package com.arielc.osyf.federacionformosa.controllers.Api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arielc.osyf.federacionformosa.models.entity.entitys.ObraSocial;
import com.arielc.osyf.federacionformosa.models.entity.entitys.PlanesObraSocial;
import com.arielc.osyf.federacionformosa.models.service.registerServicesImpl.ObraSocialService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin(origins = {"http://localhost:5173, https://federacionfarmaceuticaformosa.netlify.app" })
@RestController
@RequestMapping("/api")
public class ObraSocialRestController {
    
    private final ObraSocialService obraSocialService;

    public ObraSocialRestController(ObraSocialService obraSocialService) {
        this.obraSocialService = obraSocialService;
    }
    
    @GetMapping("/obrasSociales")
    public List<ObraSocial> getAll(){
        return obraSocialService.getAll();
    }

    @PostMapping("/saveObraSocial")
    public ResponseEntity<Object> save(@RequestBody ObraSocial obraSocial) {
             
        try {
            obraSocialService.save(obraSocial);
            return ResponseEntity.ok("Obra social guardada");
                        
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("Error al agregar Obra social: " + e.getMessage());
        }
    }

    @PutMapping("/editSocialWork/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id , @RequestBody ObraSocial obraSocial) {
             
        try {
            obraSocialService.update( id, obraSocial);
            return ResponseEntity.ok("Obra social modificada");
                        
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("Error al modificar Obra social: " + e.getMessage());
        }
    }

   @DeleteMapping("/deleteObraSocial/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
    try {
        obraSocialService.delete(id);
        return ResponseEntity.ok("Obra social eliminada");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al eliminar la Obra social" + e.getMessage());
    }
  }

  @PostMapping("/savePlanObraSocial/{id}")
  public ResponseEntity<Object> saveOffice(@PathVariable Long id, @RequestBody PlanesObraSocial plan) {
     try {
        obraSocialService.savePlan(id, plan);
        return ResponseEntity.ok("Plan agregada");
     } catch (Exception e) {
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
       .body("Error al agregar Plan: " + e.getMessage());
     }
  }

  @PutMapping("/editPlanObraSocial/{id}")
  public ResponseEntity<Object> updateOffice(@PathVariable Long id, @RequestBody PlanesObraSocial sucursal) {
           
      try {
        obraSocialService.updatePlan(id, sucursal);
          return ResponseEntity.ok("Plan modificada");
                      
      } catch (Exception e) {
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Error al modificar Plan: " + e.getMessage());
      }
  }

  @DeleteMapping("/deletePlan/{id}")
  public ResponseEntity<Object> deletePlan(@PathVariable Long id){
  try {
    obraSocialService.deletePlan(id);
      return ResponseEntity.ok("Sucursal eliminada");
  } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("Error al eliminar la Sucursal" + e.getMessage());
   }
 }
}
