package org.tesis.backend_transporte.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tesis.backend_transporte.entity.Parada;
import org.tesis.backend_transporte.entity.ParadaRuta;
import java.util.List;

import java.util.Optional;


@Repository
public interface ParadaRutaRepository extends JpaRepository<ParadaRuta, Long> {
    List<ParadaRuta> findByRutaIdRuta(Long idRuta);


}