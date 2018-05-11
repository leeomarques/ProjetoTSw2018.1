/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.ClassesBasicas;

public class Venda {

    private int IDVenda;
    private int IDCliente;
    private int IDFuncionario;
    private double ValorTotal;

    public Venda() {
        super();
    }

    public Venda(int IDVenda, int IDCliente, int IDFuncionario, double ValorTotal) {
        this.IDVenda = IDVenda;
        this.IDCliente = IDCliente;
        this.IDFuncionario = IDFuncionario;
        this.ValorTotal = ValorTotal;
    }

    public Venda(int IDCliente, int IDFuncionario, double ValorTotal) {
        this.IDCliente = IDCliente;
        this.IDFuncionario = IDFuncionario;
        this.ValorTotal = ValorTotal;
    }

    public int getIDVenda() {
        return IDVenda;
    }

    public void setIDVenda(int IDVenda) {
        this.IDVenda = IDVenda;
    }

    public int getIDCliente() {
        return IDCliente;
    }

    public void setIDCliente(int IDCliente) {
        this.IDCliente = IDCliente;
    }

    public int getIDFuncionario() {
        return IDFuncionario;
    }

    public void setIDFuncionario(int IDFuncionario) {
        this.IDFuncionario = IDFuncionario;
    }

    public double getValorTotal() {
        return ValorTotal;
    }

    public void setValorTotal(double ValorTotal) {
        this.ValorTotal = ValorTotal;
    }
}
