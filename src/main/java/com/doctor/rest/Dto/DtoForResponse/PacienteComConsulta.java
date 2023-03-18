package com.doctor.rest.Dto.DtoForResponse;

import com.doctor.rest.Models.Consulta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteComConsulta {
    private String FirstName;
    private String LastName;
    private String RG;
    private List<Consulta> Consul;

}
