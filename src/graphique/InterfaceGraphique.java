package graphique;

import projet.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class InterfaceGraphique extends JPanel{
	
	private Plateau board;
	private JFrame window;
	private int viesR1;
	private int viesR2;
	
	public InterfaceGraphique (Plateau p, int v1, int v2){
		board = p;
		viesR1 = v1;
		viesR2 = v2;
		window = new JFrame("ROBORALLY");
		window.setSize(1900, 1000);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setContentPane(this);
		window.setVisible(true);
	}
	
	public void paintComponent(Graphics ig) {
		Font ecrit = new Font("Consolas",Font.BOLD,18);
		ig.setFont(ecrit);
		ig.setColor(Color.blue);
		int i,j,k=0;
		//On dessine les cases
		for(i=0;i<8;i++) {
			for(j=0;j<8;j++) {
				ig.drawImage(board.getBoard().get(k).getImage(),50+j*90,50+i*90,90,90,this);
				k++;
			}
		}
		//On dessine les infos de joeurs
		try {
			ig.drawString("Jouer 1", 60, 930);
			ig.drawImage(ImageIO.read(new File("img/player/r1.png")), 50, 820, 90, 90, this);
			for(i=0;i<viesR1;i++) {
				ig.drawImage(ImageIO.read(new File("img/player/1up.png")), 150+i*30, 820, 30, 30, this);
			}
			ig.drawString("Jouer 2", 420, 930);
			ig.drawImage(ImageIO.read(new File("img/player/r2.png")), 410, 820, 90, 90, this);
			for(i=0;i<viesR2;i++) {
				ig.drawImage(ImageIO.read(new File("img/player/1up.png")), 510+i*30, 820, 30, 30, this);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void rafraichir() {
		window.repaint();
	}
	
	/*
	public static void main(String[] args) {
		Position p = new Position(0,0);
		Robot r1 = new Robot(p);
		Robot r2 = new Robot(p);
		Plateau game = new Plateau(r1,r2);
		InterfaceGraphique g = new InterfaceGraphique(game);
		game.afficherPlateau();
		
		g.rafraichir();
	} */
	
	

}
