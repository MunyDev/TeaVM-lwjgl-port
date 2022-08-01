package org.lwjgl.opengl;

import java.nio.ByteBuffer;
import static org.lwjgl.opengl.RealOGLConstants.*;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import org.lwjgl.util.GLUtil;
import org.munydev.teavm.lwjgl.CurrentContext;
import org.teavm.jso.JSBody;
import org.teavm.jso.JSObject;
import org.teavm.jso.typedarrays.Float32Array;
import org.teavm.jso.webgl.WebGLBuffer;
import org.teavm.jso.webgl.WebGLProgram;
import org.teavm.jso.webgl.WebGLRenderingContext;
import org.teavm.jso.webgl.WebGLShader;
import org.teavm.jso.webgl.WebGLUniformLocation;
import org.teavm.webgl2.WebGL2RenderingContext;
import org.teavm.webgl2.WebGLVertexArrayObject;

import static org.teavm.jso.webgl.WebGLRenderingContext.*;
/**
 * This is an attempt to simulate the fixed-function pipeline into the programmable pipeline by batch rendering.
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
	private static WebGL2RenderingContext ctx = (WebGL2RenderingContext) CurrentContext.getContext();
	private WebGLBuffer VBO;
	private static boolean initialized = false;
	private static WebGLShader vertexShader;
	private static WebGLShader fragmentShader;
	public static final int DEFAULT_LENGTH = 4096; //Big enough
	public WebGLUniformLocation hasTexCoords, hasNormals, hasColors;
	public boolean hasTexCoordsb = false, hasNormalsb = false, hasColorsb = false;
	private int numVertices = 0;
	private int renderIn;
	private boolean emulateQuads;
	private static WebGLProgram wglp1;
//	private GLObjectPool glob = new GLObjectPool();
	private float[] curColor = new float[] {
			1, 1, 1, 1
	};
	private float[] curNormal = new float[] {
			0, 1, 0
	};
	private float[] curTexCoord = new float[] {
			0,0
	};
	static {
		String vsource = "#version 300 es\n"
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
				+ "\toutColors = colors;\n"
				+ "\toutNormals = normals;\n"
				+ "\toutTexCoords = texCoords;\n"
				+ "}\n";
				vsource = "uniform mat4 modelview;\n uniform mat4 perspective;\nattribute vec3 vertices;\nattribute vec4 colors;\nattribute vec3 normals;\nattribute vec2 texCoords;\n\nvarying vec4 outColors;\nvarying vec3 outNormals;\nvarying vec2 outTexCoords;\n\nvoid main() {\n\tgl_Position = perspective * modelview * vec4(vertices, 1);\n\toutColors = colors;\n\toutNormals = normals;\n\toutTexCoords = texCoords;\n\n}";
//		fsource = "#version 200 es\n"
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
		String fsource = "precision highp float;\nprecision lowp int;\nvarying vec4 outColors;\nvarying vec3 outNormals;\nvarying vec2 outTexCoords;\nuniform int hasColors;\nuniform int hasNormals;\nuniform int hasTexCoords;\nuniform sampler2D sample;\n\n\nvoid main(void){\n\tvec4 resultingColor = vec4(1, 1, 1, 1);\n\tif (hasColors == 1){\n\t\tresultingColor = vec4(outColors);\n\t}\n\tif (hasNormals == 1) {\n\t\t   \n\t}\n \tif (hasTexCoords == 1) {\n\t\tresultingColor = texture2D(sample, outTexCoords);\n\t}\n\t\n\tgl_FragColor = resultingColor;\n}";
		
		
		
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
		
		ctx.deleteShader(fragmentShader);
		ctx.deleteShader(vertexShader);
//		this.glob = glob;
		
		initialized = true;
	}
	public Batch( int rendermode) {
//		String vsource;
//		String fsource;
		VBO = ctx.createBuffer();
		
		batch = ByteBuffer.allocateDirect(DEFAULT_LENGTH).order(ByteOrder.nativeOrder()).asFloatBuffer();
		ctx.bindBuffer(ARRAY_BUFFER, VBO);
		ctx.bufferData(ARRAY_BUFFER, DEFAULT_LENGTH, DYNAMIC_DRAW);
//		ConstantMapper cm = ConstantMapper.cmRenderModes;
		
		if (rendermode == GL_QUADS) {
			renderIn = TRIANGLES;
			emulateQuads = true;
			
		}else if (rendermode == GL_QUAD_STRIP || rendermode == GL_POLYGON){
			throw new UnsupportedOperationException("Unsupported render mode");
		}
		renderIn = rendermode;
		
		hasColors = ctx.getUniformLocation(wglp1, "hasColors");
		hasNormals = ctx.getUniformLocation(wglp1, "hasNormals");
		hasTexCoords = ctx.getUniformLocation(wglp1, "hasTexCoords");
		ctx.useProgram(wglp1);
		ctx.uniform1i(hasColors, 0);
		ctx.uniform1i(hasNormals, 0);
		ctx.uniform1i(hasTexCoords, 0);
		
	}
	@JSBody(script = "console.log(param);", params = {"param"})
	public static native void log(JSObject param);
	
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
		ctx.uniform1i(hasNormals, 1);
		curNormal[0] = nx;
		curNormal[1] = ny;
		curNormal[2] = nz;
	}
	public void texCoord2f(float u, float v) {
		ctx.uniform1i(hasTexCoords, 1);
		curTexCoord[0] = u;
		curTexCoord[1] = v;
	}
	
	public void drawAndFinish() {
		batch.flip();
		WebGLVertexArrayObject wglva = ctx.createVertexArray();
		ctx.bindVertexArray(wglva);
		ctx.useProgram(wglp1);
		FloatBuffer fb = FloatBuffer.allocate(16);
		GL11.glGetFloat(GL_MODELVIEW_MATRIX, fb);
		ctx.uniformMatrix4fv(ctx.getUniformLocation(wglp1, "modelview"), false,Float32Array.create(GLUtil.glCreateBufferFromJava(fb)));
		fb.flip();
		GL11.glGetFloat(GL_PROJECTION_MATRIX, fb);
		ctx.uniformMatrix4fv(ctx.getUniformLocation(wglp1, "perspective"),false, Float32Array.create(GLUtil.glCreateBufferFromJava(fb)));
		
		
		WebGLBuffer wglb = ctx.createBuffer();
//		log(Float32Array.create(GLUtil.glCreateBufferFromJava(batch)));GL11.glV
		ctx.bindBuffer(WebGLRenderingContext.ARRAY_BUFFER, wglb);
		ctx.bufferData(WebGLRenderingContext.ARRAY_BUFFER, GLUtil.glCreateBufferFromJava(batch), DYNAMIC_DRAW);
		int vertexAttrib = ctx.getAttribLocation(wglp1, "vertices");
		
		ctx.enableVertexAttribArray(vertexAttrib);
		ctx.vertexAttribPointer(vertexAttrib, 3, GL_FLOAT, false, 12 * Float.BYTES, 0 );
		
		int colorAttrib = ctx.getAttribLocation(wglp1, "colors");
		
		ctx.enableVertexAttribArray(colorAttrib);
		ctx.vertexAttribPointer(colorAttrib, 4, GL_FLOAT, false, 12 * Float.BYTES, 3 * Float.BYTES );
		int normalAttrib = ctx.getAttribLocation(wglp1, "normals");
		
		ctx.enableVertexAttribArray(normalAttrib);
		ctx.vertexAttribPointer(normalAttrib, 3, GL_FLOAT, false, 12 * Float.BYTES, 7* Float.BYTES );
		int texCoordAttrib = ctx.getAttribLocation(wglp1, "texCoords");
		
		ctx.enableVertexAttribArray(texCoordAttrib);
		ctx.vertexAttribPointer(texCoordAttrib, 2, GL_FLOAT, false, 12 * Float.BYTES, 10* Float.BYTES );
		ctx.bindVertexArray(wglva);
		ctx.bindBuffer(GL15.GL_ARRAY_BUFFER, wglb);
		ctx.useProgram(wglp1);
		ctx.drawArrays(renderIn, 0, numVertices);
		
	}
}