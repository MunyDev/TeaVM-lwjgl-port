package org.lwjgl.opengl;

import java.nio.ByteBuffer;

import org.lwjgl.util.GLUtil;
import org.teavm.jso.typedarrays.*;
public class ClientSideVertexArrays {
	public static void uploadVerices(ByteBuffer bb) {
		ArrayBuffer ab = GLUtil.glCreateBufferFromJava(bb);
		
	}
}
