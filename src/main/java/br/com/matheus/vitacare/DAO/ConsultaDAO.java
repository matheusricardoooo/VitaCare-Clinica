package br.com.matheus.vitacare.DAO;

import br.com.matheus.vitacare.model.Consulta;

public class ConsultaDAO {
    public void criarConsulta(Consulta consulta) {
        String comandoSql =
                "INSERT INTO consultas " +
                        "(id_consulta, id_paciente, id_medico, data_consulta) " +
                        "(hora_consulta, status_consulta ) " +
                        "VALUES(?, ?, ?, ?, ?, ?)";
    }
}
