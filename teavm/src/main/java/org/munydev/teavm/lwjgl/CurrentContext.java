package org.munydev.teavm.lwjgl;

import org.teavm.jso.webgl.WebGLRenderingContext;

public class CurrentContext {

	private static WebGLRenderingContext ctx;
	
	public static void setCurrentContext(WebGLRenderingContext ctx) {
		CurrentContext.ctx = ctx;
		
	}
	public static Object getContext() {
		return ctx;
	}
}
