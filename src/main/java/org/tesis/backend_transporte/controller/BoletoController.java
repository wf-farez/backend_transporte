package org.tesis.backend_transporte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tesis.backend_transporte.entity.Asiento;
import org.tesis.backend_transporte.entity.Boleto;
import org.tesis.backend_transporte.service.AsientoService;
import org.tesis.backend_transporte.service.BoletoService;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/boletos")
@CrossOrigin(origins = {"http://localhost:4200"})
public class BoletoController {
    private final BoletoService boletoService ;
    @Autowired
    public BoletoController(BoletoService boletoService) {
        this.boletoService= boletoService;
    }

    @GetMapping
    public List<Boleto> obtenerBoletos(){
        return this.boletoService.obtenerBoletos();
    }

    @PostMapping
    public ResponseEntity<Object> registrarBoleto(@RequestBody Boleto boleto) throws IllegalAccessException {
        return this.boletoService.registrarBoleto(boleto);
    }


/*
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
*/
}
