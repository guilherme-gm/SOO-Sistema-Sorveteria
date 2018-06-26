package br.unesp.rc.pinguim.controller.command;

public class CommandResult {

	private String page;
	private boolean redirect;

	public CommandResult(String page) {
		this.page = page;
		this.redirect = false;
	}

	public CommandResult(String page, boolean redirect) {
		super();
		this.page = page;
		this.redirect = redirect;
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

}
