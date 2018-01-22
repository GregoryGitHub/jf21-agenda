package br.com.caelum.jdbc.teste;

import java.sql.SQLException;

import br.com.caelum.jdbc.ConnectionFactory;

public class TestaConexao {

	public static void main(String[] args) {
		ConnectionFactory cf = new ConnectionFactory();
		cf.getConnection();
		System.out.println("Connection estabilished! ");
		try {
			cf.getConnection().close();
			System.out.println("Connection Closed! ");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
