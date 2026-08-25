package br.com.matheus.vitacare.DAO;

import br.com.matheus.vitacare.database.ConexaoBd;
import br.com.matheus.vitacare.model.Medico;

import java.sql.*;

public class MedicoDAO {
    public void cadastrarMedico(Medico medico) {
        String comandoSql =
                "INSERT INTO medicos " +
                        "(id_funcionario, crm_medico, especialidade_medica) " +
                        "VALUES(?, ?, ?)";

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

    public void listarMedicoCadastrado() {
        String consultaSql =
                /*"Pegue os registros de medicos e encontre, na tabela funcionarios,
                o funcionário que possui o mesmo id_funcionario."*/
                "SELECT " +
                        "m.id_funcionario, " +
                        "f.nome_funcionario, " +
                        "f.telefone_funcionario, " +
                        "m.crm_medico, " +
                        "m.especialidade_medica " +
                        "FROM medicos m " +
                        "INNER JOIN funcionarios f " +
                        "ON m.id_funcionario = f.id_funcionario";

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
                String crm = rs.getString("crm_medico");
                String especialidade = rs.getString("especialidade_medica");

                System.out.println("=================================================");
                System.out.println("ID: " + id);
                System.out.println("------------------------------------");
                System.out.println("NOME: " + nome);
                System.out.println("------------------------------------");
                System.out.println("TELEFONE: " + telefone);
                System.out.println("------------------------------------");
                System.out.println("CRM: " + crm);
                System.out.println("------------------------------------");
                System.out.println("ESPECIALIDADE: " + especialidade);
                System.out.println("=================================================");
            }
            if (!buscaPorCadastros) {
                System.out.println("=======================================================");
                System.out.println("        AVISO: NÃO HÁ NENHUM MÉDICO CADASTRADO         ");
                System.out.println("========================================================");
            }

        }
        catch (SQLException e) {
            throw new RuntimeException("ERRO AO CADASTRAR MÉDICO", e);
        }
    }

    public void buscarMedicoPorCrm(String crm) {
        String buscaNoBanco =
                "SELECT " +
                        "m.id_funcionario, " +
                        "f.nome_funcionario, " +
                        "f.telefone_funcionario, " +
                        "m.crm_medico, " +
                        "m.especialidade_medica " +
                        "FROM medicos m " +
                        "INNER JOIN funcionarios f " +
                        "ON m.id_funcionario = f.id_funcionario " +
                        "WHERE m.crm_medico = ?";

        try (
                Connection conexaoBanco = ConexaoBd.getConnection();
                PreparedStatement stmt = conexaoBanco.prepareStatement(buscaNoBanco);
        ) {

            stmt.setString(1, crm);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id_funcionario");
                String nome = rs.getString("nome_funcionario");
                String telefone = rs.getString("telefone_funcionario");
                String crmDoutor = rs.getString("crm_medico");
                String especialidade = rs.getString("especialidade_medica");

                System.out.println("=================================================");
                System.out.println("ID: " + id);
                System.out.println("------------------------------------");
                System.out.println("NOME: " + nome);
                System.out.println("------------------------------------");
                System.out.println("TELEFONE: " + telefone);
                System.out.println("------------------------------------");
                System.out.println("CRM: " + crmDoutor);
                System.out.println("------------------------------------");
                System.out.println("ESPECIALIDADE: " + especialidade);
                System.out.println("=================================================");
            }
            else {
                System.out.println("=============================================================");
                System.out.println("        AVISO: NÃO HÁ MÉDICO CADASTRADO COM ESTE CPF         ");
                System.out.println("=============================================================");
            }

        } catch (SQLException e) {
            throw new RuntimeException("ERRO AO BUSCAR MÉDICO", e);
        }
    }

    public void atualizarEspecialidade(String crm, String novaEspecialidade) {
        
    }
}
