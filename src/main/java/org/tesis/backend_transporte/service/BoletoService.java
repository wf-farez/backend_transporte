package org.tesis.backend_transporte.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.tesis.backend_transporte.entity.Boleto;
import org.tesis.backend_transporte.repository.BoletoRepository;

import java.util.HashMap;
import java.util.List;


@Service
public class BoletoService {

    private final BoletoRepository boletoRepository;
    HashMap<String,Object> datos;

    @Autowired
    public BoletoService(BoletoRepository boletoRepository){
        this.boletoRepository=boletoRepository;
    }

    public List<Boleto> obtenerBoletos(){
        return this.boletoRepository.findAll();
    }


    public ResponseEntity<Object> registrarBoleto(Boleto boleto) throws IllegalAccessException {

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
        if (boleto.getIdBoleto()!=null){
            datos.put("messaje","Actualizado exitoso");
        }

        boletoRepository.save(boleto);
        datos.put("data",boleto);

        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }



    }





