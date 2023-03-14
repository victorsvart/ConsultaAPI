package com.doctor.rest.Dto;

import com.doctor.rest.Models.Paciente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PacienteRequest {
    private Paciente paciente;
}
