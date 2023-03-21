package com.doctor.rest.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate DataConsulta;
    private String HorarioConsulta;
    private int isDeleted;

}
