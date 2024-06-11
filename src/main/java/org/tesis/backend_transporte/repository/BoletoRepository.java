package org.tesis.backend_transporte.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tesis.backend_transporte.entity.Boleto;


@Repository
public interface BoletoRepository extends JpaRepository<Boleto,Long> {
   //Optional<Unidad> findUnidadByPlaca (String placa);


}
