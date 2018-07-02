package br.unesp.rc.pinguim.aspect;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.unesp.rc.pinguim.controller.command.DoAtualizarFuncionario;
import br.unesp.rc.pinguim.controller.command.DoAtualizarProduto;
import br.unesp.rc.pinguim.controller.command.DoInserirFuncionario;
import br.unesp.rc.pinguim.controller.command.DoInserirPagamento;
import br.unesp.rc.pinguim.controller.command.DoInserirProduto;
import br.unesp.rc.pinguim.controller.command.ICommand;
import br.unesp.rc.pinguim.models.Funcionario;
import br.unesp.rc.pinguim.models.Venda;

/**
 * Aspecto para controle de Logs do sistema
 */
public aspect Log {

	pointcut callExecuteCommand(HttpServletRequest request, HttpServletResponse response):
		call(* ICommand.execute(HttpServletRequest, HttpServletResponse)) && args(request, response);

	/**
	 * Retorna o funcion�rio da sess�o atual
	 * 
	 * @param request
	 *            request http
	 * @return o funcion�rio logado
	 */
	public Funcionario getUsuarioAtual(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return (Funcionario) session.getAttribute("usuario");
	}

	/**
	 * Log de cria��o de funcion�rio
	 * 
	 * @param request
	 *            http request
	 * @param response
	 *            http response
	 */
	before(HttpServletRequest request, HttpServletResponse response) 
	: target(DoInserirFuncionario) && callExecuteCommand(request, response) {

		Funcionario usuario = getUsuarioAtual(request);

		System.out.println(String.format("[%1$s] Usu�rio [%2$s] est� criando um novo Funcionario:\n \tUsu�rio: %3$s\n",
				LocalDateTime.now().toString(), usuario.getNome(), request.getParameter("usuario")));
	}

	/**
	 * Log de atualiza��o de funcion�rio
	 * 
	 * @param request
	 *            http request
	 * @param response
	 *            http response
	 */
	before(HttpServletRequest request, HttpServletResponse response) 
	: target(DoAtualizarFuncionario) && callExecuteCommand(request, response) {

		Funcionario usuario = getUsuarioAtual(request);

		System.out.println(String.format(
				"[%1$s] Usu�rio [%2$s] est� atualizando um Funcionario:\n \tID do Funcion�rio: %3$s\n\tUsu�rio: %4$s\n",
				LocalDateTime.now().toString(), usuario.getNome(), request.getParameter("codigo"),
				request.getParameter("usuario")));
	}

	/**
	 * Log de cria��o de produto
	 * 
	 * @param request
	 *            http request
	 * @param response
	 *            http response
	 */
	before(HttpServletRequest request, HttpServletResponse response) 
	: target(DoInserirProduto) && callExecuteCommand(request, response) {

		Funcionario usuario = getUsuarioAtual(request);

		System.out.println(
				String.format("[%1$s] Usu�rio [%2$s] est� criando um novo produto:\n \tNome do Produto: %3$s\n",
						LocalDateTime.now().toString(), usuario.getNome(), request.getParameter("nome")));
	}

	/**
	 * Log de atualiza��o de produto
	 * 
	 * @param request
	 *            http request
	 * @param response
	 *            http response
	 */
	before(HttpServletRequest request, HttpServletResponse response) 
	: target(DoAtualizarProduto) && callExecuteCommand(request, response) {

		Funcionario usuario = getUsuarioAtual(request);

		System.out.println(String.format(
				"[%1$s] Usu�rio [%2$s] est� atualizando um Produto:\n \tID do Produto: %3$s\n\tNome do Produto: %4$s\n",
				LocalDateTime.now().toString(), usuario.getNome(), request.getParameter("codigo"),
				request.getParameter("nome")));
	}

	/**
	 * Log de confirma��o de uma venda
	 * 
	 * @param request
	 *            http request
	 * @param response
	 *            http response
	 */
	after(HttpServletRequest request, HttpServletResponse response) 
	: target(DoInserirPagamento) && callExecuteCommand(request, response) {

		Funcionario usuario = getUsuarioAtual(request);
		Venda venda = (Venda) request.getSession().getAttribute("venda");

		System.out.println(
				String.format("[%1$s] Usu�rio [%2$s] realizou uma venda:\n \tID da Venda: %3$d\n\tTotal: %4$.2f\n",
						LocalDateTime.now().toString(), usuario.getNome(), venda.getCodigo(), venda.getTotal()));
	}

}
