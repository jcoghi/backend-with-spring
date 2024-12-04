package main;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("2D Aventura");
		
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);
		
		window.pack(); // para poder ver o painel
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		gamePanel.startGameThreat(); // M�todo de iniciar o jogo
		
	}
}
