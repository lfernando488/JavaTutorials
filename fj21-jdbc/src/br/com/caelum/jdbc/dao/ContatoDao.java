package br.com.caelum.jdbc.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDao {

	private Connection connection;
	
	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Contato contato) {
		String sql = "insert into contatos "+
				"(nome,email,endereco,dataNascimento)" +
				"values (?,?,?,?)";
		
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
		
			PreparedStatement stmt = connection.prepareStatement(sql);
					
			stmt.setString(1,contato.getNome());
			stmt.setString(2,contato.getEmail());
			stmt.setString(3,contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			// executa
			stmt.execute();
			stmt.close();
		}
		catch(SQLException e){
			throw new RuntimeException(e);
		}
		
	}
	
	//Metodo para listar contatos
	public List<Contato> getLista() {
		
		try {
			List<Contato> contatos = new ArrayList<Contato>();		//Instanciando um LIST do objeto Contato 
			PreparedStatement stmt = this.connection.				//Criando PreparedStatement 
			prepareStatement("select * from contatos");				//Passando Comando SQL
			ResultSet rs = stmt.executeQuery();						//Obtento resultado da Query SQL com ResultSet
		
			while (rs.next()) {										//Passando linha por linha dos valores retornados
				
				// criando o objeto Contato
				Contato contato = new Contato();					//Instanciando objeto contato
				contato.setId(rs.getLong("id"));					//Setando ID
				contato.setNome(rs.getString("nome"));				//Setando nome
				contato.setEmail(rs.getString("email"));			//Setando email
				contato.setEndereco(rs.getString("endereco"));		//Setando endereço
	
				// montando a data através do Calendar
				Calendar data = Calendar.getInstance();				//Instanciando objeto calendar
				data.setTime(rs.getDate("dataNascimento"));			//Setando data de nascimento
				contato.setDataNascimento(data);	
		
				// adicionando o objeto à lista
				contatos.add(contato);	
			}
			
			rs.close();			//Encerrando o result Set
			stmt.close();		//Encerrando Statement
			return contatos;	//retornando a List
			
			} catch (SQLException e) {
				throw new RuntimeException(e);		//Tratamento de excessoes SQL
			}
		 }
	
	public void altera(Contato contato) {
		String sql = "update contatos set nome=?, email=?, endereco=?," +
		"dataNascimento=? where id=?";
		try {
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEmail());
		stmt.setString(3, contato.getEndereco());
		stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
		stmt.setLong(5, contato.getId());
		stmt.execute();
		stmt.close();
		
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
	public void remove(Contato contato) {
		String sql = "delete from contatos where id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}	
	}
	
	
	
}
