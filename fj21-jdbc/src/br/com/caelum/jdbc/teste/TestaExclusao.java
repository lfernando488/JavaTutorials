package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class TestaExclusao {

	public static void main(String[] args) {
		Contato contato = new Contato();
		contato.setId((long) 7);
		
		// método elegante
		ContatoDao dao = new ContatoDao();
		
		// método elegante
		dao.remove(contato);	
		System.out.println("EXCLUIDO");

	}

}
