# 🏥 VitaCare

Sistema de gerenciamento para uma clínica médica, desenvolvido em **Java** com integração ao **PostgreSQL** utilizando **JDBC**.

O projeto tem como objetivo simular as necessidades de um sistema real de gestão clínica, permitindo o gerenciamento de pacientes, funcionários, médicos, consultas, prontuários e receitas.

Além de desenvolver as funcionalidades do sistema, o projeto está sendo utilizado como forma de aprofundar conhecimentos em **Programação Orientada a Objetos, Java, SQL, JDBC, modelagem de banco de dados e arquitetura em camadas**.

---

## 📌 Sobre o projeto

O **VitaCare** surgiu como um projeto prático para aplicar conceitos de desenvolvimento Back-end em Java.

A proposta é desenvolver um sistema capaz de centralizar informações de uma clínica médica, permitindo o cadastro e gerenciamento dos principais elementos envolvidos no atendimento de pacientes.

O sistema possui entidades relacionadas entre si, reproduzindo uma estrutura semelhante à encontrada em uma aplicação real.

A estrutura principal do sistema é baseada nos seguintes elementos:

* 👤 Pacientes
* 👨‍💼 Funcionários
* 👨‍⚕️ Médicos
* 📅 Consultas

---

## 🎯 Objetivos

O principal objetivo do projeto é desenvolver uma aplicação Back-end utilizando Java e banco de dados relacional.

Durante o desenvolvimento, os seguintes conceitos estão sendo praticados:

* Programação Orientada a Objetos;
* Encapsulamento;
* Construtores;
* Getters e Setters;
* Organização em camadas;
* JDBC;
* CRUD;
* SQL;
* PostgreSQL;
* Chaves primárias e estrangeiras;
* Relacionamentos entre tabelas;
* `INNER JOIN`;
* `PreparedStatement`;
* Tratamento de exceções;
* Manipulação de datas e horários;
* Organização e reutilização de código;
* Boas práticas de desenvolvimento.

---

# 🛠️ Tecnologias utilizadas

### Java

Linguagem principal utilizada para desenvolvimento da aplicação.

### PostgreSQL

Banco de dados relacional responsável pelo armazenamento das informações do sistema.

### JDBC

Utilizado para realizar a comunicação entre a aplicação Java e o PostgreSQL.

### IntelliJ IDEA

IDE utilizada durante o desenvolvimento do projeto.

### Git e GitHub

Utilizados para versionamento e gerenciamento do código-fonte.

---

# 🏗️ Estrutura do projeto

O projeto está sendo organizado de forma a separar as responsabilidades de cada parte da aplicação.

```text
src
└── main
    └── java
        └── br.com.matheus.vitacare
            │
            ├── model
            │   ├── Paciente.java
            │   ├── Funcionario.java
            │   ├── Medico.java
            │   ├── Consulta.java

            │
            ├── dao
            │   ├── PacienteDAO.java
            │   ├── FuncionarioDAO.java
            │   ├── MedicoDAO.java
            │   ├── ConsultaDAO.java

            │
            ├── menu
            │   ├── MenuPrincipal.java
            │   ├── MenuPaciente.java
            │   ├── MenuFuncionario.java
            │   ├── MenuMedico.java
            │   ├── MenuConsulta.java

            │
            ├── config
            │   └── ConexaoBd.java
            │
            └── Main.java
```

> A estrutura pode sofrer alterações conforme o desenvolvimento e a evolução da arquitetura do projeto.

---

# 📦 Model

O pacote `model` contém as classes que representam as entidades do sistema.

Cada classe possui seus respectivos atributos, seguindo o princípio de **encapsulamento** através da utilização de atributos `private`.

Exemplo:

```java
public class Paciente {

    private int idPaciente;
    private String nomePaciente;
    private String telefonePaciente;
    private String cpfPaciente;
    private String emailPaciente;
    private LocalDate dataNascimentoPaciente;
}
```

Os atributos são acessados de maneira controlada através dos métodos apropriados.

As classes também possuem construtores para permitir a criação e inicialização dos objetos.

---

# 🗄️ DAO

O pacote `dao` é responsável pela comunicação direta entre a aplicação Java e o banco de dados PostgreSQL.

As classes DAO utilizam **JDBC** e `PreparedStatement` para executar os comandos SQL.

Cada entidade possui sua própria DAO.

### PacienteDAO

Responsável pelo gerenciamento dos pacientes.

Funcionalidades:

* Cadastrar paciente;
* Listar pacientes;
* Buscar paciente pelo CPF;
* Atualizar dados cadastrais.

### FuncionarioDAO

Responsável pelo gerenciamento dos funcionários.

Funcionalidades:

* Cadastrar funcionário;
* Listar funcionários;
* Buscar funcionário;
* Atualizar dados cadastrais.

Os funcionários possuem informações como:

* Nome;
* Telefone;
* CPF;
* E-mail;
* Data de nascimento;
* Cargo;
* Data de contratação.

### MedicoDAO

Responsável pelo gerenciamento dos médicos.

Funcionalidades:

* Cadastrar médico;
* Listar médicos;
* Buscar médico pelo CRM;
* Atualizar especialidade médica.

A entidade `Medico` possui um relacionamento com `Funcionario`, utilizando o `id_funcionario`.

### ConsultaDAO

Responsável pelo gerenciamento das consultas médicas.

Funcionalidades planejadas/implementadas:

* Criar consulta;
* Listar consultas;
* Buscar consulta;
* Atualizar dados da consulta;
* Atualizar status da consulta;
* Atualizar data da consulta;
* Atualizar horário da consulta;
* Excluir consulta.

As consultas possuem relacionamento com pacientes e médicos.

---

# 🗃️ Banco de dados

O VitaCare utiliza o **PostgreSQL** como banco de dados relacional.

As principais tabelas são:

```text
pacientes
funcionarios
medicos
consultas
prontuarios
receitas
```

## Relacionamentos

A estrutura do banco possui os seguintes relacionamentos:

```text
FUNCIONARIOS
      │
      │ 1 : 1
      ▼
   MEDICOS
      │
      │ 1 : N
      ▼
 CONSULTAS
    ▲     ▲
    │     │
    │     │
    │     │
PACIENTES

CONSULTAS
    │
    │ 1 : N
    ▼
PRONTUARIOS
    │
    │ 1 : N
    ▼
RECEITAS
```

### Funcionário → Médico

Um médico é vinculado a um funcionário através do `id_funcionario`.

```sql
FOREIGN KEY (id_funcionario)
REFERENCES funcionarios(id_funcionario)
```

Isso permite que os dados específicos do médico sejam armazenados separadamente dos dados gerais do funcionário.

### Consulta → Paciente

Cada consulta pertence a um paciente.

```sql
FOREIGN KEY (id_paciente)
REFERENCES pacientes(id_paciente)
```

### Consulta → Médico

Cada consulta também possui um médico responsável.

```sql
FOREIGN KEY (id_medico)
REFERENCES medicos(id_funcionario)
```

---

# 🔗 Uso de INNER JOIN

Como algumas informações estão distribuídas em diferentes tabelas, o projeto utiliza `INNER JOIN` para recuperar informações relacionadas.

Por exemplo, para listar consultas, é possível relacionar:

```text
consultas
   │
   ├── pacientes
   │
   └── medicos
          │
          └── funcionarios
```

Isso permite que a aplicação apresente informações completas, como:

```text
Consulta: 15
Paciente: João da Silva
CPF: 12345678900
Médico: Carlos Oliveira
CRM: 12345
Especialidade: Cardiologia
Data: 20/08/2026
Horário: 14:30
Status: AGENDADA
```

---

# 🔐 PreparedStatement

As operações com banco de dados utilizam `PreparedStatement`.

Exemplo:

```java
String sql =
        "SELECT * FROM pacientes " +
        "WHERE cpf_paciente = ?";

PreparedStatement stmt =
        conexaoBanco.prepareStatement(sql);

stmt.setString(1, cpf);
```

Essa abordagem permite trabalhar com parâmetros de forma mais segura e organizada, evitando a concatenação direta de valores fornecidos pelo usuário nas consultas SQL.

---

# 🔄 Operações CRUD

O projeto utiliza o conceito de **CRUD** para o gerenciamento das entidades.

| Operação | Significado | Exemplo            |
| -------- | ----------- | ------------------ |
| Create   | Criar       | Cadastrar paciente |
| Read     | Ler         | Listar pacientes   |
| Update   | Atualizar   | Alterar telefone   |
| Delete   | Excluir     | Excluir consulta   |

Essas operações são implementadas nas classes DAO de acordo com as necessidades de cada entidade.

---

# 🖥️ Menus

O sistema está sendo estruturado para possuir menus específicos para cada funcionalidade.

Exemplo:

```text
=====================================
              VITACARE
=====================================

1 - Pacientes
2 - Funcionários
3 - Médicos
4 - Consultas
0 - Sair
```

Cada módulo possui seu próprio menu, permitindo organizar melhor a interação com o usuário.

Exemplo:

```text
=====================================
          MENU DE PACIENTES
=====================================

1 - Cadastrar paciente
2 - Listar pacientes
3 - Buscar paciente por CPF
4 - Atualizar dados
0 - Voltar
```

Essa organização tem como objetivo evitar que toda a lógica de interação fique concentrada na classe `Main`.

---

# 📅 Tipos de dados

O projeto também utiliza tipos específicos do Java para representar determinadas informações.

### Datas

Para datas no Model:

```java
LocalDate
```

Exemplo:

```java
private LocalDate dataNascimentoPaciente;
```

Na comunicação com o PostgreSQL, a conversão é realizada quando necessário:

```java
Date.valueOf(data);
```

### Horários

Para horários:

```java
LocalTime
```

E na comunicação com o banco:

```java
Time.valueOf(horario);
```

Essa separação permite utilizar a API moderna de datas e horários do Java no Model e realizar a conversão necessária na camada DAO.

---

# 📚 Conceitos de POO aplicados

O projeto está sendo desenvolvido como uma forma prática de estudar e aplicar conceitos de **Programação Orientada a Objetos**.

Entre eles:

### Encapsulamento

Os atributos das entidades são definidos como `private`:

```java
private String nomePaciente;
```

O acesso é realizado através de métodos apropriados.

### Construtores

Os construtores são utilizados para inicializar objetos no momento de sua criação.

```java
public Paciente(
        String nomePaciente,
        String telefonePaciente,
        String cpfPaciente
) {
    this.nomePaciente = nomePaciente;
    this.telefonePaciente = telefonePaciente;
    this.cpfPaciente = cpfPaciente;
}
```

### Organização de responsabilidades

O projeto busca separar responsabilidades entre diferentes camadas:

```text
Menu
  ↓
Model
  ↓
DAO
  ↓
Banco de dados
```

Essa organização facilita a manutenção e evolução do sistema.

---

# 🚧 Status do projeto

🟡 **Em desenvolvimento**

O projeto está sendo construído gradualmente.

Funcionalidades já desenvolvidas incluem:

* [x] Estrutura inicial do projeto;
* [x] Model de Paciente;
* [x] DAO de Paciente;
* [x] CRUD/Operações de Paciente;
* [x] Model de Funcionário;
* [x] DAO de Funcionário;
* [x] Model de Médico;
* [x] DAO de Médico;
* [x] Model de Consulta;
* [x] Estrutura de consultas SQL com `INNER JOIN`;
* [x] Operações de criação, leitura e atualização de consultas;
* [ ] Finalização dos menus;
* [ ] Melhorias na arquitetura;
* [ ] Implementação de novas validações;
* [ ] Melhorias na experiência do usuário.

---

# 💡 Aprendizados

O VitaCare está sendo desenvolvido principalmente como um projeto de aprendizado prático.

Durante seu desenvolvimento, estou buscando entender não apenas **como fazer uma funcionalidade funcionar**, mas também **por que determinada estrutura ou tecnologia deve ser utilizada**.

O projeto vem permitindo praticar conceitos como:

```text
Java
   ↓
Programação Orientada a Objetos
   ↓
JDBC
   ↓
SQL
   ↓
PostgreSQL
   ↓
Relacionamentos
   ↓
Arquitetura de aplicação
```

A cada nova funcionalidade, o objetivo é evoluir tanto o sistema quanto a qualidade e organização do código.

---

# 👨‍💻 Autor

**Matheus Ricardo da Silva Pereira**

Desenvolvedor Back-end em formação, atualmente aprofundando conhecimentos em Java, Programação Orientada a Objetos, JDBC, SQL e desenvolvimento de aplicações Back-end.

🔗 LinkedIn: [linkedin.com/in/matheusricardodev](https://linkedin.com/in/matheusricardodev)

🔗 GitHub: [github.com/matheusricardoooo](https://github.com/matheusricardoooo)

---

## 📄 Licença

Este projeto foi desenvolvido para fins de **estudo e aprendizado**.
