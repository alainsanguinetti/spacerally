package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import projet.MoteurDeJeu;

public class MoteurDeJeuTest {
	
	MoteurDeJeu mot;
	
	@Before
	public void testMoteurDeJeu() {
		mot = new MoteurDeJeu();

		assertNotNull ( mot );
	}

	@Test
	public void testGetGagnant() {
		assertEquals ( 0, mot.getGagnant() );
	}
	
	@Test
	public void testConfirm(){
		
		
		assertTrue ( mot.confirm("Taper O") );
		assertFalse ( mot.confirm("Taper N") );
	}



}
