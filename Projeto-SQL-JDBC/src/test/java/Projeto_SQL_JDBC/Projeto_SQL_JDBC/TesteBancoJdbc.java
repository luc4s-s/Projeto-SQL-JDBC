package Projeto_SQL_JDBC.Projeto_SQL_JDBC;

import org.junit.Test;

import conexaojdbc.SingleConnection;
import dao.UserposDAO;
import model.Userposjava;

public class TesteBancoJdbc{
	
	
	@Test
	public void initBanco() {
		SingleConnection.getConnection();
		
		UserposDAO userposDAO = new UserposDAO();
		Userposjava userposjava = new Userposjava();
		
		userposjava.setId(6L);
		userposjava.setNome("paulo");
		userposjava.setEmail("paulo@gmail.com");
		
		userposDAO.Salvar(userposjava);
	}
 
}
