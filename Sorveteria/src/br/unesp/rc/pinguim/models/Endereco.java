package br.unesp.rc.pinguim.models;

/**
 * Define um Endereco
 */
public class Endereco {

	private String rua;
	private String numero;
	private String cep;
	private String cidade;
	private String estado;

	/**
	 * Define o valor de rua
	 * 
	 * @param rua
	 *            : rua de Endereco
	 */
	public void setRua(String rua) {
		this.rua = rua;
	}

	/**
	 * Retorna o valor de rua de Endereco
	 * 
	 * @return Retorna o valor de rua
	 */
	public String getRua() {
		return this.rua;
	}

	/**
	 * Define o valor de numero
	 * 
	 * @param numero
	 *            : numero de Endereco
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * Retorna o valor de numero de Endereco
	 * 
	 * @return Retorna o valor de numero
	 */
	public String getNumero() {
		return this.numero;
	}

	/**
	 * Define o valor de cep
	 * 
	 * @param cep
	 *            : cep de Endereco
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * Retorna o valor de cep de Endereco
	 * 
	 * @return Retorna o valor de cep
	 */
	public String getCep() {
		return this.cep;
	}

	/**
	 * Define o valor de cidade
	 * 
	 * @param cidade
	 *            : cidade de Endereco
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * Retorna o valor de cidade de Endereco
	 * 
	 * @return Retorna o valor de cidade
	 */
	public String getCidade() {
		return this.cidade;
	}

	/**
	 * Define o valor de estado
	 * 
	 * @param estado
	 *            : estado de Endereco
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * Retorna o valor de estado de Endereco
	 * 
	 * @return Retorna o valor de estado
	 */
	public String getEstado() {
		return this.estado;
	}

}
