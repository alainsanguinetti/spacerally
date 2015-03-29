package graphique;

import projet.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class InterfaceGraphique extends JPanel{
	
	private Plateau board;
	private JFrame window;
	
	public InterfaceGraphique (Plateau p ){
		board = p;
		window = new JFrame("ROBORALLY");
		window.setSize(1000, 1000);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setContentPane(this);
		window.setVisible(true);
	}
	
	public void paintComponent(Graphics ig) {
		Font ecrit = new Font("Consolas",Font.BOLD,18);
		ig.setFont(ecrit);
		ig.setColor(Color.white);
		int i,j,k=0;
		for(i=0;i<8;i++) {
			for(j=0;j<8;j++) {
				ig.drawImage(board.getBoard().get(k).getImage(),150+j*90,150+i*90,90,90,this);
				k++;
			}
		}
	}
	
	public void rafraichir() {
		window.repaint();
	}
	
	public static void main(String[] args) {
		Position p = new Position(0,0);
		Robot r1 = new Robot(p);
		Robot r2 = new Robot(p);
		Plateau game = new Plateau(r1,r2);
		InterfaceGraphique g = new InterfaceGraphique(game);
		game.afficherPlateau();
		
		g.rafraichir();
	}
	
	

}
