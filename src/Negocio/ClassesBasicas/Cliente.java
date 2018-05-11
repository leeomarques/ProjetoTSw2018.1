
package Negocio.ClassesBasicas;


public class Cliente {
    
    private String nome;
    private String cpf;
    private String endereco;
    private String email;
    private String nasc;
    private String telefone;
    private String sexo;
    private int id;
   
    
    
      public Cliente (String nome, String cpf, String endereco, String email, String nasc, String telefone,String sexo, int id){
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.nasc = nasc;
        this.telefone = telefone;
        this.sexo = sexo;
        this.id = id;
        

}

    public Cliente() {
       
    }
    
    public void setNome (String nome){
     this.nome = nome;
    
    }
    
    public String getNome (){
     return nome;
    
    }
    
    public void setCpf(String cpf){
    this.cpf = cpf;
   
    }
    
    public String getCpf(){
       return cpf;
     } 
    
    public void setEndereco(String endereco){
    this.endereco = endereco;
    
    }
    
    
    public String getEndereco(){
     return endereco;
    }
    
    public void setEmail(String email){
    this.email = email;
    
    }
    
    public String getEmail(){
    return email;
   
    }
    
    
    public void setNasc(String nasc){
    this.nasc = nasc;
   
    }
    
    
    public String getNasc(){
    return nasc;
    
    }
    
    
    public void setTelefone(String telefone){
     this.telefone = telefone;
    
    }
    
    public String getTelefone(){
     return telefone;
    
    }
    
    public void setSexo(String sexo){
        this.sexo = sexo;
    }
    
    public String getSexo(){
        return sexo;
    }
    
    public void setID(int id){
    this.id = id;
    }
    
    public int getID(){
    return id;
    }
    
        
}        
        
    
    

