/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio.ClassesBasicas;

/**
 *
 * @author Júnior
 */
public class ListaVendaProduto {
    private String DescricaoProduto;
    private int QuantidadeProduto;
    private double ValorProduto; 

    public ListaVendaProduto(String DescricaoProduto, int QuantidadeProduto, double ValorProduto) {
        this.DescricaoProduto = DescricaoProduto;
        this.QuantidadeProduto = QuantidadeProduto;
        this.ValorProduto = ValorProduto;
    }

    public String getDescricaoProduto() {
        return DescricaoProduto;
    }

    public void setDescricaoProduto(String DescricaoProduto) {
        this.DescricaoProduto = DescricaoProduto;
    }

    public int getQuantidadeProduto() {
        return QuantidadeProduto;
    }

    public void setQuantidadeProduto(int QuantidadeProduto) {
        this.QuantidadeProduto = QuantidadeProduto;
    }

    public double getValorProduto() {
        return ValorProduto;
    }

    public void setValorProduto(double ValorProduto) {
        this.ValorProduto = ValorProduto;
    }
    
}
