package graphique;

import projet.*;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.SlickException;

public class InterfaceGraphique extends BasicGame{
	
	public InterfaceGraphique ( ){
		super("Robo Rally");
	}
	
	public static void main(String[] args) {
		try {
			AppGameContainer game = new AppGameContainer(new InterfaceGraphique(),450,600,false);
			game.setTargetFrameRate(60);
			game.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		//Called after every update, you draw the game here
		
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		//Called when start the game for the first time. This is where you do things like load settings, sprites, etc and create the basic game layout
		
	}

	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {
		//This is where you handle all game logic. If anything moves, this is definitely where you'd handle it.
		
	}

}
