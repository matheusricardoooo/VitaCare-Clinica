package br.com.matheus.vitacare.DAO;

import br.com.matheus.vitacare.database.ConexaoBd;
import br.com.matheus.vitacare.model.Paciente;

import java.sql.Connection;

public class PacienteDAO {
    public void cadastrarPaciente(Paciente paciente) {
        Connection conexaoBanco = ConexaoBd.getConnection();
        String comandoSql =
                "INSERT INTO pacientes" +
                        "(nome_paciente, telefone_paciente, cpf_paciente, email_paciente,data_nascimento_paciente)" +
                        "VALUES(?,?,?,?,?)";


    }
}
