package com.arielc.osyf.federacionformosa.models.service.registerServicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.arielc.osyf.federacionformosa.models.dao.IRegistersDao.IDebitosLiquidacionesDao;
import com.arielc.osyf.federacionformosa.models.entity.entitys.DebitoLiquidaciones;


@Service
public class DebitosLiquidacionesService {
    
    private final IDebitosLiquidacionesDao debitosLiquidacionesDao;

    public DebitosLiquidacionesService(IDebitosLiquidacionesDao debitosLiquidacionesDao) {
        this.debitosLiquidacionesDao = debitosLiquidacionesDao;
    }

      public List<DebitoLiquidaciones> getAll() {
        return (List<DebitoLiquidaciones>) debitosLiquidacionesDao.findAll();
    }
    
    @SuppressWarnings("null")
    public DebitoLiquidaciones save(DebitoLiquidaciones debito){
        return (DebitoLiquidaciones) debitosLiquidacionesDao.save(debito);
    }
     
}
