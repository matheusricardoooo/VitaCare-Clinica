package br.com.matheus.vitacare.model;

import java.time.LocalDate;

public class Funcionario {
    private int idFuncionario;
    private String nomeFuncionario;
    private String telefoneFuncionario;
    private String cpfFuncionario;
    private LocalDate dataNascimentoFuncionario;
    private String cargoFuncionario;
    private LocalDate dataContratado;

    public Funcionario () {} // construtor para ter compatibilidade com frameworks futuros

    public Funcionario (
            String nomeFuncionario,
            String telefoneFuncionario,
            String cpfFuncionario,
            LocalDate dataNascimentoFuncionario,
            String cargoFuncionario,
            LocalDate dataContratado
    ) {
        this.nomeFuncionario = nomeFuncionario;
        this.telefoneFuncionario = telefoneFuncionario;
        this.cpfFuncionario = cpfFuncionario;
        this.dataNascimentoFuncionario = dataNascimentoFuncionario;
        this.cargoFuncionario = cargoFuncionario;
        this.dataContratado = dataContratado;
    }
}
