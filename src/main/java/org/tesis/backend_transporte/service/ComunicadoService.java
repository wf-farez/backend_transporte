package org.tesis.backend_transporte.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.tesis.backend_transporte.entity.Comunicado;
import org.tesis.backend_transporte.entity.Unidad;
import org.tesis.backend_transporte.repository.ComunicadoRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@Service
public class ComunicadoService {

    private final ComunicadoRepository comunicadoRepository;
    HashMap<String,Object> datos;

    @Autowired
    public ComunicadoService(ComunicadoRepository comunicadoRepository){
        this.comunicadoRepository=comunicadoRepository;
    }

    public List<Comunicado> obtenerComunicados(){
        return this.comunicadoRepository.findAll();
    }

    public ResponseEntity<Object> registrarComunicado(Comunicado comunicado) throws IllegalAccessException {


        datos= new HashMap<>();
/*

Optional<Unidad> res = comunicadoRepository.findUnidadByPlaca(unidad.getPlaca());
        if(res.isPresent() && unidad.getId_unidad()==null){
            datos.put("error",true);
            datos.put("messaje","Ya existe registro");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }*/

        datos.put("messaje","Registro exitoso");
        if (comunicado.getIdComunicado()!=null){
            datos.put("messaje","Actualizado exitoso");
        }

        comunicadoRepository.save(comunicado);
        datos.put("data",comunicado);

        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> eliminarComunicado(Long id){
        boolean existe=this.comunicadoRepository.existsById(id);
        datos=new HashMap<>();
        if (!existe){
            datos.put("error",true);
            datos.put("messaje","No existe registro");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        comunicadoRepository.deleteById(id);
        datos.put("messaje","Registro Eliminado");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );

    }

}
