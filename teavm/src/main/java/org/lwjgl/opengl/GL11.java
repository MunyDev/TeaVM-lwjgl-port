package org.lwjgl.opengl;

import org.munydev.teavm.lwjgl.CurrentContext;
import org.teavm.jso.core.JSArray;
import org.teavm.jso.core.JSBoolean;
import org.teavm.jso.core.JSNumber;
import org.teavm.jso.typedarrays.DataView;
import org.teavm.jso.typedarrays.Float32Array;
import org.teavm.jso.typedarrays.Int8Array;
import org.teavm.jso.typedarrays.Uint8Array;
import org.teavm.jso.typedarrays.Uint8ClampedArray;
import org.teavm.jso.webgl.WebGLFramebuffer;
import org.teavm.jso.webgl.WebGLRenderingContext;
import org.teavm.jso.webgl.WebGLShader;
import org.teavm.jso.webgl.WebGLTexture;
import org.teavm.webgl2.WebGL2RenderingContext;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.RealOGLConstants;
import org.lwjgl.util.GLUtil;
import org.teavm.jso.*;
/**
 * This class attempts to simulate the LWJGL2/LWJGL3 GL11 class
 * @author MunyDev
 *
 */
public class GL11 {
	public static final int GL_ACCUM = 0x100,
			GL_LOAD = 0x101,
			GL_RETURN = 0x102,
			GL_MULT = 0x103,
			GL_ADD = 0x104,
			GL_NEVER = 0x200,
			GL_LESS = 0x201,
			GL_EQUAL = 0x202,
			GL_LEQUAL = 0x203,
			GL_GREATER = 0x204,
			GL_NOTEQUAL = 0x205,
			GL_GEQUAL = 0x206,
			GL_ALWAYS = 0x207,
			GL_CURRENT_BIT = 0x1,
			GL_POINT_BIT = 0x2,
			GL_LINE_BIT = 0x4,
			GL_POLYGON_BIT = 0x8,
			GL_POLYGON_STIPPLE_BIT = 0x10,
			GL_PIXEL_MODE_BIT = 0x20,
			GL_LIGHTING_BIT = 0x40,
			GL_FOG_BIT = 0x80,
			GL_DEPTH_BUFFER_BIT = 0x100,
			GL_ACCUM_BUFFER_BIT = 0x200,
			GL_STENCIL_BUFFER_BIT = 0x400,
			GL_VIEWPORT_BIT = 0x800,
			GL_TRANSFORM_BIT = 0x1000,
			GL_ENABLE_BIT = 0x2000,
			GL_COLOR_BUFFER_BIT = 0x4000,
			GL_HINT_BIT = 0x8000,
			GL_EVAL_BIT = 0x10000,
			GL_LIST_BIT = 0x20000,
			GL_TEXTURE_BIT = 0x40000,
			GL_SCISSOR_BIT = 0x80000,
			GL_ALL_ATTRIB_BITS = 0xFFFFF,
			GL_POINTS = 0x0,
			GL_LINES = 0x1,
			GL_LINE_LOOP = 0x2,
			GL_LINE_STRIP = 0x3,
			GL_TRIANGLES = 0x4,
			GL_TRIANGLE_STRIP = 0x5,
			GL_TRIANGLE_FAN = 0x6,
			GL_QUADS = 0x7,
			GL_QUAD_STRIP = 0x8,
			GL_POLYGON = 0x9,
			GL_ZERO = 0x0,
			GL_ONE = 0x1,
			GL_SRC_COLOR = 0x300,
			GL_ONE_MINUS_SRC_COLOR = 0x301,
			GL_SRC_ALPHA = 0x302,
			GL_ONE_MINUS_SRC_ALPHA = 0x303,
			GL_DST_ALPHA = 0x304,
			GL_ONE_MINUS_DST_ALPHA = 0x305,
			GL_DST_COLOR = 0x306,
			GL_ONE_MINUS_DST_COLOR = 0x307,
			GL_SRC_ALPHA_SATURATE = 0x308,
			GL_CONSTANT_COLOR = 0x8001,
			GL_ONE_MINUS_CONSTANT_COLOR = 0x8002,
			GL_CONSTANT_ALPHA = 0x8003,
			GL_ONE_MINUS_CONSTANT_ALPHA = 0x8004,
			GL_TRUE = 0x1,
			GL_FALSE = 0x0,
			GL_CLIP_PLANE0 = 0x3000,
			GL_CLIP_PLANE1 = 0x3001,
			GL_CLIP_PLANE2 = 0x3002,
			GL_CLIP_PLANE3 = 0x3003,
			GL_CLIP_PLANE4 = 0x3004,
			GL_CLIP_PLANE5 = 0x3005,
			GL_BYTE = 0x1400,
			GL_UNSIGNED_BYTE = 0x1401,
			GL_SHORT = 0x1402,
			GL_UNSIGNED_SHORT = 0x1403,
			GL_INT = 0x1404,
			GL_UNSIGNED_INT = 0x1405,
			GL_FLOAT = 0x1406,
			GL_2_BYTES = 0x1407,
			GL_3_BYTES = 0x1408,
			GL_4_BYTES = 0x1409,
			GL_DOUBLE = 0x140A,
			GL_NONE = 0x0,
			GL_FRONT_LEFT = 0x400,
			GL_FRONT_RIGHT = 0x401,
			GL_BACK_LEFT = 0x402,
			GL_BACK_RIGHT = 0x403,
			GL_FRONT = 0x404,
			GL_BACK = 0x405,
			GL_LEFT = 0x406,
			GL_RIGHT = 0x407,
			GL_FRONT_AND_BACK = 0x408,
			GL_AUX0 = 0x409,
			GL_AUX1 = 0x40A,
			GL_AUX2 = 0x40B,
			GL_AUX3 = 0x40C,
			GL_NO_ERROR = 0x0,
			GL_INVALID_ENUM = 0x500,
			GL_INVALID_VALUE = 0x501,
			GL_INVALID_OPERATION = 0x502,
			GL_STACK_OVERFLOW = 0x503,
			GL_STACK_UNDERFLOW = 0x504,
			GL_OUT_OF_MEMORY = 0x505,
			GL_2D = 0x600,
			GL_3D = 0x601,
			GL_3D_COLOR = 0x602,
			GL_3D_COLOR_TEXTURE = 0x603,
			GL_4D_COLOR_TEXTURE = 0x604,
			GL_PASS_THROUGH_TOKEN = 0x700,
			GL_POINT_TOKEN = 0x701,
			GL_LINE_TOKEN = 0x702,
			GL_POLYGON_TOKEN = 0x703,
			GL_BITMAP_TOKEN = 0x704,
			GL_DRAW_PIXEL_TOKEN = 0x705,
			GL_COPY_PIXEL_TOKEN = 0x706,
			GL_LINE_RESET_TOKEN = 0x707,
			GL_EXP = 0x800,
			GL_EXP2 = 0x801,
			GL_CW = 0x900,
			GL_CCW = 0x901,
			GL_COEFF = 0xA00,
			GL_ORDER = 0xA01,
			GL_DOMAIN = 0xA02,
			GL_CURRENT_COLOR = 0xB00,
			GL_CURRENT_INDEX = 0xB01,
			GL_CURRENT_NORMAL = 0xB02,
			GL_CURRENT_TEXTURE_COORDS = 0xB03,
			GL_CURRENT_RASTER_COLOR = 0xB04,
			GL_CURRENT_RASTER_INDEX = 0xB05,
			GL_CURRENT_RASTER_TEXTURE_COORDS = 0xB06,
			GL_CURRENT_RASTER_POSITION = 0xB07,
			GL_CURRENT_RASTER_POSITION_VALID = 0xB08,
			GL_CURRENT_RASTER_DISTANCE = 0xB09,
			GL_POINT_SMOOTH = 0xB10,
			GL_POINT_SIZE = 0xB11,
			GL_POINT_SIZE_RANGE = 0xB12,
			GL_POINT_SIZE_GRANULARITY = 0xB13,
			GL_LINE_SMOOTH = 0xB20,
			GL_LINE_WIDTH = 0xB21,
			GL_LINE_WIDTH_RANGE = 0xB22,
			GL_LINE_WIDTH_GRANULARITY = 0xB23,
			GL_LINE_STIPPLE = 0xB24,
			GL_LINE_STIPPLE_PATTERN = 0xB25,
			GL_LINE_STIPPLE_REPEAT = 0xB26,
			GL_LIST_MODE = 0xB30,
			GL_MAX_LIST_NESTING = 0xB31,
			GL_LIST_BASE = 0xB32,
			GL_LIST_INDEX = 0xB33,
			GL_POLYGON_MODE = 0xB40,
			GL_POLYGON_SMOOTH = 0xB41,
			GL_POLYGON_STIPPLE = 0xB42,
			GL_EDGE_FLAG = 0xB43,
			GL_CULL_FACE = 0xB44,
			GL_CULL_FACE_MODE = 0xB45,
			GL_FRONT_FACE = 0xB46,
			GL_LIGHTING = 0xB50,
			GL_LIGHT_MODEL_LOCAL_VIEWER = 0xB51,
			GL_LIGHT_MODEL_TWO_SIDE = 0xB52,
			GL_LIGHT_MODEL_AMBIENT = 0xB53,
			GL_SHADE_MODEL = 0xB54,
			GL_COLOR_MATERIAL_FACE = 0xB55,
			GL_COLOR_MATERIAL_PARAMETER = 0xB56,
			GL_COLOR_MATERIAL = 0xB57,
			GL_FOG = 0xB60,
			GL_FOG_INDEX = 0xB61,
			GL_FOG_DENSITY = 0xB62,
			GL_FOG_START = 0xB63,
			GL_FOG_END = 0xB64,
			GL_FOG_MODE = 0xB65,
			GL_FOG_COLOR = 0xB66,
			GL_DEPTH_RANGE = 0xB70,
			GL_DEPTH_TEST = 0xB71,
			GL_DEPTH_WRITEMASK = 0xB72,
			GL_DEPTH_CLEAR_VALUE = 0xB73,
			GL_DEPTH_FUNC = 0xB74,
			GL_ACCUM_CLEAR_VALUE = 0xB80,
			GL_STENCIL_TEST = 0xB90,
			GL_STENCIL_CLEAR_VALUE = 0xB91,
			GL_STENCIL_FUNC = 0xB92,
			GL_STENCIL_VALUE_MASK = 0xB93,
			GL_STENCIL_FAIL = 0xB94,
			GL_STENCIL_PASS_DEPTH_FAIL = 0xB95,
			GL_STENCIL_PASS_DEPTH_PASS = 0xB96,
			GL_STENCIL_REF = 0xB97,
			GL_STENCIL_WRITEMASK = 0xB98,
			GL_MATRIX_MODE = 0xBA0,
			GL_NORMALIZE = 0xBA1,
			GL_VIEWPORT = 0xBA2,
			GL_MODELVIEW_STACK_DEPTH = 0xBA3,
			GL_PROJECTION_STACK_DEPTH = 0xBA4,
			GL_TEXTURE_STACK_DEPTH = 0xBA5,
			GL_MODELVIEW_MATRIX = 0xBA6,
			GL_PROJECTION_MATRIX = 0xBA7,
			GL_TEXTURE_MATRIX = 0xBA8,
			GL_ATTRIB_STACK_DEPTH = 0xBB0,
			GL_CLIENT_ATTRIB_STACK_DEPTH = 0xBB1,
			GL_ALPHA_TEST = 0xBC0,
			GL_ALPHA_TEST_FUNC = 0xBC1,
			GL_ALPHA_TEST_REF = 0xBC2,
			GL_DITHER = 0xBD0,
			GL_BLEND_DST = 0xBE0,
			GL_BLEND_SRC = 0xBE1,
			GL_BLEND = 0xBE2,
			GL_LOGIC_OP_MODE = 0xBF0,
			GL_INDEX_LOGIC_OP = 0xBF1,
			GL_COLOR_LOGIC_OP = 0xBF2,
			GL_AUX_BUFFERS = 0xC00,
			GL_DRAW_BUFFER = 0xC01,
			GL_READ_BUFFER = 0xC02,
			GL_SCISSOR_BOX = 0xC10,
			GL_SCISSOR_TEST = 0xC11,
			GL_INDEX_CLEAR_VALUE = 0xC20,
			GL_INDEX_WRITEMASK = 0xC21,
			GL_COLOR_CLEAR_VALUE = 0xC22,
			GL_COLOR_WRITEMASK = 0xC23,
			GL_INDEX_MODE = 0xC30,
			GL_RGBA_MODE = 0xC31,
			GL_DOUBLEBUFFER = 0xC32,
			GL_STEREO = 0xC33,
			GL_RENDER_MODE = 0xC40,
			GL_PERSPECTIVE_CORRECTION_HINT = 0xC50,
			GL_POINT_SMOOTH_HINT = 0xC51,
			GL_LINE_SMOOTH_HINT = 0xC52,
			GL_POLYGON_SMOOTH_HINT = 0xC53,
			GL_FOG_HINT = 0xC54,
			GL_TEXTURE_GEN_S = 0xC60,
			GL_TEXTURE_GEN_T = 0xC61,
			GL_TEXTURE_GEN_R = 0xC62,
			GL_TEXTURE_GEN_Q = 0xC63,
			GL_PIXEL_MAP_I_TO_I = 0xC70,
			GL_PIXEL_MAP_S_TO_S = 0xC71,
			GL_PIXEL_MAP_I_TO_R = 0xC72,
			GL_PIXEL_MAP_I_TO_G = 0xC73,
			GL_PIXEL_MAP_I_TO_B = 0xC74,
			GL_PIXEL_MAP_I_TO_A = 0xC75,
			GL_PIXEL_MAP_R_TO_R = 0xC76,
			GL_PIXEL_MAP_G_TO_G = 0xC77,
			GL_PIXEL_MAP_B_TO_B = 0xC78,
			GL_PIXEL_MAP_A_TO_A = 0xC79,
			GL_PIXEL_MAP_I_TO_I_SIZE = 0xCB0,
			GL_PIXEL_MAP_S_TO_S_SIZE = 0xCB1,
			GL_PIXEL_MAP_I_TO_R_SIZE = 0xCB2,
			GL_PIXEL_MAP_I_TO_G_SIZE = 0xCB3,
			GL_PIXEL_MAP_I_TO_B_SIZE = 0xCB4,
			GL_PIXEL_MAP_I_TO_A_SIZE = 0xCB5,
			GL_PIXEL_MAP_R_TO_R_SIZE = 0xCB6,
			GL_PIXEL_MAP_G_TO_G_SIZE = 0xCB7,
			GL_PIXEL_MAP_B_TO_B_SIZE = 0xCB8,
			GL_PIXEL_MAP_A_TO_A_SIZE = 0xCB9,
			GL_UNPACK_SWAP_BYTES = 0xCF0,
			GL_UNPACK_LSB_FIRST = 0xCF1,
			GL_UNPACK_ROW_LENGTH = 0xCF2,
			GL_UNPACK_SKIP_ROWS = 0xCF3,
			GL_UNPACK_SKIP_PIXELS = 0xCF4,
			GL_UNPACK_ALIGNMENT = 0xCF5,
			GL_PACK_SWAP_BYTES = 0xD00,
			GL_PACK_LSB_FIRST = 0xD01,
			GL_PACK_ROW_LENGTH = 0xD02,
			GL_PACK_SKIP_ROWS = 0xD03,
			GL_PACK_SKIP_PIXELS = 0xD04,
			GL_PACK_ALIGNMENT = 0xD05,
			GL_MAP_COLOR = 0xD10,
			GL_MAP_STENCIL = 0xD11,
			GL_INDEX_SHIFT = 0xD12,
			GL_INDEX_OFFSET = 0xD13,
			GL_RED_SCALE = 0xD14,
			GL_RED_BIAS = 0xD15,
			GL_ZOOM_X = 0xD16,
			GL_ZOOM_Y = 0xD17,
			GL_GREEN_SCALE = 0xD18,
			GL_GREEN_BIAS = 0xD19,
			GL_BLUE_SCALE = 0xD1A,
			GL_BLUE_BIAS = 0xD1B,
			GL_ALPHA_SCALE = 0xD1C,
			GL_ALPHA_BIAS = 0xD1D,
			GL_DEPTH_SCALE = 0xD1E,
			GL_DEPTH_BIAS = 0xD1F,
			GL_MAX_EVAL_ORDER = 0xD30,
			GL_MAX_LIGHTS = 0xD31,
			GL_MAX_CLIP_PLANES = 0xD32,
			GL_MAX_TEXTURE_SIZE = 0xD33,
			GL_MAX_PIXEL_MAP_TABLE = 0xD34,
			GL_MAX_ATTRIB_STACK_DEPTH = 0xD35,
			GL_MAX_MODELVIEW_STACK_DEPTH = 0xD36,
			GL_MAX_NAME_STACK_DEPTH = 0xD37,
			GL_MAX_PROJECTION_STACK_DEPTH = 0xD38,
			GL_MAX_TEXTURE_STACK_DEPTH = 0xD39,
			GL_MAX_VIEWPORT_DIMS = 0xD3A,
			GL_MAX_CLIENT_ATTRIB_STACK_DEPTH = 0xD3B,
			GL_SUBPIXEL_BITS = 0xD50,
			GL_INDEX_BITS = 0xD51,
			GL_RED_BITS = 0xD52,
			GL_GREEN_BITS = 0xD53,
			GL_BLUE_BITS = 0xD54,
			GL_ALPHA_BITS = 0xD55,
			GL_DEPTH_BITS = 0xD56,
			GL_STENCIL_BITS = 0xD57,
			GL_ACCUM_RED_BITS = 0xD58,
			GL_ACCUM_GREEN_BITS = 0xD59,
			GL_ACCUM_BLUE_BITS = 0xD5A,
			GL_ACCUM_ALPHA_BITS = 0xD5B,
			GL_NAME_STACK_DEPTH = 0xD70,
			GL_AUTO_NORMAL = 0xD80,
			GL_MAP1_COLOR_4 = 0xD90,
			GL_MAP1_INDEX = 0xD91,
			GL_MAP1_NORMAL = 0xD92,
			GL_MAP1_TEXTURE_COORD_1 = 0xD93,
			GL_MAP1_TEXTURE_COORD_2 = 0xD94,
			GL_MAP1_TEXTURE_COORD_3 = 0xD95,
			GL_MAP1_TEXTURE_COORD_4 = 0xD96,
			GL_MAP1_VERTEX_3 = 0xD97,
			GL_MAP1_VERTEX_4 = 0xD98,
			GL_MAP2_COLOR_4 = 0xDB0,
			GL_MAP2_INDEX = 0xDB1,
			GL_MAP2_NORMAL = 0xDB2,
			GL_MAP2_TEXTURE_COORD_1 = 0xDB3,
			GL_MAP2_TEXTURE_COORD_2 = 0xDB4,
			GL_MAP2_TEXTURE_COORD_3 = 0xDB5,
			GL_MAP2_TEXTURE_COORD_4 = 0xDB6,
			GL_MAP2_VERTEX_3 = 0xDB7,
			GL_MAP2_VERTEX_4 = 0xDB8,
			GL_MAP1_GRID_DOMAIN = 0xDD0,
			GL_MAP1_GRID_SEGMENTS = 0xDD1,
			GL_MAP2_GRID_DOMAIN = 0xDD2,
			GL_MAP2_GRID_SEGMENTS = 0xDD3,
			GL_TEXTURE_1D = 0xDE0,
			GL_TEXTURE_2D = 0xDE1,
			GL_FEEDBACK_BUFFER_POINTER = 0xDF0,
			GL_FEEDBACK_BUFFER_SIZE = 0xDF1,
			GL_FEEDBACK_BUFFER_TYPE = 0xDF2,
			GL_SELECTION_BUFFER_POINTER = 0xDF3,
			GL_SELECTION_BUFFER_SIZE = 0xDF4,
			GL_TEXTURE_WIDTH = 0x1000,
			GL_TEXTURE_HEIGHT = 0x1001,
			GL_TEXTURE_INTERNAL_FORMAT = 0x1003,
			GL_TEXTURE_BORDER_COLOR = 0x1004,
			GL_TEXTURE_BORDER = 0x1005,
			GL_DONT_CARE = 0x1100,
			GL_FASTEST = 0x1101,
			GL_NICEST = 0x1102,
			GL_LIGHT0 = 0x4000,
			GL_LIGHT1 = 0x4001,
			GL_LIGHT2 = 0x4002,
			GL_LIGHT3 = 0x4003,
			GL_LIGHT4 = 0x4004,
			GL_LIGHT5 = 0x4005,
			GL_LIGHT6 = 0x4006,
			GL_LIGHT7 = 0x4007,
			GL_AMBIENT = 0x1200,
			GL_DIFFUSE = 0x1201,
			GL_SPECULAR = 0x1202,
			GL_POSITION = 0x1203,
			GL_SPOT_DIRECTION = 0x1204,
			GL_SPOT_EXPONENT = 0x1205,
			GL_SPOT_CUTOFF = 0x1206,
			GL_CONSTANT_ATTENUATION = 0x1207,
			GL_LINEAR_ATTENUATION = 0x1208,
			GL_QUADRATIC_ATTENUATION = 0x1209,
			GL_COMPILE = 0x1300,
			GL_COMPILE_AND_EXECUTE = 0x1301,
			GL_CLEAR = 0x1500,
			GL_AND = 0x1501,
			GL_AND_REVERSE = 0x1502,
			GL_COPY = 0x1503,
			GL_AND_INVERTED = 0x1504,
			GL_NOOP = 0x1505,
			GL_XOR = 0x1506,
			GL_OR = 0x1507,
			GL_NOR = 0x1508,
			GL_EQUIV = 0x1509,
			GL_INVERT = 0x150A,
			GL_OR_REVERSE = 0x150B,
			GL_COPY_INVERTED = 0x150C,
			GL_OR_INVERTED = 0x150D,
			GL_NAND = 0x150E,
			GL_SET = 0x150F,
			GL_EMISSION = 0x1600,
			GL_SHININESS = 0x1601,
			GL_AMBIENT_AND_DIFFUSE = 0x1602,
			GL_COLOR_INDEXES = 0x1603,
			GL_MODELVIEW = 0x1700,
			GL_PROJECTION = 0x1701,
			GL_TEXTURE = 0x1702,
			GL_COLOR = 0x1800,
			GL_DEPTH = 0x1801,
			GL_STENCIL = 0x1802,
			GL_COLOR_INDEX = 0x1900,
			GL_STENCIL_INDEX = 0x1901,
			GL_DEPTH_COMPONENT = 0x1902,
			GL_RED = 0x1903,
			GL_GREEN = 0x1904,
			GL_BLUE = 0x1905,
			GL_ALPHA = 0x1906,
			GL_RGB = 0x1907,
			GL_RGBA = 0x1908,
			GL_LUMINANCE = 0x1909,
			GL_LUMINANCE_ALPHA = 0x190A,
			GL_BITMAP = 0x1A00,
			GL_POINT = 0x1B00,
			GL_LINE = 0x1B01,
			GL_FILL = 0x1B02,
			GL_RENDER = 0x1C00,
			GL_FEEDBACK = 0x1C01,
			GL_SELECT = 0x1C02,
			GL_FLAT = 0x1D00,
			GL_SMOOTH = 0x1D01,
			GL_KEEP = 0x1E00,
			GL_REPLACE = 0x1E01,
			GL_INCR = 0x1E02,
			GL_DECR = 0x1E03,
			GL_VENDOR = 0x1F00,
			GL_RENDERER = 0x1F01,
			GL_VERSION = 0x1F02,
			GL_EXTENSIONS = 0x1F03,
			GL_S = 0x2000,
			GL_T = 0x2001,
			GL_R = 0x2002,
			GL_Q = 0x2003,
			GL_MODULATE = 0x2100,
			GL_DECAL = 0x2101,
			GL_TEXTURE_ENV_MODE = 0x2200,
			GL_TEXTURE_ENV_COLOR = 0x2201,
			GL_TEXTURE_ENV = 0x2300,
			GL_EYE_LINEAR = 0x2400,
			GL_OBJECT_LINEAR = 0x2401,
			GL_SPHERE_MAP = 0x2402,
			GL_TEXTURE_GEN_MODE = 0x2500,
			GL_OBJECT_PLANE = 0x2501,
			GL_EYE_PLANE = 0x2502,
			GL_NEAREST = 0x2600,
			GL_LINEAR = 0x2601,
			GL_NEAREST_MIPMAP_NEAREST = 0x2700,
			GL_LINEAR_MIPMAP_NEAREST = 0x2701,
			GL_NEAREST_MIPMAP_LINEAR = 0x2702,
			GL_LINEAR_MIPMAP_LINEAR = 0x2703,
			GL_TEXTURE_MAG_FILTER = 0x2800,
			GL_TEXTURE_MIN_FILTER = 0x2801,
			GL_TEXTURE_WRAP_S = 0x2802,
			GL_TEXTURE_WRAP_T = 0x2803,
			GL_CLAMP = 0x2900,
			GL_REPEAT = 0x2901,
			GL_CLIENT_PIXEL_STORE_BIT = 0x1,
			GL_CLIENT_VERTEX_ARRAY_BIT = 0x2,
			GL_ALL_CLIENT_ATTRIB_BITS = 0xFFFFFFFF,
			GL_POLYGON_OFFSET_FACTOR = 0x8038,
			GL_POLYGON_OFFSET_UNITS = 0x2A00,
			GL_POLYGON_OFFSET_POINT = 0x2A01,
			GL_POLYGON_OFFSET_LINE = 0x2A02,
			GL_POLYGON_OFFSET_FILL = 0x8037,
			GL_ALPHA4 = 0x803B,
			GL_ALPHA8 = 0x803C,
			GL_ALPHA12 = 0x803D,
			GL_ALPHA16 = 0x803E,
			GL_LUMINANCE4 = 0x803F,
			GL_LUMINANCE8 = 0x8040,
			GL_LUMINANCE12 = 0x8041,
			GL_LUMINANCE16 = 0x8042,
			GL_LUMINANCE4_ALPHA4 = 0x8043,
			GL_LUMINANCE6_ALPHA2 = 0x8044,
			GL_LUMINANCE8_ALPHA8 = 0x8045,
			GL_LUMINANCE12_ALPHA4 = 0x8046,
			GL_LUMINANCE12_ALPHA12 = 0x8047,
			GL_LUMINANCE16_ALPHA16 = 0x8048,
			GL_INTENSITY = 0x8049,
			GL_INTENSITY4 = 0x804A,
			GL_INTENSITY8 = 0x804B,
			GL_INTENSITY12 = 0x804C,
			GL_INTENSITY16 = 0x804D,
			GL_R3_G3_B2 = 0x2A10,
			GL_RGB4 = 0x804F,
			GL_RGB5 = 0x8050,
			GL_RGB8 = 0x8051,
			GL_RGB10 = 0x8052,
			GL_RGB12 = 0x8053,
			GL_RGB16 = 0x8054,
			GL_RGBA2 = 0x8055,
			GL_RGBA4 = 0x8056,
			GL_RGB5_A1 = 0x8057,
			GL_RGBA8 = 0x8058,
			GL_RGB10_A2 = 0x8059,
			GL_RGBA12 = 0x805A,
			GL_RGBA16 = 0x805B,
			GL_TEXTURE_RED_SIZE = 0x805C,
			GL_TEXTURE_GREEN_SIZE = 0x805D,
			GL_TEXTURE_BLUE_SIZE = 0x805E,
			GL_TEXTURE_ALPHA_SIZE = 0x805F,
			GL_TEXTURE_LUMINANCE_SIZE = 0x8060,
			GL_TEXTURE_INTENSITY_SIZE = 0x8061,
			GL_PROXY_TEXTURE_1D = 0x8063,
			GL_PROXY_TEXTURE_2D = 0x8064,
			GL_TEXTURE_PRIORITY = 0x8066,
			GL_TEXTURE_RESIDENT = 0x8067,
			GL_TEXTURE_BINDING_1D = 0x8068,
			GL_TEXTURE_BINDING_2D = 0x8069,
			GL_VERTEX_ARRAY = 0x8074,
			GL_NORMAL_ARRAY = 0x8075,
			GL_COLOR_ARRAY = 0x8076,
			GL_INDEX_ARRAY = 0x8077,
			GL_TEXTURE_COORD_ARRAY = 0x8078,
			GL_EDGE_FLAG_ARRAY = 0x8079,
			GL_VERTEX_ARRAY_SIZE = 0x807A,
			GL_VERTEX_ARRAY_TYPE = 0x807B,
			GL_VERTEX_ARRAY_STRIDE = 0x807C,
			GL_NORMAL_ARRAY_TYPE = 0x807E,
			GL_NORMAL_ARRAY_STRIDE = 0x807F,
			GL_COLOR_ARRAY_SIZE = 0x8081,
			GL_COLOR_ARRAY_TYPE = 0x8082,
			GL_COLOR_ARRAY_STRIDE = 0x8083,
			GL_INDEX_ARRAY_TYPE = 0x8085,
			GL_INDEX_ARRAY_STRIDE = 0x8086,
			GL_TEXTURE_COORD_ARRAY_SIZE = 0x8088,
			GL_TEXTURE_COORD_ARRAY_TYPE = 0x8089,
			GL_TEXTURE_COORD_ARRAY_STRIDE = 0x808A,
			GL_EDGE_FLAG_ARRAY_STRIDE = 0x808C,
			GL_VERTEX_ARRAY_POINTER = 0x808E,
			GL_NORMAL_ARRAY_POINTER = 0x808F,
			GL_COLOR_ARRAY_POINTER = 0x8090,
			GL_INDEX_ARRAY_POINTER = 0x8091,
			GL_TEXTURE_COORD_ARRAY_POINTER = 0x8092,
			GL_EDGE_FLAG_ARRAY_POINTER = 0x8093,
			GL_V2F = 0x2A20,
			GL_V3F = 0x2A21,
			GL_C4UB_V2F = 0x2A22,
			GL_C4UB_V3F = 0x2A23,
			GL_C3F_V3F = 0x2A24,
			GL_N3F_V3F = 0x2A25,
			GL_C4F_N3F_V3F = 0x2A26,
			GL_T2F_V3F = 0x2A27,
			GL_T4F_V4F = 0x2A28,
			GL_T2F_C4UB_V3F = 0x2A29,
			GL_T2F_C3F_V3F = 0x2A2A,
			GL_T2F_N3F_V3F = 0x2A2B,
			GL_T2F_C4F_N3F_V3F = 0x2A2C,
			GL_T4F_C4F_N3F_V4F = 0x2A2D,
			GL_LOGIC_OP = 0xBF1,
			GL_TEXTURE_COMPONENTS = 0x1003;
	public static WebGL2RenderingContext ctx = (WebGL2RenderingContext) CurrentContext.getContext();
	private static Batch currentBatch;
	private static WebGLTexture[] texBatch = new WebGLTexture[4096];
	private static WebGLShader[] s = new WebGLShader[4096];
	static void	glAccum(int op, float value){
		System.out.println("stub");
    }
	static void	glAlphaFunc(int func, float ref){
		System.out.println("currently a stub!");
		
		return;
		
    }
	static boolean	glAreTexturesResident(java.nio.IntBuffer textures, java.nio.ByteBuffer residences){
		System.out.println("currently a stub!");

		return false;
    }
	static void	glArrayElement(int i){
		System.out.println("currently a stub!");
    }
	static void	glBegin(int mode){
		currentBatch = new Batch(mode);
    }
	static void	glBindTexture(int target, WebGLTexture texture){
		ConstantMapper cm = new ConstantMapper(new String[] {
				"GL_TEXTURE_1D", "GL_TEXTURE_2D", "GL_TEXTURE_3D", "GL_TEXTURE_1D_ARRAY", "GL_TEXTURE_2D_ARRAY", "GL_TEXTURE_RECTANGLE", "GL_TEXTURE_CUBE_MAP", "GL_TEXTURE_CUBE_MAP_ARRAY", "GL_TEXTURE_BUFFER", "GL_TEXTURE_2D_MULTISAMPLE", "GL_TEXTURE_2D_MULTISAMPLE_ARRAY"
		});
		
		int realTarget= cm.mapRealToWebGL(target);
		
		ctx.bindTexture(realTarget, texture);
    }
	static void	glBitmap(int width, int height, float xorig, float yorig, float xmove, float ymove, java.nio.ByteBuffer bitmap){
		System.out.println("currently a stub!");
    }
	static void	glBitmap(int width, int height, float xorig, float yorig, float xmove, float ymove, long bitmap_buffer_offset){
		System.out.println("currently a stub!");
    }
	static void	glBlendFunc(int sfactor, int dfactor){
		ctx.blendFunc(ConstantMapper.cmBlendFuncEnums.mapRealToWebGL(sfactor), ConstantMapper.cmBlendFuncEnums.mapRealToWebGL(dfactor));
		
    }
	static void	glCallList(int list){
		System.out.println("currently a stub!");
    }
	static void	glCallLists(java.nio.ByteBuffer lists){
		System.out.println("currently a stub!");
    }
	static void	glCallLists(java.nio.IntBuffer lists){
		System.out.println("currently a stub!");
    }
	static void	glCallLists(java.nio.ShortBuffer lists){
		System.out.println("currently a stub!");
    }
	static void	glClear(int mask){
		ctx.clear(ConstantMapper.cmBufferBits.mapRealToWebGL(mask));
    }
	static void	glClearAccum(float red, float green, float blue, float alpha){
		System.out.println("currently a stub!");
    }
	static void	glClearColor(float red, float green, float blue, float alpha){
		ctx.clearColor(red, green, blue, alpha);
    }
	static void	glClearDepth(double depth){
		ctx.clearDepth((float) depth);
    }
	static void	glClearStencil(int s){
		ctx.clearStencil(s);
    }
	static void	glClipPlane(int plane, java.nio.DoubleBuffer equation){
		System.out.println("currently a stub!");
		
    }
	static void	glColor3b(byte red, byte green, byte blue){
		if (currentBatch == null) {
			System.out.println("You must use glBegin");
		}
		currentBatch.color3f(red, green, blue);
    }
	static void	glColor3d(double red, double green, double blue){
		if (currentBatch == null) {
			System.out.println("You must use glBegin");
		}
		currentBatch.color3f((float) red,(float) green,(float) blue);
    }
	static void	glColor3f(float red, float green, float blue){
		if (currentBatch == null) {
			System.out.println("You must use glBegin");
		}
		currentBatch.color3f(red, green, blue);
    }
	static void	glColor3ub(byte red, byte green, byte blue){
		if (currentBatch == null) {
			System.out.println("You must use glBegin");
		}
		currentBatch.color3f(red, green, blue);
    }
	static void	glColor4b(byte red, byte green, byte blue, byte alpha){
		if (currentBatch == null) {
			System.out.println("You must use glBegin");
		}
		currentBatch.color4f(red, green, blue, alpha);
    }
	static void	glColor4d(double red, double green, double blue, double alpha){
		if (currentBatch == null) {
			System.out.println("You must use glBegin");
		}
		currentBatch.color4f((float) red, (float) green, (float) blue, (float) alpha);
    }
	static void	glColor4f(float red, float green, float blue, float alpha){
		if (currentBatch == null) {
			System.out.println("You must use glBegin");
		}
		currentBatch.color4f(red, green, blue, alpha);
    }
	static void	glColor4ub(byte red, byte green, byte blue, byte alpha){
		currentBatch.color4f(red, green, blue, alpha);
    }
	static void	glColorMask(boolean red, boolean green, boolean blue, boolean alpha){
		ctx.colorMask(red, green, blue, alpha);
		return;
    }
	static void	glColorMaterial(int face, int mode){
		return;
    }
	static void	glColorPointer(int size, boolean unsigned, int stride, java.nio.ByteBuffer pointer){
		
    }
	static void	glColorPointer(int size, int stride, java.nio.DoubleBuffer pointer){
		
    }
	static void	glColorPointer(int size, int stride, java.nio.FloatBuffer pointer){
		return;
    }
	static void	glColorPointer(int size, int type, int stride, java.nio.ByteBuffer pointer){
		
    }
	
	static void	glColorPointer(int size, int type, int stride, long pointer_buffer_offset){

    }
	static void	glCopyPixels(int x, int y, int width, int height, int type){
		
    }
	static void	glCopyTexImage1D(int target, int level, int internalFormat, int x, int y, int width, int border){
		
    }
	static void	glCopyTexImage2D(int target, int level, int internalFormat, int x, int y, int width, int height, int border){
		ConstantMapper cm = ConstantMapper.cmTexture;
		ctx.copyTexImage2D(cm.mapRealToWebGL(target), cm.mapRealToWebGL(level), cm.mapRealToWebGL(internalFormat), x, y, width, height, border);
    }
	static void	glCopyTexSubImage1D(int target, int level, int xoffset, int x, int y, int width){
		System.out.println("unsupported operation in context");
    }
	static void	glCopyTexSubImage2D(int target, int level, int xoffset, int yoffset, int x, int y, int width, int height){
		ConstantMapper cm = ConstantMapper.cmTexture;
		ctx.copyTexSubImage2D(cm.mapRealToWebGL(target), level, xoffset, yoffset, x, y, width, height);
		
    }
	static void	glCullFace(int mode){
		ctx.cullFace(ConstantMapper.cmCullFace.mapRealToWebGL(mode));
    }
	static void	glDeleteLists(int list, int range){
		
    }
	static void	glDeleteTextures(WebGLTexture texture){
		ctx.deleteTexture(texture);
    }
	static void	glDeleteTextures(WebGLTexture[] textures){
		for (WebGLTexture wgl : textures) {
			
			ctx.deleteTexture(wgl);
		}
    }
	static void	glDepthFunc(int func){
		
		ctx.depthFunc(ConstantMapper.cmFunc.mapRealToWebGL(func));
		
		
    }
	static void	glDepthMask(boolean flag){
		ctx.depthMask(flag);
    }
	static void	glDepthRange(double zNear, double zFar){
		ctx.depthRange((float) zNear,(float) zFar);
    }
	static void	glDisable(int cap){
		return;
    }
	static void	glDisableClientState(int cap){
		return;
    }
	static void	glDrawArrays(int mode, int first, int count){
		
		ctx.drawArrays(ConstantMapper.cmRenderModes.mapRealToWebGL(mode), first, count);
    }
	static void	glDrawBuffer(int mode){
		
    }
	static void	glDrawElements(int mode, java.nio.ByteBuffer indices){
		System.out.println("unsupported");
    }
	static void	glDrawElements(int mode, java.nio.IntBuffer indices){

    }
	static void	glDrawElements(int mode, int count, int type, java.nio.ByteBuffer indices) {

    }
	static void	glDrawElements(int mode, int indices_count, int type, long indices_buffer_offset){

    }
	static void	glDrawElements(int mode, java.nio.ShortBuffer indices){

    }
	static void	glDrawPixels(int width, int height, int format, int type, java.nio.ByteBuffer pixels){

    }
	static void	glDrawPixels(int width, int height, int format, int type, java.nio.IntBuffer pixels){

    }
	static void	glDrawPixels(int width, int height, int format, int type, long pixels_buffer_offset){

    }
	static void	glDrawPixels(int width, int height, int format, int type, java.nio.ShortBuffer pixels){

    }
	static void	glEdgeFlag(boolean flag){

    }
	static void	glEdgeFlagPointer(int stride, java.nio.ByteBuffer pointer){

    }
	static void	glEdgeFlagPointer(int stride, long pointer_buffer_offset){

    }
	static void	glEnable(int cap){
		
    }
	static void	glEnableClientState(int cap){

    }
	static void	glEnd(){
		currentBatch.drawAndFinish();
    }
	static void	glEndList(){

    }
	static void	glEvalCoord1d(double u){

    }
	static void	glEvalCoord1f(float u){

    }
	static void	glEvalCoord2d(double u, double v){

    }
	static void	glEvalCoord2f(float u, float v){

    }
	static void	glEvalMesh1(int mode, int i1, int i2){

    }
	static void	glEvalMesh2(int mode, int i1, int i2, int j1, int j2){

    }
	static void	glEvalPoint1(int i){

    }
	static void	glEvalPoint2(int i, int j){

    }
	static void	glFeedbackBuffer(int type, java.nio.FloatBuffer buffer){

    }
	static void	glFinish(){

    }
	static void	glFlush(){

    }
	static void	glFog(int pname, java.nio.FloatBuffer params){

    }
	static void	glFog(int pname, java.nio.IntBuffer params){

    }
	static void	glFogf(int pname, float param){

    }
	static void	glFogi(int pname, int param){

    }
	static void	glFrontFace(int mode){

    }
	static void	glFrustum(double left, double right, double bottom, double top, double zNear, double zFar){

    }
	static int	glGenLists(int range){
		return 0;
    }
	static WebGLTexture glGenTextures(){
		return ctx.createTexture();
    }
	static void	glGenTextures(java.nio.IntBuffer textures){

    }
	static boolean	glGetBoolean(int pname){
		return ctx.getParameter(ConstantMapper.cmGLParamsInfo.mapRealToWebGL(pname)).<JSBoolean> cast().booleanValue();
    }
	static void	glGetBoolean(int pname, java.nio.ByteBuffer params){
		boolean b = ctx.getParameter(ConstantMapper.cmGLParamsInfo.mapRealToWebGL(pname)).<JSBoolean> cast().booleanValue();
		
		params.putInt(b ? 1 : 0);
		params.flip();
    }
	static void	glGetClipPlane(int plane, java.nio.DoubleBuffer equation){

    }
	static double	glGetDouble(int pname){
		return (double) ctx.getParameterf(ConstantMapper.cmGLParamsInfo.mapRealToWebGL(pname));
    }
	static void	glGetDouble(int pname, java.nio.DoubleBuffer params){
		params.put((double) ctx.getParameterf(ConstantMapper.cmGLParamsInfo.mapRealToWebGL(pname)));
		params.flip();
    }
	static int	glGetError(){
		return ctx.getError();
    }
	static float glGetFloat(int pname) {
		return ctx.getParameterf(ConstantMapper.cmGLParamsInfo.mapRealToWebGL(pname));
    }
	static void	glGetFloat(int pname, java.nio.FloatBuffer params){
		params.put(ctx.getParameterf(ConstantMapper.cmGLParamsInfo.mapRealToWebGL(pname)));
    }
	static int	glGetInteger(int pname){
		return ctx.getParameteri(ConstantMapper.cmGLParamsInfo.mapRealToWebGL(pname));
    }
	static void	glGetInteger(int pname, java.nio.IntBuffer params){
		params.put(ctx.getParameteri(ConstantMapper.cmGLParamsInfo.mapRealToWebGL(pname)));
		params.flip();
    }
	static void	glGetLight(int light, int pname, java.nio.FloatBuffer params){

    }
	static void	glGetLight(int light, int pname, java.nio.IntBuffer params){

    }
	static void	glGetMap(int target, int query, java.nio.DoubleBuffer v){

    }
	static void	glGetMap(int target, int query, java.nio.FloatBuffer v){

    }
	static void	glGetMap(int target, int query, java.nio.IntBuffer v){

    }
	static void	glGetMaterial(int face, int pname, java.nio.FloatBuffer params){

    }
	static void	glGetMaterial(int face, int pname, java.nio.IntBuffer params){

    }
	static void	glGetPixelMap(int map, java.nio.FloatBuffer values){

    }
	static void	glGetPixelMapfv(int map, long values_buffer_offset){

    }
	static void	glGetPixelMapu(int map, java.nio.IntBuffer values){

    }
	static void	glGetPixelMapu(int map, java.nio.ShortBuffer values){

    }
	static void	glGetPixelMapuiv(int map, long values_buffer_offset){

    }
	static void	glGetPixelMapusv(int map, long values_buffer_offset){

    }
	static java.nio.ByteBuffer	glGetPointer(int pname, long result_size){
		
		return null;
    }
	static void	glGetPolygonStipple(java.nio.ByteBuffer mask){

    }
	static void	glGetPolygonStipple(long mask_buffer_offset){

    }
	static java.lang.String	glGetString(int name){
		
		ConstantMapper cm = new ConstantMapper(new String[] {
			"GL_VENDOR",
			"GL_VERSION",
			"GL_RENDERER",
			"GL_SHADING_LANGUAGE_VERSION",
			"GL_EXTENSIONS"
		});
		
		if (cm.mapRealToWebGL(name) != -1) {
			return ctx.getParameterString(name);
		}else {
			return "";
		}
    }
	static void	glGetTexEnv(int coord, int pname, java.nio.FloatBuffer params){
		return;
    }
	static void	glGetTexEnv(int coord, int pname, java.nio.IntBuffer params){
		return;
    }
	static float glGetTexEnvf(int coord, int pname){
		return 0;

    }
	static int	glGetTexEnvi(int coord, int pname){
		return 0;
    }
	static void	glGetTexGen(int coord, int pname, java.nio.DoubleBuffer params){
		return;
    }
	static void	glGetTexGen(int coord, int pname, java.nio.FloatBuffer params){
		return;
    }
	static void	glGetTexGen(int coord, int pname, java.nio.IntBuffer params){
		return;
    }
	static double	glGetTexGend(int coord, int pname){
		return 0;
    }
	static float	glGetTexGenf(int coord, int pname){
		return 0;
    }
	static int	glGetTexGeni(int coord, int pname){
		return 0;
    }
	static void	glGetTexImage(int target, int level, int format, int type, java.nio.ByteBuffer pixels){
		return;
    }
	static void	glGetTexImage(int target, int level, int format, int type, java.nio.DoubleBuffer pixels){
		return;
    }
	static void	glGetTexImage(int target, int level, int format, int type, java.nio.FloatBuffer pixels){
		return;
    }
	static void	glGetTexImage(int target, int level, int format, int type, java.nio.IntBuffer pixels){
		return;
    }
	static void	glGetTexImage(int target, int level, int format, int type, long pixels_buffer_offset){
		return;
    }
	static void	glGetTexImage(int target, int level, int format, int type, java.nio.ShortBuffer pixels){
		return;
    }
	static void	glGetTexLevelParameter(int target, int level, int pname, java.nio.FloatBuffer params){
		
		return;
    }
	static void	glGetTexLevelParameter(int target, int level, int pname, java.nio.IntBuffer params){

    }
	static float glGetTexLevelParameterf(int target, int level, int pname){
		return 0;
    }
	static int	glGetTexLevelParameteri(int target, int level, int pname){
		return 0;
    }
	static void	glGetTexParameter(int target, int pname, java.nio.FloatBuffer params){
		JSNumber s = ctx.getTexParameter(ConstantMapper.cmTexture.mapRealToWebGL(target), ConstantMapper.cmTexture.mapRealToWebGL(pname)).<JSNumber> cast();
		params.put(s.floatValue());
		params.flip();
    }
	static void	glGetTexParameter(int target, int pname, java.nio.IntBuffer params){
		JSNumber s = ctx.getTexParameter(target, pname).<JSNumber> cast();
		params.put(s.intValue());
		params.flip();
    }
	static float glGetTexParameterf(int target, int pname){
		
		return ctx.getTexParameter(ConstantMapper.cmTexture.mapRealToWebGL(target), ConstantMapper.cmTexture.mapRealToWebGL(pname)).<JSNumber> cast().floatValue();
		
		
    }
	static int glGetTexParameteri(int target, int pname){
		return ctx.getTexParameter(ConstantMapper.cmTexture.mapRealToWebGL(target), ConstantMapper.cmTexture.mapRealToWebGL(pname)).<JSNumber> cast().intValue();
		
		
    }
	static void	glHint(int target, int mode){
		ctx.hint(ConstantMapper.cmHint.mapRealToWebGL(target), ConstantMapper.cmHint.mapRealToWebGL(mode));
		
    }
	static void	glInitNames(){
		
    }
	static void	glInterleavedArrays(int format, int stride, java.nio.ByteBuffer pointer){
		FloatBuffer buf = pointer.asFloatBuffer();
		
		switch (format){
	    case GL_V2F:
	    	
	    	break;
	    case GL_V3F:
	    case GL_C4UB_V2F:
	    case GL_C4UB_V3F:
	    case GL_C3F_V3F:
	    case GL_N3F_V3F:
	    case GL_C4F_N3F_V3F:
	    case GL_T2F_V3F:
	    case GL_T4F_V4F:
	    case GL_T2F_C4UB_V3F:
	    case GL_T2F_C3F_V3F:
	    case GL_T2F_N3F_V3F:
	    case GL_T2F_C4F_N3F_V3F:
	    case GL_T4F_C4F_N3F_V4F:
	}
    }
	private static void bufferLoadInterleaved() {
		
	}
	static void	glInterleavedArrays(int format, int stride, java.nio.DoubleBuffer pointer){

    }
	static void	glInterleavedArrays(int format, int stride, java.nio.FloatBuffer pointer){

    }
	static void	glInterleavedArrays(int format, int stride, java.nio.IntBuffer pointer){

    }
	static void	glInterleavedArrays(int format, int stride, long pointer_buffer_offset){

    }
	static void	glInterleavedArrays(int format, int stride, java.nio.ShortBuffer pointer){

    }
	static boolean	glIsEnabled(int cap){
		return ctx.isEnabled(ConstantMapper.cmEnableDisable.mapRealToWebGL(cap));
    }
	static boolean	glIsList(int list){
		return false;
    }
	static boolean	glIsTexture(int texture){
		return true;
    }
	static void	glLight(int light, int pname, java.nio.FloatBuffer params){
		
    }
	static void	glLight(int light, int pname, java.nio.IntBuffer params){

    }
	static void	glLightf(int light, int pname, float param){

    }
	static void	glLighti(int light, int pname, int param){

    }
	static void	glLightModel(int pname, java.nio.FloatBuffer params){

    }
	static void	glLightModel(int pname, java.nio.IntBuffer params){

    }
	static void	glLightModelf(int pname, float param){

    }
	static void	glLightModeli(int pname, int param){

    }
	static void	glLineStipple(int factor, short pattern){

    }
	static void	glLineWidth(float width){

    }
	static void	glListBase(int base){

    }
	static void	glLoadIdentity(){
		
    }
	static void	glLoadMatrix(java.nio.DoubleBuffer m){

    }
	static void	glLoadMatrix(java.nio.FloatBuffer m){

    }
	static void	glLoadName(int name){

    }
	static void	glLogicOp(int opcode){

    }
	static void	glMap1d(int target, double u1, double u2, int stride, int order, java.nio.DoubleBuffer points){

    }
	static void	glMap1f(int target, float u1, float u2, int stride, int order, java.nio.FloatBuffer points){

    }
	static void	glMap2d(int target, double u1, double u2, int ustride, int uorder, double v1, double v2, int vstride, int vorder, java.nio.DoubleBuffer points){

    }
	static void	glMap2f(int target, float u1, float u2, int ustride, int uorder, float v1, float v2, int vstride, int vorder, java.nio.FloatBuffer points){

    }
	static void	glMapGrid1d(int un, double u1, double u2){

    }
	static void	glMapGrid1f(int un, float u1, float u2){

    }
	static void	glMapGrid2d(int un, double u1, double u2, int vn, double v1, double v2){

    }
	static void	glMapGrid2f(int un, float u1, float u2, int vn, float v1, float v2){

    }
	static void	glMaterial(int face, int pname, java.nio.FloatBuffer params){

    }
	static void	glMaterial(int face, int pname, java.nio.IntBuffer params){

    }
	static void	glMaterialf(int face, int pname, float param){

    }
	static void	glMateriali(int face, int pname, int param){

    }
	static void	glMatrixMode(int mode){

    }
	static void	glMultMatrix(java.nio.DoubleBuffer m){

    }
	static void	glMultMatrix(java.nio.FloatBuffer m){

    }
	static void	glNewList(int list, int mode){

    }
	static void	glNormal3b(byte nx, byte ny, byte nz) {

    }
	static void	glNormal3d(double nx, double ny, double nz){

    }
	static void	glNormal3f(float nx, float ny, float nz){

    }
	static void	glNormal3i(int nx, int ny, int nz){

    }
	static void	glNormalPointer(int stride, java.nio.ByteBuffer pointer){

    }
	static void	glNormalPointer(int stride, java.nio.DoubleBuffer pointer){

    }
	static void	glNormalPointer(int stride, java.nio.FloatBuffer pointer){

    }
	static void	glNormalPointer(int stride, java.nio.IntBuffer pointer){

    }
	static void	glNormalPointer(int type, int stride, java.nio.ByteBuffer pointer){

    }
	static void	glNormalPointer(int type, int stride, long pointer_buffer_offset){

    }
	static void	glOrtho(double left, double right, double bottom, double top, double zNear, double zFar){

    }
	static void	glPassThrough(float token){

    }
	static void	glPixelMap(int map, java.nio.FloatBuffer values){

    }
	static void	glPixelMapfv(int map, int values_mapsize, long values_buffer_offset){

    }
	static void	glPixelMapu(int map, java.nio.IntBuffer values){

    }
	static void	glPixelMapu(int map, java.nio.ShortBuffer values){

    }
	static void	glPixelMapuiv(int map, int values_mapsize, long values_buffer_offset){

    }
	static void	glPixelMapusv(int map, int values_mapsize, long values_buffer_offset){

    }
	static void	glPixelStoref(int pname, float param){

    }
	static void	glPixelStorei(int pname, int param){
	
    }
	static void	glPixelTransferf(int pname, float param){

    }
	static void	glPixelTransferi(int pname, int param){

    }
	static void	glPixelZoom(float xfactor, float yfactor){

    }
	static void	glPointSize(float size){

    }
	static void	glPolygonMode(int face, int mode){

    }
	static void	glPolygonOffset(float factor, float units){

    }
	static void	glPolygonStipple(java.nio.ByteBuffer mask){

    }
	static void	glPolygonStipple(long mask_buffer_offset){

    }
	static void	glPopAttrib(){

    }
	static void	glPopClientAttrib(){

    }
	static void	glPopMatrix(){

    }
	static void	glPopName(){

    }
	static void	glPrioritizeTextures(java.nio.IntBuffer textures, java.nio.FloatBuffer priorities){

    }
	static void	glPushAttrib(int mask){

    }
	static void	glPushClientAttrib(int mask){

    }
	static void	glPushMatrix(){

    }
	static void	glPushName(int name){

    }
	static void	glRasterPos2d(double x, double y){

    }
	static void	glRasterPos2f(float x, float y){

    }
	static void	glRasterPos2i(int x, int y){

    }
	static void	glRasterPos3d(double x, double y, double z){

    }
	static void	glRasterPos3f(float x, float y, float z){

    }
	static void	glRasterPos3i(int x, int y, int z){

    }
	static void	glRasterPos4d(double x, double y, double z, double w){

    }
	static void	glRasterPos4f(float x, float y, float z, float w){

    }
	static void	glRasterPos4i(int x, int y, int z, int w){

    }
	static void	glReadBuffer(int mode){

    }
	static void	glReadPixels(int x, int y, int width, int height, int format, int type, java.nio.ByteBuffer pixels){
		
		
		
		
		ctx.readPixels(x, y, width, height, WebGLRenderingContext.RGBA, WebGLRenderingContext.RGBA, GLUtil.glCreateBufferFromJava(pixels));
		
		
		
		
		
		
	}
	static Uint8Array glCreateBufferFromJava(ByteBuffer data) {
		Uint8Array arr = Uint8Array.create(data.remaining());
		DataView dv = DataView.create(arr);
		
		for (int i = 0; i < arr.getLength(); i++) {
			dv.setUint8(i, data.get(i));
		}
		return arr;
	}
	static Uint8Array glCreateBufferFromJava(FloatBuffer data) {
		Uint8Array arr = Uint8Array.create(data.remaining());
		DataView dv = DataView.create(arr);
		
		for (int i = 0; i < arr.getLength(); i++) {
			dv.setFloat32(i*4, data.get(i));
		}
		return arr;
	}
	
	
	static void	glReadPixels(int x, int y, int width, int height, int format, int type, java.nio.DoubleBuffer pixels){
		int pixelSize = 0;
		switch (format) {
		case GL_RGBA:
			
		}
//		glReadPixels(x, y, width, height, format, type, )
    }
	static void glConvertBufferToWebGL(FloatBuffer pixels) {
		Uint8Array s = Uint8Array.create(pixels.remaining());
		s.set(pixels.array());
	}
	static void	glReadPixels(int x, int y, int width, int height, int format, int type, java.nio.FloatBuffer pixels){
		ctx.readPixels(x, y, width, height, format, type, pixels.);
    }
	static void	glReadPixels(int x, int y, int width, int height, int format, int type, java.nio.IntBuffer pixels){

    }
	static void	glReadPixels(int x, int y, int width, int height, int format, int type, long pixels_buffer_offset){

    }
	static void	glReadPixels(int x, int y, int width, int height, int format, int type, java.nio.ShortBuffer pixels){

    }
	static void	glRectd(double x1, double y1, double x2, double y2){

    }
	static void	glRectf(float x1, float y1, float x2, float y2){

    }
	static void	glRecti(int x1, int y1, int x2, int y2){
		
	}
	static int	glRenderMode(int mode){
		return 0;
    }
	static void	glRotated(double angle, double x, double y, double z){

    }
	static void	glRotatef(float angle, float x, float y, float z){

    }
	static void	glScaled(double x, double y, double z){

    }
	static void	glScalef(float x, float y, float z){

    }
	static void	glScissor(int x, int y, int width, int height){

    }
	static void	glSelectBuffer(java.nio.IntBuffer buffer){

    }
	static void	glShadeModel(int mode){

    }
	static void	glStencilFunc(int func, int ref, int mask){

    }
	static void	glStencilMask(int mask){

    }
	static void	glStencilOp(int fail, int zfail, int zpass){
		ctx.stencilOp(ConstantMapper.cmStencilActions.mapRealToWebGL(fail), ConstantMapper.cmStencilActions.mapRealToWebGL(zfail), ConstantMapper.cmStencilActions.mapRealToWebGL(zpass));
    }
	static void	glTexCoord1d(double s){

    }
	static void	glTexCoord1f(float s){

    }
	static void	glTexCoord2d(double s, double t){

    }
	static void	glTexCoord2f(float s, float t){

    }
	static void	glTexCoord3d(double s, double t, double r){

    }
	static void	glTexCoord3f(float s, float t, float r){

    }
	static void	glTexCoord4d(double s, double t, double r, double q){

    }
	static void	glTexCoord4f(float s, float t, float r, float q){

    }
	static void	glTexCoordPointer(int size, int stride, java.nio.DoubleBuffer pointer){

    }
	static void	glTexCoordPointer(int size, int stride, java.nio.FloatBuffer pointer){

    }
	static void	glTexCoordPointer(int size, int stride, java.nio.IntBuffer pointer){

    }
	static void	glTexCoordPointer(int size, int type, int stride, java.nio.ByteBuffer pointer){

    }
	static void	glTexCoordPointer(int size, int type, int stride, long pointer_buffer_offset){

    }
	static void	glTexCoordPointer(int size, int stride, java.nio.ShortBuffer pointer){

    }
	static void	glTexEnv(int target, int pname, java.nio.FloatBuffer params){

    }
	static void	glTexEnv(int target, int pname, java.nio.IntBuffer params){

    }
	static void	glTexEnvf(int target, int pname, float param){

    }
	static void	glTexEnvi(int target, int pname, int param){

    }
	static void	glTexGen(int coord, int pname, java.nio.DoubleBuffer params){
		
    }
	static void	glTexGen(int coord, int pname, java.nio.FloatBuffer params){

    }
	static void	glTexGen(int coord, int pname, java.nio.IntBuffer params){

    }
	static void	glTexGend(int coord, int pname, double param){

    }
	static void	glTexGenf(int coord, int pname, float param){

    }
	static void	glTexGeni(int coord, int pname, int param){

    }
	static void	glTexImage1D(int target, int level, int internalformat, int width, int border, int format, int type, java.nio.ByteBuffer pixels){

    }
	static void	glTexImage1D(int target, int level, int internalformat, int width, int border, int format, int type, java.nio.DoubleBuffer pixels){

    }
	static void	glTexImage1D(int target, int level, int internalformat, int width, int border, int format, int type, java.nio.FloatBuffer pixels){

    }
	static void	glTexImage1D(int target, int level, int internalformat, int width, int border, int format, int type, java.nio.IntBuffer pixels){

    }
	static void	glTexImage1D(int target, int level, int internalformat, int width, int border, int format, int type, long pixels_buffer_offset){

    }
	static void	glTexImage1D(int target, int level, int internalformat, int width, int border, int format, int type, java.nio.ShortBuffer pixels){

    }
	static void	glTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, java.nio.ByteBuffer pixels){

    }
	static void	glTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, java.nio.DoubleBuffer pixels){

    }
	static void	glTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, java.nio.FloatBuffer pixels){

    }
	static void	glTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, java.nio.IntBuffer pixels){

    }
	static void	glTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, long pixels_buffer_offset){

    }
	static void	glTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, java.nio.ShortBuffer pixels){

    }
	static void	glTexParameter(int target, int pname, java.nio.FloatBuffer param){

    }
	static void	glTexParameter(int target, int pname, java.nio.IntBuffer param){

    }
	static void	glTexParameterf(int target, int pname, float param){

    }
	static void	glTexParameteri(int target, int pname, int param){

    }
	static void	glTexSubImage1D(int target, int level, int xoffset, int width, int format, int type, java.nio.ByteBuffer pixels){

    }
	static void	glTexSubImage1D(int target, int level, int xoffset, int width, int format, int type, java.nio.DoubleBuffer pixels){

    }
	static void	glTexSubImage1D(int target, int level, int xoffset, int width, int format, int type, java.nio.FloatBuffer pixels){

    }
	static void	glTexSubImage1D(int target, int level, int xoffset, int width, int format, int type, java.nio.IntBuffer pixels){

    }
	static void	glTexSubImage1D(int target, int level, int xoffset, int width, int format, int type, long pixels_buffer_offset){

    }
	static void	glTexSubImage1D(int target, int level, int xoffset, int width, int format, int type, java.nio.ShortBuffer pixels){

    }
	static void	glTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, java.nio.ByteBuffer pixels){

    }
	static void	glTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, java.nio.DoubleBuffer pixels){

    }
	static void	glTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, java.nio.FloatBuffer pixels){

    }
	static void	glTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, java.nio.IntBuffer pixels){
		
    }
	static void	glTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, long pixels_buffer_offset){

    }
	static void	glTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, java.nio.ShortBuffer pixels){

    }
	static void	glTranslated(double x, double y, double z){

    }
	static void	glTranslatef(float x, float y, float z){

    }
	static void	glVertex2d(double x, double y){

    }
	static void	glVertex2f(float x, float y){

    }
	static void	glVertex2i(int x, int y){

    }
	static void	glVertex3d(double x, double y, double z){

    }
	static void	glVertex3f(float x, float y, float z){

    }
	static void	glVertex3i(int x, int y, int z){

    }
	static void	glVertex4d(double x, double y, double z, double w){

    }
	static void	glVertex4f(float x, float y, float z, float w){

    }
	static void	glVertex4i(int x, int y, int z, int w){

    }
	static void	glVertexPointer(int size, int stride, java.nio.DoubleBuffer pointer){

    }
	static void	glVertexPointer(int size, int stride, java.nio.FloatBuffer pointer){

    }
	static void	glVertexPointer(int size, int stride, java.nio.IntBuffer pointer){

    }
	static void	glVertexPointer(int size, int type, int stride, java.nio.ByteBuffer pointer){

    }
	
	static void	glVertexPointer(int size, int type, int stride, long pointer_buffer_offset){

    }
	static void	glVertexPointer(int size, int stride, java.nio.ShortBuffer pointer){

    }
	static void	glViewport(int x, int y, int width, int height){

    }
}
