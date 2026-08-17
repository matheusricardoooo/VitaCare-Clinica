package br.com.matheus.vitacare.DAO;

import br.com.matheus.vitacare.database.ConexaoBd;
import br.com.matheus.vitacare.model.Consulta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

        } catch (SQLException e) {
            throw new RuntimeException("ERRO AO CADASTRAR NOVA CONSULTA", e);
        }
    }
}
