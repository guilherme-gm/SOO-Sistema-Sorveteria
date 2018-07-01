package br.unesp.rc.pinguim.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unesp.rc.pinguim.models.Funcionario;
import br.unesp.rc.pinguim.service.FuncionarioService;
import br.unesp.rc.pinguim.service.ServiceFactory;

/**
 * Exibe o formul�rio para atualizar um funcion�rio. Recebe o c�digo do
 * funcion�rio por par�metro
 */
@Command(url = "/AtualizarFuncionario")
public class AtualizarFuncionario implements ICommand {

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
		if (request.getParameter("codigo") == null) {
			// TODO : Adicionar mensagem de erro?
			return new CommandResult("ListarFuncionarios", true);
		}

		long codigo = Long.parseLong(request.getParameter("codigo"));

		FuncionarioService fs = ServiceFactory.getFuncionarioService();

		Funcionario func = fs.buscar(codigo);
		request.setAttribute("funcionario", func);
		return new CommandResult("funcionario/atualizar.jsp");
	}

}
