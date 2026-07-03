package Entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity { // Player will have all behaviours from the Entity class
				GamePanel gp;
				KeyHandler keyH;

				public final int screenX;
				public final int screenY;

				public int hasKey = 0;

				public Player(GamePanel gp, KeyHandler keyH) { // Constructor
								this.gp = gp;
								this.keyH = keyH;

								screenX = gp.screenWidth/2 - (gp.tileSize/2);
								screenY = gp.screenHeight/2 - (gp.tileSize/2);

								solidArea = new Rectangle(15, 24, 16, 22);

								solidAreaDefaultX = solidArea.x;
								solidAreaDefaultY = solidArea.y;

								setDefaultValues();
								getPlayerImage();
				}

				public void setDefaultValues() {
								worldX = gp.tileSize * 55;
								worldY = gp.tileSize * 92;
								speed = 2;
								direction = "down";
								sprinting = false;
				}

				public void getPlayerImage() {

								try {

												// WALKING

												up0 = ImageIO.read(Objects.requireNonNull(
																				getClass().getResourceAsStream("/res/player/walk/player_up0.png")));
												up1 = ImageIO.read(Objects.requireNonNull(
																				getClass().getResourceAsStream("/res/player/walk/player_up1.png")));
												up2 = ImageIO.read(Objects.requireNonNull(
																				getClass().getResourceAsStream("/res/player/walk/player_up2.png")));
												up3 = ImageIO.read(Objects.requireNonNull(
																				getClass().getResourceAsStream("/res/player/walk/player_up3.png")));

												down0 = ImageIO.read(Objects.requireNonNull(
																				getClass().getResourceAsStream("/res/player/walk/player_down0.png")));
												down1 = ImageIO.read(Objects.requireNonNull(
																				getClass().getResourceAsStream("/res/player/walk/player_down1.png")));
												down2 = ImageIO.read(Objects.requireNonNull(
																				getClass().getResourceAsStream("/res/player/walk/player_down2.png")));
												down3 = ImageIO.read(Objects.requireNonNull(
																				getClass().getResourceAsStream("/res/player/walk/player_down3.png")));

												left0 = ImageIO.read(Objects.requireNonNull(
																				getClass().getResourceAsStream("/res/player/walk/player_left0.png")));
												left1 = ImageIO.read(Objects.requireNonNull(
																				getClass().getResourceAsStream("/res/player/walk/player_left1.png")));
												left2 = ImageIO.read(Objects.requireNonNull(
																				getClass().getResourceAsStream("/res/player/walk/player_left2.png")));
												left3 = ImageIO.read(Objects.requireNonNull(
																				getClass().getResourceAsStream("/res/player/walk/player_left3.png")));

												right0 = ImageIO.read(Objects.requireNonNull(
																				getClass().getResourceAsStream("/res/player/walk/player_right0.png")));
												right1 = ImageIO.read(Objects.requireNonNull(
																				getClass().getResourceAsStream("/res/player/walk/player_right1.png")));
												right2 = ImageIO.read(Objects.requireNonNull(
																				getClass().getResourceAsStream("/res/player/walk/player_right2.png")));
												right3 = ImageIO.read(Objects.requireNonNull(
																				getClass().getResourceAsStream("/res/player/walk/player_right3.png")));

												// IDLE

												upIdle0 = ImageIO.read(Objects.requireNonNull(
																				getClass().getResourceAsStream("/res/player/idle/player_up_idle0.png")));
												upIdle1 = ImageIO.read(Objects.requireNonNull(
																				getClass().getResourceAsStream("/res/player/idle/player_up_idle1.png")));
												upIdle2 = ImageIO.read(Objects.requireNonNull(
																				getClass().getResourceAsStream("/res/player/idle/player_up_idle2.png")));
												upIdle3 = ImageIO.read(Objects.requireNonNull(
																				getClass().getResourceAsStream("/res/player/idle/player_up_idle3.png")));

												downIdle0 = ImageIO.read(Objects.requireNonNull(
																				getClass().getResourceAsStream("/res/player/idle/player_down_idle0.png")));
												downIdle1 = ImageIO.read(Objects.requireNonNull(
																				getClass().getResourceAsStream("/res/player/idle/player_down_idle1.png")));
												downIdle2 = ImageIO.read(Objects.requireNonNull(
																				getClass().getResourceAsStream("/res/player/idle/player_down_idle2.png")));
												downIdle3 = ImageIO.read(Objects.requireNonNull(
																				getClass().getResourceAsStream("/res/player/idle/player_down_idle3.png")));

												leftIdle0 = ImageIO.read(Objects.requireNonNull(
																				getClass().getResourceAsStream("/res/player/idle/player_left_idle0.png")));
												leftIdle1 = ImageIO.read(Objects.requireNonNull(
																				getClass().getResourceAsStream("/res/player/idle/player_left_idle1.png")));
												leftIdle2 = ImageIO.read(Objects.requireNonNull(
																				getClass().getResourceAsStream("/res/player/idle/player_left_idle2.png")));
												leftIdle3 = ImageIO.read(Objects.requireNonNull(
																				getClass().getResourceAsStream("/res/player/idle/player_left_idle3.png")));

												rightIdle0 = ImageIO.read(Objects.requireNonNull(
																				getClass().getResourceAsStream("/res/player/idle/player_right_idle0.png")));
												rightIdle1 = ImageIO.read(Objects.requireNonNull(
																				getClass().getResourceAsStream("/res/player/idle/player_right_idle1.png")));
												rightIdle2 = ImageIO.read(Objects.requireNonNull(
																				getClass().getResourceAsStream("/res/player/idle/player_right_idle2.png")));
												rightIdle3 = ImageIO.read(Objects.requireNonNull(
																				getClass().getResourceAsStream("/res/player/idle/player_right_idle3.png")));

								} catch (IOException e) {
												e.printStackTrace();
								}
				}

				public void update() throws IOException {

								if (keyH.sprinting) {
												speed = 3;
												animationSpeed = 6;
								} else {
												speed = 2;
												animationSpeed = 8;
								}

								if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {

												if (keyH.upPressed) {

																if (!direction.equals("up")) {
																				spriteNum = 0;
																				spriteCounter = 0;
																}

																direction = "up";

												}
												else if (keyH.downPressed) {

																if (!direction.equals("down")) {
																				spriteNum = 0;
																				spriteCounter = 0;
																}

																direction = "down";

												}

												else if (keyH.leftPressed) {

																if (!direction.equals("left")) {
																				spriteNum = 0;
																				spriteCounter = 0;
																}

																direction = "left";

												}
												else if (keyH.rightPressed) {

																if (!direction.equals("right")) {
																				spriteNum = 0;
																				spriteCounter = 0;
																}

																direction = "right";

												}

												// Check Tile Collision
												collisionOn = false;
												gp.cChecker.checkTile(this);

												// Check Object Collision
												int objIndex = gp.cChecker.checkObject(this, true);
												pickUpObject(objIndex);

												if (!collisionOn) {

																if (keyH.upPressed) {
																				worldY -= speed;
																}
																else if (keyH.downPressed) {
																				worldY += speed;
																}
																else if (keyH.leftPressed) {
																				worldX -= speed;
																}
																else if (keyH.rightPressed) {
																				worldX += speed;
																}
												}



								}
								spriteCounter++;
								if (spriteCounter > animationSpeed) {

												if (spriteNum == 0) {
																spriteNum = 1;
												}
												else if (spriteNum == 1) {
																spriteNum = 2;
												}
												else if (spriteNum == 2) {
																spriteNum = 3;
												}
												else if (spriteNum == 3) {
																spriteNum = 0;
												}

												spriteCounter = 0;
								}
				}

				public void pickUpObject(int i) throws IOException {
								if (i != 999) {
												String objectName = gp.obj[i].name;

												switch (objectName) {
																case "Key" -> {
																				gp.playSFX(2);
																				hasKey++;
																				gp.obj[i] = null;
																}
																case "Door" -> {
																				if (hasKey > 0) {
																								hasKey--;
																								gp.obj[i].collision = false;
																								gp.obj[i].image = ImageIO.read(
																																Objects.requireNonNull(
																																								getClass().getResourceAsStream("/res/objects/door/door_opened.png")
																																)
																								);
																								gp.playSFX(1);
																				}
																}
												}
								}
				}

				public void draw(Graphics2D g2) {

								BufferedImage image = null;
								switch (direction) {
												case "up" -> {
																if (keyH.upPressed) {

																				if (spriteNum == 0) image = up0;
																				if (spriteNum == 1) image = up1;
																				if (spriteNum == 2) image = up2;
																				if (spriteNum == 3) image = up3;
																} else {
																				if (spriteNum == 0) {
																								image = upIdle0;
																				}
																				if (spriteNum == 1) {
																								image = upIdle1;
																				}
																				if (spriteNum == 2) {
																								image = upIdle2;
																				}
																				if (spriteNum == 3) {
																								image = upIdle3;
																				}
																}
												}
												case "down" -> {
																if (keyH.downPressed) {

																				if (spriteNum == 0) image = down0;
																				if (spriteNum == 1) image = down1;
																				if (spriteNum == 2) image = down2;
																				if (spriteNum == 3) image = down3;
																} else {
																				if (spriteNum == 0) {
																								image = downIdle0;
																				}
																				if (spriteNum == 1) {
																								image = downIdle1;
																				}
																				if (spriteNum == 2) {
																								image = downIdle2;
																				}
																				if (spriteNum == 3) {
																								image = downIdle3;
																				}
																}
												}
												case "left" -> {
																if (keyH.leftPressed) {

																				if (spriteNum == 0) image = left0;
																				if (spriteNum == 1) image = left1;
																				if (spriteNum == 2) image = left2;
																				if (spriteNum == 3) image = left3;
																} else {
																				if (spriteNum == 0) {
																								image = leftIdle0;
																				}
																				if (spriteNum == 1) {
																								image = leftIdle1;
																				}
																				if (spriteNum == 2) {
																								image = leftIdle2;
																				}
																				if (spriteNum == 3) {
																								image = leftIdle3;
																				}
																}

												}
												case "right" -> {
																if (keyH.rightPressed) {

																				if (spriteNum == 0) image = right0;
																				if (spriteNum == 1) image = right1;
																				if (spriteNum == 2) image = right2;
																				if (spriteNum == 3) image = right3;
																} else {
																				if (spriteNum == 0) {
																								image = rightIdle0;
																				}
																				if (spriteNum == 1) {
																								image = rightIdle1;
																				}
																				if (spriteNum == 2) {
																								image = rightIdle2;
																				}
																				if (spriteNum == 3) {
																								image = rightIdle3;
																				}
																}

												}

								}

								if (image != null) {
								    g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
								}


//								Just for debugging
//								g2.drawRect(
//																screenX + solidArea.x,
//																screenY + solidArea.y,
//																solidArea.width,
//																solidArea.height
//								);
				}
}







