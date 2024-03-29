package org.munydev.teavm.lwjgl;

import org.teavm.jso.*;
import org.teavm.jso.browser.*;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import static org.teavm.jso.browser.Window.*;
public class Client {
	private static float deltaTime = 0;
	private static float lastTime = 0;
    public static void main(String[] args) {
        System.setProperty("joml.nounsafe", "true");
    	DisplayMode dm = new DisplayMode(640, 480, true);
//        document.getBody().appendChild(canvas);
        Display.setDisplayMode(dm);
        try {
        	Display.setTitle("woah");
			Display.create();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
//        CurrentContext.setCurrentContext(Di);
        Display.setFullscreen(true);
        Display.setFullscreenKey(Keyboard.KEY_F11);
        requestAnimationFrame(new AnimationFrameCallback() {

			@Override
			public void onAnimationFrame(double timestamp) {
				// TODO Auto-generated method stub
						deltaTime = (float) (timestamp - lastTime) * 100;
						lastTime = (float) timestamp;
				 		GL11.glClearColor(0, 0, 0, 1);
			        	GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			        	GL11.glBegin(GL11.GL_TRIANGLES);
			        	GL11.glColor4f(0, 0, 1, 1);
			        	GL11.glVertex3f(-0.5f, 0.5f, 0);
			        	GL11.glVertex3f(0.5f, 0.5f, 0);
			        	GL11.glVertex3f(0.5f, -0.5f, 0);
			        	GL11.glVertex3f(-0.5f, 0.5f, 0);
			        	GL11.glVertex3f(0.5f, -0.5f, 0);
			        	GL11.glVertex3f(-0.5f, -0.5f, 0);
			        
			        	GL11.glEnd();
			        	Display.setTitle(String.valueOf(deltaTime));
			        	Display.update();
						Mouse.poll();
//						log("hello", Display.getWindow());
//						log(String.valueOf(Keyboard.isKeyDown(Keyboard.KEY_F11)), Display.getWindow());
						requestAnimationFrame(this);
			        
			}
        	
        });
    }
    
    @JSBody(script = "window.console.log(param);", params = {"param", "window"})
    public native static void log(String param, Window w);
    @JSBody(script = "window.showOpenDirectoryPicker()")
    public native static void showOpenDirectoryPicker();
    
    @JSBody(params = "message",script = "window.alert(message)")
    public native static void alert(String message);
}
