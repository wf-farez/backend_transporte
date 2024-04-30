package org.tesis.backend_transporte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tesis.backend_transporte.entity.Ruta;
import org.tesis.backend_transporte.entity.Unidad;
import org.tesis.backend_transporte.service.RutaService;
import org.tesis.backend_transporte.service.UnidadService;

import java.util.List;


@RestController
@RequestMapping(path = "api/rutas")
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
