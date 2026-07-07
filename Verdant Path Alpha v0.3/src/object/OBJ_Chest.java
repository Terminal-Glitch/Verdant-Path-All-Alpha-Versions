package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Chest extends SuperObjects{


				public OBJ_Chest() {

								name = "Chest";

								try {
												image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/objects/chest/chest.png")));


								} catch (IOException e) {
												e.printStackTrace();
								}
								collision = true;

				}

}

