package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* Contrato lógica para outras classes/servlets logicas.
 * @author José Henrique Gregorio
 * */
public interface Logica {
	
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception;

}
