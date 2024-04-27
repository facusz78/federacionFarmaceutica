package com.arielc.osyf.federacionformosa.models.service.registerServicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.arielc.osyf.federacionformosa.models.dao.IRegistersDao.ITipoDebitosDao;
import com.arielc.osyf.federacionformosa.models.entity.entitys.TipoDebitos;

@Service
public class TipoDebitosService {
    
    private final ITipoDebitosDao tipoDebitosDao;

    public TipoDebitosService(ITipoDebitosDao tipoDebitosDao) {
        this.tipoDebitosDao = tipoDebitosDao;
    }

    public List<TipoDebitos> getAll() {
        return (List<TipoDebitos>) tipoDebitosDao.findAll();
    }
    
    @SuppressWarnings("null")
    public TipoDebitos save(TipoDebitos sucursal){
        return (TipoDebitos) tipoDebitosDao.save(sucursal);
    }
    
    public Optional<TipoDebitos> findById(Long id){
        return tipoDebitosDao.findById(id);
    } 

    public void delete(Long id){
    Optional<TipoDebitos> officeDelete = tipoDebitosDao.findById(id);
      if(officeDelete.isPresent()){
            tipoDebitosDao.delete(officeDelete.get());
       }else {
            throw new RuntimeException("Debito no encontrada");
     }
    }
}
