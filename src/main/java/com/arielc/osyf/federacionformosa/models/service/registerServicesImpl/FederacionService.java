package com.arielc.osyf.federacionformosa.models.service.registerServicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.arielc.osyf.federacionformosa.models.dao.IRegistersDao.IFederacionDao;
import com.arielc.osyf.federacionformosa.models.entity.entitys.Federation;

@Service
public class FederacionService {
    
    private final IFederacionDao federacionDao;

    public FederacionService(IFederacionDao federacionDao) {
        this.federacionDao = federacionDao;
    }
    
    public List<Federation> getAll() {
        return (List<Federation>) federacionDao.findAll();
    }

    @SuppressWarnings("null")
    public Federation saveUpdate(Federation federacion){

        if(federacion.getId() == null) {
            return federacionDao.save(federacion);
        }
    
        Optional<Federation> farmaciaEdit = federacionDao.findById(federacion.getId());
        if(farmaciaEdit.isPresent()){
            Federation farmaciaToUpdate = farmaciaEdit.get();
            farmaciaToUpdate.setNombre(federacion.getNombre());
            farmaciaToUpdate.setCuit(federacion.getCuit());
            farmaciaToUpdate.setAgente_retencion(federacion.getAgente_retencion());
            farmaciaToUpdate.setConvenio(federacion.getConvenio());
            farmaciaToUpdate.setCp(federacion.getCp());
            farmaciaToUpdate.setDGRP(federacion.getDGRP());
            farmaciaToUpdate.setProvincia(federacion.getProvincia());
            farmaciaToUpdate.setLocalidad(federacion.getLocalidad());
            farmaciaToUpdate.setTelefono(federacion.getTelefono());
            farmaciaToUpdate.setWeb(federacion.getWeb());
            farmaciaToUpdate.setPos_iva(federacion.getPos_iva());
            farmaciaToUpdate.setInicio_Actividad(federacion.getInicio_Actividad());
            farmaciaToUpdate.setDireccion(federacion.getDireccion());
            farmaciaToUpdate.setEmail(federacion.getEmail());
           return federacionDao.save(farmaciaToUpdate);
        } else {
            return null;
        }
      
    }

    public Optional<Federation> findById(Long id){
       return federacionDao.findById(id);
    }
}
