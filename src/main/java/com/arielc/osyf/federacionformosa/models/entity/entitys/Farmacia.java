package com.arielc.osyf.federacionformosa.models.entity.entitys;

import java.math.BigDecimal;
import java.util.List;

import com.arielc.osyf.federacionformosa.models.entity.enums.Iva;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="Farmacia")
public class Farmacia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String codigo_pami;
    private Long cuit;
    private Iva pos_iva;
    private BigDecimal ingresos_brutos;
    @OneToMany
    @JoinColumn()
    private List<SucursalFarmacias> sucursales;

    @OneToMany
    @JoinColumn()
    private List<Farmaceuticos> farmaceuticos;
    
    public Long getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCodigo_pami() {
        return codigo_pami;
    }
    public void setCodigo_pami(String codigo_pami) {
        this.codigo_pami = codigo_pami;
    }
    public Long getCuit() {
        return cuit;
    }
    public void setCuit(Long cuit) {
        this.cuit = cuit;
    }
    public BigDecimal getIngresos_brutos() {
        return ingresos_brutos;
    }
    public void setIngresos_brutos(BigDecimal ingresos_brutos) {
        this.ingresos_brutos = ingresos_brutos;
    }
    public List<SucursalFarmacias> getSucursales() {
        return sucursales;
    }
    public void setSucursales(List<SucursalFarmacias> sucursales) {
        this.sucursales = sucursales;
    }
    public Iva getPos_iva() {
        return pos_iva;
    }
    public void setPos_iva(Iva pos_iva) {
        this.pos_iva = pos_iva;
    }
    public List<Farmaceuticos> getFarmaceuticos() {
        return farmaceuticos;
    }
    public void setFarmaceuticos(List<Farmaceuticos> farmaceuticos) {
        this.farmaceuticos = farmaceuticos;
    } 
}
