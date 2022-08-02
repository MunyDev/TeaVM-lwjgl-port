package org.lwjgl.opengl;

public class SysUpdater {
	private static double time = 0;

	public static double getTime() {
		return time;
	}
	
	
	protected static void setTime(double time) {
		SysUpdater.time = time;
	}
}
