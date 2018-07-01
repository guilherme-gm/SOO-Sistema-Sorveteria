package br.unesp.rc.pinguim.dao;

import java.util.List;

import br.unesp.rc.pinguim.models.Venda;

public interface VendaDAO {

	public static final String INSERT_VENDA = "INSERT INTO Venda (total,dataVenda,Funcionario_codigo,Pagamento_codigo) VALUES (?,?,?,?)";
	public static final String SELECT_VENDA = "SELECT v.codigo,total,dataVenda,Funcionario_codigo,Pagamento_codigo, "
			+ "metodoPagamento, f.nome FROM Venda v "
			+ "JOIN pagamento p on Pagamento_codigo =  p.codigo "
			+ "JOIN funcionario f on f.codigo = v.Funcionario_codigo "
			+ "ORDER BY v.codigo";

	public boolean salvar(Venda venda);

	public List<Venda> BuscarTodos();
}
