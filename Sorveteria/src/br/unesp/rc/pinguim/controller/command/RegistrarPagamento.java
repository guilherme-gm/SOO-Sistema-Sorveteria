package br.unesp.rc.pinguim.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Command(url = "/RegistrarPagamento")
public class RegistrarPagamento implements ICommand {

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
		return new CommandResult("venda/pagamento.jsp");
	}
	
	

}
