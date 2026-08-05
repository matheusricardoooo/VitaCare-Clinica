package br.com.matheus.vitacare.DAO;

import br.com.matheus.vitacare.database.ConexaoBd;
import br.com.matheus.vitacare.model.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.ResultSet;

public class PacienteDAO {
    public void cadastrarPaciente(Paciente paciente) {
        String comandoSql =
                "INSERT INTO pacientes" +
                        "(nome_paciente, telefone_paciente, cpf_paciente, email_paciente,data_nascimento_paciente)" +
                        "VALUES(?,?,?,?,?)";

        try(
                Connection conexaoBanco = ConexaoBd.getConnection();
                PreparedStatement stmt = conexaoBanco.prepareStatement(comandoSql);

        ) {
            stmt.setString(1, paciente.getNomePaciente());
            stmt.setString(2, paciente.getTelefonePaciente());
            stmt.setString(3, paciente.getCpfPaciente());
            stmt.setString(4, paciente.getEmailPaciente());
            stmt.setDate(5, Date.valueOf(paciente.getDataNascimentoPaciente()));

            stmt.executeUpdate();

            System.out.println("========================================================");
            System.out.println("            PACIENTE CADASTRADO COM SUCESSO!            ");
            System.out.println("========================================================");

        } catch (SQLException e) {
            throw new RuntimeException("ERRO AO CADASTRAR PACIENTE", e);
        }
    }

    public void visualizarPaacientesCadastrados() {
        try (

        ) {

        } catch (SQLException e) {
            throw new RuntimeException("ERRO AO CADASTRAR PACIENTE", e);
        }
    }
}
