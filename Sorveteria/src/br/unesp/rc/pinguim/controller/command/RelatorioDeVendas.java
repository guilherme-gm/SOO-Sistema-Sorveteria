package br.unesp.rc.pinguim.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unesp.rc.pinguim.controller.exception.AccessDeniedException;
import br.unesp.rc.pinguim.service.ServiceFactory;
import br.unesp.rc.pinguim.service.VendaService;

/**
 * Exibe um relatório das vendas
 */
@Command(url = "/RelatorioDeVendas")
public class RelatorioDeVendas implements ICommand {

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response)
			throws AccessDeniedException {

		VendaService vs = ServiceFactory.getVendaService();

		request.setAttribute("vendas", vs.buscarTodos());
		return new CommandResult("venda/relatorio.jsp");
	}

}
