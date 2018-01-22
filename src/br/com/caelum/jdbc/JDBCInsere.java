package br.com.caelum.jdbc;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public class JDBCInsere {

	public static void main(String[] args) throws SQLException {
		// Conectando Com AutoCloseable
		try (Connection con = new ConnectionFactory().getConnection()) {
			String sql = "INSERT INTO contatos (nome, email, endereco, dataNascimento) values(?,?,?,?)";

			PreparedStatement stm = con.prepareStatement(sql);

			// Preenchendo os Valores
			stm.setString(1, "Pedro");
			stm.setString(2, "pedroaugusto@gmail.com");
			stm.setString(3, "R. Luiz Carlos passos tavares");
			stm.setDate(4, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));

			// Executa
			stm.execute();
			stm.close();

			System.out.println("Gravado com sucesso!");
			con.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}

}
