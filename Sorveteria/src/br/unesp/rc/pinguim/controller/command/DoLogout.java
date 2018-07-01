package br.unesp.rc.pinguim.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;  


/**
 * Realiza o logout
 *
 */
@Command(url = "/DoLogout")
public class DoLogout implements ICommand{

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
		
        HttpSession session = request.getSession();
        session.invalidate(); 

		return new CommandResult("Login", true);
	}	
}
