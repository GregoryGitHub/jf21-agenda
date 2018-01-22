package br.com.caelum.modelo.dao.teste;

import br.com.caelum.modelo.Contato;
import br.com.caelum.modelo.dao.ContatoDao;

public class TestaUpdateContato {
	public static void main(String[] args) {
		ContatoDao dao = new ContatoDao();
		Contato c = dao.get(1);
		
		c.setNome("José Henrique Gregorio");
		
		dao.update(c);
	}
}
