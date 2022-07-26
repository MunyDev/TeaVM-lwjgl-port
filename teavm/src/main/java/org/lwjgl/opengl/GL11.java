package org.lwjgl.opengl;

import org.munydev.teavm.lwjgl.CurrentContext;
import org.teavm.jso.core.JSArray;
import org.teavm.jso.core.JSBoolean;
import org.teavm.jso.core.JSNumber;
import org.teavm.jso.typedarrays.*;
import org.teavm.jso.webgl.WebGLRenderingContext;
import org.teavm.jso.webgl.WebGLShader;
import org.teavm.jso.webgl.WebGLTexture;
import org.teavm.webgl2.WebGL2RenderingContext;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

import org.joml.Matrix4d;
import org.joml.Matrix4f;
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
//	private static WebGLTexture[] texBatch = new WebGLTexture[4096];
//	private static WebGLShader[] s = new WebGLShader[4096];
	public static void	glAccum(int op, float value){
		System.out.println("stub");
    }
	public static void	glAlphaFunc(int func, float ref){
		System.out.println("currently a stub!");
		
		return;
		
    }
	static boolean	glAreTexturesResident(java.nio.IntBuffer textures, java.nio.ByteBuffer residences){
		System.out.println("currently a stub!");

		return false;
    }
	public static void	glArrayElement(int i){
		System.out.println("currently a stub!");
    }
	public static void	glBegin(int mode){
		currentBatch = new Batch(mode);
    }
	public static void	glBindTexture(int target, WebGLTexture texture){
//		ConstantMapper cm = new ConstantMapper(new String[] {
//				"GL_TEXTURE_1D", "GL_TEXTURE_2D", "GL_TEXTURE_3D", "GL_TEXTURE_1D_ARRAY", "GL_TEXTURE_2D_ARRAY", "GL_TEXTURE_RECTANGLE", "GL_TEXTURE_CUBE_MAP", "GL_TEXTURE_CUBE_MAP_ARRAY", "GL_TEXTURE_BUFFER", "GL_TEXTURE_2D_MULTISAMPLE", "GL_TEXTURE_2D_MULTISAMPLE_ARRAY"
//		});
		
		
		
		ctx.bindTexture(target, texture);
    }
	public static void	glBitmap(int width, int height, float xorig, float yorig, float xmove, float ymove, java.nio.ByteBuffer bitmap){
		System.out.println("currently a stub!");
    }
	public static void	glBitmap(int width, int height, float xorig, float yorig, float xmove, float ymove, long bitmap_buffer_offset){
		System.out.println("currently a stub!");
    }
	public static void	glBlendFunc(int sfactor, int dfactor){
		ctx.blendFunc(sfactor, dfactor);
		
    }
	public static void	glCallList(int list){
		System.out.println("currently a stub!");
    }
	public static void	glCallLists(java.nio.ByteBuffer lists){
		System.out.println("currently a stub!");
    }
	public static void	glCallLists(java.nio.IntBuffer lists){
		System.out.println("currently a stub!");
    }
	public static void	glCallLists(java.nio.ShortBuffer lists){
		System.out.println("currently a stub!");
    }
	public static void	glClear(int mask){
		ctx.clear(mask);
    }
	public static void	glClearAccum(float red, float green, float blue, float alpha){
		System.out.println("currently a stub!");
    }
	public static void	glClearColor(float red, float green, float blue, float alpha){
		ctx.clearColor(red, green, blue, alpha);
    }
	public static void	glClearDepth(double depth){
		ctx.clearDepth((float) depth);
    }
	public static void	glClearStencil(int s){
		ctx.clearStencil(s);
    }
	public static void	glClipPlane(int plane, java.nio.DoubleBuffer equation){
//		System.out.println("currently a stub!");
		
		
    }
	public static void	glColor3b(byte red, byte green, byte blue){
		if (currentBatch == null) {
			System.out.println("You must use glBegin");
		}
		currentBatch.color3f(red, green, blue);
    }
	public static void	glColor3d(double red, double green, double blue){
		if (currentBatch == null) {
			System.out.println("You must use glBegin");
		}
		currentBatch.color3f((float) red,(float) green,(float) blue);
    }
	public static void	glColor3f(float red, float green, float blue){
		if (currentBatch == null) {
			System.out.println("You must use glBegin");
		}
		currentBatch.color3f(red, green, blue);
    }
	public static void	glColor3ub(byte red, byte green, byte blue){
		if (currentBatch == null) {
			System.out.println("You must use glBegin");
		}
		currentBatch.color3f(red, green, blue);
    }
	public static void	glColor4b(byte red, byte green, byte blue, byte alpha){
		if (currentBatch == null) {
			System.out.println("You must use glBegin");
		}
		currentBatch.color4f(red, green, blue, alpha);
    }
	public static void	glColor4d(double red, double green, double blue, double alpha){
		if (currentBatch == null) {
			System.out.println("You must use glBegin");
		}
		currentBatch.color4f((float) red, (float) green, (float) blue, (float) alpha);
    }
	public static void	glColor4f(float red, float green, float blue, float alpha){
		if (currentBatch == null) {
			System.out.println("You must use glBegin");
		}
		currentBatch.color4f(red, green, blue, alpha);
    }
	public static void	glColor4ub(byte red, byte green, byte blue, byte alpha){
		currentBatch.color4f(red, green, blue, alpha);
    }
	public static void	glColorMask(boolean red, boolean green, boolean blue, boolean alpha){
		ctx.colorMask(red, green, blue, alpha);
		return;
    }
	public static void	glColorMaterial(int face, int mode){
		
		return;
    }
	public static void	glColorPointer(int size, boolean unsigned, int stride, java.nio.ByteBuffer pointer){
		
    }
	public static void	glColorPointer(int size, int stride, java.nio.DoubleBuffer pointer){
		
    }
	public static void	glColorPointer(int size, int stride, java.nio.FloatBuffer pointer){
		return;
    }
	public static void	glColorPointer(int size, int type, int stride, java.nio.ByteBuffer pointer){
		
    }
	
	public static void	glColorPointer(int size, int type, int stride, long pointer_buffer_offset){

    }
	public static void	glCopyPixels(int x, int y, int width, int height, int type){
		
    }
	public static void	glCopyTexImage1D(int target, int level, int internalFormat, int x, int y, int width, int border){
		
    }
	public static void	glCopyTexImage2D(int target, int level, int internalFormat, int x, int y, int width, int height, int border){
//		ConstantMapper cm = ConstantMapper.cmTexture;
		ctx.copyTexImage2D(target, level, internalFormat, x, y, width, height, border);
    }
	public static void	glCopyTexSubImage1D(int target, int level, int xoffset, int x, int y, int width){
		System.out.println("unsupported operation in context");
    }
	public static void	glCopyTexSubImage2D(int target, int level, int xoffset, int yoffset, int x, int y, int width, int height){
		ctx.copyTexSubImage2D(target, level, xoffset, yoffset, x, y, width, height);
		
    }
	public static void	glCullFace(int mode){
		ctx.cullFace(mode);
    }
	public static void	glDeleteLists(int list, int range){
		
    }
	public static void	glDeleteTextures(WebGLTexture texture){
		ctx.deleteTexture(texture);
    }
	public static void	glDeleteTextures(WebGLTexture[] textures){
		for (WebGLTexture wgl : textures) {
			
			ctx.deleteTexture(wgl);
		}
    }
	public static void	glDepthFunc(int func){
		
		ctx.depthFunc(func);
		
		
    }
	public static void	glDepthMask(boolean flag){
		ctx.depthMask(flag);
    }
	public static void	glDepthRange(double zNear, double zFar){
		ctx.depthRange((float) zNear,(float) zFar);
    }
	public static void	glDisable(int cap){
		return;
    }
	public static void	glDisableClientState(int cap){
		return;
    }
	public static void	glDrawArrays(int mode, int first, int count){
		
		ctx.drawArrays(mode, first, count);
    }
	public static void	glDrawBuffer(int mode){
		
    }
	public static void	glDrawElements(int mode, java.nio.ByteBuffer indices){
		System.out.println("unsupported");
    }
	public static void	glDrawElements(int mode, java.nio.IntBuffer indices){

    }
	public static void	glDrawElements(int mode, int count, int type, java.nio.ByteBuffer indices) {

    }
	public static void	glDrawElements(int mode, int indices_count, int type, long indices_buffer_offset){

    }
	public static void	glDrawElements(int mode, java.nio.ShortBuffer indices){

    }
	public static void	glDrawPixels(int width, int height, int format, int type, java.nio.ByteBuffer pixels){

    }
	public static void	glDrawPixels(int width, int height, int format, int type, java.nio.IntBuffer pixels){

    }
	public static void	glDrawPixels(int width, int height, int format, int type, long pixels_buffer_offset){

    }
	public static void	glDrawPixels(int width, int height, int format, int type, java.nio.ShortBuffer pixels){

    }
	public static void	glEdgeFlag(boolean flag){

    }
	public static void	glEdgeFlagPointer(int stride, java.nio.ByteBuffer pointer){

    }
	public static void	glEdgeFlagPointer(int stride, long pointer_buffer_offset){

    }
	public static void	glEnable(int cap){
		ctx.enable(cap);
    }
	public static void	glEnableClientState(int cap){
		GL11.glEnable(cap);
    }
	public static void	glEnd(){
		currentBatch.drawAndFinish();
    }
	public static void	glEndList(){
		
    }
	public static void	glEvalCoord1d(double u){

    }
	public static void	glEvalCoord1f(float u){

    }
	public static void	glEvalCoord2d(double u, double v){
		
    }
	public static void	glEvalCoord2f(float u, float v){

    }
	public static void	glEvalMesh1(int mode, int i1, int i2){

    }
	public static void	glEvalMesh2(int mode, int i1, int i2, int j1, int j2){

    }
	public static void	glEvalPoint1(int i){

    }
	public static void	glEvalPoint2(int i, int j){

    }
	public static void	glFeedbackBuffer(int type, java.nio.FloatBuffer buffer){

    }
	public static void	glFinish(){

    }
	public static void	glFlush(){

    }
	public static void	glFog(int pname, java.nio.FloatBuffer params){

    }
	public static void	glFog(int pname, java.nio.IntBuffer params){

    }
	public static void	glFogf(int pname, float param){

    }
	public static void	glFogi(int pname, int param){

    }
	public static void	glFrontFace(int mode){

    }
	public static void	glFrustum(double left, double right, double bottom, double top, double zNear, double zFar){

    }
	static int	glGenLists(int range){
		
		return 0;
    }
	static WebGLTexture glGenTextures(){
		return ctx.createTexture();
    }
	public static void	glGenTextures(java.nio.IntBuffer textures){

    }
	static boolean	glGetBoolean(int pname){
		return ctx.getParameter(pname).<JSBoolean> cast().booleanValue();
    }
	public static void	glGetBoolean(int pname, java.nio.ByteBuffer params){
		boolean b = ctx.getParameter(pname).<JSBoolean> cast().booleanValue();
		
		params.putInt(b ? 1 : 0);
		params.flip();
    }
	public static void	glGetClipPlane(int plane, java.nio.DoubleBuffer equation){

    }
	static double	glGetDouble(int pname){
		return (double) ctx.getParameterf(pname);
    }
	public static void	glGetDouble(int pname, java.nio.DoubleBuffer params){
		params.put((double) ctx.getParameterf(pname));
		params.flip();
    }
	static int	glGetError(){
		return ctx.getError();
    }
	static float glGetFloat(int pname) {
		return ctx.getParameterf(pname);
    }
	public static void	glGetFloat(int pname, java.nio.FloatBuffer params){
		params.put(ctx.getParameterf(pname));
    }
	static int	glGetInteger(int pname){
		if (pname == GL11.GL_MAX_CLIP_PLANES) return 5;
		return ctx.getParameteri(pname);
    }
	public static void	glGetInteger(int pname, java.nio.IntBuffer params){
		params.put(ctx.getParameteri(pname));
		params.flip();
    }
	public static void	glGetLight(int light, int pname, java.nio.FloatBuffer params){
		
    }
	public static void	glGetLight(int light, int pname, java.nio.IntBuffer params){

    }
	public static void	glGetMap(int target, int query, java.nio.DoubleBuffer v){

    }
	public static void	glGetMap(int target, int query, java.nio.FloatBuffer v){

    }
	public static void	glGetMap(int target, int query, java.nio.IntBuffer v){

    }
	public static void	glGetMaterial(int face, int pname, java.nio.FloatBuffer params){

    }
	public static void	glGetMaterial(int face, int pname, java.nio.IntBuffer params){

    }
	public static void	glGetPixelMap(int map, java.nio.FloatBuffer values){

    }
	public static void	glGetPixelMapfv(int map, long values_buffer_offset){

    }
	public static void	glGetPixelMapu(int map, java.nio.IntBuffer values){

    }
	public static void	glGetPixelMapu(int map, java.nio.ShortBuffer values){

    }
	public static void	glGetPixelMapuiv(int map, long values_buffer_offset){

    }
	public static void	glGetPixelMapusv(int map, long values_buffer_offset){

    }
	static java.nio.ByteBuffer	glGetPointer(int pname, long result_size){
		
		return null;
    }
	public static void	glGetPolygonStipple(java.nio.ByteBuffer mask){

    }
	public static void	glGetPolygonStipple(long mask_buffer_offset){

    }
	static java.lang.String	glGetString(int name){
		
//		ConstantMapper cm = new ConstantMapper(new String[] {
//			"GL_VENDOR",
//			"GL_VERSION",
//			"GL_RENDERER",
//			"GL_SHADING_LANGUAGE_VERSION",
//			"GL_EXTENSIONS"
//		});
		
		return ctx.getParameterString(name);
    }
	public static void	glGetTexEnv(int coord, int pname, java.nio.FloatBuffer params){
		return;
    }
	public static void	glGetTexEnv(int coord, int pname, java.nio.IntBuffer params){
		return;
    }
	static float glGetTexEnvf(int coord, int pname){
		return 0;

    }
	static int	glGetTexEnvi(int coord, int pname){
		return 0;
    }
	public static void	glGetTexGen(int coord, int pname, java.nio.DoubleBuffer params){
		return;
    }
	public static void	glGetTexGen(int coord, int pname, java.nio.FloatBuffer params){
		return;
    }
	public static void	glGetTexGen(int coord, int pname, java.nio.IntBuffer params){
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
	public static void	glGetTexImage(int target, int level, int format, int type, java.nio.ByteBuffer pixels){
		return;
    }
	public static void	glGetTexImage(int target, int level, int format, int type, java.nio.DoubleBuffer pixels){
		return;
    }
	public static void	glGetTexImage(int target, int level, int format, int type, java.nio.FloatBuffer pixels){
		return;
    }
	public static void	glGetTexImage(int target, int level, int format, int type, java.nio.IntBuffer pixels){
		return;
    }
	public static void	glGetTexImage(int target, int level, int format, int type, long pixels_buffer_offset){
		return;
    }
	public static void	glGetTexImage(int target, int level, int format, int type, java.nio.ShortBuffer pixels){
		return;
    }
	public static void	glGetTexLevelParameter(int target, int level, int pname, java.nio.FloatBuffer params){
		
		return;
    }
	public static void	glGetTexLevelParameter(int target, int level, int pname, java.nio.IntBuffer params){

    }
	static float glGetTexLevelParameterf(int target, int level, int pname){
		return 0;
    }
	static int	glGetTexLevelParameteri(int target, int level, int pname){
		return 0;
    }
	public static void	glGetTexParameter(int target, int pname, java.nio.FloatBuffer params){
		JSNumber s = ctx.getTexParameter(target, pname).<JSNumber> cast();
		params.put(s.floatValue());
		params.flip();
    }
	public static void	glGetTexParameter(int target, int pname, java.nio.IntBuffer params){
		JSNumber s = ctx.getTexParameter(target, pname).<JSNumber> cast();
		params.put(s.intValue());
		params.flip();
    }
	static float glGetTexParameterf(int target, int pname){
		
		return ctx.getTexParameter(target, pname).<JSNumber> cast().floatValue();
		
		
    }
	static int glGetTexParameteri(int target, int pname){
		return ctx.getTexParameter(target, pname).<JSNumber> cast().intValue();
		
		
    }
	public static void	glHint(int target, int mode){
		ctx.hint(target, mode);
		
    }
	public static void	glInitNames(){
		
    }
	public static void	glInterleavedArrays(int format, int stride, java.nio.ByteBuffer pointer){
//		FloatBuffer buf = pointer.asFloatBuffer();
		
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
//	private public static void bufferLoadInterleaved() {
//		
//	}
	public static void	glInterleavedArrays(int format, int stride, java.nio.DoubleBuffer pointer){
		
    }
	public static void	glInterleavedArrays(int format, int stride, java.nio.FloatBuffer pointer){

    }
	public static void	glInterleavedArrays(int format, int stride, java.nio.IntBuffer pointer){

    }
	public static void	glInterleavedArrays(int format, int stride, long pointer_buffer_offset){

    }
	public static void	glInterleavedArrays(int format, int stride, java.nio.ShortBuffer pointer){

    }
	static boolean	glIsEnabled(int cap){
		return ctx.isEnabled(cap);
    }
	static boolean	glIsList(int list){
		return false;
    }
	static boolean	glIsTexture(int texture){
		return true;
    }
	public static void	glLight(int light, int pname, java.nio.FloatBuffer params){
		
    }
	public static void	glLight(int light, int pname, java.nio.IntBuffer params){

    }
	public static void	glLightf(int light, int pname, float param){
		
    }
	public static void	glLighti(int light, int pname, int param){

    }
	public static void	glLightModel(int pname, java.nio.FloatBuffer params){

    }
	public static void	glLightModel(int pname, java.nio.IntBuffer params){

    }
	public static void	glLightModelf(int pname, float param){

    }
	public static void	glLightModeli(int pname, int param){

    }
	public static void	glLineStipple(int factor, short pattern){

    }
	public static void	glLineWidth(float width){

    }
	public static void	glListBase(int base){

    }
	public static void	glLoadIdentity(){
		
    }
	public static void	glLoadMatrix(java.nio.DoubleBuffer m){

    }
	public static void	glLoadMatrix(java.nio.FloatBuffer m){

    }
	public static void	glLoadName(int name){

    }
	public static void	glLogicOp(int opcode){

    }
	public static void	glMap1d(int target, double u1, double u2, int stride, int order, java.nio.DoubleBuffer points){

    }
	public static void	glMap1f(int target, float u1, float u2, int stride, int order, java.nio.FloatBuffer points){

    }
	public static void	glMap2d(int target, double u1, double u2, int ustride, int uorder, double v1, double v2, int vstride, int vorder, java.nio.DoubleBuffer points){

    }
	public static void	glMap2f(int target, float u1, float u2, int ustride, int uorder, float v1, float v2, int vstride, int vorder, java.nio.FloatBuffer points){

    }
	public static void	glMapGrid1d(int un, double u1, double u2){

    }
	public static void	glMapGrid1f(int un, float u1, float u2){

    }
	public static void	glMapGrid2d(int un, double u1, double u2, int vn, double v1, double v2){

    }
	public static void	glMapGrid2f(int un, float u1, float u2, int vn, float v1, float v2){

    }
	public static void	glMaterial(int face, int pname, java.nio.FloatBuffer params){

    }
	public static void	glMaterial(int face, int pname, java.nio.IntBuffer params){

    }
	public static void	glMaterialf(int face, int pname, float param){

    }
	public static void	glMateriali(int face, int pname, int param){

    }
	public static void	glMatrixMode(int mode){
		
    }
	public static void	glMultMatrix(java.nio.DoubleBuffer m){

    }
	public static void	glMultMatrix(java.nio.FloatBuffer m){

    }
	public static void	glNewList(int list, int mode){

    }
	public static void	glNormal3b(byte nx, byte ny, byte nz) {

    }
	public static void	glNormal3d(double nx, double ny, double nz){

    }
	public static void	glNormal3f(float nx, float ny, float nz){

    }
	public static void	glNormal3i(int nx, int ny, int nz){

    }
	public static void	glNormalPointer(int stride, java.nio.ByteBuffer pointer){

    }
	public static void	glNormalPointer(int stride, java.nio.DoubleBuffer pointer){

    }
	public static void	glNormalPointer(int stride, java.nio.FloatBuffer pointer){

    }
	public static void	glNormalPointer(int stride, java.nio.IntBuffer pointer){

    }
	public static void	glNormalPointer(int type, int stride, java.nio.ByteBuffer pointer){

    }
	public static void	glNormalPointer(int type, int stride, long pointer_buffer_offset){

    }
	public static void	glOrtho(double left, double right, double bottom, double top, double zNear, double zFar){

    }
	public static void	glPassThrough(float token){

    }
	public static void	glPixelMap(int map, java.nio.FloatBuffer values){

    }
	public static void	glPixelMapfv(int map, int values_mapsize, long values_buffer_offset){

    }
	public static void	glPixelMapu(int map, java.nio.IntBuffer values){

    }
	public static void	glPixelMapu(int map, java.nio.ShortBuffer values){

    }
	public static void	glPixelMapuiv(int map, int values_mapsize, long values_buffer_offset){

    }
	public static void	glPixelMapusv(int map, int values_mapsize, long values_buffer_offset){

    }
	public static void	glPixelStoref(int pname, float param){

    }
	public static void	glPixelStorei(int pname, int param){
	
    }
	public static void	glPixelTransferf(int pname, float param){

    }
	public static void	glPixelTransferi(int pname, int param){

    }
	public static void	glPixelZoom(float xfactor, float yfactor){

    }
	public static void	glPointSize(float size){

    }
	public static void	glPolygonMode(int face, int mode){

    }
	public static void	glPolygonOffset(float factor, float units){

    }
	public static void	glPolygonStipple(java.nio.ByteBuffer mask){

    }
	public static void	glPolygonStipple(long mask_buffer_offset){

    }
	public static void	glPopAttrib(){

    }
	public static void	glPopClientAttrib(){

    }
	public static void	glPopMatrix(){

    }
	public static void	glPopName(){

    }
	public static void	glPrioritizeTextures(java.nio.IntBuffer textures, java.nio.FloatBuffer priorities){

    }
	public static void	glPushAttrib(int mask){
		
    }
	public static void	glPushClientAttrib(int mask){

    }
	public static void	glPushMatrix(){

    }
	public static void	glPushName(int name){

    }
	public static void	glRasterPos2d(double x, double y){

    }
	public static void	glRasterPos2f(float x, float y){

    }
	public static void	glRasterPos2i(int x, int y){

    }
	public static void	glRasterPos3d(double x, double y, double z){

    }
	public static void	glRasterPos3f(float x, float y, float z){

    }
	public static void	glRasterPos3i(int x, int y, int z){

    }
	public static void	glRasterPos4d(double x, double y, double z, double w){

    }
	public static void	glRasterPos4f(float x, float y, float z, float w){

    }
	public static void	glRasterPos4i(int x, int y, int z, int w){

    }
	public static void	glReadBuffer(int mode){

    }
	public static void	glReadPixels(int x, int y, int width, int height, int format, int type, java.nio.ByteBuffer pixels){
		
		
		
		ArrayBuffer ab = GLUtil.glNewBuffer(pixels);
		Uint8Array ua = Uint8Array.create(ab);
		
//		ctx.readPixels(x, y, width, height, WebGLRenderingContext.RGBA, WebGLRenderingContext.RGBA, GLUtil.glCreateBufferFromJava(pixels));
		ctx.readPixels(x, y, width, height, format, type, ua);
		pixels.flip();
		GLUtil.glWriteArrayBufferToJavau(ua.getBuffer(), pixels);
		
		
		
		
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
	
	
	public static void	glReadPixels(int x, int y, int width, int height, int format, int type, java.nio.DoubleBuffer pixels){
		
//		glReadPixels(x, y, width, height, format, type, )
//		ctx.readPixels(x, y, width, height, format, WebGLRenderingContext.UNSIGNED_, null);
		System.out.println("Unsupported");
    }
//	public static void glConvertBufferToWebGL(FloatBuffer pixels) {
//		
//	}
	public static void	glReadPixels(int x, int y, int width, int height, int format, int type, java.nio.FloatBuffer pixels){
		Uint8Array ua = Uint8Array.create(GLUtil.glNewBuffer(pixels));
		ctx.readPixels(x, y, width, height, format, WebGL2RenderingContext.FLOAT, ua);
		pixels.flip();
		GLUtil.glWriteArrayBufferToJava(ua.getBuffer(), pixels);
		pixels.flip();
    }
	public static void	glReadPixels(int x, int y, int width, int height, int format, int type, java.nio.IntBuffer pixels){
		Int32Array sd = Int32Array.create(GLUtil.glCreateBufferFromJava(pixels));
		ctx.readPixels(x, y, width, height, format, WebGL2RenderingContext.UNSIGNED_INT, sd);
		pixels.flip();
		GLUtil.glWriteArrayBufferToJava(sd.getBuffer(), pixels);
		pixels.flip();
    }
	public static void	glReadPixels(int x, int y, int width, int height, int format, int type, long pixels_buffer_offset){
		return;
    }
	@JSBody(script = "return Array.from(arrBuf);", params = {"arrBuf"})
	public native static JSArray<JSNumber> glGetArrayFromBuf(ArrayBuffer buf);
	public static void	glReadPixels(int x, int y, int width, int height, int format, int type, java.nio.ShortBuffer pixels){
		Int16Array sd = Int16Array.create(GLUtil.glCreateBufferFromJava(pixels));
		ctx.readPixels(x, y, width, height, format, WebGLRenderingContext.SHORT, sd);
		pixels.flip();
		GLUtil.glWriteArrayBufferToJava(sd.getBuffer(), pixels);
		pixels.flip();
    }
	public static void	glRectd(double x1, double y1, double x2, double y2){
//		currentBatch.vertex2f((float)x1, (float)y1);
//		currentBatch.vertex2f((float)x2, (float)y1);
//		currentBatch.vertex2f((float)x2, (float)y2);
//		currentBatch.vertex2f((float)x1, (float)y1);
//		currentBatch.vertex2f((float)x2, (float)y2);
//		currentBatch.vertex2f((float)x1, (float)y2);
    }
	public static void	glRectf(float x1, float y1, float x2, float y2){
//		currentBatch.vertex2f((float)x1, (float)y1);
    }
	public static void	glRecti(int x1, int y1, int x2, int y2){
//		not supported
	}
	static int	glRenderMode(int mode){
		return 0;
    }
	public static void	glRotated(double angle, double x, double y, double z){
		
    }
	public static void	glRotatef(float angle, float x, float y, float z){

    }
	public static void	glScaled(double x, double y, double z){

    }
	public static void	glScalef(float x, float y, float z){
		
    }
	public static void	glScissor(int x, int y, int width, int height){
		ctx.scissor(x, y, width, height);
    }
//	public static void	glSelectBuffer(java.nio.IntBuffer buffer){
//
//    }
	public static void	glShadeModel(int mode){
		
    }
	public static void	glStencilFunc(int func, int ref, int mask){
		ctx.stencilFunc(func, ref, mask);
    }
	public static void	glStencilMask(int mask){
		ctx.stencilMask(mask);
    }
	public static void	glStencilOp(int fail, int zfail, int zpass){
		ctx.stencilOp(fail, zfail, zpass);
    }
	public static void	glTexCoord1d(double s){
		
    }
	public static void	glTexCoord1f(float s){

    }
	public static void	glTexCoord2d(double s, double t){

    }
	public static void	glTexCoord2f(float s, float t){

    }
	public static void	glTexCoord3d(double s, double t, double r){

    }
	public static void	glTexCoord3f(float s, float t, float r){

    }
	public static void	glTexCoord4d(double s, double t, double r, double q){

    }
	public static void	glTexCoord4f(float s, float t, float r, float q){

    }
	public static void	glTexCoordPointer(int size, int stride, java.nio.DoubleBuffer pointer){

    }
	public static void	glTexCoordPointer(int size, int stride, java.nio.FloatBuffer pointer){

    }
	public static void	glTexCoordPointer(int size, int stride, java.nio.IntBuffer pointer){

    }
	public static void	glTexCoordPointer(int size, int type, int stride, java.nio.ByteBuffer pointer){

    }
	public static void	glTexCoordPointer(int size, int type, int stride, long pointer_buffer_offset){

    }
	public static void	glTexCoordPointer(int size, int stride, java.nio.ShortBuffer pointer){

    }
	public static void	glTexEnv(int target, int pname, java.nio.FloatBuffer params){

    }
	public static void	glTexEnv(int target, int pname, java.nio.IntBuffer params){

    }
	public static void	glTexEnvf(int target, int pname, float param){

    }
	public static void	glTexEnvi(int target, int pname, int param){

    }
	public static void	glTexGen(int coord, int pname, java.nio.DoubleBuffer params){
		
    }
	public static void	glTexGen(int coord, int pname, java.nio.FloatBuffer params){

    }
	public static void	glTexGen(int coord, int pname, java.nio.IntBuffer params){

    }
	public static void	glTexGend(int coord, int pname, double param){

    }
	public static void	glTexGenf(int coord, int pname, float param){

    }
	public static void	glTexGeni(int coord, int pname, int param){

    }
	public static void	glTexImage1D(int target, int level, int internalformat, int width, int border, int format, int type, java.nio.ByteBuffer pixels){
		System.out.println("1D textures are unsupported");
    }
	public static void	glTexImage1D(int target, int level, int internalformat, int width, int border, int format, int type, java.nio.DoubleBuffer pixels){
		System.out.println("1D textures are unsupported");
    }
	public static void	glTexImage1D(int target, int level, int internalformat, int width, int border, int format, int type, java.nio.FloatBuffer pixels){
		System.out.println("1D textures are unsupported");
    }
	public static void	glTexImage1D(int target, int level, int internalformat, int width, int border, int format, int type, java.nio.IntBuffer pixels){
		System.out.println("1D textures are unsupported");
    }
	public static void	glTexImage1D(int target, int level, int internalformat, int width, int border, int format, int type, long pixels_buffer_offset){
		System.out.println("1D textures are unsupported");
    }
	public static void	glTexImage1D(int target, int level, int internalformat, int width, int border, int format, int type, java.nio.ShortBuffer pixels){
		System.out.println("1D textures are unsupported");
    }
	public static void	glTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, java.nio.ByteBuffer pixels){
		ctx.texImage2D(target, level, internalformat, width, height, border, format, type, Uint8Array.create(GLUtil.glCreateBufferFromJava(pixels)), type);
    }
	public static void	glTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, java.nio.DoubleBuffer pixels){
		ctx.texImage2D(target, level, internalformat, width, height, border, format, type, Float64Array.create(GLUtil.glCreateBufferFromJava(pixels)), type);
    }
	public static void	glTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, java.nio.FloatBuffer pixels){
		ctx.texImage2D(target, level, internalformat, width, height, border, format, type, Float32Array.create(GLUtil.glCreateBufferFromJava(pixels)), type);
    }
	public static void	glTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, java.nio.IntBuffer pixels){
		ctx.texImage2D(target, level, internalformat, width, height, border, format, type, Int32Array.create(GLUtil.glCreateBufferFromJava(pixels)), type);
    }
	public static void	glTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, long pixels_buffer_offset){
		
    }
	public static void	glTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, java.nio.ShortBuffer pixels){
		ctx.texImage2D(target, level, internalformat, width, height, border, format, type, Int16Array.create(GLUtil.glCreateBufferFromJava(pixels)), type);
    }
	public static void	glTexParameter(int target, int pname, java.nio.FloatBuffer param){
		ctx.texParameterf(target, pname, param.get());
    }
	public static void	glTexParameter(int target, int pname, java.nio.IntBuffer param){
		ctx.texParameteri(target, pname, param.get());
    }
	public static void	glTexParameterf(int target, int pname, float param){
		ctx.texParameterf(target, pname, param);
    }
	public static void	glTexParameteri(int target, int pname, int param){
		ctx.texParameteri(target, pname, param);
    }
	public static void	glTexSubImage1D(int target, int level, int xoffset, int width, int format, int type, java.nio.ByteBuffer pixels){
		
    }
	public static void	glTexSubImage1D(int target, int level, int xoffset, int width, int format, int type, java.nio.DoubleBuffer pixels){

    }
	public static void	glTexSubImage1D(int target, int level, int xoffset, int width, int format, int type, java.nio.FloatBuffer pixels){

    }
	public static void	glTexSubImage1D(int target, int level, int xoffset, int width, int format, int type, java.nio.IntBuffer pixels){

    }
	public static void	glTexSubImage1D(int target, int level, int xoffset, int width, int format, int type, long pixels_buffer_offset){

    }
	public static void	glTexSubImage1D(int target, int level, int xoffset, int width, int format, int type, java.nio.ShortBuffer pixels){

    }
	public static void	glTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, java.nio.ByteBuffer pixels){
		ctx.texSubImage2D(target, level, xoffset, yoffset, width, height, format, type, Uint8Array.create(GLUtil.glCreateBufferFromJava(pixels)));
    }
	public static void	glTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, java.nio.DoubleBuffer pixels){
		ctx.texSubImage2D(target, level, xoffset, yoffset, width, height, format, type, Float64Array.create(GLUtil.glCreateBufferFromJava(pixels)));
    }
	public static void	glTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, java.nio.FloatBuffer pixels){
		ctx.texSubImage2D(target, level, xoffset, yoffset, width, height, format, type, Float32Array.create(GLUtil.glCreateBufferFromJava(pixels)));
    }
	public static void	glTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, java.nio.IntBuffer pixels){
		ctx.texSubImage2D(target, level, xoffset, yoffset, width, height, format, type, Int32Array.create(GLUtil.glCreateBufferFromJava(pixels)));
    }
	public static void	glTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, long pixels_buffer_offset){
		
    }
	public static void	glTexSubImage2D(int target, int level, int xoffset, int yoffset, int width, int height, int format, int type, java.nio.ShortBuffer pixels){
		ctx.texSubImage2D(target, level, xoffset, yoffset, width, height, format, type, Int16Array.create(GLUtil.glCreateBufferFromJava(pixels)));
    }
	public static void	glTranslated(double x, double y, double z){
		
    }
	public static void	glTranslatef(float x, float y, float z){

    }
	public static void	glVertex2d(double x, double y){
		currentBatch.vertex2f((float) x, (float) y);
    }
	public static void	glVertex2f(float x, float y){
		currentBatch.vertex2f((float) x, (float) y);
    }
	public static void	glVertex2i(int x, int y){
		currentBatch.vertex2f((float) x, (float) y);
    }
	public static void	glVertex3d(double x, double y, double z){
		currentBatch.vertex3f((float) x, (float) y, (float) z);
    }
	public static void	glVertex3f(float x, float y, float z){
		currentBatch.vertex3f((float) x, (float) y, (float) z);
    }
	public static void	glVertex3i(int x, int y, int z){
		currentBatch.vertex3f((float) x, (float) y, (float) z);
    }
	public static void	glVertex4d(double x, double y, double z, double w){
		currentBatch.vertex4f((float) x, (float) y, (float) z, (float) w);
    }
	public static void	glVertex4f(float x, float y, float z, float w){
		currentBatch.vertex4f((float) x, (float) y, (float) z, (float) w);
    }
	public static void	glVertex4i(int x, int y, int z, int w){
		currentBatch.vertex4f((float) x, (float) y, (float) z, (float) w);
    }
	public static void	glVertexPointer(int size, int stride, java.nio.DoubleBuffer pointer){
		
    }
	public static void	glVertexPointer(int size, int stride, java.nio.FloatBuffer pointer){

    }
	public static void	glVertexPointer(int size, int stride, java.nio.IntBuffer pointer){

    }
	public static void	glVertexPointer(int size, int type, int stride, java.nio.ByteBuffer pointer){

    }
	
	public static void	glVertexPointer(int size, int type, int stride, long pointer_buffer_offset){

    }
	public static void	glVertexPointer(int size, int stride, java.nio.ShortBuffer pointer){

    }
	public static void	glViewport(int x, int y, int width, int height){
		ctx.viewport(x, y, width, height);
    }
}
