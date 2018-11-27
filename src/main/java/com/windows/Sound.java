package com.windows;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * Sound application class.
 *
 * @author Gasperskyy Aleskey
 * @version 1.0
 */

public class Sound {

	public void playSound() {
		
		Media m = new Media(getClass().getResource("/sounds/Beybleyd_001.mp3").toString());
		new MediaPlayer(m).play();
		
	}
	
}
