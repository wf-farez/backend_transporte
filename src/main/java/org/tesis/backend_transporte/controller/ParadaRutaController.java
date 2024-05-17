package org.tesis.backend_transporte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tesis.backend_transporte.entity.ParadaRuta;
import org.tesis.backend_transporte.service.ParadaRutaService;
import java.util.List;

@RestController
@RequestMapping(path = "api/paradasruta")
public class ParadaRutaController {
    private final ParadaRutaService paradaRutaService ;

    @Autowired
    public ParadaRutaController(ParadaRutaService paradaRutaService) {
        this.paradaRutaService = paradaRutaService;
    }

    @GetMapping
    public List<ParadaRuta> obtenerParadasRuta(){
        return this.paradaRutaService.obtenerParadasRuta();
    }

    @GetMapping(params = "idRuta")
    public List<ParadaRuta> obtenerParadasRutaByRutaId(@RequestParam("idRuta") Long idRuta) {
        return this.paradaRutaService.obtenerParadasRutaByRutaId(idRuta);
    }
    @PostMapping
    public ResponseEntity<Object> registrarParadaRuta(@RequestBody ParadaRuta paradaRuta) throws IllegalAccessException {
        return this.paradaRutaService.registrarParadaRuta(paradaRuta);
    }
    @PutMapping
    public ResponseEntity<Object> actualizarParadaRuta(@RequestBody ParadaRuta paradaRuta) throws IllegalAccessException {
        return this.paradaRutaService.registrarParadaRuta(paradaRuta);
    }

    @DeleteMapping(path="{idParadaRuta}")
    public ResponseEntity<Object> eliminarParadaRuta( @PathVariable("idParadaRuta") Long idParadaRuta){
        return this.paradaRutaService.eliminarParadaRuta(idParadaRuta);
    }

    @DeleteMapping(params = "idRuta")
    public ResponseEntity<Object> eliminarParadasRutaPorIdRuta(@RequestParam("idRuta") Long idRuta) {
        ResponseEntity<Object> response;
        try {
            this.paradaRutaService.eliminarParadasRutaPorIdRuta(idRuta);
            response = ResponseEntity.ok().build();
        } catch (Exception e) {
            response = ResponseEntity.badRequest().body("Error al eliminar paradas de ruta por ID de ruta: " + e.getMessage());
        }
        return response;
    }


}
