package object;

import Entity.Player;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Door extends SuperObjects{

				GamePanel gp;
				public OBJ_Door(GamePanel gp) {
								this.gp = gp;
								name = "Door";

								try {
												image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/objects/door/door.png")));


								} catch (IOException e) {
												e.printStackTrace();
								}
								collision = true;

				}


}
