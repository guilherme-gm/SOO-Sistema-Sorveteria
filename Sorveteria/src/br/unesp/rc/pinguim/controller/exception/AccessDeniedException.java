package br.unesp.rc.pinguim.controller.exception;

/**
 * Exceção de quando o usuário tenta acessar um endereço que não é permitido
 * para este
 */
public class AccessDeniedException extends Exception {

	/**
	 * URL para onde o usuário será redirecionado
	 */
	private String url;

	public AccessDeniedException(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
