package projeto.test;

import org.junit.*;

import br.com.agenda.dao.*;

public class ContatoDAOTest {

	@Test
	public void testIsEmpty(){
		boolean b;
		
		b = ContatoDAO.IsEmpty("abc");
		Assert.assertFalse(b);
		
		b = ContatoDAO.IsEmpty(null);
		Assert.assertTrue(b);
		
		b = ContatoDAO.IsEmpty("");
		Assert.assertTrue(b);
	}
	
	
	
}
