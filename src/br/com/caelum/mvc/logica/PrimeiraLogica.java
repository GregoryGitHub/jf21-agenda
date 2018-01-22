package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrimeiraLogica implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("Executando a primeira logica....");
		System.out.println("Retornando o nome da página JSP...");
		
		//Aqui retorna um nome de uma página ou recurso (servlet).
		return "primeira-logica.jsp";
	}

}
