package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexaojdbc.SingleConnection;
import model.Userposjava;

public class UserposDAO {

	private Connection connection;

	public UserposDAO() {
		connection = SingleConnection.getConnection();
	}

	//metodo para salvar no banco 
	public void Salvar(Userposjava userposjava) {
		try {
			//sql para inser no banco
			String sql = "insert into userposjava (id, nome, email) values (?, ?, ?)";
			PreparedStatement insert = connection.prepareStatement(sql);//preparando o sql
			
			//passano os paramentros segindo as ordem
			insert.setLong(1, userposjava.getId());
			insert.setString(2, userposjava.getNome());
			insert.setString(3, userposjava.getEmail());
			
			insert.execute();//executando 
			connection.commit();//salvando no banco

		} catch (Exception e) {
			try {
				connection.rollback();// reverte operaçao se tiver erro
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

}
