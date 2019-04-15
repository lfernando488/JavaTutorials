package br.com.caelum.jdbc.teste;

import java.sql.SQLException;
import java.util.Calendar;
import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		
		//Connection connection = new ConnectionFactory().getConnection();
		//System.out.println("Conexão aberta!");
		//connection.close();	
	
		Contato contato = new Contato();
		contato.setNome("Caelum7");
		contato.setEmail("contato2@caelum.com.br");
		contato.setEndereco("R. Vergueiro 3186 cj57");
		contato.setDataNascimento(Calendar.getInstance());
	
		// método elegante
		ContatoDao dao = new ContatoDao();
		
		// método elegante
		dao.adiciona(contato);	
		System.out.println("Gravado!");
		
	}

}
