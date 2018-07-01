package br.unesp.rc.pinguim.controller.command;

public class InserirFuncionario implements ICommand {
	
	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
		return new CommandResult("funcionario/inserir.jsp");
	}

}
