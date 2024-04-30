package org.tesis.backend_transporte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tesis.backend_transporte.entity.Comunicado;
import org.tesis.backend_transporte.service.ComunicadoService;


import java.util.List;


@RestController
@RequestMapping(path = "api/comunicados")
public class ComunicadoController {
    private final ComunicadoService comunicadoService ;

    @Autowired
    public ComunicadoController(ComunicadoService comunicadoService) {
        this.comunicadoService = comunicadoService;
    }

    @GetMapping
    public List<Comunicado> obtenerComunicados(){
        return this.comunicadoService.obtenerComunicados();
    }

    @PostMapping
    public ResponseEntity<Object> registrarComunicado(@RequestBody Comunicado comunicado) throws IllegalAccessException {
        return this.comunicadoService.registrarComunicado(comunicado);
    }
    @PutMapping
    public ResponseEntity<Object> actualizarComunicado(@RequestBody Comunicado comunicado) throws IllegalAccessException {
        return this.comunicadoService.registrarComunicado(comunicado);
    }

    @DeleteMapping(path="{idComunicado}")
    public ResponseEntity<Object> eliminarComunicado( @PathVariable("idComunicado") Long idComunicado){
        return this.comunicadoService.eliminarComunicado(idComunicado);
    }
}
