package br.com.matheus.vitacare.DAO;

import br.com.matheus.vitacare.database.ConexaoBd;
import br.com.matheus.vitacare.model.Consulta;

import java.sql.*;

public class ConsultaDAO {
    public void criarConsulta(Consulta consulta) {
        String comandoSql =
                "INSERT INTO consultas " +
                        "(id_consulta, id_paciente, id_medico, data_consulta) " +
                        "(hora_consulta, status_consulta ) " +
                        "VALUES(?, ?, ?, ?, ?, ?)";

        try (
                Connection conexaoBanco = ConexaoBd.getConnection();
                PreparedStatement stmt = conexaoBanco.prepareStatement(comandoSql);
                ) {

            stmt.setInt(1, consulta.getIdConsulta());
            stmt.setInt(2, consulta.getIdPaciente());
            stmt.setInt(3, consulta.getIdMedico());
            stmt.setDate(4, Date.valueOf(consulta.getDataConsulta()));
            stmt.setTime(5, Time.valueOf(consulta.getHoraConsulta()));
            stmt.setString(6, consulta.getStatusConsulta());

            stmt.executeUpdate();

            System.out.println("======================================================");
            System.out.println("            CONSULTA AGENDADA COM SUCESSO!            ");
            System.out.println("======================================================");


        }
        catch (SQLException e) {
            throw new RuntimeException("ERRO AO CADASTRAR UMA CONSULTA", e);
        }
    }

    public void visualizarConsultas() {

    }
}
