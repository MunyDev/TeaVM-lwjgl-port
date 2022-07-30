/* MACHINE GENERATED FILE, DO NOT EDIT */

package org.lwjgl.opengl;

import java.nio.*;

import org.lwjgl.util.GLUtil;
import org.munydev.teavm.lwjgl.CurrentContext;
import org.teavm.jso.core.JSNumber;
import org.teavm.jso.typedarrays.*;
import org.teavm.jso.webgl.WebGLActiveInfo;
import org.teavm.jso.webgl.WebGLBuffer;
import org.teavm.jso.webgl.WebGLFramebuffer;
import org.teavm.jso.webgl.WebGLProgram;
import org.teavm.jso.webgl.WebGLRenderbuffer;
import org.teavm.jso.webgl.WebGLTexture;
import org.teavm.jso.webgl.WebGLUniformLocation;
import org.teavm.webgl2.*;


import static org.lwjgl.opengl.GLObjectBuffers.*;
//import org.lwjgl.*;
//import java.nio.*;

public final class GL30 {

	public static final int GL_MAJOR_VERSION = 0x821B,
		GL_MINOR_VERSION = 0x821C,
		GL_NUM_EXTENSIONS = 0x821D,
		GL_CONTEXT_FLAGS = 0x821E,
		GL_CONTEXT_FLAG_FORWARD_COMPATIBLE_BIT = 0x1,
		GL_DEPTH_BUFFER = 0x8223,
		GL_STENCIL_BUFFER = 0x8224,
		GL_COMPRESSED_RED = 0x8225,
		GL_COMPRESSED_RG = 0x8226,
		GL_COMPARE_REF_TO_TEXTURE = 0x884E,
		GL_CLIP_DISTANCE0 = 0x3000,
		GL_CLIP_DISTANCE1 = 0x3001,
		GL_CLIP_DISTANCE2 = 0x3002,
		GL_CLIP_DISTANCE3 = 0x3003,
		GL_CLIP_DISTANCE4 = 0x3004,
		GL_CLIP_DISTANCE5 = 0x3005,
		GL_CLIP_DISTANCE6 = 0x3006,
		GL_CLIP_DISTANCE7 = 0x3007,
		GL_MAX_CLIP_DISTANCES = 0xD32,
		GL_MAX_VARYING_COMPONENTS = 0x8B4B,
		GL_BUFFER_ACCESS_FLAGS = 0x911F,
		GL_BUFFER_MAP_LENGTH = 0x9120,
		GL_BUFFER_MAP_OFFSET = 0x9121;

	/**
	 *  Accepted by the &lt;pname&gt; parameters of GetVertexAttribdv,
	 *  GetVertexAttribfv, GetVertexAttribiv, GetVertexAttribIiv, and
	 *  GetVertexAttribIuiv:
	 */
	public static final int GL_VERTEX_ATTRIB_ARRAY_INTEGER = 0x88FD;

	/**
	 * Returned by the &lt;type&gt; parameter of GetActiveUniform: 
	 */
	public static final int GL_SAMPLER_BUFFER = 0x8DC2,
		GL_SAMPLER_CUBE_SHADOW = 0x8DC5,
		GL_UNSIGNED_INT_VEC2 = 0x8DC6,
		GL_UNSIGNED_INT_VEC3 = 0x8DC7,
		GL_UNSIGNED_INT_VEC4 = 0x8DC8,
		GL_INT_SAMPLER_1D = 0x8DC9,
		GL_INT_SAMPLER_2D = 0x8DCA,
		GL_INT_SAMPLER_3D = 0x8DCB,
		GL_INT_SAMPLER_CUBE = 0x8DCC,
		GL_INT_SAMPLER_2D_RECT = 0x8DCD,
		GL_INT_SAMPLER_1D_ARRAY = 0x8DCE,
		GL_INT_SAMPLER_2D_ARRAY = 0x8DCF,
		GL_INT_SAMPLER_BUFFER = 0x8DD0,
		GL_UNSIGNED_INT_SAMPLER_1D = 0x8DD1,
		GL_UNSIGNED_INT_SAMPLER_2D = 0x8DD2,
		GL_UNSIGNED_INT_SAMPLER_3D = 0x8DD3,
		GL_UNSIGNED_INT_SAMPLER_CUBE = 0x8DD4,
		GL_UNSIGNED_INT_SAMPLER_2D_RECT = 0x8DD5,
		GL_UNSIGNED_INT_SAMPLER_1D_ARRAY = 0x8DD6,
		GL_UNSIGNED_INT_SAMPLER_2D_ARRAY = 0x8DD7,
		GL_UNSIGNED_INT_SAMPLER_BUFFER = 0x8DD8;

	/**
	 *  Accepted by the &lt;pname&gt; parameter of GetBooleanv, GetIntegerv, GetFloatv,
	 *  and GetDoublev:
	 */
	public static final int GL_MIN_PROGRAM_TEXEL_OFFSET = 0x8904,
		GL_MAX_PROGRAM_TEXEL_OFFSET = 0x8905;

	/**
	 * Accepted by the &lt;mode&gt; parameter of BeginConditionalRender: 
	 */
	public static final int GL_QUERY_WAIT = 0x8E13,
		GL_QUERY_NO_WAIT = 0x8E14,
		GL_QUERY_BY_REGION_WAIT = 0x8E15,
		GL_QUERY_BY_REGION_NO_WAIT = 0x8E16;

	/**
	 * Accepted by the &lt;access&gt; parameter of MapBufferRange: 
	 */
	public static final int GL_MAP_READ_BIT = 0x1,
		GL_MAP_WRITE_BIT = 0x2,
		GL_MAP_INVALIDATE_RANGE_BIT = 0x4,
		GL_MAP_INVALIDATE_BUFFER_BIT = 0x8,
		GL_MAP_FLUSH_EXPLICIT_BIT = 0x10,
		GL_MAP_UNSYNCHRONIZED_BIT = 0x20;

	/**
	 *  Accepted by the &lt;target&gt; parameter of ClampColor and the &lt;pname&gt;
	 *  parameter of GetBooleanv, GetIntegerv, GetFloatv, and GetDoublev.
	 */
	public static final int GL_CLAMP_VERTEX_COLOR = 0x891A,
		GL_CLAMP_FRAGMENT_COLOR = 0x891B,
		GL_CLAMP_READ_COLOR = 0x891C;

	/**
	 * Accepted by the &lt;clamp&gt; parameter of ClampColor. 
	 */
	public static final int GL_FIXED_ONLY = 0x891D;

	/**
	 *  Accepted by the &lt;internalformat&gt; parameter of TexImage1D, TexImage2D,
	 *  TexImage3D, CopyTexImage1D, CopyTexImage2D, and RenderbufferStorageEXT,
	 *  and returned in the &lt;data&gt; parameter of GetTexLevelParameter and
	 *  GetRenderbufferParameterivEXT:
	 */
	public static final int GL_DEPTH_COMPONENT32F = 0x8CAC,
		GL_DEPTH32F_STENCIL8 = 0x8CAD;

	/**
	 *  Accepted by the &lt;type&gt; parameter of DrawPixels, ReadPixels, TexImage1D,
	 *  TexImage2D, TexImage3D, TexSubImage1D, TexSubImage2D, TexSubImage3D, and
	 *  GetTexImage:
	 */
	public static final int GL_FLOAT_32_UNSIGNED_INT_24_8_REV = 0x8DAD;

	/**
	 * Accepted by the &lt;value&gt; parameter of GetTexLevelParameter: 
	 */
	public static final int GL_TEXTURE_RED_TYPE = 0x8C10,
		GL_TEXTURE_GREEN_TYPE = 0x8C11,
		GL_TEXTURE_BLUE_TYPE = 0x8C12,
		GL_TEXTURE_ALPHA_TYPE = 0x8C13,
		GL_TEXTURE_LUMINANCE_TYPE = 0x8C14,
		GL_TEXTURE_INTENSITY_TYPE = 0x8C15,
		GL_TEXTURE_DEPTH_TYPE = 0x8C16;

	/**
	 * Returned by the &lt;params&gt; parameter of GetTexLevelParameter: 
	 */
	public static final int GL_UNSIGNED_NORMALIZED = 0x8C17;

	/**
	 *  Accepted by the &lt;internalFormat&gt; parameter of TexImage1D,
	 *  TexImage2D, and TexImage3D:
	 */
	public static final int GL_RGBA32F = 0x8814,
		GL_RGB32F = 0x8815,
		GL_ALPHA32F = 0x8816,
		GL_RGBA16F = 0x881A,
		GL_RGB16F = 0x881B,
		GL_ALPHA16F = 0x881C;

	/**
	 *  Accepted by the &lt;internalformat&gt; parameter of TexImage1D,
	 *  TexImage2D, TexImage3D, CopyTexImage1D, CopyTexImage2D, and
	 *  RenderbufferStorage:
	 */
	public static final int GL_R11F_G11F_B10F = 0x8C3A;

	/**
	 *  Accepted by the &lt;type&gt; parameter of DrawPixels, ReadPixels,
	 *  TexImage1D, TexImage2D, GetTexImage, TexImage3D, TexSubImage1D,
	 *  TexSubImage2D, TexSubImage3D, GetHistogram, GetMinmax,
	 *  ConvolutionFilter1D, ConvolutionFilter2D, ConvolutionFilter3D,
	 *  GetConvolutionFilter, SeparableFilter2D, GetSeparableFilter,
	 *  ColorTable, ColorSubTable, and GetColorTable:
	 */
	public static final int GL_UNSIGNED_INT_10F_11F_11F_REV = 0x8C3B;

	/**
	 *  Accepted by the &lt;internalformat&gt; parameter of TexImage1D,
	 *  TexImage2D, TexImage3D, CopyTexImage1D, CopyTexImage2D, and
	 *  RenderbufferStorage:
	 */
	public static final int GL_RGB9_E5 = 0x8C3D;

	/**
	 *  Accepted by the &lt;type&gt; parameter of DrawPixels, ReadPixels,
	 *  TexImage1D, TexImage2D, GetTexImage, TexImage3D, TexSubImage1D,
	 *  TexSubImage2D, TexSubImage3D, GetHistogram, GetMinmax,
	 *  ConvolutionFilter1D, ConvolutionFilter2D, ConvolutionFilter3D,
	 *  GetConvolutionFilter, SeparableFilter2D, GetSeparableFilter,
	 *  ColorTable, ColorSubTable, and GetColorTable:
	 */
	public static final int GL_UNSIGNED_INT_5_9_9_9_REV = 0x8C3E;

	/**
	 *  Accepted by the &lt;pname&gt; parameter of GetTexLevelParameterfv and
	 *  GetTexLevelParameteriv:
	 */
	public static final int GL_TEXTURE_SHARED_SIZE = 0x8C3F;

	/**
	 *  Accepted by the &lt;target&gt; parameter of BindFramebuffer,
	 *  CheckFramebufferStatus, FramebufferTexture{1D|2D|3D},
	 *  FramebufferRenderbuffer, and
	 *  GetFramebufferAttachmentParameteriv:
	 */
	public static final int GL_FRAMEBUFFER = 0x8D40,
		GL_READ_FRAMEBUFFER = 0x8CA8,
		GL_DRAW_FRAMEBUFFER = 0x8CA9;

	/**
	 *  Accepted by the &lt;target&gt; parameter of BindRenderbuffer,
	 *  RenderbufferStorage, and GetRenderbufferParameteriv, and
	 *  returned by GetFramebufferAttachmentParameteriv:
	 */
	public static final int GL_RENDERBUFFER = 0x8D41;

	/**
	 *  Accepted by the &lt;internalformat&gt; parameter of
	 *  RenderbufferStorage:
	 */
	public static final int GL_STENCIL_INDEX1 = 0x8D46,
		GL_STENCIL_INDEX4 = 0x8D47,
		GL_STENCIL_INDEX8 = 0x8D48,
		GL_STENCIL_INDEX16 = 0x8D49;

	/**
	 * Accepted by the &lt;pname&gt; parameter of GetRenderbufferParameteriv: 
	 */
	public static final int GL_RENDERBUFFER_WIDTH = 0x8D42,
		GL_RENDERBUFFER_HEIGHT = 0x8D43,
		GL_RENDERBUFFER_INTERNAL_FORMAT = 0x8D44,
		GL_RENDERBUFFER_RED_SIZE = 0x8D50,
		GL_RENDERBUFFER_GREEN_SIZE = 0x8D51,
		GL_RENDERBUFFER_BLUE_SIZE = 0x8D52,
		GL_RENDERBUFFER_ALPHA_SIZE = 0x8D53,
		GL_RENDERBUFFER_DEPTH_SIZE = 0x8D54,
		GL_RENDERBUFFER_STENCIL_SIZE = 0x8D55;

	/**
	 *  Accepted by the &lt;pname&gt; parameter of
	 *  GetFramebufferAttachmentParameteriv:
	 */
	public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE = 0x8CD0,
		GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME = 0x8CD1,
		GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL = 0x8CD2,
		GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE = 0x8CD3,
		GL_FRAMEBUFFER_ATTACHMENT_COLOR_ENCODING = 0x8210,
		GL_FRAMEBUFFER_ATTACHMENT_COMPONENT_TYPE = 0x8211,
		GL_FRAMEBUFFER_ATTACHMENT_RED_SIZE = 0x8212,
		GL_FRAMEBUFFER_ATTACHMENT_GREEN_SIZE = 0x8213,
		GL_FRAMEBUFFER_ATTACHMENT_BLUE_SIZE = 0x8214,
		GL_FRAMEBUFFER_ATTACHMENT_ALPHA_SIZE = 0x8215,
		GL_FRAMEBUFFER_ATTACHMENT_DEPTH_SIZE = 0x8216,
		GL_FRAMEBUFFER_ATTACHMENT_STENCIL_SIZE = 0x8217;

	/**
	 * Returned in &lt;params&gt; by GetFramebufferAttachmentParameteriv: 
	 */
	public static final int GL_FRAMEBUFFER_DEFAULT = 0x8218,
		GL_INDEX = 0x8222;

	/**
	 *  Accepted by the &lt;attachment&gt; parameter of
	 *  FramebufferTexture{1D|2D|3D}, FramebufferRenderbuffer, and
	 *  GetFramebufferAttachmentParameteriv
	 */
	public static final int GL_COLOR_ATTACHMENT0 = 0x8CE0,
		GL_COLOR_ATTACHMENT1 = 0x8CE1,
		GL_COLOR_ATTACHMENT2 = 0x8CE2,
		GL_COLOR_ATTACHMENT3 = 0x8CE3,
		GL_COLOR_ATTACHMENT4 = 0x8CE4,
		GL_COLOR_ATTACHMENT5 = 0x8CE5,
		GL_COLOR_ATTACHMENT6 = 0x8CE6,
		GL_COLOR_ATTACHMENT7 = 0x8CE7,
		GL_COLOR_ATTACHMENT8 = 0x8CE8,
		GL_COLOR_ATTACHMENT9 = 0x8CE9,
		GL_COLOR_ATTACHMENT10 = 0x8CEA,
		GL_COLOR_ATTACHMENT11 = 0x8CEB,
		GL_COLOR_ATTACHMENT12 = 0x8CEC,
		GL_COLOR_ATTACHMENT13 = 0x8CED,
		GL_COLOR_ATTACHMENT14 = 0x8CEE,
		GL_COLOR_ATTACHMENT15 = 0x8CEF,
		GL_DEPTH_ATTACHMENT = 0x8D00,
		GL_STENCIL_ATTACHMENT = 0x8D20,
		GL_DEPTH_STENCIL_ATTACHMENT = 0x821A;

	/**
	 * Returned by CheckFramebufferStatus(): 
	 */
	public static final int GL_FRAMEBUFFER_COMPLETE = 0x8CD5,
		GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT = 0x8CD6,
		GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT = 0x8CD7,
		GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER = 0x8CDB,
		GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER = 0x8CDC,
		GL_FRAMEBUFFER_UNSUPPORTED = 0x8CDD,
		GL_FRAMEBUFFER_UNDEFINED = 0x8219;

	/**
	 *  Accepted by the &lt;pname&gt; parameters of GetIntegerv, GetFloatv,
	 *  and GetDoublev:
	 */
	public static final int GL_FRAMEBUFFER_BINDING = 0x8CA6,
		GL_RENDERBUFFER_BINDING = 0x8CA7,
		GL_MAX_COLOR_ATTACHMENTS = 0x8CDF,
		GL_MAX_RENDERBUFFER_SIZE = 0x84E8;

	/**
	 * Returned by GetError(): 
	 */
	public static final int GL_INVALID_FRAMEBUFFER_OPERATION = 0x506;

	/**
	 *  Accepted by the &lt;type&gt; parameter of DrawPixels, ReadPixels,
	 *  TexImage1D, TexImage2D, TexImage3D, GetTexImage, TexSubImage1D,
	 *  TexSubImage2D, TexSubImage3D, GetHistogram, GetMinmax,
	 *  ConvolutionFilter1D, ConvolutionFilter2D, GetConvolutionFilter,
	 *  SeparableFilter2D, GetSeparableFilter, ColorTable, ColorSubTable,
	 *  and GetColorTable:
	 *  <p/>
	 *  Accepted by the &lt;type&gt; argument of VertexPointer, NormalPointer,
	 *  ColorPointer, SecondaryColorPointer, FogCoordPointer, TexCoordPointer,
	 *  and VertexAttribPointer:
	 */
	public static final int GL_HALF_FLOAT = 0x140B;

	/**
	 * Accepted by the &lt;pname&gt; parameter of GetRenderbufferParameteriv. 
	 */
	public static final int GL_RENDERBUFFER_SAMPLES = 0x8CAB;

	/**
	 * Returned by CheckFramebufferStatus. 
	 */
	public static final int GL_FRAMEBUFFER_INCOMPLETE_MULTISAMPLE = 0x8D56;

	/**
	 *  Accepted by the &lt;pname&gt; parameter of GetBooleanv, GetIntegerv,
	 *  GetFloatv, and GetDoublev.
	 */
	public static final int GL_MAX_SAMPLES = 0x8D57;

	/**
	 * Accepted by the &lt;pname&gt; parameters of GetIntegerv, GetFloatv, and GetDoublev. 
	 */
	public static final int GL_DRAW_FRAMEBUFFER_BINDING = 0x8CA6,
		GL_READ_FRAMEBUFFER_BINDING = 0x8CAA;

	/**
	 *  Accepted by the &lt;pname&gt; parameters of GetBooleanv, GetIntegerv,
	 *  GetFloatv, and GetDoublev:
	 */
	public static final int GL_RGBA_INTEGER_MODE = 0x8D9E;

	/**
	 *  Accepted by the &lt;internalFormat&gt; parameter of TexImage1D,
	 *  TexImage2D, and TexImage3D:
	 */
	public static final int GL_RGBA32UI = 0x8D70,
		GL_RGB32UI = 0x8D71,
		GL_ALPHA32UI = 0x8D72,
		GL_RGBA16UI = 0x8D76,
		GL_RGB16UI = 0x8D77,
		GL_ALPHA16UI = 0x8D78,
		GL_RGBA8UI = 0x8D7C,
		GL_RGB8UI = 0x8D7D,
		GL_ALPHA8UI = 0x8D7E,
		GL_RGBA32I = 0x8D82,
		GL_RGB32I = 0x8D83,
		GL_ALPHA32I = 0x8D84,
		GL_RGBA16I = 0x8D88,
		GL_RGB16I = 0x8D89,
		GL_ALPHA16I = 0x8D8A,
		GL_RGBA8I = 0x8D8E,
		GL_RGB8I = 0x8D8F,
		GL_ALPHA8I = 0x8D90;

	/**
	 *  Accepted by the &lt;format&gt; parameter of TexImage1D, TexImage2D,
	 *  TexImage3D, TexSubImage1D, TexSubImage2D, TexSubImage3D,
	 *  DrawPixels and ReadPixels:
	 */
	public static final int GL_RED_INTEGER = 0x8D94,
		GL_GREEN_INTEGER = 0x8D95,
		GL_BLUE_INTEGER = 0x8D96,
		GL_ALPHA_INTEGER = 0x8D97,
		GL_RGB_INTEGER = 0x8D98,
		GL_RGBA_INTEGER = 0x8D99,
		GL_BGR_INTEGER = 0x8D9A,
		GL_BGRA_INTEGER = 0x8D9B;

	/**
	 *  Accepted by the &lt;target&gt; parameter of TexParameteri, TexParameteriv,
	 *  TexParameterf, TexParameterfv, and BindTexture:
	 */
	public static final int GL_TEXTURE_1D_ARRAY = 0x8C18,
		GL_TEXTURE_2D_ARRAY = 0x8C1A;

	/**
	 *  Accepted by the &lt;target&gt; parameter of TexImage3D, TexSubImage3D,
	 *  CopyTexSubImage3D, CompressedTexImage3D, and CompressedTexSubImage3D:
	 */
	public static final int GL_PROXY_TEXTURE_2D_ARRAY = 0x8C1B;

	/**
	 *  Accepted by the &lt;target&gt; parameter of TexImage2D, TexSubImage2D,
	 *  CopyTexImage2D, CopyTexSubImage2D, CompressedTexImage2D, and
	 *  CompressedTexSubImage2D:
	 */
	public static final int GL_PROXY_TEXTURE_1D_ARRAY = 0x8C19;

	/**
	 *  Accepted by the &lt;pname&gt; parameter of GetBooleanv, GetDoublev, GetIntegerv
	 *  and GetFloatv:
	 */
	public static final int GL_TEXTURE_BINDING_1D_ARRAY = 0x8C1C,
		GL_TEXTURE_BINDING_2D_ARRAY = 0x8C1D,
		GL_MAX_ARRAY_TEXTURE_LAYERS = 0x88FF;

	/**
	 *  Accepted by the &lt;param&gt; parameter of TexParameterf, TexParameteri,
	 *  TexParameterfv, and TexParameteriv when the &lt;pname&gt; parameter is
	 *  TEXTURE_COMPARE_MODE_ARB:
	 */
	public static final int GL_COMPARE_REF_DEPTH_TO_TEXTURE = 0x884E;

	/**
	 *  Accepted by the &lt;pname&gt; parameter of
	 *  GetFramebufferAttachmentParameteriv:
	 */
	public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LAYER = 0x8CD4;

	/**
	 * Returned by the &lt;type&gt; parameter of GetActiveUniform: 
	 */
	public static final int GL_SAMPLER_1D_ARRAY = 0x8DC0,
		GL_SAMPLER_2D_ARRAY = 0x8DC1,
		GL_SAMPLER_1D_ARRAY_SHADOW = 0x8DC3,
		GL_SAMPLER_2D_ARRAY_SHADOW = 0x8DC4;

	/**
	 *  Accepted by the &lt;format&gt; parameter of DrawPixels, ReadPixels,
	 *  TexImage1D, TexImage2D, TexImage3D, TexSubImage1D, TexSubImage2D,
	 *  TexSubImage3D, and GetTexImage, by the &lt;type&gt; parameter of
	 *  CopyPixels, by the &lt;internalformat&gt; parameter of TexImage1D,
	 *  TexImage2D, TexImage3D, CopyTexImage1D, CopyTexImage2D, and
	 *  RenderbufferStorage, and returned in the &lt;data&gt; parameter of
	 *  GetTexLevelParameter and GetRenderbufferParameteriv.
	 */
	public static final int GL_DEPTH_STENCIL = 0x84F9;

	/**
	 *  Accepted by the &lt;type&gt; parameter of DrawPixels, ReadPixels,
	 *  TexImage1D, TexImage2D, TexImage3D, TexSubImage1D, TexSubImage2D,
	 *  TexSubImage3D, and GetTexImage.
	 */
	public static final int GL_UNSIGNED_INT_24_8 = 0x84FA;

	/**
	 *  Accepted by the &lt;internalformat&gt; parameter of TexImage1D,
	 *  TexImage2D, TexImage3D, CopyTexImage1D, CopyTexImage2D, and
	 *  RenderbufferStorage, and returned in the &lt;data&gt; parameter of
	 *  GetTexLevelParameter and GetRenderbufferParameteriv.
	 */
	public static final int GL_DEPTH24_STENCIL8 = 0x88F0;

	/**
	 * Accepted by the &lt;value&gt; parameter of GetTexLevelParameter. 
	 */
	public static final int GL_TEXTURE_STENCIL_SIZE = 0x88F1;

	/**
	 *  Accepted by the &lt;internalformat&gt; parameter of TexImage2D,
	 *  CopyTexImage2D, and CompressedTexImage2D and the &lt;format&gt; parameter
	 *  of CompressedTexSubImage2D:
	 */
	public static final int GL_COMPRESSED_RED_RGTC1 = 0x8DBB,
		GL_COMPRESSED_SIGNED_RED_RGTC1 = 0x8DBC,
		GL_COMPRESSED_RG_RGTC2 = 0x8DBD,
		GL_COMPRESSED_SIGNED_RG_RGTC2 = 0x8DBE;

	/**
	 *  Accepted by the &lt;internalFormat&gt; parameter of TexImage1D, TexImage2D,
	 *  TexImage3D, CopyTexImage1D, and CopyTexImage2D:
	 */
	public static final int GL_R8 = 0x8229,
		GL_R16 = 0x822A,
		GL_RG8 = 0x822B,
		GL_RG16 = 0x822C,
		GL_R16F = 0x822D,
		GL_R32F = 0x822E,
		GL_RG16F = 0x822F,
		GL_RG32F = 0x8230,
		GL_R8I = 0x8231,
		GL_R8UI = 0x8232,
		GL_R16I = 0x8233,
		GL_R16UI = 0x8234,
		GL_R32I = 0x8235,
		GL_R32UI = 0x8236,
		GL_RG8I = 0x8237,
		GL_RG8UI = 0x8238,
		GL_RG16I = 0x8239,
		GL_RG16UI = 0x823A,
		GL_RG32I = 0x823B,
		GL_RG32UI = 0x823C;

	/**
	 *  Accepted by the &lt;format&gt; parameter of TexImage3D, TexImage2D,
	 *  TexImage3D, TexSubImage1D, TexSubImage2D, TexSubImage3D,
	 *  DrawPixels and ReadPixels:
	 */
	public static final int GL_RG = 0x8227,
		GL_RG_INTEGER = 0x8228;

	/**
	 *  Accepted by the &lt;target&gt; parameters of BindBuffer, BufferData,
	 *  BufferSubData, MapBuffer, UnmapBuffer, GetBufferSubData,
	 *  GetBufferPointerv, BindBufferRange, BindBufferOffset and
	 *  BindBufferBase:
	 */
	public static final int GL_TRANSFORM_FEEDBACK_BUFFER = 0x8C8E;

	/**
	 *  Accepted by the &lt;param&gt; parameter of GetIntegerIndexedv and
	 *  GetBooleanIndexedv:
	 */
	public static final int GL_TRANSFORM_FEEDBACK_BUFFER_START = 0x8C84,
		GL_TRANSFORM_FEEDBACK_BUFFER_SIZE = 0x8C85;

	/**
	 *  Accepted by the &lt;param&gt; parameter of GetIntegerIndexedv and
	 *  GetBooleanIndexedv, and by the &lt;pname&gt; parameter of GetBooleanv,
	 *  GetDoublev, GetIntegerv, and GetFloatv:
	 */
	public static final int GL_TRANSFORM_FEEDBACK_BUFFER_BINDING = 0x8C8F;

	/**
	 * Accepted by the &lt;bufferMode&gt; parameter of TransformFeedbackVaryings: 
	 */
	public static final int GL_INTERLEAVED_ATTRIBS = 0x8C8C,
		GL_SEPARATE_ATTRIBS = 0x8C8D;

	/**
	 *  Accepted by the &lt;target&gt; parameter of BeginQuery, EndQuery, and
	 *  GetQueryiv:
	 */
	public static final int GL_PRIMITIVES_GENERATED = 0x8C87,
		GL_TRANSFORM_FEEDBACK_PRIMITIVES_WRITTEN = 0x8C88;

	/**
	 *  Accepted by the &lt;cap&gt; parameter of Enable, Disable, and IsEnabled, and by
	 *  the &lt;pname&gt; parameter of GetBooleanv, GetIntegerv, GetFloatv, and
	 *  GetDoublev:
	 */
	public static final int GL_RASTERIZER_DISCARD = 0x8C89;

	/**
	 *  Accepted by the &lt;pname&gt; parameter of GetBooleanv, GetDoublev, GetIntegerv,
	 *  and GetFloatv:
	 */
	public static final int GL_MAX_TRANSFORM_FEEDBACK_INTERLEAVED_COMPONENTS = 0x8C8A,
		GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_ATTRIBS = 0x8C8B,
		GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_COMPONENTS = 0x8C80;

	/**
	 * Accepted by the &lt;pname&gt; parameter of GetProgramiv: 
	 */
	public static final int GL_TRANSFORM_FEEDBACK_VARYINGS = 0x8C83,
		GL_TRANSFORM_FEEDBACK_BUFFER_MODE = 0x8C7F,
		GL_TRANSFORM_FEEDBACK_VARYING_MAX_LENGTH = 0x8C76;

	/**
	 *  Accepted by the &lt;pname&gt; parameter of GetBooleanv, GetIntegerv,
	 *  GetFloatv, and GetDoublev:
	 */
	public static final int GL_VERTEX_ARRAY_BINDING = 0x85B5;

	/**
	 *  Accepted by the &lt;cap&gt; parameter of Enable, Disable, and IsEnabled,
	 *  and by the &lt;pname&gt; parameter of GetBooleanv, GetIntegerv, GetFloatv,
	 *  and GetDoublev:
	 */
	public static final int GL_FRAMEBUFFER_SRGB = 0x8DB9;

	/**
	 *  Accepted by the &lt;pname&gt; parameter of GetBooleanv, GetIntegerv,
	 *  GetFloatv, and GetDoublev:
	 */
	public static final int GL_FRAMEBUFFER_SRGB_CAPABLE = 0x8DBA;

	private GL30() {}
	private static WebGL2RenderingContext ctx = (WebGL2RenderingContext) CurrentContext.getContext();
	public static String glGetStringi(int name, int index) {
		return ctx.getParameterString(name);
	}
	static native String nglGetStringi(int name, int index, long function_pointer);

	public static void glClearBuffer(int buffer, int drawbuffer, FloatBuffer value) {
		ctx.clearBufferfv(buffer, drawbuffer, Float32Array.create(GLUtil.glCreateBufferFromJava(value)), 0);
	}
	static native void nglClearBufferfv(int buffer, int drawbuffer, long value, long function_pointer);

	public static void glClearBuffer(int buffer, int drawbuffer, IntBuffer value) {
		ctx.clearBufferiv(buffer, drawbuffer, Int32Array.create(GLUtil.glCreateBufferFromJava(value)), 0);
	}
	static native void nglClearBufferiv(int buffer, int drawbuffer, long value, long function_pointer);

	public static void glClearBufferu(int buffer, int drawbuffer, IntBuffer value) {
		ctx.clearBufferuiv(buffer, drawbuffer, GLUtil.glCreateBufferFromJava(value), drawbuffer);
	}
	static native void nglClearBufferuiv(int buffer, int drawbuffer, long value, long function_pointer);

	public static void glClearBufferfi(int buffer, int drawbuffer, float depth, int stencil) {
		ctx.clearBufferfi(buffer, drawbuffer, depth, stencil);
	}
	static native void nglClearBufferfi(int buffer, int drawbuffer, float depth, int stencil, long function_pointer);

	public static void glVertexAttribI1i(int index, int x) {
		ctx.vertexAttribI4i(index, x, 0, 0, 1);
	}
	static native void nglVertexAttribI1i(int index, int x, long function_pointer);

	public static void glVertexAttribI2i(int index, int x, int y) {
		ctx.vertexAttribI4i(index, x, y, 0, 1);
	}
	static native void nglVertexAttribI2i(int index, int x, int y, long function_pointer);

	public static void glVertexAttribI3i(int index, int x, int y, int z) {
		ctx.vertexAttribI4i(index, x, y, z, 1);
	}
	static native void nglVertexAttribI3i(int index, int x, int y, int z, long function_pointer);

	public static void glVertexAttribI4i(int index, int x, int y, int z, int w) {
		ctx.vertexAttribI4i(index, x, y, z, w);
	}
	static native void nglVertexAttribI4i(int index, int x, int y, int z, int w, long function_pointer);

	public static void glVertexAttribI1ui(int index, int x) {
		ctx.vertexAttribI4ui(index, x, 0, 0, 0);
	}
	static native void nglVertexAttribI1ui(int index, int x, long function_pointer);

	public static void glVertexAttribI2ui(int index, int x, int y) {
		ctx.vertexAttribI4ui(index, x, y, 0, 1);
	}
	static native void nglVertexAttribI2ui(int index, int x, int y, long function_pointer);

	public static void glVertexAttribI3ui(int index, int x, int y, int z) {
		ctx.vertexAttribI4ui(index, x, y, z, 0);
	}
	static native void nglVertexAttribI3ui(int index, int x, int y, int z, long function_pointer);

	public static void glVertexAttribI4ui(int index, int x, int y, int z, int w) {
		ctx.vertexAttribI4ui(index, x, y, z, w);
	}
	static native void nglVertexAttribI4ui(int index, int x, int y, int z, int w, long function_pointer);

	public static void glVertexAttribI1(int index, IntBuffer v) {
		int[] arr = new int[] {v.get(), 0, 0, 1};
		Int32Array res = Int32Array.create(arr.length);
		res.set(arr);
		ctx.vertexAttribI4iv(index, res);
	}
	static native void nglVertexAttribI1iv(int index, long v, long function_pointer);

	public static void glVertexAttribI2(int index, IntBuffer v) {
		int[] arr = new int[] {v.get(), v.get(), 0, 1};
		Int32Array res = Int32Array.create(arr.length);
		res.set(arr);
		ctx.vertexAttribI4iv(index, res);
	}
	static native void nglVertexAttribI2iv(int index, long v, long function_pointer);

	public static void glVertexAttribI3(int index, IntBuffer v) {
		int[] arr = new int[] {v.get(), v.get(), v.get(), 1};
		Int32Array res = Int32Array.create(arr.length);
		res.set(arr);
		ctx.vertexAttribI4iv(index, res);
	}
	static native void nglVertexAttribI3iv(int index, long v, long function_pointer);

	public static void glVertexAttribI4(int index, IntBuffer v) {
		int[] arr = new int[] {v.get(), v.get(), v.get(), v.get()};
		Int32Array res = Int32Array.create(arr.length);
		res.set(arr);
		ctx.vertexAttribI4iv(index, res);
	}
	static native void nglVertexAttribI4iv(int index, long v, long function_pointer);

	public static void glVertexAttribI1u(int index, IntBuffer v) {
		int[] arr = new int[] {v.get(), 0, 0, 1};
		Int32Array res = Int32Array.create(arr.length);
		res.set(arr);
		ctx.vertexAttribI4uiv(index, res.getBuffer());
	}
	static native void nglVertexAttribI1uiv(int index, long v, long function_pointer);

	public static void glVertexAttribI2u(int index, IntBuffer v) {
		int[] arr = new int[] {v.get(), v.get(), 0, 1};
		Int32Array res = Int32Array.create(arr.length);
		res.set(arr);
		ctx.vertexAttribI4uiv(index, res.getBuffer());
	}
	static native void nglVertexAttribI2uiv(int index, long v, long function_pointer);

	public static void glVertexAttribI3u(int index, IntBuffer v) {
		int[] arr = new int[] {v.get(), v.get(), v.get(), 1};
		Int32Array res = Int32Array.create(arr.length);
		res.set(arr);
		ctx.vertexAttribI4uiv(index, res.getBuffer());
	}
	static native void nglVertexAttribI3uiv(int index, long v, long function_pointer);

	public static void glVertexAttribI4u(int index, IntBuffer v) {
		int[] arr = new int[] {v.get(), v.get(), v.get(), v.get()};
		Int32Array res = Int32Array.create(arr.length);
		res.set(arr);
		ctx.vertexAttribI4uiv(index, res.getBuffer());
	}
	static native void nglVertexAttribI4uiv(int index, long v, long function_pointer);

	public static void glVertexAttribI4(int index, ByteBuffer v) {
		int[] arr = new int[] {v.get(), v.get(), v.get(), v.get()};
		Int32Array res = Int32Array.create(arr.length);
		res.set(arr);
		ctx.vertexAttribI4iv(index, res);
	}
	static native void nglVertexAttribI4bv(int index, long v, long function_pointer);

	public static void glVertexAttribI4(int index, ShortBuffer v) {
		int[] arr = new int[] {v.get(), v.get(), v.get(), v.get()};
		Int32Array res = Int32Array.create(arr.length);
		res.set(arr);
		ctx.vertexAttribI4iv(index, res);
	}
	static native void nglVertexAttribI4sv(int index, long v, long function_pointer);

	public static void glVertexAttribI4u(int index, ByteBuffer v) {
		int[] arr = new int[] {v.get(), v.get(), v.get(), v.get()};
		Int32Array res = Int32Array.create(arr.length);
		res.set(arr);
		ctx.vertexAttribI4iv(index, res);
	}
	static native void nglVertexAttribI4ubv(int index, long v, long function_pointer);

	public static void glVertexAttribI4u(int index, ShortBuffer v) {
		int[] arr = new int[] {v.get(), v.get(), v.get(), v.get()};
		Int32Array res = Int32Array.create(arr.length);
		res.set(arr);
		ctx.vertexAttribI4iv(index, res);
	}
	static native void nglVertexAttribI4usv(int index, long v, long function_pointer);

	public static void glVertexAttribIPointer(int index, int size, int type, int stride, ByteBuffer buffer) {
		ctx.vertexAttribIPointer(index, size, type, stride, buffer.get());
	}
	public static void glVertexAttribIPointer(int index, int size, int type, int stride, IntBuffer buffer) {
		ctx.vertexAttribIPointer(index, size, type, stride, buffer.get());
	}
	public static void glVertexAttribIPointer(int index, int size, int type, int stride, ShortBuffer buffer) {
		ctx.vertexAttribIPointer(index, size, type, stride, buffer.get());
	}
	static native void nglVertexAttribIPointer(int index, int size, int type, int stride, long buffer, long function_pointer);
	public static void glVertexAttribIPointer(int index, int size, int type, int stride, long buffer_buffer_offset) {
//		ctx.vertexAttribIPointer(index, size, type, stride, buffer.get());
	}
	static native void nglVertexAttribIPointerBO(int index, int size, int type, int stride, long buffer_buffer_offset, long function_pointer);

	public static void glGetVertexAttribI(int index, int pname, IntBuffer params) {
		JSNumber v = (JSNumber) ctx.getVertexAttrib(index, pname);
		params.put(v.intValue());
	}
	static native void nglGetVertexAttribIiv(int index, int pname, long params, long function_pointer);

	public static void glGetVertexAttribIu(int index, int pname, IntBuffer params) {
		params.get(((JSNumber) ctx.getVertexAttrib(index, pname)).intValue());
	}
	static native void nglGetVertexAttribIuiv(int index, int pname, long params, long function_pointer);

	public static void glUniform1ui(int location, int v0) {
		ctx.uniform1ui((WebGLUniformLocation) get(location).getObject(), v0);
	}
	static native void nglUniform1ui(int location, int v0, long function_pointer);

	public static void glUniform2ui(int location, int v0, int v1) {
		ctx.uniform2ui((WebGLUniformLocation) get(location).getObject(), v0, v1);
	}
	static native void nglUniform2ui(int location, int v0, int v1, long function_pointer);

	public static void glUniform3ui(int location, int v0, int v1, int v2) {
		ctx.uniform3ui((WebGLUniformLocation) get(location).getObject(), v0, v1, v2);
	}
	static native void nglUniform3ui(int location, int v0, int v1, int v2, long function_pointer);

	public static void glUniform4ui(int location, int v0, int v1, int v2, int v3) {
		ctx.uniform4ui((WebGLUniformLocation) get(location).getObject(), v0, v1, v2, v3);
	}
	static native void nglUniform4ui(int location, int v0, int v1, int v2, int v3, long function_pointer);

	public static void glUniform1u(int location, IntBuffer value) {
		ctx.uniform1uiv((WebGLUniformLocation) get(location).getObject(), GLUtil.glCreateBufferFromJava(value));
	}
	static native void nglUniform1uiv(int location, int value_count, long value, long function_pointer);

	public static void glUniform2u(int location, IntBuffer value) {
		ctx.uniform2uiv((WebGLUniformLocation) get(location).getObject(), GLUtil.glCreateBufferFromJava(value));
	}
	static native void nglUniform2uiv(int location, int value_count, long value, long function_pointer);

	public static void glUniform3u(int location, IntBuffer value) {
		ctx.uniform3uiv((WebGLUniformLocation) get(location).getObject(), GLUtil.glCreateBufferFromJava(value));
	}
	static native void nglUniform3uiv(int location, int value_count, long value, long function_pointer);

	public static void glUniform4u(int location, IntBuffer value) {
		ctx.uniform4uiv((WebGLUniformLocation) get(location).getObject(), GLUtil.glCreateBufferFromJava(value));
	}
	static native void nglUniform4uiv(int location, int value_count, long value, long function_pointer);

	public static void glGetUniformu(int program, int location, IntBuffer params) {
		ctx.getUniform((WebGLProgram) get(program).getObject(), (WebGLUniformLocation) get(location).getObject());
	}
	static native void nglGetUniformuiv(int program, int location, long params, long function_pointer);

	public static void glBindFragDataLocation(int program, int colorNumber, ByteBuffer name) {
		
	}
	static native void nglBindFragDataLocation(int program, int colorNumber, long name, long function_pointer);

	/** Overloads glBindFragDataLocation. */
	public static void glBindFragDataLocation(int program, int colorNumber, CharSequence name) {
		
	}

	public static int glGetFragDataLocation(int program, ByteBuffer name) {
		return ctx.getFragDataLocation((WebGLProgram) get(program).getObject(), name.asCharBuffer().toString());
	}
	static native int nglGetFragDataLocation(int program, long name, long function_pointer);

	/** Overloads glGetFragDataLocation. */
	public static int glGetFragDataLocation(int program, CharSequence name) {
	
		return ctx.getFragDataLocation((WebGLProgram) get(program).getObject(), name.toString());
	}

	public static void glBeginConditionalRender(int id, int mode) {
		
	}
	static native void nglBeginConditionalRender(int id, int mode, long function_pointer);

	public static void glEndConditionalRender() {
		
	}
	static native void nglEndConditionalRender(long function_pointer);

	/**
	 *  glMapBufferRange maps a GL buffer object range to a ByteBuffer. The old_buffer argument can be null,
	 *  in which case a new ByteBuffer will be created, pointing to the returned memory. If old_buffer is non-null,
	 *  it will be returned if it points to the same mapped memory and has the same capacity as the buffer object,
	 *  otherwise a new ByteBuffer is created. That way, an application will normally use glMapBufferRange like this:
	 *  <p/>
	 *  ByteBuffer mapped_buffer; mapped_buffer = glMapBufferRange(..., ..., ..., ..., null); ... // Another map on the same buffer mapped_buffer = glMapBufferRange(..., ..., ..., ..., mapped_buffer);
	 *  <p/>
	 *  Only ByteBuffers returned from this method are to be passed as the old_buffer argument. User-created ByteBuffers cannot be reused.
	 * <p>
	 *  @param old_buffer A ByteBuffer. If this argument points to the same address and has the same capacity as the new mapping, it will be returned and no new buffer will be created.
	 * <p>
	 *  @return A ByteBuffer representing the mapped buffer memory.
	 */
	public static ByteBuffer glMapBufferRange(int target, long offset, long length, int access, ByteBuffer old_buffer) {
		return null;
	}
	static native ByteBuffer nglMapBufferRange(int target, long offset, long length, int access, ByteBuffer old_buffer, long function_pointer);

	public static void glFlushMappedBufferRange(int target, long offset, long length) {
		
	}
	static native void nglFlushMappedBufferRange(int target, long offset, long length, long function_pointer);

	public static void glClampColor(int target, int clamp) {
		
	}
	static native void nglClampColor(int target, int clamp, long function_pointer);

	public static boolean glIsRenderbuffer(int renderbuffer) {
		return get(renderbuffer).getType() == GL_OBJECT_RENDERBUFFER;
	}
	static native boolean nglIsRenderbuffer(int renderbuffer, long function_pointer);

	public static void glBindRenderbuffer(int target, int renderbuffer) {
		ctx.bindRenderbuffer(target, (WebGLRenderbuffer) get(renderbuffer).getObject());
	}
	static native void nglBindRenderbuffer(int target, int renderbuffer, long function_pointer);

	public static void glDeleteRenderbuffers(IntBuffer renderbuffers) {
		ctx.deleteRenderbuffer((WebGLRenderbuffer) get(renderbuffers.get()).getObject());
	}
	static native void nglDeleteRenderbuffers(int renderbuffers_n, long renderbuffers, long function_pointer);

	/** Overloads glDeleteRenderbuffers. */
	public static void glDeleteRenderbuffers(int renderbuffer) {
		ctx.deleteRenderbuffer((WebGLRenderbuffer) get(renderbuffer).getObject());
	}

	public static void glGenRenderbuffers(IntBuffer renderbuffers) {
		int remaining = renderbuffers.remaining();
		for (int i =0; i < remaining; i ++) {
			renderbuffers.put(newObject(GL_OBJECT_RENDERBUFFER, ctx.createRenderbuffer()));
		}
	}
	static native void nglGenRenderbuffers(int renderbuffers_n, long renderbuffers, long function_pointer);

	/** Overloads glGenRenderbuffers. */
	public static int glGenRenderbuffers() {
		return newObject(GL_OBJECT_RENDERBUFFER, ctx.createRenderbuffer());
	}

	public static void glRenderbufferStorage(int target, int internalformat, int width, int height) {
		ctx.renderbufferStorage(target, internalformat, width, height);
	}
	static native void nglRenderbufferStorage(int target, int internalformat, int width, int height, long function_pointer);

	public static void glGetRenderbufferParameter(int target, int pname, IntBuffer params) {
		params.put(((JSNumber) ctx.getRenderbufferParameter(target, pname)).intValue());
	}
	static native void nglGetRenderbufferParameteriv(int target, int pname, long params, long function_pointer);

	/**
	 * Overloads glGetRenderbufferParameteriv.
	 * <p>
	 * @deprecated Will be removed in 3.0. Use {@link #glGetRenderbufferParameteri} instead. 
	 */
	@Deprecated
	public static int glGetRenderbufferParameter(int target, int pname) {
		return GL30.glGetRenderbufferParameteri(target, pname);
	}

	/** Overloads glGetRenderbufferParameteriv. */
	public static int glGetRenderbufferParameteri(int target, int pname) {
		return ((JSNumber) ctx.getRenderbufferParameter(target, pname)).intValue();
	}

	public static boolean glIsFramebuffer(int framebuffer) {
		return get(framebuffer).getType() == GL_OBJECT_FRAMEBUFFER;
	}
	static native boolean nglIsFramebuffer(int framebuffer, long function_pointer);

	public static void glBindFramebuffer(int target, int framebuffer) {
		ctx.bindFramebuffer(target, (WebGLFramebuffer) get(framebuffer).getObject());
	}
	static native void nglBindFramebuffer(int target, int framebuffer, long function_pointer);

	public static void glDeleteFramebuffers(IntBuffer framebuffers) {
		for (int i = 0; i < framebuffers.remaining(); i++) {
			ctx.deleteFramebuffer((WebGLFramebuffer) get(framebuffers.get()).getObject());
		}
	}
	static native void nglDeleteFramebuffers(int framebuffers_n, long framebuffers, long function_pointer);

	/** Overloads glDeleteFramebuffers. */
	public static void glDeleteFramebuffers(int framebuffer) {
		ctx.deleteFramebuffer((WebGLFramebuffer) get(framebuffer).getObject());
	}

	public static void glGenFramebuffers(IntBuffer framebuffers) {
		for (int i = 0; i < framebuffers.remaining(); i++ ) {
			framebuffers.put(newObject(GL_OBJECT_FRAMEBUFFER, ctx.createFramebuffer()));
		}
	}
	static native void nglGenFramebuffers(int framebuffers_n, long framebuffers, long function_pointer);

	/** Overloads glGenFramebuffers. */
	public static int glGenFramebuffers() {
		return newObject(GL_OBJECT_FRAMEBUFFER, ctx.createFramebuffer());
	}

	public static int glCheckFramebufferStatus(int target) {
		return ctx.checkFramebufferStatus(target);
	}
	static native int nglCheckFramebufferStatus(int target, long function_pointer);

	public static void glFramebufferTexture1D(int target, int attachment, int textarget, int texture, int level) {
		
	}
	static native void nglFramebufferTexture1D(int target, int attachment, int textarget, int texture, int level, long function_pointer);

	public static void glFramebufferTexture2D(int target, int attachment, int textarget, int texture, int level) {
		ctx.framebufferTexture2D(target, attachment, textarget, (WebGLTexture) get(texture).getObject(), level);
	}
	static native void nglFramebufferTexture2D(int target, int attachment, int textarget, int texture, int level, long function_pointer);

	public static void glFramebufferTexture3D(int target, int attachment, int textarget, int texture, int level, int zoffset) {
		
	}
	static native void nglFramebufferTexture3D(int target, int attachment, int textarget, int texture, int level, int zoffset, long function_pointer);

	public static void glFramebufferRenderbuffer(int target, int attachment, int renderbuffertarget, int renderbuffer) {
		ctx.framebufferRenderbuffer(target, attachment, renderbuffertarget, (WebGLRenderbuffer) get(renderbuffer).getObject());
	}
	static native void nglFramebufferRenderbuffer(int target, int attachment, int renderbuffertarget, int renderbuffer, long function_pointer);

	public static void glGetFramebufferAttachmentParameter(int target, int attachment, int pname, IntBuffer params) {
		params.put(((JSNumber) ctx.getFramebufferAttachmentParameter(target, attachment, pname)).intValue());
	}
	static native void nglGetFramebufferAttachmentParameteriv(int target, int attachment, int pname, long params, long function_pointer);

	/**
	 * Overloads glGetFramebufferAttachmentParameteriv.
	 * <p>
	 * @deprecated Will be removed in 3.0. Use {@link #glGetFramebufferAttachmentParameteri} instead. 
	 */
	@Deprecated
	public static int glGetFramebufferAttachmentParameter(int target, int attachment, int pname) {
		return GL30.glGetFramebufferAttachmentParameteri(target, attachment, pname);
	}

	/** Overloads glGetFramebufferAttachmentParameteriv. */
	public static int glGetFramebufferAttachmentParameteri(int target, int attachment, int pname) {
		return ((JSNumber) ctx.getFramebufferAttachmentParameter(target, attachment, pname)).intValue();
	}

	public static void glGenerateMipmap(int target) {
		ctx.generateMipmap(target);
	}
	static native void nglGenerateMipmap(int target, long function_pointer);

	/**
	 *  Establishes the data storage, format, dimensions, and number of
	 *  samples of a renderbuffer object's image.
	 */
	public static void glRenderbufferStorageMultisample(int target, int samples, int internalformat, int width, int height) {
		ctx.renderbufferStorageMultisample(target, samples, internalformat, width, height);
	}
	static native void nglRenderbufferStorageMultisample(int target, int samples, int internalformat, int width, int height, long function_pointer);

	/**
	 *  Transfers a rectangle of pixel values from one
	 *  region of the read framebuffer to another in the draw framebuffer.
	 *  &lt;mask&gt; is the bitwise OR of a number of values indicating which
	 *  buffers are to be copied. The values are COLOR_BUFFER_BIT,
	 *  DEPTH_BUFFER_BIT, and STENCIL_BUFFER_BIT.
	 *  The pixels corresponding to these buffers are
	 *  copied from the source rectangle, bound by the locations (srcX0,
	 *  srcY0) and (srcX1, srcY1) inclusive, to the destination rectangle,
	 *  bound by the locations (dstX0, dstY0) and (dstX1, dstY1)
	 *  inclusive.
	 *  If the source and destination rectangle dimensions do not match,
	 *  the source image is stretched to fit the destination
	 *  rectangle. &lt;filter&gt; must be LINEAR or NEAREST and specifies the
	 *  method of interpolation to be applied if the image is
	 *  stretched.
	 */
	public static void glBlitFramebuffer(int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter) {
		ctx.blitFramebuffer(srcX0, srcY0, srcX1, srcY1, dstX0, dstY0, dstX1, dstY1, mask, filter);
	}
	static native void nglBlitFramebuffer(int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter, long function_pointer);

	public static void glTexParameterI(int target, int pname, IntBuffer params) {
		ctx.texParameteri(target, pname, params.get());
	}
	static native void nglTexParameterIiv(int target, int pname, long params, long function_pointer);

	/** Overloads glTexParameterIiv. */
	public static void glTexParameterIi(int target, int pname, int param) {
		ctx.texParameteri(target, pname, param);
	}

	public static void glTexParameterIu(int target, int pname, IntBuffer params) {
		ctx.texParameteri(target, pname, params.get());
	}
	static native void nglTexParameterIuiv(int target, int pname, long params, long function_pointer);

	/** Overloads glTexParameterIuiv. */
	public static void glTexParameterIui(int target, int pname, int param) {
		ctx.texParameteri(target, pname, param);
	}

	public static void glGetTexParameterI(int target, int pname, IntBuffer params) {
		params.put( ((JSNumber) ctx.getTexParameter(target, pname)).intValue());
	}
	static native void nglGetTexParameterIiv(int target, int pname, long params, long function_pointer);

	/** Overloads glGetTexParameterIiv. */
	public static int glGetTexParameterIi(int target, int pname) {
		return ((JSNumber) ctx.getTexParameter(target, pname)).intValue();
	}

	public static void glGetTexParameterIu(int target, int pname, IntBuffer params) {
		params.put(((JSNumber) ctx.getTexParameter(target, pname)).intValue());
	}
	static native void nglGetTexParameterIuiv(int target, int pname, long params, long function_pointer);

	/** Overloads glGetTexParameterIuiv. */
	public static int glGetTexParameterIui(int target, int pname) {
		return ((JSNumber) ctx.getTexParameter(target, pname)).intValue();
	}

	public static void glFramebufferTextureLayer(int target, int attachment, int texture, int level, int layer) {
		ctx.framebufferTextureLayer(target, attachment, (WebGLTexture) get(texture).getObject(), level, layer);
	}
	static native void nglFramebufferTextureLayer(int target, int attachment, int texture, int level, int layer, long function_pointer);

	public static void glColorMaski(int buf, boolean r, boolean g, boolean b, boolean a) {
		ctx.colorMask(r, g, b, a);
	}
	static native void nglColorMaski(int buf, boolean r, boolean g, boolean b, boolean a, long function_pointer);

	public static void glGetBoolean(int value, int index, ByteBuffer data) {
		data.put(ctx.getParameteri(value) == 1 ? (byte) 1: (byte) 0);
	}
	static native void nglGetBooleani_v(int value, int index, long data, long function_pointer);

	/** Overloads glGetBooleani_v. */
	public static boolean glGetBoolean(int value, int index) {
		return ctx.getParameteri(value) == 1;
	}

	public static void glGetInteger(int value, int index, IntBuffer data) {
		data.put(ctx.getParameteri(value));
	}
	static native void nglGetIntegeri_v(int value, int index, long data, long function_pointer);

	/** Overloads glGetIntegeri_v. */
	public static int glGetInteger(int value, int index) {
		return ctx.getParameteri(index);
	}

	public static void glEnablei(int target, int index) {
		ctx.enable(target);
	}
	static native void nglEnablei(int target, int index, long function_pointer);

	public static void glDisablei(int target, int index) {
		ctx.disable(target);
	}
	static native void nglDisablei(int target, int index, long function_pointer);

	public static boolean glIsEnabledi(int target, int index) {
		return ctx.isEnabled(target);
	}
	static native boolean nglIsEnabledi(int target, int index, long function_pointer);

	public static void glBindBufferRange(int target, int index, int buffer, long offset, long size) {
		ctx.bindBufferRange(target, index, (WebGLBuffer) get(buffer).getObject(), index, buffer);
	}
	static native void nglBindBufferRange(int target, int index, int buffer, long offset, long size, long function_pointer);

	public static void glBindBufferBase(int target, int index, int buffer) {
		ctx.bindBufferBase(target, index, (WebGLBuffer) get(buffer).getObject());
	}
	static native void nglBindBufferBase(int target, int index, int buffer, long function_pointer);

	public static void glBeginTransformFeedback(int primitiveMode) {
		ctx.beginTransformFeedback(primitiveMode);
	}
	static native void nglBeginTransformFeedback(int primitiveMode, long function_pointer);

	public static void glEndTransformFeedback() {
		ctx.endTransformFeedback();
		
	}
	static native void nglEndTransformFeedback(long function_pointer);

	public static void glTransformFeedbackVaryings(int program, int count, ByteBuffer varyings, int bufferMode) {
		ctx.transformFeedbackVaryings((WebGLProgram) get(program).getObject(), new String[] {varyings.asCharBuffer().toString()}, bufferMode);
	}
	static native void nglTransformFeedbackVaryings(int program, int count, long varyings, int bufferMode, long function_pointer);

	/** Overloads glTransformFeedbackVaryings. */
	public static void glTransformFeedbackVaryings(int program, CharSequence[] varyings, int bufferMode) {
		ctx.transformFeedbackVaryings((WebGLProgram) get(program).getObject(), new String[] {varyings.toString()}, bufferMode);
	}

	public static void glGetTransformFeedbackVarying(int program, int index, IntBuffer length, IntBuffer size, IntBuffer type, ByteBuffer name) {
		WebGLActiveInfo wai = ctx.getTransformFeedbackVarying((WebGLProgram) get(program).getObject(), index);
		length.put(wai.getSize());
		size.put(wai.getSize());
		type.put(wai.getType());
		name.asCharBuffer().put(wai.getName());
	}
	static native void nglGetTransformFeedbackVarying(int program, int index, int name_bufSize, long length, long size, long type, long name, long function_pointer);

	/** Overloads glGetTransformFeedbackVarying. */
	public static String glGetTransformFeedbackVarying(int program, int index, int bufSize, IntBuffer size, IntBuffer type) {
		WebGLActiveInfo wai = ctx.getTransformFeedbackVarying((WebGLProgram) get(program).getObject(), index);
		size.put(wai.getSize());
		type.put(wai.getType());
		
		return wai.getName();
	}

	public static void glBindVertexArray(int array) {
		ctx.bindVertexArray((WebGLVertexArrayObject) get(array).getObject());
	}
	static native void nglBindVertexArray(int array, long function_pointer);

	public static void glDeleteVertexArrays(IntBuffer arrays) {
		ctx.deleteVertexArray((WebGLVertexArrayObject) get(arrays.get()).getObject());
	}
	static native void nglDeleteVertexArrays(int arrays_n, long arrays, long function_pointer);

	/** Overloads glDeleteVertexArrays. */
	public static void glDeleteVertexArrays(int array) {
		ctx.deleteVertexArray((WebGLVertexArrayObject) get(array).getObject());
	}

	public static void glGenVertexArrays(IntBuffer arrays) {
		for (int i = 0; i < arrays.remaining(); i++) {
			arrays.put(glGenVertexArrays());
		}
	}
	static native void nglGenVertexArrays(int arrays_n, long arrays, long function_pointer);
	
	/** Overloads glGenVertexArrays. */
	public static int glGenVertexArrays() {
		return newObject(GL_OBJECT_VAOS, ctx.createVertexArray());
	}

	public static boolean glIsVertexArray(int array) {
		return get(array).getType() == GL_OBJECT_VAOS;
	}
	static native boolean nglIsVertexArray(int array, long function_pointer);
}
