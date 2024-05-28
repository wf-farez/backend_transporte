package org.tesis.backend_transporte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tesis.backend_transporte.entity.Ruta;
import org.tesis.backend_transporte.service.RutaService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "api/v1/rutas")
@CrossOrigin(origins = {"http://localhost:4200"})
public class RutaController {
    private final RutaService rutaService;

    @Autowired
    public RutaController(RutaService rutaService) {
        this.rutaService = rutaService;
    }

    @GetMapping
    public List<Ruta> obtenerRutas(){
        return this.rutaService.obtenerRutas();
    }

    @GetMapping(params = "idRuta")
    public Optional<Ruta> obtenerRutaByRutaId(@RequestParam("idRuta") Long idRuta) {
        return this.rutaService.obtenerRutaByRutaId(idRuta);
    }

    @PostMapping
    public ResponseEntity<Object> registrarRuta(@RequestBody Ruta ruta) throws IllegalAccessException {
        return this.rutaService.registrarRuta(ruta);
    }

    @PutMapping
    public ResponseEntity<Object> actualizarRuta(@RequestBody Ruta ruta) throws IllegalAccessException {
        return this.rutaService.registrarRuta(ruta);
    }

    @DeleteMapping(path="{idRuta}")
    public ResponseEntity<Object> eliminarRuta( @PathVariable("idRuta") Long idRuta){
        return this.rutaService.eliminarRuta(idRuta);
    }
}
