/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import projet.Jeu;

/**
 * @author alain
 *
 */
public class JeuTest {

	/**
	 * Test method for {@link projet.Jeu#Jeu()}.
	 */
	@Test
	public void testJeu() {
		Jeu jeu = new Jeu();
		
		assertNotNull ( jeu );
	}
	
	

}
