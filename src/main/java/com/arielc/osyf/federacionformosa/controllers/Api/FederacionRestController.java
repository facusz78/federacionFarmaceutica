package com.arielc.osyf.federacionformosa.controllers.Api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arielc.osyf.federacionformosa.models.entity.entitys.Federation;
import com.arielc.osyf.federacionformosa.models.service.registerServicesImpl.FederacionService;

@CrossOrigin(origins = {"http://localhost:5173, https://federacionfarmaceuticaformosa.netlify.app" })
@RestController
@RequestMapping("/api")
public class FederacionRestController {
     
    private FederacionService federacionService;

    public FederacionRestController(FederacionService federacionService) {
        this.federacionService = federacionService;
    }

    @GetMapping("/federacion")
    public List<Federation> getAll(){
        return federacionService.getAll();
    }

    @PostMapping("/saveFederacion")
    public ResponseEntity<Object> save(@RequestBody Federation federacion) {
        try {
            federacionService.saveUpdate(federacion);
            return ResponseEntity.ok("Federacion guardada");
                        
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("Error al agregar Federacion: " + e.getMessage());
        }
    }

}
