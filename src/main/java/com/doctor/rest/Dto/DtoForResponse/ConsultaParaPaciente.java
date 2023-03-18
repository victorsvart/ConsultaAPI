package com.doctor.rest.Dto.DtoForResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultaParaPaciente {
    private String DataConsulta;
    private String HorarioConsulta;
}
