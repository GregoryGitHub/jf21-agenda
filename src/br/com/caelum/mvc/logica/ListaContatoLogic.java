package br.com.caelum.mvc.logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.modelo.Contato;
import br.com.caelum.modelo.dao.ContatoDao;

public class ListaContatoLogic implements Logica{

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		// Monta a lista de contatos
        List<Contato> contatos = new ContatoDao().getAll();

        // Guarda a lista no request
        req.setAttribute("contatos", contatos);

        return "lista-contatos-jstl.jsp";



	}

}