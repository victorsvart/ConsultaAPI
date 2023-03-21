package com.doctor.rest.Repo;


import com.doctor.rest.Models.ProcedimentosRealizados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcedimentosRealizadosRepository extends JpaRepository<ProcedimentosRealizados, Integer> {
}
