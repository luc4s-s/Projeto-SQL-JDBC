package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			
			//passando os paramentros segindo as ordem
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

	
	//metodo para retorna uma Lista 
	public List<Userposjava> listar() throws Exception {
		List<Userposjava> list = new ArrayList<Userposjava>();//instanciando a lista
		
		String sql = "select * from userposjava";//montando o sql
		
		PreparedStatement statement = connection.prepareStatement(sql);//preparando o sql
		ResultSet resultado = statement.executeQuery();//executando no banco
		
		while (resultado.next()) {//enquanto for true ele vai percorrer a lista 
			Userposjava userposjava = new Userposjava();//criando novos objetos
			
			//setando objetos
			userposjava.setId(resultado.getLong("id"));
			userposjava.setNome(resultado.getString("nome"));
			userposjava.setEmail(resultado.getString("email"));
			
			//adicionadno na lista
			list.add(userposjava);
		}
		
		return list;
	}
	
	//metodo para consultar so um atributo
	public Userposjava buscar(Long id) throws Exception {
		Userposjava  retorno = new Userposjava();
		
		String sql = "select * from userposjava where id = " + id;//montando o sql
		
		PreparedStatement statement = connection.prepareStatement(sql);//preparando o sql
		ResultSet resultado = statement.executeQuery();//executando no banco
		
		while (resultado.next()) {//retorna apenas um objeto ou nenhum
			
			//setando os objetos
			retorno.setId(resultado.getLong("id"));
			retorno.setNome(resultado.getString("nome"));
			retorno.setEmail(resultado.getString("email"));
			
		}
		
		return retorno;
	}
}











