package controller;

import java.io.IOException;

import dao.TarefasDAO;
import dao.UsuariosDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuarios;
import model.Tarefas;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;

/**
 * Servlet implementation class AgendaListagemTarefaServlet
 */
@WebServlet("/listagemTarefa")
public class AgendaListagemTarefaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsuariosDAO usuarioDAO = new UsuariosDAO();
	TarefasDAO tarefaDAO = new TarefasDAO();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgendaListagemTarefaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usuario_login = (String) request.getSession().getAttribute("usuario_login");
		
		if (usuario_login != null) {
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
		String usuario_login = (String) request.getSession().getAttribute("usuario_login");
		
		if (usuario_login != null) {
			ServletContext servletContext = getServletContext();
	        String login = (String) servletContext.getAttribute("login");
	        String senha = (String) servletContext.getAttribute("senha");
			String filtro = request.getParameter("tarefa_filtro");
	        
	        Usuarios usuario = new Usuarios();
			usuario.setLogin(login);
			usuario.setSenha(senha);
			
			try {
				
				usuarioDAO.loginUsuario(usuario);
				ArrayList<Tarefas> tarefas = new ArrayList<>();
				tarefas = tarefaDAO.listTarefaFiltro(usuario, filtro);
				request.setAttribute("lista", tarefas);
			
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/agendaprincipal.jsp");
				dispatcher.forward(request, response);
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
	}

}
	
