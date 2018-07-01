package br.unesp.rc.pinguim.controller.command;

public class Login implements ICommand {
	
	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
		return new CommandResult("/login.jsp");
	}

}