package br.unesp.rc.pinguim.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unesp.rc.pinguim.service.ProdutoService;
import br.unesp.rc.pinguim.service.ServiceFactory;

/**
 * Busca produto a partir do nome dado em "nome" e retornando uma lista em JSON
 */
@Command(url = "/BuscaProdutoPorNome")
public class BuscaProdutoPorNome implements ICommand {

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
		String nome = request.getParameter("nome");
		ProdutoService ps = ServiceFactory.getProdutoService();

		request.setAttribute("json", ps.buscar("%" + nome + "%"));

		CommandResult rs = new CommandResult("");
		rs.setJson(true);
		return rs;
	}

}
