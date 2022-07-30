package org.munydev.teavm.lwjgl;

import org.teavm.jso.webgl.WebGLRenderingContext;
import org.teavm.webgl2.WebGL2RenderingContext;

public class CurrentContext {

	private static WebGL2RenderingContext ctx;
	
	public static void setCurrentContext(WebGL2RenderingContext ctx) {
		CurrentContext.ctx = ctx;
		
	}
	public static Object getContext() {
		return ctx;
	}
}
