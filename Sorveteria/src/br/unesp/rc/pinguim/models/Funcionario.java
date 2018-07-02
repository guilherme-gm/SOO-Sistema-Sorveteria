package br.unesp.rc.pinguim.models;

import java.util.Date;

/**
 * Define um Funcionario
 */
public class Funcionario {

	private long codigo;
	private String nome;
	private Endereco endereco;
	private Contato contato;
	private String cpf;
	private Date dataNascimento;
	private Cargo cargo;
	private Acesso acesso;

	/**
	 * Define o valor de codigo
	 * 
	 * @param codigo
	 *            : codigo de Funcionario
	 */
	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	/**
	 * Retorna o valor de codigo de Funcionario
	 * 
	 * @return Retorna o valor de codigo
	 */
	public long getCodigo() {
		return this.codigo;
	}

	/**
	 * Define o valor de nome
	 * 
	 * @param nome
	 *            : nome de Funcionario
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna o valor de nome de Funcionario
	 * 
	 * @return Retorna o valor de nome
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * Define o valor de endereco
	 * 
	 * @param endereco
	 *            : endereco de Funcionario
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	/**
	 * Retorna o valor de endereco de Funcionario
	 * 
	 * @return Retorna o valor de endereco
	 */
	public Endereco getEndereco() {
		return this.endereco;
	}

	/**
	 * Define o valor de contato
	 * 
	 * @param contato
	 *            : contato de Funcionario
	 */
	public void setContato(Contato contato) {
		this.contato = contato;
	}

	/**
	 * Retorna o valor de contato de Funcionario
	 * 
	 * @return Retorna o valor de contato
	 */
	public Contato getContato() {
		return this.contato;
	}

	/**
	 * Define o valor de cpf
	 * 
	 * @param cpf
	 *            : cpf de Funcionario
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * Retorna o valor de cpf de Funcionario
	 * 
	 * @return Retorna o valor de cpf
	 */
	public String getCpf() {
		return this.cpf;
	}

	/**
	 * Define o valor de dataNascimento
	 * 
	 * @param dataNascimento
	 *            : dataNascimento de Funcionario
	 */
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/**
	 * Retorna o valor de dataNascimento de Funcionario
	 * 
	 * @return Retorna o valor de dataNascimento
	 */
	public Date getDataNascimento() {
		return this.dataNascimento;
	}

	/**
	 * Define o valor de cargo
	 * 
	 * @param cargo
	 *            : cargo de Funcionario
	 */
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	/**
	 * Retorna o valor de cargo de Funcionario
	 * 
	 * @return Retorna o valor de cargo
	 */
	public Cargo getCargo() {
		return this.cargo;
	}

	public Acesso getAcesso() {
		return this.acesso;
	}

	public void setAcesso(Acesso acesso) {
		this.acesso = acesso;
	}

}
