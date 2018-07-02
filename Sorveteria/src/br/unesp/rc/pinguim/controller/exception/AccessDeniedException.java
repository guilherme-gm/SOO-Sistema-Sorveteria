package br.unesp.rc.pinguim.controller.exception;

import br.unesp.rc.pinguim.models.Funcionario;

/**
 * Exce��o de quando o usu�rio tenta acessar um endere�o que n�o � permitido
 * para este
 */
public class AccessDeniedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * URL para onde o usu�rio ser� redirecionado
	 */
	private String url;

	/**
	 * Funcion�rio que causou a exce��o (null se n�o � um usu�rio logado)
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
