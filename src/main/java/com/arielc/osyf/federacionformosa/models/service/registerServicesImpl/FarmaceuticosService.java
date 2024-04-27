package com.arielc.osyf.federacionformosa.models.service.registerServicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.arielc.osyf.federacionformosa.models.dao.IRegistersDao.IFarmaceuticosDao;
import com.arielc.osyf.federacionformosa.models.entity.entitys.Farmaceuticos;

@Service
public class FarmaceuticosService {
    
    private final IFarmaceuticosDao farmaceuticosDao;

    public FarmaceuticosService(IFarmaceuticosDao farmaceuticosDao) {
        this.farmaceuticosDao = farmaceuticosDao;
    }

    public List<Farmaceuticos> getAll() {
        return (List<Farmaceuticos>) farmaceuticosDao.findAll();
    }

    @SuppressWarnings("null")
    public Farmaceuticos save(Farmaceuticos farmaceutico){
        return (Farmaceuticos) farmaceuticosDao.save(farmaceutico);
    }

    public Farmaceuticos update(Long id, Farmaceuticos farmaceutico){

        Optional<Farmaceuticos> farmaceuticoEdit = farmaceuticosDao.findById(id);
        if(farmaceuticoEdit.isPresent()){
            Farmaceuticos farmaceuticoUpdate = farmaceuticoEdit.get();
            farmaceuticoUpdate.setNombre(farmaceutico.getNombre());
            farmaceuticoUpdate.setApellido(farmaceutico.getApellido());
            farmaceuticoUpdate.setDni(farmaceutico.getDni());
            farmaceuticoUpdate.setMatricula(farmaceutico.getMatricula());
            farmaceuticoUpdate.setDireccion(farmaceutico.getDireccion());
            farmaceuticoUpdate.setProvincia(farmaceutico.getProvincia());
            farmaceuticoUpdate.setLocalidad(farmaceutico.getLocalidad());
            farmaceuticoUpdate.setCp(farmaceutico.getCp());
            farmaceuticoUpdate.setEmail(farmaceutico.getEmail());
            farmaceuticoUpdate.setTelefono(farmaceutico.getTelefono());
            farmaceuticoUpdate.setStatus(farmaceutico.getStatus());
           return farmaceuticosDao.save(farmaceuticoUpdate);
        } else {
            throw new RuntimeException("Error al editar la Farmaceutico");
        }  
    }

    public void delete(Long id){
        Optional<Farmaceuticos> deleteFarm = farmaceuticosDao.findById(id);
        if(deleteFarm.isPresent()){
            farmaceuticosDao.delete(deleteFarm.get());
        } else {
            throw new RuntimeException("Farmaceutico  no encontrada");
        }
    }

}
