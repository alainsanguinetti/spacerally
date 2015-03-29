package cartes;

import java.awt.Image;

/**
 * This class describes a general card
 * @author alain
 *
 */
public abstract class Carte {
	
	/*
	 *            *** Attributes ***
	 */
	/**
	 * Unique number to give priority to a card over another card
	 */
	private int vitesse;
	/**
	 * Counter to give every card a unique vitesse
	 */
	public static int cpt_vitesse = 0;
	/**
	 * Each has a parameter.
	 */
	private int param;
	
	protected Image img;
	/*
	 *             *** Getters and setters ***
	 */
	/**
	 * @return the vitesse
	 */
	public int getVitesse() {
		return vitesse;
	}

	/**
	 * @param vitesse the vitesse to set
	 */
	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	/**
	 * @return the param
	 */
	public int getParam() {
		return param;
	}

	/**
	 * @param param the param to set
	 */
	public void setParam(int param) {
		this.param = param;
	}

	/*
	 *            *** Constructors ***
	 */
	/**
	 * Constructor for all cards, each card has a unique "vitesse"
	 */
	public Carte ( ){
		
		setVitesse(cpt_vitesse);
		
		cpt_vitesse++;
	}
	
	/*
	 *           *** Functions
	 */

}
