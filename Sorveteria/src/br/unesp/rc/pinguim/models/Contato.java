package br.unesp.rc.pinguim.models;

/**
 * Define um Contato
 */
public class Contato {

	private String telefone;
	private String celular;
	private String email;

	/**
	 * Define o valor de telefone
	 * 
	 * @param telefone
	 *            : telefone de Contato
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * Retorna o valor de telefone de Contato
	 * 
	 * @return Retorna o valor de telefone
	 */
	public String getTelefone() {
		return this.telefone;
	}

	/**
	 * Define o valor de celular
	 * 
	 * @param celular
	 *            : celular de Contato
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}

	/**
	 * Retorna o valor de celular de Contato
	 * 
	 * @return Retorna o valor de celular
	 */
	public String getCelular() {
		return this.celular;
	}

	/**
	 * Define o valor de email
	 * 
	 * @param email
	 *            : email de Contato
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Retorna o valor de email de Contato
	 * 
	 * @return Retorna o valor de email
	 */
	public String getEmail() {
		return this.email;
	}

}
