package br.unesp.rc.pinguim.models;


/**
 * Define um Produto
 */
public class Produto {

    private long codigo;
    private String nome;
    private CategoriaProduto categoria;
    private int quantidadeEstoque;
    private int estoqueMinimo;
    private Double precoVenda;
    private Double precoCompra;

    /**
     * Define o valor de codigo
     * @param codigo : codigo da Produto
     */
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    /**
     * Retorna o valor de codigo da Produto
     * @return Retorna o valor de codigo
     */
    public long getCodigo() {
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
     * @param precoCompra : precoCompra do Produto
     */
    public void setPrecoCompra(Double precoCompra) {
        this.precoCompra = precoCompra;
    }

    /**
     * Retorna o valor de precoCompra do Produto
     * @return Retorna o valor de precoCompra
     */
    public Double getPrecoCompra() {
        return this.precoCompra;
    }

    /**
     * Retorna o valor de quantidadeEstoque do Produto
     * @return Retorna o valor de quatidadeCompra
     */
	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	/**
	 * Define o valor de quantidadeEstoque 
	 * @param quantidadeEstoque : quantidadeEstoque do Produto
	 */
	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", nome=" + nome + ", categoria=" + categoria + ", quantidadeEstoque="
				+ quantidadeEstoque + ", estoqueMinimo=" + estoqueMinimo + ", precoVenda=" + precoVenda
				+ ", precoCompra=" + precoCompra + "]";
	} 
    
	
	
    
}

