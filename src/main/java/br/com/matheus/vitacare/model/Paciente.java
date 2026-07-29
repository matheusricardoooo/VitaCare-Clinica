package br.com.matheus.vitacare.model;

import java.time.LocalDate;

public class Paciente {
    private int idPaciente;
    private String nomePaciente;
    private String telefonePaciente;
    private String cpfPaciente;
    private String emailPaciente;
    private LocalDate dataNascimentoPaciente;

    public Paciente () {} // construtor para ter compatibilidade com frameworks futuros

    public Paciente (
            String nomePaciente,
            String telefonePaciente,
            String cpfPaciente,
            String emailPaciente,
            LocalDate dataNascimentoPaciente
    ) {
        this.nomePaciente = nomePaciente;
        this.telefonePaciente = telefonePaciente;
        this.cpfPaciente = cpfPaciente;
        this.emailPaciente = emailPaciente;
        this.dataNascimentoPaciente = dataNascimentoPaciente;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    // utilizado apenas para DAO no insert do banco de dados
    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getTelefonePaciente() {
        return telefonePaciente;
    }

    public void setTelefonePaciente(String telefonePaciente) {
        this.telefonePaciente = telefonePaciente;
    }

    public String getCpfPaciente() {
        return cpfPaciente;
    }

    public String getEmailPaciente() {
        return emailPaciente;
    }

    public void setEmailPaciente(String emailPaciente) {
        this.emailPaciente = emailPaciente;
    }

    public LocalDate getDataNascimentoPaciente() {
        return dataNascimentoPaciente;
    }
}
