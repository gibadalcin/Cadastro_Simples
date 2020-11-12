package domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author giba01
 */
public class Customer {
    private String nome,cpf,telefone,email;
    private int id,idade;
    
    public Customer(String nome,String cpf,int idade,String telefone,String email){
        this.nome=nome;
        this.cpf=cpf;
        this.idade=idade;
        this.telefone=telefone;
        this.email=email;
    }
    public Customer(int id,String nome,String cpf,int idade,String telefone,String email){
        this.id=id;
        this.nome=nome;
        this.cpf=cpf;
        this.idade=idade;
        this.telefone=telefone;
        this.email=email;
    }
    
    public Customer(){
        
    }
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
   public String getNome(){
       return nome;
   }
       public void setNome(String nome){
           this.nome = nome;
       }
       
    public String getCpf(){
       return cpf;
   }
       public void setCpf(String cpf){
           this.cpf = cpf;
       }
    
       public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
       
   public String getTelefone(){
       return telefone;
   }
       public void setTelefone(String telefone){
           this.telefone = telefone;
       }
       
   public String getEmail(){
       return email;
   }
       public void setEmail(String email){
           this.email = email;
       }    
    
}
