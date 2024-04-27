package com.arielc.osyf.federacionformosa.models.service.registerServicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.arielc.osyf.federacionformosa.models.dao.IRegistersDao.ILiquidacionDao;
import com.arielc.osyf.federacionformosa.models.entity.entitys.Liquidacion;

@Service
public class LiquidacionService {
    
    private final ILiquidacionDao liquidacionDao;

    public LiquidacionService(ILiquidacionDao liquidacionDao) {
        this.liquidacionDao = liquidacionDao;
    }

    public List<Liquidacion> getAll() {
        return (List<Liquidacion>) liquidacionDao.findAll();
    }
    
    @SuppressWarnings("null")
    public Liquidacion save(Liquidacion liquidacion){
        return (Liquidacion) liquidacionDao.save(liquidacion);
    }

}
