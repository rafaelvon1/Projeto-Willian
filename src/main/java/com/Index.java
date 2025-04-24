package com;
import com.view.TelaPrincipal;
import com.view.TelaLogin;

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

    
    //----------------verificaçoes acesso ao banco de dados e etc----------------
    Controller controller = new Controller();
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

    public void inserindo(String nome, String email, String senha){
        
        
        if (controller.setSenha(senha)   == 0 || controller.setNome(nome) == 0 || controller.setEmail(email) == 0) {
            JOptionPane.showMessageDialog(null, "nada inserido no bando de dados", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        else{
            if (controller.Validar(email) == 0) {
                JOptionPane.showMessageDialog(null, "E-mail já cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
                
            }
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            controller.setInserir();
            
        }
        
    }
    
}
