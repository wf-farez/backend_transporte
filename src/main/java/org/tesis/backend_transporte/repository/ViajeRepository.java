package org.tesis.backend_transporte.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tesis.backend_transporte.entity.Viaje;

import java.util.Optional;


@Repository
public interface ViajeRepository extends JpaRepository<Viaje,Long> {
   Optional<Viaje> findViajeByCodigoViaje(String codigoViaje);


}
