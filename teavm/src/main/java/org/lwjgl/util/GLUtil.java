package org.lwjgl.util;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

import org.teavm.jso.typedarrays.DataView;
import org.teavm.jso.typedarrays.Uint8Array;
import org.teavm.jso.typedarrays.Uint8ClampedArray;
import org.teavm.jso.webgl.WebGLRenderingContext;

public class GLUtil {
//	static void	glReadPixels(int x, int y, int width, int height, int format, int type, java.nio.ByteBuffer pixels){
//		Uint8ClampedArray ua = Uint8ClampedArray.create(pixels.capacity());
//		
//		
//		
//		ctx.readPixels(x, y, width, height, WebGLRenderingContext.RGBA, WebGLRenderingContext.RGBA, ua);
//		
//		for (int i = 0; i < ua.getLength(); i++ ) {
//			pixels.put((byte) ua.get(i));
//		}
//		
//		
//		
//	}
	public static int glGenLists() {
		
	}
	public static Uint8Array glNewBuffer(ByteBuffer data) {
		Uint8Array arr = Uint8Array.create(data.remaining() * Byte.BYTES);
		
		return arr;
	}
	public static Uint8Array glCreateBufferFromJava(ByteBuffer data) {
		Uint8Array arr = Uint8Array.create(data.remaining() * Byte.BYTES);
		DataView dv = DataView.create(arr);
		
		for (int i = 0; i < arr.getLength(); i++) {
			dv.setUint8(i, data.get(i));
		}
		return arr;
	}
	public static Uint8Array glCreateBufferFromJava(FloatBuffer data) {
		Uint8Array arr = Uint8Array.create(data.remaining() * Float.BYTES);
		DataView dv = DataView.create(arr);
		
		for (int i = 0; i < arr.getLength(); i++) {
			dv.setFloat32(i*4, data.get(i));
			
		}
		return arr;
	}
	public static Uint8Array glCreateBufferFromJava(DoubleBuffer data) {
		Uint8Array arr = Uint8Array.create(data.remaining() * Double.BYTES);
		DataView dv = DataView.create(arr);
		
		for (int i = 0; i < arr.getLength(); i++) {
			dv.setFloat64(i*8, data.get(i));
			
		}
		
		return arr;
	}
	
	public static Uint8Array glCreateBufferFromJava(ShortBuffer data) {
		Uint8Array arr = Uint8Array.create(data.remaining() * Short.BYTES);
		DataView dv = DataView.create(arr);
		
		for (int i = 0; i < arr.getLength(); i++) {
			dv.setFloat64(i*8, data.get(i));
			
		}
		return arr;
	}
	public static Uint8Array glCreateBufferFromJava(IntBuffer data) {
		Uint8Array arr = Uint8Array.create(data.remaining() * Integer.BYTES);
		DataView dv = DataView.create(arr);
		
		for (int i = 0; i < arr.getLength(); i++) {
			dv.setInt32(i*8, data.get(i));
			
		}
		return arr;
	}
}
