package com.arielc.osyf.federacionformosa.models.service.registerServicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.arielc.osyf.federacionformosa.models.dao.IRegistersDao.ISucursalFarmaciaDao;
import com.arielc.osyf.federacionformosa.models.entity.entitys.SucursalFarmacias;

@Service
public class SucursalFarmaciasService {
    
    private final ISucursalFarmaciaDao sucursalesDao;

    public SucursalFarmaciasService(ISucursalFarmaciaDao sucursalesDao) {
        this.sucursalesDao = sucursalesDao;
    }
   
    public List<SucursalFarmacias> getAll() {
        return (List<SucursalFarmacias>) sucursalesDao.findAll();
    }
    
    @SuppressWarnings("null")
    public SucursalFarmacias save(SucursalFarmacias sucursal){
        return (SucursalFarmacias) sucursalesDao.save(sucursal);
    }

    public Optional<SucursalFarmacias> findById(Long id){
        return sucursalesDao.findById(id);
    } 

    public void delete(Long id){
        Optional<SucursalFarmacias> officeDelete = sucursalesDao.findById(id);
        if(officeDelete.isPresent()){
            sucursalesDao.delete(officeDelete.get());
        } else {
            throw new RuntimeException("Sucursal no encontrada");
        }
    }   
}
