package br.com.matheus.vitacare.DAO;

import br.com.matheus.vitacare.database.ConexaoBd;
import br.com.matheus.vitacare.model.Consulta;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;

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
        String comandoSql =
                "SELECT " +
                        "c.id_consulta, " +
                        "p.nome_paciente, " +
                        "p.cpf_paciente, " +
                        "f.nome_funcionario AS nome_medico, " +
                        "m.crm_medico, " +
                        "m.especialidade_medica, " +
                        "c.data_consulta, " +
                        "c.hora_consulta, " +
                        "c.status_consulta " +
                        "FROM consultas c " +
                        "INNER JOIN pacientes p ON c.id_paciente = p.id_paciente" +
                        "INNER JOIN medicos m ON c.id_medico = m.id_funcionario" +
                        "INNER JOIN funcionarios f ON m.id_funcionario = f.id_funcionario";

        try (
                Connection conexaoBanco = ConexaoBd.getConnection();
                PreparedStatement stmt = conexaoBanco.prepareStatement(comandoSql);
                ) {

            ResultSet rs = stmt.executeQuery();
            boolean encontrarConsulta = false;
            while (rs.next()) {
                encontrarConsulta = true;
                int id = rs.getInt("id_consulta");
                String nomeP = rs.getString("nome_paciente");
                String cpf = rs.getString("cpf_paciente");
                String nomeM = rs.getString("nome_medico");
                String especialidade = rs.getString("especialidade_medica");
                Date data = rs.getDate("data_consulta");
                Time horario = rs.getTime("hora_consulta");
                String status = rs.getString("status_consulta");

                System.out.println("=================================================");
                System.out.println("ID: " + id);
                System.out.println("------------------------------------");
                System.out.println("NOME DO PACIENTE: " + nomeP);
                System.out.println("------------------------------------");
                System.out.println("CPF DO PACIENTE: " + cpf);
                System.out.println("------------------------------------");
                System.out.println("NOME DO MÉDICO: " + nomeM);
                System.out.println("------------------------------------");
                System.out.println("ESPECIALIDADE: " + especialidade);
                System.out.println("------------------------------------");
                System.out.println("DATA DA CONSULTA: " + data);
                System.out.println("------------------------------------");
                System.out.println("HORÁRIO DA CONSULTA: " + horario);
                System.out.println("------------------------------------");
                System.out.println("STATUS DA CONSULTA: " + status);
                System.out.println("=================================================");
            }
            if (!encontrarConsulta) {
                System.out.println("==========================================================");
                System.out.println("        AVISO: NÃO HÁ NENHUMA CONSULTA CADASTRADO         ");
                System.out.println("==========================================================");
            }

        }
        catch (SQLException e) {
            throw new RuntimeException("ERRO AO VISUALIZAR CONSULTAS CADASTRADAS", e);
        }
    }

    public void buscarConsultaPorId(int id) {
        String buscaNoBanco =
                "SELECT " +
                        "c.id_consulta, " +
                        "p.nome_paciente, " +
                        "p.cpf_paciente, " +
                        "f.nome_funcionario AS nome_medico, " +
                        "m.crm_medico, " +
                        "m.especialidade_medica, " +
                        "c.data_consulta, " +
                        "c.hora_consulta, " +
                        "c.status_consulta " +
                        "FROM consultas c " +
                        "INNER JOIN pacientes p ON c.id_paciente = p.id_paciente" +
                        "INNER JOIN medicos m ON c.id_medico = m.id_funcionario" +
                        "INNER JOIN funcionarios f ON m.id_funcionario = f.id_funcionario" +
                        "WHERE c.id_consulta = ?";

        try (
                Connection conexaoBanco = ConexaoBd.getConnection();
                PreparedStatement stmt = conexaoBanco.prepareStatement(buscaNoBanco);
        ) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int idC = rs.getInt("id_consulta");
                String nomeP = rs.getString("nome_paciente");
                String cpf = rs.getString("cpf_paciente");
                String nomeM = rs.getString("nome_medico");
                String especialidade = rs.getString("especialidade_medica");
                Date data = rs.getDate("data_consulta");
                Time horario = rs.getTime("hora_consulta");
                String status = rs.getString("status_consulta");

                System.out.println("=================================================");
                System.out.println("ID: " + idC);
                System.out.println("------------------------------------");
                System.out.println("NOME DO PACIENTE: " + nomeP);
                System.out.println("------------------------------------");
                System.out.println("CPF DO PACIENTE: " + cpf);
                System.out.println("------------------------------------");
                System.out.println("NOME DO MÉDICO: " + nomeM);
                System.out.println("------------------------------------");
                System.out.println("ESPECIALIDADE: " + especialidade);
                System.out.println("------------------------------------");
                System.out.println("DATA DA CONSULTA: " + data);
                System.out.println("------------------------------------");
                System.out.println("HORÁRIO DA CONSULTA: " + horario);
                System.out.println("------------------------------------");
                System.out.println("STATUS DA CONSULTA: " + status);
                System.out.println("=================================================");
            }
            else {
                System.out.println("==============================================================");
                System.out.println("        AVISO: NÃO HÁ CONSULTA COM ESTE ID CADASTRADO         ");
                System.out.println("==============================================================");
            }

        } catch (SQLException e) {
            throw new RuntimeException("ERRO AO BUSCAR MÉDICO", e);
        }
    }

    public void atualizarStatusConsulta(int idConsulta, String statusAtualizado) {
        String atualizacaoBanco =
                "UPDATE consultas " +
                        "SET status_consulta = ? " +
                        "WHERE id_consulta = ?";

        try (
                Connection conexaoBanco = ConexaoBd.getConnection();
                PreparedStatement stmt = conexaoBanco.prepareStatement(atualizacaoBanco);
                ) {

            stmt.setString(1, statusAtualizado);
            stmt.setInt(2, idConsulta);
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
            throw new RuntimeException("ERRO AO ATUALIZAR STATUS DA CONSULTA MÉDICA", e);
        }
    }

    public void atualizarDataConsulta(int idConsulta, LocalDate dataAtualizada) {
        String atualizacaoBanco =
                "UPDATE consultas " +
                        "SET data_consulta = ? " +
                        "WHERE id_consulta = ?";

        try(
                Connection conexaoBanco = ConexaoBd.getConnection();
                PreparedStatement stmt = conexaoBanco.prepareStatement(atualizacaoBanco);
                ) {

            stmt.setInt(1,idConsulta);
            stmt.setDate(2,Date.valueOf(dataAtualizada));
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("============================================================");
                System.out.println("        SUCESSO: DATA DE CONSULTA ALTERADA COM ÊXITO        ");
                System.out.println("============================================================");
            }
            else {
                System.out.println("==========================================================");
                System.out.println("        AVISO: NÃO HÁ NENHUA CONSULTA COM ESTE ID         ");
                System.out.println("==========================================================");
            }

        } catch (SQLException e) {
            throw new RuntimeException("ERRO AO ATUALIZAR DATA DA CONSULTA", e);
        }
    }

    public void atualizarHoraConsulta(int idConsulta, LocalTime horaAtualizada) {
        String atualizacaoBanco =
                "UPDATE consultas " +
                        "SET hora_consulta = ? " +
                        "WHERE id_consulta = ?";

        try () {

        }
        catch(SQLException e) {
            throw new RuntimeException("ERRO AO ATUALIZAR HORÁRIO DA CONSULTA", e);
        }
    }
}
