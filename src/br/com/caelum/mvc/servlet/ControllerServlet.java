package br.com.caelum.mvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.mvc.logica.Logica;

@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet {
	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   
	   String parametro  = req.getParameter("logica"); // Recuperando parametros da url
	   String nomeDaClasse = "br.com.caelum.mvc.logica."+ parametro; // Montando nome da classe
	   
	   try {
		   Class classe = Class.forName(nomeDaClasse); // Criando a classe com o nome passado
		   
		   Logica logica = (Logica) classe.newInstance(); // Instanciando a nova classe criada.
		   
		   String pagina = logica.executa(req, res); // executando o método da classe e capturando a string retorno
		   
		   req.getRequestDispatcher(pagina).forward(req, res); // Dispachando o recurso retornado da linha anterior
		   
	   } catch (Exception e) {
		  throw new ServletException("A Lógica de negócios Causou uma exceção",e);
	   }
	}

}
