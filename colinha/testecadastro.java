package view;
import connect.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import controller.Controller;
public class testecadastro {
    public void cadastrar(Controller controller) {
        String sql = "INSERT INTO teste (email, senha) VALUES (?, ?)";

        PreparedStatement ps = null; 
        try {
            ps = Conexao.getConnection().prepareStatement(sql);  
            ps.setString(1, controller.getEmail());  
            ps.setString(2, new String(controller.getSenha()));
            ps.execute();  
            System.out.println("Cadastro realizado com sucesso!");  
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage()); 
        }
        
    }
}
