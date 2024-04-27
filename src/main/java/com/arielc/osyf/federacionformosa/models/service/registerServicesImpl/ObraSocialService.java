package com.arielc.osyf.federacionformosa.models.service.registerServicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.arielc.osyf.federacionformosa.models.dao.IRegistersDao.IObraSocialDao;
import com.arielc.osyf.federacionformosa.models.entity.entitys.ObraSocial;
import com.arielc.osyf.federacionformosa.models.entity.entitys.PlanesObraSocial;

@Service
public class ObraSocialService {
    
    private final IObraSocialDao socialDao;
    private final PlanesObraSocialService planesObraSocialService;
    
    public ObraSocialService(IObraSocialDao socialDao, PlanesObraSocialService planesObraSocialService) {
        this.socialDao = socialDao;
        this.planesObraSocialService = planesObraSocialService;
    }
    public List<ObraSocial> getAll() {
        return (List<ObraSocial>) socialDao.findAll();
    }
    
    @SuppressWarnings("null")
    public ObraSocial save(ObraSocial obraSOcial){
        return (ObraSocial) socialDao.save(obraSOcial);
    }

   public void delete(Long id){
        Optional<ObraSocial> deleteSocialWork = socialDao.findById(id);
        if(deleteSocialWork.isPresent()){
            socialDao.delete(deleteSocialWork.get());
        } else {
            throw new RuntimeException("Farmacia no encontrada");
        }
    }

    public ObraSocial update(Long id, ObraSocial socialWork){

        Optional<ObraSocial> socialWorkEdit = socialDao.findById(id);
        if(socialWorkEdit.isPresent()){
            ObraSocial socialWorkUpdate = socialWorkEdit.get();
            socialWorkUpdate.setNombre(socialWork.getNombre());
            socialWorkUpdate.setDireccion(socialWork.getDireccion());
            socialWorkUpdate.setSigla(socialWork.getSigla());
            socialWorkUpdate.setEmail(socialWork.getEmail());
            socialWorkUpdate.setTelefono(socialWork.getTelefono());
            socialWorkUpdate.setWeb(socialWork.getWeb());
            socialWorkUpdate.setProvincia(socialWork.getProvincia());
            socialWorkUpdate.setLocalidad(socialWork.getLocalidad());
           return socialDao.save(socialWorkUpdate);
        } else {
            throw new RuntimeException("Error al editar la Farmacia");
        }  
    }

    public ObraSocial savePlan(Long id, PlanesObraSocial plan) {
        Optional<ObraSocial> obraSocial = socialDao.findById(id);
        if (obraSocial.isPresent()) {
            try {
                PlanesObraSocial savedPlan = planesObraSocialService.save(plan);
                if (savedPlan != null) {
                    obraSocial.get().getPlanes().add(savedPlan);
                    socialDao.save(obraSocial.get());
                }
            } catch (Exception e) {
                System.out.println("Error al guardar la Plan: " + e.getMessage());
            }
        } else {
            throw new RuntimeException("Obra social no encontrada");
        }
        return obraSocial.get();
    }

    public PlanesObraSocial updatePlan(Long Id, PlanesObraSocial plan){
        Optional<PlanesObraSocial> sucursalEdit = planesObraSocialService.findById(Id);
        if(sucursalEdit.isPresent()){
            PlanesObraSocial planUpdate = sucursalEdit.get();
             planUpdate.setNombre(plan.getNombre());
             planUpdate.setPorcentaje(plan.getPorcentaje());
            return planesObraSocialService.save(planUpdate);
        } else {
            throw new RuntimeException("Error al editar la Plan");
        }
    }
    
    public void deletePlan(Long id) {
        planesObraSocialService.delete(id);
    }
}
