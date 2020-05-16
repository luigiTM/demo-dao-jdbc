package aplicacao;

import modelo.dao.FabricaDao;
import modelo.dao.VendedorDao;
import modelo.entidades.Vendedor;

public class Programa {

	public static void main(String[] args) {

		VendedorDao vendedorDao = FabricaDao.criarVendedorDao();
		Vendedor vendedor = vendedorDao.buscarPorId(3);
		System.out.println(vendedor);

	}

}
