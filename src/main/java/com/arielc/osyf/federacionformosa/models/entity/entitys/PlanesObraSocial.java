package com.arielc.osyf.federacionformosa.models.entity.entitys;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Planes_de_obra_social")
public class PlanesObraSocial {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int porcentaje;
    @ManyToOne
    @JoinColumn(name = "obras_sociales_id")
    private ObraSocial obraSocial;

    public Long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public ObraSocial getObraSocial() {
        return obraSocial;
    }
    public void setObraSocial(ObraSocial obraSocial) {
        this.obraSocial = obraSocial;
    }
    public int getPorcentaje() {
        return porcentaje;
    }
    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    } 
}
