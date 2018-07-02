package br.unesp.rc.pinguim.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unesp.rc.pinguim.controller.exception.AccessDeniedException;

public interface ICommand {

	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws AccessDeniedException;

}
