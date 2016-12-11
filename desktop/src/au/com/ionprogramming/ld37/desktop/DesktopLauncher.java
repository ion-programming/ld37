package au.com.ionprogramming.ld37.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import au.com.ionprogramming.ld37.MainGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Is there room?";
        config.width = 864;
        config.height = 480;
		config.resizable = false;
		new LwjglApplication(new MainGame(), config);
	}
}
