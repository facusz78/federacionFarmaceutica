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

import com.arielc.osyf.federacionformosa.models.entity.entitys.Farmacia;
import com.arielc.osyf.federacionformosa.models.entity.entitys.SucursalFarmacias;
import com.arielc.osyf.federacionformosa.models.service.registerServicesImpl.FarmaciaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin(origins = {"http://localhost:5173, https://federacionfarmaceuticaformosa.netlify.app" })
@RestController
@RequestMapping("/api")
public class FarmaciaRestController {
    
    private final FarmaciaService farmaciaService;

    public FarmaciaRestController(FarmaciaService farmaciaService) {
        this.farmaciaService = farmaciaService;
    }
    
    @GetMapping("/farmacias")
    public List<Farmacia> getAll(){
        return farmaciaService.getAll();
    }

    @PostMapping("/saveFarmacia")
    public ResponseEntity<Object> save(@RequestBody Farmacia farmacia) {
             
        try {
            farmaciaService.save(farmacia);
            return ResponseEntity.ok("Farmacia guardada");
                        
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("Error al agregar Farmacia: " + e.getMessage());
        }
    }

    @PutMapping("/updateFarmacia/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id , @RequestBody Farmacia farmacia) {
             
        try {
            farmaciaService.update(id, farmacia);
            return ResponseEntity.ok("Farmacia modificada");
                        
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("Error al modificar Farmacia: " + e.getMessage());
        }
    }

   @DeleteMapping("/deleteFarmacia/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
    try {
        farmaciaService.delete(id);
        return ResponseEntity.ok("Farmacia eliminada");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al eliminar la Farmacia" + e.getMessage());
     }
   }

   @PostMapping("/AgregeSucursal/{id}")
   public ResponseEntity<Object> saveOffice(@PathVariable Long id, @RequestBody SucursalFarmacias sucursal) {
      try {
          farmaciaService.saveOffice(id, sucursal);
         return ResponseEntity.ok("Sucursal agregada");
      } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
        .body("Error al agregar Sucursal: " + e.getMessage());
      }
   }

   @PutMapping("/editeSucursal/{id}")
   public ResponseEntity<Object> updateOffice(@PathVariable Long id, @RequestBody SucursalFarmacias sucursal) {
            
       try {
           farmaciaService.updateOffice(id, sucursal);
           return ResponseEntity.ok("Sucursal modificada");
                       
       } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
           .body("Error al modificar Sucursal: " + e.getMessage());
       }
   }
   
   @DeleteMapping("/deleteSucursal/{id}")
   public ResponseEntity<Object> deleteOffice(@PathVariable Long id){
   try {
       farmaciaService.deleteOffice(id);
       return ResponseEntity.ok("Sucursal eliminada");
   } catch (Exception e) {
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
               .body("Error al eliminar la Sucursal" + e.getMessage());
    }
  }
}