package com.doctor.rest.Dto.DtoForRequests;

import java.sql.Date;
import java.util.List;

import com.doctor.rest.Models.Consulta;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PacienteDTO {
    private int ID;
    private String firstName;
    private String lastName;
    private int Age;
    private String CPF;
    private String Telefone;
    private String Endereco;
    private Date Nascimento;
    private List<Consulta> Consul;
    
    
}
