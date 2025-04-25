package com;
import com.view.TelaPrincipal;
import com.view.TelaLogin;
import com.view.TelaPopupEmail;
import javax.swing.JOptionPane;
import com.controller.Controller;
import com.view.TelaCadastro;
//import controller.Controller;
public class Index {

    //----------------paginas principal login cadastro----------------
    public static void main(String[] args){
        TelaPrincipal telalogin = new TelaPrincipal();
        telalogin.Principal();
    }
    
    public void Login(){
        TelaLogin telalogin = new TelaLogin();
        telalogin.Login();
    }
    public void Cadastro(){
        TelaCadastro telaCadastro = new TelaCadastro();
        telaCadastro.Cadastro();

    }

    
    //----------------verificaçoes e acesso ao banco de dados e etc----------------
    Controller controller = new Controller();

    public int FormatandoDados(String nome, String email, String senha){
        if (controller.setSenha(senha)   == 0 || controller.setNome(nome) == 0 || controller.setEmail(email) == 0) {
            JOptionPane.showMessageDialog(null, "nada inserido no bando de dados", "Erro", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        else{

        }
        
        return 1;
    }



    public int validarCodigo(String email){
        if (controller.setEmail(email) == 0) {
            //pass
        }
        else{
            System.out.println("caiu aqui");
            TelaPopupEmail popup = new TelaPopupEmail(null, controller.getEmail(),controller.Validar(email));
            popup.setVisible(true);
            
        }
        return 0;
    }
    public void VerificacaoExito(String email, String senha){
        if (controller.setEmail(email) == 0 || controller.setSenha(senha) == 0) {
            JOptionPane.showMessageDialog(null, "nada inserido no bando de dados", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else{
            JOptionPane.showMessageDialog(null, "Login realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            controller.verificar();
            
            
        }
        
        ;

        //verificar se os baguio existe no banco de dados la fio
    }

    public int inserindo(String nome, String email, String senha){
        if (FormatandoDados(nome, email, senha) == 0) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        else{
            if (validarCodigo(email) == 0) {
                JOptionPane.showMessageDialog(null, "Erro ao validar o código!", "Erro", JOptionPane.ERROR_MESSAGE);
                return 0;
            }
            
        }
        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        controller.setInserir();
            

        return 1;
        
    }
    
}
