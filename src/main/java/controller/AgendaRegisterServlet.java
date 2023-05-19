package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.UsuariosDAO;
import model.Usuarios;

/**
 * Servlet implementation class AgendaRegisterServlet
 */
@WebServlet(urlPatterns = {"/register", "/"})
public class AgendaRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UsuariosDAO usuarioDAO = new UsuariosDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgendaRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/agendaregister.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String nome = request.getParameter("nome");
		String email = request.getParameter("senha");
		
		Usuarios usuario = new Usuarios();
		usuario.setLogin(login);
		usuario.setSenha(senha);
		usuario.setNome(nome);
		usuario.setEmail(email);
		
		try {
			usuarioDAO.registerUsuario(usuario);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/agendalogin.jsp");
		dispatcher.forward(request, response);
		
	}

}
