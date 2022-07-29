package org.munydev.teavm.lwjgl;

import org.teavm.jso.dom.html.HTMLDocument;
import org.teavm.jso.dom.html.HTMLElement;
import org.teavm.jso.dom.html.HTMLLinkElement;
import org.teavm.jso.typedarrays.ArrayBuffer;
import org.teavm.jso.typedarrays.Uint8Array;
import org.teavm.interop.Async;
import org.teavm.interop.AsyncCallback;
import org.teavm.jso.*;
import org.teavm.jso.ajax.ReadyStateChangeHandler;
import org.teavm.jso.ajax.XMLHttpRequest;
import org.teavm.jso.browser.*;
import org.lwjgl.BufferUtils;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.util.GLUtil;

import static org.teavm.jso.browser.Window.*;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
public class Client {
	static byte[] data;
	@Async
	public static native String xhrOpen(String x);
	
	public static void xhrOpen(String x, AsyncCallback<String> str) {
		XMLHttpRequest xhr =  XMLHttpRequest.create();
		xhr.open("GET", x, true);
    	xhr.setResponseType("arraybuffer");
    	xhr.setOnReadyStateChange(new ReadyStateChangeHandler() {

			@Override
			public void stateChanged() {
				// TODO Auto-generated method stub
				if (xhr.getReadyState() == XMLHttpRequest.DONE) {
					Uint8Array v = Uint8Array.create(((ArrayBuffer) xhr.getResponse()));
					data = GLUtil.glWriteArrayToJByteArray(v);
					str.complete("lol");
				}
			}
    		
    	});
    	
    	xhr.send();
	}
    public static void main(String[] args) {
//        HTMLDocument document = HTMLDocument.current();
//        HTMLCanvasElement canvas = (HTMLCanvasElement)document.createElement("canvas");
//        document.getBody().getStyle().setProperty("margin", "0");
//        document.getBody().getStyle().setProperty("padding", "0");
//        canvas.setWidth(Window.current().getInnerWidth());
//        canvas.setHeight(Window.current().getInnerHeight());
//        
//        WebGL2RenderingContext ctx = (WebGL2RenderingContext)canvas.getContext("webgl2");
//        
//        if (ctx == null) {
//        	alert("Could not initialize OpenGL context");
//        }
//        document.getBody().getStyle().setProperty("overflow", "hidden");
//        Window.current().addEventListener("resize", new EventListener<Event>() {
//
//			@Override
//			public void handleEvent(Event evt) {
//				// TODO Auto-generated method stub
//				ctx.getCanvas().setWidth(Window.current().getInnerWidth());
//				ctx.getCanvas().setHeight(Window.current().getInnerHeight());
//				
//				GL11.glViewport(0, 0, Window.current().getInnerWidth(), Window.current().getInnerHeight());
//				evt.preventDefault();
//				evt.stopPropagation();
//			}
//        	
//        });
    	HTMLDocument document = HTMLDocument.current();
    	
    	document.getBody().setInnerHTML("If you don't see the game window, allow popups(disable popup blocker) and reload");
    	Display.setDisplayMode(new DisplayMode(640, 480, true));
    	Display.create();
    	xhrOpen("./default-icon.ico");
//    	IntBuffer ai = BufferUtils.createIntBuffer(1);
//    	ai.flip();
//    	glGenTextures(ai);
//    	ai.flip();
//    	int k = ai.get();
//    	glBindTexture(GL_TEXTURE_2D, k);
//    	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
//    	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
//    	
//    	
//    	try {
//			BufferedImage bi = ImageIO.read(new ByteArrayInputStream(data));
//			int[] rgb = new int[bi.getWidth() * bi.getHeight()];
//			bi.getRGB(0, 0, bi.getWidth(), bi.getHeight(), rgb, 0, bi.getWidth());
//			ByteBuffer b = BufferUtils.createByteBuffer(bi.getWidth() * bi.getHeight() * 4);
//			for (int i = 0; i < bi.getWidth(); i++) {
//				for (int j = 0; j < bi.getHeight(); j++) {
//					int argb = rgb[i + j * bi.getWidth()];
//					
//					b.put((byte) ((argb >> 16) & 0xff));
//					b.put((byte) ((argb >> 8) & 0xff));
//					b.put((byte) ((argb >> 0) & 0xff));
//					b.put((byte) ((argb >> 24) & 0xff));
//				}
//			}
//			b.flip();
//			GL11.glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, bi.getWidth(), bi.getHeight(), 0, GL_RGBA, GL_UNSIGNED_BYTE, b);
//			
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	System.out.println(data);
    	HTMLLinkElement link = (HTMLLinkElement) Display.getWindow().getDocument().createElement("link");
    	link.setRel("icon");
    	link.setType("image/x-icon");
    	link.setHref("data:image/x-icon;base64," +Base64.encodeBase64String(data));
    	document.getHead().appendChild(link);
    	System.out.println(Base64.encodeBase64String(data));
    	Window.setTimeout(new TimerHandler() {

			@Override
			public void onTimer() {
				// TODO Auto-generated method stub
				Display.getWindow().getDocument().getHead().appendChild(link);
				log("finished", Display.getWindow());
			}
    		
    	}, 5000);
    	
    	
//        CurrentContext.setCurrentContext(ctx);
//        Mouse.create();
//        Mouse.setGrabbed(true);
//        Keyboard.create();
    	
    	
    	
        Mouse.setGrabbed(true);
        Display.setFullscreen(true);
        Display.setFullscreenKey(Keyboard.KEY_F11);
        
        requestAnimationFrame(new AnimationFrameCallback() {

			@Override
			public void onAnimationFrame(double timestamp) {
				// TODO Auto-generated method stub
				if (Display.isCloseRequested()) {
					
//					Window.current().close();
				}
				
				glClearColor(0, 0, 0, 1);
				glClear(GL_COLOR_BUFFER_BIT);
				
				glBegin(GL_TRIANGLES);
				GL11.glTexCoord2f(0, 0);
				glVertex3f(-0.5f, 0.5f, 0);
				GL11.glTexCoord2f(1, 0);
				glVertex3f(0.5f, 0.5f, 0);
				GL11.glTexCoord2f(1, 1);
				glVertex3f(0.5f, -0.5f, 0);
				GL11.glTexCoord2f(0, 0);
				glVertex3f(-0.5f, 0.5f, 0);
				GL11.glTexCoord2f(1, 1);
				glVertex3f(0.5f, -0.5f, 0);
				GL11.glTexCoord2f(0, 1);
				glVertex3f(-0.5f, -0.5f, 0);
				
				glEnd();
				
//				log(String.valueOf(Mouse.isButtonDown(0)), Display.getWindow());
//				log(String.valueOf(Keyboard.isKeyDown(Keyboard.KEY_0)), Display.getWindow());
//				System.out.print('\n');
				Display.update();
				
				requestAnimationFrame(this);
				
			}
        	
        });
//        document.getBody().appendChild(canvas);
        
        
        
    }
    @JSBody(script = "window.console.log(param);", params = {"param", "window"})
    public native static void log(String param, Window w);
    
    @JSBody(script = "window.showOpenDirectoryPicker()")
    public native static void showOpenDirectoryPicker();
    
    @JSBody(params = "message",script = "window.alert(message)")
    public native static void alert(String message);
}
