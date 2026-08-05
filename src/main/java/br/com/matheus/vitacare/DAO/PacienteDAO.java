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
                        "(nome_paciente, telefone_paciente, cpf_paciente," +
                        " email_paciente,data_nascimento_paciente)" +
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

    public void listarPacientesCadastrados() {

        String consultaSql = "SELECT * FROM pacientes";

        try (
            Connection conexaoBanco = ConexaoBd.getConnection();
            PreparedStatement stmt = conexaoBanco.prepareStatement(consultaSql)
        ) {

            ResultSet rs = stmt.executeQuery();
            boolean buscaPorCadastros = false;
            while (rs.next()) {
                buscaPorCadastros = true;
                int id = rs.getInt("id_paciente");
                String nome = rs.getString("nome_paciente");
                String telefone = rs.getString("telefone_paciente");
                String cpf = rs.getString("cpf_paciente");
                String email = rs.getString("email_paciente");
                Date data = rs.getDate("data_nascimento_pasciente");

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
                System.out.println("DATA NASCIMENTO: " + data);
                System.out.println("=================================================");
            }
            if (!buscaPorCadastros) {
                System.out.println("========================================================");
                System.out.println("        AVISO: NÃO HÁ NENHUM USUÁRIO CADASTRADO         ");
                System.out.println("========================================================");
            }

        }
        catch (SQLException e) {
            throw new RuntimeException("ERRO AO CADASTRAR PACIENTE", e);
        }
    }
    public void buscarPacientePorCpf(String cpf) {
        String buscaNoBanco =
                "SELECT * FROM pacientes" +
                "WHERE cpf_paciente = ?";

        try (
                Connection conexaoBanco = ConexaoBd.getConnection();
                PreparedStatement stmt = conexaoBanco.prepareStatement(buscaNoBanco);
        ) {

            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id_paciente");
                String nome = rs.getString("nome_paciente");
                String telefone = rs.getString("telefone_paciente");
                String Cpf = rs.getString("cpf_paciente");
                String email = rs.getString("email_paciente");
                Date data = rs.getDate("data_nascimento_paciente");

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
                System.out.println("=================================================");
            }
            else {
                System.out.println("===============================================================");
                System.out.println("        AVISO: NÃO HÁ PACIENTE CADASTRADO COM ESTE CPF         ");
                System.out.println("===============================================================");
            }

        } catch (SQLException e) {
            throw new RuntimeException("ERRO AO BUSCAR PACIENTE", e);
        }
    }

    public void atualizarNomePaciente(String cpf, String novoNome) {
        String atualizacaoBanco =
                "UPDATE pacientes " +
                "SET nome_paciente = ? " +
                "WHERE cpf_paciente = ?";

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
                System.out.println("===========================================================");
                System.out.println("        AVISO: NÃO HÁ NENHUM PACIENTE COM ESTE CPF         ");
                System.out.println("===========================================================");
            }
        }
        catch (SQLException e) {
            throw new RuntimeException("ERRO AO ATUALIZAR NOME DO PACIENTE", e);
        }
    }

    public void atualizarTelefonePaciente(String cpf, String novoTelefone) {
        String atualizacaoBanco =
                "UPDATE pacientes " +
                        "SET telefone_paciente = ? " +
                        "WHERE cpf_paciente = ?";

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
                System.out.println("===========================================================");
                System.out.println("        AVISO: NÃO HÁ NENHUM PACIENTE COM ESTE CPF         ");
                System.out.println("===========================================================");
            }
        }
        catch (SQLException e) {
            throw new RuntimeException("ERRO AO ATUALIZAR TELEFONE DO PACIENTE", e);
        }
    }
}
