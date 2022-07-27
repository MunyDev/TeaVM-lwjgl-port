package org.munydev.teavm.lwjgl;

import org.teavm.jso.dom.html.HTMLDocument;
import org.teavm.jso.dom.html.HTMLElement;
import org.teavm.jso.dom.html.HTMLLinkElement;
import org.teavm.jso.*;
import org.teavm.jso.ajax.XMLHttpRequest;
import org.teavm.jso.browser.*;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import static org.teavm.jso.browser.Window.*;

import org.apache.commons.codec.binary.Base64;
public class Client {
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
    	HTMLLinkElement link = (HTMLLinkElement) Display.getWindow().getDocument().createElement("link");
    	link.setRel("shortcut icon");
    	link.setHref("https://stackoverflow.com/favicon.ico");
    	XMLHttpRequest xhr =  XMLHttpRequest.create();
    	
    	Display.getWindow().getDocument().getHead().appendChild(link);
    	
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
					
					Window.current().close();
				}
				
				GL11.glClearColor(0, 0, 0, 1);
				GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
				
				GL11.glBegin(GL11.GL_TRIANGLES);
				GL11.glColor3f(1, 0, 0);
				GL11.glVertex3f(-0.5f, 0.5f, 0);
				GL11.glColor3f(0, 1, 0);
				GL11.glVertex3f(0.5f, 0.5f, 0);
				GL11.glColor3f(0, 0, 1);
				GL11.glVertex3f(0.5f, -0.5f, 0);
				GL11.glColor3f(1, 0, 0);
				GL11.glVertex3f(-0.5f, 0.5f, 0);
				GL11.glColor3f(0, 0, 1);
				GL11.glVertex3f(0.5f, -0.5f, 0);
				GL11.glColor3f(1, 1, 1);
				GL11.glVertex3f(-0.5f, -0.5f, 0);
				
				GL11.glEnd();
				
				log(String.valueOf(Mouse.isButtonDown(0)), Display.getWindow());
				log(String.valueOf(Keyboard.isKeyDown(Keyboard.KEY_0)), Display.getWindow());
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
