package com.arielc.osyf.federacionformosa.models.entity.entitys;

import java.time.LocalDate;

import com.arielc.osyf.federacionformosa.models.entity.enums.Iva;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Federacion")
public class Federation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String direccion;
    private Long telefono;
    private Long agente_retencion;
    private String provincia;
    private String localidad;
    private LocalDate inicio_Actividad;
    private Long convenio;
    private String web;
    private Long cuit;
    private Long cp;
    private Long DGRP;
    private Iva pos_iva;
    private String email;

    public Long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public Long getTelefono() {
        return telefono;
    }
    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }
    public Long getAgente_retencion() {
        return agente_retencion;
    }
    public void setAgente_retencion(Long agente_retencion) {
        this.agente_retencion = agente_retencion;
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
    public void setInicio_Actividad(LocalDate inicio_Actividad) {
        this.inicio_Actividad = inicio_Actividad;
    }
    public Long getConvenio() {
        return convenio;
    }
    public void setConvenio(Long convenio) {
        this.convenio = convenio;
    }
    public String getWeb() {
        return web;
    }
    public void setWeb(String web) {
        this.web = web;
    }
    public Long getCuit() {
        return cuit;
    }
    public void setCuit(Long cuit) {
        this.cuit = cuit;
    }
    public Long getCp() {
        return cp;
    }
    public void setCp(Long cp) {
        this.cp = cp;
    }
    public Long getDGRP() {
        return DGRP;
    }
    public void setDGRP(Long dGRP) {
        DGRP = dGRP;
    }
    public LocalDate getInicio_Actividad() {
        return inicio_Actividad;
    }
    public Iva getPos_iva() {
        return pos_iva;
    }
    public void setPos_iva(Iva pos_iva) {
        this.pos_iva = pos_iva;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
      
}
