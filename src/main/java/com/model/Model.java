package com.model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import com.connect.Conexao;


public class Model {
    public void cadastrar(String nome, String email, String senha) {
        String sql = "INSERT INTO Usuarios ( nome, email, senha) VALUES ( ?, ?, ?)";

        PreparedStatement ps = null; 
        try {
            ps = Conexao.getConnection().prepareStatement(sql);  
            ps.setString(1, nome); 
            ps.setString(2, email);  
            ps.setString(3, senha);
            ps.execute();  
            System.out.println("Conexão: " + (System.currentTimeMillis()) + "ms");
            System.out.println("Cadastro realizado com sucesso!");  
            
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage()); 
        }
        
    }
    public int verificar(String email) {
        String sql = "SELECT email FROM Usuarios WHERE email = ?";

        PreparedStatement ps = null; 
        ResultSet rs = null;
        try {
            ps = Conexao.getConnection().prepareStatement(sql);  
            ps.setString(1, email);  
            rs = ps.executeQuery();
            if (rs.next()) {  
                return 1; 
            } else {
                  
            }
            return 0;
        } catch (SQLException e) {
            
            System.out.println("Erro ao verificar: " + e.getMessage());
        }
        return 0;
    }
    public int autenticar(String email, String senhaDigitada) {
    String sql = "SELECT senha FROM Usuarios WHERE email = ?";
    PreparedStatement ps = null;
    ResultSet rs = null;
        System.out.println("dentro do autenticar: " + senhaDigitada);
    try {
        ps = Conexao.getConnection().prepareStatement(sql);
        ps.setString(1, email);
        rs = ps.executeQuery();

        if (rs.next()) {
            String senhaHash = rs.getString("senha");

            // Aqui você usa o BCrypt para comparar a senha digitada com o hash
            if (BCrypt.checkpw(senhaDigitada, senhaHash)) {
                return 1; // senha correta
            } else {
                return 0; // senha incorreta
            }
        } else {
            return 0; // e-mail não encontrado
        }

    } catch (SQLException e) {
        System.out.println("Erro ao autenticar: " + e.getMessage());
        return 0;
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao fechar recursos: " + e.getMessage());
        }
    }
}

}
