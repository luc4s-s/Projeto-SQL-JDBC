package Projeto_SQL_JDBC.Projeto_SQL_JDBC;

import java.util.List;

import org.junit.Test;

import conexaojdbc.SingleConnection;
import dao.UserposDAO;
import model.BeanUserFone;
import model.Telefone;
import model.Userposjava;

public class TesteBancoJdbc{
	
	
	@Test
	public void initBanco() {//metodo de insert
		SingleConnection.getConnection();
		
		UserposDAO userposDAO = new UserposDAO();
		Userposjava userposjava = new Userposjava();
		
		userposjava.setNome("junior");
		userposjava.setEmail("junior@gmail.com");
		
		userposDAO.Salvar(userposjava);
	}
	
	@Test
	public void initListar() {//metodo de listar
		UserposDAO dao = new UserposDAO();
		try {
			List<Userposjava> list = dao.listar();
			
			for (Userposjava userposjava : list) {
				System.out.println(userposjava);
				System.out.println("----------------");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initbuscar() {//metodo para fazer uma consulta
		UserposDAO dao = new UserposDAO();
		
		try {
			Userposjava userposjava = dao.buscar(6L);//trazendo o objeto
			
			System.out.println(userposjava);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initAtualizar() {//metodo para Atualizar
		
		try {
			
			UserposDAO dao = new UserposDAO();
			
			Userposjava objetoBanco = dao.buscar(5L);
									//aqui fica oque vai atualizar no nome do banco
			objetoBanco.setNome("nome atualizado com metodo atualizar");//nome sendo mudado no banco
			
			dao.atualizar(objetoBanco);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	public void initDeletar() {//metodo para Deletar
		
		try {
			
			UserposDAO dao = new  UserposDAO();
			dao.deletar(7L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeInsertTelefone() {//metodo para salvarTelefone
		Telefone telefone = new Telefone();
		telefone.setNumero("(81) 9 55555555");// atributo que vai ser salvo la no banco
		telefone.setTipo("Casa");// atributo que vai ser salvo la no banco
		telefone.setUsuario(3L);// Id/codigo para qual o telefone vai ser salvo 
		
		UserposDAO dao = new UserposDAO();
		dao.salvarTelefone(telefone);//chamando o metodo salvarTelefone
		
	}
	
	@Test
	public void testeCarregaFonesUser() {//metodo para listar os telefones
		
		UserposDAO dao = new UserposDAO();
		
		List<BeanUserFone> benUserFones = dao.listaUserFone(1L); //passando o id de consulta
		
		for (BeanUserFone beanUserFone : benUserFones) {
			System.out.println(beanUserFone);
			System.out.println("------------------------");
		}
		
	}
	
	@Test
	public void testeDeleteUserFones() {//metodo para deletar em cascata filhos e pais 
		UserposDAO dao = new UserposDAO();
		dao.deleteFonesPorUser(2L);
		
	}
 
}
