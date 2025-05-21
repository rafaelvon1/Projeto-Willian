package com.connect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = System.getenv("URL_Java");
    private static final String USER = System.getenv("USER_Java");
    private static final String PASSWORD = System.getenv("PASSWORD_Java");
    
    public static Connection  getConnection() {
        
        try {
            // Carrega o driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Retorna a conexão
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            //Erro ao carregar o driver JDBC:
            System.out.println("Erro ao carregar o driver JDBC: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
            
        }
        return null;
    }

    public static void main(String[] args) {
        Connection connection = getConnection();
        if (connection != null) {
            System.out.println("Conexão bem-sucedida!");
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        } else {
            System.out.println("Falha na conexão.");
        }
    }
}
