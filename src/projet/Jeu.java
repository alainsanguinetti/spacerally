package projet;

/**
 * Cette classe est la classe mère du projet, 
 * elle permet de lancer le moteur de jeu
 * et l'interface graphique
 * @author alain
 *
 */
public class Jeu {
	
	//
	//          *** Attributs ***
	//
	// private MoteurDeJeu moteur;
	// private InterfaceGraphique interface_graphique;
	private Paquet pioche;
	
	public static void main ( String[] arg )
	{
		System.out.println("Hihi");
		
		Jeu jeu = new Jeu ( );
		
	}

	public Jeu() {
		// Nous avons besoin d'un paquet mélangé
		try {
			pioche = new Paquet (84);
			pioche.melanger();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Nous avons aussi besoin de 2 joueurs
		
		// d'un plateau de jeu
		
		// D'une interface graphique
		
		// Et d'un moteur de jeu
	}

}
