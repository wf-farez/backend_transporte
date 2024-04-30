package org.tesis.backend_transporte.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.tesis.backend_transporte.entity.Viaje;
import org.tesis.backend_transporte.repository.ViajeRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@Service
public class ViajeService {

    private final ViajeRepository viajeRepository;
    HashMap<String,Object> datos;

    @Autowired
    public ViajeService(ViajeRepository viajeRepository){
        this.viajeRepository=viajeRepository;
    }

    public List<Viaje> obtenerViajes(){
        return this.viajeRepository.findAll();
    }

    public ResponseEntity<Object> registrarViaje(Viaje viaje) throws IllegalAccessException {

        Optional<Viaje> res = viajeRepository.findViajeByCodigoViaje(viaje.getCodigoViaje());
        datos= new HashMap<>();

        if(res.isPresent() && viaje.getIdViaje()==null){
            datos.put("error",true);
            datos.put("messaje","Ya existe registro");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        datos.put("messaje","Registro exitoso");
        if (viaje.getIdViaje()!=null){
            datos.put("messaje","Actualizado exitoso");
        }

        viajeRepository.save(viaje);
        datos.put("data",viaje);

        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> eliminarViaje(Long id){
        boolean existe=this.viajeRepository.existsById(id);
        datos=new HashMap<>();
        if (!existe){
            datos.put("error",true);
            datos.put("messaje","No existe registro");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        viajeRepository.deleteById(id);
        datos.put("messaje","Registro Eliminado");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );

    }

}
