package br.com.matheus.vitacare.database;

// vai representar a conexão aberta com o banco de dados
import java.sql.Connection;
// vai encontrar o driver jdbc que o maven baixou
import java.sql.DriverManager;
// vai realizar o tratamento de exceções caso aconteça
import java.sql.SQLException;
// vai ler arquivo de configuração (config.properties)
import java.util.Properties;
// cria um fluxo para que o conteúdo do arquivo config.properties possa ser lido.
import java.io.InputStream;
// serve para tratamento de erro de leitura do arquivo configuração
import java.io.IOException;

public class ConexaoBd {

    public static Connection getConnection() {

    }
}
