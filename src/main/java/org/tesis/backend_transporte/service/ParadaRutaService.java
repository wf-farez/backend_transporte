package org.tesis.backend_transporte.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.tesis.backend_transporte.entity.Parada;
import org.tesis.backend_transporte.entity.ParadaRuta;
import org.tesis.backend_transporte.repository.ParadaRepository;
import org.tesis.backend_transporte.repository.ParadaRutaRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@Service
public class ParadaRutaService {
    private final ParadaRutaRepository paradaRutaRepository;
    HashMap<String,Object> datos;

    @Autowired
    public ParadaRutaService(ParadaRutaRepository paradaRutaRepository){
        this.paradaRutaRepository=paradaRutaRepository;
    }

    public List<ParadaRuta> obtenerParadasRuta(){
        return this.paradaRutaRepository.findAll();
    }

    // Método para encontrar paradas de ruta por ID de ruta
    public List<ParadaRuta> obtenerParadasRutaByRutaId(Long idRuta) {
        return this.paradaRutaRepository.findByRutaIdRuta(idRuta);
    }
    public ResponseEntity<Object> registrarParadaRuta(ParadaRuta paradaRuta) throws IllegalAccessException {

        //Optional<ParadaRuta> res = paradaRutaRepository.findParadaByNombreParada(paradaRuta.getNombreParadaRuta());
        datos= new HashMap<>();

        /*if(res.isPresent() && parada.getIdParada()==null){
            datos.put("error",true);
            datos.put("messaje","Ya existe registro");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }*/
        datos.put("messaje","Registro exitoso");
        if (paradaRuta.getIdParadaRuta()!=null){
            datos.put("messaje","Actualizado exitoso");
        }

        paradaRutaRepository.save(paradaRuta);
        datos.put("data",paradaRuta);

        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> eliminarParadaRuta(Long id){
        boolean existe=this.paradaRutaRepository.existsById(id);
        datos=new HashMap<>();
        if (!existe){
            datos.put("error",true);
            datos.put("messaje","No existe registro");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        paradaRutaRepository.deleteById(id);
        datos.put("messaje","Registro Eliminado");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );
    }




    public void eliminarParadasRutaPorIdRuta(Long idRuta) {
        List<ParadaRuta> paradasRuta = paradaRutaRepository.findByRutaIdRuta(idRuta);
        paradaRutaRepository.deleteAll(paradasRuta);
    }

}
