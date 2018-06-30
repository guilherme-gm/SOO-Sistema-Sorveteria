package br.unesp.rc.pinguim.models;

import java.util.Date;

/**
 * Define uma notificação de estoque baixo
 */
public class Notificacao {

	private long codigo;
	private Date data;
	private boolean lido;
	private Produto produto;

	public Notificacao() {
		super();
	}

	/**
	 * Retorna o código da notificação
	 * 
	 * @return o código
	 */
	public long getCodigo() {
		return codigo;
	}

	/**
	 * Defien o código da notificação
	 * 
	 * @param codigo
	 *            o código
	 */
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	/**
	 * Retorna a data da notificação
	 * 
	 * @return data que a notificação foi emitida
	 */
	public Date getData() {
		return data;
	}

	/**
	 * Define a data que a notificação foi emitida
	 * 
	 * @param data
	 *            data que foi emitida
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * Retorna se a notificação foi lida
	 * 
	 * @return
	 */
	public boolean isLido() {
		return lido;
	}

	/**
	 * Determina o estado de lido.
	 * 
	 * @param lido
	 */
	public void setLido(boolean lido) {
		this.lido = lido;
	}

	/**
	 * Retorna o produto associado a notificação
	 * 
	 * @return
	 */
	public Produto getProduto() {
		return produto;
	}

	/**
	 * Define o produto associado a notificação
	 * 
	 * @param produto
	 */
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
