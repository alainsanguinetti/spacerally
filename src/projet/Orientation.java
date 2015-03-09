package projet;

/**
 * Describes the cards that performs a rotation of the robot
 * @author alain
 *
 */
public abstract class Orientation extends Carte {
	
	/**
	 * The angle of the rotation 
	 *    ** 1 is 90° counter-clockwise,
	 *    ** -1 is 90° clockwise
	 *    ** 2 is 180°
	 */
	private int angle;

	public Orientation() {
		// TODO Auto-generated constructor stub
	}

}
