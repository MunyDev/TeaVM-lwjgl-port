package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import static org.lwjgl.opengl.RealOGLConstants.*;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import org.munydev.teavm.lwjgl.CurrentContext;
import org.teavm.jso.webgl.WebGLBuffer;
import org.teavm.jso.webgl.WebGLProgram;
import org.teavm.jso.webgl.WebGLRenderingContext;
import org.teavm.jso.webgl.WebGLShader;
import org.teavm.jso.webgl.WebGLUniformLocation;

import static org.teavm.jso.webgl.WebGLRenderingContext.*;
/**
 * This is an attempt to simulate the fixed-function pipeline into the core pipeline by batch rendering.
 * <br /><b><em>NOTICE THAT: THIS IS AN ATTEMPT TO SIMULATE THE OPENGL FIXED FUNCTION PIPELINE
 * AND THEREFORE THERE MAY BE BUGS</em> </b>
 * 
 * @author MunyDev
 * @see org.lwjgl.opengl.GL11
 *
 */
public class Batch {
	private FloatBuffer batch;
	private float[] tempBatch;
	private WebGLRenderingContext ctx = (WebGLRenderingContext) CurrentContext.getContext();
	private WebGLBuffer VBO;
	private boolean initialized = false;
	private WebGLShader vertexShader;
	private WebGLShader fragmentShader;
	public static final int DEFAULT_LENGTH = 4096; //Big enough
	public WebGLUniformLocation hasTexCoords, hasNormals, hasColors;
	public boolean hasTexCoordsb = false, hasNormalsb = false, hasColorsb = false;
	private int numVertices = 0;
	private int renderIn;
	private boolean emulateQuads;
	private WebGLProgram wglp1;
	private float[] curColor = new float[] {
			1, 1, 1, 1
	};
	private float[] curNormal = new float[] {
			0, 1, 0
	};
	private float[] curTexCoord = new float[] {
			0,0
	};
	public Batch( int rendermode) {
		String vsource;
		String fsource;
		VBO = ctx.createBuffer();
		
		
		ctx.bindBuffer(ARRAY_BUFFER, VBO);
		ctx.bufferData(ARRAY_BUFFER, DEFAULT_LENGTH, DYNAMIC_DRAW);
		ConstantMapper cm = ConstantMapper.cmRenderModes;
		
		if (rendermode == GL_QUADS) {
			renderIn = TRIANGLES;
			emulateQuads = true;
			
		}else if (rendermode == GL_QUAD_STRIP || rendermode == GL_POLYGON){
			throw new UnsupportedOperationException("Unsupported render mode");
		}
		renderIn = cm.mapRealToWebGL(rendermode);
		vsource = "#version 300 es\n"
				+ "attribute vec3 vertices;\n"
				+ "attribute vec4 colors;\n"
				+ "attribute vec3 normals;\n"
				+ "attribute vec2 texCoords;\n"
				+ "\n"
				+ "varying vec4 outColors;\n"
				+ "varying vec3 outNormals;\n"
				+ "varying vec2 outTexCoords;\n"
				+ "\n"
				+ "void main(void)\n"
				+ "{\n"
				+ "\tgl_Position = vec4(vertices, 1);\n"
				+ "\toutColors = colors;"
				+ "\toutNormals = normals;"
				+ "\toutTexCoords = texCoords;"
				+ "}\n";
		
//		fsource = "#version 300 es\n"
//				+ "varying vec3 outColors;\n"
//				+ "varying vec3 outNormals;\n"
//				+ "varying vec2 outTexCoords;\n"
//				+ "uniform int hasColors;\n"
//				+ "uniform int hasNormals;\n"
//				+ "uniform int hasTexCoords;\n"
//				+ "uniform sampler2D sample;"
//				+ "\n"
//				+ "\n"
//				+ "\n"
//				+ "void main(void){\n"
//				+ "	vec4 resultingColor = vec4(1, 1, 1, 1);\n"
//				+ "	if (hasColors){\n"
//				+ "		resultingColor = vec4(hasColors);\n"
//				+ "	}\n"
//				+ "	if (hasNormals) {\n"
//				+ "		   "
//				+ "	}\n"
//				+ " if (hasTexCoords) {\n"
//				+ "		"
//				+ ""
//				+ "}";
		fsource = "#version 300 es\nvarying vec4 outColors;\nvarying vec3 outNormals;\nvarying vec2 outTexCoords;\nuniform int hasColors;\nuniform int hasNormals;\nuniform int hasTexCoords;\nuniform sampler2D sample;\n\n\nvoid main(void){\n\tvec4 resultingColor = vec4(1, 1, 1, 1);\n\tif (hasColors == 1){\n\t\tresultingColor = vec4(hasColors);\n\t}\n\tif (hasNormals) {\n\t\t   \n\t}\n \tif (hasTexCoords) {\n\t\tresultingColor = texture(sample, outTexCoords);\n\t}\n\t\n\tgl_FragColor = resultingColor;\n}";
		
		
		batch = ByteBuffer.allocateDirect(DEFAULT_LENGTH).order(ByteOrder.nativeOrder()).asFloatBuffer();
		vertexShader = ctx.createShader(VERTEX_SHADER);
		ctx.shaderSource(vertexShader, vsource);
		ctx.compileShader(vertexShader);
		boolean b = ctx.getShaderParameterb(vertexShader, COMPILE_STATUS);
		if (!b) {
			String shaderLog = ctx.getShaderInfoLog(vertexShader);
			System.out.println(shaderLog);
		}
		
		
		fragmentShader = ctx.createShader(FRAGMENT_SHADER);
		ctx.shaderSource(fragmentShader, fsource);
		ctx.compileShader(fragmentShader);
		b = ctx.getShaderParameterb(fragmentShader, COMPILE_STATUS);
		if (!b) {
			String shaderLog = ctx.getShaderInfoLog(fragmentShader);
			System.err.println(shaderLog);
		}
		
		wglp1 = ctx.createProgram();
		ctx.attachShader(wglp1, vertexShader);
		ctx.attachShader(wglp1, fragmentShader);
		ctx.linkProgram(wglp1);
		
		b = ctx.getProgramParameterb(wglp1, LINK_STATUS);
		if (!b) {
			String programLog = ctx.getProgramInfoLog(wglp1);
			System.err.println(programLog);
		}
		hasColors = ctx.getUniformLocation(wglp1, "hasColors");
		hasNormals = ctx.getUniformLocation(wglp1, "hasNormals");
		hasTexCoords = ctx.getUniformLocation(wglp1, "hasTexCoords");
		ctx.uniform1i(hasColors, 1);
		ctx.deleteShader(fragmentShader);
		ctx.deleteShader(vertexShader);
		initialized = true;
		
		
	}
	
	
	public void vertex2f(float x, float y) {
		batch.put(x).put(y).put(0).put(curColor).put(curNormal).put(curTexCoord);
		numVertices += 1;
		
	}
	public void vertex3f(float x, float y, float z) {
		numVertices += 1;
		batch.put(x).put(y).put(z).put(curColor).put(curNormal).put(curTexCoord);
		
	}
	public void vertex4f(float x, float y, float z, float w) {
		numVertices += 1;
		batch.put(x).put(y).put(z).put(curColor).put(curNormal).put(curTexCoord);
		
	}
	
	public void color3f(float r, float g, float b) {
		ctx.uniform1i(hasColors, 1);
		curColor[0] = r; curColor[1] = g; curColor[2] = b; curColor[3] = 1;
	}
	public void color4f(float r, float g, float b, float a) {
		ctx.uniform1i(hasColors, 1);
		curColor[0] = r; curColor[1] = g; curColor[2] = b; curColor[3] = a;
	}
	

	public void normal3f(float nx, float ny, float nz) {
		curNormal[0] = nx;
		curNormal[1] = ny;
		curNormal[2] = nz;
	}
	
	
	public void drawAndFinish() {
		
	}
}
