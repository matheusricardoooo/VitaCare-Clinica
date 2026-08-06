package br.com.matheus.vitacare.DAO;

import br.com.matheus.vitacare.database.ConexaoBd;
import br.com.matheus.vitacare.model.Funcionario;

import java.sql.Connection;
import java.sql.Date;
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

            stmt.setString(1, funcionario.getNomeFuncionario());
            stmt.setString(2, funcionario.getTelefoneFuncionario());
            stmt.setString(3, funcionario.getCpfFuncionario());
            stmt.setString(4, funcionario.getEmailFuncionario());
            stmt.setDate(5, Date.valueOf(funcionario.getDataNascimentoFuncionario()));
            stmt.setString(6, funcionario.getCargoFuncionario());
            stmt.setDate(7, Date.valueOf(funcionario.getDataContratado()));

            stmt.executeUpdate();
            System.out.println("===========================================================");
            System.out.println("            FUNCIONÁRIO CADASTRADO COM SUCESSO!            ");
            System.out.println("===========================================================");

        }
        catch (SQLException e) {
            throw new RuntimeException("ERRO AO CADASTRAR FUNCIONÁRIO", e);
        }
    }
}
