package br.unesp.rc.pinguim.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Exibe a págian de Sobre
 */
@Command(url = "/Sobre")
public class Sobre implements ICommand {

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
		return new CommandResult("sobre.jsp");
	}

}
