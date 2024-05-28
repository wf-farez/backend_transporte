package org.tesis.backend_transporte.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.tesis.backend_transporte.entity.Compania;
import org.tesis.backend_transporte.entity.Comunicado;
import org.tesis.backend_transporte.repository.CompaniaRepository;
import org.tesis.backend_transporte.repository.ComunicadoRepository;

import java.util.HashMap;
import java.util.List;


@Service
public class CompaniaService {

    private final CompaniaRepository companiaRepository;
    HashMap<String,Object> datos;

    @Autowired
    public CompaniaService(CompaniaRepository companiaRepository){
        this.companiaRepository =companiaRepository;
    }

    public List<Compania> obtenerCompanias(){
        return this.companiaRepository.findAll();
    }

    public ResponseEntity<Object> registrarCompania(Compania compania) throws IllegalAccessException {


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
        if (compania.getIdCompania()!=null){
            datos.put("messaje","Actualizado exitoso");
        }

        companiaRepository.save(compania);
        datos.put("data",compania);

        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> eliminarCompania(Long id){
        boolean existe=this.companiaRepository.existsById(id);
        datos=new HashMap<>();
        if (!existe){
            datos.put("error",true);
            datos.put("messaje","No existe registro");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        companiaRepository.deleteById(id);
        datos.put("messaje","Registro Eliminado");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );

    }

}
