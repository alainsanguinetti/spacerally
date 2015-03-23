package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cartes.Carte;
import cartes.Paquet;

public class PaquetTest {
	
	Paquet pq;
	
	@Before
	public void TestPaquet(){
		Carte.cpt_vitesse=0;

		pq = new Paquet ( 84 );
		
		assertNotNull ( pq );
		assertEquals( 84, pq.getTas().size() );
		assertEquals ( 0, pq.getTas().get(0).getVitesse() );
		assertEquals ( 83, pq.getTas().get(83).getVitesse() );
	}

	@Test
	public void testMelanger() {
		pq.melanger();
		
		assertNotNull ( pq );
		assertEquals ( 84, pq.size() );
	}
	
	@Test
	public void testTirerCartes( )
	{
		Paquet test = pq.tirerCartes( 3 );
		
		assertNotNull ( test );
		assertEquals ( 3, test.size() );
	}

}
