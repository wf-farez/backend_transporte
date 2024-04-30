package org.tesis.backend_transporte.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.tesis.backend_transporte.entity.Evento;
import org.tesis.backend_transporte.repository.EventoRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@Service
public class EventoService {
    private final EventoRepository eventoRepository;
    HashMap<String,Object> datos;

    @Autowired
    public EventoService(EventoRepository eventoRepository){
        this.eventoRepository=eventoRepository;
    }

    public List<Evento> obtenerEventos(){
        return this.eventoRepository.findAll();
    }

    public ResponseEntity<Object> registrarEvento(Evento evento) throws IllegalAccessException {
        datos= new HashMap<>();

       /* Optional<Unidad> res = eventoRepository.findUnidadByPlaca(unidad.getPlaca());
        if(res.isPresent() && unidad.getId_unidad()==null){
            datos.put("error",true);
            datos.put("messaje","Ya existe registro");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }*/

        datos.put("messaje","Registro exitoso");
        if (evento.getIdEvento()!=null){
            datos.put("messaje","Actualizado exitoso");
        }

        eventoRepository.save(evento);
        datos.put("data",evento);

        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> eliminarEvento(Long id){
        boolean existe=this.eventoRepository.existsById(id);
        datos=new HashMap<>();
        if (!existe){
            datos.put("error",true);
            datos.put("messaje","No existe registro");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        eventoRepository.deleteById(id);
        datos.put("messaje","Registro Eliminado");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );

    }

}
