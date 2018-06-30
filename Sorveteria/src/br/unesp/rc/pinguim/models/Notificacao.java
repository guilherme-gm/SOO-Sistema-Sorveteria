package br.unesp.rc.pinguim.models;

import java.util.Date;

/**
 * Define uma notifica��o de estoque baixo
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
	 * Retorna o c�digo da notifica��o
	 * 
	 * @return o c�digo
	 */
	public long getCodigo() {
		return codigo;
	}

	/**
	 * Defien o c�digo da notifica��o
	 * 
	 * @param codigo
	 *            o c�digo
	 */
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	/**
	 * Retorna a data da notifica��o
	 * 
	 * @return data que a notifica��o foi emitida
	 */
	public Date getData() {
		return data;
	}

	/**
	 * Define a data que a notifica��o foi emitida
	 * 
	 * @param data
	 *            data que foi emitida
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * Retorna se a notifica��o foi lida
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
	 * Retorna o produto associado a notifica��o
	 * 
	 * @return
	 */
	public Produto getProduto() {
		return produto;
	}

	/**
	 * Define o produto associado a notifica��o
	 * 
	 * @param produto
	 */
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
