package com.arielc.osyf.federacionformosa.models.entity.entitys;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "XXXXDebitos_de_liquidaciones")
public class DebitoLiquidaciones {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descuento;
    private BigDecimal importe_descuento;
    private BigDecimal importe;
    private int manual;
    private Long nota_recup;
    private int porcentaje;
    private int porcentaje_descuento;
    
    public Long getId() {
        return id;
    }
    public String getDescuento() {
        return descuento;
    }
    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }
    public BigDecimal getImporte_descuento() {
        return importe_descuento;
    }
    public void setImporte_descuento(BigDecimal importe_descuento) {
        this.importe_descuento = importe_descuento;
    }
    public BigDecimal getImporte() {
        return importe;
    }
    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }
    public int getManual() {
        return manual;
    }
    public void setManual(int manual) {
        this.manual = manual;
    }
    public Long getNota_recup() {
        return nota_recup;
    }
    public void setNota_recup(Long nota_recup) {
        this.nota_recup = nota_recup;
    }
    public int getPorcentaje() {
        return porcentaje;
    }
    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
    public int getPorcentaje_descuento() {
        return porcentaje_descuento;
    }
    public void setPorcentaje_descuento(int porcentaje_descuento) {
        this.porcentaje_descuento = porcentaje_descuento;
    }
}
