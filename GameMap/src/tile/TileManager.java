package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {

	GamePanel gp;
	Tile[] tile;
	String[] types;
	int mapTileNum[][];
	
	
	public TileManager(GamePanel gp) {
		this.gp = gp;
		tile = new Tile[15];
		types = new String[] {"earth.png", "grass.png", "sand.png", "tree.png", "wall.png", "water.png"};
		mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
		getTileImage();
	}
	
	public void getTileImage() {
		try {
			
			for(int i = 0; i < types.length; i++) {
				tile[i] = new Tile();
				tile[i].image = ImageIO.read(getClass().getResource("/res/tiles/"+types[i]));
			}

		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void loadMap() {
		
		try {
			InputStream is = getClass().getResourceAsStream("/maps/fist.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			while(col < gp.maxScreenCol && row < gp.maxScreenRow) {
				
				String line = br.readLine();
				
				while(col < gp.maxScreenCol) {
					String numbers[] = line.split(" ");
					int num = Integer.parseInt(numbers[col]);
					mapTileNum[col][row] = num;
					col++;
				}
				if(col == gp.maxScreenCol) {
					col = 0;
					row++;
				}
				br.close();
		}
		}catch(IOException e) {
			
		}
	}
	
	public void drae(Graphics2D g2) {
		for(int i = 0; i < types.length; i++) {
//Para criação do mapa
			int col = 0;
			int row = 0;
			int x = 0;
			int y = 0;
			
			while(col < gp.maxScreenCol && row < gp.maxScreenRow) {
				g2.drawImage(tile[3].image, x, y, gp.tileSize, gp.tileSize,null);
				col++;
				x += gp.tileSize;
				
				if(col == gp.maxScreenCol) {
					y +=gp.tileSize;
					row++;
					col = 0;
					x = 0;
				}
				
			}
			
		}
	}
	
}
