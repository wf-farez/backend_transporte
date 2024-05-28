package org.tesis.backend_transporte.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.tesis.backend_transporte.entity.Asiento;
import org.tesis.backend_transporte.entity.Empleado;
import org.tesis.backend_transporte.entity.ParadaRuta;
import org.tesis.backend_transporte.repository.AsientoRepository;
import org.tesis.backend_transporte.repository.EmpleadoRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@Service
public class AsientoService {

    private final AsientoRepository asientoRepository;
    HashMap<String,Object> datos;

    @Autowired
    public AsientoService(AsientoRepository asientoRepository){
        this.asientoRepository=asientoRepository;
    }

    public List<Asiento> obtenerAsientos(){
        return this.asientoRepository.findAll();
    }

    public ResponseEntity<Object> registrarAsiento(Asiento asiento) throws IllegalAccessException {

        datos= new HashMap<>();
        /*Optional<Empleado> res = asientoRepository.findEmpleadoByCedula(empleado.getCedula());


        if(res.isPresent() && empleado.getIdEmpleado()==null){
            datos.put("error",true);
            datos.put("messaje","Ya existe registro");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        */

        datos.put("messaje","Registro exitoso");
        if (asiento.getIdAsiento()!=null){
            datos.put("messaje","Actualizado exitoso");
        }

        asientoRepository.save(asiento);
        datos.put("data",asiento);

        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> eliminarAsiento(Long id){
        boolean existe=this.asientoRepository.existsById(id);
        datos=new HashMap<>();
        if (!existe){
            datos.put("error",true);
            datos.put("messaje","No existe registro");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        asientoRepository.deleteById(id);
        datos.put("messaje","Registro Eliminado");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );

    }


    public void eliminarAsientosPorIdUnidad(Long idUnidad) {
        List<Asiento> asientosUnidad = asientoRepository.findByUnidadIdUnidad(idUnidad);
       asientoRepository.deleteAll(asientosUnidad);
    }
}
