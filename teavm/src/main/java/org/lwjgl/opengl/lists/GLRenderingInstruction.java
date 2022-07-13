package org.lwjgl.opengl.lists;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.teavm.jso.typedarrays.DataView;
import org.teavm.jso.typedarrays.Uint8Array;

public class GLRenderingInstruction {
	public String riName;
	public Uint8Array data;
	public int bytePos = 0;
	public static final int PARAM_TYPE_FLOAT = 0;
	public static final int PARAM_TYPE_INTEGER = 1;
	public static final int PARAM_TYPE_DOUBLE = 2;
	public static final int PARAM_TYPE_SHORT = 3;
	public static final int PARAM_TYPE_BYTE = 4;
	
	public GLRenderingInstruction(String riName, Uint8Array ua, int type, int numArgs) {
		this.riName = riName;
		this.data = ua;
		switch (type) {
		case PARAM_TYPE_FLOAT:
			break;
		case PARAM_TYPE_DOUBLE:
			break;
		case PARAM_TYPE_SHORT:
			break;
		case PARAM_TYPE_BYTE:
			break;
		case PARAM_TYPE_INTEGER:
			break;
		default:
			System.err.println("Unsupported parameter of rendering instruction");
			break;
		}
		
		
	}
	
	public GLRenderingInstruction(String riName) {
		this.riName = riName;
		this.data = Uint8Array.create(32 * Float.BYTES);
	}
	
	public void uploadDataf(float x, float y, float z, float w) {
		DataView dv = DataView.create(this.data);
		dv.setFloat32(bytePos + 0, x);
		dv.setFloat32(bytePos + 4, y);
		dv.setFloat32(bytePos + 8, z);
		dv.setFloat32(bytePos + 12, w);
		bytePos += 12;
		
		
		
	}
	public void uploadDataf(float x, float y, float z) {
		DataView dv = DataView.create(this.data);
		dv.setFloat32(bytePos + 0, x);
		dv.setFloat32(bytePos + 4, y);
		dv.setFloat32(bytePos + 8, z);
		dv.setFloat32(bytePos + 12, 0);
		bytePos += 12;
	}
}
