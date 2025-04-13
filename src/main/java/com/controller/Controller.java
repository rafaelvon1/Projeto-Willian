package com.controller;
import com.model.Model;

public class Controller{

   private String nome;
   private String email;
   private String senha;
   //--------------------------Filtrando parametros -----------------------------------



    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

   public String getEmail() {   
       return email;
   }
    public void setEmail(String email) {
         this.email = email;
    }
    //inserindo senha
    public String getSenha() {
        return senha;
    }   
    public void setSenha(String senha) {
        this.senha = senha;
    }    
    //--------------------------Filtrando parametros -----------------------------------
    
    //----------------------inserindo dados----------------
    public void setInserir(){
        Model cadastro = new Model(); 
        cadastro.cadastrar(this.nome, this.email, this.senha);
    }
}   
