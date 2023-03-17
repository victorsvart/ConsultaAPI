package com.doctor.rest.Dto.DtoForRequests;

import com.doctor.rest.Models.Consulta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


public interface ConsultaPacienteDTO {
    String getFirstName();

    String getLastName();

    String getRG();

    List<Consulta> getConsul();


//    private String firstName;
//    private String lastName;
//    private String RG;
//
//    private LocalDate dataConsulta;
//
//    private String horarioConsulta;
}
