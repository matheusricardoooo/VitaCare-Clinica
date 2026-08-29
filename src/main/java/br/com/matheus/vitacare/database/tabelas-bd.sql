CREATE TABLE pacientes (
	id_paciente SERIAL PRIMARY KEY,
	nome_paciente VARCHAR(100) NOT NULL,
	telefone_paciente VARCHAR(20) NOT NULL,
	cpf_paciente VARCHAR(11) NOT NULL UNIQUE,
	email_paciente VARCHAR(100),
	data_nascimento_paciente DATE NOT NULL
);

CREATE TABLE funcionarios (
	id_funcionario SERIAL PRIMARY KEY,
	nome_funcionario VARCHAR(100) NOT NULL,
	telefone_funcionario VARCHAR(20) NOT NULL,
	cpf_funcionario VARCHAR(11) NOT NULL UNIQUE,
	email_funcionario VARCHAR(100),
	data_nascimento_funcionario DATE NOT NULL,
	cargo_funcionario VARCHAR(50) NOT NULL,
	data_contratacao DATE NOT NULL
);

CREATE TABLE medicos (
	id_funcionario INT PRIMARY KEY,
	crm_medico VARCHAR(20) NOT NULL UNIQUE,
	especialidade_medica VARCHAR(50) NOT NULL,

	CONSTRAINT fk_medico_funcionario
        FOREIGN KEY (id_funcionario)
        REFERENCES funcionarios(id_funcionario)
);

CREATE TABLE consultas (
	id_consulta SERIAL PRIMARY KEY,
	id_paciente INT NOT NULL,
	id_medico INT NOT NULL,
	data_consulta DATE NOT NULL,
	hora_consulta TIME NOT NULL,
	status_consulta VARCHAR(20) NOT NULL,

	CONSTRAINT fk_consulta_paciente
		FOREIGN KEY(id_paciente)
		REFERENCES pacientes(id_paciente),

	CONSTRAINT fk_consulta_medico
		FOREIGN KEY(id_medico)
		REFERENCES medicos(id_funcionario)
);