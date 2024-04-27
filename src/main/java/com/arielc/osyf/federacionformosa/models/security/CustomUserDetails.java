package com.arielc.osyf.federacionformosa.models.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.time.LocalDate;
import java.util.Collection;


public class CustomUserDetails extends User {
    private Long uid;
    private String name;
    private String apellido;
    private String sexo;
    private String rol;
    private LocalDate nacimiento;
    // constructor, getters y setters...

 
    public CustomUserDetails(String username, String password, 
                         boolean enabled, boolean accountNonExpired, 
                         boolean credentialsNonExpired, boolean accountNonLocked, 
                         Collection<? extends GrantedAuthority> authorities, Long uid, String name, String apellido,String sexo, String rol, LocalDate nacimiento) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.uid = uid;
        this.name = name;
        this.apellido = apellido;
        this.sexo = sexo;
        this.rol = rol;
        this.nacimiento = nacimiento;
    }

    public Long getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public String getSexo() {
        return sexo;
    }

    public String getRol() {
        return rol;
    }

    public String getApellido() {
        return apellido;
    }

    public LocalDate getNacimiento() {
        return nacimiento;
    }

}
