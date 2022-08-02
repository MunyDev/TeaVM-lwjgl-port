package org.lwjgl.opengl;

import org.lwjgl.Sys;

public class SysUpdater {
	private static double time = 0;

	public static double getTime() {
		return time;
	}
	
	
	protected static void setTime(double time) {
		SysUpdater.time = time;
	}
	protected static void updateClipboard() {
//		if (!Sys.clipboardReq) {
			Sys.updateClipboard();
//		}
	}
}
