package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuarios;
import model.Tarefas;
import dao.UsuariosDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import dao.TarefasDAO;
import java.text.ParseException;
import java.text.DateFormat;  



/**
 * Servlet implementation class AgendaCadastroTarefaServlet
 */
@WebServlet("/cadastroTarefa")
public class AgendaCadastroTarefaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuariosDAO usuarioDAO = new UsuariosDAO();
	TarefasDAO tarefaDAO = new TarefasDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgendaCadastroTarefaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/agendacadastrotarefa.jsp");
		dispatcher.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext servletContext = getServletContext();
        String login = (String) servletContext.getAttribute("login");
        String senha = (String) servletContext.getAttribute("senha");
        
        Usuarios usuario = new Usuarios();
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		try {
			usuarioDAO.loginUsuario(usuario);
			String titulo = request.getParameter("titulo");
			String descricao = request.getParameter("descricao");
			String dataInicioString = request.getParameter("data_inicio");
			String dataConclusaoString = request.getParameter("data_conclusao"); 
			String status = request.getParameter("status");
			Tarefas tarefa = new Tarefas();
			tarefa.setTitulo(titulo);
			tarefa.setDescricao(descricao);
			tarefa.setStatus(status);
			
			DateFormat fmt = new java.text.SimpleDateFormat("yyyy-MM-dd");
			java.sql.Date data_inicioSQL;
			java.sql.Date data_conclusaoSQL;
			try {
				data_inicioSQL = new java.sql.Date(fmt.parse(dataInicioString).getTime());
				data_conclusaoSQL = new java.sql.Date(fmt.parse(dataConclusaoString).getTime());
				tarefa.setData_inicio(data_inicioSQL);
				tarefa.setData_conclusao(data_conclusaoSQL);
				
			} catch(ParseException e) {
				e.printStackTrace();
			}
			tarefaDAO.registerTarefa(tarefa, usuario);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/agendaprincipal.jsp");
			dispatcher.forward(request, response);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
