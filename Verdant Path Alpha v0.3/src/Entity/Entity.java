package Entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

				public int worldX, worldY; // These are public variables meaning we don't have to use super keyword!
				public int speed; // These are public variables meaning we don't have to use super keyword!
				public boolean sprinting;

				public BufferedImage up0;
				public BufferedImage up1;
				public BufferedImage up2;
				public BufferedImage up3;
				public BufferedImage down0;
				public BufferedImage down1;
				public BufferedImage down2;
				public BufferedImage down3;
				public BufferedImage right0;
				public BufferedImage right1;
				public BufferedImage right2;
				public BufferedImage right3;
				public BufferedImage left0;
				public BufferedImage left1;
				public BufferedImage left2;
				public BufferedImage left3;
				public BufferedImage upIdle0;
				public BufferedImage upIdle1;
				public BufferedImage upIdle2;
				public BufferedImage upIdle3;
				public BufferedImage downIdle0;
				public BufferedImage downIdle1;
				public BufferedImage downIdle2;
				public BufferedImage downIdle3;
				public BufferedImage leftIdle0;
				public BufferedImage leftIdle1;
				public BufferedImage leftIdle2;
				public BufferedImage leftIdle3;
				public BufferedImage rightIdle0;
				public BufferedImage rightIdle1;
				public BufferedImage rightIdle2;
				public BufferedImage rightIdle3;
				public String direction;

				public int spriteCounter = 0;
				public int spriteNum = 1;
				public int animationSpeed = 3;

				public Rectangle solidArea;
				public int solidAreaDefaultX, solidAreaDefaultY;
				public boolean collisionOn = false;

}
