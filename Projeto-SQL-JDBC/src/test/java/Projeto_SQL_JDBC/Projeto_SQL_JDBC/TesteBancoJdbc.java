package Projeto_SQL_JDBC.Projeto_SQL_JDBC;

import org.junit.Test;

import conexaojdbc.SingleConnection;

public class TesteBancoJdbc{
	
	
	@Test
	public void initBanco() {
		SingleConnection.getConnection();
	}
 
}
