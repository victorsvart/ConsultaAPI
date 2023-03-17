package com.doctor.rest.Repo;


import com.doctor.rest.Dto.DtoForRequests.ConsultaPacienteDTO;
import com.doctor.rest.Dto.PacienteResponse;
import com.doctor.rest.Models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    Optional<Paciente> findByID(int ID);
    Optional<Paciente> findByRG(String rg);
    void deleteAll();

    @Query("SELECT new com.doctor.rest.Dto.PacienteResponse(c.firstName, c.lastName, c.Endereco, c.RG, c.Age, z.DataConsulta, z.HorarioConsulta) FROM Paciente c JOIN c.Consul z")
    List<PacienteResponse> getJoinInformation();

    @Query("SELECT new com.doctor.rest.Dto.PacienteResponse(c.firstName, c.lastName, c.Endereco, c.RG, c.Age, z.DataConsulta, z.HorarioConsulta) FROM Paciente c JOIN c.Consul z WHERE z.isDeleted = 0")
    List<PacienteResponse> getConsultasPaciente();

    @Query(value = "SELECT c.first_name as firstName, c.last_name as lastName, c.rg FROM crudpacientes.paciente c JOIN crudpacientes.consulta z WHERE c.rg = :keyword AND z.paciente_id = c.id AND z.is_deleted = 0", nativeQuery = true)
    List<ConsultaPacienteDTO> findByKeyword(@Param("keyword")String keyword);


}
