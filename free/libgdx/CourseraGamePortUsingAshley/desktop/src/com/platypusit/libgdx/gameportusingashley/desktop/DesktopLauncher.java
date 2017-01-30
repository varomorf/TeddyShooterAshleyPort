package com.platypusit.libgdx.gameportusingashley.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.platypusit.libgdx.gameportusingashley.CourseraGamePortUsingAshley;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new CourseraGamePortUsingAshley(), config);
	}
}
