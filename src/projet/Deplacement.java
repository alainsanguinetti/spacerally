package projet;

/**
 * This is a type of card that do not change orientation of the robot
 * but will change its position on the game 
 * @author alain
 *
 */
public abstract class Deplacement extends Carte {

	/*
	 *            *** Attributes ***
	 */
	/**
	 * distance is the number of tiles that the robot will move
	 */
	private int distance ;
	
	/*
	 *            *** Getters and Setters ***
	 */
	/**
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}

	/**
	 * @param distance the distance to set
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}

	/*
	 *            *** Constructor *** 
	 */
	public Deplacement() {
		// TODO Auto-generated constructor stub
	}

}
