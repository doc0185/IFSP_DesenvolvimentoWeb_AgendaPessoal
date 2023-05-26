package controller;

import java.io.IOException;

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
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext servletContext = getServletContext();
		int id = (int) servletContext.getAttribute("id_tarefa");
		
	}

}
