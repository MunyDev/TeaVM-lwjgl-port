package org.munydev.teavm.lwjgl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GLObjectBuffers;
import org.lwjgl.util.GLUtil;
import org.munydev.fs.FSFile;
import org.munydev.fs.FSFileInputStream;

import static org.lwjgl.opengl.GL11.*;
import org.teavm.classlib.impl.Base64Impl;
import org.teavm.interop.Async;
import org.teavm.interop.AsyncCallback;
import org.teavm.jso.JSBody;
import org.teavm.jso.ajax.ReadyStateChangeHandler;
import org.teavm.jso.ajax.XMLHttpRequest;
import org.teavm.jso.canvas.ImageData;
import org.teavm.jso.core.JSArray;
import org.teavm.jso.core.JSNumber;
import org.teavm.jso.dom.events.Event;
import org.teavm.jso.dom.html.HTMLImageElement;
import org.teavm.jso.typedarrays.ArrayBuffer;
import org.teavm.jso.typedarrays.Uint8Array;
import org.teavm.jso.webgl.WebGLRenderingContext;
import org.teavm.jso.webgl.WebGLTexture;
import org.teavm.webgl2.WebGL2RenderingContext;
import org.teavm.jso.dom.events.EventListener;

//import com.baislsl.png.decode.Decoder;

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
				
				if (xhr.getReadyState() == 4) {
					System.out.println("recieved");
					str.complete((ArrayBuffer) xhr.getResponse());
				}
			}
			
		});
		xhr.open("GET", url, true);
		xhr.send();
	}
	@SuppressWarnings("resource")
	public static void loadImage(FSFile ff, int id) {
		new FSFileInputStream(ff, (fin)->{
//			byte[] b = GLUtil.glWriteArrayToJByteArray(fin.data);
//			String url = "data:image/png;base64," + Base64.encodeBase64String(b);
			
			HTMLImageElement elem = createJSImage();
			WebGLTexture wgt = (WebGLTexture) GLObjectBuffers.getObject(id);
			ctx.bindTexture(GL_TEXTURE_2D, wgt);
			Uint8Array rgb = Uint8Array.create(4);
			rgb.set(new byte[] {(byte) 255, 0, 0, (byte) 255});
			ctx.texImage2D(GL_TEXTURE_2D, 0, GL_RGBA, 1, 1, 0, GL_RGBA, GL_UNSIGNED_BYTE, rgb, 0);
			elem.addEventListener("load", (ev)->{
				ctx.bindTexture(GL_TEXTURE_2D, wgt);
				ctx.texImage2D(GL_TEXTURE_2D, 0, GL_RGBA, GL_RGBA, GL_UNSIGNED_BYTE, elem);
				
				if (isPowerOf2(elem.getWidth()) && isPowerOf2(elem.getHeight())) {
					ctx.generateMipmap(GL_TEXTURE_2D);
				}else {
					GL11.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
					GL11.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
					GL11.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
					GL11.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
				}
				fin.close();
			});
			elem.setSrc(fin.getUrl());
			
		});
	}
	
	/**
	 * Lets browser do the encoding
	 * @param input Any input stream
	 * @return returns the OpenGL Texture ID
	 */
	public static int loadPng(InputStream input) {
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
		
		HTMLImageElement elem = createJSImage();
		Uint8Array arr = Uint8Array.create(4);
		arr.set(new byte[] {(byte) 255, 0, 0, 0});
		
		
		
		int texID = GL11.glGenTextures();
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, texID);
		
		
		
		WebGL2RenderingContext ctx = (WebGL2RenderingContext) CurrentContext.getContext();
		ctx.texImage2D(GL_TEXTURE_2D, 0, GL_RGBA, 1, 1, 0, GL_RGBA, GL_UNSIGNED_BYTE, arr);
		elem.addEventListener("load", new EventListener<Event>() {

			@Override
			public void handleEvent(Event evt) {
				// TODO Auto-generated method stub
				ctx.texImage2D(GL_TEXTURE_2D, 0, GL_RGBA, GL_RGBA, GL_UNSIGNED_BYTE, elem);
				if (isPowerOf2(elem.getWidth()) && isPowerOf2(elem.getHeight())) {
					ctx.generateMipmap(GL_TEXTURE_2D);
				}else {
					GL11.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
					GL11.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
					GL11.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
					GL11.glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
				}
//				int x = WebGLRenderingContext.TEXTURE_2D;
			}
			
		});
		elem.setSrc(url);
		IOUtils.closeQuietly(input);
		return texID;
	}
	/**
	 * inefficient
	 * @param in
	 * @param texID
	 */
	public static void loadPng(InputStream in, int texID) {
		WebGLTexture wgl = (WebGLTexture) GLObjectBuffers.getObject(texID);
		byte[] b = new byte[200];
		try {
			b = IOUtils.toByteArray(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String url = "data:image/png;base64,"+Base64.encodeBase64String(b);
		HTMLImageElement hie = createJSImage();
		System.out.println(url);
		GL11.glBindTexture(GL_TEXTURE_2D, texID);
//		ctx.texImage2D(GL_TEXTURE_2D, 0, GL_RGBA, GL_RGBA, GL_UNSIGNED_BYTE, hie);
		hie.addEventListener("load", (ev)->{
			ctx.bindTexture(WebGLRenderingContext.TEXTURE_2D, wgl);
			ctx.texImage2D(GL_TEXTURE_2D, 0, GL_RGBA, GL_RGBA, GL_UNSIGNED_BYTE, hie);
			
			if (isPowerOf2(hie.getWidth()) && isPowerOf2(hie.getHeight())) {
				ctx.generateMipmap(GL_TEXTURE_2D);
			}else {
				ctx.texParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
				ctx.texParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
				ctx.texParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
				ctx.texParameteri(GL_TEXTURE_2D,GL_TEXTURE_WRAP_T, GL_REPEAT);
				
			}
		});
		hie.setSrc(url);
	}
	private static boolean isPowerOf2(int value) {
		  return (value & (value - 1)) == 0;
	}
	@JSBody(script = "return new Image();")
	private static native HTMLImageElement createJSImage();
	/**
	 * This loads it from http url. THIS IS COMPLETELY DIFFERENT FROM loadPng(String path) because this loads it from the file system
	 * 
	 * @param url HTTP Url
	 */
	public static int loadPngFromUrl(String url) {
		ArrayBuffer buf = xhrGet(url);
		Uint8Array ua = Uint8Array.create(buf);
		byte[] a = new byte[ua.getLength()];
		
		GLUtil.glWriteBufferToJArray(buf, a);
		
		return loadPng(new ByteArrayInputStream(a));
		
	}
}
