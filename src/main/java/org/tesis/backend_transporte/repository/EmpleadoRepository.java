package org.tesis.backend_transporte.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tesis.backend_transporte.entity.Empleado;
import org.tesis.backend_transporte.entity.Unidad;

import java.util.Optional;


@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado,Long> {
   Optional<Empleado> findEmpleadoByCedula(String cedula);


}
