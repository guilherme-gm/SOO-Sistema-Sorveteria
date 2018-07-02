package br.unesp.rc.pinguim.controller.command;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unesp.rc.pinguim.models.Acesso;
import br.unesp.rc.pinguim.models.Cargo;
import br.unesp.rc.pinguim.models.Contato;
import br.unesp.rc.pinguim.models.Endereco;
import br.unesp.rc.pinguim.models.Funcionario;
import br.unesp.rc.pinguim.service.FuncionarioService;
import br.unesp.rc.pinguim.service.ServiceFactory;

/**
 * Execu��o da atualiza��o de um funcion�rio
 */
@Command(url = "/DoAtualizarFuncionario")
public class DoAtualizarFuncionario implements ICommand {

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		Funcionario funcionario = new Funcionario();
		Acesso acesso = new Acesso();
		Endereco endereco = new Endereco();
		Contato contato = new Contato();

		funcionario.setCodigo(Long.parseLong(request.getParameter("codigo")));

		acesso.setUsuario(request.getParameter("usuario"));
		acesso.setSenha(request.getParameter("senha"));

		endereco.setRua(request.getParameter("rua"));
		endereco.setNumero(request.getParameter("numero"));
		endereco.setCep(request.getParameter("cep"));
		endereco.setCidade(request.getParameter("cidade"));
		endereco.setEstado(request.getParameter("estado"));

		contato.setCelular(request.getParameter("celular"));
		contato.setEmail(request.getParameter("email"));
		contato.setTelefone(request.getParameter("telefone"));

		funcionario.setNome(request.getParameter("nome"));
		funcionario.setCpf(request.getParameter("cpf"));
		try {
			funcionario.setDataNascimento(format.parse(request.getParameter("dataNascimento")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		funcionario.setAcesso(acesso);
		funcionario.setCargo(Cargo.valueOf(request.getParameter("cargo")));
		funcionario.setEndereco(endereco);
		funcionario.setContato(contato);

		FuncionarioService fs = ServiceFactory.getFuncionarioService();
		boolean b = fs.atualizar(funcionario);
		CommandResult rs = null;

		if (b) {
			rs = new CommandResult("ListarFuncionarios", true);
		} else {
			rs = new CommandResult("funcionario/atualizar");
		}
		return rs;
	}

}