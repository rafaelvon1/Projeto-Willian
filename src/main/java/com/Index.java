package com;
import com.view.TelaPrincipal;
import com.view.TelaLogin;
import com.controller.Controller;
import com.view.TelaCadastro;
//import controller.Controller;
public class Index {
    public static void main(String[] args){
        TelaPrincipal telalogin = new TelaPrincipal();
        telalogin.TelaPrincipal();
    }
    public void inserindo(String email, char[] senha){
        Controller controller = new Controller();
        controller.setEmail(email);
        controller.setSenha(senha);
        controller.setInserir();
        
    }
    public void Login(){
        TelaLogin telalogin = new TelaLogin();
        telalogin.TelaLogin();
    }
    public void Cadastro(){
        TelaCadastro telaCadastro = new TelaCadastro();
        telaCadastro.TelaCadastro();
    }
    
}
