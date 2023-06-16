package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
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
		String usuario_login = (String) request.getSession().getAttribute("usuario_login");
		
		if (usuario_login!=null) {	
			if (request.getParameter("id_tarefa") != null) {
				int id_tarefa = Integer.parseInt(request.getParameter("id_tarefa"));
				ServletContext servletContext = getServletContext();
		        servletContext.setAttribute("id_tarefa", id_tarefa);
		        
	        
	        	Tarefas tarefa = new Tarefas();
	    		try {
	    			tarefa = tarefaDAO.visualEdicaoTarefa(id_tarefa);
	    		} catch (ClassNotFoundException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	    		request.setAttribute("titulo", tarefa.getTitulo());
	    		request.setAttribute("descricao", tarefa.getDescricao());
	    		request.setAttribute("data_inicio", tarefa.getData_inicio());
	    		request.setAttribute("data_conclusao", tarefa.getData_conclusao());
	    		request.setAttribute("status", tarefa.getStatus());
	    		
	            servletContext.setAttribute("tarefa", tarefa);
	    		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/agendaedicaotarefa.jsp");
	    		dispatcher.forward(request, response);	
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/agendalogin.jsp");
				dispatcher.forward(request, response);
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
		String usuario_login = (String) request.getSession().getAttribute("usuario_login");
		if (usuario_login != null) {
			
			ServletContext servletContext = getServletContext();
			int id = (int) servletContext.getAttribute("id_tarefa");
			String login = (String) servletContext.getAttribute("login");
	        String senha = (String) servletContext.getAttribute("senha");
        
        
        	Usuarios usuario = new Usuarios();
     		usuario.setLogin(login);
     		usuario.setSenha(senha);
     		
     		String titulo = request.getParameter("titulo");
     		String descricao = request.getParameter("descricao");
     		String dataInicioString = request.getParameter("data_inicio");
     		String dataConclusaoString = request.getParameter("data_conclusao"); 
     		String status = request.getParameter("status");
     		
     		if (titulo.length() != 0 || descricao.length() != 0) {
     			Tarefas tarefa = new Tarefas();
         		tarefa.setId(id);
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
         		
         		try {
         			usuarioDAO.loginUsuario(usuario);
         			tarefaDAO.atualizarTarefa(tarefa);
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
	    		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/agendaedicaotarefa.jsp");
     			dispatcher.forward(request, response);
     		}
     		
     		
        } else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/agendalogin.jsp");
			dispatcher.forward(request, response);
		}
        
       
		
		
	}

}
