package Negocio.ClassesBasicas;

/**
 *
 * @author rafael
 */
public class Produto {

    private String descricaoProduto;
    private double valorProduto;
    private String quantidadeProduto;
    private int idFornecedorProduto;
    private int idProduto;
    private String nomeFornecedor;

    public Produto() {
        super();
    }

    public Produto(String descricaoProduto, double valorProduto, String quantidadeProduto, int idFornecedorProduto, int idProduto) {
        this.descricaoProduto = descricaoProduto;
        this.valorProduto = valorProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.idFornecedorProduto = idFornecedorProduto;
        this.idProduto = idProduto;
    }

    public Produto(String descricaoProduto, double valorProduto, String quantidadeProduto, int idFornecedorProduto) {
        this.descricaoProduto = descricaoProduto;
        this.valorProduto = valorProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.idFornecedorProduto = idFornecedorProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public String getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(String quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public int getIdFornecedorProduto() {
        return idFornecedorProduto;
    }

    public void setIdFornecedorProduto(int idFornecedorProduto) {
        this.idFornecedorProduto = idFornecedorProduto;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * @return the nomeFornecedor
     */
    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    /**
     * @param nomeFornecedor the nomeFornecedor to set
     */
    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

}
