package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {
				Clip clip;
				URL soundURL[] = new URL[30];

				public Sound() {
								soundURL[0] = getClass().getResource("/res/sounds/music/peace_before_the_truth.wav");
								soundURL[1] = getClass().getResource("/res/sounds/SFX/door_sound.wav");
								soundURL[2] = getClass().getResource("/res/sounds/SFX/key_pickup.wav");
								soundURL[3] = getClass().getResource("/res/sounds/SFX/chest_open.wav");
				}

				public void setFile(int i) {

								try {

												AudioInputStream AIS = AudioSystem.getAudioInputStream(soundURL[i]);
												clip = AudioSystem.getClip();
												clip.open(AIS);
								} catch (Exception e) {
												e.printStackTrace();
								}

				}

				public void play() {
								clip.start();
				}

				public void loop() {
								clip.loop(Clip.LOOP_CONTINUOUSLY);
				}

				public void stop() {
								clip.stop();
				}
}

