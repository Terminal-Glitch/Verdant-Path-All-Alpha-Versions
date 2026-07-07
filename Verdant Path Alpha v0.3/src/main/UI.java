package main;

import object.OBJ_Chest;
import object.OBJ_Key;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {

				GamePanel gp;

				Font mono_bold_32;
				Font mono_bold_80;
				BufferedImage KeyImage; // We don't write image because we will display more images than just key
				BufferedImage ChestImage;
				public boolean messageOn = false;
				public String message = "";
				public int messageCounter = 0;
				public boolean gameFinished = false;

				public UI(GamePanel gp) {
								this.gp = gp;

								mono_bold_32 = new Font("Monospaced", Font.BOLD, 32);
								mono_bold_80 = new Font("Monospaced", Font.BOLD, 80);

								OBJ_Key key = new OBJ_Key();
								OBJ_Chest chest = new OBJ_Chest();
								KeyImage = key.image;
								ChestImage = chest.image;
				}

				public void showMessage(String text) {
								message = text;
								messageOn = true;
				}

				public void draw(Graphics2D g2) {

												g2.setFont(mono_bold_32);
												g2.setColor(Color.white);
												g2.drawImage(KeyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
												g2.drawString(" X " + gp.player.hasKey, 64 ,60);

												g2.drawImage(ChestImage, gp.tileSize/2, gp.tileSize * 2, gp.tileSize, gp.tileSize, null);
												g2.drawString(" X " + gp.player.hasChest + " / " + gp.player.totalChests, 64, 128);

												// Display message
												if (messageOn) {
																g2.setFont(g2.getFont().deriveFont(30F));
																g2.drawString(message, gp.tileSize/2, 196);

																messageCounter++;

																if (messageCounter == 150) {
																				messageOn = false;
																				messageCounter = 0;
																}
												}


				}

}
