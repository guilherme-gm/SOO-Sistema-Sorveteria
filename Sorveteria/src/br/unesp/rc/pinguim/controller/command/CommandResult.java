package br.unesp.rc.pinguim.controller.command;

import br.unesp.rc.pinguim.controller.SrvController;

/**
 * Resultado da execução de um comando, usado por {@link SrvController}
 */
public class CommandResult {

	/**
	 * Página que será carregada, no caso de redirecionamento, a url
	 */
	private String page;

	/**
	 * O template usado (arquivo jsp na raiz da pasta web)
	 */
	private String template;

	/**
	 * Se este resultado é um redirecionamento
	 */
	private boolean redirect;

	/**
	 * Se este comando deve apresentar um JSON como resultado (apresentando o json
	 * do objeto no atributo "json".
	 */
	private boolean isJson;

	public CommandResult() {
		this.page = "";
		this.template = "index.jsp";
		this.redirect = false;
		this.isJson = false;
	}

	public CommandResult(String page) {
		this.page = page;
		this.template = "index.jsp";
		this.redirect = false;
		this.isJson = false;
	}

	public CommandResult(String page, boolean redirect) {
		super();
		this.page = page;
		this.redirect = redirect;
		this.isJson = false;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public boolean isRedirect() {
		return redirect;
	}

	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}

	public boolean isJson() {
		return isJson;
	}

	public void setJson(boolean isJson) {
		this.isJson = isJson;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

}
