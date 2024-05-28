package org.tesis.backend_transporte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tesis.backend_transporte.entity.Unidad;
import org.tesis.backend_transporte.entity.Viaje;
import org.tesis.backend_transporte.service.UnidadService;
import org.tesis.backend_transporte.service.ViajeService;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1/viajes")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ViajeController {
    private final ViajeService viajeService ;

    @Autowired
    public ViajeController(ViajeService viajeService) {
        this.viajeService = viajeService;
    }

    @GetMapping
    public List<Viaje> obtenerViajes(){
        return this.viajeService.obtenerViajes();
    }

    @PostMapping
    public ResponseEntity<Object> registrarViaje(@RequestBody Viaje viaje) throws IllegalAccessException {
        return this.viajeService.registrarViaje(viaje);
    }
    @PutMapping
    public ResponseEntity<Object> actualizarViaje(@RequestBody Viaje viaje) throws IllegalAccessException {
        return this.viajeService.registrarViaje(viaje);
    }

    @DeleteMapping(path="{idViaje}")
    public ResponseEntity<Object> eliminarViaje( @PathVariable("idViaje") Long idViaje){
        return this.viajeService.eliminarViaje(idViaje);
    }






}
