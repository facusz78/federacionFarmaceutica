package com.arielc.osyf.federacionformosa.models.service.registerServicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.arielc.osyf.federacionformosa.models.dao.IRegistersDao.ITipoLiquidacionDao;
import com.arielc.osyf.federacionformosa.models.entity.entitys.TipoDebitos;
import com.arielc.osyf.federacionformosa.models.entity.entitys.TipoLiquidacion;

@Service
public class TipoLiquidacionService {

    private final ITipoLiquidacionDao liquDao;
    private final TipoDebitosService debitosService;

    public TipoLiquidacionService(ITipoLiquidacionDao liquDao, TipoDebitosService debitosService) {
        this.liquDao = liquDao;
        this.debitosService = debitosService;
    }

    public List<TipoLiquidacion> getAll() {
        return (List<TipoLiquidacion>) liquDao.findAll();
    }
    
    @SuppressWarnings("null")
    public TipoLiquidacion save(TipoLiquidacion liquidacion){
        return (TipoLiquidacion) liquDao.save(liquidacion);
    }

    public TipoLiquidacion update(Long id, TipoLiquidacion tipo){

        Optional<TipoLiquidacion> tipoLiq = liquDao.findById(id);
        if(tipoLiq.isPresent()){
            TipoLiquidacion tipoLiqUpdate = tipoLiq.get();
            tipoLiqUpdate.setTipo(tipo.getTipo());
            tipoLiqUpdate.setDescripcion(tipo.getDescripcion());
           return liquDao.save(tipoLiqUpdate);
        } else {
            throw new RuntimeException("Error al editar la Tipo de liquidacion");
        }  
    }

    public void delete(Long id){
        Optional<TipoLiquidacion> deleteLiqui = liquDao.findById(id);
        if(deleteLiqui.isPresent()){
            liquDao.delete(deleteLiqui.get());
        } else {
            throw new RuntimeException("Tipo de liquidacion no encontrada");
        }
    }

    public TipoLiquidacion saveTipoDebito(Long id, TipoDebitos debito){
         Optional<TipoLiquidacion> liquidacion = liquDao.findById(id);
         if (liquidacion.isPresent()) {
            try {
                TipoDebitos savedDebito = debitosService.save(debito);
                if (savedDebito != null) {
                    liquidacion.get().getTipoDebitos().add(savedDebito);
                   return liquDao.save(liquidacion.get());
                }
            } catch (Exception e) {
                e.getMessage();
            }
        } else {
             throw new RuntimeException("Liquidacion no encontrada");
        }
       return null;
    }
   
    public TipoDebitos updateDebit(Long Id, TipoDebitos debito){
        Optional<TipoDebitos> debitoEdit = debitosService.findById(Id);
        if(debitoEdit.isPresent()){
            TipoDebitos debitoUpdate = debitoEdit.get();
            debitoUpdate.setDescripcion(debito.getDescripcion());
            debitoUpdate.setImporte_a_superar(debito.getImporte_a_superar());
            debitoUpdate.setPorcentaje(debito.getPorcentaje());
            debitoUpdate.setPosIVA(debito.getPosIVA());
            debitoUpdate.setMonto_fijo(debito.getMonto_fijo());
            return debitosService.save(debitoUpdate);
        } else {
            throw new RuntimeException("Error al editar Debito");
        }
    }
    
    public void deleteTypeDebito(Long id){
          debitosService.delete(id);
    }
}
