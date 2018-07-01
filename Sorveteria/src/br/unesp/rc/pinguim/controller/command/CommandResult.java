package br.unesp.rc.pinguim.controller.command;

public class CommandResult {

	private String page;
	private String template;
	private boolean redirect;
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
