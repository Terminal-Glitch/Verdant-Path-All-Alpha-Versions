package main;

import javax.swing.*;

public class Main {
				public static void main(String[] args) {

								// Our game could purely be made in java
								JFrame window = new JFrame();

								ImageIcon icon = new ImageIcon("src/res/icon/icon.png");
								window.setIconImage(icon.getImage());

								window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
								window.setResizable(false); // Window can't be resized
								window.setTitle("Verdant Path - Alpha v0.1");

								GamePanel gamePanel = new GamePanel(); // We have already set the preferred size in GamePanel.java
								window.add(gamePanel);
								window.pack(); // Causes this window to be set to preferred size

								window.setLocationRelativeTo(null); // Will make the window appear at the center
								window.setVisible(true); // So we can actually see the window

								gamePanel.startGameThread();

				}
}
