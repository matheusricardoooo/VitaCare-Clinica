package br.com.matheus.vitacare.DAO;

import br.com.matheus.vitacare.database.ConexaoBd;
import br.com.matheus.vitacare.model.Medico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedicoDAO {
    public void cadastrarMedico(Medico medico) {
        String comandoSql =
                "INSERT INTO medicos" +
                        "crm_medico, especialidade_medica";
    }
}
