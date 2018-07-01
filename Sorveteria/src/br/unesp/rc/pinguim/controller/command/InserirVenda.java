package br.unesp.rc.pinguim.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Abre a página para registrar uma venda
 */
@Command(url = "/InserirVenda")
public class InserirVenda implements ICommand {

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
		return new CommandResult("venda/registrar.jsp");
	}

}
