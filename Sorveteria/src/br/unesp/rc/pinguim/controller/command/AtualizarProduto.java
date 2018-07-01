package br.unesp.rc.pinguim.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unesp.rc.pinguim.models.Produto;
import br.unesp.rc.pinguim.service.ProdutoService;
import br.unesp.rc.pinguim.service.ServiceFactory;

/**
 * Exibe o formulário para atualizar um produto
 */
@Command(url = "/AtualizarProduto")
public class AtualizarProduto implements ICommand {

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {

		if (request.getParameter("codigo") == null) {
			return new CommandResult("ListarProdutos", true);
		}

		long codigo = Long.parseLong(request.getParameter("codigo"));

		ProdutoService ps = ServiceFactory.getProdutoService();

		Produto produto = ps.buscar(codigo);
		request.setAttribute("produto", produto);
		return new CommandResult("produto/atualizar.jsp");
	}

}
