package br.com.matheus.vitacare.model;

import java.time.LocalDate;

public class Funcionario {
    private int idFuncionario;
    private String nomeFuncionario;
    private String telefoneFuncionario;
    private String cpfFuncionario;
    private String emailFuncionario;
    private LocalDate dataNascimentoFuncionario;
    private String cargoFuncionario;
    private LocalDate dataContratado;

    public Funcionario () {} // construtor para ter compatibilidade com frameworks futuros

    public Funcionario (
            String nomeFuncionario,
            String telefoneFuncionario,
            String cpfFuncionario,
            String emailFuncionario,
            LocalDate dataNascimentoFuncionario,
            String cargoFuncionario,
            LocalDate dataContratado
    ) {
        this.nomeFuncionario = nomeFuncionario;
        this.telefoneFuncionario = telefoneFuncionario;
        this.cpfFuncionario = cpfFuncionario;
        this.emailFuncionario = emailFuncionario;
        this.dataNascimentoFuncionario = dataNascimentoFuncionario;
        this.cargoFuncionario = cargoFuncionario;
        this.dataContratado = dataContratado;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public String getTelefoneFuncionario() {
        return telefoneFuncionario;
    }

    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    public String getEmailFuncionario() {
        return emailFuncionario;
    }

    public LocalDate getDataNascimentoFuncionario() {
        return dataNascimentoFuncionario;
    }

    public String getCargoFuncionario() {
        return cargoFuncionario;
    }

    public LocalDate getDataContratado() {
        return dataContratado;
    }
}
