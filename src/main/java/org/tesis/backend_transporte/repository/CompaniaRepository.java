package org.tesis.backend_transporte.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tesis.backend_transporte.entity.Compania;

@Repository
public interface CompaniaRepository extends JpaRepository<Compania,Long> {
   //Optional<Unidad> findUnidadByPlaca (String placa);


}
