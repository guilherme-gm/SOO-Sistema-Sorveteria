package br.unesp.rc.pinguim.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Command(url = "/InserirProduto")
public class InserirProduto implements ICommand {

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
		return new CommandResult("produto/inserir.jsp");
	}

}
