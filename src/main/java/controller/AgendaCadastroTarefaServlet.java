package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.UsuariosDAO;
import jakarta.servlet.RequestDispatcher;
import dao.TarefasDAO;

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
		doGet(request, response);
	}

}
