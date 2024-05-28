package org.tesis.backend_transporte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tesis.backend_transporte.entity.Compania;
import org.tesis.backend_transporte.entity.Comunicado;
import org.tesis.backend_transporte.service.CompaniaService;
import org.tesis.backend_transporte.service.ComunicadoService;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1/companias")
@CrossOrigin(origins = {"http://localhost:4200"})

public class CompaniaController {
    private final CompaniaService companiaService ;
    @Autowired
    public CompaniaController(CompaniaService companiaService) {
        this.companiaService = companiaService;
    }

    @GetMapping
    public List<Compania> obtenerCompanias(){
        return this.companiaService.obtenerCompanias();
    }

    @PostMapping
    public ResponseEntity<Object> registrarCompania(@RequestBody Compania compania) throws IllegalAccessException {
        return this.companiaService.registrarCompania(compania);
    }

    @PutMapping
    public ResponseEntity<Object> actualizarCompania(@RequestBody Compania compania) throws IllegalAccessException {
        return this.companiaService.registrarCompania(compania);
    }
    @DeleteMapping(path="{idCompania}")
    public ResponseEntity<Object> eliminarCompania( @PathVariable("idCompania") Long idCompania){
        return this.companiaService.eliminarCompania(idCompania);
    }
}
