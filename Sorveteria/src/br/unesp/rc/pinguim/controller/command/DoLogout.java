package br.unesp.rc.pinguim.controller.command;

import javax.servlet.http.HttpSession;  


/**
 * Realiza o logout
 *
 */
public class DoLogout implements ICommand{

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
		
        HttpSession session = request.getSession();
        session.invalidate(); 

		return new CommandResult("/login");
	}	
}
