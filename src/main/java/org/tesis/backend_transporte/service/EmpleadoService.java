package org.tesis.backend_transporte.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.tesis.backend_transporte.entity.Empleado;
import org.tesis.backend_transporte.repository.EmpleadoRepository;


import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;
    HashMap<String,Object> datos;

    @Autowired
    public EmpleadoService(EmpleadoRepository empleadoRepository){
        this.empleadoRepository=empleadoRepository;
    }

    public List<Empleado> obtenerEmpleados(){
        return this.empleadoRepository.findAll();
    }

    public ResponseEntity<Object> registrarEmpleado(Empleado empleado) throws IllegalAccessException {

        Optional<Empleado> res = empleadoRepository.findEmpleadoByCedula(empleado.getCedula());
        datos= new HashMap<>();

        if(res.isPresent() && empleado.getIdEmpleado()==null){
            datos.put("error",true);
            datos.put("messaje","Ya existe registro");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        datos.put("messaje","Registro exitoso");
        if (empleado.getIdEmpleado()!=null){
            datos.put("messaje","Actualizado exitoso");
        }

        empleadoRepository.save(empleado);
        datos.put("data",empleado);

        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );
    }

    public ResponseEntity<Object> eliminarEmpleado(Long id){
        boolean existe=this.empleadoRepository.existsById(id);
        datos=new HashMap<>();
        if (!existe){
            datos.put("error",true);
            datos.put("messaje","No existe registro");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        empleadoRepository.deleteById(id);
        datos.put("messaje","Registro Eliminado");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );

    }

}
