package org.tesis.backend_transporte.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tesis.backend_transporte.entity.Evento;
import org.tesis.backend_transporte.entity.Unidad;

import java.util.Optional;


@Repository
public interface EventoRepository extends JpaRepository<Evento,Long> {
   //Optional<Unidad> findUnidadByPlaca (String placa);


}
