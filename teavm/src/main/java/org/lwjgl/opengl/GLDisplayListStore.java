package org.lwjgl.opengl;

import org.lwjgl.opengl.lists.GLRenderingInstruction;

/** Sadly the class is a store for each GL Display list and therefore it needs to be non-static */
public class GLDisplayListStore {
	public GLRenderingInstruction[] s = new GLRenderingInstruction[64];
	public int id;
	private int pos;
	public GLDisplayListStore(int id) {
		this.id = id;
		this.pos = 0;
		
	}
	
	public int storeNewInstruction(String riName, Object[] data, int type, int numArgs) {
		int curIdx = pos;
		s[curIdx] = new GLRenderingInstruction(riName, data,  type,  numArgs);
		pos++;
		return curIdx;
	}
	public int storeNewInstruction(String riName) {
		int curIdx = pos;
		s[curIdx] = new GLRenderingInstruction(riName);
		pos++;
		return curIdx;
		
	}
	
}
