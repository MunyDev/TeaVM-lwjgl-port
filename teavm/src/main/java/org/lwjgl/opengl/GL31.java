/* MACHINE GENERATED FILE, DO NOT EDIT */

package org.lwjgl.opengl;

import org.munydev.teavm.lwjgl.CurrentContext;
import org.teavm.jso.core.JSNumber;
import org.teavm.jso.webgl.WebGLActiveInfo;
import org.teavm.jso.webgl.WebGLProgram;
import org.teavm.webgl2.WebGL2RenderingContext;
import static org.lwjgl.opengl.GLObjectBuffers.*;
import java.nio.*;

public final class GL31 {

	public static final int GL_RED_SNORM = 0x8F90,
		GL_RG_SNORM = 0x8F91,
		GL_RGB_SNORM = 0x8F92,
		GL_RGBA_SNORM = 0x8F93,
		GL_R8_SNORM = 0x8F94,
		GL_RG8_SNORM = 0x8F95,
		GL_RGB8_SNORM = 0x8F96,
		GL_RGBA8_SNORM = 0x8F97,
		GL_R16_SNORM = 0x8F98,
		GL_RG16_SNORM = 0x8F99,
		GL_RGB16_SNORM = 0x8F9A,
		GL_RGBA16_SNORM = 0x8F9B,
		GL_SIGNED_NORMALIZED = 0x8F9C,
		GL_COPY_READ_BUFFER_BINDING = 0x8F36,
		GL_COPY_WRITE_BUFFER_BINDING = 0x8F37,
		GL_COPY_READ_BUFFER = 0x8F36,
		GL_COPY_WRITE_BUFFER = 0x8F37;

	/**
	 *  Accepted by the &lt;cap&gt; parameter of IsEnabled, and by
	 *  the &lt;pname&gt; parameter of GetBooleanv, GetIntegerv, GetFloatv, and
	 *  GetDoublev:
	 */
	public static final int GL_PRIMITIVE_RESTART = 0x8F9D;

	/**
	 *  Accepted by the &lt;pname&gt; parameter of GetBooleanv, GetIntegerv,
	 *  GetFloatv, and GetDoublev:
	 */
	public static final int GL_PRIMITIVE_RESTART_INDEX = 0x8F9E;

	/**
	 *  Accepted by the &lt;target&gt; parameter of BindBuffer, BufferData,
	 *  BufferSubData, MapBuffer, MapBufferRange, BindTexture, UnmapBuffer,
	 *  GetBufferSubData, GetBufferParameteriv, GetBufferPointerv, and TexBuffer,
	 *  and the <pname> parameter of GetBooleanv, GetDoublev, GetFloatv, and
	 *  GetIntegerv:
	 */
	public static final int GL_TEXTURE_BUFFER = 0x8C2A;

	/**
	 *  Accepted by the &lt;pname&gt; parameters of GetBooleanv, GetDoublev,
	 *  GetFloatv, and GetIntegerv:
	 */
	public static final int GL_MAX_TEXTURE_BUFFER_SIZE = 0x8C2B,
		GL_TEXTURE_BINDING_BUFFER = 0x8C2C,
		GL_TEXTURE_BUFFER_DATA_STORE_BINDING = 0x8C2D,
		GL_TEXTURE_BUFFER_FORMAT = 0x8C2E;

	/**
	 *  Accepted by the &lt;cap&gt; parameter of Enable, Disable and IsEnabled;
	 *  by the &lt;pname&gt; parameter of GetBooleanv, GetIntegerv, GetFloatv
	 *  and GetDoublev; and by the &lt;target&gt; parameter of BindTexture,
	 *  GetTexParameterfv, GetTexParameteriv, TexParameterf, TexParameteri,
	 *  TexParameterfv and TexParameteriv:
	 *  Accepted by the &lt;target&gt; parameter of GetTexImage,
	 *  GetTexLevelParameteriv, GetTexLevelParameterfv, TexImage2D,
	 *  CopyTexImage2D, TexSubImage2D and CopySubTexImage2D:
	 */
	public static final int GL_TEXTURE_RECTANGLE = 0x84F5;

	/**
	 *  Accepted by the &lt;pname&gt; parameter of GetBooleanv, GetIntegerv,
	 *  GetFloatv and GetDoublev:
	 */
	public static final int GL_TEXTURE_BINDING_RECTANGLE = 0x84F6;

	/**
	 *  Accepted by the &lt;target&gt; parameter of GetTexLevelParameteriv,
	 *  GetTexLevelParameterfv, GetTexParameteriv and TexImage2D:
	 */
	public static final int GL_PROXY_TEXTURE_RECTANGLE = 0x84F7;

	/**
	 *  Accepted by the &lt;pname&gt; parameter of GetBooleanv, GetDoublev,
	 *  GetIntegerv and GetFloatv:
	 */
	public static final int GL_MAX_RECTANGLE_TEXTURE_SIZE = 0x84F8;

	/**
	 *  Returned by &lt;type&gt; parameter of GetActiveUniform when the location
	 *  &lt;index&gt; for program object &lt;program&gt; is of type sampler2DRect:
	 */
	public static final int GL_SAMPLER_2D_RECT = 0x8B63;

	/**
	 *  Returned by &lt;type&gt; parameter of GetActiveUniform when the location
	 *  &lt;index&gt; for program object &lt;program&gt; is of type sampler2DRectShadow:
	 */
	public static final int GL_SAMPLER_2D_RECT_SHADOW = 0x8B64;

	/**
	 *  Accepted by the &lt;target&gt; parameters of BindBuffer, BufferData,
	 *  BufferSubData, MapBuffer, UnmapBuffer, GetBufferSubData, and
	 *  GetBufferPointerv:
	 */
	public static final int GL_UNIFORM_BUFFER = 0x8A11;

	/**
	 *  Accepted by the &lt;pname&gt; parameter of GetIntegeri_v, GetBooleanv,
	 *  GetIntegerv, GetFloatv, and GetDoublev:
	 */
	public static final int GL_UNIFORM_BUFFER_BINDING = 0x8A28;

	/**
	 * Accepted by the &lt;pname&gt; parameter of GetIntegeri_v: 
	 */
	public static final int GL_UNIFORM_BUFFER_START = 0x8A29,
		GL_UNIFORM_BUFFER_SIZE = 0x8A2A;

	/**
	 *  Accepted by the &lt;pname&gt; parameter of GetBooleanv, GetIntegerv,
	 *  GetFloatv, and GetDoublev:
	 */
	public static final int GL_MAX_VERTEX_UNIFORM_BLOCKS = 0x8A2B,
		GL_MAX_GEOMETRY_UNIFORM_BLOCKS = 0x8A2C,
		GL_MAX_FRAGMENT_UNIFORM_BLOCKS = 0x8A2D,
		GL_MAX_COMBINED_UNIFORM_BLOCKS = 0x8A2E,
		GL_MAX_UNIFORM_BUFFER_BINDINGS = 0x8A2F,
		GL_MAX_UNIFORM_BLOCK_SIZE = 0x8A30,
		GL_MAX_COMBINED_VERTEX_UNIFORM_COMPONENTS = 0x8A31,
		GL_MAX_COMBINED_GEOMETRY_UNIFORM_COMPONENTS = 0x8A32,
		GL_MAX_COMBINED_FRAGMENT_UNIFORM_COMPONENTS = 0x8A33,
		GL_UNIFORM_BUFFER_OFFSET_ALIGNMENT = 0x8A34;

	/**
	 * Accepted by the &lt;pname&gt; parameter of GetProgramiv: 
	 */
	public static final int GL_ACTIVE_UNIFORM_BLOCK_MAX_NAME_LENGTH = 0x8A35,
		GL_ACTIVE_UNIFORM_BLOCKS = 0x8A36;

	/**
	 * Accepted by the &lt;pname&gt; parameter of GetActiveUniformsiv: 
	 */
	public static final int GL_UNIFORM_TYPE = 0x8A37,
		GL_UNIFORM_SIZE = 0x8A38,
		GL_UNIFORM_NAME_LENGTH = 0x8A39,
		GL_UNIFORM_BLOCK_INDEX = 0x8A3A,
		GL_UNIFORM_OFFSET = 0x8A3B,
		GL_UNIFORM_ARRAY_STRIDE = 0x8A3C,
		GL_UNIFORM_MATRIX_STRIDE = 0x8A3D,
		GL_UNIFORM_IS_ROW_MAJOR = 0x8A3E;

	/**
	 * Accepted by the &lt;pname&gt; parameter of GetActiveUniformBlockiv: 
	 */
	public static final int GL_UNIFORM_BLOCK_BINDING = 0x8A3F,
		GL_UNIFORM_BLOCK_DATA_SIZE = 0x8A40,
		GL_UNIFORM_BLOCK_NAME_LENGTH = 0x8A41,
		GL_UNIFORM_BLOCK_ACTIVE_UNIFORMS = 0x8A42,
		GL_UNIFORM_BLOCK_ACTIVE_UNIFORM_INDICES = 0x8A43,
		GL_UNIFORM_BLOCK_REFERENCED_BY_VERTEX_SHADER = 0x8A44,
		GL_UNIFORM_BLOCK_REFERENCED_BY_GEOMETRY_SHADER = 0x8A45,
		GL_UNIFORM_BLOCK_REFERENCED_BY_FRAGMENT_SHADER = 0x8A46;

	/**
	 * Returned by GetActiveUniformsiv and GetUniformBlockIndex 
	 */
	public static final int GL_INVALID_INDEX = 0xFFFFFFFF;
	private static WebGL2RenderingContext ctx = (WebGL2RenderingContext) CurrentContext.getContext();

	private GL31() {}

	public static void glDrawArraysInstanced(int mode, int first, int count, int primcount) {
		ctx.drawArraysInstanced(mode, first, count, primcount);
	}
	static native void nglDrawArraysInstanced(int mode, int first, int count, int primcount, long function_pointer);

	public static void glDrawElementsInstanced(int mode, ByteBuffer indices, int primcount) {
//		ctx.drawElementsInstanced(mode, primcount, primcount, mode, primcount);
	}
	public static void glDrawElementsInstanced(int mode, IntBuffer indices, int primcount) {
		
	}
	public static void glDrawElementsInstanced(int mode, ShortBuffer indices, int primcount) {
		
	}
	static native void nglDrawElementsInstanced(int mode, int indices_count, int type, long indices, int primcount, long function_pointer);
	public static void glDrawElementsInstanced(int mode, int indices_count, int type, long indices_buffer_offset, int primcount) {
		ctx.drawElementsInstanced(mode, indices_count, type, (int) indices_buffer_offset, primcount);
	}
	static native void nglDrawElementsInstancedBO(int mode, int indices_count, int type, long indices_buffer_offset, int primcount, long function_pointer);

	public static void glCopyBufferSubData(int readtarget, int writetarget, long readoffset, long writeoffset, long size) {
		ctx.copyBufferSubData(readtarget, writetarget, (int) readoffset, (int) writeoffset, (int) size);
	}
	static native void nglCopyBufferSubData(int readtarget, int writetarget, long readoffset, long writeoffset, long size, long function_pointer);

	public static void glPrimitiveRestartIndex(int index) {
		
	}
	static native void nglPrimitiveRestartIndex(int index, long function_pointer);

	public static void glTexBuffer(int target, int internalformat, int buffer) {
		
	}
	static native void nglTexBuffer(int target, int internalformat, int buffer, long function_pointer);

	public static void glGetUniformIndices(int program, ByteBuffer uniformNames, IntBuffer uniformIndices) {
		ctx.getUniformIndices((WebGLProgram) get(program).getObject(), new String[] {uniformNames.asCharBuffer().toString()});
	}
	static native void nglGetUniformIndices(int program, int uniformIndices_uniformCount, long uniformNames, long uniformIndices, long function_pointer);

	/** Overloads glGetUniformIndices. */
	public static void glGetUniformIndices(int program, CharSequence[] uniformNames, IntBuffer uniformIndices) {
		uniformIndices.put(ctx.getUniformIndices((WebGLProgram) get(program).getObject(), (String[]) uniformNames));
	}

	public static void glGetActiveUniforms(int program, IntBuffer uniformIndices, int pname, IntBuffer params) {
		int[] arr = new int[uniformIndices.remaining()];
		uniformIndices.get(arr);
		params.put(ctx.getActiveUniforms((WebGLProgram) get(program).getObject(), arr, pname).<JSNumber> cast().intValue());
		
	}
	static native void nglGetActiveUniformsiv(int program, int uniformIndices_uniformCount, long uniformIndices, int pname, long params, long function_pointer);

	/**
	 * Overloads glGetActiveUniformsiv.
	 * <p>
	 * @deprecated Will be removed in 3.0. Use {@link #glGetActiveUniformsi} instead. 
	 */
	@Deprecated
	public static int glGetActiveUniforms(int program, int uniformIndex, int pname) {
		return GL31.glGetActiveUniformsi(program, uniformIndex, pname);
	}

	/** Overloads glGetActiveUniformsiv. */
	public static int glGetActiveUniformsi(int program, int uniformIndex, int pname) {
	
		
		return ctx.getActiveUniforms((WebGLProgram) get(program).getObject(), new int[] {uniformIndex}, pname).<JSNumber> cast().intValue();
	}

	public static void glGetActiveUniformName(int program, int uniformIndex, IntBuffer length, ByteBuffer uniformName) {
		WebGLActiveInfo wai = ctx.getActiveUniform((WebGLProgram) get(program).getObject(), uniformIndex);
		length.put(wai.getName().length());
		uniformName.asCharBuffer().put(wai.getName());
	}
	static native void nglGetActiveUniformName(int program, int uniformIndex, int uniformName_bufSize, long length, long uniformName, long function_pointer);

	/** Overloads glGetActiveUniformName. */
	public static String glGetActiveUniformName(int program, int uniformIndex, int bufSize) {
		WebGLActiveInfo wai = ctx.getActiveUniform((WebGLProgram) get(program).getObject(), uniformIndex);
		return wai.getName();
	}

	public static int glGetUniformBlockIndex(int program, ByteBuffer uniformBlockName) {
		return ctx.getUniformBlockIndex((WebGLProgram) get(program).getObject(), uniformBlockName.asCharBuffer().toString());
	}
	static native int nglGetUniformBlockIndex(int program, long uniformBlockName, long function_pointer);

	/** Overloads glGetUniformBlockIndex. */
	public static int glGetUniformBlockIndex(int program, CharSequence uniformBlockName) {
		return ctx.getUniformBlockIndex((WebGLProgram) get(program).getObject(), (String) uniformBlockName);
	}

	public static void glGetActiveUniformBlock(int program, int uniformBlockIndex, int pname, IntBuffer params) {
		params.put(((JSNumber) ctx.getActiveUniformBlockParameter((WebGLProgram) get(program).getObject(), uniformBlockIndex, pname)).intValue());
	}
	static native void nglGetActiveUniformBlockiv(int program, int uniformBlockIndex, int pname, long params, long function_pointer);

	/**
	 * Overloads glGetActiveUniformBlockiv.
	 * <p>
	 * @deprecated Will be removed in 3.0. Use {@link #glGetActiveUniformBlocki} instead. 
	 */
	@Deprecated
	public static int glGetActiveUniformBlock(int program, int uniformBlockIndex, int pname) {
		return GL31.glGetActiveUniformBlocki(program, uniformBlockIndex, pname);
	}

	/** Overloads glGetActiveUniformBlockiv. */
	public static int glGetActiveUniformBlocki(int program, int uniformBlockIndex, int pname) {
		return ((JSNumber) ctx.getActiveUniformBlockParameter((WebGLProgram) get(program).getObject(), uniformBlockIndex, pname)).intValue();
	}

	public static void glGetActiveUniformBlockName(int program, int uniformBlockIndex, IntBuffer length, ByteBuffer uniformBlockName) {
		uniformBlockName.asCharBuffer().put(ctx.getActiveUniformBlockName((WebGLProgram) get(program).getObject(), uniformBlockIndex));
	}
	static native void nglGetActiveUniformBlockName(int program, int uniformBlockIndex, int uniformBlockName_bufSize, long length, long uniformBlockName, long function_pointer);

	/** Overloads glGetActiveUniformBlockName. */
	public static String glGetActiveUniformBlockName(int program, int uniformBlockIndex, int bufSize) {
		return ctx.getActiveUniformBlockName((WebGLProgram) get(program).getObject(), uniformBlockIndex);
	}

	public static void glUniformBlockBinding(int program, int uniformBlockIndex, int uniformBlockBinding) {
		ctx.uniformBlockBinding((WebGLProgram) get(program).getObject(), uniformBlockIndex, uniformBlockBinding);
	}
	static native void nglUniformBlockBinding(int program, int uniformBlockIndex, int uniformBlockBinding, long function_pointer);
}
