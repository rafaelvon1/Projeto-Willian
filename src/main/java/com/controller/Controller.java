package com.controller;
import javax.swing.JOptionPane;
import org.mindrot.jbcrypt.BCrypt;
import com.VerificacaoEmail.ValidarEmail;
import com.model.Model;

public class Controller{

   private String nome;
   private String email;
   private String senha;
   //--------------------------Filtrando parametros -----------------------------------incio



     //--------------------------nome do usuario-----------------------------------
    public int setNome(String nome) {
        this.nome = nome;
        if (this.nome.length() < 3 ||  this.nome.length() > 15 ) { 
            JOptionPane.showMessageDialog(null, "O nome deve pelo menos estar entre 3 e 15 caracteres!", "Erro", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        else if (this.nome.matches(".*\\d.*") || this.nome.matches(".*[^a-zA-Z0-9].*")) {
            JOptionPane.showMessageDialog(null, "O nome não pode conter números ou caracteres especiais!", "Erro", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
        return 1;
    }

    //--------------------------email do usuario -----------------------------------
    public int setEmail(String email) {
         this.email = email;
         if (this.email.length() < 16) {
            JOptionPane.showMessageDialog(null, "O email invalido!", "Erro", JOptionPane.ERROR_MESSAGE);
            return 0;
    
        }
        else{
            if (!this.email.contains("@gmail.com") ) {
                JOptionPane.showMessageDialog(null, "E-mail inválido! Certifique-se de que contém '@' e '.'");
                return 0;
            }
        }
        return 1;
    }
   

     //--------------------------senha do usuario -----------------------------------
    public int setSenha(String senha) {
        this.senha = senha;
        if (this.senha.length() < 8 || !this.senha.matches(".*[0-9].*") || !this.senha.contains("@")) {
            JOptionPane.showMessageDialog(null, "Senha fraca! A senha deve ter no mínimo 8 caracteres, incluir pelo menos 1 número e o caractere '@'");
            return 0;
        }
        else{
            if (this.senha.length() > 15) {
                JOptionPane.showMessageDialog(null, "Senha muito longa! A senha deve ter no máximo 15 caracteres.");
                return 0;
            }
        }
        return 1;
    }  
    public void Criptografia() {
        this.senha = BCrypt.hashpw(this.senha, BCrypt.gensalt());
        
        
    }  
    //--------------------------Filtrando parametros -----------------------------------fim
    
    //----------------------inserindo dados----------------inicio
    public void setInserir(){
        Model cadastro = new Model(); 
        cadastro.cadastrar(this.nome, this.email, this.senha);
    }
    //----------------------inserindo dados----------------fim
    //----------------------verificando dados----------------inicio
    public int verificarApenasEmail(){
        Model verificar = new Model(); 
        return verificar.verificar(this.email);
    }
    public int verificarSenha(String email){
        Model verificar = new Model(); 
        return verificar.autenticar(email , senha);
    }
    public int enviarCodigo(String email) {
        ValidarEmail validar = new ValidarEmail(); 
        return validar.validar(email);
    }
}   
