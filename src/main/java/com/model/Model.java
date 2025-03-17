package com.model;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.connect.Conexao;


public class Model {
    public void cadastrar(String email, char[] senha) {
        String sql = "INSERT INTO teste (email, senha) VALUES (?, ?)";

        PreparedStatement ps = null; 
        try {
            ps = Conexao.getConnection().prepareStatement(sql);  
            ps.setString(1, email);  
            ps.setString(2, new String(senha));
            ps.execute();  
            System.out.println("Cadastro realizado com sucesso!");  
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage()); 
        }
        
    }
}
