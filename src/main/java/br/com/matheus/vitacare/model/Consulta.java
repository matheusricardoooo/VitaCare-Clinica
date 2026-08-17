package br.com.matheus.vitacare.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Consulta {
    private int idConsulta;
    private int idPaciente;
    private int idMedico;
    private LocalDate dataConsulta;
    private LocalTime horaConsulta;
    private String statusConsulta;
}
