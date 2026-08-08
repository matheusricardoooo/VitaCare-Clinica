package br.com.matheus.vitacare.DAO;

import br.com.matheus.vitacare.database.ConexaoBd;
import br.com.matheus.vitacare.model.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.ResultSet;

public class FuncionarioDAO {
    public void cadastrarFuncionario(Funcionario funcionario) {
        String comandoSql =
                "INSERT INTO funcionarios " +
                        "(nome_funcionario, telefone_funcionario, cpf_funcionario, " +
                        "email_funcionario, data_nascimento_funcionario, cargo_funcionario, " +
                        "data_contratacao) " +
                        "VALUES(?, ?, ?, ?, ?, ?, ?)";

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

    public void atualizarNomeFuncionario(String cpf, String novoNome) {
        String atualizacaoBanco =
                "UPDATE funcionarios " +
                        "SET nome_funcionario = ? " +
                        "WHERE cpf_funcionario = ?";

        try (
                Connection conexaoBanco = ConexaoBd.getConnection();
                PreparedStatement stmt = conexaoBanco.prepareStatement(atualizacaoBanco);
        ) {
            stmt.setString(1, novoNome);
            stmt.setString(2, cpf);
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("================================================");
                System.out.println("        SUCESSO: NOME ALTERADO COM ÊXITO        ");
                System.out.println("================================================");
            }
            else {
                System.out.println("==============================================================");
                System.out.println("        AVISO: NÃO HÁ NENHUM FUNCIONÁRIO COM ESTE CPF         ");
                System.out.println("==============================================================");
            }
        }
        catch (SQLException e) {
            throw new RuntimeException("ERRO AO ATUALIZAR NOME DO FUNCIONÁRIO", e);
        }
    }

    public void atualizarTelefoneFuncionario(String cpf, String novoTelefone) {
        String atualizacaoBanco =
                "UPDATE funcionarios " +
                        "SET telefone_funcionario = ? " +
                        "WHERE cpf_funcionario = ?";

        try (
                Connection conexaoBanco = ConexaoBd.getConnection();
                PreparedStatement stmt = conexaoBanco.prepareStatement(atualizacaoBanco);
        ) {
            stmt.setString(1, novoTelefone);
            stmt.setString(2, cpf);
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("====================================================");
                System.out.println("        SUCESSO: TELEFONE ALTERADO COM ÊXITO        ");
                System.out.println("====================================================");
            }
            else {
                System.out.println("==============================================================");
                System.out.println("        AVISO: NÃO HÁ NENHUM FUNCIONÁRIO COM ESTE CPF         ");
                System.out.println("==============================================================");
            }
        }
        catch (SQLException e) {
            throw new RuntimeException("ERRO AO ATUALIZAR TELEFONE DO FUNCIONÁRIO", e);
        }
    }

    public void atualizarEmailFuncionario(String cpf, String novoEmail) {
        String atualizacaoBanco =
                "UPDATE funcionarios " +
                        "SET email_funcionario = ? " +
                        "WHERE cpf_funcionario = ?";

        try (
                Connection conexaoBanco = ConexaoBd.getConnection();
                PreparedStatement stmt = conexaoBanco.prepareStatement(atualizacaoBanco);
        ) {
            stmt.setString(1, novoEmail);
            stmt.setString(2, cpf);
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("=================================================");
                System.out.println("        SUCESSO: EMAIL ALTERADO COM ÊXITO        ");
                System.out.println("=================================================");
            }
            else {
                System.out.println("===========================================================");
                System.out.println("        AVISO: NÃO HÁ NENHUM FUNCIONÁRIO COM ESTE CPF      ");
                System.out.println("===========================================================");
            }
        }
        catch (SQLException e) {
            throw new RuntimeException("ERRO AO ATUALIZAR EMAIL DO PACIENTE", e);
        }
    }

    public void atualizarAniversarioFuncionario(String cpf, String novaDataNascimento) {
        String atualizacaoBanco =
                "UPDATE pacientes " +
                        "SET data_nascimento_funcionario = ? " +
                        "WHERE cpf_funcionario = ?";

        try (
                Connection conexaoBanco = ConexaoBd.getConnection();
                PreparedStatement stmt = conexaoBanco.prepareStatement(atualizacaoBanco);
        ) {
            stmt.setString(1, novaDataNascimento);
            stmt.setString(2, cpf);
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("==============================================================");
                System.out.println("        SUCESSO: DATA DE NASCIMENTO ALTERADA COM ÊXITO        ");
                System.out.println("==============================================================");
            }
            else {
                System.out.println("==============================================================");
                System.out.println("        AVISO: NÃO HÁ NENHUM FUNCIONÁRIO COM ESTE CPF         ");
                System.out.println("==============================================================");
            }
        }
        catch (SQLException e) {
            throw new RuntimeException("ERRO AO ATUALIZAR DATA DE NASCIMENTO DO FUNCIONÁRIO", e);
        }
    }

    public void atualizarCargoFuncionario(String cpf, String novoCargo) {
        String atualizacaoBanco =
                "UPDATE funcionarios " +
                        "SET cargo_funcionario = ? " +
                        "WHERE cpf_funcionario = ?";

        try (
                Connection conexaoBanco = ConexaoBd.getConnection();
                PreparedStatement stmt = conexaoBanco.prepareStatement(atualizacaoBanco);
        ) {
            stmt.setString(1, novoCargo);
            stmt.setString(2, cpf);
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("=================================================");
                System.out.println("        SUCESSO: CARGO ALTERADO COM ÊXITO        ");
                System.out.println("=================================================");
            }
            else {
                System.out.println("===========================================================");
                System.out.println("        AVISO: NÃO HÁ NENHUM FUNCIONÁRIO COM ESTE CPF         ");
                System.out.println("===========================================================");
            }
        }
        catch (SQLException e) {
            throw new RuntimeException("ERRO AO ATUALIZAR CARGO DO FUNCIONÁRIO", e);
        }
    }

    public void atualizarDataContratadoFuncionario(String cpf, String novoCargo) {
        String atualizacaoBanco =
                "UPDATE funcionarios " +
                        "SET data_contratacao = ? " +
                        "WHERE cpf_funcionario = ?";

        try (
                Connection conexaoBanco = ConexaoBd.getConnection();
                PreparedStatement stmt = conexaoBanco.prepareStatement(atualizacaoBanco);
        ) {
            stmt.setString(1, novoCargo);
            stmt.setString(2, cpf);
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("================================================================");
                System.out.println("        SUCESSO: DATA DE CONTRATRAÇÃO ALTERADO COM ÊXITO        ");
                System.out.println("================================================================");
            }
            else {
                System.out.println("===========================================================");
                System.out.println("        AVISO: NÃO HÁ NENHUM FUNCIONÁRIO COM ESTE CPF         ");
                System.out.println("===========================================================");
            }
        }
        catch (SQLException e) {
            throw new RuntimeException("ERRO AO ATUALIZAR DATA DE CONTRATAÇÃO DO FUNCIONÁRIO", e);
        }
    }

    public void deletarFuncionario(String cpf) {
        String deletarFuncionarioBanco =
                "DELETE FROM funcionarios " +
                        "WHERE cpf_funcionario = ? ";

        try (
                Connection conexaoBanco = ConexaoBd.getConnection();
                PreparedStatement stmt = conexaoBanco.prepareStatement(deletarFuncionarioBanco);
        ) {

            stmt.setString(1, cpf);
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("=======================================================");
                System.out.println("        SUCESSO: FUNCIONÁRIO DELETADO COM ÊXITO        ");
                System.out.println("=======================================================");
            }
            else {
                System.out.println("==============================================================");
                System.out.println("        AVISO: NÃO HÁ NENHUM FUNCIONÁRIO COM ESTE CPF         ");
                System.out.println("==============================================================");
            }

        } catch (SQLException e) {
            throw new RuntimeException("ERRO AO EXCLUIR FUNCIONÁRIO", e);
        }
    }
}
