/**
 * 
 */
package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Leandro
 *
 */
@WebServlet(urlPatterns="/executa")
public class Controller extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String tarefa = req.getParameter("tarefa");
		//qual tarefa exatamente?
		if (tarefa == null){
			throw new IllegalArgumentException("Você esqueceu de passar a tarefa");
		}
		
		tarefa = "br.com.alura.gerenciador.web." + tarefa;
		Class<?> tipo;
		try {
			tipo = Class.forName(tarefa);
			ITarefa instancia = (ITarefa) tipo.newInstance();
			String pagina = instancia.executa(req, resp);
			RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
			dispatcher.forward(req, resp);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
	}
	
}
