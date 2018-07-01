package br.unesp.rc.pinguim.controller.command;

import java.sql.Date;

import br.unesp.rc.pinguim.models.Acesso;
import br.unesp.rc.pinguim.models.Cargo;
import br.unesp.rc.pinguim.models.CategoriaProduto;
import br.unesp.rc.pinguim.models.Contato;
import br.unesp.rc.pinguim.models.Endereco;
import br.unesp.rc.pinguim.models.Funcionario;
import br.unesp.rc.pinguim.models.Produto;
import br.unesp.rc.pinguim.service.FuncionarioService;
import br.unesp.rc.pinguim.service.ProdutoService;
import br.unesp.rc.pinguim.service.ServiceFactory;

/**
 * Realiza a inser��o de um produto
 *
 */
public class DoInserirFuncionario  implements ICommand{

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
		
		Funcionario funcionario = new Funcionario();
        Acesso acesso = new Acesso();
        Endereco endereco = new Endereco();
        Contato contato = new Contato();
        
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
        funcionario.setDataNascimento(Date.valueOf(request.getParameter("dataNascimento")));
        funcionario.setAcesso(acesso);
        funcionario.setCargo(Cargo.valueOf(request.getParameter("cargo")));
        funcionario.setEndereco(endereco);
        funcionario.setContato(contato);
		
		FuncionarioService fs = ServiceFactory.getFuncionarioService();
		boolean b = fs.salvar(funcionario);
		CommandResult  rs = null;
		if(b) {
			rs =  new CommandResult("/home", true);
		}else {
			rs = new CommandResult("funcionario/inserir");
		}
		
		return rs;
	}

	
}

