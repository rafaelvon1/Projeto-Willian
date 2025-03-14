package controller;

import model.Model;

public class Controller{
   private String email;
   private char[] senha;
   //inserindo email e
   public String getEmail() {   
       return email;
   }
    public void setEmail(String email) {
         this.email = email;
    }
    //inserindo senha
    public char[] getSenha() {
        return senha;
    }   
    public void setSenha(char[] senha) {
        this.senha = senha.clone();
    }    
    public void setInserir(){
        Model cadastro = new Model();
        cadastro.cadastrar(email, senha); 
    }
}   
