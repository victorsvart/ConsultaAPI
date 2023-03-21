package com.doctor.rest.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PacienteResponse {
    private String firstName;
    private String lastName;
    private String endereco;
    private String rg;
    private int age;
    private LocalDate DataConsulta;
    private String HorarioConsulta;

}
