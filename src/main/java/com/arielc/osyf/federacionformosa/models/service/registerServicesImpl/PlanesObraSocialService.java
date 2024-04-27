package com.arielc.osyf.federacionformosa.models.service.registerServicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.arielc.osyf.federacionformosa.models.dao.IRegistersDao.IPlanesObraSocialDao;
import com.arielc.osyf.federacionformosa.models.entity.entitys.PlanesObraSocial;

@Service
public class PlanesObraSocialService {
    
    private final IPlanesObraSocialDao planesObraSocialDao;

    public PlanesObraSocialService(IPlanesObraSocialDao planesObraSocialDao) {
        this.planesObraSocialDao = planesObraSocialDao;
    }

    public List<PlanesObraSocial> getAll() {
    return (List<PlanesObraSocial>) planesObraSocialDao.findAll();
    }
    
    @SuppressWarnings("null")
    public PlanesObraSocial save(PlanesObraSocial plan){
        return (PlanesObraSocial) planesObraSocialDao.save(plan);
    }

    public Optional<PlanesObraSocial> findById(Long id){
        return planesObraSocialDao.findById(id);
    } 

    public void delete(Long id){
        Optional<PlanesObraSocial> planDelete = planesObraSocialDao.findById(id);
        if(planDelete.isPresent()){
            planesObraSocialDao.delete(planDelete.get());
        } else {
            throw new RuntimeException("Sucursal no encontrada");
        }
    }   
}
