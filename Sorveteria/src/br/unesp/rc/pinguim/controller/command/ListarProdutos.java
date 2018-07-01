package br.unesp.rc.pinguim.controller.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unesp.rc.pinguim.models.Produto;
import br.unesp.rc.pinguim.service.ProdutoService;
import br.unesp.rc.pinguim.service.ServiceFactory;

/**
 * Apresenta uma lista com todos os produtos cadastrados
 */
@Command(url = "/ListarProdutos")
public class ListarProdutos implements ICommand {

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {

		ProdutoService ps = ServiceFactory.getProdutoService();

		List<Produto> produtos = ps.buscarTodos();
		request.setAttribute("produtos", produtos);
		return new CommandResult("produto/listar.jsp");
	}

}
