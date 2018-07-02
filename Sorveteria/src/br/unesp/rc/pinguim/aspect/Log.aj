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
	 * Retorna o funcionário da sessão atual
	 * 
	 * @param request
	 *            request http
	 * @return o funcionário logado
	 */
	public Funcionario getUsuarioAtual(HttpServletRequest request) {
		HttpSession session = request.getSession();
		return (Funcionario) session.getAttribute("usuario");
	}

	/**
	 * Log de criação de funcionário
	 * 
	 * @param request
	 *            http request
	 * @param response
	 *            http response
	 */
	before(HttpServletRequest request, HttpServletResponse response) 
	: target(DoInserirFuncionario) && callExecuteCommand(request, response) {

		Funcionario usuario = getUsuarioAtual(request);

		System.out.println(String.format("[%1$s] Usuário [%2$s] está criando um novo Funcionario:\n \tUsuário: %3$s\n",
				LocalDateTime.now().toString(), usuario.getNome(), request.getParameter("usuario")));
	}

	/**
	 * Log de atualização de funcionário
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
				"[%1$s] Usuário [%2$s] está atualizando um Funcionario:\n \tID do Funcionário: %3$s\n\tUsuário: %4$s\n",
				LocalDateTime.now().toString(), usuario.getNome(), request.getParameter("codigo"),
				request.getParameter("usuario")));
	}

	/**
	 * Log de criação de produto
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
				String.format("[%1$s] Usuário [%2$s] está criando um novo produto:\n \tNome do Produto: %3$s\n",
						LocalDateTime.now().toString(), usuario.getNome(), request.getParameter("nome")));
	}

	/**
	 * Log de atualização de produto
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
				"[%1$s] Usuário [%2$s] está atualizando um Produto:\n \tID do Produto: %3$s\n\tNome do Produto: %4$s\n",
				LocalDateTime.now().toString(), usuario.getNome(), request.getParameter("codigo"),
				request.getParameter("nome")));
	}

	/**
	 * Log de confirmação de uma venda
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
				String.format("[%1$s] Usuário [%2$s] realizou uma venda:\n \tID da Venda: %3$d\n\tTotal: %4$.2f\n",
						LocalDateTime.now().toString(), usuario.getNome(), venda.getCodigo(), venda.getTotal()));
	}

}
