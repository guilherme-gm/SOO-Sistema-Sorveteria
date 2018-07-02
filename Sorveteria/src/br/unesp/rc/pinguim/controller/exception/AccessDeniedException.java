package br.unesp.rc.pinguim.controller.exception;

/**
 * Exce��o de quando o usu�rio tenta acessar um endere�o que n�o � permitido
 * para este
 */
public class AccessDeniedException extends Exception {

	/**
	 * URL para onde o usu�rio ser� redirecionado
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
