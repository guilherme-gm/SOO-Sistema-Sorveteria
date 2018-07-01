package br.unesp.rc.pinguim.controller.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unesp.rc.pinguim.models.Funcionario;
import br.unesp.rc.pinguim.service.FuncionarioService;
import br.unesp.rc.pinguim.service.ServiceFactory;

/**
 * Apresenta uma lista com todos os funcionários cadastrados
 */
@Command(url = "/ListarFuncionarios")
public class ListarFuncionarios implements ICommand {

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {

		FuncionarioService fs = ServiceFactory.getFuncionarioService();
		
		List<Funcionario> funcionarios = fs.buscarTodos();
		request.setAttribute("funcionarios", funcionarios);
		
		return new CommandResult("funcionario/listar.jsp");
	}

}
