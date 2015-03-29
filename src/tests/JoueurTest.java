package tests;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import cartes.Paquet;
import projet.Joueur;
import projet.Robot;
import projet.Position;

public class JoueurTest {
	
	Joueur j;
	
	@Before
	public void testJoueur () {
		Position p = new Position(0,0);
		Robot r = new Robot(p);
		j = new Joueur ( r );
	}

	@Test
	public void testPreparerJeu() {
		
		Paquet pioche = new Paquet ( 84 );
		Paquet main = pioche.tirerCartes(9);
		
		j.preparerJeu ( main );
	}

}
