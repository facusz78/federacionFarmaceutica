package com.arielc.osyf.federacionformosa.models.security;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.arielc.osyf.federacionformosa.models.entity.auth.userEntity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


@Component
public class jwt {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;
    

    public String generateTokenRenew(userEntity subject) {
        
      byte[] keyBytes = Decoders.BASE64.decode(secret);
      Key key = Keys.hmacShaKeyFor(keyBytes);

        return Jwts.builder()
        .claim("userId", subject.getId())
        .claim("userName", subject.getUserName())
        .claim("correo", subject.getCorreo())
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + expiration))
        .signWith(key, SignatureAlgorithm.HS256)
        .compact();
    }

       public String generateTokenDetail(String username) {
        
      byte[] keyBytes = Decoders.BASE64.decode(secret);
      Key key = Keys.hmacShaKeyFor(keyBytes);

        return Jwts.builder()
        .claim("correo", username)
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + expiration))
        .signWith(key, SignatureAlgorithm.HS256)
        .compact();
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractUsername(String token) {
        Claims claims = extractAllClaims(token);
        String usernameByEmail = claims.get("correo", String.class);
        return usernameByEmail;
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public Boolean validateToken(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    } 
}