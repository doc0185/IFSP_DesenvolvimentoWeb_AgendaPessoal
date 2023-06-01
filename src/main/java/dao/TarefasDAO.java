package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList; 


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
				
				tarefa.setUser_id(usuario.getId());
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
	
	public ArrayList<Tarefas> listTarefa (Usuarios usuario) throws ClassNotFoundException{
		String LIST_TAREFAS_SQL = "SELECT id, titulo, descricao, data_criacao, data_conclusao, stat from tarefas "
				+ "WHERE user_id = ?;";
		Class.forName("com.mysql.jdbc.Driver");
		ArrayList<Tarefas> listTarefas = new ArrayList<>();
		
		try (Connection connection = DriverManager.
				getConnection(url, username, password);
				
				PreparedStatement preparedStatement = connection.prepareStatement(LIST_TAREFAS_SQL)){;
				
				preparedStatement.setInt(1, usuario.getId());
				
				
				System.out.println(preparedStatement);
				
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					
					Tarefas tarefa = new Tarefas();
					tarefa.setId(rs.getInt("id"));
					tarefa.setTitulo(rs.getString("titulo"));
					tarefa.setDescricao(rs.getString("descricao"));
					tarefa.setData_inicio(rs.getDate("data_criacao"));
					tarefa.setData_conclusao(rs.getDate("data_conclusao"));
					tarefa.setStatus(rs.getString("stat"));
					listTarefas.add(tarefa);
				}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return listTarefas;
	}
	
	public void deletarTarefa (int id) throws ClassNotFoundException{
		
		String DELETE_TAREFAS_SQL = "DELETE FROM tarefas "
				+ "WHERE id = ?;";
		Class.forName("com.mysql.jdbc.Driver");
	
		try (Connection connection = DriverManager.
				getConnection(url, username, password);
				
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TAREFAS_SQL)){;
				
				preparedStatement.setInt(1, id);
				
				
				System.out.println(preparedStatement);
				
				preparedStatement.executeUpdate();
				
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public Tarefas visualEdicaoTarefa (int id) throws ClassNotFoundException{
		Tarefas tarefa = new Tarefas();
		
		String LIST_TAREFAS_SQL = "SELECT titulo, descricao, data_criacao, data_conclusao, stat from tarefas "
				+ "WHERE id = ?;";
		Class.forName("com.mysql.jdbc.Driver");
		
		try (Connection connection = DriverManager.
				getConnection(url, username, password);
				
				PreparedStatement preparedStatement = connection.prepareStatement(LIST_TAREFAS_SQL)){;
				
				preparedStatement.setInt(1, id);
				
				
				System.out.println(preparedStatement);
				
				ResultSet rs = preparedStatement.executeQuery();
				while (rs.next()) {
					
					tarefa.setTitulo(rs.getString("titulo"));
					tarefa.setDescricao(rs.getString("descricao"));
					tarefa.setData_inicio(rs.getDate("data_criacao"));
					tarefa.setData_conclusao(rs.getDate("data_conclusao"));
					tarefa.setStatus(rs.getString("stat"));
				}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return tarefa;
	}
	
	public int atualizarTarefa (Tarefas tarefa) throws ClassNotFoundException{
		String UPDATE_TAREFA = "UPDATE tarefas SET titulo = ?, descricao = ?, data_criacao = ?, data_conclusao = ?, stat = ? "
				+ "WHERE id = ?;";
		int result = 0;
		Class.forName("com.mysql.jdbc.Driver");
		
		try (Connection connection = DriverManager.
				getConnection(url, username, password);
				
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TAREFA)){;
				preparedStatement.setString(1, tarefa.getTitulo());
				preparedStatement.setString(2, tarefa.getDescricao());
				preparedStatement.setDate(3, tarefa.getData_inicio());
				preparedStatement.setDate(4, tarefa.getData_conclusao());
				preparedStatement.setString(5, tarefa.getStatus());
				preparedStatement.setInt(6, tarefa.getId());
				
				System.out.println(preparedStatement);
				result = preparedStatement.executeUpdate();
				
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return result;
	}

}
