
package Negocio.ClassesBasicas;

public class ListaVenda {
    private int IDVenda;
    private String NomeCliente;
    private String NomeFuncionario;
    private double ValorVenda;

    public ListaVenda(int IDVenda, String NomeCliente, String NomeFuncionario, double ValorVenda) {
        this.IDVenda = IDVenda;
        this.NomeCliente = NomeCliente;
        this.NomeFuncionario = NomeFuncionario;
        this.ValorVenda = ValorVenda;
    }

    public int getIDVenda() {
        return IDVenda;
    }

    public void setIDVenda(int IDVenda) {
        this.IDVenda = IDVenda;
    }

    public String getNomeCliente() {
        return NomeCliente;
    }

    public void setNomeCliente(String NomeCliente) {
        this.NomeCliente = NomeCliente;
    }

    public String getNomeFuncionario() {
        return NomeFuncionario;
    }

    public void setNomeFuncionario(String NomeFuncionario) {
        this.NomeFuncionario = NomeFuncionario;
    }

    public double getValorVenda() {
        return ValorVenda;
    }

    public void setValorVenda(double ValorVenda) {
        this.ValorVenda = ValorVenda;
    }
    
}
