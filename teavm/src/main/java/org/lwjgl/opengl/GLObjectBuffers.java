package org.lwjgl.opengl;

import org.teavm.jso.webgl.WebGLBuffer;
import org.teavm.jso.webgl.WebGLProgram;
import org.teavm.jso.webgl.WebGLShader;
import org.teavm.jso.webgl.WebGLTexture;
import org.teavm.jso.webgl.WebGLUniformLocation;

public class GLObjectBuffers {
	public static int texCount = 0, shaderCount = 0, programCount = 0, bufferCount = 0, uniformCount = 0;
	public static final int DEFAULT_SIZE = 4096;
	public static WebGLTexture[] textures = new WebGLTexture[DEFAULT_SIZE]; 
	public static WebGLUniformLocation[] uniforms = new WebGLUniformLocation[DEFAULT_SIZE]; 
	public static WebGLShader[] shaders = new WebGLShader[DEFAULT_SIZE];
	public static WebGLProgram[] programs = new WebGLProgram[DEFAULT_SIZE];
	public static WebGLBuffer[] buffers = new WebGLBuffer[DEFAULT_SIZE];
	
	public static int[] lists = new int[DEFAULT_SIZE];
}
