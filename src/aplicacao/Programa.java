package aplicacao;

import modelo.dao.DepartamentoDao;
import modelo.dao.fabrica.FabricaDao;

public class Programa {

	public static void main(String[] args) {

		DepartamentoDao departamento = FabricaDao.criarDepartamento();
		System.out.println(departamento.buscarPorId(1));
	}

}
