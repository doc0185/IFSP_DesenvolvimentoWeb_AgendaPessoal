package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import model.Tarefas;
import model.Usuarios;
import dao.TarefasDAO;
import dao.UsuariosDAO;

/**
 * Servlet implementation class AgendaLoginServlet
 */
@WebServlet("/login")
public class AgendaLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuariosDAO usuarioDAO = new UsuariosDAO();
	TarefasDAO tarefaDAO = new TarefasDAO();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgendaLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/agendalogin.jsp");
		dispatcher.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		Usuarios usuario = new Usuarios();
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		try {
 			
			if(usuarioDAO.loginUsuario(usuario) != 0) {
				ArrayList<Tarefas> tarefas = new ArrayList<>();
				tarefas = tarefaDAO.listTarefa(usuario);
				request.setAttribute("lista", tarefas);
				 ServletContext servletContext = getServletContext();
			        servletContext.setAttribute("login", login);
			        servletContext.setAttribute("senha", senha);

					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/agendaprincipal.jsp");
					dispatcher.forward(request, response);
			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
       
	}

}
