package com.arielc.osyf.federacionformosa.models.entity.entitys;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tipos_de_liquidacion")
public class TipoLiquidacion {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private String descripcion;
    @OneToMany
    @JoinColumn()
    private List<TipoDebitos> tipoDebitos;
    
    @ManyToMany(mappedBy = "tipos_de_liquidacion")
    private List<Liquidacion> liquidaciones;

    public Long getId() {
        return id;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public List<TipoDebitos> getTipoDebitos() {
        return tipoDebitos;
    }
    public void setTipoDebitos(List<TipoDebitos> tipoDebitos) {
        this.tipoDebitos = tipoDebitos;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}