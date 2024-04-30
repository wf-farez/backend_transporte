package org.tesis.backend_transporte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tesis.backend_transporte.entity.Evento;
import org.tesis.backend_transporte.entity.Unidad;
import org.tesis.backend_transporte.service.EventoService;
import org.tesis.backend_transporte.service.UnidadService;

import java.util.List;


@RestController
@RequestMapping(path = "api/eventos")
public class EventoController {
    private final EventoService eventoService ;

    @Autowired
    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping
    public List<Evento> obtenerEventos(){
        return this.eventoService.obtenerEventos();
    }

    @PostMapping
    public ResponseEntity<Object> registrarEvento(@RequestBody Evento evento) throws IllegalAccessException {
        return this.eventoService.registrarEvento(evento);
    }
    @PutMapping
    public ResponseEntity<Object> actualizarEvento(@RequestBody Evento evento) throws IllegalAccessException {
        return this.eventoService.registrarEvento(evento);
    }
    @DeleteMapping(path="{idEvento}")
    public ResponseEntity<Object> eliminarEvento( @PathVariable("idEvento") Long idEvento){
        return this.eventoService.eliminarEvento(idEvento);
    }
}
