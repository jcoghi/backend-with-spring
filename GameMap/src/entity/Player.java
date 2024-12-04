package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {

	GamePanel gp;
	KeyHandler keyH;

	public Player(GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH;
		setDefaultValues();
		getPlayerImage();
	}

	public void setDefaultValues() {
		x = 100;
		y = 100;
		speed = 4;
		direction = "down";
	}

	public void getPlayerImage() {
		try {
			down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/1.jpg"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/2.jpg"));
			down3 = ImageIO.read(getClass().getResourceAsStream("/res/player/1.jpg"));
			down4 = ImageIO.read(getClass().getResourceAsStream("/res/player/3.jpg"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/4.jpg"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/5.jpg"));
			left3 = ImageIO.read(getClass().getResourceAsStream("/res/player/4.jpg"));
			left4 = ImageIO.read(getClass().getResourceAsStream("/res/player/6.jpg"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/7.jpg"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/8.jpg"));
			right3 = ImageIO.read(getClass().getResourceAsStream("/res/player/7.jpg"));
			right4 = ImageIO.read(getClass().getResourceAsStream("/res/player/9.jpg"));
			up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/10.jpg"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/11.jpg"));
			up3 = ImageIO.read(getClass().getResourceAsStream("/res/player/10.jpg"));
			up4 = ImageIO.read(getClass().getResourceAsStream("/res/player/12.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Atualiza a tela 60 vezes por segundo. 
	public void update() {
		if (keyH.upPressed == true) {
			direction = "up";
			y -= speed;
		} else if (keyH.downPressed == true) {
			direction = "down";
			y += speed;
		} else if (keyH.leftPressed == true) {
			direction = "left";
			x -= speed;
		} else if (keyH.rightPressed == true) {
			direction = "right";
			x += speed;
		}
		//A cada 15 frames troca a imagem
		spriteCounter++; 
		if(spriteCounter > 10) {
			if(spriteNum == 1) {
				spriteNum++;
			} else if(spriteNum == 2) {
				spriteNum++;
			} else if(spriteNum == 3) {
				spriteNum++;
			} else if (spriteNum == 4) {
				spriteNum = 1;
			}
			spriteCounter = 0;
		}
		
	}

	public void draw(Graphics2D g2) {

		BufferedImage image = null;
		switch (direction) {
		case "up" -> {
			if(spriteNum == 1) {
				image = up1;
			}
			if(spriteNum == 2) {
				image = up2;
			}
			if(spriteNum == 3) {
				image = up3;
			}
			if(spriteNum == 4) {
				image = up4;
			}
		}
		case "down" -> {
			if(spriteNum == 1) {
				image = down1;
			}
			if(spriteNum == 2) {
				image = down2;
			}
			if(spriteNum == 3) {
				image = down3;
			}
			if(spriteNum == 4) {
				image = down4;
			}
		}
		case "left" -> {
			if(spriteNum == 1) {
				image = left1;
			}
			if(spriteNum == 2) {
				image = left2;
			}
			if(spriteNum == 3) {
				image = left3;
			}
			if(spriteNum == 4) {
				image = left4;
			}
		}
		case "right" -> {
			if(spriteNum == 1) {
				image = right1;
			}
			if(spriteNum == 2) {
				image = right2;
			}
			if(spriteNum == 3) {
				image = right3;
			}
			if(spriteNum == 4) {
				image = right4;
			}
		}
		}

		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
	}

}
