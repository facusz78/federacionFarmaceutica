package com.arielc.osyf.federacionformosa.models.entity.entitys;

import com.arielc.osyf.federacionformosa.models.entity.enums.CuotaSocial;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="Farmaceuticos")
public class Farmaceuticos {
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String nombre;
   private String apellido;
   private Long dni;
   private Long matricula;
   private String direccion;
   private String provincia;
   private String localidad;
   private int cp;
   private String email;
   private Long telefono;
   private CuotaSocial status;
   @ManyToOne
   private Farmacia farmacia;

    public Long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public Long getDni() {
        return dni;
    }
    public void setDni(Long dni) {
        this.dni = dni;
    }
    public Long getMatricula() {
        return matricula;
    }
    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getProvincia() {
        return provincia;
    }
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    public String getLocalidad() {
        return localidad;
    }
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
    public int getCp() {
        return cp;
    }
    public void setCp(int cp) {
        this.cp = cp;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Long getTelefono() {
        return telefono;
    }
    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }
    public CuotaSocial getStatus() {
        return status;
    }
    public void setStatus(CuotaSocial status) {
        this.status = status;
    }
    public Farmacia getFarmacia() {
        return farmacia;
    }
    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    }   
}
