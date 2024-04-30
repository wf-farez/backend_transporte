package org.tesis.backend_transporte.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tesis.backend_transporte.entity.Parada;


import java.util.Optional;


@Repository
public interface ParadaRepository extends JpaRepository<Parada,Long> {
   Optional<Parada> findParadaByNombreParada(String nombreParada);


}
