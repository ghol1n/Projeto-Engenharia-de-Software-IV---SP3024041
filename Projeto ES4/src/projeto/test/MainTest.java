package projeto.test;

import org.junit.*;

import br.com.agenda.aplicacao.*;

public class MainTest {

	@Test
	public void testIsEmpty(){
		boolean b;
		
		b = Main.IsEmpty("abc");
		Assert.assertFalse(b);
		
		b = Main.IsEmpty(null);
		Assert.assertTrue(b);
		
		b = Main.IsEmpty("");
		Assert.assertTrue(b);
	}
}
