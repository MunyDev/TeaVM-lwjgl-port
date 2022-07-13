/* MACHINE GENERATED FILE, DO NOT EDIT */

package org.lwjgl.opengl;

import org.lwjgl.util.GLUtil;
import org.munydev.teavm.lwjgl.CurrentContext;
import org.teavm.jso.webgl.*;

import java.nio.*;

/**
 *  <p/>
 *  The core OpenGL1.3 API.
 * <p>
 *  @author cix_foo <cix_foo@users.sourceforge.net>
 *  @version $Revision$
 *  $Id$
 */
public final class GL13 {
	
	public static final int GL_TEXTURE0 = 0x84C0,
		GL_TEXTURE1 = 0x84C1,
		GL_TEXTURE2 = 0x84C2,
		GL_TEXTURE3 = 0x84C3,
		GL_TEXTURE4 = 0x84C4,
		GL_TEXTURE5 = 0x84C5,
		GL_TEXTURE6 = 0x84C6,
		GL_TEXTURE7 = 0x84C7,
		GL_TEXTURE8 = 0x84C8,
		GL_TEXTURE9 = 0x84C9,
		GL_TEXTURE10 = 0x84CA,
		GL_TEXTURE11 = 0x84CB,
		GL_TEXTURE12 = 0x84CC,
		GL_TEXTURE13 = 0x84CD,
		GL_TEXTURE14 = 0x84CE,
		GL_TEXTURE15 = 0x84CF,
		GL_TEXTURE16 = 0x84D0,
		GL_TEXTURE17 = 0x84D1,
		GL_TEXTURE18 = 0x84D2,
		GL_TEXTURE19 = 0x84D3,
		GL_TEXTURE20 = 0x84D4,
		GL_TEXTURE21 = 0x84D5,
		GL_TEXTURE22 = 0x84D6,
		GL_TEXTURE23 = 0x84D7,
		GL_TEXTURE24 = 0x84D8,
		GL_TEXTURE25 = 0x84D9,
		GL_TEXTURE26 = 0x84DA,
		GL_TEXTURE27 = 0x84DB,
		GL_TEXTURE28 = 0x84DC,
		GL_TEXTURE29 = 0x84DD,
		GL_TEXTURE30 = 0x84DE,
		GL_TEXTURE31 = 0x84DF,
		GL_ACTIVE_TEXTURE = 0x84E0,
		GL_CLIENT_ACTIVE_TEXTURE = 0x84E1,
		GL_MAX_TEXTURE_UNITS = 0x84E2,
		GL_NORMAL_MAP = 0x8511,
		GL_REFLECTION_MAP = 0x8512,
		GL_TEXTURE_CUBE_MAP = 0x8513,
		GL_TEXTURE_BINDING_CUBE_MAP = 0x8514,
		GL_TEXTURE_CUBE_MAP_POSITIVE_X = 0x8515,
		GL_TEXTURE_CUBE_MAP_NEGATIVE_X = 0x8516,
		GL_TEXTURE_CUBE_MAP_POSITIVE_Y = 0x8517,
		GL_TEXTURE_CUBE_MAP_NEGATIVE_Y = 0x8518,
		GL_TEXTURE_CUBE_MAP_POSITIVE_Z = 0x8519,
		GL_TEXTURE_CUBE_MAP_NEGATIVE_Z = 0x851A,
		GL_PROXY_TEXTURE_CUBE_MAP = 0x851B,
		GL_MAX_CUBE_MAP_TEXTURE_SIZE = 0x851C,
		GL_COMPRESSED_ALPHA = 0x84E9,
		GL_COMPRESSED_LUMINANCE = 0x84EA,
		GL_COMPRESSED_LUMINANCE_ALPHA = 0x84EB,
		GL_COMPRESSED_INTENSITY = 0x84EC,
		GL_COMPRESSED_RGB = 0x84ED,
		GL_COMPRESSED_RGBA = 0x84EE,
		GL_TEXTURE_COMPRESSION_HINT = 0x84EF,
		GL_TEXTURE_COMPRESSED_IMAGE_SIZE = 0x86A0,
		GL_TEXTURE_COMPRESSED = 0x86A1,
		GL_NUM_COMPRESSED_TEXTURE_FORMATS = 0x86A2,
		GL_COMPRESSED_TEXTURE_FORMATS = 0x86A3,
		GL_MULTISAMPLE = 0x809D,
		GL_SAMPLE_ALPHA_TO_COVERAGE = 0x809E,
		GL_SAMPLE_ALPHA_TO_ONE = 0x809F,
		GL_SAMPLE_COVERAGE = 0x80A0,
		GL_SAMPLE_BUFFERS = 0x80A8,
		GL_SAMPLES = 0x80A9,
		GL_SAMPLE_COVERAGE_VALUE = 0x80AA,
		GL_SAMPLE_COVERAGE_INVERT = 0x80AB,
		GL_MULTISAMPLE_BIT = 0x20000000,
		GL_TRANSPOSE_MODELVIEW_MATRIX = 0x84E3,
		GL_TRANSPOSE_PROJECTION_MATRIX = 0x84E4,
		GL_TRANSPOSE_TEXTURE_MATRIX = 0x84E5,
		GL_TRANSPOSE_COLOR_MATRIX = 0x84E6,
		GL_COMBINE = 0x8570,
		GL_COMBINE_RGB = 0x8571,
		GL_COMBINE_ALPHA = 0x8572,
		GL_SOURCE0_RGB = 0x8580,
		GL_SOURCE1_RGB = 0x8581,
		GL_SOURCE2_RGB = 0x8582,
		GL_SOURCE0_ALPHA = 0x8588,
		GL_SOURCE1_ALPHA = 0x8589,
		GL_SOURCE2_ALPHA = 0x858A,
		GL_OPERAND0_RGB = 0x8590,
		GL_OPERAND1_RGB = 0x8591,
		GL_OPERAND2_RGB = 0x8592,
		GL_OPERAND0_ALPHA = 0x8598,
		GL_OPERAND1_ALPHA = 0x8599,
		GL_OPERAND2_ALPHA = 0x859A,
		GL_RGB_SCALE = 0x8573,
		GL_ADD_SIGNED = 0x8574,
		GL_INTERPOLATE = 0x8575,
		GL_SUBTRACT = 0x84E7,
		GL_CONSTANT = 0x8576,
		GL_PRIMARY_COLOR = 0x8577,
		GL_PREVIOUS = 0x8578,
		GL_DOT3_RGB = 0x86AE,
		GL_DOT3_RGBA = 0x86AF,
		GL_CLAMP_TO_BORDER = 0x812D;
	private static WebGLRenderingContext ctx = (WebGLRenderingContext) CurrentContext.getContext();
	private GL13() {}

	public static void glActiveTexture(int texture) {
		ctx.activeTexture(ConstantMapper.cmTexture.mapRealToWebGL(texture));
	}
	static native void nglActiveTexture(int texture, long function_pointer);

	public static void glClientActiveTexture(int texture) {
		System.out.println("Client textures are not supported");
	}
	static native void nglClientActiveTexture(int texture, long function_pointer);

	public static void glCompressedTexImage1D(int target, int level, int internalformat, int width, int border, ByteBuffer data) {
		System.out.println("1D textures are not supported");
	}
	static native void nglCompressedTexImage1D(int target, int level, int internalformat, int width, int border, int data_imageSize, long data, long function_pointer);
	public static void glCompressedTexImage1D(int target, int level, int internalformat, int width, int border, int data_imageSize, long data_buffer_offset) {
		System.out.println("1D textures are not supported");
	}
	static native void nglCompressedTexImage1DBO(int target, int level, int internalformat, int width, int border, int data_imageSize, long data_buffer_offset, long function_pointer);

	/** Overloads glCompressedTexImage1D. */
	public static void glCompressedTexImage1D(int target, int level, int internalformat, int width, int border, int imageSize) {
		System.out.println("1D Textures are not supported");
	}

	public static void glCompressedTexImage2D(int target, int level, int internalformat, int width, int height, int border, ByteBuffer data) {
		
		ctx.compressedTexImage2D(ConstantMapper.cmTexture.mapRealToWebGL(target), level, ConstantMapper.cmTexture.mapRealToWebGL(internalformat), width, height, border, GLUtil.glCreateBufferFromJava(data));
		
	}
	static native void nglCompressedTexImage2D(int target, int level, int internalformat, int width, int height, int border, int data_imageSize, long data, long function_pointer);
	public static void glCompressedTexImage2D(int target, int level, int internalformat, int width, int height, int border, int data_imageSize, long data_buffer_offset) {
//		ctx.compressedTexImage2D(ConstantMapper.cmTexture.mapRealToWebGL(target), ConstantMapper.cmTexture.mapRealToWebGL(level), ConstantMapper.cmTexture.mapRealToWebGL(internalformat), width, height, border, null);
		System.out.println("Unsupported");
	}
	static native void nglCompressedTexImage2DBO(int target, int level, int internalformat, int width, int height, int border, int data_imageSize, long data_buffer_offset, long function_pointer);

	/** Overloads glCompressedTexImage2D. */
	public static void glCompressedTexImage2D(int target, int level, int internalformat, int width, int height, int border, int imageSize) {
//		ctx.compressedTexImage2D(ConstantMapper.cmTexture.mapRealToWebGL(target), ConstantMapper.cmTexture.mapRealToWebGL(level), ConstantMapper.cmTexture.mapRealToWebGL(internalformat), width, height, border, GLUtil.glCreateBufferFromJava(data));
	}

	public static void glCompressedTexImage3D(int target, int level, int internalformat, int width, int height, int depth, int border, ByteBuffer data) {
		ctx.compressedTexImage2D(ConstantMapper.cmTexture.mapRealToWebGL(target), ConstantMapper.cmTexture.mapRealToWebGL(level), ConstantMapper.cmTexture.mapRealToWebGL(internalformat), width, height, border, GLUtil.glCreateBufferFromJava(data));
	}
	static native void nglCompressedTexImage3D(int target, int level, int internalformat, int width, int height, int depth, int border, int data_imageSize, long data, long function_pointer);
	public static void glCompressedTexImage3D(int target, int level, int internalformat, int width, int height, int depth, int border, int data_imageSize, long data_buffer_offset) {
		
	}
	static native void nglCompressedTexImage3DBO(int target, int level, int internalformat, int width, int height, int depth, int border, int data_imageSize, long data_buffer_offset, long function_pointer);

	/** Overloads glCompressedTexImage3D. */
	public static void glCompressedTexImage3D(int target, int level, int internalformat, int width, int height, int depth, int border, int imageSize) {
		System.out.println("3D Unsupported");
	}

	public static void glCompressedTexSubImage1D(int target, int level, int xoffset, int width, int format, ByteBuffer data) {
//		ctx.compressedTexImage2D(ConstantMapper.cmTexture.mapRealToWebGL(target), ConstantMapper.cmTexture.mapRealToWebGL(level), ConstantMapper.cmTexture.mapRealToWebGL(internalformat), width, height, border, GLUtil.glCreateBufferFromJava(data));
	}
	static native void nglCompressedTexSubImage1D(int target, int level, int xoffset, int width, int format, int data_imageSize, long data, long function_pointer);
	public static void glCompressedTexSubImage1D(int target, int level, int xoffset, int width, int format, int data_imageSize, long data_buffer_offset) {
		System.out.println("1D Unsupported");
	}
	static native void nglCompressedTexSubImage1DBO(int target, int level, int xoffset, int width, int format, int data_imageSize, long data_buffer_offset, long function_pointer);

	public static void glCompressedTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, ByteBuffer data) {
		ctx.compressedTexSubImage2D(ConstantMapper.cmTexture.mapRealToWebGL(target), level, xoffset, yoffset, width, height, ConstantMapper.cmTexture.mapRealToWebGL(level), GLUtil.glCreateBufferFromJava(data));
	}
	static native void nglCompressedTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int data_imageSize, long data, long function_pointer);
	public static void glCompressedTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int data_imageSize, long data_buffer_offset) {
//		ctx.compressedTexSubImage2D(ConstantMapper.cmTexture.mapRealToWebGL(target), level, ConstantMapper.cmTexture.mapRealToWebGL(internalformat), width, height, border, GLUtil.glCreateBufferFromJava(data));
	}
	static native void nglCompressedTexSubImage2DBO(int target, int level, int xoffset, int yoffset, int width, int height, int format, int data_imageSize, long data_buffer_offset, long function_pointer);

	public static void glCompressedTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, ByteBuffer data) {
		System.out.println("3d unsupported");
	}
	static native void nglCompressedTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int data_imageSize, long data, long function_pointer);
	public static void glCompressedTexSubImage3D(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int data_imageSize, long data_buffer_offset) {
		
	}
	static native void nglCompressedTexSubImage3DBO(int target, int level, int xoffset, int yoffset, int zoffset, int width, int height, int depth, int format, int data_imageSize, long data_buffer_offset, long function_pointer);

	public static void glGetCompressedTexImage(int target, int lod, ByteBuffer img) {
		
	}
	public static void glGetCompressedTexImage(int target, int lod, IntBuffer img) {
		
	}
	public static void glGetCompressedTexImage(int target, int lod, ShortBuffer img) {
		
	}
	static native void nglGetCompressedTexImage(int target, int lod, long img, long function_pointer);
	public static void glGetCompressedTexImage(int target, int lod, long img_buffer_offset) {

	}
	static native void nglGetCompressedTexImageBO(int target, int lod, long img_buffer_offset, long function_pointer);

	public static void glMultiTexCoord1f(int target, float s) {
		
	}
	static native void nglMultiTexCoord1f(int target, float s, long function_pointer);

	public static void glMultiTexCoord1d(int target, double s) {
		
	}
	static native void nglMultiTexCoord1d(int target, double s, long function_pointer);

	public static void glMultiTexCoord2f(int target, float s, float t) {
	
	}
	static native void nglMultiTexCoord2f(int target, float s, float t, long function_pointer);

	public static void glMultiTexCoord2d(int target, double s, double t) {
		
	}
	static native void nglMultiTexCoord2d(int target, double s, double t, long function_pointer);

	public static void glMultiTexCoord3f(int target, float s, float t, float r) {
		
	}
	static native void nglMultiTexCoord3f(int target, float s, float t, float r, long function_pointer);

	public static void glMultiTexCoord3d(int target, double s, double t, double r) {
		
	}
	static native void nglMultiTexCoord3d(int target, double s, double t, double r, long function_pointer);

	public static void glMultiTexCoord4f(int target, float s, float t, float r, float q) {
		
	}
	static native void nglMultiTexCoord4f(int target, float s, float t, float r, float q, long function_pointer);

	public static void glMultiTexCoord4d(int target, double s, double t, double r, double q) {
		
	}
	static native void nglMultiTexCoord4d(int target, double s, double t, double r, double q, long function_pointer);

	public static void glLoadTransposeMatrix(FloatBuffer m) {
		
	}
	static native void nglLoadTransposeMatrixf(long m, long function_pointer);

	public static void glLoadTransposeMatrix(DoubleBuffer m) {
		
	}
	static native void nglLoadTransposeMatrixd(long m, long function_pointer);

	public static void glMultTransposeMatrix(FloatBuffer m) {
		
	}
	static native void nglMultTransposeMatrixf(long m, long function_pointer);

	public static void glMultTransposeMatrix(DoubleBuffer m) {
		
	}
	static native void nglMultTransposeMatrixd(long m, long function_pointer);

	public static void glSampleCoverage(float value, boolean invert) {
		
	}
	static native void nglSampleCoverage(float value, boolean invert, long function_pointer);
}
