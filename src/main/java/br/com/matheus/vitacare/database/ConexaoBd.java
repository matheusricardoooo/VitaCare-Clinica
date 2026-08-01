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
        // objeto criado para guardas as chaves recebidas do config.properties
        Properties properties = new Properties();

        // abre o arquivo config como fluxo de leitura e fecha automaticamente
        try (InputStream input = ConexaoBd.class.getClassLoader().getResourceAsStream("config.properties")) {
            // verifica se o arquivo foi encontrado
            if (input != null) {
                // se não foi encontrado o programa é interrompido avisando o problema
                throw new RuntimeException("Arquivo config.properties não encontrado");
            }
            // adiciona o conteúdo do config no objeto properties
            properties.load(input);
        }
        // alerta erro de leitura do arquivo
        catch (IOException e) {
            throw new RuntimeException("ERRO AO LER O ARQUIVO DE CONFIGURAÇÃO", e);
        }

        // ler os valores da chave do config (url,usuario,senha)
        String url = properties.getProperty("url");
        String usuario = properties.getProperty("usuario");
        String senha = properties.getProperty("senha");

    }
}
