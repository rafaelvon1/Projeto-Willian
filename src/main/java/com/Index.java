package com;
import com.view.TelaPrincipal;
import com.view.TelaLogin;
import com.view.TelaPopupEmail;
import javax.swing.JOptionPane;
import com.controller.Controller;
import com.view.TelaCadastro;
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

    
    //----------------verificaçoes e acesso ao banco de dados e etc----------------
    Controller controller = new Controller();
    
    public int FormatandoDados(String nome, String email, String senha){
        if (controller.setNome(nome)   == 0 || controller.setEmail(email) == 0 || controller.setSenha(senha) == 0) {
            JOptionPane.showMessageDialog(null, "nada inserido no bando de dados", "Erro", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        else{

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
    
    public int inserindo(String nome, String email, String senha){
        controller.Criptografia();
        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        controller.setInserir();
            

        return 1;
        
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
        
    
        //verificar se os baguio existe no banco de dados la fio
    }
    
}
