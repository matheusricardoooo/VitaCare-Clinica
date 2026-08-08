package br.com.matheus.vitacare.model;

public class Medico {
    private int idFuncionario;
    private String crmMedico;
    private String especialidadeMedica;

    public Medico () {} // construtor vazio para implementação de framework

    public Medico (
            int idFuncionario,
            String crmMedico,
            String especialidadeMedica
    ) {
        this.idFuncionario = idFuncionario;
        this.crmMedico = crmMedico;
        this.especialidadeMedica = especialidadeMedica;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public String getCrmMedico() {
        return crmMedico;
    }

    public String getEspecialidadeMedica() {
        return especialidadeMedica;
    }
}
