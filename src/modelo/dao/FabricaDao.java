package modelo.dao;

import bancoDeDados.BancoDeDados;
import modelo.dao.implementacao.VendedorDaoJdbc;

public class FabricaDao {

	public static VendedorDao criarVendedorDao() {
		return new VendedorDaoJdbc(BancoDeDados.getConexao());
	}

}
