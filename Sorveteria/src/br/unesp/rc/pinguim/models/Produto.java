package br.unesp.rc.pinguim.models;


/**
 * Define um Produto
 */
public class Produto {

    private int codigo;
    private String nome;
    private CategoriaProduto categoria;
    private int estoqueMinimo;
    private Double precoVenda;
    private Double precoCompra;

    /**
     * Define o valor de codigo
     * @param codigo : codigo da Produto
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Retorna o valor de codigo da Produto
     * @return Retorna o valor de codigo
     */
    public int getCodigo() {
        return this.codigo;
    } 
    
    /**
     * Define o valor de nome
     * @param nome : nome da Produto
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o valor de nome da Produto
     * @return Retorna o valor de nome
     */
    public String getNome() {
        return this.nome;
    } 
    
    /**
     * Define o valor de categoria
     * @param categoria : categoria da Produto
     */
    public void setCategoria(CategoriaProduto categoria) {
        this.categoria = categoria;
    }

    /**
     * Retorna o valor de categoria da Produto
     * @return Retorna o valor de categoria
     */
    public CategoriaProduto getCategoria() {
        return this.categoria;
    } 
    
    /**
     * Define o valor de estoqueMinimo
     * @param estoqueMinimo : estoqueMinimo da Produto
     */
    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    /**
     * Retorna o valor de estoqueMinimo da Produto
     * @return Retorna o valor de estoqueMinimo
     */
    public int getEstoqueMinimo() {
        return this.estoqueMinimo;
    } 
    
    /**
     * Define o valor de precoVenda
     * @param precoVenda : precoVenda da Produto
     */
    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    /**
     * Retorna o valor de precoVenda da Produto
     * @return Retorna o valor de precoVenda
     */
    public Double getPrecoVenda() {
        return this.precoVenda;
    } 
    
    /**
     * Define o valor de precoCompra
     * @param precoCompra : precoCompra da Produto
     */
    public void setPrecoCompra(Double precoCompra) {
        this.precoCompra = precoCompra;
    }

    /**
     * Retorna o valor de precoCompra da Produto
     * @return Retorna o valor de precoCompra
     */
    public Double getPrecoCompra() {
        return this.precoCompra;
    } 
    
}

