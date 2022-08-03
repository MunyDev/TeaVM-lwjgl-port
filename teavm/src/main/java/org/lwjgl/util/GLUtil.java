package org.lwjgl.util;



import java.nio.*;

import org.teavm.jso.typedarrays.*;

public class GLUtil {
//	static void	glReadPixels(int x, int y, int width, int height, int format, int type, java.nio.ByteBuffer pixels){
//		Uint8ClampedArray ua = Uint8ClampedArray.create(pixels.capacity());
//		
//		
//		
////		ctx.readPixels(x, y, width, height, WebGLRenderingContext.RGBA, WebGLRenderingContext.RGBA, ua);
//		
//		for (int i = 0; i < ua.getLength(); i++ ) {
//			pixels.put((byte) ua.get(i));
//		}
//		
//		
//		
//	}
	
	public static ArrayBuffer glNewBuffer(ByteBuffer data) {
		return ArrayBuffer.create(data.remaining() * Byte.BYTES);
	}
	public static ArrayBuffer glNewBuffer(FloatBuffer data) {
		return ArrayBuffer.create(data.remaining() * Float.BYTES);
	}
	public static ArrayBuffer glNewBuffer(DoubleBuffer data) {
		return ArrayBuffer.create(data.remaining() * Double.BYTES);
	}
	public static ArrayBuffer glNewBuffer(ShortBuffer data) {
		return ArrayBuffer.create(data.remaining() * Short.BYTES);
	}
	public static ArrayBuffer glNewBuffer(IntBuffer data) {
		return ArrayBuffer.create(data.remaining() * Integer.BYTES);
	}
//	public static ArrayBuffer glNewBuffer(LongBuffer data) {
//		return ArrayBuffer.create(data.remaining() * Float.BYTES);
//	}
	//No Type casting/safety...
	
	
	public static void glWriteArrayBufferToJavab(ArrayBuffer ab, ByteBuffer d) {
		Int8Array ua = Int8Array.create(ab);
		int len = ua.getLength();
		
		for (int i = 0; i < len; i++) {
			byte v = ua.get(i);
			d.put(v);
		}
		
	}  
	public static void glWriteArrayBufferToJavau(ArrayBuffer ab, ByteBuffer d) {
		Uint8Array ua = Uint8Array.create(ab);
		int len = ua.getLength();
		
		for (int i = 0; i < len; i++) {
			short v = ua.get(i);
			d.put((byte)v);
		}
		
	}
	public static void glWriteArrayBufferToJava(ArrayBuffer ab, ShortBuffer d) {
		Int16Array ua = Int16Array.create(ab);
		int len = ua.getLength();
		
		for (int i = 0; i < len; i++) {
			short v = ua.get(i);
			d.put(v);
		}
		
	}                              
	public static void glWriteArrayBufferToJava(ArrayBuffer ab, IntBuffer d) {
		Int32Array in = Int32Array.create(ab);
		int len = in.getLength();
		
		for (int i = 0; i < len; i++) {
			
			int v = in.get(i);
			d.put(v);
			
		}
	}                                           
	public static void glWriteArrayBufferToJava(ArrayBuffer ab, DoubleBuffer d) {
		Float64Array fin = Float64Array.create(ab);
		int len = fin.getLength();
		
		for (int i = 0; i< len; i++) {
			double val = fin.get(i);
			d.put(val);
		}
	}
	public static byte[] glWriteArrayToJByteArray(Uint8Array ua) {
		byte[] x = new byte[ua.getLength()];
		for (int i = 0; i < ua.getLength(); i++) {
			x[i] = (byte) ua.get(i);
		}
		return x;
	}
	public static void glWriteArrayBufferToJava(ArrayBuffer ab, FloatBuffer d) {
		Float32Array fin = Float32Array.create(ab);
		int len = fin.getLength();
		
		for (int i = 0; i< len; i++) {
			float val = fin.get(i);
			d.put(val);
		}
	}
	public static ArrayBuffer glCreateBufferFromJava(ByteBuffer data) {
		ArrayBuffer arr = ArrayBuffer.create(data.remaining() * Byte.BYTES);
		Uint8Array dv = Uint8Array.create(arr);
		byte[] exp = new byte[data.remaining()];
		data.get(exp);
		dv.set(exp);
		return arr;
	}
	public static ArrayBuffer glCreateBufferFromJava(FloatBuffer data) {
		ArrayBuffer arr = ArrayBuffer.create(data.remaining() * Float.BYTES);
		Float32Array arr1 = Float32Array.create(arr);
		float[] exp = new float[data.remaining()];
		data.get(exp);
		arr1.set(exp);
		return arr;
	}
	public static ArrayBuffer glCreateBufferFromJava(DoubleBuffer data) {
		ArrayBuffer arr = ArrayBuffer.create(data.remaining() * Double.BYTES);
		DataView dv = DataView.create(arr);
		int len = data.remaining();
		for (int i = 0; i < len; i++) {
			dv.setFloat64(i*8, data.get(i));
			
		}
		return arr;
	}
	public static ArrayBuffer glCreateBufferFromJava(IntBuffer data) {
		ArrayBuffer arr = ArrayBuffer.create(data.remaining() * Integer.BYTES);
		DataView dv = DataView.create(arr);
		int len = data.remaining();
		for (int i = 0; i < len; i++) {
			dv.setInt32(i*4, data.get(i));
			
		}
		return arr;
	}
	public static ArrayBuffer glCreateBufferFromJava(ShortBuffer data) {
		ArrayBuffer arr = ArrayBuffer.create(data.remaining() * Short.BYTES);
		DataView dv = DataView.create(arr);
		int len = data.remaining();
		for (int i = 0; i < len; i++) {
			dv.setFloat64(i*8, data.get(i));
			
		}
		
		return arr;
	}
	public static void glWriteBufferToJArray(ArrayBuffer buf, byte[] b) {
		int len = buf.getByteLength();
		Uint8Array ua = Uint8Array.create(buf);
		for (int i = 0; i < len; i++) {
			b[i] = (byte) ua.get(i);
		}
	}
}