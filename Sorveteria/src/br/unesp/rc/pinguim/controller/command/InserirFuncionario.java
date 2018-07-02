package br.unesp.rc.pinguim.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Exibe o formulário para inserir um funcionário
 */
@Command(url = "/InserirFuncionario")
public class InserirFuncionario implements ICommand {

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
		return new CommandResult("funcionario/inserir.jsp");
	}

}
