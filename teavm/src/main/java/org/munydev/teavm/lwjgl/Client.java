package org.munydev.teavm.lwjgl;

import org.teavm.jso.dom.events.Event;

import org.teavm.jso.dom.events.EventListener;
import org.teavm.jso.dom.html.HTMLCanvasElement;
import org.teavm.jso.dom.html.HTMLDocument;
import org.teavm.jso.*;
import org.teavm.jso.browser.*;
import org.teavm.webgl2.WebGL2RenderingContext;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Batch;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

import static org.teavm.jso.browser.Window.*;
public class Client {
    public static void main(String[] args) {
        HTMLDocument document = HTMLDocument.current();
        HTMLCanvasElement canvas = (HTMLCanvasElement)document.createElement("canvas");
        document.getBody().getStyle().setProperty("margin", "0");
        document.getBody().getStyle().setProperty("padding", "0");
        canvas.setWidth(Window.current().getInnerWidth());
        canvas.setHeight(Window.current().getInnerHeight());
        
        WebGL2RenderingContext ctx = (WebGL2RenderingContext)canvas.getContext("webgl2");
        
        if (ctx == null) {
        	alert("Could not initialize OpenGL context");
        }
        document.getBody().getStyle().setProperty("overflow", "hidden");
        Window.current().addEventListener("resize", new EventListener<Event>() {

			@Override
			public void handleEvent(Event evt) {
				// TODO Auto-generated method stub
				ctx.getCanvas().setWidth(Window.current().getInnerWidth());
				ctx.getCanvas().setHeight(Window.current().getInnerHeight());
				
				GL11.glViewport(0, 0, Window.current().getInnerWidth(), Window.current().getInnerHeight());
				evt.preventDefault();
				evt.stopPropagation();
			}
        	
        });
        
        CurrentContext.setCurrentContext(ctx);
        Mouse.create();
        Mouse.setGrabbed(true);
        Keyboard.create();
        requestAnimationFrame(new AnimationFrameCallback() {

			@Override
			public void onAnimationFrame(double timestamp) {
				// TODO Auto-generated method stub
				
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
//				log(String.valueOf(Mouse.isButtonDown(0)));
//				log(String.valueOf(Keyboard.isKeyDown(Keyboard.KEY_0)));
//				System.out.print('\n');
				Mouse.poll();
				
				requestAnimationFrame(this);
				
			}
        	
        });
        document.getBody().appendChild(canvas);
        
        
        
    }
    @JSBody(script = "window.console.log(param);", params = {"param"})
    public native static void log(String param);
    
    @JSBody(script = "window.showOpenDirectoryPicker()")
    public native static void showOpenDirectoryPicker();
    
    @JSBody(params = "message",script = "window.alert(message)")
    public native static void alert(String message);
}
