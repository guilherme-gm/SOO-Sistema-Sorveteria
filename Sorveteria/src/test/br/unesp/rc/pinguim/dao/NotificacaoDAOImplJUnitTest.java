package test.br.unesp.rc.pinguim.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Instant;
import java.util.Date;

import org.junit.jupiter.api.Test;

import br.unesp.rc.pinguim.dao.NotificacaoDAOImpl;
import br.unesp.rc.pinguim.models.Notificacao;
import br.unesp.rc.pinguim.models.Produto;
import br.unesp.rc.pinguim.utils.FabricaConexao;

/**
 * Teste para a classe {@link NotificacaoDAO}
 */
class NotificacaoDAOImplJUnitTest {

	private Notificacao notificacao;

	public void setUp() {
		Produto prod = new Produto();
		prod.setCodigo(1);

		notificacao = new Notificacao();
		notificacao.setData(Date.from(Instant.now()));
		notificacao.setLido(false);
		notificacao.setProduto(prod);
	}

	public void tearDown() throws SQLException {
		Connection con = FabricaConexao.getConexao();
		PreparedStatement pstm = con.prepareStatement("TRUNCATE TABLE Notificacao");
		pstm.executeQuery();
	}

	@Test
	void teste() throws SQLException {
		setUp();

		NotificacaoDAOImpl dao = new NotificacaoDAOImpl();
		assertEquals(dao.salvar(notificacao), true);

		tearDown();
	}

}
