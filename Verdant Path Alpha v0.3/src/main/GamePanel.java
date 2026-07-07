package main;

import Entity.Player;
import object.SuperObjects;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GamePanel extends JPanel implements Runnable{

				// Screen Setting
				final int originalTileSize = 16;
				final int scale = 3;

				final public int tileSize = (originalTileSize * scale);

				public final int maxScreenCol = 16;
				public final int maxScreenRow = 12;

				public final int screenWidth = ((tileSize) * maxScreenCol);
				public final int screenHeight = ((tileSize) * maxScreenRow);

				public final int maxWorldCol = 100;
				public final int maxWorldRow = 100;

				int FPS = 60;

				TileManager tileM = new TileManager(this);
				KeyHandler keyH = new KeyHandler();
				Thread gameThread;
				public CollisionChecker cChecker = new CollisionChecker(this);
				Sound music = new Sound();
				Sound SFX = new Sound();
				public UI ui = new UI(this);
				public Player player = new Player(this, keyH);
				public AssetSetter aSetter = new AssetSetter(this);
				public SuperObjects obj[] = new SuperObjects[10];


				public GamePanel() {
								this.setPreferredSize(new Dimension(screenWidth, screenHeight));
								this.setBackground(Color.black);
								this.setDoubleBuffered(true); // Used for better rendering performance
								this.addKeyListener(keyH); // Key inputs added to GamePanel
								this.setFocusable(true); // It will keep its focus/check for key inputs
				}

				public void setupObject() {
								aSetter.setObject();
								playMusic(0);
				}

				public void startGameThread() {
								gameThread = new Thread(this); // Passing gamePanel class to the Thread constructor
								gameThread.start();
				}

				@Override
				public void run() { // Core of the game which will update character, to NPCs, enemies and everything

								double drawInterval = 1000000000/FPS;
								double delta = 0;
								long lastTime = System.nanoTime();
								long currentTime;
								long timer = 0;
								long drawCount = 0;

								while (gameThread != null) {
												currentTime = System.nanoTime();
												delta += (currentTime - lastTime) / drawInterval; // Remaining Time
												timer += (currentTime - lastTime);
												lastTime = currentTime;

												if (delta >= 1) {
																try {
																				update();
																} catch (IOException e) {
																				e.printStackTrace();
																}
																repaint();
																delta--;
																drawCount++;
												}

												if (timer >= 1000000000) {
																drawCount = 0;
																timer = 0;
												}
								}
				}

				public void update() throws IOException {
								player.update();
				}

				public void paintComponent(Graphics g) { // Graphics class has many function to draw objects
								super.paintComponent(g);

								Graphics2D g2 = (Graphics2D)g;

								g2.setRenderingHint(
																RenderingHints.KEY_INTERPOLATION,
																RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR
								);

								tileM.draw(g2); // TILE

								for (SuperObjects superObjects : obj) {
												if (superObjects != null) {
																superObjects.draw(g2, this); // OBJECT
												}
								}

								player.draw(g2); // PLAYER

								ui.draw(g2); // UI/Text

								g2.dispose();
				}

				public void playMusic(int i) {
								music.setFile(i);
								music.play();
								music.loop();
				}

				public void stopMusic() {
								music.stop();
				}

				public void playSFX(int i) {
								SFX.setFile(i);
								SFX.play();
				}
}
