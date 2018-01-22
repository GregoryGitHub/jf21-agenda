package br.com.caelum.modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.modelo.Contato;

public class ContatoDao {
	
	private Connection con;

	//Construtor
	public ContatoDao() {
		this.con = new  ConnectionFactory().getConnection();
	}
	
	//==============DAO==============//
	
    /* Insere um contato no banco de dados.*/
	public void add(Contato contato) {
		
		// Conectando Com AutoCloseable
		try  {
			String sql = "INSERT INTO contatos (nome, email, endereco, dataNascimento) values(?,?,?,?)";

			PreparedStatement stm = con.prepareStatement(sql);

			// Preenchendo os Valores
			stm.setString(1, contato.getNome());
			stm.setString(2, contato.getEmail());
			stm.setString(3, contato.getEndereco());
			stm.setDate(4, new java.sql.Date(contato.getDataNascimento().getTimeInMillis()));

			// Executa
			stm.execute();
			stm.close();

			System.out.println("Gravado com sucesso!");
			con.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/*Retorna uma lista de todos os contatos*/
	public List<Contato> getAll() {
		List<Contato> lista = new ArrayList<Contato>();
		String sql = "SELECT * FROM contatos;";
		try {
			PreparedStatement stmt= con.prepareStatement(sql);
			ResultSet r = stmt.executeQuery();
			
			while(r.next()) {
				//Instanciando e populando novo objeto.
				Contato c = new Contato();
				c.setId(r.getLong("id"));
				c.setNome(r.getString("nome"));
				c.setEmail(r.getString("email"));
				c.setEndereco(r.getString("endereco"));
				Calendar nascimento = Calendar.getInstance();
				nascimento.setTime(r.getDate("dataNascimento"));
				c.setDataNascimento(nascimento);
				//Adicionando a Lista
				lista.add(c);
			}
			r.close();
			stmt.close();
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	/*Retorna um contato informando um ID*/
	public Contato get(int id) {
		Contato c = new Contato();
		String sql = "SELECT * FROM contatos WHERE id = ?;";
		try {
			PreparedStatement stmt= con.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet r = stmt.executeQuery();
			
			while(r.next()) {
				//Instanciando e populando novo objeto.
				c.setId(r.getLong("id"));
				c.setNome(r.getString("nome"));
				c.setEmail(r.getString("email"));
				c.setEndereco(r.getString("endereco"));
				Calendar nascimento = Calendar.getInstance();
				nascimento.setTime(r.getDate("dataNascimento"));
				c.setDataNascimento(nascimento);
				
			}
			r.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}
	
	/*Atualiza um contato existente*/
	public void update(Contato contato) {
		try  {
			String sql = "UPDATE contatos SET nome=?, email=?, endereco=?, dataNascimento=? WHERE id = ?";

			PreparedStatement stm = this.con.prepareStatement(sql);

			// Preenchendo os Valores
			stm.setString(1, contato.getNome());
			stm.setString(2, contato.getEmail());
			stm.setString(3, contato.getEndereco());
			stm.setDate(4, new java.sql.Date(contato.getDataNascimento().getTimeInMillis()));
			stm.setLong(5, contato.getId());
			
			// Executa
			stm.execute();
			stm.close();

			System.out.println("Atualizado com sucesso!");

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void delete(Contato contato) {
		try  {
			String sql = "DELETE FROM contatos WHERE id = ?";

			PreparedStatement stm = this.con.prepareStatement(sql);

			// Preenchendo os Valores
			stm.setLong(1, contato.getId());
			
			// Executa
			stm.execute();
			stm.close();

			System.out.println("O Contato foi Apagado!");

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
