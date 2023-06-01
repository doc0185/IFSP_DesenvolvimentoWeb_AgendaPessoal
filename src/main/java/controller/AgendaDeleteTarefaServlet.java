package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.TarefasDAO;
import dao.UsuariosDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import model.Tarefas;
import model.Usuarios;

/**
 * Servlet implementation class AgendaDeleteTarefaServlet
 */
@WebServlet("/deleteTarefa")
public class AgendaDeleteTarefaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuariosDAO usuarioDAO = new UsuariosDAO();
	TarefasDAO tarefaDAO = new TarefasDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgendaDeleteTarefaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario_login = (String) request.getSession().getAttribute("usuario_login");
		if (usuario_login != null) {
			ServletContext servletContext = getServletContext();
	        String login = (String) servletContext.getAttribute("login");
	        String senha = (String) servletContext.getAttribute("senha");
	        
	        Usuarios usuario = new Usuarios();
			usuario.setLogin(login);
			usuario.setSenha(senha);
			
			int id_tarefa = Integer.parseInt(request.getParameter("id_tarefa"));
		
		
			try {
				tarefaDAO.deletarTarefa(id_tarefa);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				usuarioDAO.loginUsuario(usuario);
				ArrayList<Tarefas> tarefas = new ArrayList<>();
				tarefas = tarefaDAO.listTarefa(usuario);
				request.setAttribute("lista", tarefas);
			
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/agendaprincipal.jsp");
				dispatcher.forward(request, response);
		
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/agendalogin.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
