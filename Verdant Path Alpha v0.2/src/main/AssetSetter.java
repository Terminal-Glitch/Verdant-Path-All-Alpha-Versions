package main;

import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_Key;

public class AssetSetter {

				GamePanel gp;

				public AssetSetter(GamePanel gp) {
								this.gp = gp;
				}

				public void setObject() {
								gp.obj[0] = new OBJ_Key();
								gp.obj[0].worldX = 10 * gp.tileSize;
								gp.obj[0].worldY = 8 * gp.tileSize;

								gp.obj[1] = new OBJ_Door(gp);
								gp.obj[1].worldX = 30 * gp.tileSize;
								gp.obj[1].worldY = 32 * gp.tileSize;

								gp.obj[2] = new OBJ_Chest();
								gp.obj[2].worldX = 33 * gp.tileSize;
								gp.obj[2].worldY = 23 * gp.tileSize;


								gp.obj[3] = new OBJ_Key();
								gp.obj[3].worldX = 75 * gp.tileSize;
								gp.obj[3].worldY = 41 * gp.tileSize;

								gp.obj[4] = new OBJ_Door(gp);
								gp.obj[4].worldX = 54 * gp.tileSize;
								gp.obj[4].worldY = 24 * gp.tileSize;

								gp.obj[5] = new OBJ_Chest();
								gp.obj[5].worldX = 54 * gp.tileSize;
								gp.obj[5].worldY = 22 * gp.tileSize;


				}

}
