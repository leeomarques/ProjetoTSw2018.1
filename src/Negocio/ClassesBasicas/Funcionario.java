package Negocio.ClassesBasicas;

public class Funcionario {

    private String funcao;
    private String cpf;
    private String sexo;
    private String telefone;
    private String departamento;
    private String dataNascimento;
    private String nome;
    private Integer id;

    public Funcionario() {
        super();
    }

    public Funcionario(String nome, String cpf, String sexo, String telefone, String departamento, String dataNascimento, String funcao) {
       
        this.nome = nome;
        this.funcao = funcao;
        this.cpf = cpf;
        this.sexo = sexo;
        this.telefone = telefone;
        this.departamento = departamento;
        this.dataNascimento = dataNascimento;
        
    }

    public Funcionario(Integer id, String funcao, String cpf, String sexo, String telefone, String departamento, String dataNascimento, String nome) {
        this.funcao = funcao;
        this.cpf = cpf;
        this.sexo = sexo;
        this.telefone = telefone;
        this.departamento = departamento;
        this.dataNascimento = dataNascimento;
        this.nome = nome;
        this.id = id;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
