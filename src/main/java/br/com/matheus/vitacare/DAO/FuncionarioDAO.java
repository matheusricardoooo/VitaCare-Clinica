package br.com.matheus.vitacare.DAO;

import br.com.matheus.vitacare.database.ConexaoBd;
import br.com.matheus.vitacare.model.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FuncionarioDAO {
    public void cadastrarFuncionario(Funcionario funcionario) {
        String comandoSql =
                "INSERT INTO funcionarios" +
                        "nome_funcionario, telefone_funcionario, cpf_funcionario " +
                        "email_funcionario, data_nascimento_funcionario, cargo_funcionario " +
                        "data_contratado" +
                        "VALUES(?,?,?,?,?,?,?)";

        try (
                Connection conexaoBanco = ConexaoBd.getConnection();
                PreparedStatement stmt = conexaoBanco.prepareStatement(comandoSql);
        ) {
        }
        catch (SQLException e) {
            throw new RuntimeException("ERRO AO CADASTRAR FUNCIONÁRIO", e);
        }
    }
}
