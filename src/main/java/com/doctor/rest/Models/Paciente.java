package com.doctor.rest.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Date;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Paciente {
    @Id
    @GeneratedValue()
    private int ID;

    private String firstName;

    private String lastName;

    private int Age;

    private String Laudo;

    private String RG;

    private String Telefone;

    private String Endereco;

    private java.sql.Date Nascimento;

    private String Profissao;

    @OneToMany(targetEntity = Consulta.class, cascade = CascadeType.ALL)
    private List<Consulta> Consul;
    @OneToMany(targetEntity = ProcedimentosRealizados.class, cascade = CascadeType.ALL)
    private List<ProcedimentosRealizados> procedimentosRealizados;



}
