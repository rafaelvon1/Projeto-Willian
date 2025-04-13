package com;
import com.view.TelaPrincipal;
import com.view.TelaLogin;
import com.controller.Controller;
import com.view.TelaCadastro;
//import controller.Controller;
public class Index {

    //----------------paginas principal login cadastro----------------
    public static void main(String[] args){
        TelaPrincipal telalogin = new TelaPrincipal();
        telalogin.TelaPrincipal();
    }
    
    public void Login(){
        TelaLogin telalogin = new TelaLogin();
        telalogin.TelaLogin();
    }
    public void Cadastro(){
        TelaCadastro telaCadastro = new TelaCadastro();
        telaCadastro.TelaCadastro();

    }

    
    //----------------verificaçoes acesso ao banco de dados e etc----------------
    public void VerificacaoExito(){
        //verificar se os baguio existe no banco de dados la fio
    }

    public void inserindo(String nome, String email, String senha){
        Controller controller = new Controller();
        controller.setNome(nome);
        controller.setEmail(email);
        controller.setSenha(senha);
        controller.setInserir();
        
    }
    
}
