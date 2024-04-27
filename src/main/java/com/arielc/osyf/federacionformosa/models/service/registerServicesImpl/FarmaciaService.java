package com.arielc.osyf.federacionformosa.models.service.registerServicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.arielc.osyf.federacionformosa.models.dao.IRegistersDao.IFarmaciaDao;
import com.arielc.osyf.federacionformosa.models.entity.entitys.Farmacia;
import com.arielc.osyf.federacionformosa.models.entity.entitys.SucursalFarmacias;

@Service
public class FarmaciaService {
    
    private final IFarmaciaDao farmaciaDao;
    private final SucursalFarmaciasService sucursalService;

    public FarmaciaService(IFarmaciaDao farmaciaDao, SucursalFarmaciasService sucursalService) {
        this.farmaciaDao = farmaciaDao;
        this.sucursalService = sucursalService;
    }
   
    public List<Farmacia> getAll() {
        return (List<Farmacia>) farmaciaDao.findAll();
    }
    
    @SuppressWarnings("null")
    public Farmacia save(Farmacia farmacia){
        return (Farmacia) farmaciaDao.save(farmacia);
    }
    
    public Farmacia update(Long id, Farmacia farmacia){

        Optional<Farmacia> farmaciaEdit = farmaciaDao.findById(id);
        if(farmaciaEdit.isPresent()){
            Farmacia farmaciaToUpdate = farmaciaEdit.get();
            farmaciaToUpdate.setNombre(farmacia.getNombre());
            farmaciaToUpdate.setCuit(farmacia.getCuit());
            farmaciaToUpdate.setIngresos_brutos(farmacia.getIngresos_brutos());
            farmaciaToUpdate.setPos_iva(farmacia.getPos_iva());
           return farmaciaDao.save(farmaciaToUpdate);
        } else {
            throw new RuntimeException("Error al editar la Farmacia");
        }
      
    }

    public void delete(Long id){
        Optional<Farmacia> deleteFarm = farmaciaDao.findById(id);
        if(deleteFarm.isPresent()){
            farmaciaDao.delete(deleteFarm.get());
        } else {
            throw new RuntimeException("Farmacia no encontrada");
        }
    }

    public Farmacia saveOffice(Long id, SucursalFarmacias sucursal) {
        Optional<Farmacia> farmacia = farmaciaDao.findById(id);
        if (farmacia.isPresent()) {
            try {
                SucursalFarmacias savedSucursal = sucursalService.save(sucursal);
                if (savedSucursal != null) {
                    farmacia.get().getSucursales().add(savedSucursal);
                    farmaciaDao.save(farmacia.get());
                }
            } catch (Exception e) {
                System.out.println("Error al guardar la sucursal: " + e.getMessage());
            }
        } else {
            throw new RuntimeException("Farmacia no encontrada");
        }
        return farmacia.get();
    }
     
    public SucursalFarmacias updateOffice(Long Id, SucursalFarmacias sucursal){
        Optional<SucursalFarmacias> sucursalEdit = sucursalService.findById(Id);
        if(sucursalEdit.isPresent()){
            SucursalFarmacias sucursalUpdate = sucursalEdit.get();
            sucursalUpdate.setDireccion(sucursal.getDireccion());
            sucursalUpdate.setEmail(sucursal.getEmail());
            sucursalUpdate.setLocalidad(sucursal.getLocalidad());
            sucursalUpdate.setProvincia(sucursal.getProvincia());
            sucursalUpdate.setTelefono(sucursal.getTelefono());
            sucursalUpdate.setNombre(sucursal.getNombre());
            return sucursalService.save(sucursalUpdate);
        } else {
            throw new RuntimeException("Error al editar la Farmacia");
        }
    }
    
    public void deleteOffice(Long id) {
        sucursalService.delete(id);
    }
}
