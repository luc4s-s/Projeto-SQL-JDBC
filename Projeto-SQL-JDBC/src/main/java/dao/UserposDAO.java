package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SingleConnection;
import model.Telefone;
import model.Userposjava;

public class UserposDAO {

	private Connection connection;

	public UserposDAO() {
		connection = SingleConnection.getConnection();
	}

	// metodo para Salvar no banco
	public void Salvar(Userposjava userposjava) {
		try {
			// sql para inser no banco
			String sql = "insert into userposjava (nome, email) values (?, ?)";
			PreparedStatement insert = connection.prepareStatement(sql);// preparando o sql

			// passando os paramentros segindo as ordem
			insert.setString(1, userposjava.getNome());
			insert.setString(2, userposjava.getEmail());

			insert.execute();// executando
			connection.commit();// salvando no banco

		} catch (Exception e) {
			try {
				connection.rollback();// reverte operaçao se tiver erro
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	// metodo para salvarTelefone no banco
	public void salvarTelefone(Telefone telefone ) {
		
		try {
			
			String sql = "INSERT INTO public.telefoneuser(numero, tipo, usuariopessoa) VALUES (?, ?, ?);"; //montando o sql
			PreparedStatement statement = connection.prepareStatement(sql);//preparando sql
			//setando os Atributos
			statement.setString(1, telefone.getNumero());
			statement.setString(2, telefone.getTipo());
			statement.setLong(3, telefone.getUsuario());
			statement.execute();//executando 
			
			connection.commit();//fazendo o commit no banco 
			
		} catch (Exception e) {
			try {
				connection.rollback();// reverte operaçao se tiver erro
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	

	// metodo para retorna uma Lista
	public List<Userposjava> listar() throws Exception {
		List<Userposjava> list = new ArrayList<Userposjava>();// instanciando a lista

		String sql = "select * from userposjava";// montando o sql

		PreparedStatement statement = connection.prepareStatement(sql);// preparando o sql
		ResultSet resultado = statement.executeQuery();// executando no banco

		while (resultado.next()) {// enquanto for true ele vai percorrer a lista
			Userposjava userposjava = new Userposjava();// criando novos objetos

			// setando objetos
			userposjava.setId(resultado.getLong("id"));
			userposjava.setNome(resultado.getString("nome"));
			userposjava.setEmail(resultado.getString("email"));

			// adicionadno na lista
			list.add(userposjava);
		}

		return list;
	}

	// metodo para consultar so um atributo
	public Userposjava buscar(Long id) throws Exception {
		Userposjava retorno = new Userposjava();

		String sql = "select * from userposjava where id = " + id;// montando o sql

		PreparedStatement statement = connection.prepareStatement(sql);// preparando o sql
		ResultSet resultado = statement.executeQuery();// executando no banco

		while (resultado.next()) {// retorna apenas um objeto ou nenhum

			// setando os objetos
			retorno.setId(resultado.getLong("id"));
			retorno.setNome(resultado.getString("nome"));
			retorno.setEmail(resultado.getString("email"));

		}

		return retorno;
	}

	// metodo para Atualizar no banco
	public void atualizar(Userposjava useposjava) {
		try {
							// montando o sql
			String sql = "update userposjava set nome = ? where id = " + useposjava.getId();

			PreparedStatement statement = connection.prepareStatement(sql);// preparando o sql
			statement.setString(1, useposjava.getNome());

			statement.execute();// executando sql
			connection.commit();//fazendo o commit da atualizaçao

		} catch (Exception e) {
			try {
				connection.rollback();// reverte operaçao se tiver erro
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
	
	// metodo para Deletar no banco
	public void deletar(Long id) {
		
		try {
			String sql = "delete from userposjava where id = " + id;//montando o sql para deletar
			PreparedStatement preparedStatement = connection.prepareStatement(sql);//preparando o sql 
			preparedStatement.execute(); // executando sql
			connection.commit();//fazendo o commit de delete
			
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
