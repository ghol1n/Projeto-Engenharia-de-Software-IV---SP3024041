package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import Conexao.Teste;
import br.com.agenda.model.Contato;

public class ContatoDAO {
	
	//CRUD
	public static boolean IsEmpty(String s) {
		if (s==null)
			return true;
		else
			if(s=="")
				return true;
			else
				return false;
	}
	
	public void create(Contato contato) {
		
		String sql = "INSERT INTO contatos(nome, fone, email) VALUES (?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			//criar conexao com o bd
			conn = Teste.createConnectionToMySQL();
			//criamos uma prepared... para executar query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			
			if (IsEmpty(contato.getNome()) == true) {
				System.out.println("O nome está vazio. Programa encerrado");
				System.exit(0);
			}
			if (IsEmpty(contato.getFone()) == true) {
				System.out.println("O telefone está vazio. Programa encerrado");
				System.exit(0);
			}
			if (IsEmpty(contato.getNome()) == true) {
				System.out.println("O Email está vazio. Programa encerrado");
				System.exit(0);
			}
				
			pstm.setString(1, contato.getNome());
			pstm.setString(2, contato.getFone());
			pstm.setString(3, contato.getEmail());
			//executar a query
			pstm.execute();
		//	System.out.println("Dados cadastrados com SUCESSO.\n\n Aluno: Gabriel Bertholin\nSP3024041");
			System.out.println("Dados cadastrados com SUCESSO.\n");

			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			//fechar conn
			try {
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		
		
		
	}

	public List<Contato> getContatos(){
		String sql = "SELECT * FROM contatos";
		
		List<Contato> contatos = new ArrayList<Contato>();
		Connection conn = null;
		PreparedStatement pstm = null;
		// classe que vai recuperar os dados do banco
		ResultSet rset = null;
		
		try {
			conn = Teste.createConnectionToMySQL();
			pstm = (PreparedStatement)  conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			//Enquanto tiver informacao, vai rodar
			while(rset.next()) {
				Contato contato = new Contato();
				//recuperar id
				contato.setId(rset.getInt("id"));
				//recuperar nome
				contato.setNome(rset.getString("nome"));
				//recuperar fone
				contato.setFone(rset.getString("fone"));
				//recuperar email
				contato.setEmail(rset.getString("email"));
				
				contatos.add(contato);
				
			}
		}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}finally {
				try {
					if(rset!=null) {
						rset.close();
					}
					if(pstm!=null) {
						pstm.close();
					}
					if(conn!=null) {
						conn.close();
					}
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}//fim finally
			
			return contatos;
	
		//fim try
		
	}
	
}
