/* MACHINE GENERATED FILE, DO NOT EDIT */

package org.lwjgl.opengl;

//import org.lwjgl.*;
import org.munydev.teavm.lwjgl.CurrentContext;
import org.teavm.webgl2.WebGL2RenderingContext;

import java.nio.*;

/**
 *  <p/>
 *  The core OpenGL1.4 API.
 * <p>
 *  @author cix_foo <cix_foo@users.sourceforge.net>
 *  @version $Revision$
 *  $Id$
 */
public final class GL14 {

	public static final int GL_GENERATE_MIPMAP = 0x8191,
		GL_GENERATE_MIPMAP_HINT = 0x8192,
		GL_DEPTH_COMPONENT16 = 0x81A5,
		GL_DEPTH_COMPONENT24 = 0x81A6,
		GL_DEPTH_COMPONENT32 = 0x81A7,
		GL_TEXTURE_DEPTH_SIZE = 0x884A,
		GL_DEPTH_TEXTURE_MODE = 0x884B,
		GL_TEXTURE_COMPARE_MODE = 0x884C,
		GL_TEXTURE_COMPARE_FUNC = 0x884D,
		GL_COMPARE_R_TO_TEXTURE = 0x884E,
		GL_FOG_COORDINATE_SOURCE = 0x8450,
		GL_FOG_COORDINATE = 0x8451,
		GL_FRAGMENT_DEPTH = 0x8452,
		GL_CURRENT_FOG_COORDINATE = 0x8453,
		GL_FOG_COORDINATE_ARRAY_TYPE = 0x8454,
		GL_FOG_COORDINATE_ARRAY_STRIDE = 0x8455,
		GL_FOG_COORDINATE_ARRAY_POINTER = 0x8456,
		GL_FOG_COORDINATE_ARRAY = 0x8457,
		GL_POINT_SIZE_MIN = 0x8126,
		GL_POINT_SIZE_MAX = 0x8127,
		GL_POINT_FADE_THRESHOLD_SIZE = 0x8128,
		GL_POINT_DISTANCE_ATTENUATION = 0x8129,
		GL_COLOR_SUM = 0x8458,
		GL_CURRENT_SECONDARY_COLOR = 0x8459,
		GL_SECONDARY_COLOR_ARRAY_SIZE = 0x845A,
		GL_SECONDARY_COLOR_ARRAY_TYPE = 0x845B,
		GL_SECONDARY_COLOR_ARRAY_STRIDE = 0x845C,
		GL_SECONDARY_COLOR_ARRAY_POINTER = 0x845D,
		GL_SECONDARY_COLOR_ARRAY = 0x845E,
		GL_BLEND_DST_RGB = 0x80C8,
		GL_BLEND_SRC_RGB = 0x80C9,
		GL_BLEND_DST_ALPHA = 0x80CA,
		GL_BLEND_SRC_ALPHA = 0x80CB,
		GL_INCR_WRAP = 0x8507,
		GL_DECR_WRAP = 0x8508,
		GL_TEXTURE_FILTER_CONTROL = 0x8500,
		GL_TEXTURE_LOD_BIAS = 0x8501,
		GL_MAX_TEXTURE_LOD_BIAS = 0x84FD,
		GL_MIRRORED_REPEAT = 0x8370,
		GL_BLEND_COLOR = 0x8005,
		GL_BLEND_EQUATION = 0x8009,
		GL_FUNC_ADD = 0x8006,
		GL_FUNC_SUBTRACT = 0x800A,
		GL_FUNC_REVERSE_SUBTRACT = 0x800B,
		GL_MIN = 0x8007,
		GL_MAX = 0x8008;
	private static WebGL2RenderingContext ctx = (WebGL2RenderingContext) CurrentContext.getContext();
	private GL14() {}

	public static void glBlendEquation(int mode) {
		ctx.blendEquation(mode);
	}
	static native void nglBlendEquation(int mode, long function_pointer);

	public static void glBlendColor(float red, float green, float blue, float alpha) {
		ctx.blendColor(red, green, blue, alpha);
	}
	static native void nglBlendColor(float red, float green, float blue, float alpha, long function_pointer);

	public static void glFogCoordf(float coord) {
		
	}
	static native void nglFogCoordf(float coord, long function_pointer);

	public static void glFogCoordd(double coord) {
	
	}
	static native void nglFogCoordd(double coord, long function_pointer);

	public static void glFogCoordPointer(int stride, DoubleBuffer data) {

	}
	public static void glFogCoordPointer(int stride, FloatBuffer data) {

	}
	static native void nglFogCoordPointer(int type, int stride, long data, long function_pointer);
	public static void glFogCoordPointer(int type, int stride, long data_buffer_offset) {

	}
	static native void nglFogCoordPointerBO(int type, int stride, long data_buffer_offset, long function_pointer);

	public static void glMultiDrawArrays(int mode, IntBuffer piFirst, IntBuffer piCount) {
		
	}
	static native void nglMultiDrawArrays(int mode, long piFirst, long piCount, int piFirst_primcount, long function_pointer);

	public static void glPointParameteri(int pname, int param) {

	}
	static native void nglPointParameteri(int pname, int param, long function_pointer);

	public static void glPointParameterf(int pname, float param) {

	}
	static native void nglPointParameterf(int pname, float param, long function_pointer);

	public static void glPointParameter(int pname, IntBuffer params) {

	}
	static native void nglPointParameteriv(int pname, long params, long function_pointer);

	public static void glPointParameter(int pname, FloatBuffer params) {

	}
	static native void nglPointParameterfv(int pname, long params, long function_pointer);

	public static void glSecondaryColor3b(byte red, byte green, byte blue) {

	}
	static native void nglSecondaryColor3b(byte red, byte green, byte blue, long function_pointer);

	public static void glSecondaryColor3f(float red, float green, float blue) {
		
	}
	static native void nglSecondaryColor3f(float red, float green, float blue, long function_pointer);

	public static void glSecondaryColor3d(double red, double green, double blue) {

	}
	static native void nglSecondaryColor3d(double red, double green, double blue, long function_pointer);

	public static void glSecondaryColor3ub(byte red, byte green, byte blue) {

	}
	static native void nglSecondaryColor3ub(byte red, byte green, byte blue, long function_pointer);

	public static void glSecondaryColorPointer(int size, int stride, DoubleBuffer data) {

	}
	public static void glSecondaryColorPointer(int size, int stride, FloatBuffer data) {

	}
	public static void glSecondaryColorPointer(int size, boolean unsigned, int stride, ByteBuffer data) {
		
	}
	static native void nglSecondaryColorPointer(int size, int type, int stride, long data, long function_pointer);
	public static void glSecondaryColorPointer(int size, int type, int stride, long data_buffer_offset) {
		
	}
	static native void nglSecondaryColorPointerBO(int size, int type, int stride, long data_buffer_offset, long function_pointer);

	public static void glBlendFuncSeparate(int sfactorRGB, int dfactorRGB, int sfactorAlpha, int dfactorAlpha) {
		
	}
	static native void nglBlendFuncSeparate(int sfactorRGB, int dfactorRGB, int sfactorAlpha, int dfactorAlpha, long function_pointer);

	public static void glWindowPos2f(float x, float y) {
		
	}
	static native void nglWindowPos2f(float x, float y, long function_pointer);

	public static void glWindowPos2d(double x, double y) {

	}
	static native void nglWindowPos2d(double x, double y, long function_pointer);

	public static void glWindowPos2i(int x, int y) {

	}
	static native void nglWindowPos2i(int x, int y, long function_pointer);

	public static void glWindowPos3f(float x, float y, float z) {
		
	}
	static native void nglWindowPos3f(float x, float y, float z, long function_pointer);

	public static void glWindowPos3d(double x, double y, double z) {

	}
	static native void nglWindowPos3d(double x, double y, double z, long function_pointer);

	public static void glWindowPos3i(int x, int y, int z) {
		
	}
	static native void nglWindowPos3i(int x, int y, int z, long function_pointer);
}
