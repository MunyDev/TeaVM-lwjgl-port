/* MACHINE GENERATED FILE, DO NOT EDIT */

package org.lwjgl.opengl;

import org.lwjgl.util.GLUtil;
import org.munydev.teavm.lwjgl.CurrentContext;
import org.teavm.jso.typedarrays.Float32Array;
import org.teavm.jso.webgl.WebGLUniformLocation;
import org.teavm.webgl2.WebGL2RenderingContext;
import static org.lwjgl.opengl.GLObjectBuffers.*;
import java.nio.*;

public final class GL21 {

	/**
	 * Returned by the &lt;type&gt; parameter of GetActiveAttribARB. 
	 */
	public static final int GL_FLOAT_MAT2x3 = 0x8B65,
		GL_FLOAT_MAT2x4 = 0x8B66,
		GL_FLOAT_MAT3x2 = 0x8B67,
		GL_FLOAT_MAT3x4 = 0x8B68,
		GL_FLOAT_MAT4x2 = 0x8B69,
		GL_FLOAT_MAT4x3 = 0x8B6A;

	/**
	 *  Accepted by the &lt;target&gt; parameters of BindBuffer, BufferData,
	 *  BufferSubData, MapBuffer, UnmapBuffer, GetBufferSubData,
	 *  GetBufferParameteriv, and GetBufferPointerv.
	 */
	public static final int GL_PIXEL_PACK_BUFFER = 0x88EB,
		GL_PIXEL_UNPACK_BUFFER = 0x88EC;

	/**
	 *  Accepted by the &lt;pname&gt; parameter of GetBooleanv, GetIntegerv,
	 *  GetFloatv, and GetDoublev.
	 */
	public static final int GL_PIXEL_PACK_BUFFER_BINDING = 0x88ED,
		GL_PIXEL_UNPACK_BUFFER_BINDING = 0x88EF;

	/**
	 *  Accepted by the &lt;internalformat&gt; parameter of TexImage1D, TexImage2D,
	 *  TexImage3D, CopyTexImage1D, CopyTexImage2D.
	 */
	public static final int GL_SRGB = 0x8C40,
		GL_SRGB8 = 0x8C41,
		GL_SRGB_ALPHA = 0x8C42,
		GL_SRGB8_ALPHA8 = 0x8C43,
		GL_SLUMINANCE_ALPHA = 0x8C44,
		GL_SLUMINANCE8_ALPHA8 = 0x8C45,
		GL_SLUMINANCE = 0x8C46,
		GL_SLUMINANCE8 = 0x8C47,
		GL_COMPRESSED_SRGB = 0x8C48,
		GL_COMPRESSED_SRGB_ALPHA = 0x8C49,
		GL_COMPRESSED_SLUMINANCE = 0x8C4A,
		GL_COMPRESSED_SLUMINANCE_ALPHA = 0x8C4B;
	private static WebGL2RenderingContext ctx = (WebGL2RenderingContext) CurrentContext.getContext();
	/**
	 * Accepted by the &lt;pname&gt; parameter of GetIntegerv and GetFloatv. 
	 */
	public static final int GL_CURRENT_RASTER_SECONDARY_COLOR = 0x845F;

	private GL21() {}

	public static void glUniformMatrix2x3(int location, boolean transpose, FloatBuffer matrices) {
		ctx.uniformMatrix2x3fv((WebGLUniformLocation) getObject(location) , transpose, Float32Array.create(GLUtil.glCreateBufferFromJava(matrices)));
	}
	static native void nglUniformMatrix2x3fv(int location, int matrices_count, boolean transpose, long matrices, long function_pointer);

	public static void glUniformMatrix3x2(int location, boolean transpose, FloatBuffer matrices) {
		ctx.uniformMatrix3x2fv((WebGLUniformLocation) getObject(location), transpose, Float32Array.create(GLUtil.glCreateBufferFromJava(matrices)));
	}
	static native void nglUniformMatrix3x2fv(int location, int matrices_count, boolean transpose, long matrices, long function_pointer);

	public static void glUniformMatrix2x4(int location, boolean transpose, FloatBuffer matrices) {
		ctx.uniformMatrix2x4fv((WebGLUniformLocation) getObject(location), transpose, Float32Array.create(GLUtil.glCreateBufferFromJava(matrices)));
	}
	static native void nglUniformMatrix2x4fv(int location, int matrices_count, boolean transpose, long matrices, long function_pointer);

	public static void glUniformMatrix4x2(int location, boolean transpose, FloatBuffer matrices) {
		ctx.uniformMatrix4x2fv((WebGLUniformLocation) getObject(location), transpose, Float32Array.create(GLUtil.glCreateBufferFromJava(matrices)));
	}
	static native void nglUniformMatrix4x2fv(int location, int matrices_count, boolean transpose, long matrices, long function_pointer);

	public static void glUniformMatrix3x4(int location, boolean transpose, FloatBuffer matrices) {
		ctx.uniformMatrix3x4fv((WebGLUniformLocation) getObject(location), transpose, Float32Array.create(GLUtil.glCreateBufferFromJava(matrices)));
	}
	static native void nglUniformMatrix3x4fv(int location, int matrices_count, boolean transpose, long matrices, long function_pointer);

	public static void glUniformMatrix4x3(int location, boolean transpose, FloatBuffer matrices) {
		ctx.uniformMatrix4x3fv((WebGLUniformLocation) getObject(location), transpose, Float32Array.create(GLUtil.glCreateBufferFromJava(matrices)), 0, 0);
	}
	static native void nglUniformMatrix4x3fv(int location, int matrices_count, boolean transpose, long matrices, long function_pointer);
}
