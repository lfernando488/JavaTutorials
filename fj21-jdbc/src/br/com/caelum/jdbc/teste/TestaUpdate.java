package br.com.caelum.jdbc.teste;

import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaUpdate {

	public static void main(String[] args) {
		Contato contato = new Contato();
		
		contato.setNome("Caelum22");
		contato.setEmail("contato2@caelum.com.br");
		contato.setEndereco("R. Vergueiro 3186 cj57");
		contato.setDataNascimento(Calendar.getInstance());
		contato.setId((long) 2);
		// método elegante
		ContatoDao dao = new ContatoDao();
		
		// método elegante
		dao.altera(contato);	
		System.out.println("Gravado!");

	}

}
