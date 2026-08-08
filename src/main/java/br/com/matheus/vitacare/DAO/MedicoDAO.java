package br.com.matheus.vitacare.DAO;

import br.com.matheus.vitacare.database.ConexaoBd;
import br.com.matheus.vitacare.model.Medico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedicoDAO {
    public void cadastrarMedico(Medico medico) {
        String comandoSql =
                "INSERT INTO medicos " +
                        "(id_funcionario, crm_medico, especialidade_medica) " +
                        "VALUES(?,?,?)";

        try (
                Connection conexaoBanco = ConexaoBd.getConnection();
                PreparedStatement stmt = conexaoBanco.prepareStatement(comandoSql);
                ) {

            stmt.setInt(1, medico.getIdFuncionario());
            stmt.setString(2, medico.getCrmMedico());
            stmt.setString(3, medico.getEspecialidadeMedica());
            stmt.executeUpdate();

            System.out.println("===========================================================");
            System.out.println("            MÉDICO CADASTRADO COM SUCESSO!            ");
            System.out.println("===========================================================");

        }
        catch (SQLException e) {
            throw new RuntimeException("ERRO AO CADASTRAR MÉDICO", e);
        }
    }
}
