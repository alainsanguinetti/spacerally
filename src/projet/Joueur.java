/**
 * 
 */
package projet;

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
	private Paquet choix;
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
	public Paquet getChoix() {
		return choix;
	}

	/**
	 * @param choix the choix to set
	 */
	public void setChoix(Paquet choix) {
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
		
	}

	public boolean isWinner() {
		// TODO Auto-generated method stub
		return false;
	}

	public void preparerJeu( Paquet tirerCartes ) {
		
	}

}
