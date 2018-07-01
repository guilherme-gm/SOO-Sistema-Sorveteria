package br.unesp.rc.pinguim.models;


/**
 * Define um ItemVenda
 */
public class ItemVenda {

    private int quantidade;
    private Double valorUnidade;
    private Produto produto;

    
    public ItemVenda(int quantidade, Double valorUnidade, Produto produto) {
		super();
		this.quantidade = quantidade;
		this.valorUnidade = valorUnidade;
		this.produto = produto;
	}

	/**
     * Define o valor de quantidade
     * @param quantidade : quantidade do ItemVenda
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Retorna o valor de quantidade do ItemVenda
     * @return Retorna o valor de quantidade
     */
    public int getQuantidade() {
        return this.quantidade;
    } 
    
    /**
     * Define o valor de valorUnidade
     * @param valorUnidade : valorUnidade do ItemVenda
     */
    public void setValorUnidade(Double valorUnidade) {
        this.valorUnidade = valorUnidade;
    }

    /**
     * Retorna o valor de valorUnidade do ItemVenda
     * @return Retorna o valor de valorUnidade
     */
    public Double getValorUnidade() {
        return this.valorUnidade;
    }

    /**
     * Retorna o produto do ItemVenda
     * @return Retorna o produto 
     */
	public Produto getProduto() {
		return produto;
	}

	/**
	 * Define o produto do ItemVenda
	 * @param produto : produto do ItemVenda
	 */
	public void setProduto(Produto produto) {
		this.produto = produto;
	} 
    
    
	
    
}

