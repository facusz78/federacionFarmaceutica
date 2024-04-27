package com.arielc.osyf.federacionformosa.models.service.registerServicesImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.arielc.osyf.federacionformosa.models.dao.IRegistersDao.ISucursalFarmaciaDao;
import com.arielc.osyf.federacionformosa.models.entity.entitys.SucursalFarmacias;

@Service
public class SucursalesFarmaciaService {
    
    private final ISucursalFarmaciaDao sucursalFarmaciaDao;

    public SucursalesFarmaciaService(ISucursalFarmaciaDao sucursalFarmaciaDao) {
        this.sucursalFarmaciaDao = sucursalFarmaciaDao;
    }

    public List<SucursalFarmacias> getAll() {
        return (List<SucursalFarmacias>) sucursalFarmaciaDao.findAll();
    }
    
    @SuppressWarnings("null")
    public SucursalFarmacias save(SucursalFarmacias sucursal){
        return (SucursalFarmacias) sucursalFarmaciaDao.save(sucursal);
    }
}
