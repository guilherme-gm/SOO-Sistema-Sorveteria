package br.unesp.rc.pinguim.controller.exception;

import br.unesp.rc.pinguim.models.Funcionario;

/**
 * Exceção de quando o usuário tenta acessar um endereço que não é permitido
 * para este
 */
public class AccessDeniedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * URL para onde o usuário será redirecionado
	 */
	private String url;

	/**
	 * Funcionário que causou a exceção (null se não é um usuário logado)
	 */
	private Funcionario funcionario;

	public AccessDeniedException(String url, Funcionario funcionario) {
		this.url = url;
		this.funcionario = funcionario;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

}
