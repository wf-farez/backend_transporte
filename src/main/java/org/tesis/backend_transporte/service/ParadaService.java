package org.tesis.backend_transporte.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.tesis.backend_transporte.entity.Parada;
import org.tesis.backend_transporte.repository.ParadaRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@Service
public class ParadaService {
    private final ParadaRepository paradaRepository;
    HashMap<String,Object> datos;

    @Autowired
    public ParadaService(ParadaRepository paradaRepository){
        this.paradaRepository=paradaRepository;
    }

    public List<Parada> obtenerParadas(){
        return this.paradaRepository.findAll();
    }

    public ResponseEntity<Object> registrarParada(Parada parada) throws IllegalAccessException {

        Optional<Parada> res = paradaRepository.findParadaByNombreParada(parada.getNombreParada());
        datos= new HashMap<>();

        if(res.isPresent() && parada.getIdParada()==null){
            datos.put("error",true);
            datos.put("messaje","Ya existe registro");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        datos.put("messaje","Registro exitoso");
        if (parada.getIdParada()!=null){
            datos.put("messaje","Actualizado exitoso");
        }

        paradaRepository.save(parada);
        datos.put("data",parada);

        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> eliminarParada(Long id){
        boolean existe=this.paradaRepository.existsById(id);
        datos=new HashMap<>();
        if (!existe){
            datos.put("error",true);
            datos.put("messaje","No existe registro");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        paradaRepository.deleteById(id);
        datos.put("messaje","Registro Eliminado");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );

    }

}
