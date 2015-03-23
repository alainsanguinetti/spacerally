/**
 * 
 */
package tests;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

import cartes.Carte;
import cartes.Orientation;

/**
 * @author alain
 *
 */
public class OrientationTest {

	/**
	 * Test method for {@link cartes.Orientation#Orientation(int)}.
	 */
	@Test
	public void testOrientation() {
		Orientation dp = new Orientation ( 10 );
		
		assertNotNull ( dp );
		assertEquals ( 0, dp.getVitesse() );
		assertEquals ( 10, dp.getParam() );
	}

	@Test
	public void testCartes() {
		LinkedList<Carte> tmp = Orientation.cartes( 5, 3 );
		
		assertNotNull ( tmp );
		assertEquals ( 5, tmp.size() );
		assertEquals ( 3, tmp.get(0).getParam() );
		assertEquals ( tmp.get(0).getVitesse(), tmp.get(1).getVitesse() - 1);
	}

}
