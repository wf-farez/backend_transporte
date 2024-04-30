package org.tesis.backend_transporte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tesis.backend_transporte.entity.Parada;
import org.tesis.backend_transporte.service.ParadaService;

import java.util.List;


@RestController
@RequestMapping(path = "api/paradas")
public class ParadaController {
    private final ParadaService paradaService ;

    @Autowired
    public ParadaController(ParadaService paradaService) {
        this.paradaService = paradaService;
    }

    @GetMapping
    public List<Parada> obtenerParadas(){
        return this.paradaService.obtenerParadas();
    }

    @PostMapping
    public ResponseEntity<Object> registrarParada(@RequestBody Parada parada) throws IllegalAccessException {
        return this.paradaService.registrarParada(parada);
    }
    @PutMapping
    public ResponseEntity<Object> actualizarParada(@RequestBody Parada parada) throws IllegalAccessException {
        return this.paradaService.registrarParada(parada);
    }

    @DeleteMapping(path="{idParada}")
    public ResponseEntity<Object> eliminarParada( @PathVariable("idParada") Long idParada){
        return this.paradaService.eliminarParada(idParada);
    }
}
