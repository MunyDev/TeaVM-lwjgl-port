package org.lwjgl.opengl;

import org.teavm.jso.JSObject;

public class GLObject {
	
	private JSObject jso;
	private int type;
	
	public GLObject(JSObject jso, int type) {
		this.jso = jso;
		this.type = type;
	}
	
	public int getType() {
		return type;
	}
	
	public JSObject getObject() {
		return jso;
	}
 }
