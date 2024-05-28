package org.tesis.backend_transporte.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tesis.backend_transporte.entity.Asiento;
import org.tesis.backend_transporte.entity.ParadaRuta;
import org.tesis.backend_transporte.entity.Unidad;

import java.util.List;
import java.util.Optional;


@Repository
public interface AsientoRepository extends JpaRepository<Asiento,Long> {
    List<Asiento> findByUnidadIdUnidad(Long idUnidad);


}
