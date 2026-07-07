package object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class OBJ_Key extends SuperObjects{

				public OBJ_Key() {
								name = "Key";

								try {
												image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/objects/key/key.png")));
								} catch (IOException e) {
												e.printStackTrace();
								}

				}

}
