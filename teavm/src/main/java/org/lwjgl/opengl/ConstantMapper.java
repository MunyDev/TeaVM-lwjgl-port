package org.lwjgl.opengl;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Consumer;

/**
 * BEFORE USING THIS <br />
 * SCOPES AND PREFIXES ARE BASED ON REAL OPENGL CONSTANTS, <b>NOT WEBGL CONSTANTS</b>
 * @author MunyDev
 *
 */
public class ConstantMapper {
	public static ConstantMapper cmFunc = new ConstantMapper(new String[] {
			"GL_NEVER",
			"GL_LESS",
			"GL_EQUAL",
			"GL_LEQUAL",
			"GL_GREATER",
			"GL_NOTEQUAL",
			"GL_GEQUAL",
			"GL_ALWAYS"
	});
//	public static ConstantMapper cmDraw = new ConstantMapper(new String[] {
//			"GL_POINTS",
//			"GL_LINES",
//			"GL_LINE_STRIP",
//			"GL_LINE_LOOP",
//			"GL_TRIANGLES",
//			"GL_TRIANGLE_STRIP",
//			"GL_TRIANGLE_FAN"
//	});
//
//	public static ConstantMapper cmTexTargets = new ConstantMapper(new String[] {
//			"GL_TEXTURE_1D", "GL_TEXTURE_2D", "GL_TEXTURE_3D", "GL_TEXTURE_1D_ARRAY", "GL_TEXTURE_2D_ARRAY", "GL_TEXTURE_RECTANGLE", "GL_TEXTURE_CUBE_MAP", "GL_TEXTURE_CUBE_MAP_ARRAY", "GL_TEXTURE_BUFFER", "GL_TEXTURE_2D_MULTISAMPLE", "GL_TEXTURE_2D_MULTISAMPLE_ARRAY"
//	});
//	public static ConstantMapper cmTexParams = new ConstantMapper(new String[] {
//			"GL_DEPTH_STENCIL_TEXTURE_MODE", 
//			"GL_IMAGE_FORMAT_COMPATIBILITY_TYPE", 
//			"GL_TEXTURE_BASE_LEVEL", 
//			"GL_TEXTURE_BORDER_COLOR", 
//			"GL_TEXTURE_COMPARE_MODE", 
//			"GL_TEXTURE_COMPARE_FUNC", 
//			"GL_TEXTURE_IMMUTABLE_FORMAT", 
//			"GL_TEXTURE_IMMUTABLE_LEVELS", 
//			"GL_TEXTURE_LOD_BIAS", 
//			"GL_TEXTURE_MAG_FILTER", 
//			"GL_TEXTURE_TARGET", 
//			"GL_TEXTURE_WRAP_S", 
//			"GL_TEXTURE_WRAP_T"
//	});
//	public static ConstantMapper cmAllTypes = new ConstantMapper(new String[] {
//			"GL_FLOAT",
//			"GL_FLOAT_VEC2",
//			"GL_FLOAT_VEC3",
//			"GL_FLOAT_VEC4",
//			"GL_DOUBLE",
//			"GL_DOUBLE_VEC2",
//			"GL_DOUBLE_VEC3",
//			"GL_DOUBLE_VEC4",
//			"GL_INT",
//			"GL_INT_VEC2",
//			"GL_INT_VEC3",
//			"GL_INT_VEC4",
//			"GL_UNSIGNED_INT",
//			"GL_UNSIGNED_INT_VEC2",
//			"GL_UNSIGNED_INT_VEC3",
//			"GL_UNSIGNED_INT_VEC4",
//			"GL_BOOL",
//			"GL_BOOL_VEC2",
//			"GL_BOOL_VEC3",
//			"GL_BOOL_VEC4",
//			"GL_FLOAT_MAT2",
//			"GL_FLOAT_MAT3",
//			"GL_FLOAT_MAT4",
//			"GL_FLOAT_MAT2x3",
//			"GL_FLOAT_MAT2x4",
//			"GL_FLOAT_MAT3x2",
//			"GL_FLOAT_MAT3x4",
//			"GL_FLOAT_MAT4x2",
//			"GL_FLOAT_MAT4x3",
//			"GL_DOUBLE_MAT2",
//			"GL_DOUBLE_MAT3",
//			"GL_DOUBLE_MAT4",
//			"GL_DOUBLE_MAT2x3",
//			"GL_DOUBLE_MAT2x4",
//			"GL_DOUBLE_MAT3x2",
//			"GL_DOUBLE_MAT3x4",
//			"GL_DOUBLE_MAT4x2",
//			"GL_DOUBLE_MAT4x3",
//			"GL_SAMPLER_1D",
//			"GL_SAMPLER_2D",
//			"GL_SAMPLER_3D",
//			"GL_SAMPLER_CUBE",
//			"GL_SAMPLER_1D_SHADOW",
//			"GL_SAMPLER_2D_SHADOW",
//			"GL_SAMPLER_1D_ARRAY",
//			"GL_SAMPLER_2D_ARRAY",
//			"GL_SAMPLER_1D_ARRAY_SHADOW",
//			"GL_SAMPLER_2D_ARRAY_SHADOW",
//			"GL_SAMPLER_2D_MULTISAMPLE",
//			"GL_SAMPLER_2D_MULTISAMPLE_ARRAY",
//			"GL_SAMPLER_CUBE_SHADOW",
//			"GL_SAMPLER_BUFFER",
//			"GL_SAMPLER_2D_RECT",
//			"GL_SAMPLER_2D_RECT_SHADOW",
//			"GL_INT_SAMPLER_1D",
//			"GL_INT_SAMPLER_2D",
//			"GL_INT_SAMPLER_3D",
//			"GL_INT_SAMPLER_CUBE",
//			"GL_INT_SAMPLER_1D_ARRAY",
//			"GL_INT_SAMPLER_2D_ARRAY",
//			"GL_INT_SAMPLER_2D_MULTISAMPLE",
//			"GL_INT_SAMPLER_2D_MULTISAMPLE_ARRAY",
//			"GL_INT_SAMPLER_BUFFER",
//			"GL_INT_SAMPLER_2D_RECT",
//			"GL_UNSIGNED_INT_SAMPLER_1D",
//			"GL_UNSIGNED_INT_SAMPLER_2D",
//			"GL_UNSIGNED_INT_SAMPLER_3D",
//			"GL_UNSIGNED_INT_SAMPLER_CUBE",
//			"GL_UNSIGNED_INT_SAMPLER_1D_ARRAY",
//			"GL_UNSIGNED_INT_SAMPLER_2D_ARRAY",
//			"GL_UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE",
//			"GL_UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE_ARRAY",
//			"GL_UNSIGNED_INT_SAMPLER_BUFFER",
//			"GL_UNSIGNED_INT_SAMPLER_2D_RECT",
//			"GL_IMAGE_1D",
//			"GL_IMAGE_2D",
//			"GL_IMAGE_3D",
//			"GL_IMAGE_2D_RECT",
//			"GL_IMAGE_CUBE",
//			"GL_IMAGE_BUFFER",
//			"GL_IMAGE_1D_ARRAY",
//			"GL_IMAGE_2D_ARRAY",
//			"GL_IMAGE_2D_MULTISAMPLE",
//			"GL_IMAGE_2D_MULTISAMPLE_ARRAY",
//			"GL_INT_IMAGE_1D",
//			"GL_INT_IMAGE_2D",
//			"GL_INT_IMAGE_3D",
//			"GL_INT_IMAGE_2D_RECT",
//			"GL_INT_IMAGE_CUBE",
//			"GL_INT_IMAGE_BUFFER",
//			"GL_INT_IMAGE_1D_ARRAY",
//			"GL_INT_IMAGE_2D_ARRAY",
//			"GL_INT_IMAGE_2D_MULTISAMPLE",
//			"GL_INT_IMAGE_2D_MULTISAMPLE_ARRAY",
//			"GL_UNSIGNED_INT_IMAGE_1D",
//			"GL_UNSIGNED_INT_IMAGE_2D",
//			"GL_UNSIGNED_INT_IMAGE_3D",
//			"GL_UNSIGNED_INT_IMAGE_2D_RECT",
//			"GL_UNSIGNED_INT_IMAGE_CUBE",
//			"GL_UNSIGNED_INT_IMAGE_BUFFER",
//			"GL_UNSIGNED_INT_IMAGE_1D_ARRAY",
//			"GL_UNSIGNED_INT_IMAGE_2D_ARRAY",
//			"GL_UNSIGNED_INT_IMAGE_2D_MULTISAMPLE",
//			"GL_UNSIGNED_INT_IMAGE_2D_MULTISAMPLE_ARRAY",
//			"GL_UNSIGNED_INT_ATOMIC_COUNTER",
//			"GL_FLOAT",
//			"GL_FLOAT_VEC2",
//			"GL_FLOAT_VEC3",
//			"GL_FLOAT_VEC4",
//			"GL_INT",
//			"GL_INT_VEC2",
//			"GL_INT_VEC3",
//			"GL_INT_VEC4",
//			"GL_BOOL",
//			"GL_BOOL_VEC2",
//			"GL_BOOL_VEC3",
//			"GL_BOOL_VEC4",
//			"GL_FLOAT_MAT2",
//			"GL_FLOAT_MAT3",
//			"GL_FLOAT_MAT4",
//			"GL_SAMPLER_2D",
//			"GL_SAMPLER_CUBE",
//			"GL_UNSIGNED_BYTE",
//			"GL_UNSIGNED_SHORT_5_6_5",
//			"GL_UNSIGNED_SHORT_4_4_4_4",
//			"GL_UNSIGNED_SHORT_5_5_5_1",
//			"GL_UNSIGNED_SHORT",
//			"GL_UNSIGNED_INT",
//	});
	
	public static ConstantMapper cmBufferBits = new ConstantMapper(new String[] {
			"GL_DEPTH_BUFFER_BIT",
			"GL_STENCIL_BUFFER_BIT",
			"GL_COLOR_BUFFER_BIT"
	});
	public static ConstantMapper cmRenderModes = new ConstantMapper(new String[] {
			"GL_POINTS",
			"GL_LINES",
			"GL_LINE_LOOP",
			"GL_LINE_STRIP",
			"GL_TRIANGLES",
			"GL_TRIANGLE_STRIP",
			"GL_TRIANGLE_FAN"
	});
	
	public static ConstantMapper cmBlendFuncEnums = new ConstantMapper(new String[] {
			"GL_ZERO",
			"GL_ONE",
			"GL_SRC_COLOR",
			"GL_ONE_MINUS_SRC_COLOR",
			"GL_SRC_ALPHA",
			"GL_ONE_MINUS_SRC_ALPHA",
			"GL_DST_ALPHA",
			"GL_ONE_MINUS_DST_ALPHA",
			"GL_DST_COLOR",
			"GL_ONE_MINUS_DST_COLOR",
			"GL_SRC_ALPHA_SATURATE",
			"GL_CONSTANT_COLOR",
			"GL_ONE_MINUS_CONSTANT_COLOR",
			"GL_CONSTANT_ALPHA",
			"GL_ONE_MINUS_CONSTANT_ALPHA"
	});
	public static ConstantMapper cmOperatorsFuncExt = new ConstantMapper(new String[] {
			"GL_FUNC_ADD",
			"GL_FUNC_SUBTRACT",
			"GL_FUNC_REVERSE_SUBTRACT"
	});
	public static ConstantMapper cmGLParamsInfo = new ConstantMapper(new String[] {
			"GL_BLEND_EQUATION",
			"GL_BLEND_EQUATION_RGB",
			"GL_BLEND_EQUATION_ALPHA",
			"GL_BLEND_DST_RGB",
			"GL_BLEND_SRC_RGB",
			"GL_BLEND_DST_ALPHA",
			"GL_BLEND_SRC_ALPHA",
			"GL_BLEND_COLOR",
			"GL_ARRAY_BUFFER_BINDING",
			"GL_ELEMENT_ARRAY_BUFFER_BINDING",
			"GL_LINE_WIDTH",
			"GL_ALIASED_POINT_SIZE_RANGE",
			"GL_ALIASED_LINE_WIDTH_RANGE",
			"GL_CULL_FACE_MODE",
			"GL_FRONT_FACE",
			"GL_DEPTH_RANGE",
			"GL_DEPTH_WRITEMASK",
			"GL_DEPTH_CLEAR_VALUE",
			"GL_DEPTH_FUNC",
			"GL_STENCIL_CLEAR_VALUE",
			"GL_STENCIL_FUNC",
			"GL_STENCIL_FAIL",
			"GL_STENCIL_PASS_DEPTH_FAIL",
			"GL_STENCIL_PASS_DEPTH_PASS",
			"GL_STENCIL_REF",
			"GL_STENCIL_VALUE_MASK",
			"GL_STENCIL_WRITEMASK",
			"GL_STENCIL_BACK_FUNC",
			"GL_STENCIL_BACK_FAIL",
			"GL_STENCIL_BACK_PASS_DEPTH_FAIL",
			"GL_STENCIL_BACK_PASS_DEPTH_PASS",
			"GL_STENCIL_BACK_REF",
			"GL_STENCIL_BACK_VALUE_MASK",
			"GL_STENCIL_BACK_WRITEMASK",
			"GL_VIEWPORT",
			"GL_SCISSOR_BOX",
			"GL_COLOR_CLEAR_VALUE",
			"GL_COLOR_WRITEMASK",
			"GL_UNPACK_ALIGNMENT",
			"GL_PACK_ALIGNMENT",
			"GL_MAX_TEXTURE_SIZE",
			"GL_MAX_VIEWPORT_DIMS",
			"GL_SUBPIXEL_BITS",
			"GL_RED_BITS",
			"GL_GREEN_BITS",
			"GL_BLUE_BITS",
			"GL_ALPHA_BITS",
			"GL_DEPTH_BITS",
			"GL_STENCIL_BITS",
			"GL_POLYGON_OFFSET_UNITS",
			"GL_POLYGON_OFFSET_FACTOR",
			"GL_TEXTURE_BINDING_2D",
			"GL_SAMPLE_BUFFERS",
			"GL_SAMPLES",
			"GL_SAMPLE_COVERAGE_VALUE",
			"GL_SAMPLE_COVERAGE_INVERT",
			"GL_COMPRESSED_TEXTURE_FORMATS",
			"GL_VENDOR",
			"GL_RENDERER",
			"GL_VERSION",
			"GL_IMPLEMENTATION_COLOR_READ_TYPE",
			"GL_IMPLEMENTATION_COLOR_READ_FORMAT",
			//WebGL 2 Parameters
			
			"GL_READ_BUFFER",
			"GL_UNPACK_ROW_LENGTH",
			"GL_UNPACK_SKIP_ROWS",
			"GL_UNPACK_SKIP_PIXELS",
			"GL_PACK_ROW_LENGTH",
			"GL_PACK_SKIP_ROWS",
			"GL_PACK_SKIP_PIXELS",
			"GL_TEXTURE_BINDING_3D",
			"GL_UNPACK_SKIP_IMAGES",
			"GL_UNPACK_IMAGE_HEIGHT",
			"GL_MAX_3D_TEXTURE_SIZE",
			"GL_MAX_ELEMENTS_VERTICES",
			"GL_MAX_ELEMENTS_INDICES",
			"GL_MAX_TEXTURE_LOD_BIAS",
			"GL_MAX_FRAGMENT_UNIFORM_COMPONENTS",
			"GL_MAX_VERTEX_UNIFORM_COMPONENTS",
			"GL_MAX_ARRAY_TEXTURE_LAYERS",
			"GL_MIN_PROGRAM_TEXEL_OFFSET",
			"GL_MAX_PROGRAM_TEXEL_OFFSET",
			"GL_MAX_VARYING_COMPONENTS",
			"GL_FRAGMENT_SHADER_DERIVATIVE_HINT",
			"GL_RASTERIZER_DISCARD",
			"GL_VERTEX_ARRAY_BINDING",
			"GL_MAX_VERTEX_OUTPUT_COMPONENTS",
			"GL_MAX_FRAGMENT_INPUT_COMPONENTS",
			"GL_MAX_SERVER_WAIT_TIMEOUT",
			"GL_MAX_ELEMENT_INDEX"
			
	});
	public static ConstantMapper cmStencilActions = new ConstantMapper(new String[] {
			"GL_KEEP",
			"GL_REPLACE",
			"GL_INCR",
			"GL_DECR",
			"GL_INVERT",
			"GL_INCR_WRAP",
			"GL_DECR_WRAP"
			
			//WebGL2 Constants(NONE)
			
	});
	public static ConstantMapper cmBuffers = new ConstantMapper(new String[] {
			"GL_STATIC_DRAW",
			"GL_STREAM_DRAW",
			"GL_DYNAMIC_DRAW",
			"GL_ARRAY_BUFFER",
			"GL_ELEMENT_ARRAY_BUFFER",
			"GL_BUFFER_SIZE",
			"GL_BUFFER_USAGE",
			//WebGL2 Constants(REMOVE IF YOU CHOOSE)
			
			"GL_PIXEL_PACK_BUFFER",
			"GL_PIXEL_UNPACK_BUFFER",
			"GL_PIXEL_PACK_BUFFER_BINDING",
			"GL_PIXEL_UNPACK_BUFFER_BINDING",
			"GL_COPY_READ_BUFFER",
			"GL_COPY_WRITE_BUFFER",
			"GL_COPY_READ_BUFFER_BINDING"
	});
	public static ConstantMapper cmGetVertexAttrib = new ConstantMapper(new String[] {
			"GL_CURRENT_VERTEX_ATTRIB",
			"GL_VERTEX_ATTRIB_ARRAY_ENABLED",
			"GL_VERTEX_ATTRIB_ARRAY_SIZE",
			"GL_VERTEX_ATTRIB_ARRAY_STRIDE",
			"GL_VERTEX_ATTRIB_ARRAY_TYPE",
			"GL_VERTEX_ATTRIB_ARRAY_NORMALIZED",
			"GL_VERTEX_ATTRIB_ARRAY_POINTER",
			"GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING"
	});
	public static ConstantMapper cmCullFace = new ConstantMapper(new String[] {
			"GL_CULL_FACE",
			"GL_FRONT",
			"GL_BACK",
			"GL_FRONT_AND_BACK"	
	});
	public static ConstantMapper cmEnableDisable = new ConstantMapper(new String[] {
			"GL_BLEND",
			"GL_DEPTH_TEST",
			"GL_DITHER",
			"GL_POLYGON_OFFSET_FILL",
			"GL_SAMPLE_ALPHA_TO_COVERAGE",
			"GL_SAMPLE_COVERAGE",
			"GL_SCISSOR_TEST",
			"GL_STENCIL_TEST"
	});
	public static ConstantMapper cmGetError = new ConstantMapper(new String[] {
			"GL_NO_ERROR",
			"GL_INVALID_ENUM",
			"GL_INVALID_VALUE",
			"GL_INVALID_OPERATION",
			"GL_OUT_OF_MEMORY",
			"GL_CONTEXT_LOST_WEBGL"	
	});
	public static ConstantMapper cmFrontFace = new ConstantMapper(new String[] {
			"GL_CW",
			"GL_CCW"
	});
	public static ConstantMapper cmHint = new ConstantMapper(new String[] {
			"GL_DONT_CARE",
			"GL_FASTEST",
			"GL_NICEST",
			"GL_GENERATE_MIPMAP_HINT"
	});
	public static ConstantMapper cmDataTypes = new ConstantMapper(new String[] {
			"GL_BYTE",
			"GL_UNSIGNED_BYTE",
			"GL_SHORT",
			"GL_UNSIGNED_SHORT",
			"GL_INT",
			"GL_UNSIGNED_INT",
			"GL_FLOAT"
	});
	public static ConstantMapper cmPixelFormatConstants = new ConstantMapper(new String[] {
			"GL_DEPTH_COMPONENT",
			"GL_ALPHA",
			"GL_RGB",
			"GL_RGBA",
			"GL_LUMINANCE",
			"GL_LUMINANCE_ALPHA"
	});
	public static ConstantMapper cmPixelTypes = new ConstantMapper(new String[] {
			"GL_UNSIGNED_BYTE",
			"GL_UNSIGNED_SHORT_4_4_4_4",
			"GL_UNSIGNED_SHORT_5_5_5_1",
			"GL_UNSIGNED_SHORT_5_6_5",
			//WebGL 2 Pixel Types
			"GL_UNSIGNED_INT_2_10_10_10_REV",
			"GL_UNSIGNED_INT_10F_11F_11F_REV",
			"GL_UNSIGNED_INT_5_9_9_9_REV",
			"GL_FLOAT_32_UNSIGNED_INT_24_8_REV",
			"GL_UNSIGNED_INT_24_8",
			"GL_HALF_FLOAT",
			"GL_RG",
			"GL_RG_INTEGER",
			"GL_INT_2_10_10_10_REV"
	});
	public static ConstantMapper cmTexture = new ConstantMapper(new String[] {
			"GL_NEAREST",
			"GL_LINEAR",
			"GL_NEAREST_MIPMAP_NEAREST",
			"GL_LINEAR_MIPMAP_NEAREST",
			"GL_NEAREST_MIPMAP_LINEAR",
			"GL_LINEAR_MIPMAP_LINEAR",
			"GL_TEXTURE_MAG_FILTER",
			"GL_TEXTURE_MIN_FILTER",
			"GL_TEXTURE_WRAP_S",
			"GL_TEXTURE_WRAP_T",
			"GL_TEXTURE_2D",
			"GL_TEXTURE",
			"GL_TEXTURE_CUBE_MAP",
			"GL_TEXTURE_BINDING_CUBE_MAP",
			"GL_TEXTURE_CUBE_MAP_POSITIVE_X",
			"GL_TEXTURE_CUBE_MAP_NEGATIVE_X",
			"GL_TEXTURE_CUBE_MAP_POSITIVE_Y",
			"GL_TEXTURE_CUBE_MAP_NEGATIVE_Y",
			"GL_TEXTURE_CUBE_MAP_POSITIVE_Z",
			"GL_TEXTURE_CUBE_MAP_NEGATIVE_Z",
			"GL_MAX_CUBE_MAP_TEXTURE_SIZE",
			"GL_TEXTURE0",
			"GL_TEXTURE1",
			"GL_TEXTURE2",
			"GL_TEXTURE3",
			"GL_TEXTURE4",
			"GL_TEXTURE5",
			"GL_TEXTURE6",
			"GL_TEXTURE7",
			"GL_TEXTURE8",
			"GL_TEXTURE9",
			"GL_TEXTURE10",
			"GL_TEXTURE11",
			"GL_TEXTURE12",
			"GL_TEXTURE13",
			"GL_TEXTURE14",
			"GL_TEXTURE15",
			"GL_TEXTURE16",
			"GL_TEXTURE17",
			"GL_TEXTURE18",
			"GL_TEXTURE19",
			"GL_TEXTURE20",
			"GL_TEXTURE21",
			"GL_TEXTURE22",
			"GL_TEXTURE23",
			"GL_TEXTURE24",
			"GL_TEXTURE25",
			"GL_TEXTURE26",
			"GL_TEXTURE27",
			"GL_TEXTURE28",
			"GL_TEXTURE29",
			"GL_TEXTURE30",
			"GL_TEXTURE31",
			"GL_ACTIVE_TEXTURE",
			"GL_REPEAT",
			"GL_CLAMP_TO_EDGE",
			"GL_MIRRORED_REPEAT",
			//WebGL2
			"GL_RED",
			"GL_RGB8",
			"GL_RGBA8",
			"GL_RGB10_A2",
			"GL_TEXTURE_3D",
			"GL_TEXTURE_WRAP_R",
			"GL_TEXTURE_MIN_LOD",
			"GL_TEXTURE_MAX_LOD",
			"GL_TEXTURE_BASE_LEVEL",
			"GL_TEXTURE_MAX_LEVEL",
			"GL_TEXTURE_COMPARE_MODE",
			"GL_TEXTURE_COMPARE_FUNC",
			"GL_SRGB",
			"GL_SRGB8",
			"GL_SRGB8_ALPHA8",
			"GL_COMPARE_REF_TO_TEXTURE",
			"GL_RGBA32F",
			"GL_RGB32F",
			"GL_RGBA16F",
			"GL_RGB16F",
			"GL_TEXTURE_2D_ARRAY",
			"GL_TEXTURE_BINDING_2D_ARRAY",
			"GL_R11F_G11F_B10F",
			"GL_RGB9_E5",
			"GL_RGBA32UI",
			"GL_RGB32UI",
			"GL_RGBA16UI",
			"GL_RGB16UI",
			"GL_RGBA8UI",
			"GL_RGB8UI",
			"GL_RGBA32I",
			"GL_RGB32I",
			"GL_RGBA16I",
			"GL_RGB16I",
			"GL_RGBA8I",
			"GL_RGB8I",
			"GL_RED_INTEGER",
			"GL_RGB_INTEGER",
			"GL_RGBA_INTEGER",
			"GL_R8",
			"GL_RG8",
			"GL_R16F",
			"GL_R32F",
			"GL_RG16F",
			"GL_RG32F",
			"GL_R8I",
			"GL_R8UI",
			"GL_R16I",
			"GL_R16UI",
			"GL_R32I",
			"GL_R32UI",
			"GL_RG8I",
			"GL_RG8UI",
			"GL_RG16I",
			"GL_RG16UI",
			"GL_RG32I",
			"GL_RG32UI",
			"GL_R8_SNORM",
			"GL_RG8_SNORM",
			"GL_RGB8_SNORM",
			"GL_RGBA8_SNORM",
			"GL_RGB10_A2UI",
			"GL_TEXTURE_IMMUTABLE_FORMAT",
			"GL_TEXTURE_IMMUTABLE_LEVELS",
	});
	public static ConstantMapper cmSamplers = new ConstantMapper(new String[] {
			"GL_SAMPLER_3D",
			"GL_SAMPLER_2D_SHADOW",
			"GL_SAMPLER_2D_ARRAY",
			"GL_SAMPLER_2D_ARRAY_SHADOW",
			"GL_SAMPLER_CUBE_SHADOW",
			"GL_INT_SAMPLER_2D",
			"GL_INT_SAMPLER_3D",
			"GL_INT_SAMPLER_CUBE",
			"GL_INT_SAMPLER_2D_ARRAY",
			"GL_UNSIGNED_INT_SAMPLER_2D",
			"GL_UNSIGNED_INT_SAMPLER_3D",
			"GL_UNSIGNED_INT_SAMPLER_CUBE",
			"GL_UNSIGNED_INT_SAMPLER_2D_ARRAY",
			"GL_MAX_SAMPLES",
			"GL_SAMPLER_BINDING"
	});
	public static ConstantMapper cmUniformTypes = new ConstantMapper(new String[] {
			"GL_FLOAT_VEC2",
			"GL_FLOAT_VEC3",
			"GL_FLOAT_VEC4",
			"GL_INT_VEC2",
			"GL_INT_VEC3",
			"GL_INT_VEC4",
			"GL_BOOL",
			"GL_BOOL_VEC2",
			"GL_BOOL_VEC3",
			"GL_BOOL_VEC4",
			"GL_FLOAT_MAT2",
			"GL_FLOAT_MAT3",
			"GL_FLOAT_MAT4",
			"GL_SAMPLER_2D",
			"GL_SAMPLER_CUBE",
			
			
			
			
	});
	public static ConstantMapper cmQuery = new ConstantMapper(new String[] {
			"GL_CURRENT_QUERY",
			"GL_QUERY_RESULT",
			"GL_QUERY_RESULT_AVAILABLE",
			"GL_ANY_SAMPLES_PASSED",
			"GL_ANY_SAMPLES_PASSED_CONSERVATIVE"
	});
	public static ConstantMapper cmShaderTypes = new ConstantMapper(new String[] {
			"GL_LOW_FLOAT",
			"GL_MEDIUM_FLOAT",
			"GL_HIGH_FLOAT",
			"GL_LOW_INT",
			"GL_MEDIUM_INT",
			"GL_HIGH_INT"
	});
	public static ConstantMapper cmShader = new ConstantMapper(new String[] {
			"GL_FRAGMENT_SHADER",
			"GL_VERTEX_SHADER",
			"GL_COMPILE_STATUS",
			"GL_DELETE_STATUS",
			"GL_LINK_STATUS",
			"GL_VALIDATE_STATUS",
			"GL_ATTACHED_SHADERS",
			"GL_ACTIVE_ATTRIBUTES",
			"GL_ACTIVE_UNIFORMS",
			"GL_MAX_VERTEX_ATTRIBS",
			"GL_MAX_VERTEX_UNIFORM_VECTORS",
			"GL_MAX_VARYING_VECTORS",
			"GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS",
			"GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS",
			"GL_MAX_TEXTURE_IMAGE_UNITS",
			"GL_MAX_FRAGMENT_UNIFORM_VECTORS",
			"GL_SHADER_TYPE",
			"GL_SHADING_LANGUAGE_VERSION",
			"GL_CURRENT_PROGRAM"
	});
	public static ConstantMapper cmFramebuffer = new ConstantMapper(new String[] {
			"GL_FRAMEBUFFER",
			"GL_RENDERBUFFER",
			"GL_RGBA4",
			"GL_RGB5_A1",
			"GL_RGB565",
			"GL_DEPTH_COMPONENT16",
			"GL_STENCIL_INDEX8",
			"GL_DEPTH_STENCIL",
			"GL_RENDERBUFFER_WIDTH",
			"GL_RENDERBUFFER_HEIGHT",
			"GL_RENDERBUFFER_INTERNAL_FORMAT",
			"GL_RENDERBUFFER_RED_SIZE",
			"GL_RENDERBUFFER_GREEN_SIZE",
			"GL_RENDERBUFFER_BLUE_SIZE",
			"GL_RENDERBUFFER_ALPHA_SIZE",
			"GL_RENDERBUFFER_DEPTH_SIZE",
			"GL_RENDERBUFFER_STENCIL_SIZE",
			"GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE",
			"GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME",
			"GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL",
			"GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE",
			"GL_COLOR_ATTACHMENT0",
			"GL_DEPTH_ATTACHMENT",
			"GL_STENCIL_ATTACHMENT",
			"GL_DEPTH_STENCIL_ATTACHMENT",
			"GL_NONE",
			"GL_FRAMEBUFFER_COMPLETE",
			"GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT",
			"GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT",
			"GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS",
			"GL_FRAMEBUFFER_UNSUPPORTED",
			"GL_FRAMEBUFFER_BINDING",
			"GL_RENDERBUFFER_BINDING",
			"GL_MAX_RENDERBUFFER_SIZE",
			"GL_INVALID_FRAMEBUFFER_OPERATION"
	});
	public static ConstantMapper cmDrawBuffers = new ConstantMapper(new String[] {
			"GL_MAX_DRAW_BUFFERS",
			"GL_DRAW_BUFFER0",
			"GL_DRAW_BUFFER1",
			"GL_DRAW_BUFFER2",
			"GL_DRAW_BUFFER3",
			"GL_DRAW_BUFFER4",
			"GL_DRAW_BUFFER5",
			"GL_DRAW_BUFFER6",
			"GL_DRAW_BUFFER7",
			"GL_DRAW_BUFFER8",
			"GL_DRAW_BUFFER9",
			"GL_DRAW_BUFFER10",
			"GL_DRAW_BUFFER11",
			"GL_DRAW_BUFFER12",
			"GL_DRAW_BUFFER13",
			"GL_DRAW_BUFFER14",
			"GL_DRAW_BUFFER15",
			"GL_MAX_COLOR_ATTACHMENTS",
			"GL_COLOR_ATTACHMENT1",
			"GL_COLOR_ATTACHMENT2",
			"GL_COLOR_ATTACHMENT3",
			"GL_COLOR_ATTACHMENT4",
			"GL_COLOR_ATTACHMENT5",
			"GL_COLOR_ATTACHMENT6",
			"GL_COLOR_ATTACHMENT7",
			"GL_COLOR_ATTACHMENT8",
			"GL_COLOR_ATTACHMENT9",
			"GL_COLOR_ATTACHMENT10",
			"GL_COLOR_ATTACHMENT11",
			"GL_COLOR_ATTACHMENT12",
			"GL_COLOR_ATTACHMENT13",
			"GL_COLOR_ATTACHMENT14",
			"GL_COLOR_ATTACHMENT15"
	});
	private enum ConstantMapperOptions{
		USE_PREFIX, USE_SCOPE
	}
	public ConstantMapperOptions opt;
//	private Object data;
	private Map<Integer, String> subsetOpengl;
//	private Map<String, String> subsetBridge;
	private Map<Integer, String> subsetWGL;
	
	
	
	/**
	 * Clearly obvious. This constructor sets up the ConstantMapper to work with a SCOPE. It is much better if you use the predefined constant mappers.
	 *  
	 * @param scopes
	 */
	@SuppressWarnings("unlikely-arg-type")
	public ConstantMapper(String scopes[]) {
		this.opt = ConstantMapperOptions.USE_SCOPE;
//		this.data = scopes;
		
		Map<String, Integer> opengl = BridgeConstants.m;
		subsetOpengl = new HashMap<Integer, String>();
		for (String s : scopes) {
			//We throw an exception if it is not unique
			if (subsetOpengl.containsKey(s))
				throw new IllegalStateException("Make sure your scopes have its values be unique");
			if (!BridgeConstants.ogltowgl.containsKey(s)) continue;
			subsetOpengl.put(opengl.get(s), s);
			String x =  BridgeConstants.ogltowgl.get(s);
			subsetWGL.put(BridgeConstants.wgl.get(x), x);
		}
		
		
	}
	public ConstantMapper(String prefix) {
		this.opt = ConstantMapperOptions.USE_PREFIX;
//		this.data = prefix;
		Map<String, Integer> opengl = BridgeConstants.m;
		subsetOpengl = new HashMap<Integer, String>();
		
		opengl.entrySet().forEach(new Consumer<Map.Entry<String, Integer>>() {

			@Override
			public void accept(Entry<String, Integer> t) {
				// TODO Auto-generated method stub
				String s = t.getKey();
				int i = t.getValue();
				
				//Check if it fits the criteria
				if (s.startsWith(prefix)) {
					subsetOpengl.put(i, s);
				}
			}
			
		});
	}
	public String[] getScopeList() {
		return (String[]) subsetOpengl.values().toArray();
	}
	public int mapRealToWebGL(int i) {
		if (!subsetOpengl.containsKey(i)) return -1;
		String name = subsetOpengl.get(i); 
		
		Map<String, String> ogltowgl = BridgeConstants.ogltowgl;
		if ( BridgeConstants.wgl.get(ogltowgl.get(name)) != null) {
			return BridgeConstants.wgl.get(ogltowgl.get(name));
		}
		else {
			return -1;
		}
	}
	public int mapWebGLToReal(int i) {
		String s= subsetWGL.get(i);
		Map<String, String> ogltowgl = BridgeConstants.ogltowgl;
		
		for (Map.Entry<String, String> ent : ogltowgl.entrySet()) {
			if (s == ent.getValue()) return BridgeConstants.m.get(ent.getKey());
		}
		return -1;
	}
	
}
