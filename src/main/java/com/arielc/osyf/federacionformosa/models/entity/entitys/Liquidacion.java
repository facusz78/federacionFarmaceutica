package com.arielc.osyf.federacionformosa.models.entity.entitys;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Liquidaciones")
public class Liquidacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha_cierre;
    private LocalDate fecha_inicio;
    private BigDecimal total_bruto;
    private BigDecimal total_deba;
    private BigDecimal total_debm;
    private BigDecimal total_neto;
    @ManyToMany
    private List<TipoLiquidacion> tipos_de_liquidacion;
    
    public Long getId() {
        return id;
    }
    public LocalDate getFecha_cierre() {
        return fecha_cierre;
    }
    public void setFecha_cierre(LocalDate fecha_cierre) {
        this.fecha_cierre = fecha_cierre;
    }
    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }
    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }
    public BigDecimal getTotal_bruto() {
        return total_bruto;
    }
    public void setTotal_bruto(BigDecimal total_bruto) {
        this.total_bruto = total_bruto;
    }
    public BigDecimal getTotal_deba() {
        return total_deba;
    }
    public void setTotal_deba(BigDecimal total_deba) {
        this.total_deba = total_deba;
    }
    public BigDecimal getTotal_debm() {
        return total_debm;
    }
    public void setTotal_debm(BigDecimal total_debm) {
        this.total_debm = total_debm;
    }
    public BigDecimal getTotal_neto() {
        return total_neto;
    }
    public void setTotal_neto(BigDecimal total_neto) {
        this.total_neto = total_neto;
    }
    public List<TipoLiquidacion> getTipos_de_liquidacion() {
        return tipos_de_liquidacion;
    }
    public void setTipos_de_liquidacion(List<TipoLiquidacion> tipos_de_liquidacion) {
        this.tipos_de_liquidacion = tipos_de_liquidacion;
    }
    
}
