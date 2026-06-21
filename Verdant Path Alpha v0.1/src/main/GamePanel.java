package main;

import Entity.Player;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

				// Screen Setting
				final int originalTileSize = 32;
				final int scale = 2;

				final public int tileSize = (originalTileSize * scale);

				public final int maxScreenCol = 10;
				public final int maxScreenRow = 8;

				public final int screenWidth = ((tileSize) * maxScreenCol);
				public final int screenHeight = ((tileSize) * maxScreenRow);

				public final int maxWorldCol = 50;
				public final int maxWorldRow = 50;
				public final int worldWidth = tileSize * maxWorldCol;
				public final int worldHeight = tileSize * maxWorldRow;

				int FPS = 60;

				TileManager tileM = new TileManager(this);
				KeyHandler keyH = new KeyHandler();
				Thread gameThread;
				public CollisionChecker cChecker = new CollisionChecker(this);
				public Player player = new Player(this, keyH);

				public GamePanel() {
								this.setPreferredSize(new Dimension(screenWidth, screenHeight));
								this.setBackground(Color.black);
								this.setDoubleBuffered(true); // Used for better rendering performance
								this.addKeyListener(keyH); // Key inputs added to GamePanel
								this.setFocusable(true); // It will keep its focus/check for key inputs
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
																update();
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

				public void update() {
								player.update();
				}

				public void paintComponent(Graphics g) { // Graphics class has many function to draw objects
								super.paintComponent(g);

								Graphics2D g2 = (Graphics2D)g;

								g2.setRenderingHint(
																RenderingHints.KEY_INTERPOLATION,
																RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR
								);

								tileM.draw(g2);
								player.draw(g2);
								g2.dispose();
				}
}
