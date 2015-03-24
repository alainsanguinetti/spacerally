package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import cartes.Paquet;
import projet.Joueur;
import projet.Robot;

public class JoueurTest {
	
	Joueur j;
	
	@Before
	public void testJoueur () {
		Robot r = new Robot();
		j = new Joueur ( r );
	}

	@Test
	public void testPreparerJeu() {
		
		Paquet pioche = new Paquet ( 84 );
		Paquet main = pioche.tirerCartes(9);
		
		j.preparerJeu ( main );
	}

}
