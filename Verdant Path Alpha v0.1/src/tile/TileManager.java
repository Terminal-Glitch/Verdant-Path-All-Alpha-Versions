package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class TileManager {

				GamePanel gp;
				public Tile[] tile;
				public int mapTileNum[][];

				public TileManager(GamePanel gp) {
								this.gp = gp;

								tile = new Tile[100];
								mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];

								getTileImage();
								loadMap("/res/maps/map01.txt");
				}

				public void getTileImage() {
								try {

												String[] tileNames = {
																				"grass", // 0
																				"water", // 1
																				"sand", // 2
																				"tree", // 3
																				"flowery_grass", // 4
																				"mushroom_grass", // 5
																				"path", // 6
																				"pathed_grass_up", // 7
																				"pathed_grass_down", // 8
																				"pathed_grass_left", // 9
																				"pathed_grass_right", // 10
																				"brick", // 11
												};

												for (int tileIndex = 0; tileIndex < tileNames.length; tileIndex++) {
																tile[tileIndex] = new Tile();


																tile[tileIndex].image = ImageIO.read(
																								Objects.requireNonNull(
																																getClass().getResourceAsStream(
																																								"/res/tiles/" + tileNames[tileIndex] + ".png"
																																)
																								)
																);


												}

												tile[1].collision = true; // Water
												tile[3].collision = true; // Tree
												tile[11].collision = true; // Brick
								} catch (IOException e) {
												e.printStackTrace();
								}
				}

				public void loadMap(String filePath) {
								try {
												InputStream is = Objects.requireNonNull(
																				getClass().getResourceAsStream(filePath)
												);

												BufferedReader br = new BufferedReader(new InputStreamReader(is)); // Helpful for reading a file

												int col = 0;
												int row = 0;

												while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
																String line = br.readLine(); // Reads a line of text and will keep doing it until the above condition becomes false

																if (line == null) {
																				break;
																}

																String numbers[] = line.trim().split("\\s+"); // This will remove white spaces from the file

																while (col < gp.maxWorldCol) {

																				int num = Integer.parseInt(numbers[col]);

																				mapTileNum[col][row] = num;
																				col++;
																}

																if (col == gp.maxWorldCol) {
																				col = 0;
																				row++;
																}
												}

												br.close();

								} catch (Exception e) {
												e.printStackTrace();
								}
				}

				public void draw(Graphics2D g2) {
								int worldCol = 0;
								int worldRow = 0;

								while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {

												int tileNum = mapTileNum[worldCol][worldRow];

												int worldX = gp.tileSize * worldCol;
												int worldY = gp.tileSize * worldRow;

												int screenX = worldX + gp.player.screenX - gp.player.worldX;
												int screenY = worldY + gp.player.screenY - gp.player.worldY;

												if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX &&
															worldX - gp.tileSize < gp.player.worldX + gp.player.screenX &&
															worldY + gp.tileSize > gp.player.worldY - gp.player.screenY
															&& worldY - gp.tileSize < gp.player.worldY + gp.player.screenY) {
																g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
												}
												worldCol++;

												if (worldCol == gp.maxWorldCol) {
																worldCol = 0;
																worldRow++;
												}
								}
				}

}
