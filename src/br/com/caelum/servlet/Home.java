package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns= {"/home","/index","/welcome"})
public class Home extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1864873876406363492L;

	public void init(ServletConfig config) throws ServletException{
		super.init(config); //Reescrevendo da classe pai. Não esqueçendo o super.
		log("Servelt Criada");
	}
	
	public void destroy(ServletConfig config) throws ServletException{
		super.destroy(); //Reescrevendo da classe pai. Não esqueçendo o super.
		log("Servelt Destruida");
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		
		writer.println("Home Servlet Com Anotations");
		writer.println("Acesse com /home ou /index ou ainda /welcome");
	}
}
