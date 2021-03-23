package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Teste {
	public static boolean IsEmpty(Connection con) {
		if (con==null)
			return true;
			else
				return false;
	}
	
	private static Teste conexaoUtil;
	public static Teste getInstance() {
		
		if(conexaoUtil==null) {
			
			conexaoUtil = new Teste();
			
		}
		return conexaoUtil;
	}
	
	//variavel de conexao
	public static Connection createConnectionToMySQL() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco","root","0000");
		return connection;
	}
	
	
	public static void main(String[] args) throws Exception {
		//ver se já tem uma conexao aberta
		
		try {Connection con = createConnectionToMySQL();
		
		//testar
		
			if(IsEmpty(con)==false) {
		
			System.out.println("Conexao estabelecida");
			con.close();
			}
			else {
				System.out.println("Conexao nao estabelecida");
			}
		}catch(Exception e) {
		System.out.println("Conexao nao estabelecida");
		//e.printStackTrace();
	}
		}
	

}
