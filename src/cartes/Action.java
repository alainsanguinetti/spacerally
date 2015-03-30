package cartes;

import projet.Joueur;

/**
 * Describes an action that the game engine will implement
 * @author alain
 *
 */
public class Action {
	
	private Joueur j;
	private Carte mvt;
	
	/**
	 * @return the j
	 */
	public Joueur getJ() {
		return j;
	}

	/**
	 * @param j the j to set
	 */
	public void setJ(Joueur j) {
		this.j = j;
	}

	/**
	 * @return the mvt
	 */
	public Carte getMvt() {
		return mvt;
	}

	/**
	 * @param mvt the mvt to set
	 */
	public void setMvt(Carte mvt) {
		this.mvt = mvt;
	}
	
	/**
	 * Default constructor for an action
	 * @param mvt the card that describes the action
	 * @param j the player that does the action
	 */
	public Action ( Carte mvt, Joueur j ) {
		
		this.setJ(j);
		this.setMvt(mvt);
		
	}

}
