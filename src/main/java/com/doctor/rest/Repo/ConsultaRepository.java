package com.doctor.rest.Repo;

import com.doctor.rest.Dto.DtoForRequests.ConsultaDTO;
import com.doctor.rest.Dto.DtoForRequests.ConsultaPacienteDTO;
import com.doctor.rest.Models.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {

    @Query(value = "SELECT c.data_consulta as dataConsulta, c.horario_consulta as horarioConsulta FROM crudpacientes.consulta c JOIN crudpacientes.paciente z WHERE c.is_deleted = 0 AND z.rg = :keyword AND c.paciente_id = z.id", nativeQuery = true)
    List<ConsultaDTO> findByKeyword(@Param("keyword")String keyword);

}
