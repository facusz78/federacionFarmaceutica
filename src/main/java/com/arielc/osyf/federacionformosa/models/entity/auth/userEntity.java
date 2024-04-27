package com.arielc.osyf.federacionformosa.models.entity.auth;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.arielc.osyf.federacionformosa.models.entity.enums.Sexo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "Usuarios")
public class userEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El campo username es obligatorio")
    @NotNull
    @NotEmpty
    private String userName;
    @NotBlank(message = "El campo apeliido es obligatorio")
    @NotNull
    @NotEmpty
    private String apellido;
    private Sexo sexo;
    @NotBlank(message = "El campo Email es obligatorio")
    @NotNull
    @Email
    @NotEmpty
    private String correo;
    @NotBlank(message = "El campo password es obligatorio")
    @NotNull
    @NotEmpty
    private String password;
    private String token; 
    private Rol rol;
    private Long telefono;
    private LocalDate nacimiento;
    
    public LocalDate getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPasswordEncoded(PasswordEncoder passwordEncoder, String plainPassword) {
        this.password = passwordEncoder.encode(plainPassword);
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }
    
}
