package br.unesp.rc.pinguim.models;

/**
 * Define um ItemVenda
 */
public class ItemVenda {

	private int quantidade;
	private double valorUnidade;
	private Produto produto;

	public ItemVenda(int quantidade, double valorUnidade, Produto produto) {
		super();
		this.quantidade = quantidade;
		this.valorUnidade = valorUnidade;
		this.produto = produto;
	}

	/**
	 * Define o valor de quantidade
	 * 
	 * @param quantidade
	 *            : quantidade do item vendido
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	/**
	 * Retorna o valor de quantidade do item vendido
	 * 
	 * @return Retorna o valor de quantidade
	 */
	public int getQuantidade() {
		return this.quantidade;
	}

	/**
	 * Define o valor unitário
	 * 
	 * @param valorUnidade
	 *            : valor unitário do item vendido
	 */
	public void setValorUnidade(double valorUnidade) {
		this.valorUnidade = valorUnidade;
	}

	/**
	 * Retorna o valor unitaário do item vendido
	 * 
	 * @return Retorna o valor unitário
	 */
	public double getValorUnidade() {
		return this.valorUnidade;
	}

	/**
	 * Retorna o produto do item vendido
	 * 
	 * @return Retorna o produto
	 */
	public Produto getProduto() {
		return produto;
	}

	/**
	 * Define o produto do item vendido
	 * 
	 * @param produto
	 *            : produto
	 */
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "ItemVenda [quantidade=" + quantidade + ", valorUnidade=" + valorUnidade + ", produto=" + produto + "]";
	}

}
