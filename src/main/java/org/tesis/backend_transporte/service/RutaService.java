package org.tesis.backend_transporte.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.tesis.backend_transporte.entity.Parada;
import org.tesis.backend_transporte.entity.Ruta;
import org.tesis.backend_transporte.repository.RutaRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@Service
public class RutaService {
    private final RutaRepository rutaRepository;
    HashMap<String,Object> datos;

    @Autowired
    public RutaService(RutaRepository rutaRepository){
        this.rutaRepository=rutaRepository;
    }

    public List<Ruta> obtenerRutas(){
        return this.rutaRepository.findAll();
    }

    public ResponseEntity<Object> registrarRuta(Ruta ruta) throws IllegalAccessException {

        Optional<Ruta> res = rutaRepository.findRutaByNombreRuta(ruta.getNombreRuta());
        datos= new HashMap<>();

        if(res.isPresent() && ruta.getIdRuta()==null){
            datos.put("error",true);
            datos.put("messaje","Ya existe registro");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        datos.put("messaje","Registro exitoso");
        if (ruta.getIdRuta()!=null){
            datos.put("messaje","Actualizado exitoso");
        }

        rutaRepository.save(ruta);
        datos.put("data",ruta);

        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> eliminarRuta(Long id){
        boolean existe=this.rutaRepository.existsById(id);
        datos=new HashMap<>();
        if (!existe){
            datos.put("error",true);
            datos.put("messaje","No existe registro");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        rutaRepository.deleteById(id);
        datos.put("messaje","Registro Eliminado");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );

    }

}
