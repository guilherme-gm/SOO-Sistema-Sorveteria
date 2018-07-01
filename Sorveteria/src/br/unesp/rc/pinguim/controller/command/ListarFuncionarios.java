package br.unesp.rc.pinguim.controller.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unesp.rc.pinguim.models.Funcionario;

/**
 * Apresenta uma lista com todos os funcionários cadastrados
 */
@Command(url = "/ListarFuncionarios")
public class ListarFuncionarios implements ICommand {

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {

		// TODO : buscar no banco
		//ProdutoService ps = ServiceFactory.getProdutoService();

		List<Funcionario> funcionarios = new ArrayList<>();//ps.buscarTodos();
		funcionarios.add(new Funcionario());
		request.setAttribute("funcionarios", funcionarios);
		return new CommandResult("funcionario/listar.jsp");
	}

}
