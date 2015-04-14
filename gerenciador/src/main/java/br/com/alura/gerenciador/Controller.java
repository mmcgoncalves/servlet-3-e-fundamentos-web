package br.com.alura.gerenciador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/extecuta")
public class Controller extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String tarefa = req.getParameter("tarefa");
		if(tarefa == null){
			throw new IllegalArgumentException("Você esqueceu de passar uma tarefa");
		}
		
		tarefa = "br.com.alura.gerenciador." + tarefa;
        try {
			Class<?> type = Class.forName(tarefa);
			Tarefa instacia = (Tarefa) type.newInstance();
			String pagina = instacia.executa(req, resp);
			RequestDispatcher requestDispatcher = req.getRequestDispatcher(pagina);
			requestDispatcher.forward(req, resp);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
	}

}
