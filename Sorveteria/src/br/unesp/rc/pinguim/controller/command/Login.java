package br.unesp.rc.pinguim.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Exibe o formulário de login
 */
@Command(url = "/Login")
public class Login implements ICommand {

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
		CommandResult cr = new CommandResult();
		cr.setTemplate("login.jsp");
		return cr;
	}

}