package com.doctor.rest.Dto.DtoForRequests;

import com.doctor.rest.Models.Consulta;
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
