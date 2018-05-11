package Negocio.ClassesBasicas;

public class Fornecedor {
    private String cnpj;
    private String razao;
    private String fantasia;
    private String contato;
    private String email;
    private String telefone;
    private int id;
    private char status;
    
    public Fornecedor() {
    
    }
 
    public Fornecedor(String cnpj, String razao, String fantasia, 
                      String contato, String email, String telefone, int id) {
        this.cnpj     = cnpj;
        this.razao    = razao;
        this.fantasia = fantasia;
        this.contato  = contato;
        this.email    = email;
        this.telefone = telefone;
        this.id       = id;
    }
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazao() {
        return razao;
    }

    public void setRazao(String razao) {
        this.razao = razao;
    }

    public String getFantasia() {
        return fantasia;
    }

    public void setFantasia(String fantasia) {
        this.fantasia = fantasia;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }
}
