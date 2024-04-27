package com.arielc.osyf.federacionformosa.controllers.auth;

import org.springframework.web.bind.annotation.RestController;

import com.arielc.osyf.federacionformosa.models.entity.auth.userEntity;
import com.arielc.osyf.federacionformosa.models.security.jwt;
import com.arielc.osyf.federacionformosa.models.service.userServicesImpl.IUserService;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@Validated
@CrossOrigin(origins = {"http://localhost:5173" })
@RestController
@RequestMapping("/auth")
public class AuthRestController {
    
      @Autowired
    private IUserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private jwt jwtInstance;
    
    @GetMapping("/usuarios")
    public List<userEntity> getAllUsuarios() {
        return userService.findAll();
    }
    
    @GetMapping("/renew")
    public ResponseEntity<Object> renewToken(@RequestHeader("x-token") String token) {
        
        String email = jwtInstance.extractUsername(token);
    
        if (jwtInstance.validateToken(token, email)) {
           
            userEntity existingUser = userService.findByCorreo(email);
    
            if (existingUser != null) {
                 existingUser.setToken(jwtInstance.generateTokenRenew(existingUser));
                 return ResponseEntity.ok(existingUser);
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Token inválido o usuario no encontrado");
    }
      
    @PostMapping("/register")
    public ResponseEntity<Object> create(@RequestBody userEntity newUser) {
         
          //Verifico que todos los datos existan
            if (newUser.getCorreo().isEmpty() || newUser.getCorreo().isBlank() || !newUser.getCorreo().contains("@") || !Objects.nonNull(newUser.getCorreo())
                || newUser.getPassword().isEmpty() || newUser.getPassword().isBlank() || !Objects.nonNull(newUser.getPassword())
                ||newUser.getUserName().isEmpty() || newUser.getUserName().isBlank() || !Objects.nonNull(newUser.getUserName())) {  
            
               return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("campos vacios o nulos");
            } 

        // Verificar si ya existe un usuario con el mismo correo
        if (userService.existsByCorreo(newUser.getCorreo())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("El correo ya está registrado. Por favor, use otro correo.");
          }
        
        // Si no existe, guardar el nuevo usuario
        userEntity savedUser = userService.save(newUser);
        
        if (savedUser != null) {

                //Generar y Almacena el token en el objeto User
                savedUser.setToken(jwtInstance.generateTokenRenew(savedUser));

            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Hubo un error al registrar el usuario.");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody userEntity loginUser) {

        userEntity existingUser = userService.findByCorreo(loginUser.getCorreo());
     
        if (existingUser == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Credenciales inválidas. Usuario incorrecto");
        }
        if (passwordEncoder.matches(loginUser.getPassword(), existingUser.getPassword())) {
    
            existingUser.setToken(jwtInstance.generateTokenRenew(existingUser));
            existingUser.setApellido(null);
            existingUser.setPasswordEncoded(passwordEncoder, loginUser.getPassword()); 
        
            return ResponseEntity.ok(existingUser);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Credenciales inválidas. Contraseña incorrecta");
        } 
    }

    @PutMapping("/userEdit")
    public ResponseEntity<Object> update(@RequestBody userEntity userEdit) {
        
        userEntity existingUser = userService.findById(userEdit.getId());
    
        if (existingUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Usuario no encontrado");
        }
    
        existingUser.setUserName(userEdit.getUserName());
        existingUser.setApellido(userEdit.getApellido());
        existingUser.setNacimiento(userEdit.getNacimiento());

    
        // Guardar el usuario actualizado en la base de datos
        userService.save(existingUser);
    
        return ResponseEntity.ok(existingUser);
    }    
    
    @PostMapping("/resetPassword")
    public ResponseEntity<?> forgotPassword(@RequestParam String email) {
        userService.forgotPassword(email);
        return ResponseEntity.ok("Se ha enviado un correo electrónico con instrucciones para restablecer tu contraseña.");
    }    
    
    @PutMapping("createNewPassword")
    public ResponseEntity<?> createNewPassword( @RequestBody userEntity usuario) {
        userEntity existingUser = userService.findByCorreo(usuario.getCorreo());
        
        if (existingUser == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Credenciales inválidas. Usuario incorrecto");
        }
         
        existingUser.setPasswordEncoded(passwordEncoder, usuario.getPassword());

        userService.save(existingUser);
        
        return ResponseEntity.ok(existingUser);
    }
}
