package br.com.matheus.vitacare.DAO;

import br.com.matheus.vitacare.database.ConexaoBd;
import br.com.matheus.vitacare.model.Paciente;

import java.sql.Connection;

public class PacienteDAO {
    public void cadastrarPaciente(Paciente paciente) {
        Connection conexaoBanco = ConexaoBd.getConnection();

    }
}
