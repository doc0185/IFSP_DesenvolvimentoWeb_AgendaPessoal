package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Tarefas;
import model.Usuarios;

public class TarefasDAO {
	String serverName="localhost";
	String databasePort="3306";
	String mydatabase="agendaPessoal";
	String url = "jdbc:mysql://" + serverName + ":" + databasePort + "/" + mydatabase;
	
	String username = "root";
	String password = "";
	
	public int registerTarefa (Tarefas tarefa, Usuarios usuario) throws ClassNotFoundException{
		String INSERT_TAREFA_SQL = "INSERT INTO tarefas" + 
				"(user_id, titulo, descricao, data_criacao, data_conclusao, stat) VALUES" +
				"(?, ?, ?, ?, ?, ?);";
		int result = 0;
		Class.forName("com.mysql.jdbc.Driver");
		
		try (Connection connection = DriverManager.
				getConnection(url, username, password);
				
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TAREFA_SQL)){;
				preparedStatement.setInt(1, usuario.getId());
				preparedStatement.setString(2, tarefa.getTitulo());
				preparedStatement.setString(3, tarefa.getDescricao());
				preparedStatement.setDate(4, tarefa.getData_inicio());
				preparedStatement.setDate(5, tarefa.getData_conclusao());
				preparedStatement.setString(6, tarefa.getStatus());
				
				System.out.println(preparedStatement);
				
				result = preparedStatement.executeUpdate();
				ResultSet rs = preparedStatement.getGeneratedKeys();
				if(rs.next()) {
					tarefa.setId(rs.getInt(1));
					System.out.println(tarefa.getId());
				}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
