package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Tarefas;
import model.Usuarios;
import dao.TarefasDAO;
import dao.UsuariosDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;

/**
 * Servlet implementation class AgendaEdicaoTarefaServlet
 */
@WebServlet("/edicaoTarefa")
public class AgendaEdicaoTarefaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuariosDAO usuarioDAO = new UsuariosDAO();
	TarefasDAO tarefaDAO = new TarefasDAO();
	int id_tarefa;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgendaEdicaoTarefaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/agendaprincipal.jsp");
		dispatcher.forward(request, response);
		id_tarefa = Integer.parseInt(request.getParameter("id_tarefa"));
		try {
			tarefaDAO.deletarTarefa(id_tarefa);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
        String login = (String) servletContext.getAttribute("login");
        String senha = (String) servletContext.getAttribute("senha");
        
        Usuarios usuario = new Usuarios();
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		try {
			usuarioDAO.loginUsuario(usuario);
			
			ArrayList<Tarefas> tarefas = new ArrayList<>();
			tarefas = tarefaDAO.listTarefa(usuario);
			request.setAttribute("lista", tarefas);
			System.out.println("oi");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/agendaprincipal.jsp");
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
