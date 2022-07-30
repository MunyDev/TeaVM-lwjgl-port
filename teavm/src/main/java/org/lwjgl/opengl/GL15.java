/* MACHINE GENERATED FILE, DO NOT EDIT */

package org.lwjgl.opengl;

import org.lwjgl.util.GLUtil;
import org.munydev.teavm.lwjgl.CurrentContext;
import org.teavm.jso.core.JSNumber;
import org.teavm.jso.typedarrays.ArrayBuffer;
import org.teavm.jso.typedarrays.Float32Array;
import org.teavm.jso.typedarrays.Float64Array;
import org.teavm.jso.typedarrays.Int8Array;
import org.teavm.jso.typedarrays.Uint8Array;
import org.teavm.jso.webgl.WebGLBuffer;
import org.teavm.jso.webgl.WebGLRenderingContext;
import org.teavm.webgl2.WebGL2RenderingContext;
import org.teavm.webgl2.WebGLQuery;

import java.nio.*;
import static org.lwjgl.opengl.GLObjectBuffers.*;
public final class GL15 {
	private static WebGL2RenderingContext ctx = (WebGL2RenderingContext) CurrentContext.getContext();
	public static final int GL_ARRAY_BUFFER = 0x8892,
		GL_ELEMENT_ARRAY_BUFFER = 0x8893,
		GL_ARRAY_BUFFER_BINDING = 0x8894,
		GL_ELEMENT_ARRAY_BUFFER_BINDING = 0x8895,
		GL_VERTEX_ARRAY_BUFFER_BINDING = 0x8896,
		GL_NORMAL_ARRAY_BUFFER_BINDING = 0x8897,
		GL_COLOR_ARRAY_BUFFER_BINDING = 0x8898,
		GL_INDEX_ARRAY_BUFFER_BINDING = 0x8899,
		GL_TEXTURE_COORD_ARRAY_BUFFER_BINDING = 0x889A,
		GL_EDGE_FLAG_ARRAY_BUFFER_BINDING = 0x889B,
		GL_SECONDARY_COLOR_ARRAY_BUFFER_BINDING = 0x889C,
		GL_FOG_COORDINATE_ARRAY_BUFFER_BINDING = 0x889D,
		GL_WEIGHT_ARRAY_BUFFER_BINDING = 0x889E,
		GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING = 0x889F,
		GL_STREAM_DRAW = 0x88E0,
		GL_STREAM_READ = 0x88E1,
		GL_STREAM_COPY = 0x88E2,
		GL_STATIC_DRAW = 0x88E4,
		GL_STATIC_READ = 0x88E5,
		GL_STATIC_COPY = 0x88E6,
		GL_DYNAMIC_DRAW = 0x88E8,
		GL_DYNAMIC_READ = 0x88E9,
		GL_DYNAMIC_COPY = 0x88EA,
		GL_READ_ONLY = 0x88B8,
		GL_WRITE_ONLY = 0x88B9,
		GL_READ_WRITE = 0x88BA,
		GL_BUFFER_SIZE = 0x8764,
		GL_BUFFER_USAGE = 0x8765,
		GL_BUFFER_ACCESS = 0x88BB,
		GL_BUFFER_MAPPED = 0x88BC,
		GL_BUFFER_MAP_POINTER = 0x88BD,
		GL_FOG_COORD_SRC = 0x8450,
		GL_FOG_COORD = 0x8451,
		GL_CURRENT_FOG_COORD = 0x8453,
		GL_FOG_COORD_ARRAY_TYPE = 0x8454,
		GL_FOG_COORD_ARRAY_STRIDE = 0x8455,
		GL_FOG_COORD_ARRAY_POINTER = 0x8456,
		GL_FOG_COORD_ARRAY = 0x8457,
		GL_FOG_COORD_ARRAY_BUFFER_BINDING = 0x889D,
		GL_SRC0_RGB = 0x8580,
		GL_SRC1_RGB = 0x8581,
		GL_SRC2_RGB = 0x8582,
		GL_SRC0_ALPHA = 0x8588,
		GL_SRC1_ALPHA = 0x8589,
		GL_SRC2_ALPHA = 0x858A;

	/**
	 *  Accepted by the &lt;target&gt; parameter of BeginQuery, EndQuery,
	 *  and GetQueryiv:
	 */
	public static final int GL_SAMPLES_PASSED = 0x8914;

	/**
	 * Accepted by the &lt;pname&gt; parameter of GetQueryiv: 
	 */
	public static final int GL_QUERY_COUNTER_BITS = 0x8864,
		GL_CURRENT_QUERY = 0x8865;

	/**
	 *  Accepted by the &lt;pname&gt; parameter of GetQueryObjectiv and
	 *  GetQueryObjectuiv:
	 */
	public static final int GL_QUERY_RESULT = 0x8866,
		GL_QUERY_RESULT_AVAILABLE = 0x8867;

	private GL15() {}

	public static void glBindBuffer(int target, int buffer) {
		ctx.bindBuffer(ConstantMapper.cmBuffers.mapRealToWebGL(target), (WebGLBuffer) get(buffer).getObject());
	}
	static native void nglBindBuffer(int target, int buffer, long function_pointer);

	public static void glDeleteBuffers(IntBuffer buffers) {
		while (buffers.remaining() > 0) {
			
			glDeleteBuffers(buffers.get());
			
		}
	}
	static native void nglDeleteBuffers(int buffers_n, long buffers, long function_pointer);

	/** Overloads glDeleteBuffers. */
	public static void glDeleteBuffers(int buffer) {
		ctx.deleteBuffer((WebGLBuffer) get(buffer).getObject());
	}

	public static void glGenBuffers(IntBuffer buffers) {
		int len = buffers.limit();
		for (int i = 0; i < len; i++) {
			buffers.put(glGenBuffers());
		}
	}
	static native void nglGenBuffers(int buffers_n, long buffers, long function_pointer);

	/** Overloads glGenBuffers. */
	public static int glGenBuffers() {
		
		return newObject(GL_OBJECT_BUFFERS, ctx.createBuffer());
	}

	public static boolean glIsBuffer(int buffer) {
		return get(buffer).getType() == GL_OBJECT_BUFFERS;
	}
	static native boolean nglIsBuffer(int buffer, long function_pointer);

	public static void glBufferData(int target, long data_size, int usage) {
		ctx.bufferData(target, (int) data_size, usage);
	}
	public static void glBufferData(int target, ByteBuffer data, int usage) {
		
		
		ctx.bufferData(target, GLUtil.glCreateBufferFromJava(data), usage);
		
	}
	public static void glBufferData(int target, DoubleBuffer data, int usage) {
		ctx.bufferData(target, GLUtil.glCreateBufferFromJava(data), usage);
	}
	public static void glBufferData(int target, FloatBuffer data, int usage) {
		ctx.bufferData(target, GLUtil.glCreateBufferFromJava(data), usage);

	}
	public static void glBufferData(int target, IntBuffer data, int usage) {
		ctx.bufferData(target, GLUtil.glCreateBufferFromJava(data), usage);

	}
	public static void glBufferData(int target, ShortBuffer data, int usage) {
		ctx.bufferData(target, GLUtil.glCreateBufferFromJava(data), usage);
	}

	public static void glBufferSubData(int target, long offset, ByteBuffer data) {
		ctx.bufferSubData(target, (int) offset, GLUtil.glCreateBufferFromJava(data));

	}
	public static void glBufferSubData(int target, long offset, DoubleBuffer data) {
		ctx.bufferSubData(target, (int) offset, GLUtil.glCreateBufferFromJava(data));

	}
	public static void glBufferSubData(int target, long offset, FloatBuffer data) {
		ctx.bufferSubData(target, (int) offset, GLUtil.glCreateBufferFromJava(data));

	}
	public static void glBufferSubData(int target, long offset, IntBuffer data) {
		ctx.bufferSubData(target, (int) offset, GLUtil.glCreateBufferFromJava(data));

	}
	public static void glBufferSubData(int target, long offset, ShortBuffer data) {
		ctx.bufferSubData(target, (int) offset, GLUtil.glCreateBufferFromJava(data));

	}
	static native void nglBufferSubData(int target, long offset, long data_size, long data, long function_pointer);

	public static void glGetBufferSubData(int target, long offset, ByteBuffer data) {
		Int8Array ua = Int8Array.create(GLUtil.glNewBuffer(data));
		ctx.getBufferSubData(target, 0, ua , 0, ua.getByteLength());
		data.flip();
		GLUtil.glWriteArrayBufferToJavab(ua.getBuffer(), data);
	}
	public static void glGetBufferSubData(int target, long offset, DoubleBuffer data) {
		Float64Array arr = Float64Array.create(GLUtil.glNewBuffer(data));
		ctx.getBufferSubData(target, (int) offset, arr, 0, target);
		data.flip();
		GLUtil.glWriteArrayBufferToJava(arr.getBuffer(), data);
		data.flip();
		
		
	}
	public static void glGetBufferSubData(int target, long offset, FloatBuffer data) {

		Float32Array arr = Float32Array.create(GLUtil.glNewBuffer(data));
		ctx.getBufferSubData(target, (int) offset, arr, 0, target);
		data.flip();
		GLUtil.glWriteArrayBufferToJava(arr.getBuffer(), data);
		data.flip();



	}
	public static void glGetBufferSubData(int target, long offset, IntBuffer data) {


		Float64Array arr = Float64Array.create(GLUtil.glNewBuffer(data));
		ctx.getBufferSubData(target, (int) offset, arr, 0, target);
		data.flip();
		GLUtil.glWriteArrayBufferToJava(arr.getBuffer(), data);
		data.flip();


	}
	public static void glGetBufferSubData(int target, long offset, ShortBuffer data) {

		Float64Array arr = Float64Array.create(GLUtil.glNewBuffer(data));
		ctx.getBufferSubData(target, (int) offset, arr, 0, target);
		data.flip();
		GLUtil.glWriteArrayBufferToJava(arr.getBuffer(), data);
		data.flip();



	}
	static native void nglGetBufferSubData(int target, long offset, long data_size, long data, long function_pointer);

	/**
	 *  glMapBuffer maps a GL buffer object to a ByteBuffer. The old_buffer argument can be null,
	 *  in which case a new ByteBuffer will be created, pointing to the returned memory. If old_buffer is non-null,
	 *  it will be returned if it points to the same mapped memory and has the same capacity as the buffer object,
	 *  otherwise a new ByteBuffer is created. That way, an application will normally use glMapBuffer like this:
	 *  <p/>
	 *  ByteBuffer mapped_buffer; mapped_buffer = glMapBuffer(..., ..., null); ... // Another map on the same buffer mapped_buffer = glMapBuffer(..., ..., mapped_buffer);
	 *  <p/>
	 *  Only ByteBuffers returned from this method are to be passed as the old_buffer argument. User-created ByteBuffers cannot be reused.
	 *  <p/>
	 *  The version of this method without an explicit length argument calls glGetBufferParameter internally to
	 *  retrieve the current buffer object size, which may cause a pipeline flush and reduce application performance.
	 *  <p/>
	 *  The version of this method with an explicit length argument is a fast alternative to the one without. No GL call
	 *  is made to retrieve the buffer object size, so the user is responsible for tracking and using the appropriate length.<br>
	 *  Security warning: The length argument should match the buffer object size. Reading from or writing to outside
	 *  the memory region that corresponds to the mapped buffer object will cause native crashes.
	 * <p>
	 *  @param old_buffer A ByteBuffer. If this argument points to the same address and has the same capacity as the new mapping, it will be returned and no new buffer will be created.
	 * <p>
	 *  @return A ByteBuffer representing the mapped buffer memory.
	 */
	public static ByteBuffer glMapBuffer(int target, int access, ByteBuffer old_buffer) {

		return null;





	}
	/**
	 *  glMapBuffer maps a GL buffer object to a ByteBuffer. The old_buffer argument can be null,
	 *  in which case a new ByteBuffer will be created, pointing to the returned memory. If old_buffer is non-null,
	 *  it will be returned if it points to the same mapped memory and has the same capacity as the buffer object,
	 *  otherwise a new ByteBuffer is created. That way, an application will normally use glMapBuffer like this:
	 *  <p/>
	 *  ByteBuffer mapped_buffer; mapped_buffer = glMapBuffer(..., ..., null); ... // Another map on the same buffer mapped_buffer = glMapBuffer(..., ..., mapped_buffer);
	 *  <p/>
	 *  Only ByteBuffers returned from this method are to be passed as the old_buffer argument. User-created ByteBuffers cannot be reused.
	 *  <p/>
	 *  The version of this method without an explicit length argument calls glGetBufferParameter internally to
	 *  retrieve the current buffer object size, which may cause a pipeline flush and reduce application performance.
	 *  <p/>
	 *  The version of this method with an explicit length argument is a fast alternative to the one without. No GL call
	 *  is made to retrieve the buffer object size, so the user is responsible for tracking and using the appropriate length.<br>
	 *  Security warning: The length argument should match the buffer object size. Reading from or writing to outside
	 *  the memory region that corresponds to the mapped buffer object will cause native crashes.
	 * <p>
	 *  @param old_buffer A ByteBuffer. If this argument points to the same address and has the same capacity as the new mapping, it will be returned and no new buffer will be created.
	 * <p>
	 *  @return A ByteBuffer representing the mapped buffer memory.
	 */
	public static ByteBuffer glMapBuffer(int target, int access, long length, ByteBuffer old_buffer) {



		return null;



	}
	static native ByteBuffer nglMapBuffer(int target, int access, long result_size, ByteBuffer old_buffer, long function_pointer);

	public static boolean glUnmapBuffer(int target) {

		
		return false;


	}
	static native boolean nglUnmapBuffer(int target, long function_pointer);

	public static void glGetBufferParameter(int target, int pname, IntBuffer params) {
		int param = ((JSNumber) ctx.getBufferParameter(target, pname)).intValue();

		params.put(param);


	}
	static native void nglGetBufferParameteriv(int target, int pname, long params, long function_pointer);

	/**
	 * Overloads glGetBufferParameteriv.
	 * <p>
	 * @deprecated Will be removed in 3.0. Use {@link #glGetBufferParameteri} instead. 
	 */
	@Deprecated
	public static int glGetBufferParameter(int target, int pname) {
		return GL15.glGetBufferParameteri(target, pname);
	}

	/** Overloads glGetBufferParameteriv. */
	public static int glGetBufferParameteri(int target, int pname) {
		
		
		return ((JSNumber) ctx.getBufferParameter(target, pname)).intValue();
		
		
		
	}

	public static ByteBuffer glGetBufferPointer(int target, int pname) {
		int x = ((JSNumber) ctx.getBufferParameter(target, WebGLRenderingContext.BUFFER_SIZE)).intValue();
		ArrayBuffer buf = ArrayBuffer.create(x);
		Uint8Array ua = Uint8Array.create(buf);
		ctx.getBufferSubData(target, 0, ua, 0, pname);
		ByteBuffer result = ByteBuffer.allocate(x);
		result.flip();
		GLUtil.glWriteArrayBufferToJavau(ua.getBuffer(), result);
		result.flip();
		return result;
		
	}
	static native ByteBuffer nglGetBufferPointerv(int target, int pname, long result_size, long function_pointer);

	public static void glGenQueries(IntBuffer ids) {
		ids.put(newObject(GL_OBJECT_QUERIES, ctx.createQuery()));

		ids.flip();


	}
	static native void nglGenQueries(int ids_n, long ids, long function_pointer);

	/** Overloads glGenQueries. */
	public static int glGenQueries() {

		
		
		return newObject(GL_OBJECT_QUERIES, ctx.createQuery());
		


	}

	public static void glDeleteQueries(IntBuffer ids) {
		ctx.deleteQuery((WebGLQuery) get(ids.get()).getObject());



	}
	static native void nglDeleteQueries(int ids_n, long ids, long function_pointer);

	/** Overloads glDeleteQueries. */
	public static void glDeleteQueries(int id) {

		ctx.deleteQuery((WebGLQuery) get(id).getObject());
		
		


	}

	public static boolean glIsQuery(int id) {
		return true;




	}
	static native boolean nglIsQuery(int id, long function_pointer);

	public static void glBeginQuery(int target, int id) {

		ctx.beginQuery(target, (WebGLQuery) get(id).getObject());


	}
	static native void nglBeginQuery(int target, int id, long function_pointer);

	public static void glEndQuery(int target) {

		ctx.endQuery(target);


	}
	static native void nglEndQuery(int target, long function_pointer);

	public static void glGetQuery(int target, int pname, IntBuffer params) {


		params.put(find(ctx.getQuery(target, pname)));


	}
	static native void nglGetQueryiv(int target, int pname, long params, long function_pointer);

	/**
	 * Overloads glGetQueryiv.
	 * <p>
	 * @deprecated Will be removed in 3.0. Use {@link #glGetQueryi} instead. 
	 */
	@Deprecated
	public static int glGetQuery(int target, int pname) {
		return GL15.glGetQueryi(target, pname);
	}

	/** Overloads glGetQueryiv. */
	public static int glGetQueryi(int target, int pname) {
		

		return find(ctx.getQuery(target, pname));



	}

	public static void glGetQueryObject(int id, int pname, IntBuffer params) {

		params.put(((JSNumber) ctx.getQueryParameter((WebGLQuery) get(id).getObject(), pname)).intValue());



	}
	static native void nglGetQueryObjectiv(int id, int pname, long params, long function_pointer);

	/** Overloads glGetQueryObjectiv. */
	public static int glGetQueryObjecti(int id, int pname) {
		
		
		
		return ((JSNumber) ctx.getQueryParameter((WebGLQuery) get(id).getObject(), pname)).intValue();




	}

	public static void glGetQueryObjectu(int id, int pname, IntBuffer params) {
		params.put(((JSNumber) ctx.getQueryParameter((WebGLQuery) get(id).getObject(), pname)).intValue());




	}
	static native void nglGetQueryObjectuiv(int id, int pname, long params, long function_pointer);

	/** Overloads glGetQueryObjectuiv. */
	public static int glGetQueryObjectui(int id, int pname) {


		return ((JSNumber) ctx.getQueryParameter((WebGLQuery) get(id).getObject(), pname)).intValue();



	}
}