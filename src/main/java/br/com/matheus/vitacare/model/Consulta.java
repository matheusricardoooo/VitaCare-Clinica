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

    public Consulta () {} // construtor para ter compatibilidade com framework

    public Consulta ( // construtor incia um objeto atribuindo valor ao atributo declarado
            int id_consulta,
            int id_paciente,
            int id_medico,
            LocalDate data_consulta,
            LocalTime hora_consulta,
            String status_consulta
    ) {
        this.idConsulta = id_consulta;
        this.idPaciente = id_paciente;
        this.idMedico = id_medico;
        this.dataConsulta = data_consulta;
        this.horaConsulta = hora_consulta;
        this.statusConsulta = status_consulta;
    }
}
