package br.unesp.rc.pinguim.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.unesp.rc.pinguim.models.Pagamento;
import br.unesp.rc.pinguim.models.Venda;
import br.unesp.rc.pinguim.service.ServiceFactory;
import br.unesp.rc.pinguim.service.VendaService;

@Command(url = "/DoInserirPagamento")
public class DoInserirPagamento implements ICommand {

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();

		if (session == null) {
			return new CommandResult("index.jsp", true);
		}

		Venda venda = (Venda) session.getAttribute("venda");

		if (venda == null) {
			return new CommandResult("", true);
		}

		/* Carrega o metodo do pagamento */
		Pagamento pagamento = new Pagamento(request.getParameter("metodoPagamento"));
		venda.setPagamento(pagamento);

		VendaService vs = ServiceFactory.getVendaService();
		if (vs.salvar(venda)) {
			return new CommandResult("index.jsp", true);
		} else {
			return new CommandResult("venda/pagamento.jsp");
		}
	}

}
