package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
				public boolean upPressed, downPressed, leftPressed, rightPressed, sprinting;
				@Override
				public void keyTyped(KeyEvent e) {
								// Useless in our game
				}

				@Override
				public void keyPressed(KeyEvent e) {


								int code = e.getKeyCode();

								if (code == KeyEvent.VK_SHIFT) {
												sprinting = true;
								}

								// Movement involves both, W, A, S, D and Arrow keys
								if ((code == KeyEvent.VK_UP) || (code == KeyEvent.VK_W)) {
												upPressed = true;
								}

								else if ((code == KeyEvent.VK_DOWN) || (code == KeyEvent.VK_S)) {
												downPressed = true;
								}

								else if ((code == KeyEvent.VK_LEFT) || (code == KeyEvent.VK_A)) {
												leftPressed = true;
								}

								else if ((code == KeyEvent.VK_RIGHT) || (code == KeyEvent.VK_D)) {
												rightPressed = true;
								}


				}

				@Override
				public void keyReleased(KeyEvent e) {

								int code = e.getKeyCode();

								if (code == KeyEvent.VK_SHIFT) {
												sprinting = false;
								}

								if ((code == KeyEvent.VK_UP) || (code == KeyEvent.VK_W)) {
												upPressed = false;
								}

								else if ((code == KeyEvent.VK_DOWN) || (code == KeyEvent.VK_S)) {
												downPressed = false;
								}

								else if ((code == KeyEvent.VK_LEFT) || (code == KeyEvent.VK_A)) {
												leftPressed = false;
								}

								else if ((code == KeyEvent.VK_RIGHT) || (code == KeyEvent.VK_D)) {
												rightPressed = false;
								}
				}
}
