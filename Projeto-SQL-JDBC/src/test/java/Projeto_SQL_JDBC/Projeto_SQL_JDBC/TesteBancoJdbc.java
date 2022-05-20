package Projeto_SQL_JDBC.Projeto_SQL_JDBC;

import java.util.List;

import org.junit.Test;

import conexaojdbc.SingleConnection;
import dao.UserposDAO;
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
	public void initbuscar() {//metodo para vazer uma consulta
		UserposDAO dao = new UserposDAO();
		
		try {
			Userposjava userposjava = dao.buscar(6L);//trazendo o objeto
			
			System.out.println(userposjava);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initAtualizar() {
		
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
	public void initDeletar() {
		
		try {
			
			UserposDAO dao = new  UserposDAO();
			dao.deletar(7L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
}
