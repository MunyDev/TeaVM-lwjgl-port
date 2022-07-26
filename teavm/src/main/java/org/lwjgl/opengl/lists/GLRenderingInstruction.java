package org.lwjgl.opengl.lists;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.lwjgl.opengl.GL11;
import org.teavm.classlib.java.util.zip.TZipInputStream;
import org.teavm.classlib.java.util.zip.TZipOutputStream;
import org.teavm.jso.typedarrays.ArrayBuffer;
import org.teavm.jso.typedarrays.DataView;
//import org.teavm.jso.typedarrays.Uint8Array;
import org.teavm.jso.typedarrays.Uint8Array;

public class GLRenderingInstruction {
	public String riName;
	public ArrayBuffer data;
	public Object[] params;
	public int numArgs = 0;
	public int bytePos = 0;
	public static final int PARAM_TYPE_FLOAT = 0;
	public static final int PARAM_TYPE_INTEGER = 1;
	public static final int PARAM_TYPE_DOUBLE = 2;
	public static final int PARAM_TYPE_SHORT = 3;
	public static final int PARAM_TYPE_BYTE = 4;
	public int paramType = PARAM_TYPE_FLOAT;
	private Class<?> getClassType(int paramType){
		switch (paramType) {
		case PARAM_TYPE_FLOAT:
			return Float.class;
		case PARAM_TYPE_INTEGER:
			return Integer.class;
		case PARAM_TYPE_DOUBLE:
			return Double.class;
		case PARAM_TYPE_SHORT:
			return Short.class;
		case PARAM_TYPE_BYTE:
			return Byte.class;
		
		default:
			return Float.class;
		}
	}
	public GLRenderingInstruction(String riName, Object[] values, int type, int numArgs) {
		this.riName = riName;
		this.paramType = PARAM_TYPE_FLOAT;
		this.params = values;
		this.numArgs = numArgs;
		switch (type) {
		case PARAM_TYPE_FLOAT:
			
			this.data = ArrayBuffer.create(Float.BYTES * numArgs);
			
			break;
		case PARAM_TYPE_DOUBLE:
			this.data = ArrayBuffer.create(Double.BYTES * numArgs);
			break;
		case PARAM_TYPE_SHORT:
			this.data = ArrayBuffer.create(Short.BYTES * numArgs);
			break;
		case PARAM_TYPE_BYTE:
			this.data = ArrayBuffer.create(Byte.BYTES * numArgs);
			break;
		case PARAM_TYPE_INTEGER:
			this.data = ArrayBuffer.create(Integer.BYTES * numArgs);
			break;
		default:
			System.err.println("Unsupported parameter of rendering instruction");
			break;
		}
		
		
	}
	
	public GLRenderingInstruction(String riName) {
		this.riName = riName;
		this.data = Uint8Array.create(32 * Float.BYTES).getBuffer();
	}
	
	public void invokeInstructionReg() {
		try {
			Class<?> pa = this.getClassType(this.paramType);
			Class<?>[] results = new Class<?>[this.numArgs];
			Arrays.fill(results, pa);
			Method m = GL11.class.getDeclaredMethod(riName, results);
			
			m.invoke(null, params);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	public void invokeInstructionBuf() {
////		Class<?> pa = this.getClassType(this.paramType);
//		
//	}
	public void uploadDataf(float x, float y, float z, float w) {
		DataView dv = DataView.create(this.data);
		dv.setFloat32(bytePos + 0, x);
		dv.setFloat32(bytePos + 4, y);
		dv.setFloat32(bytePos + 8, z);
		dv.setFloat32(bytePos + 12, w);
		bytePos += 16;
		
		
		
	}
	public void uploadDataf(float x, float y, float z) {
		DataView dv = DataView.create(this.data);
		dv.setFloat32(bytePos + 0, x);
		dv.setFloat32(bytePos + 4, y);
		dv.setFloat32(bytePos + 8, z);
		dv.setFloat32(bytePos + 12, 0);
		bytePos += 16;
	}
	public void uploadDataub(byte x, byte y, byte z, byte w) {
		DataView dv = DataView.create(this.data);
		dv.setUint8(bytePos + 0, x);
		dv.setUint8(bytePos + 1, y);
		dv.setUint8(bytePos + 2, z);
		dv.setUint8(bytePos+4, w);
		bytePos += 4;
	}
	public void uploadDataub(byte x, byte y, byte z) {
		DataView dv = DataView.create(this.data);
		dv.setUint8(bytePos + 0, x);
		dv.setUint8(bytePos + 1, y);
		dv.setUint8(bytePos + 2, z);
		dv.setUint8(bytePos + 3, 0);
		bytePos += 4;
	}
	public void uploadDatai(int x, int y, int z) {
		DataView dv = DataView.create(this.data);
		dv.setInt32(bytePos + 0, x);
		dv.setInt32(bytePos + 1, y);
		dv.setInt32(bytePos + 2, z);
		dv.setInt32(bytePos + 3, 0);
		bytePos += 16;
	}
	public void uploadDatai(int x, int y, int z, int w) {
		DataView dv = DataView.create(this.data);
		dv.setInt32(bytePos + 0, x);
		dv.setInt32(bytePos + 1, y);
		dv.setInt32(bytePos + 2, z);
		dv.setInt32(bytePos + 3, w);
		bytePos += 16;
	}
}
