package org.munydev.teavm.lwjgl;

import org.teavm.jso.dom.events.Event;

import org.teavm.jso.dom.events.EventListener;
import org.teavm.jso.dom.html.HTMLCanvasElement;
import org.teavm.jso.dom.html.HTMLDocument;
import org.teavm.jso.*;
import org.teavm.jso.browser.*;
import org.teavm.webgl2.WebGL2RenderingContext;

import static org.teavm.jso.webgl.WebGLRenderingContext.*;

import org.lwjgl.input.Mouse;

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
				ctx.viewport(0, 0, document.getBody().getClientWidth(), document.getBody().getClientHeight());
			}
        	
        });
        CurrentContext.setCurrentContext(ctx);
        Mouse.create();
        requestAnimationFrame(new AnimationFrameCallback() {

			@Override
			public void onAnimationFrame(double timestamp) {
				// TODO Auto-generated method stub
				ctx.clearColor(0, 0, 1, 1);
				ctx.clear(COLOR_BUFFER_BIT);
				
				
				requestAnimationFrame(this);
			}
        	
        });
        document.getBody().appendChild(canvas);
        
        
        
    }
    @JSBody(script = "window.showOpenDirectoryPicker()")
    public native static void showOpenDirectoryPicker();
    
    @JSBody(params = "message",script = "window.alert(message)")
    public native static void alert(String message);
}
