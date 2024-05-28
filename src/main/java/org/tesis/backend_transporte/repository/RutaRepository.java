package org.tesis.backend_transporte.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tesis.backend_transporte.entity.Ruta;

import java.util.Optional;


@Repository
public interface RutaRepository extends JpaRepository<Ruta,Long> {
   Optional<Ruta> findRutaByNombreRuta(String nombreRuta);

   Optional<Ruta> findRutaByIdRuta(Long idRuta);

}
