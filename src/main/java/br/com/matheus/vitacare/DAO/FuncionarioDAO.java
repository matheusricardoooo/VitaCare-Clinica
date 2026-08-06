package br.com.matheus.vitacare.DAO;

import br.com.matheus.vitacare.database.ConexaoBd;
import br.com.matheus.vitacare.model.Funcionario;

import java.sql.*;

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

    public void listarFuncionariosCadastrados() {

        String consultaSql = "SELECT * FROM funcionarios";

        try (
                Connection conexaoBanco = ConexaoBd.getConnection();
                PreparedStatement stmt = conexaoBanco.prepareStatement(consultaSql)
        ) {

            ResultSet rs = stmt.executeQuery();
            boolean buscaPorCadastros = false;
            while (rs.next()) {
                buscaPorCadastros = true;
                int id = rs.getInt("id_funcionario");
                String nome = rs.getString("nome_funcionario");
                String telefone = rs.getString("telefone_funcionario");
                String cpf = rs.getString("cpf_funcionario");
                String email = rs.getString("email_funcionario");
                Date dataNascimento = rs.getDate("data_nascimento_funcionario");
                String cargo = rs.getString("cargo_funcionario");
                Date dataContrato = rs.getDate("data_contratacao");

                System.out.println("=================================================");
                System.out.println("ID: " + id);
                System.out.println("------------------------------------");
                System.out.println("NOME: " + nome);
                System.out.println("------------------------------------");
                System.out.println("TELEFONE: " + telefone);
                System.out.println("------------------------------------");
                System.out.println("CPF: " + cpf);
                System.out.println("------------------------------------");
                System.out.println("EMAIL: " + email);
                System.out.println("------------------------------------");
                System.out.println("DATA NASCIMENTO: " + dataNascimento);
                System.out.println("------------------------------------");
                System.out.println("CARGO: " + cargo);
                System.out.println("------------------------------------");
                System.out.println("DATA CONTRATAÇÃO: " + dataContrato);
                System.out.println("=================================================");
            }
            if (!buscaPorCadastros) {
                System.out.println("============================================================");
                System.out.println("        AVISO: NÃO HÁ NENHUM FUNCIONÁRIO CADASTRADO         ");
                System.out.println("============================================================");
            }

        }
        catch (SQLException e) {
            throw new RuntimeException("ERRO AO CADASTRAR FUNCIONÁRIO", e);
        }
    }

    public void buscarFuncionarioPorCpf(String cpf) {
        String buscaNoBanco =
                "SELECT * FROM funcionarios" +
                        "WHERE cpf_funcionario = ?";

        try (
                Connection conexaoBanco = ConexaoBd.getConnection();
                PreparedStatement stmt = conexaoBanco.prepareStatement(buscaNoBanco);
        ) {

            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id_funcionario");
                String nome = rs.getString("nome_funcionario");
                String telefone = rs.getString("telefone_funcionario");
                String Cpf = rs.getString("cpf_funcionario");
                String email = rs.getString("email_funcionario");
                Date data = rs.getDate("data_nascimento_funcionario");
                String cargo = rs.getString("cargo_funcionario");
                Date dataContrato = rs.getDate("data_contratacao");

                System.out.println("=================================================");
                System.out.println("ID: " + id);
                System.out.println("------------------------------------");
                System.out.println("NOME: " + nome);
                System.out.println("------------------------------------");
                System.out.println("TELEFONE: " + telefone);
                System.out.println("------------------------------------");
                System.out.println("CPF: " + Cpf);
                System.out.println("------------------------------------");
                System.out.println("EMAIL: " + email);
                System.out.println("------------------------------------");
                System.out.println("DATA NASCIMENTO: " + data);
                System.out.println("------------------------------------");
                System.out.println("CARGO: " + cargo);
                System.out.println("------------------------------------");
                System.out.println("DATA CONTRATAÇÃO: " + dataContrato);
                System.out.println("=================================================");
            }
            else {
                System.out.println("==================================================================");
                System.out.println("        AVISO: NÃO HÁ FUNCIONARIO CADASTRADO COM ESTE CPF         ");
                System.out.println("==================================================================");
            }

        } catch (SQLException e) {
            throw new RuntimeException("ERRO AO BUSCAR FUNCIONÁRIO", e);
        }
    }
}
