package org.tesis.backend_transporte.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tesis.backend_transporte.entity.Comunicado;

import java.util.Optional;


@Repository
public interface ComunicadoRepository extends JpaRepository<Comunicado,Long> {
   //Optional<Unidad> findUnidadByPlaca (String placa);


}
