package org.lwjgl.opengl;

import org.teavm.jso.JSBody;
import org.teavm.jso.JSObject;

public class GLObjectBuffers {
	private static int objectCount = 0;
	private static final int DEFAULT_SIZE = 4096;
	public static final int GL_OBJECT_BUFFERS = 0x1;
	public static final int GL_OBJECT_TEXTURES = 0x1;
	public static final int GL_OBJECT_PROGRAMS = 0x2;
	public static final int GL_OBJECT_QUERIES = 0x3;
	public static final int GL_OBJECT_UNIFORMS = 0x3;
	public static final int GL_OBJECT_SHADERS = 0x4;
	public static final int GL_OBJECT_LISTS = 0x5;
	public static final int GL_OBJECT_RENDERBUFFER = 0x6;
	
	public static final int GL_OBJECT_FRAMEBUFFER = 0x7;
	
	public static final int GL_OBJECT_VAOS = 0x8;
//	public static WebGLTexture[] textures = new WebGLTexture[DEFAULT_SIZE]; 
//	public static WebGLUniformLocation[] uniforms = new WebGLUniformLocation[DEFAULT_SIZE]; 
//	public static WebGLShader[] shaders = new WebGLShader[DEFAULT_SIZE];
//	public static WebGLProgram[] programs = new WebGLProgram[DEFAULT_SIZE];
//	public static WebGLBuffer[] buffers = new WebGLBuffer[DEFAULT_SIZE];
//	public static WebGLQuery[] queries = new WebGLQuery[DEFAULT_SIZE];
	
	
//	private static GLObject[] objects = new GLObject[DEFAULT_SIZE * 5];
//	private static int = 0;
//	public static int[] lists = new int[DEFAULT_SIZE];
	//Smart ass allocation
	
	static {
		initialize();
	}
	@JSBody(script = "window.globjs = [];")
	public static native int initialize();
	/**
	 * Creates an object and returns the id using smarta*s allocation
	 * @param type Specifies the type of the webgl object
	 * @param obj The actual object
	 * @return returns the id
	 */
	@JSBody(script = "return window.globjs.push({type: type, object: obj}) - 1", params= {"type", "obj"})
	public static native int newObject(int type, JSObject obj);
	
	@JSBody(script = "return window.globjs[idx].object;", params= {"idx"})
	public static native JSObject getObject(int idx);
	
	@JSBody(script = "return window.globjs[idx].type;", params= {"idx"})
	public static native int getType(int idx);
	
	
	public static int find(JSObject obj) {
		return 0;
		
	}
}