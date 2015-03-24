/**
 * 
 */
package projet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import cartes.Carte;
import cartes.Paquet;

/**
 * @author Eder JIMENEZ
 *
 */
public class Joueur {
	
	/**
	 * Attributs
	 */
	private Robot rob;
	private Carte choix[] = new Carte[5];
	private Paquet main;
	private int nbrDrapeaux;
	
	/**
	 * @return the rob
	 */
	public Robot getRob() {
		return rob;
	}

	/**
	 * @param rob the rob to set
	 */
	public void setRob(Robot rob) {
		this.rob = rob;
	}

	/**
	 * @return the choix
	 */
	public Carte[] getChoix() {
		return choix;
	}

	/**
	 * @param choix the choix to set
	 */
	public void setChoix(Carte[] choix) {
		this.choix = choix;
	}

	/**
	 * @return the main
	 */
	public Paquet getMain() {
		return main;
	}

	/**
	 * @param main the main to set
	 */
	public void setMain(Paquet main) {
		this.main = main;
	}

	/**
	 * @return the nbrDrapeaux
	 */
	public int getNbrDrapeaux() {
		return nbrDrapeaux;
	}

	/**
	 * @param nbrDrapeaux the nbrDrapeaux to set
	 */
	public void setNbrDrapeaux(int nbrDrapeaux) {
		this.nbrDrapeaux = nbrDrapeaux;
	}

	/**
	 * Constructeur
	 * @param r le robot qui représente le joueur
	 */
	public Joueur(Robot r) {
		
		main = new Paquet ();
	}

	/**
	 * Asks the player to order cards to move the robot
	 * @param cartes the cards that the player will be able to choose from
	 */
	public void preparerJeu( Paquet cartes ) {
		
		boolean fini = false;
		int emplacement, carte;
		this.main = cartes;
		
		do
		{
			// Afficher la main
			main.toString();
			choix.toString();
			
			// Choisir un emplacement
			emplacement = demanderChiffre ( "emplacement", 0, 4 );
			
			// Soit on valide
			if ( emplacement == -1)
			{
				fini = true;
				break;
			} else {
				
				// Choisir une carte de la main
				carte = demanderChiffre ( "carte", 0, 8 );
				
				if ( carte != -1 )
				{
					mettreCarte ( emplacement, carte );
				}
				else
				{
					fini = true;
					break;
				}
			}
			
			// Tant que le joueur n'a pas validé ses choix
		} while ( !fini );
	}

	/**
	 * This function will take a card from the hand of the player 
	 * and put it at the specified slot in the cards that will be played.
	 * If there is already a card, it is removed.
	 * @param emplacement the number of the slot where it will be placed
	 * @param carte the card that will be put on the slot
	 */
	private void mettreCarte(int emplacement, int carte) {
		
		Carte temp = null;
		
		// Tester si la carte existe dans la main
		if ( main.get(carte) == null ){
			return;
		}

		// Tester si la case est libre
		if ( choix[emplacement] != null )
		{
			// Si non, on remet la carte dans la main
			temp = choix[emplacement];
			choix[emplacement] = null;
		}
			
		// On met la carte de la main dans la place souhaitée
		choix[emplacement] = main.get(carte) ;
		
		// Si besoin, on remet la carte qui était à la place dans la main
		if ( temp != null )
			main.add(temp);
		
	
	}

	/**
	 * Affiche un texte et demande à l'utilisateur de rentrer un chiffre entre 2 valeurs
	 * @param string le texte de personnalisation
	 * @param i la valeur limite basse
	 * @param j la valeur limite haute
	 * @return la valeur choisie par l'utilisateur ou -1 si l'utilisateur préfère sortir
	 */
	private int demanderChiffre(String string, int i, int j) {
		int emplacement = 0;
		
		do { 
			// Afficher et demander
			System.out.println("Choisissez un(e) " 
								+ string 
								+ " [ " 
								+ i
								+ " - "
								+ j
								+ " ], ou V pour valider et sortir.");
			
			// Lecture du flux d'entrée
			String inputData = "";
			BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
	
			// Lecture du int
			try { 
				inputData = inputReader.readLine(); 
			} catch(IOException e) { 
				System.out.println("Error reading keyboard input");
			}
			
			// Soit on sort
			if ( inputData.equals ( "V" ) )
			{
				return -1;
			}
			
			// Soit on cherche un numéro d'emplacement
			emplacement = Integer.parseInt(inputData);

			// Vérifier la validité du choix
		} while ( emplacement < i || emplacement > j );

		return emplacement;
	}

}
