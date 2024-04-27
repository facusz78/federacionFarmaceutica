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

import com.arielc.osyf.federacionformosa.models.entity.entitys.TipoDebitos;
import com.arielc.osyf.federacionformosa.models.entity.entitys.TipoLiquidacion;
import com.arielc.osyf.federacionformosa.models.service.registerServicesImpl.TipoLiquidacionService;

@CrossOrigin(origins = {"http://localhost:5173, https://federacionfarmaceuticaformosa.netlify.app"})
@RestController
@RequestMapping("/api")
public class LiquidacionesController {
    
    private final TipoLiquidacionService liquidacionService;

    public LiquidacionesController(TipoLiquidacionService liquidacionService) {
        this.liquidacionService = liquidacionService;
    }
    
    @GetMapping("/liquidaciones")
    public List<TipoLiquidacion> getAll(){
        return liquidacionService.getAll();
    }

    @PostMapping("/saveLiquidacion")
    public ResponseEntity<Object> save(@RequestBody TipoLiquidacion tipo) {
             
        try {
            liquidacionService.save(tipo);
            return ResponseEntity.ok("Tipo de liquidacion guardada");
                        
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("Error al agregar Tipo de liquidacion: " + e.getMessage());
        }
    }

    @PutMapping("/updateLiquidacion/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id , @RequestBody TipoLiquidacion tipo) {
             
        try {
            liquidacionService.update( id, tipo);
            return ResponseEntity.ok("Obra social modificada");
                        
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("Error al modificar Obra social: " + e.getMessage());
        }
    }
    
    @DeleteMapping("/deleteLiquidacion/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
    try {
        liquidacionService.delete(id);
        return ResponseEntity.ok("Tipo de liquidacion eliminada");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al eliminar la Tipo de liquidacion" + e.getMessage());
    }
  }

//   @GetMapping("/debitos")
//   public List<TipoDebitos> getAll(){
//       return dService.getAll();
//   }
  
  @PostMapping("/saveDebito/{id}")
  public ResponseEntity<Object> save(@PathVariable Long id, @RequestBody TipoDebitos debito) {
      try {
        liquidacionService.saveTipoDebito(id,debito);
          return ResponseEntity.ok("Tipo de Debito guardada");
                      
      } catch (Exception e) {
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Error al agregar Tipo de debito: " + e.getMessage());
      }
  }

  @PutMapping("/editeDebito/{id}")
  public ResponseEntity<Object> updateDebit(@PathVariable Long id, @RequestBody TipoDebitos debito) {
           
      try {
        liquidacionService.updateDebit(id, debito);
          return ResponseEntity.ok("Debito modificada");
                      
      } catch (Exception e) {
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Error al modificar Sucursal: " + e.getMessage());
      }
  }
  
  @DeleteMapping("/deleteDebit/{id}")
  public ResponseEntity<Object> deleteOffice(@PathVariable Long id){
  try {
    liquidacionService.deleteTypeDebito(id);
      return ResponseEntity.ok("Debito eliminada");
  } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("Error al eliminar Tipo de Debito" + e.getMessage());
   }
  } 
}
