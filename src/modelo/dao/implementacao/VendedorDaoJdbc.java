package modelo.dao.implementacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import bancoDeDados.BancoDeDados;
import bancoDeDados.excexoes.BancoDeDadosException;
import modelo.dao.VendedorDao;
import modelo.entidades.Departamento;
import modelo.entidades.Vendedor;

public class VendedorDaoJdbc implements VendedorDao {

	private Connection conexao;

	public VendedorDaoJdbc(Connection conexao) {
		this.conexao = conexao;
	}

	@Override
	public void inserir(Vendedor vendedor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizar(Vendedor vendedor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletarPorId(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Vendedor buscarPorId(Integer id) {
		PreparedStatement declaracaoPreparada = null;
		ResultSet resultado = null;
		try {
			declaracaoPreparada = conexao.prepareStatement("SELECT vendedor.*,departamento.Nome as NomeDepartamento  FROM vendedor INNER JOIN departamento  ON vendedor.IdDepartamento = departamento.Id  WHERE vendedor.Id = ? ");
			declaracaoPreparada.setInt(1, id);
			resultado = declaracaoPreparada.executeQuery();
			if (resultado.next()) {
				Departamento departamento = instanciarDepartamento(resultado);
				Vendedor vendedor = instanciarVendedor(resultado, departamento);
				return vendedor;
			}
			return null;
		} catch (SQLException e) {
			throw new BancoDeDadosException(e.getMessage());
		} finally {
			BancoDeDados.fecharDeclaracao(declaracaoPreparada);
			BancoDeDados.fecharResultado(resultado);
		}
	}

	@Override
	public List<Vendedor> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	private Vendedor instanciarVendedor(ResultSet resultado, Departamento departamento) throws SQLException {
		Vendedor vendedor = new Vendedor();
		vendedor.setId(resultado.getInt("Id"));
		vendedor.setNome(resultado.getString("Nome"));
		vendedor.setEmail(resultado.getString("Email"));
		vendedor.setSalarioBase(resultado.getDouble("SalarioBase"));
		vendedor.setDataNascimento(resultado.getDate("DataNascimento"));
		vendedor.setDepartamento(departamento);
		return vendedor;
	}

	private Departamento instanciarDepartamento(ResultSet resultado) throws SQLException {
		Departamento departamento = new Departamento();
		departamento.setId(resultado.getInt("IdDepartamento"));
		departamento.setNome(resultado.getString("NomeDepartamento"));
		return departamento;
	}

}
