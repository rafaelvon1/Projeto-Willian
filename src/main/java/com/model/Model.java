package com.model;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.connect.Conexao;


public class Model {
    public Integer cadastrar(String nome, String email, String senha) {
        String sql = "INSERT INTO Usuarios ( nome, email, senha) VALUES ( ?, ?, ?)";

        PreparedStatement ps = null; 
        try {
            ps = Conexao.getConnection().prepareStatement(sql);  
            ps.setString(1, nome); 
            ps.setString(2, email);  
            ps.setString(3, senha);
            ps.execute();  
            System.out.println("Cadastro realizado com sucesso!");  
        } catch (SQLException e) {
            return 0;
        }
        return 1;
    }
}
