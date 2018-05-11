package Negocio.ClassesBasicas;

public class Usuario {
    private String Login;
    private String Senha;
    private int ID;
    
    public Usuario(){
        
    }
    
    public Usuario(String Login, String Senha){
        this.Login = Login;
        this.Senha = Senha;
    }

    public String getLogin() {
        return Login;
    }
   
    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
