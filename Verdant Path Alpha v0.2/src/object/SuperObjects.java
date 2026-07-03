package object;

import Entity.Player;
import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;


public class SuperObjects {
				public BufferedImage image;
				public String name;
				public boolean collision = false;
				public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
				public int solidAreaDefaultX = solidArea.x;
				public int solidAreaDefaultY = solidArea.y;
				public int worldX, worldY;

				public void draw(Graphics2D g2, GamePanel gp) {
								int screenX = worldX + gp.player.screenX - gp.player.worldX;
								int screenY = worldY + gp.player.screenY - gp.player.worldY;

								if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
																worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
																worldY + gp.tileSize > gp.player.worldY - gp.player.screenY
																&& worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
												g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
								}
				}
}
