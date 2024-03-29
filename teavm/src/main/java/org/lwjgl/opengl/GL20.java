/* MACHINE GENERATED FILE, DO NOT EDIT */

package org.lwjgl.opengl;

import org.lwjgl.BufferUtils;
import org.munydev.teavm.lwjgl.CurrentContext;
import org.teavm.jso.core.JSNumber;
import org.teavm.jso.typedarrays.Float32Array;
import org.teavm.jso.webgl.WebGLActiveInfo;
import org.teavm.jso.webgl.WebGLProgram;
import org.teavm.jso.webgl.WebGLRenderingContext;
import org.teavm.jso.webgl.WebGLShader;
import org.teavm.jso.webgl.WebGLUniformLocation;
import org.teavm.webgl2.WebGL2RenderingContext;

import static org.lwjgl.opengl.GLObjectBuffers.*;
import java.nio.*;
import java.nio.charset.StandardCharsets;

public final class GL20 {
	private static WebGL2RenderingContext wglc = (WebGL2RenderingContext) CurrentContext.getContext();
	//Could have used deserialization but wasn't worth the effort because I still had to store bytearrays.
	// This is an attempt to simulate OpenGL GLuint IDs
	
	/**
	 * Accepted by the &lt;name&gt; parameter of GetString: 
	 */
	public static final int GL_SHADING_LANGUAGE_VERSION = 0x8B8C;

	/**
	 * Accepted by the &lt;pname&gt; argument of GetInteger: 
	 */
	public static final int GL_CURRENT_PROGRAM = 0x8B8D;

	/**
	 * Accepted by the &lt;pname&gt; parameter of GetObjectParameter{fi}vARB: 
	 */
	public static final int GL_SHADER_TYPE = 0x8B4F,
		GL_DELETE_STATUS = 0x8B80,
		GL_COMPILE_STATUS = 0x8B81,
		GL_LINK_STATUS = 0x8B82,
		GL_VALIDATE_STATUS = 0x8B83,
		GL_INFO_LOG_LENGTH = 0x8B84,
		GL_ATTACHED_SHADERS = 0x8B85,
		GL_ACTIVE_UNIFORMS = 0x8B86,
		GL_ACTIVE_UNIFORM_MAX_LENGTH = 0x8B87,
		GL_ACTIVE_ATTRIBUTES = 0x8B89,
		GL_ACTIVE_ATTRIBUTE_MAX_LENGTH = 0x8B8A,
		GL_SHADER_SOURCE_LENGTH = 0x8B88;

	/**
	 * Returned by the &lt;params&gt; parameter of GetObjectParameter{fi}vARB: 
	 */
	public static final int GL_SHADER_OBJECT = 0x8B48;

	/**
	 * Returned by the &lt;type&gt; parameter of GetActiveUniformARB: 
	 */
	public static final int GL_FLOAT_VEC2 = 0x8B50,
		GL_FLOAT_VEC3 = 0x8B51,
		GL_FLOAT_VEC4 = 0x8B52,
		GL_INT_VEC2 = 0x8B53,
		GL_INT_VEC3 = 0x8B54,
		GL_INT_VEC4 = 0x8B55,
		GL_BOOL = 0x8B56,
		GL_BOOL_VEC2 = 0x8B57,
		GL_BOOL_VEC3 = 0x8B58,
		GL_BOOL_VEC4 = 0x8B59,
		GL_FLOAT_MAT2 = 0x8B5A,
		GL_FLOAT_MAT3 = 0x8B5B,
		GL_FLOAT_MAT4 = 0x8B5C,
		GL_SAMPLER_1D = 0x8B5D,
		GL_SAMPLER_2D = 0x8B5E,
		GL_SAMPLER_3D = 0x8B5F,
		GL_SAMPLER_CUBE = 0x8B60,
		GL_SAMPLER_1D_SHADOW = 0x8B61,
		GL_SAMPLER_2D_SHADOW = 0x8B62;

	/**
	 *  Accepted by the &lt;shaderType&gt; argument of CreateShader and
	 *  returned by the &lt;params&gt; parameter of GetShader{if}v:
	 */
	public static final int GL_VERTEX_SHADER = 0x8B31;

	/**
	 *  Accepted by the &lt;pname&gt; parameter of GetBooleanv, GetIntegerv,
	 *  GetFloatv, and GetDoublev:
	 */
	public static final int GL_MAX_VERTEX_UNIFORM_COMPONENTS = 0x8B4A,
		GL_MAX_VARYING_FLOATS = 0x8B4B,
		GL_MAX_VERTEX_ATTRIBS = 0x8869,
		GL_MAX_TEXTURE_IMAGE_UNITS = 0x8872,
		GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS = 0x8B4C,
		GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS = 0x8B4D,
		GL_MAX_TEXTURE_COORDS = 0x8871;

	/**
	 *  Accepted by the &lt;cap&gt; parameter of Disable, Enable, and IsEnabled, and
	 *  by the &lt;pname&gt; parameter of GetBooleanv, GetIntegerv, GetFloatv, and
	 *  GetDoublev:
	 */
	public static final int GL_VERTEX_PROGRAM_POINT_SIZE = 0x8642,
		GL_VERTEX_PROGRAM_TWO_SIDE = 0x8643;

	/**
	 * Accepted by the &lt;pname&gt; parameter of GetVertexAttrib{dfi}vARB: 
	 */
	public static final int GL_VERTEX_ATTRIB_ARRAY_ENABLED = 0x8622,
		GL_VERTEX_ATTRIB_ARRAY_SIZE = 0x8623,
		GL_VERTEX_ATTRIB_ARRAY_STRIDE = 0x8624,
		GL_VERTEX_ATTRIB_ARRAY_TYPE = 0x8625,
		GL_VERTEX_ATTRIB_ARRAY_NORMALIZED = 0x886A,
		GL_CURRENT_VERTEX_ATTRIB = 0x8626;

	/**
	 * Accepted by the &lt;pname&gt; parameter of GetVertexAttribPointervARB: 
	 */
	public static final int GL_VERTEX_ATTRIB_ARRAY_POINTER = 0x8645;

	/**
	 *  Accepted by the &lt;shaderType&gt; argument of CreateShader and
	 *  returned by the &lt;params&gt; parameter of GetShader{fi}vARB:
	 */
	public static final int GL_FRAGMENT_SHADER = 0x8B30;

	/**
	 *  Accepted by the &lt;pname&gt; parameter of GetBooleanv, GetIntegerv,
	 *  GetFloatv, and GetDoublev:
	 */
	public static final int GL_MAX_FRAGMENT_UNIFORM_COMPONENTS = 0x8B49;

	/**
	 *  Accepted by the &lt;target&gt; parameter of Hint and the &lt;pname&gt; parameter of
	 *  GetBooleanv, GetIntegerv, GetFloatv, and GetDoublev:
	 */
	public static final int GL_FRAGMENT_SHADER_DERIVATIVE_HINT = 0x8B8B;

	/**
	 *  Accepted by the &lt;pname&gt; parameters of GetIntegerv, GetFloatv,
	 *  and GetDoublev:
	 */
	public static final int GL_MAX_DRAW_BUFFERS = 0x8824,
		GL_DRAW_BUFFER0 = 0x8825,
		GL_DRAW_BUFFER1 = 0x8826,
		GL_DRAW_BUFFER2 = 0x8827,
		GL_DRAW_BUFFER3 = 0x8828,
		GL_DRAW_BUFFER4 = 0x8829,
		GL_DRAW_BUFFER5 = 0x882A,
		GL_DRAW_BUFFER6 = 0x882B,
		GL_DRAW_BUFFER7 = 0x882C,
		GL_DRAW_BUFFER8 = 0x882D,
		GL_DRAW_BUFFER9 = 0x882E,
		GL_DRAW_BUFFER10 = 0x882F,
		GL_DRAW_BUFFER11 = 0x8830,
		GL_DRAW_BUFFER12 = 0x8831,
		GL_DRAW_BUFFER13 = 0x8832,
		GL_DRAW_BUFFER14 = 0x8833,
		GL_DRAW_BUFFER15 = 0x8834;

	/**
	 *  Accepted by the &lt;cap&gt; parameter of Enable, Disable, and IsEnabled, by
	 *  the &lt;pname&gt; parameter of GetBooleanv, GetIntegerv, GetFloatv, and
	 *  GetDoublev, and by the &lt;target&gt; parameter of TexEnvi, TexEnviv,
	 *  TexEnvf, TexEnvfv, GetTexEnviv, and GetTexEnvfv:
	 */
	public static final int GL_POINT_SPRITE = 0x8861;

	/**
	 *  When the &lt;target&gt; parameter of TexEnvf, TexEnvfv, TexEnvi, TexEnviv,
	 *  GetTexEnvfv, or GetTexEnviv is POINT_SPRITE, then the value of
	 *  &lt;pname&gt; may be:
	 */
	public static final int GL_COORD_REPLACE = 0x8862;

	/**
	 *  Accepted by the &lt;pname&gt; parameter of PointParameter{if}vARB, and the
	 *  &lt;pname&gt; of Get:
	 */
	public static final int GL_POINT_SPRITE_COORD_ORIGIN = 0x8CA0;

	/**
	 * Accepted by the &lt;param&gt; parameter of PointParameter{if}vARB: 
	 */
	public static final int GL_LOWER_LEFT = 0x8CA1,
		GL_UPPER_LEFT = 0x8CA2,
		GL_STENCIL_BACK_FUNC = 0x8800,
		GL_STENCIL_BACK_FAIL = 0x8801,
		GL_STENCIL_BACK_PASS_DEPTH_FAIL = 0x8802,
		GL_STENCIL_BACK_PASS_DEPTH_PASS = 0x8803,
		GL_STENCIL_BACK_REF = 0x8CA3,
		GL_STENCIL_BACK_VALUE_MASK = 0x8CA4,
		GL_STENCIL_BACK_WRITEMASK = 0x8CA5,
		GL_BLEND_EQUATION_RGB = 0x8009,
		GL_BLEND_EQUATION_ALPHA = 0x883D;

	private GL20() {}

	/**
	 *  The ARB_shader_objects extension allows multiple, optionally null-terminated, source strings to define a shader program.
	 *  <p/>
	 *  This method uses just a single string, that should NOT be null-terminated.
	 * <p>
	 *  @param shader
	 *  @param string
	 */
	public static void glShaderSource(int shader, ByteBuffer string) {
		wglc.shaderSource((WebGLShader) getObject(shader), string.asCharBuffer().toString());
	}
	static native void nglShaderSource(int shader, int count, long string, int string_length, long function_pointer);

	/** Overloads glShaderSource. */
	public static void glShaderSource(int shader, CharSequence string) {
		wglc.shaderSource((WebGLShader) getObject(shader), string.toString());
	}

	/** Overloads glShaderSource. */
	public static void glShaderSource(int shader, CharSequence[] strings) {
		wglc.shaderSource((WebGLShader) getObject(shader), null);
	}
	static native void nglShaderSource3(int shader, int count, long strings, long length, long function_pointer);

	public static int glCreateShader(int type) {
		
		return newObject(GL_OBJECT_SHADERS, wglc.createShader(type));
	}
	static native int nglCreateShader(int type, long function_pointer);

	public static boolean glIsShader(int shader) {
		
		return getType(shader) == GL_OBJECT_SHADERS;
	}
	static native boolean nglIsShader(int shader, long function_pointer);

	public static void glCompileShader(int shader) {
		WebGLShader s = (WebGLShader) getObject(shader);
		wglc.compileShader(s);
	}
	static native void nglCompileShader(int shader, long function_pointer);

	public static void glDeleteShader(int shader) {
		
		wglc.deleteShader((WebGLShader) getObject(shader));
	}
	static native void nglDeleteShader(int shader, long function_pointer);

	public static int glCreateProgram() {
		 
		return newObject(GL_OBJECT_PROGRAMS, wglc.createProgram());
	}
	static native int nglCreateProgram(long function_pointer);

	public static boolean glIsProgram(int program) {
		return getType(program) == GL_OBJECT_PROGRAMS;
	}
	static native boolean nglIsProgram(int program, long function_pointer);

	public static void glAttachShader(int program, int shader) {
		WebGLProgram pr = (WebGLProgram) getObject(program);
		WebGLShader sh = (WebGLShader) getObject(shader);
		
		wglc.attachShader(pr, sh);
	}
	static native void nglAttachShader(int program, int shader, long function_pointer);

	public static void glDetachShader(int program, int shader) {
		wglc.detachShader((WebGLProgram) getObject(program),(WebGLShader) getObject(shader));
	}
	static native void nglDetachShader(int program, int shader, long function_pointer);

	public static void glLinkProgram(int program) {
		wglc.linkProgram((WebGLProgram) getObject(program));
	}
	static native void nglLinkProgram(int program, long function_pointer);

	public static void glUseProgram(int program) {
		wglc.useProgram((WebGLProgram) getObject(program));
	}
	static native void nglUseProgram(int program, long function_pointer);

	public static void glValidateProgram(int program) {
		wglc.validateProgram((WebGLProgram) getObject(program));
	}
	static native void nglValidateProgram(int program, long function_pointer);

	public static void glDeleteProgram(int program) {
		wglc.deleteProgram((WebGLProgram) getObject(program));
	}
	static native void nglDeleteProgram(int program, long function_pointer);

	public static void glUniform1f(int location, float v0) {
		wglc.uniform1f((WebGLUniformLocation) getObject(location), v0);
	}
	static native void nglUniform1f(int location, float v0, long function_pointer);

	public static void glUniform2f(int location, float v0, float v1) {
		wglc.uniform2f((WebGLUniformLocation) getObject(location), v0, v1);
	}
	static native void nglUniform2f(int location, float v0, float v1, long function_pointer);

	public static void glUniform3f(int location, float v0, float v1, float v2) {
		wglc.uniform3f((WebGLUniformLocation) getObject(location), v0, v1, v2);
	}
	static native void nglUniform3f(int location, float v0, float v1, float v2, long function_pointer);

	public static void glUniform4f(int location, float v0, float v1, float v2, float v3) {
		wglc.uniform4f((WebGLUniformLocation) getObject(location), v0, v1, v2, v3);
		
	}
	static native void nglUniform4f(int location, float v0, float v1, float v2, float v3, long function_pointer);

	public static void glUniform1i(int location, int v0) {
		wglc.uniform1i((WebGLUniformLocation) getObject(location), v0);
	}
	static native void nglUniform1i(int location, int v0, long function_pointer);

	public static void glUniform2i(int location, int v0, int v1) {
		wglc.uniform2i((WebGLUniformLocation) getObject(location), v0, v1);
		
	}
	static native void nglUniform2i(int location, int v0, int v1, long function_pointer);

	public static void glUniform3i(int location, int v0, int v1, int v2) {
		wglc.uniform3i((WebGLUniformLocation) getObject(location), v0, v1, v2);
	}
	static native void nglUniform3i(int location, int v0, int v1, int v2, long function_pointer);

	public static void glUniform4i(int location, int v0, int v1, int v2, int v3) {
		wglc.uniform4i((WebGLUniformLocation) getObject(location), v0, v1, v2, v3);
	}
	static native void nglUniform4i(int location, int v0, int v1, int v2, int v3, long function_pointer);

	public static void glUniform1(int location, FloatBuffer values) {
		float[] arr = new float[values.remaining()];
		values.get(arr);
		wglc.uniform4fv((WebGLUniformLocation) getObject(location), arr);
	}
	static native void nglUniform1fv(int location, int values_count, long values, long function_pointer);

	public static void glUniform2(int location, FloatBuffer values) {
		float[] arr = new float[values.remaining()];
		values.get(arr);
		wglc.uniform4fv((WebGLUniformLocation) getObject(location), arr);
		
	}
	static native void nglUniform2fv(int location, int values_count, long values, long function_pointer);

	public static void glUniform3(int location, FloatBuffer values) {
		float[] arr = new float[values.remaining()];
		values.get(arr);
		wglc.uniform4fv((WebGLUniformLocation) getObject(location), arr);
		
	}
	static native void nglUniform3fv(int location, int values_count, long values, long function_pointer);

	public static void glUniform4(int location, FloatBuffer values) {
		float[] arr = new float[values.remaining()];
		values.get(arr);
		wglc.uniform4fv((WebGLUniformLocation) getObject(location), arr);
	}
	static native void nglUniform4fv(int location, int values_count, long values, long function_pointer);

	public static void glUniform1(int location, IntBuffer values) {
		int[] arr = new int[values.remaining()];
		values.get(arr);
		wglc.uniform1iv((WebGLUniformLocation) getObject(location), arr);
	}
	static native void nglUniform1iv(int location, int values_count, long values, long function_pointer);

	public static void glUniform2(int location, IntBuffer values) {
		int[] arr = new int[values.remaining()];
		
		values.get(arr);
		wglc.uniform2iv((WebGLUniformLocation) getObject(location), arr);
	}
	static native void nglUniform2iv(int location, int values_count, long values, long function_pointer);

	public static void glUniform3(int location, IntBuffer values) {
		int[] arr = new int[values.remaining()];
		
		values.get(arr);
		wglc.uniform3iv((WebGLUniformLocation) getObject(location), arr);
	}
	static native void nglUniform3iv(int location, int values_count, long values, long function_pointer);

	public static void glUniform4(int location, IntBuffer values) {
		int len = values.remaining();
		Float32Array fa = Float32Array.create(len);
		int i = 0;
		for (i = 0; i < len; i++) {
			fa.set(i, values.get());
		}
		wglc.uniform4fv((WebGLUniformLocation) getObject(location), fa);
		
	}
	static native void nglUniform4iv(int location, int values_count, long values, long function_pointer);

	public static void glUniformMatrix2(int location, boolean transpose, FloatBuffer matrices) {
		int len = matrices.remaining();
		Float32Array fa = Float32Array.create(len);
		int i = 0;
		for (i = 0; i < len; i++) {
			fa.set(i, matrices.get());
		}
		wglc.uniformMatrix2fv((WebGLUniformLocation) getObject(location), transpose, fa);
	}
	static native void nglUniformMatrix2fv(int location, int matrices_count, boolean transpose, long matrices, long function_pointer);

	public static void glUniformMatrix3(int location, boolean transpose, FloatBuffer matrices) {
		int len = matrices.remaining();
		Float32Array fa = Float32Array.create(len);
		int i = 0;
		for (i = 0; i < len; i++) {
			fa.set(i, matrices.get());
		}
		wglc.uniformMatrix3fv((WebGLUniformLocation) getObject(location), transpose, fa);
	}
	static native void nglUniformMatrix3fv(int location, int matrices_count, boolean transpose, long matrices, long function_pointer);

	public static void glUniformMatrix4(int location, boolean transpose, FloatBuffer matrices) {
		int len = matrices.remaining();
		Float32Array fa = Float32Array.create(len);
		int i = 0;
		for (i = 0; i < len; i++) {
			fa.set(i, matrices.get());
		}
		wglc.uniformMatrix4fv((WebGLUniformLocation) getObject(location), transpose, fa);
	}
	static native void nglUniformMatrix4fv(int location, int matrices_count, boolean transpose, long matrices, long function_pointer);

	public static void glGetShader(int shader, int pname, IntBuffer params) {
		params.put(wglc.getShaderParameteri((WebGLShader) getObject(shader), pname));
		params.flip();
	}
	static native void nglGetShaderiv(int shader, int pname, long params, long function_pointer);
	
	/**
	 * Overloads glGetShaderiv.
	 * <p>
	 * @deprecated Will be removed in 3.0. Use {@link #glGetShaderi} instead. 
	 */
	@Deprecated
	public static int glGetShader(int shader, int pname) {
		return GL20.glGetShaderi(shader, pname);
	}

	/** Overloads glGetShaderiv. */
	public static int glGetShaderi(int shader, int pname) {
		return wglc.getShaderParameteri((WebGLShader) getObject(shader), pname);
		
		
	}

	public static void glGetProgram(int program, int pname, IntBuffer params) {
		params.put(wglc.getProgramParameteri((WebGLProgram) getObject(program), pname));
		params.flip();
	}
	static native void nglGetProgramiv(int program, int pname, long params, long function_pointer);

	/**
	 * Overloads glGetProgramiv.
	 * <p>
	 * @deprecated Will be removed in 3.0. Use {@link #glGetProgrami} instead. 
	 */
	@Deprecated
	public static int glGetProgram(int program, int pname) {
		return GL20.glGetProgrami(program, pname);
	}

	/** Overloads glGetProgramiv. */
	public static int glGetProgrami(int program, int pname) {
		return wglc.getProgramParameteri((WebGLProgram) getObject(program), pname);
	}

	public static void glGetShaderInfoLog(int shader, IntBuffer length, ByteBuffer infoLog) {
		infoLog.put(wglc.getShaderInfoLog((WebGLShader) getObject(shader)).getBytes(StandardCharsets.UTF_8));
		length.put(wglc.getShaderInfoLog((WebGLShader) getObject(shader)).getBytes(StandardCharsets.UTF_8).length * Byte.BYTES);
		infoLog.flip(); length.flip();
	}
	static native void nglGetShaderInfoLog(int shader, int infoLog_maxLength, long length, long infoLog, long function_pointer);

	/** Overloads glGetShaderInfoLog. */
	public static String glGetShaderInfoLog(int shader, int maxLength) {
		return wglc.getShaderInfoLog((WebGLShader) getObject(shader)).substring(0, maxLength);
	}

	public static void glGetProgramInfoLog(int program, IntBuffer length, ByteBuffer infoLog) {
		byte[] programInfoLog = wglc.getProgramInfoLog((WebGLProgram) getObject(program)).getBytes(StandardCharsets.UTF_8);
		infoLog.put(programInfoLog);
		length.put(programInfoLog.length);
	}
	static native void nglGetProgramInfoLog(int program, int infoLog_maxLength, long length, long infoLog, long function_pointer);

	/** Overloads glGetProgramInfoLog. */
	public static String glGetProgramInfoLog(int program, int maxLength) {
		return wglc.getProgramInfoLog((WebGLProgram) getObject(program));
	}

	public static void glGetAttachedShaders(int program, IntBuffer count, IntBuffer shaders1) {
		System.out.println("Unavailable");
		
	}
	static native void nglGetAttachedShaders(int program, int shaders_maxCount, long count, long shaders, long function_pointer);

	/**
	 *  Returns the location of the uniform with the specified name. The ByteBuffer should contain the uniform name as a
	 *  <b>null-terminated</b> string.
	 * <p>
	 *  @param program
	 *  @param name
	 */
	public static int glGetUniformLocation(int program, ByteBuffer name) {
		
		return newObject(GL_OBJECT_UNIFORMS, wglc.getUniformLocation((WebGLProgram) getObject(program), name.asCharBuffer().toString()));
		
	}
	static native int nglGetUniformLocation(int program, long name, long function_pointer);

	/** Overloads glGetUniformLocation. */
	public static int glGetUniformLocation(int program, CharSequence name) {
		
		return newObject(GL_OBJECT_UNIFORMS, wglc.getUniformLocation((WebGLProgram) getObject(program), name.toString()));
	}

	public static void glGetActiveUniform(int program, int index, IntBuffer length, IntBuffer size, IntBuffer type, ByteBuffer name) {
		WebGLActiveInfo info = wglc.getActiveUniform((WebGLProgram) getObject(program), index);
		
		length.put(info.getSize());
		type.put(info.getType());
		
		
		
		
	}
	static native void nglGetActiveUniform(int program, int index, int name_maxLength, long length, long size, long type, long name, long function_pointer);

	/**
	 * Overloads glGetActiveUniform.
	 * <p>
	 * Overloads glGetActiveUniform. This version returns both size and type in the sizeType buffer (at .position() and .position() + 1). 
	 */
	public static String glGetActiveUniform(int program, int index, int maxLength, IntBuffer sizeType) {
		sizeType.put(wglc.getActiveUniform((WebGLProgram) getObject(program), index).getSize());
		sizeType.put(wglc.getActiveUniform((WebGLProgram) getObject(program), index).getType());
		return wglc.getActiveUniform((WebGLProgram) getObject(program), index).getName();
	}

	/**
	 * Overloads glGetActiveUniform.
	 * <p>
	 * Overloads glGetActiveUniformARB. This version returns only the uniform name. 
	 */
	public static String glGetActiveUniform(int program, int index, int maxLength) {
		return wglc.getActiveUniform((WebGLProgram) getObject(program), index).getName();
	}

	/**
	 * Overloads glGetActiveUniform.
	 * <p>
	 * Overloads glGetActiveUniform. This version returns only the uniform size. 
	 */
	public static int glGetActiveUniformSize(int program, int index) {
		return wglc.getActiveUniform((WebGLProgram) getObject(program), index).getSize();
		
	}

	/**
	 * Overloads glGetActiveUniform.
	 * <p>
	 * Overloads glGetActiveUniform. This version returns only the uniform type. 
	 */
	public static int glGetActiveUniformType(int program, int index) {
		return ConstantMapper.cmShaderTypes.mapWebGLToReal(wglc.getActiveUniform((WebGLProgram) getObject(program), index).getType());
	}

	public static void glGetUniform(int program, WebGLUniformLocation location, FloatBuffer params) {
		Float32Array s = (Float32Array) wglc.getUniform((WebGLProgram) getObject(program), location);
		for (int a = 0; a < s.getLength(); a++) {
			params.put(s.get(a));
		}
		
	}
	static native void nglGetUniformfv(int program, int location, long params, long function_pointer);

	public static void glGetUniform(int program, int location, IntBuffer params) {
		wglc.getUniform((WebGLProgram) getObject(program), (WebGLUniformLocation) getObject(location));
	}
	static native void nglGetUniformiv(int program, int location, long params, long function_pointer);

	public static void glGetShaderSource(int shader, IntBuffer length, ByteBuffer source) {
		
	}
	static native void nglGetShaderSource(int shader, int source_maxLength, long length, long source, long function_pointer);

	/** Overloads glGetShaderSource. */
	public static String glGetShaderSource(int shader, int maxLength) {
		return wglc.getShaderSource((WebGLShader) getObject(shader)).substring(0, maxLength);
	}

	public static void glVertexAttrib1s(int index, short x) {
		wglc.vertexAttrib1f(index, x);
	}
	static native void nglVertexAttrib1s(int index, short x, long function_pointer);

	public static void glVertexAttrib1f(int index, float x) {
		wglc.vertexAttrib1f(index, x);
	}
	static native void nglVertexAttrib1f(int index, float x, long function_pointer);

	public static void glVertexAttrib1d(int index, double x) {
		wglc.vertexAttrib1f(index, (float) x);
	}
	static native void nglVertexAttrib1d(int index, double x, long function_pointer);

	public static void glVertexAttrib2s(int index, short x, short y) {
		wglc.vertexAttrib2f(index,(float) x,(float) y);
	}
	static native void nglVertexAttrib2s(int index, short x, short y, long function_pointer);

	public static void glVertexAttrib2f(int index, float x, float y) {
		wglc.vertexAttrib2f(index,(float) x,(float) y);
	}
	static native void nglVertexAttrib2f(int index, float x, float y, long function_pointer);

	public static void glVertexAttrib2d(int index, double x, double y) {
		wglc.vertexAttrib2f(index, (float) x, (float) y);
	}
	static native void nglVertexAttrib2d(int index, double x, double y, long function_pointer);

	public static void glVertexAttrib3s(int index, short x, short y, short z) {
		wglc.vertexAttrib3f(index,(float) x,(float) y,(float) z);
	}
	static native void nglVertexAttrib3s(int index, short x, short y, short z, long function_pointer);

	public static void glVertexAttrib3f(int index, float x, float y, float z) {
		wglc.vertexAttrib3f(index,(float) x,(float) y,(float) z);
	}
	static native void nglVertexAttrib3f(int index, float x, float y, float z, long function_pointer);

	public static void glVertexAttrib3d(int index, double x, double y, double z) {
		wglc.vertexAttrib3f(index, (float) x, (float) y, (float) z);
	}
	static native void nglVertexAttrib3d(int index, double x, double y, double z, long function_pointer);

	public static void glVertexAttrib4s(int index, short x, short y, short z, short w) {
		wglc.vertexAttrib4f(index,(float) x,(float) y,(float) z,(float) w);
	}
	static native void nglVertexAttrib4s(int index, short x, short y, short z, short w, long function_pointer);

	public static void glVertexAttrib4f(int index, float x, float y, float z, float w) {
		wglc.vertexAttrib4f(index, x, y, z, w);
	}
	static native void nglVertexAttrib4f(int index, float x, float y, float z, float w, long function_pointer);

	public static void glVertexAttrib4d(int index, double x, double y, double z, double w) {
		wglc.vertexAttrib4f(index,(float) x,(float) y,(float) z,(float) w);
	}
	static native void nglVertexAttrib4d(int index, double x, double y, double z, double w, long function_pointer);

	public static void glVertexAttrib4Nub(int index, byte x, byte y, byte z, byte w) {
		wglc.vertexAttrib4f(index, x, y, z, w);
	}
	static native void nglVertexAttrib4Nub(int index, byte x, byte y, byte z, byte w, long function_pointer);

	public static void glVertexAttribPointer(int index, int size, boolean normalized, int stride, DoubleBuffer buffer) {
	
		wglc.vertexAttribPointer(index, size, WebGLConstants.FLOAT, normalized, stride, (int) buffer.get());
		
	}
	public static void glVertexAttribPointer(int index, int size, boolean normalized, int stride, FloatBuffer buffer) {
		wglc.vertexAttribPointer(index, size, WebGLConstants.FLOAT, normalized, stride, (int) buffer.get());
	}
	public static void glVertexAttribPointer(int index, int size, boolean unsigned, boolean normalized, int stride, ByteBuffer buffer) {
		wglc.vertexAttribPointer(index, size, WebGLConstants.FLOAT, normalized, stride, (int) buffer.get());
	}
	public static void glVertexAttribPointer(int index, int size, boolean unsigned, boolean normalized, int stride, IntBuffer buffer) {
		wglc.vertexAttribPointer(index, size, WebGLConstants.FLOAT, normalized, stride, (int) buffer.get());
	}
	public static void glVertexAttribPointer(int index, int size, boolean unsigned, boolean normalized, int stride, ShortBuffer buffer) {
		wglc.vertexAttribPointer(index, size, WebGLConstants.FLOAT, normalized, stride, (int) buffer.get());
	}
	static native void nglVertexAttribPointer(int index, int size, int type, boolean normalized, int stride, long buffer, long function_pointer);
	public static void glVertexAttribPointer(int index, int size, int type, boolean normalized, int stride, long buffer_buffer_offset) {
		wglc.vertexAttribPointer(index, size, WebGLConstants.FLOAT, normalized, stride, (int) buffer_buffer_offset);
		
	}
	static native void nglVertexAttribPointerBO(int index, int size, int type, boolean normalized, int stride, long buffer_buffer_offset, long function_pointer);

	/** Overloads glVertexAttribPointer. */
	public static void glVertexAttribPointer(int index, int size, int type, boolean normalized, int stride, ByteBuffer buffer) {
		wglc.vertexAttribPointer(index, size, WebGLConstants.FLOAT, normalized, stride, (int) buffer.get());
	}

	public static void glEnableVertexAttribArray(int index) {
		wglc.enableVertexAttribArray(index);
	}
	static native void nglEnableVertexAttribArray(int index, long function_pointer);

	public static void glDisableVertexAttribArray(int index) {
		wglc.disableVertexAttribArray(index);
	}
	static native void nglDisableVertexAttribArray(int index, long function_pointer);

	public static void glGetVertexAttrib(int index, int pname, FloatBuffer params) {
		Float32Array actualParams = wglc.getVertexAttrib(index, pname).<Float32Array> cast();
		int len = actualParams.getLength();
		
		for (int i = 0; i < len; i++) {
			params.put(actualParams.get(i));
		}
		
	}
	static native void nglGetVertexAttribfv(int index, int pname, long params, long function_pointer);

	public static void glGetVertexAttrib(int index, int pname, DoubleBuffer params) {
		Float32Array actualParams = wglc.getVertexAttrib(index, pname).<Float32Array> cast();
		int len = actualParams.getLength();
		
		for (int i = 0; i < len; i++) {
			params.put(actualParams.get(i));
		}
	}
	static native void nglGetVertexAttribdv(int index, int pname, long params, long function_pointer);

	public static void glGetVertexAttrib(int index, int pname, IntBuffer params) {
		int result = wglc.getVertexAttrib(index, pname).<JSNumber> cast().intValue();
		params.put(result);
		params.flip();
		return;
	}
	
	static native void nglGetVertexAttribiv(int index, int pname, long params, long function_pointer);

	public static ByteBuffer glGetVertexAttribPointer(int index, int pname, long result_size) {
		byte result = wglc.getVertexAttrib(index, pname).<JSNumber> cast().byteValue();
		ByteBuffer bb = BufferUtils.createByteBuffer((int) result_size);
		bb.put(result);
		bb.flip();
		return bb;
	}
	static native ByteBuffer nglGetVertexAttribPointerv(int index, int pname, long result_size, long function_pointer);

	/** Overloads glGetVertexAttribPointerv. */
	public static void glGetVertexAttribPointer(int index, int pname, ByteBuffer pointer) {
		//TODO: Stub
		byte b = wglc.getVertexAttrib(index, pname).<JSNumber> cast().byteValue();
		pointer.put(b);
		pointer.flip();
	}
	static native void nglGetVertexAttribPointerv2(int index, int pname, long pointer, long function_pointer);

	public static void glBindAttribLocation(int program, int index, ByteBuffer name) {
		wglc.bindAttribLocation((WebGLProgram) getObject(program), index, name.asCharBuffer().toString());
	}
	static native void nglBindAttribLocation(int program, int index, long name, long function_pointer);

	/** Overloads glBindAttribLocation. */
	public static void glBindAttribLocation(int program, int index, CharSequence name) {
		wglc.bindAttribLocation((WebGLProgram) getObject(program), index, name.toString());
	}

	public static void glGetActiveAttrib(int program, int index, IntBuffer length, IntBuffer size, IntBuffer type, ByteBuffer name) {
		WebGLRenderingContext c = ((WebGLRenderingContext) CurrentContext.getContext());
		WebGLActiveInfo wai = c.getActiveAttrib((WebGLProgram) getObject(program), index);
		length.put(wai.getSize());
		length.flip();
		size.put(wai.getSize());
		size.flip();
		type.put(wai.getType());
		type.flip();
		name.asCharBuffer().put(wai.getName());
		
	}
	static native void nglGetActiveAttrib(int program, int index, int name_maxLength, long length, long size, long type, long name, long function_pointer);

	/**
	 * Overloads glGetActiveAttrib.
	 * <p>
	 * Overloads glGetActiveAttrib. This version returns both size and type in the sizeType buffer (at .position() and .position() + 1). 
	 */
	public static String glGetActiveAttrib(int program, int index, int maxLength, IntBuffer sizeType) {
		sizeType.put(wglc.getActiveAttrib((WebGLProgram) getObject(program), index).getSize());
		sizeType.put(wglc.getActiveAttrib((WebGLProgram) getObject(program), index).getType());
		sizeType.flip();
		return wglc.getActiveAttrib((WebGLProgram) getObject(program), index).getName();
		
	}

	/**
	 * Overloads glGetActiveAttrib.
	 * <p>
	 * Overloads glGetActiveAttrib. This version returns only the attrib name. 
	 */
	public static String glGetActiveAttrib(int program, int index, int maxLength) {
		return wglc.getActiveAttrib((WebGLProgram) getObject(program), index).getName();
	}

	/**
	 * Overloads glGetActiveAttrib.
	 * <p>
	 * Overloads glGetActiveAttribARB. This version returns only the attrib size. 
	 */
	public static int glGetActiveAttribSize(int program, int index) {
		return wglc.getActiveAttrib((WebGLProgram) getObject(program), index).getSize();
	}

	/**
	 * Overloads glGetActiveAttrib.
	 * <p>
	 * Overloads glGetActiveAttrib. This version returns only the attrib type. 
	 */
	public static int glGetActiveAttribType(int program, int index) {
		return wglc.getActiveAttrib((WebGLProgram) getObject(program), index).getType();
	}

	public static int glGetAttribLocation(int program, ByteBuffer name) {
		return wglc.getAttribLocation((WebGLProgram) getObject(program), name.asCharBuffer().toString());
	}
	static native int nglGetAttribLocation(int program, long name, long function_pointer);

	/** Overloads glGetAttribLocation. */
	public static int glGetAttribLocation(int program, CharSequence name) {
		return wglc.getAttribLocation((WebGLProgram) getObject(program), name.toString());
	}

	public static void glDrawBuffers(IntBuffer buffers) {
		//TODO: Stub
		int len = buffers.remaining();
		int[] abc = new int[len];
		for (int i = 0; i < len; i++) {
			abc[i] = buffers.get();
		}
		wglc.drawBuffers(abc);
		
	}
	static native void nglDrawBuffers(int buffers_size, long buffers, long function_pointer);

	/** Overloads glDrawBuffers. */
	public static void glDrawBuffers(int buffer) {
		//TODO: Stub
		wglc.drawBuffers(new int[buffer]);
	}

	public static void glStencilOpSeparate(int face, int sfail, int dpfail, int dppass) {
//		ConstantMapper map = ConstantMapper.cmStencilActions;
		
		wglc.stencilOpSeparate(face, sfail, dpfail, dppass);
		
	}
	static native void nglStencilOpSeparate(int face, int sfail, int dpfail, int dppass, long function_pointer);

	public static void glStencilFuncSeparate(int face, int func, int ref, int mask) {
//		ConstantMapper map = ConstantMapper.cmStencilActions;
		wglc.stencilFuncSeparate(face, func, ref, mask);
	}
	static native void nglStencilFuncSeparate(int face, int func, int ref, int mask, long function_pointer);

	public static void glStencilMaskSeparate(int face, int mask) {
	
		wglc.stencilMaskSeparate(face, mask);
	}
	static native void nglStencilMaskSeparate(int face, int mask, long function_pointer);

	public static void glBlendEquationSeparate(int modeRGB, int modeAlpha) {
		wglc.blendEquationSeparate(modeRGB, modeAlpha);
	}
	static native void nglBlendEquationSeparate(int modeRGB, int modeAlpha, long function_pointer);
}