package org.tesis.backend_transporte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tesis.backend_transporte.entity.Asiento;
import org.tesis.backend_transporte.service.AsientoService;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/asientos")
@CrossOrigin(origins = {"http://localhost:4200"})
public class AsientoController {
    private final AsientoService asientoService ;
    @Autowired
    public AsientoController(AsientoService asientoService) {
        this.asientoService = asientoService;
    }

    @GetMapping
    public List<Asiento> obtenerAsientos(){
        return this.asientoService.obtenerAsientos();
    }

    @PostMapping
    public ResponseEntity<Object> registrarAsiento(@RequestBody Asiento asiento) throws IllegalAccessException {
        return this.asientoService.registrarAsiento(asiento);
    }
    @PutMapping
    public ResponseEntity<Object> actualizarAsiento(@RequestBody Asiento asiento) throws IllegalAccessException {
        return this.asientoService.registrarAsiento(asiento);
    }
    @DeleteMapping(path="{idAsiento}")
    public ResponseEntity<Object> eliminarAsiento( @PathVariable("idAsiento") Long idAsiento){
        return this.asientoService.eliminarAsiento(idAsiento);
    }


    @DeleteMapping(params = "idUnidad")
    public ResponseEntity<Object> eliminarAsientosPorIdUnidad(@RequestParam("idUnidad") Long idUnidad) {
        ResponseEntity<Object> response;
        try {
            this.asientoService.eliminarAsientosPorIdUnidad(idUnidad);
            response = ResponseEntity.ok().build();
        } catch (Exception e) {
            response = ResponseEntity.badRequest().body("Error al eliminar paradas de ruta por ID de ruta: " + e.getMessage());
        }
        return response;
    }

}
