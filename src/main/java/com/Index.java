package com;
import javax.swing.JOptionPane;

import com.controller.Controller;
import com.view.TelaCadastro;
import com.view.TelaLogin;
import com.view.TelaPopupEmail;
import com.view.TelaPrincipal;
import com.view.TrocarSenha;

//import controller.Controller;
public class Index {
    private int codigo;
    private int codigoDigitado;
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
    public void TrocarSenha(){
        TrocarSenha trocarSenha = new TrocarSenha();
        trocarSenha.Trocar();
    }

    
    //----------------verificaçoes e acesso ao banco de dados e etc----------------
    Controller controller = new Controller();
    
    public int FormatandoDadosCadastro(String nome, String email, String senha){
        if (controller.setNome(nome)   == 0 || controller.setEmail(email) == 0 || controller.setSenha(senha) == 0) {
            JOptionPane.showMessageDialog(null, "nada inserido no bando de dados", "Erro", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        return 1;
    }
    public int FormatandoDadosLogin(String email){
        if (controller.setEmail(email) == 0 ) {
            JOptionPane.showMessageDialog(null, "email invalido", "Erro", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        return 1;
    }
    public int FormatandoDadosRedefinirSenha(String senha){
        if (controller.setSenha(senha) == 0) {
            JOptionPane.showMessageDialog(null, "senha invalida", "Erro", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        return 1;
    }

    public void enviarCodigo(String email){
        JOptionPane.showMessageDialog(null, "Um codigo esta sendo enviado, aguarde", "Sucesso", JOptionPane.ERROR_MESSAGE);
        this.codigo = controller.enviarCodigo(email);
    }

    public void TelaPopup(String email){
        int codigo = TelaPopupEmail.abrirPopup(null);
        this.codigoDigitado = codigo;
        
    }
    
    public int validarCodigo(){
        
       if (this.codigoDigitado != this.codigo) {
           JOptionPane.showMessageDialog(null, "Codigo Invalido!", "Erro", JOptionPane.ERROR_MESSAGE);
           return 0;
       }
       else{
           JOptionPane.showMessageDialog(null, "Codigo valido!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
           //controller.setInserir();
       }
        
       
       return 1;
        
    }
    
    public int inserindo(){
        controller.Criptografia();
        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        controller.setInserir();
            

        return 1;
        
    }

    public void AlterarSenha(){
        controller.Criptografia();
        controller.AlterarSenhaController();
        
    }


    
    public int VerificacaoExitoEmail(){
        System.out.println("chamou class email");
        if (controller.verificarApenasEmail() == 1){
            //email confirmado
            System.out.println("email confirmado");
            return 1;
            
        }
        return 0;
    }
    public int VerificacaoExitoSenha(String email, String senha){
        System.out.println("chamou class senha");
        if (controller.verificarSenha(email, senha) == 1){
            System.out.println("senha confirmado");
        //     JOptionPane.showMessageDialog(null, "Senha ja existe", "erro!", JOptionPane.ERROR_MESSAGE);
            return 1;
            
        }
        return 0;
    }
}
