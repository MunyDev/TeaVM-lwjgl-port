package org.lwjgl.opengl;

import org.munydev.teavm.lwjgl.CurrentContext;
import org.teavm.webgl2.WebGL2RenderingContext;
import org.teavm.webgl2.WebGLSync;

public class GLSync {
	private WebGLSync wglsync;
	private boolean deleted =false;
	public GLSync(WebGLSync wglsync) {
		this.wglsync = wglsync;
		this.deleted = false;
	}
	
	protected WebGLSync getSync() {
		return wglsync;
	}
	protected boolean isDeleted() {
		return this.deleted;
	}
	
	protected void delete() {
		((WebGL2RenderingContext) CurrentContext.getContext()).deleteSync(wglsync);
		this.deleted = true;
		
	}
}
