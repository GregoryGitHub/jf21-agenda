package br.com.caelum.modelo.dao.teste;

import java.text.SimpleDateFormat;

import br.com.caelum.modelo.Contato;
import br.com.caelum.modelo.dao.ContatoDao;

public class TestaListaContato {

	public static void main(String[] args) {
		ContatoDao dao = new ContatoDao();
		
		for(Contato c : dao.getAll()) {
			
			
			System.out.println("Nome: "+c.getNome());
			System.out.println("Email: "+c.getEmail());
			System.out.println("Endereco: "+c.getEndereco());
			
			SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
			String data = sdf.format(c.getDataNascimento().getTime());
			System.out.println("Data Nascimento: "+data);
			System.out.println("-------------------------------------");
			
		}
		
		System.out.println(dao.get(2).getNome());

	}

}
