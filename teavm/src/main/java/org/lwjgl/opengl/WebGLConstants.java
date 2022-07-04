package org.lwjgl.opengl;

public class WebGLConstants {
	static int DEPTH_BUFFER_BIT               = 0x00000100;
    static int STENCIL_BUFFER_BIT             = 0x00000400;
    static int COLOR_BUFFER_BIT               = 0x00004000;
    static int POINTS                         = 0x0000;
    static int LINES                          = 0x0001;
    static int LINE_LOOP                      = 0x0002;
    static int LINE_STRIP                     = 0x0003;
    static int TRIANGLES                      = 0x0004;
    static int TRIANGLE_STRIP                 = 0x0005;
    static int TRIANGLE_FAN                   = 0x0006;

    static int ZERO                           = 0;
    static int ONE                            = 1;
    static int SRC_COLOR                      = 0x0300;
    static int ONE_MINUS_SRC_COLOR            = 0x0301;
    static int SRC_ALPHA                      = 0x0302;
    static int ONE_MINUS_SRC_ALPHA            = 0x0303;
    static int DST_ALPHA                      = 0x0304;
    static int ONE_MINUS_DST_ALPHA            = 0x0305;

    static int DST_COLOR                      = 0x0306;
    static int ONE_MINUS_DST_COLOR            = 0x0307;
    static int SRC_ALPHA_SATURATE             = 0x0308;

    static int FUNC_ADD                       = 0x8006;
    static int BLEND_EQUATION                 = 0x8009;
    static int BLEND_EQUATION_RGB             = 0x8009;
    static int BLEND_EQUATION_ALPHA           = 0x883D;

    static int FUNC_SUBTRACT                  = 0x800A;
    static int FUNC_REVERSE_SUBTRACT          = 0x800B;

    static int BLEND_DST_RGB                  = 0x80C8;
    static int BLEND_SRC_RGB                  = 0x80C9;
    static int BLEND_DST_ALPHA                = 0x80CA;
    static int BLEND_SRC_ALPHA                = 0x80CB;
    static int CONSTANT_COLOR                 = 0x8001;
    static int ONE_MINUS_CONSTANT_COLOR       = 0x8002;
    static int CONSTANT_ALPHA                 = 0x8003;
    static int ONE_MINUS_CONSTANT_ALPHA       = 0x8004;
    static int BLEND_COLOR                    = 0x8005;

    static int ARRAY_BUFFER                   = 0x8892;
    static int ELEMENT_ARRAY_BUFFER           = 0x8893;
    static int ARRAY_BUFFER_BINDING           = 0x8894;
    static int ELEMENT_ARRAY_BUFFER_BINDING   = 0x8895;

    static int STREAM_DRAW                    = 0x88E0;
    static int STATIC_DRAW                    = 0x88E4;
    static int DYNAMIC_DRAW                   = 0x88E8;

    static int BUFFER_SIZE                    = 0x8764;
    static int BUFFER_USAGE                   = 0x8765;

    static int CURRENT_VERTEX_ATTRIB          = 0x8626;

    static int FRONT                          = 0x0404;
    static int BACK                           = 0x0405;
    static int FRONT_AND_BACK                 = 0x0408;

    static int CULL_FACE                      = 0x0B44;
    static int BLEND                          = 0x0BE2;
    static int DITHER                         = 0x0BD0;
    static int STENCIL_TEST                   = 0x0B90;
    static int DEPTH_TEST                     = 0x0B71;
    static int SCISSOR_TEST                   = 0x0C11;
    static int POLYGON_OFFSET_FILL            = 0x8037;
    static int SAMPLE_ALPHA_TO_COVERAGE       = 0x809E;
    static int SAMPLE_COVERAGE                = 0x80A0;

    static int NO_ERROR                       = 0;
    static int INVALID_ENUM                   = 0x0500;
    static int INVALID_VALUE                  = 0x0501;
    static int INVALID_OPERATION              = 0x0502;
    static int OUT_OF_MEMORY                  = 0x0505;

    static int CW                             = 0x0900;
    static int CCW                            = 0x0901;

    static int LINE_WIDTH                     = 0x0B21;
    static int ALIASED_POINT_SIZE_RANGE       = 0x846D;
    static int ALIASED_LINE_WIDTH_RANGE       = 0x846E;
    static int CULL_FACE_MODE                 = 0x0B45;
    static int FRONT_FACE                     = 0x0B46;
    static int DEPTH_RANGE                    = 0x0B70;
    static int DEPTH_WRITEMASK                = 0x0B72;
    static int DEPTH_CLEAR_VALUE              = 0x0B73;
    static int DEPTH_FUNC                     = 0x0B74;
    static int STENCIL_CLEAR_VALUE            = 0x0B91;
    static int STENCIL_FUNC                   = 0x0B92;
    static int STENCIL_FAIL                   = 0x0B94;
    static int STENCIL_PASS_DEPTH_FAIL        = 0x0B95;
    static int STENCIL_PASS_DEPTH_PASS        = 0x0B96;
    static int STENCIL_REF                    = 0x0B97;
    static int STENCIL_VALUE_MASK             = 0x0B93;
    static int STENCIL_WRITEMASK              = 0x0B98;
    static int STENCIL_BACK_FUNC              = 0x8800;
    static int STENCIL_BACK_FAIL              = 0x8801;
    static int STENCIL_BACK_PASS_DEPTH_FAIL   = 0x8802;
    static int STENCIL_BACK_PASS_DEPTH_PASS   = 0x8803;
    static int STENCIL_BACK_REF               = 0x8CA3;
    static int STENCIL_BACK_VALUE_MASK        = 0x8CA4;
    static int STENCIL_BACK_WRITEMASK         = 0x8CA5;
    static int VIEWPORT                       = 0x0BA2;
    static int SCISSOR_BOX                    = 0x0C10;
    static int COLOR_CLEAR_VALUE              = 0x0C22;
    static int COLOR_WRITEMASK                = 0x0C23;
    static int UNPACK_ALIGNMENT               = 0x0CF5;
    static int PACK_ALIGNMENT                 = 0x0D05;
    static int MAX_TEXTURE_SIZE               = 0x0D33;
    static int MAX_VIEWPORT_DIMS              = 0x0D3A;
    static int SUBPIXEL_BITS                  = 0x0D50;
    static int RED_BITS                       = 0x0D52;
    static int GREEN_BITS                     = 0x0D53;
    static int BLUE_BITS                      = 0x0D54;
    static int ALPHA_BITS                     = 0x0D55;
    static int DEPTH_BITS                     = 0x0D56;
    static int STENCIL_BITS                   = 0x0D57;
    static int POLYGON_OFFSET_UNITS           = 0x2A00;
    static int POLYGON_OFFSET_FACTOR          = 0x8038;
    static int TEXTURE_BINDING_2D             = 0x8069;
    static int SAMPLE_BUFFERS                 = 0x80A8;
    static int SAMPLES                        = 0x80A9;
    static int SAMPLE_COVERAGE_VALUE          = 0x80AA;
    static int SAMPLE_COVERAGE_INVERT         = 0x80AB;

    static int COMPRESSED_TEXTURE_FORMATS     = 0x86A3;

    static int DONT_CARE                      = 0x1100;
    static int FASTEST                        = 0x1101;
    static int NICEST                         = 0x1102;

    static int GENERATE_MIPMAP_HINT            = 0x8192;

    static int BYTE                           = 0x1400;
    static int UNSIGNED_BYTE                  = 0x1401;
    static int SHORT                          = 0x1402;
    static int UNSIGNED_SHORT                 = 0x1403;
    static int INT                            = 0x1404;
    static int UNSIGNED_INT                   = 0x1405;
    static int FLOAT                          = 0x1406;

    static int DEPTH_COMPONENT                = 0x1902;
    static int ALPHA                          = 0x1906;
    static int RGB                            = 0x1907;
    static int RGBA                           = 0x1908;
    static int LUMINANCE                      = 0x1909;
    static int LUMINANCE_ALPHA                = 0x190A;

    static int UNSIGNED_SHORT_4_4_4_4         = 0x8033;
    static int UNSIGNED_SHORT_5_5_5_1         = 0x8034;
    static int UNSIGNED_SHORT_5_6_5           = 0x8363;

    static int FRAGMENT_SHADER                  = 0x8B30;
    static int VERTEX_SHADER                    = 0x8B31;
    static int MAX_VERTEX_ATTRIBS               = 0x8869;
    static int MAX_VERTEX_UNIFORM_VECTORS       = 0x8DFB;
    static int MAX_VARYING_VECTORS              = 0x8DFC;
    static int MAX_COMBINED_TEXTURE_IMAGE_UNITS = 0x8B4D;
    static int MAX_VERTEX_TEXTURE_IMAGE_UNITS   = 0x8B4C;
    static int MAX_TEXTURE_IMAGE_UNITS          = 0x8872;
    static int MAX_FRAGMENT_UNIFORM_VECTORS     = 0x8DFD;
    static int SHADER_TYPE                      = 0x8B4F;
    static int DELETE_STATUS                    = 0x8B80;
    static int LINK_STATUS                      = 0x8B82;
    static int VALIDATE_STATUS                  = 0x8B83;
    static int ATTACHED_SHADERS                 = 0x8B85;
    static int ACTIVE_UNIFORMS                  = 0x8B86;
    static int ACTIVE_ATTRIBUTES                = 0x8B89;
    static int SHADING_LANGUAGE_VERSION         = 0x8B8C;
    static int CURRENT_PROGRAM                  = 0x8B8D;

    static int NEVER                          = 0x0200;
    static int LESS                           = 0x0201;
    static int EQUAL                          = 0x0202;
    static int LEQUAL                         = 0x0203;
    static int GREATER                        = 0x0204;
    static int NOTEQUAL                       = 0x0205;
    static int GEQUAL                         = 0x0206;
    static int ALWAYS                         = 0x0207;

    static int KEEP                           = 0x1E00;
    static int REPLACE                        = 0x1E01;
    static int INCR                           = 0x1E02;
    static int DECR                           = 0x1E03;
    static int INVERT                         = 0x150A;
    static int INCR_WRAP                      = 0x8507;
    static int DECR_WRAP                      = 0x8508;

    static int VENDOR                         = 0x1F00;
    static int RENDERER                       = 0x1F01;
    static int VERSION                        = 0x1F02;

    static int NEAREST                        = 0x2600;
    static int LINEAR                         = 0x2601;

    static int NEAREST_MIPMAP_NEAREST         = 0x2700;
    static int LINEAR_MIPMAP_NEAREST          = 0x2701;
    static int NEAREST_MIPMAP_LINEAR          = 0x2702;
    static int LINEAR_MIPMAP_LINEAR           = 0x2703;

    static int TEXTURE_MAG_FILTER             = 0x2800;
    static int TEXTURE_MIN_FILTER             = 0x2801;
    static int TEXTURE_WRAP_S                 = 0x2802;
    static int TEXTURE_WRAP_T                 = 0x2803;

    static int TEXTURE_2D                     = 0x0DE1;
    static int TEXTURE                        = 0x1702;

    static int TEXTURE_CUBE_MAP               = 0x8513;
    static int TEXTURE_BINDING_CUBE_MAP       = 0x8514;
    static int TEXTURE_CUBE_MAP_POSITIVE_X    = 0x8515;
    static int TEXTURE_CUBE_MAP_NEGATIVE_X    = 0x8516;
    static int TEXTURE_CUBE_MAP_POSITIVE_Y    = 0x8517;
    static int TEXTURE_CUBE_MAP_NEGATIVE_Y    = 0x8518;
    static int TEXTURE_CUBE_MAP_POSITIVE_Z    = 0x8519;
    static int TEXTURE_CUBE_MAP_NEGATIVE_Z    = 0x851A;
    static int MAX_CUBE_MAP_TEXTURE_SIZE      = 0x851C;

    static int TEXTURE0                       = 0x84C0;
    static int TEXTURE1                       = 0x84C1;
    static int TEXTURE2                       = 0x84C2;
    static int TEXTURE3                       = 0x84C3;
    static int TEXTURE4                       = 0x84C4;
    static int TEXTURE5                       = 0x84C5;
    static int TEXTURE6                       = 0x84C6;
    static int TEXTURE7                       = 0x84C7;
    static int TEXTURE8                       = 0x84C8;
    static int TEXTURE9                       = 0x84C9;
    static int TEXTURE10                      = 0x84CA;
    static int TEXTURE11                      = 0x84CB;
    static int TEXTURE12                      = 0x84CC;
    static int TEXTURE13                      = 0x84CD;
    static int TEXTURE14                      = 0x84CE;
    static int TEXTURE15                      = 0x84CF;
    static int TEXTURE16                      = 0x84D0;
    static int TEXTURE17                      = 0x84D1;
    static int TEXTURE18                      = 0x84D2;
    static int TEXTURE19                      = 0x84D3;
    static int TEXTURE20                      = 0x84D4;
    static int TEXTURE21                      = 0x84D5;
    static int TEXTURE22                      = 0x84D6;
    static int TEXTURE23                      = 0x84D7;
    static int TEXTURE24                      = 0x84D8;
    static int TEXTURE25                      = 0x84D9;
    static int TEXTURE26                      = 0x84DA;
    static int TEXTURE27                      = 0x84DB;
    static int TEXTURE28                      = 0x84DC;
    static int TEXTURE29                      = 0x84DD;
    static int TEXTURE30                      = 0x84DE;
    static int TEXTURE31                      = 0x84DF;
    static int ACTIVE_TEXTURE                 = 0x84E0;

    static int REPEAT                         = 0x2901;
    static int CLAMP_TO_EDGE                  = 0x812F;
    static int MIRRORED_REPEAT                = 0x8370;

    static int FLOAT_VEC2                     = 0x8B50;
    static int FLOAT_VEC3                     = 0x8B51;
    static int FLOAT_VEC4                     = 0x8B52;
    static int INT_VEC2                       = 0x8B53;
    static int INT_VEC3                       = 0x8B54;
    static int INT_VEC4                       = 0x8B55;
    static int BOOL                           = 0x8B56;
    static int BOOL_VEC2                      = 0x8B57;
    static int BOOL_VEC3                      = 0x8B58;
    static int BOOL_VEC4                      = 0x8B59;
    static int FLOAT_MAT2                     = 0x8B5A;
    static int FLOAT_MAT3                     = 0x8B5B;
    static int FLOAT_MAT4                     = 0x8B5C;
    static int SAMPLER_2D                     = 0x8B5E;
    static int SAMPLER_CUBE                   = 0x8B60;

    /* Vertex Arrays */
    static int VERTEX_ATTRIB_ARRAY_ENABLED        = 0x8622;
    static int VERTEX_ATTRIB_ARRAY_SIZE           = 0x8623;
    static int VERTEX_ATTRIB_ARRAY_STRIDE         = 0x8624;
    static int VERTEX_ATTRIB_ARRAY_TYPE           = 0x8625;
    static int VERTEX_ATTRIB_ARRAY_NORMALIZED     = 0x886A;
    static int VERTEX_ATTRIB_ARRAY_POINTER        = 0x8645;
    static int VERTEX_ATTRIB_ARRAY_BUFFER_BINDING = 0x889F;

/* Shader Source */
    static int COMPILE_STATUS                 = 0x8B81;

/* Shader Precision-Specified Types */
    static int LOW_FLOAT                      = 0x8DF0;
    static int MEDIUM_FLOAT                   = 0x8DF1;
    static int HIGH_FLOAT                     = 0x8DF2;
    static int LOW_INT                        = 0x8DF3;
    static int MEDIUM_INT                     = 0x8DF4;
    static int HIGH_INT                       = 0x8DF5;

    /* Framebuffer Object. */
    static int FRAMEBUFFER                    = 0x8D40;
    static int RENDERBUFFER                   = 0x8D41;

    static int RGBA4                          = 0x8056;
    static int RGB5_A1                        = 0x8057;
    static int RGB565                         = 0x8D62;
    static int DEPTH_COMPONENT16              = 0x81A5;
    static int STENCIL_INDEX                  = 0x1901;
    static int STENCIL_INDEX8                 = 0x8D48;
    static int DEPTH_STENCIL                  = 0x84F9;

    static int RENDERBUFFER_WIDTH             = 0x8D42;
    static int RENDERBUFFER_HEIGHT            = 0x8D43;
    static int RENDERBUFFER_INTERNAL_FORMAT   = 0x8D44;
    static int RENDERBUFFER_RED_SIZE          = 0x8D50;
    static int RENDERBUFFER_GREEN_SIZE        = 0x8D51;
    static int RENDERBUFFER_BLUE_SIZE         = 0x8D52;
    static int RENDERBUFFER_ALPHA_SIZE        = 0x8D53;
    static int RENDERBUFFER_DEPTH_SIZE        = 0x8D54;
    static int RENDERBUFFER_STENCIL_SIZE      = 0x8D55;

    static int FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE           = 0x8CD0;
    static int FRAMEBUFFER_ATTACHMENT_OBJECT_NAME           = 0x8CD1;
    static int FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL         = 0x8CD2;
    static int FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE = 0x8CD3;

    static int COLOR_ATTACHMENT0              = 0x8CE0;
    static int DEPTH_ATTACHMENT               = 0x8D00;
    static int STENCIL_ATTACHMENT             = 0x8D20;
    static int DEPTH_STENCIL_ATTACHMENT       = 0x821A;

    static int NONE                           = 0;

    static int FRAMEBUFFER_COMPLETE                      = 0x8CD5;
    static int FRAMEBUFFER_INCOMPLETE_ATTACHMENT         = 0x8CD6;
    static int FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT = 0x8CD7;
    static int FRAMEBUFFER_INCOMPLETE_DIMENSIONS         = 0x8CD9;
    static int FRAMEBUFFER_UNSUPPORTED                   = 0x8CDD;

    static int FRAMEBUFFER_BINDING            = 0x8CA6;
    static int RENDERBUFFER_BINDING           = 0x8CA7;
    static int MAX_RENDERBUFFER_SIZE          = 0x84E8;

    static int INVALID_FRAMEBUFFER_OPERATION  = 0x0506;

    static int UNPACK_FLIP_Y_WEBGL            = 0x9240;
    static int UNPACK_PREMULTIPLY_ALPHA_WEBGL = 0x9241;
    static int CONTEXT_LOST_WEBGL             = 0x9242;
    static int UNPACK_COLORSPACE_CONVERSION_WEBGL = 0x9243;
    static int BROWSER_DEFAULT_WEBGL          = 0x9244;
}
