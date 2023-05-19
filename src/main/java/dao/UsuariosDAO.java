package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuarios;

public class UsuariosDAO {
	String serverName="localhost";
	String databasePort="3306";
	String mydatabase="agendaPessoal";
	String url = "jdbc:mysql://" + serverName + ":" + databasePort + "/" + mydatabase;
	
	String username = "root";
	String password = "";
	
	public int registerUsuario (Usuarios usuario) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO usuarios" + 
				"(login, senha, nome, email) VALUES" +
				"(?, ?, ?, ?);";
		int result = 0;
		Class.forName("com.mysql.jdbc.Driver");
		
		try (Connection connection = DriverManager.
				getConnection(url, username, password);
				
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)){;
				
				preparedStatement.setString(1, usuario.getLogin());
				preparedStatement.setString(2, usuario.getSenha());
				preparedStatement.setString(3, usuario.getNome());
				preparedStatement.setString(4, usuario.getEmail());
				
				System.out.println(preparedStatement);
				
				result = preparedStatement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	
	}
	
	public int loginUsuario(Usuarios usuario) throws ClassNotFoundException {
		String LOGIN_USERS_SQL = "SELECT id from usuarios "
				+ "WHERE login = ? AND senha = ?;";
		Class.forName("com.mysql.jdbc.Driver");
		
		try (Connection connection = DriverManager.
				getConnection(url, username, password);
				
				PreparedStatement preparedStatement = connection.prepareStatement(LOGIN_USERS_SQL)){;
				
				preparedStatement.setString(1, usuario.getLogin());
				preparedStatement.setString(2, usuario.getSenha());
				
				System.out.println(preparedStatement);
				
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					System.out.println(rs.getString("id"));		
					return 1;
				}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
}
