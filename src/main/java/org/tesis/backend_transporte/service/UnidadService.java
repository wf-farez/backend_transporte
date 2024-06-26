package org.tesis.backend_transporte.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.tesis.backend_transporte.entity.Asiento;
import org.tesis.backend_transporte.entity.Unidad;
import org.tesis.backend_transporte.repository.AsientoRepository;
import org.tesis.backend_transporte.repository.UnidadRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@Service
public class UnidadService {
    private final UnidadRepository unidadRepository;
    private final AsientoRepository asientoRepository;
    HashMap<String,Object> datos;
    HashMap<String,Object> datos2;

    @Autowired
    public UnidadService(UnidadRepository unidadRepository, AsientoRepository asientoRepository){
        this.unidadRepository=unidadRepository;
        this.asientoRepository = asientoRepository;
    }

    public List<Unidad> obtenerUnidades(){
        return this.unidadRepository.findAll();
    }

    public ResponseEntity<Object> registrarUnidad(Unidad unidad) throws IllegalAccessException {

        Optional<Unidad> res = unidadRepository.findUnidadByPlaca(unidad.getPlaca());
        datos= new HashMap<>();

        if(res.isPresent() && unidad.getIdUnidad()==null){
            datos.put("error",true);
            datos.put("messaje","Ya existe registro");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        datos.put("messaje","Registro exitoso");

        if (unidad.getIdUnidad()!=null){
            datos.put("messaje","Actualizado exitoso");
        }

        unidadRepository.save(unidad);
        datos.put("data",unidad);

        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> eliminarUnidad(Long id){
        boolean existe=this.unidadRepository.existsById(id);
        datos=new HashMap<>();
        if (!existe){
            datos.put("error",true);
            datos.put("messaje","No existe registro");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        unidadRepository.deleteById(id);
        datos.put("messaje","Registro Eliminado");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );

    }





    public ResponseEntity<Object> registrarAsientos(Asiento asiento) throws IllegalAccessException {

        datos2= new HashMap<>();


        datos2.put("messaje","Registro exitoso");


        asientoRepository.save(asiento);
        datos2.put("data",asiento);

        return new ResponseEntity<>(
                datos2,
                HttpStatus.CREATED
        );
    }

}
