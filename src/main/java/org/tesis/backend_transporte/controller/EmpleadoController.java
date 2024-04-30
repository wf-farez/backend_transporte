package org.tesis.backend_transporte.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tesis.backend_transporte.entity.Empleado;
import org.tesis.backend_transporte.service.EmpleadoService;
import java.util.List;

@RestController
@RequestMapping(path = "api/empleados")
public class EmpleadoController {
    private final EmpleadoService empleadoService ;

    @Autowired
    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public List<Empleado> obtenerEmpleados(){
        return this.empleadoService.obtenerEmpleados();
    }

    @PostMapping
    public ResponseEntity<Object> registrarEmpleado(@RequestBody Empleado empleado) throws IllegalAccessException {
        return this.empleadoService.registrarEmpleado(empleado);
    }
    @PutMapping
    public ResponseEntity<Object> actualizarEmpleado(@RequestBody Empleado empleado) throws IllegalAccessException {
        return this.empleadoService.registrarEmpleado(empleado);
    }

    @DeleteMapping(path="{idEmpleado}")
    public ResponseEntity<Object> eliminarEmpleado( @PathVariable("idEmpleado") Long idEmpleado){
        return this.empleadoService.eliminarEmpleado(idEmpleado);
    }
}
