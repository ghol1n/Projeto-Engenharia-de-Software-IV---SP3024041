package br.com.agenda.aplicacao;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

public class Main {
	
	public static boolean IsEmpty(String s) {
		if (s==null)
			return true;
		else
			if(s=="")
				return true;
			else
				return false;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String Nome = "Gabriel Bertholin";
		String Fone = "11999999999";
		String Email = "";
		
		if (IsEmpty(Nome) == true) {
			System.out.println("O nome está vazio. Programa encerrado");
			System.exit(0);
		}
		if (IsEmpty(Fone) == true) {
			System.out.println("O telefone está vazio. Programa encerrado");
			System.exit(0);
		}
		if (IsEmpty(Email) == true) {
			System.out.println("O Email está vazio. Programa encerrado");
			System.exit(0);
		}
		
		Contato contato = new Contato();
		contato.setNome(Nome);
		contato.setFone(Fone);
		contato.setEmail(Email);
		
		ContatoDAO contatoDao = new ContatoDAO();
		contatoDao.create(contato);
		
		
		//visualizar os registros do bd
		for(Contato c : contatoDao.getContatos()) {
			System.out.println("Contato: "+c.getNome());
		}

	}

}
