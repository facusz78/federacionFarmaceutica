package com.arielc.osyf.federacionformosa.models.entity.entitys;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Resumenes")
public class Resumen {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String total_import;
    private String total_OB;
    private LocalDate carga;
    private LocalDate envio;
    @OneToMany
    private List<ObraSocial> obraSocials;
    @OneToMany
    private List<Farmacia> farmacias;
    @OneToOne
    private Liquidacion liquidacion;

    public Long getId() {
        return id;
    }
    public String getTotal_import() {
        return total_import;
    }
    public void setTotal_import(String total_import) {
        this.total_import = total_import;
    }
    public String getTotal_OB() {
        return total_OB;
    }
    public void setTotal_OB(String total_OB) {
        this.total_OB = total_OB;
    }
    public LocalDate getCarga() {
        return carga;
    }
    public void setCarga(LocalDate carga) {
        this.carga = carga;
    }
    public LocalDate getEnvio() {
        return envio;
    }
    public void setEnvio(LocalDate envio) {
        this.envio = envio;
    }
    public List<ObraSocial> getObraSocials() {
        return obraSocials;
    }
    public void setObraSocials(List<ObraSocial> obraSocials) {
        this.obraSocials = obraSocials;
    }
    public List<Farmacia> getFarmacias() {
        return farmacias;
    }
    public void setFarmacias(List<Farmacia> farmacias) {
        this.farmacias = farmacias;
    }
    public Liquidacion getLiquidacion() {
        return liquidacion;
    }
    public void setLiquidacion(Liquidacion liquidacion) {
        this.liquidacion = liquidacion;
    }
}
