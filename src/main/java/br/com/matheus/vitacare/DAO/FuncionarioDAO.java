package br.com.matheus.vitacare.DAO;

import br.com.matheus.vitacare.model.Funcionario;

public class FuncionarioDAO {
    public void cadastrarFuncionario(Funcionario funcionario) {
        String comandoSql =
                "INSERT INTO funcionarios" +
                        "nome_funcionario, telefone_funcionario, cpf_funcionario " +
                        "email_funcionario, data_nascimento_funcionario, cargo_funcionario " +
                        "data_contratado";
    }
}
