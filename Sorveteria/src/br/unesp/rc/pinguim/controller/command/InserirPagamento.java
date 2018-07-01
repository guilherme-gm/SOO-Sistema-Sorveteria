package br.unesp.rc.pinguim.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.unesp.rc.pinguim.models.Venda;

@Command(url = "/InserirPagamento")
public class InserirPagamento implements ICommand {

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();

		if (session == null) {
			return new CommandResult("", true);
		}

		Venda venda = (Venda) session.getAttribute("venda");

		if (venda == null) {
			return new CommandResult("", true);
		}

		request.setAttribute("total", venda.getTotal());
		
		return new CommandResult("venda/pagamento.jsp");
	}

}
