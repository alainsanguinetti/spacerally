package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import cartes.Carte;
import cartes.Paquet;

public class PaquetTest {

	@Test
	public void testPaquet() {
		Paquet pq = new Paquet ( );
		
		assertNotNull ( pq );
		assertEquals( 84, pq.getTas().size() );
		assertEquals ( 0, pq.getTas().get(0).getVitesse() );
		assertEquals ( 83, pq.getTas().get(83).getVitesse() );
	}

	@Test
	public void testMelanger() {
		Paquet pq = new Paquet ( );
		
		assertNotNull ( pq );
		assertEquals ( 84, pq.size() );
	}

}
