package dao;

import java.sql.Connection;

import conexaojdbc.SingleConnection;

public class UserposDAO {
	
	private Connection connection;
	
	public UserposDAO() {
		connection = SingleConnection.getConnection();
	}

}
