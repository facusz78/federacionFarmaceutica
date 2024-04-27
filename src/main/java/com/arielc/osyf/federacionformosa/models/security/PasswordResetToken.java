package com.arielc.osyf.federacionformosa.models.security;

import java.util.Date;

import com.arielc.osyf.federacionformosa.models.entity.auth.userEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import java.util.Calendar;

@Entity
public class PasswordResetToken {

    private static final int EXPIRATION = 60 * 24;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String token;

    @ManyToOne(targetEntity = userEntity.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private userEntity user;

    private Date expiryDate;

    
    public String getToken() {
        return token;
    }

    public void setExpiryDate() {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MINUTE, EXPIRATION);
        this.expiryDate = now.getTime();
    }
    
    public void setToken(String token) {
        this.token = token;
    }

    public void setUser(userEntity user) {
        this.user = user;
    }

    public void setExpiryDate(int minutes) {
        Calendar now = Calendar.getInstance();
        now.add(Calendar.MINUTE, minutes);
        this.expiryDate = now.getTime();
    }
}
