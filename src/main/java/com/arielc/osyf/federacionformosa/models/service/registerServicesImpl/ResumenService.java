package com.arielc.osyf.federacionformosa.models.service.registerServicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.arielc.osyf.federacionformosa.models.dao.IRegistersDao.IResumenDao;
import com.arielc.osyf.federacionformosa.models.entity.entitys.Resumen;

@Service
public class ResumenService {
    
    private final IResumenDao resumenDao;

    public ResumenService(IResumenDao resumenDao) {
        this.resumenDao = resumenDao;
    }

       public List<Resumen> getAll() {
        return (List<Resumen>) resumenDao.findAll();
    }
    
    @SuppressWarnings("null")
    public Resumen save(Resumen resumen){
        return (Resumen) resumenDao.save(resumen);
    }
 
}
