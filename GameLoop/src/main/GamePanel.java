package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

	// Configurações da Tela
	final int originalTileSize = 16; // 16x16 tile
	final int scale = 3; // multiplicar o tile para 48x48

	final int tileSize = originalTileSize * scale;

	// Configurar o tamanho da tela pela quantidade de tiles
	final int maxScreenCol = 16;
	final int maxScreenRow = 12;
	final int screenWidth = tileSize * maxScreenCol; // 768px
	final int screenHeight = tileSize * maxScreenRow; // 576px
	
	// FPS
	int FPS = 60;

	KeyHandler keyH = new KeyHandler();
	Thread gameThread; // para criar o FPS

	// Configurar a posiçao inicial do jogador
	int playerX = 100;
	int playerY = 100;
	int playerSpeed = 4; // incrementar coordenadas em 4px

	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.BLACK);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH); // Adicionando Evento de teclado ao Painel
		this.setFocusable(true);
	}

	public void startGameThreat() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() { // loop do jogo
		
		// Criando o intervalo de atualização na tela
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime(); // Pegar o tempo inicial
		long currentTime;
		
		while(gameThread != null) {
			currentTime = System.nanoTime(); // Pegar o tempo atual
			// Verificar se já está na hora de atualizar a tela
			delta += (currentTime - lastTime) / drawInterval;
			lastTime = currentTime; // atualizando a última vez que foi desenhada
			
			if(delta >= 1) {
				update();
				repaint();
				delta--;
			}
			
		}
		
	}

	public void update() {

		if (keyH.upPressed == true) {
			playerY -= playerSpeed;
		} else if (keyH.downPressed == true) {
			playerY += playerSpeed;
		} else if (keyH.leftPressed == true) {
			playerX -= playerSpeed;
		} else if (keyH.rightPressed == true) {
			playerX += playerSpeed;
		}

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g); // Desenhar as informações na Painel
		// G2D extend a Graphic -> Meneira mais sofisticada de
		// controlar a geometria, coordenadas, cores, textos...
		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(Color.white);

		g2.fillRect(playerX, playerY, tileSize, tileSize); // Desenhar retângulo

		g2.dispose(); // descartar o g2 para economizar memória

	}

}
