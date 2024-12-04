package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable {

	// Configurações da Tela
	final int originalTileSize = 16; // 16x16 tile
	final int scale = 3; // multiplicar o tile para 48x48

	public final int tileSize = originalTileSize * scale;

	// Configurar o tamanho da tela pela quantidade de tiles
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12;
	public final int screenWidth = tileSize * maxScreenCol; // 768px
	public final int screenHeight = tileSize * maxScreenRow; // 576px
	
	// FPS
	int FPS = 60;

	//CRIANDO EVENTOS DE TECLADO
	KeyHandler keyH = new KeyHandler();
	// CRIANDO O FPS DO JOGO
	Thread gameThread; 
	// INSTANCIANDO UM JOGADOR -> * APÓS A CRIAÇÃO DA CLASSE PLAYER *
	Player player = new Player(this, keyH);
	// Tile Manager
	TileManager tileM = new TileManager(this);

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
		player.update();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g); // Desenhar as informações na Painel
		// G2D extend a Graphic -> Meneira mais sofisticada de
		// controlar a geometria, coordenadas, cores, textos...
		Graphics2D g2 = (Graphics2D) g;
		// Primeiro printar o mapa e, depois o personagem -> É desenhado por camadas;
		tileM.drae(g2);
		player.draw(g2);
		g2.dispose(); // descartar o g2 para economizar memória

	}

}
