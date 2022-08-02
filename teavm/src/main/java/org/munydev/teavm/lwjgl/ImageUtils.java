package org.munydev.teavm.lwjgl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.teavm.classlib.impl.Base64Impl;
import org.teavm.interop.Async;
import org.teavm.interop.AsyncCallback;
import org.teavm.jso.ajax.ReadyStateChangeHandler;
import org.teavm.jso.ajax.XMLHttpRequest;
import org.teavm.jso.typedarrays.ArrayBuffer;

import com.baislsl.png.decode.Decoder;

public class ImageUtils {
	@Async
	private static native ArrayBuffer xhrGet(String url);
	
	private static void xhrGet(String url, AsyncCallback<ArrayBuffer> str) {
		XMLHttpRequest xhr = XMLHttpRequest.create();
		xhr.setResponseType("arraybuffer");
		xhr.setOnReadyStateChange(new ReadyStateChangeHandler() {

			@Override
			public void stateChanged() {
				// TODO Auto-generated method stub
				if (xhr.getStatus() == 4) {
					str.complete((ArrayBuffer) xhr.getResponse());
				}
			}
			
		});
		xhr.open("GET", url);
	}
	/**
	 * Lets browser do the encoding
	 * @param input Any input stream
	 * 
	 */
	public static void loadPng(InputStream input) {
//		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] b = new byte[200];
		try {
			b = IOUtils.toByteArray(input);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int imageLength = b.length;
		
		String url = "data:image/png;base64," + Base64.encodeBase64String(b);
		
		
		IOUtils.closeQuietly(input);
		
	}
	/**
	 * This loads it from http url. THIS IS COMPLETELY DIFFERENT FROM loadPng(String path) because this loads it from the file system
	 * 
	 * @param url HTTP Url
	 */
	public static void loadPngFromUrl(String url) {
		ArrayBuffer buf = xhrGet(url);
		
	}
}
