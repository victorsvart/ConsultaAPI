package com.doctor.rest.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @JoinColumn(name ="paciente_id", referencedColumnName = "id")
    private List<Consulta> Consul;
    @OneToMany(targetEntity = ProcedimentosRealizados.class, cascade = CascadeType.ALL)
    private List<ProcedimentosRealizados> procedimentosRealizados;

    



}
