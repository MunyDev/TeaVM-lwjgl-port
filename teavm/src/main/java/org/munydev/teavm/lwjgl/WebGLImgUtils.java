package org.munydev.teavm.lwjgl;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
public class WebGLImgUtils {
	public static void wglTexImage(InputStream s) {
		byte[] a = null;
		try {
			a = IOUtils.toByteArray(s);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		Base64.encodeBase64String(a);
	}
}
