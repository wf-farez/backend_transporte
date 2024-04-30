package org.tesis.backend_transporte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tesis.backend_transporte.entity.Unidad;
import org.tesis.backend_transporte.service.UnidadService;

import java.util.List;



@RestController
@RequestMapping(path = "api/unidades")
public class UnidadController {
    private final UnidadService unidadService ;

    @Autowired
    public UnidadController(UnidadService unidadService) {
        this.unidadService = unidadService;
    }

    @GetMapping
    public List<Unidad> obtenerUnidades(){
        return this.unidadService.obtenerUnidades();
    }

    @PostMapping
    public ResponseEntity<Object> registrarUnidad(@RequestBody Unidad unidad) throws IllegalAccessException {
        return this.unidadService.registrarUnidad(unidad);
    }
    @PutMapping
    public ResponseEntity<Object> actualizarUnidad(@RequestBody Unidad unidad) throws IllegalAccessException {
        return this.unidadService.registrarUnidad(unidad);
    }

    @DeleteMapping(path="{idUnidad}")
    public ResponseEntity<Object> eliminarUnidad( @PathVariable("idUnidad") Long idUnidad){
        return this.unidadService.eliminarUnidad(idUnidad);
    }
}
