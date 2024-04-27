package com.arielc.osyf.federacionformosa.controllers.Api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arielc.osyf.federacionformosa.models.entity.entitys.Farmaceuticos;
import com.arielc.osyf.federacionformosa.models.service.registerServicesImpl.FarmaceuticosService;

@CrossOrigin(origins = {"http://localhost:5173, https://federacionfarmaceuticaformosa.netlify.app" })
@RestController
@RequestMapping("/api")
public class FarmaceuticoRestController {
    
    private final FarmaceuticosService farmaceuticosService;

    public FarmaceuticoRestController(FarmaceuticosService farmaceuticosService) {
        this.farmaceuticosService = farmaceuticosService;
    }
    
    @GetMapping("/farmaceuticos")
    public List<Farmaceuticos> getAll(){
        return farmaceuticosService.getAll();
    }
   
    @PostMapping("/saveFarmaceutico")
    public ResponseEntity<Object> save(@RequestBody Farmaceuticos farmaceutico) {
             
        try {
            farmaceuticosService.save(farmaceutico);
            return ResponseEntity.ok("Farmaceutico guardada");
                        
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("Error al agregar Farmaceutico: " + e.getMessage());
        }
    }

    @PutMapping("/updateFarmaceutico/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id , @RequestBody Farmaceuticos farmaceutico) {
             
        try {
            farmaceuticosService.update(id, farmaceutico);
            return ResponseEntity.ok("Farmaceutico modificada");
                        
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("Error al modificar Farmaceutico: " + e.getMessage());
        }
    }

    @DeleteMapping("/deleteFarmaceutico/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
    try {
        farmaceuticosService.delete(id);
        return ResponseEntity.ok("Farmaceutico eliminada");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al eliminar la Farmaceutico" + e.getMessage());
     }
   }

}
