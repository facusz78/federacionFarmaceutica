package com.arielc.osyf.federacionformosa.models.entity.entitys;

import java.math.BigDecimal;

import com.arielc.osyf.federacionformosa.models.entity.enums.Iva;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Tipos_de_debitos")
public class TipoDebitos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private BigDecimal descuento;
    private BigDecimal importe_a_superar;
    private BigDecimal maximo;
    private BigDecimal minimo;
    private BigDecimal monto_fijo;
    private BigDecimal porcentaje;
    private Long porcentaje_descuento;
    private Iva posIVA;
    @ManyToOne
    @JoinColumn(name = "tipo_liquidacion_id")
    private TipoLiquidacion tipoLiquidacion;
    public Long getId() {
        return id;
    }
    public BigDecimal getDescuento() {
        return descuento;
    }
    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }
    public BigDecimal getImporte_a_superar() {
        return importe_a_superar;
    }
    public void setImporte_a_superar(BigDecimal importe_a_superar) {
        this.importe_a_superar = importe_a_superar;
    }
    public BigDecimal getMaximo() {
        return maximo;
    }
    public void setMaximo(BigDecimal maximo) {
        this.maximo = maximo;
    }
    public BigDecimal getMinimo() {
        return minimo;
    }
    public void setMinimo(BigDecimal minimo) {
        this.minimo = minimo;
    }
    public BigDecimal getMonto_fijo() {
        return monto_fijo;
    }
    public void setMonto_fijo(BigDecimal monto_fijo) {
        this.monto_fijo = monto_fijo;
    }
    public BigDecimal getPorcentaje() {
        return porcentaje;
    }
    public void setPorcentaje(BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }
    public Long getPorcentaje_descuento() {
        return porcentaje_descuento;
    }
    public void setPorcentaje_descuento(Long porcentaje_descuento) {
        this.porcentaje_descuento = porcentaje_descuento;
    }
    public TipoLiquidacion getTipoLiquidacion() {
        return tipoLiquidacion;
    }
    public void setTipoLiquidacion(TipoLiquidacion tipoLiquidacion) {
        this.tipoLiquidacion = tipoLiquidacion;
    }
    public Iva getPosIVA() {
        return posIVA;
    }
    public void setPosIVA(Iva posIVA) {
        this.posIVA = posIVA;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
     
}
