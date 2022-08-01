package org.lwjgl.opengl;

import org.teavm.jso.JSBody;
import org.teavm.jso.browser.Window;
import org.teavm.jso.dom.events.Event;
import org.teavm.jso.dom.events.EventListener;
import org.teavm.jso.dom.events.KeyboardEvent;
import org.teavm.jso.dom.html.HTMLCanvasElement;
import org.teavm.jso.dom.html.HTMLDocument;
import org.teavm.jso.dom.html.HTMLElement;
import org.teavm.webgl2.WebGL2RenderingContext;


/*
	 * Copyright (c) 2002-2008 LWJGL Project
	 * All rights reserved.
	 *
	 * Redistribution and use in source and binary forms, with or without
	 * modification, are permitted provided that the following conditions are
	 * met:
	 *
	 * * Redistributions of source code must retain the above copyright
	 *   notice, this list of conditions and the following disclaimer.
	 *
	 * * Redistributions in binary form must reproduce the above copyright
	 *   notice, this list of conditions and the following disclaimer in the
	 *   documentation and/or other materials provided with the distribution.
	 *
	 * * Neither the name of 'LWJGL' nor the names of
	 *   its contributors may be used to endorse or promote products derived
	 *   from this software without specific prior written permission.
	 *
	 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
	 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
	 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
	 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
	 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
	 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
	 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
	 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
	 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
	 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
	 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
	 */
	

	/**
	 * This is the abstract class for a Display in LWJGL. LWJGL displays have some
	 * peculiar characteristics:
	 *
	 * - the display may be closeable by the user or operating system, and may be minimized
	 * by the user or operating system
	 * - only one display may ever be open at once
	 * - the operating system may or may not be able to do fullscreen or windowed displays.
	 *
	 * @author foo
	 */

	import org.lwjgl.input.Keyboard;
	import org.lwjgl.input.Mouse;
import org.munydev.teavm.lwjgl.CurrentContext;

import java.nio.ByteBuffer;

	public final class Display {
		private static boolean wasResized = false;
		private static final Thread shutdown_hook = new Thread() {
			public void run() {
				reset();
			}
		};
		private static Window jsWin;
		/** The display implementor */
//		private static final DisplayImplementation display_impl;

		/** The initial display mode */
//		private static final DisplayMode initial_mode;

		/** The parent, if any */
//		private static Canvas parent;

		/** The current display mode, if created */
		private static DisplayMode current_mode;

		/** X coordinate of the window */
		private static int x = -1;

		/** Cached window icons, for when Display is recreated */
		private static ByteBuffer[] cached_icons;

		/**
		 * Y coordinate of the window. Y in window coordinates is from the top of the display down,
		 * unlike GL, where it is typically at the bottom of the display.
		 */
		private static int y = -1;

		private static boolean fullscreenReq = false;
		/** the width of the Display window */
		private static int width = 0;

		/** the height of the Display window */
		private static int height = 0;

		/** Title of the window (never null) */
		private static String title = "Game";

		/** Fullscreen */
		private static boolean fullscreen;

		/** Swap interval */
		private static int swap_interval;

		/** The Drawable instance that tracks the current Display context */
//		private static DrawableLWJGL drawable;

		private static boolean window_created;

		private static boolean parent_resized;

		private static boolean window_resized;

		private static boolean window_resizable;

		/** Initial Background Color of Display */
		private static float r, g, b;
		private static boolean closeRequested;
		private static int fkey;
	
//		private static final ComponentListener component_listener = new ComponentAdapter() {
//			public void componentResized(ComponentEvent e) {
//				synchronized ( GlobalLock.lock ) {
//					parent_resized = true;
//				}
//			}
//		};

		

//		/**
//		 * Fetch the Drawable from the Display.
//		 *
//		 * @return the Drawable corresponding to the Display context
//		 */
//		public static Drawable getDrawable() {
//		
//		}

		private static void createDisplayImplementation() {

		}

		/** Only constructed by ourselves */
		private Display() {
		}

		/**
		 * Returns the entire list of possible fullscreen display modes as an array, in no
		 * particular order. Although best attempts to filter out invalid modes are done, any
		 * given mode is not guaranteed to be available nor is it guaranteed to be within the
		 * current monitor specs (this is especially a problem with the frequency parameter).
		 * Furthermore, it is not guaranteed that create() will detect an illegal display mode.
		 * <p/>
		 * The only certain way to check
		 * is to call create() and make sure it works.
		 * Only non-palette-indexed modes are returned (ie. bpp will be 16, 24, or 32).
		 * Only DisplayModes from this call can be used when the Display is in fullscreen
		 * mode.
		 *
		 * @return an array of all display modes the system reckons it can handle.
		 */
		public static DisplayMode[] getAvailableDisplayModes()  {
			return null;
		}

		/**
		 * Return the initial desktop display mode.
		 *
		 * @return The desktop display mode
		 */
		public static DisplayMode getDesktopDisplayMode() {
			return new DisplayMode(640, 480);
		}

		/**
		 * Return the current display mode, as set by setDisplayMode().
		 *
		 * @return The current display mode
		 */
		public static DisplayMode getDisplayMode() {
			return current_mode;
		}

		/**
		 * Set the current display mode. If no OpenGL context has been created, the given mode will apply to
		 * the context when create() is called, and no immediate mode switching will happen. If there is a
		 * context already, it will be resized according to the given mode. If the context is also a
		 * fullscreen context, the mode will also be switched immediately. The native cursor position
		 * is also reset.
		 *
		 * @param mode The new display mode to set
		 *
		 * @ if the display mode could not be set
		 */
		public static void setDisplayMode(DisplayMode mode)  {
			current_mode = mode;
		}

		private static DisplayMode getEffectiveMode() {
			return new DisplayMode(640, 480);
		}

		private static int getWindowX() {
			return jsWin.getScreenX();
		}

		private static int getWindowY() {
			return jsWin.getScreenY();
		}

		/**
		 * Create the native window peer from the given mode and fullscreen flag.
		 * A native context must exist, and it will be attached to the window.
		 */
		private static void createWindow()  {
			
		}

		private static void releaseDrawable() {

		}

		private static void destroyWindow() {

		}

		private static void switchDisplayMode()  {

		}

		/**
		 * Set the display configuration to the specified gamma, brightness and contrast.
		 * The configuration changes will be reset when destroy() is called.
		 *
		 * @param gamma      The gamma value
		 * @param brightness The brightness value between -1.0 and 1.0, inclusive
		 * @param contrast   The contrast, larger than 0.0.
		 */
		public static void setDisplayConfiguration(float gamma, float brightness, float contrast)  {

		}

		/**
		 * An accurate sync method that will attempt to run at a constant frame rate.
		 * It should be called once every frame.
		 *
		 * @param fps - the desired frame rate, in frames per second
		 */
		public static void sync(int fps) {
	
		}

		/** @return the title of the window */
		public static String getTitle() {
			
			return jsWin.getDocument().getTitle();
		}

		/** Return the last parent set with setParent(). */
		public static Object getParent() {
			return CurrentContext.getContext();
		}

		/**
		 * Set the parent of the Display. If parent is null, the Display will appear as a top level window.
		 * If parent is not null, the Display is made a child of the parent. A parent's isDisplayable() must be true when
		 * setParent() is called and remain true until setParent() is called again with
		 * null or a different parent. This generally means that the parent component must remain added to it's parent container.<p>
		 * It is not advisable to call this method from an AWT thread, since the context will be made current on the thread
		 * and it is difficult to predict which AWT thread will process any given AWT event.<p>
		 * While the Display is in fullscreen mode, the current parent will be ignored. Additionally, when a non null parent is specified,
		 * the Dispaly will inherit the size of the parent, disregarding the currently set display mode.<p>
		 */
//		public static void setParent(Canvas parent)  {
//
//		}

		/**
		 * Set the fullscreen mode of the context. If no context has been created through create(),
		 * the mode will apply when create() is called. If fullscreen is true, the context will become
		 * a fullscreen context and the display mode is switched to the mode given by getDisplayMode(). If
		 * fullscreen is false, the context will become a windowed context with the dimensions given in the
		 * mode returned by getDisplayMode(). The native cursor position is also reset.
		 *
		 * @param fullscreen Specify the fullscreen mode of the context.
		 *
		 * @ If fullscreen is true, and the current DisplayMode instance is not
		 *                        from getAvailableDisplayModes() or if the mode switch fails.
		 */
		public static void setFullscreen(boolean fullscreen)  {
			if (fullscreen) {
				fullscreenReq = true;
			}else {
				exitFullscreen(jsWin);
			}
		}
		public static void setFullscreenKey(int key) {
			Display.fkey = key;
		}
		/**
		 * Set the mode of the context. If no context has been created through create(),
		 * the mode will apply when create() is called. If mode.isFullscreenCapable() is true, the context will become
		 * a fullscreen context and the display mode is switched to the mode given by getDisplayMode(). If
		 * mode.isFullscreenCapable() is false, the context will become a windowed context with the dimensions given in the
		 * mode returned by getDisplayMode(). The native cursor position is also reset.
		 *
		 * @param mode The new display mode to set. Must be non-null.
		 *
		 * @ If the mode switch fails.
		 */
		public static void setDisplayModeAndFullscreen(DisplayMode mode)  {

		}

		private static void setDisplayModeAndFullscreenInternal(boolean fullscreen, DisplayMode mode)  {

		}

		/** @return whether the Display is in fullscreen mode */
		public static boolean isFullscreen() {
			return isFullscreen(((WebGL2RenderingContext)CurrentContext.getContext()).getCanvas());
		}

		/**
		 * Set the title of the window. This may be ignored by the underlying OS.
		 *
		 * @param newTitle The new window title
		 */
		public static void setTitle(String newTitle) {
			title = newTitle;
		}

		/** @return true if the user or operating system has asked the window to close */
		public static boolean isCloseRequested() {
			return closeRequested;
		}
		@JSBody(script = "return window.document.visibilityState == \"visible\";")
		public static native boolean nisVisible();
		/** @return true if the window is visible, false if not */
		public static boolean isVisible() {
			return nisVisible();
		}

		/** @return true if window is active, that is, the foreground display of the operating system. */
		public static boolean isActive() {
			return nisVisible();
		}

		/**
		 * Determine if the window's contents have been damaged by external events.
		 * If you are writing a straightforward game rendering loop and simply paint
		 * every frame regardless, you can ignore this flag altogether. If you are
		 * trying to be kind to other processes you can check this flag and only
		 * redraw when it returns true. The flag is cleared when update() or isDirty() is called.
		 *
		 * @return true if the window has been damaged by external changes
		 *         and needs to repaint itself
		 */
		public static boolean isDirty() {
			return false;
		}

		/**
		 * Process operating system events. Call this to update the Display's state and to receive new
		 * input device events. This method is called from update(), so it is not necessary to call
		 * this method if update() is called periodically.
		 */
		public static void processMessages() {
			
		}

		/**
		 * Swap the display buffers. This method is called from update(), and should normally not be called by
		 * the application.
		 *
		 * @throws OpenGLException if an OpenGL error has occured since the last call to glGetError()
		 */
		public static void swapBuffers()  {

		}

		/**
		 * Update the window. If the window is visible clears
		 * the dirty flag and calls swapBuffers() and finally
		 * polls the input devices.
		 */
		public static void update() {
			update(true);
		}

		/**
		 * Update the window. If the window is visible clears
		 * the dirty flag and calls swapBuffers() and finally
		 * polls the input devices if processMessages is true.
		 *
		 * @param processMessages Poll input devices if true
		 */
		public static void update(boolean processMessages) {
			Mouse.poll();
			Keyboard.poll();
			wasResized = false;
			jsWin.getDocument().setTitle(title);
		}

		static void pollDevices() {
			// Poll the input devices while we're here
			
		}

		/**
		 * Release the Display context.
		 *
		 * @ If the context could not be released
		 */
		public static void releaseContext()  {
			
		}

		/** Returns true if the Display's context is current in the current thread. */
		public static boolean isCurrent()  {
			return true;
		}

		/**
		 * Make the Display the current rendering context for GL calls.
		 *
		 * @ If the context could not be made current
		 */
		public static void makeCurrent()  {
			
		}

		private static void removeShutdownHook() {

		}

		private static void registerShutdownHook() {

		}

		/**
		 * Create the OpenGL context. If isFullscreen() is true or if windowed
		 * context are not supported on the platform, the display mode will be switched to the mode returned by
		 * getDisplayMode(), and a fullscreen context will be created. If isFullscreen() is false, a windowed context
		 * will be created with the dimensions given in the mode returned by getDisplayMode(). If a context can't be
		 * created with the given parameters, a LWJGLException will be thrown.
		 * <p/>
		 * <p>The window created will be set up in orthographic 2D projection, with 1:1 pixel ratio with GL coordinates.
		 *
		 * @
		 */
		public static void create() throws Exception {
			create((Object)null);
		}
		
		
		public static void create(Object... unused) throws Exception {
			DisplayMode dm = getDisplayMode();
			if (dm == null) {
				dm = new DisplayMode(800, 600);
				dm.setPopup(true);
			}
			jsWin = Window.current();
			if (dm.isPopup()) {
				jsWin = Window.current().open("", "_blank", "width=" +dm.getWidth()+",height="+dm.getHeight()+",popup,"+"titlebar=no,toolbar=no,status=yes");
				System.out.println("width=" +dm.getWidth()+",height="+dm.getHeight()+",popup,"+"titlebar=no,toolbar=no,status=yes");
				System.out.println(jsWin.getInnerWidth());
				System.out.println(jsWin.getInnerHeight());
			}
			HTMLDocument document = jsWin.getDocument();
			HTMLCanvasElement elem = (HTMLCanvasElement) jsWin.getDocument().createElement("canvas");
			document.getBody().getStyle().setProperty("margin", "0");
	        document.getBody().getStyle().setProperty("padding", "0");
	        
	        elem.setWidth(jsWin.getInnerWidth());
	        elem.setHeight(jsWin.getInnerHeight());
	        WebGL2RenderingContext ctx = (WebGL2RenderingContext) elem.getContext("webgl2");
	        document.getBody().getStyle().setProperty("overflow", "hidden");
	        document.setTitle(title);
	        jsWin.addEventListener("beforeunload", new EventListener<Event>() {

				@Override
				public void handleEvent(Event evt) {
					// TODO Auto-generated method stub
					closeRequested = true;
				}
	        	
	        });
	        jsWin.addEventListener("keydown", new EventListener<KeyboardEvent>() {

				@Override
				public void handleEvent(KeyboardEvent evt) {
					// TODO Auto-generated method stub
//					if (evt.getKey() == "Escape") return;
					if (fullscreenReq && Keyboard.map(fkey).contains(evt.getCode())) {
					requestFullscreen(elem);
					}
//					fullscreenReq = false;
					evt.preventDefault();
					evt.stopPropagation();
				}
	        	
	        });
	        Window.current().addEventListener("beforeunload", new EventListener<Event>() {

				@Override
				public void handleEvent(Event evt) {
					// TODO Auto-generated method stub
					closeRequested = true;
					jsWin.close();
				}
	        	
	        });
	        CurrentContext.setCurrentContext((WebGL2RenderingContext) elem.getContext("webgl2"));
	        jsWin.addEventListener("resize", new EventListener<Event>() {

				@Override
				public void handleEvent(Event evt) {
					// TODO Auto-generated method stub
					elem.setWidth(jsWin.getInnerWidth());
					elem.setHeight(jsWin.getInnerHeight());
					
					((WebGL2RenderingContext) elem.getContext("webgl2")).viewport(0, 0, jsWin.getInnerWidth(), jsWin.getInnerHeight());
					wasResized = true;
					evt.preventDefault();
					evt.stopPropagation();
				}
	        	
	        });

	        CurrentContext.setCurrentContext(ctx);
	        Keyboard.create();
	        Mouse.create();
	        
	        document.getBody().appendChild(ctx.getCanvas());
	        
	        
		}
		public static Window getWindow() {
			return jsWin;
		}
		
		
		@JSBody(script = "elem.requestFullscreen()", params = {"elem"} )
		private static native void requestFullscreen(HTMLElement elem);
		
		@JSBody(script = "window.document.exitFullscreen()", params= {"window"})
		private static native void exitFullscreen(Window w);
		
		@JSBody(script = "return window.document.fullscreenElement == elem;", params = {"elem"} )
		private static native boolean isFullscreen(HTMLElement elem);
		
		/**
		 * Create the OpenGL context with the given minimum parameters. If isFullscreen() is true or if windowed
		 * context are not supported on the platform, the display mode will be switched to the mode returned by
		 * getDisplayMode(), and a fullscreen context will be created. If isFullscreen() is false, a windowed context
		 * will be created with the dimensions given in the mode returned by getDisplayMode(). If a context can't be
		 * created with the given parameters, a LWJGLException will be thrown.
		 * <p/>
		 * <p>The window created will be set up in orthographic 2D projection, with 1:1 pixel ratio with GL coordinates.
		 *
		 * @param pixel_format Describes the minimum specifications the context must fulfill.
		 *
		 * @
		 */
//		public static void create(PixelFormat pixel_format)  {
//	
//		}

//		/**
//		 * Create the OpenGL context with the given minimum parameters. If isFullscreen() is true or if windowed
//		 * context are not supported on the platform, the display mode will be switched to the mode returned by
//		 * getDisplayMode(), and a fullscreen context will be created. If isFullscreen() is false, a windowed context
//		 * will be created with the dimensions given in the mode returned by getDisplayMode(). If a context can't be
//		 * created with the given parameters, a LWJGLException will be thrown.
//		 * <p/>
//		 * <p>The window created will be set up in orthographic 2D projection, with 1:1 pixel ratio with GL coordinates.
//		 *
//		 * @param pixel_format    Describes the minimum specifications the context must fulfill.
//		 * @param shared_drawable The Drawable to share context with. (optional, may be null)
//		 *
//		 * @
//		 */
//		public static void create(PixelFormat pixel_format, Drawable shared_drawable)  {
//
//		}
//
//		/**
//		 * Create the OpenGL context with the given minimum parameters. If isFullscreen() is true or if windowed
//		 * context are not supported on the platform, the display mode will be switched to the mode returned by
//		 * getDisplayMode(), and a fullscreen context will be created. If isFullscreen() is false, a windowed context
//		 * will be created with the dimensions given in the mode returned by getDisplayMode(). If a context can't be
//		 * created with the given parameters, a LWJGLException will be thrown.
//		 * <p/>
//		 * <p>The window created will be set up in orthographic 2D projection, with 1:1 pixel ratio with GL coordinates.
//		 *
//		 * @param pixel_format Describes the minimum specifications the context must fulfill.
//		 * @param attribs      The ContextAttribs to use when creating the context. (optional, may be null)
//		 *
//		 * @
//		 */
//		public static void create(PixelFormat pixel_format, ContextAttribs attribs)  {
//
//		}
//
//		/**
//		 * Create the OpenGL context with the given minimum parameters. If isFullscreen() is true or if windowed
//		 * context are not supported on the platform, the display mode will be switched to the mode returned by
//		 * getDisplayMode(), and a fullscreen context will be created. If isFullscreen() is false, a windowed context
//		 * will be created with the dimensions given in the mode returned by getDisplayMode(). If a context can't be
//		 * created with the given parameters, a LWJGLException will be thrown.
//		 * <p/>
//		 * <p>The window created will be set up in orthographic 2D projection, with 1:1 pixel ratio with GL coordinates.
//		 *
//		 * @param pixel_format    Describes the minimum specifications the context must fulfill.
//		 * @param shared_drawable The Drawable to share context with. (optional, may be null)
//		 * @param attribs         The ContextAttribs to use when creating the context. (optional, may be null)
//		 *
//		 * @
//		 */
//		public static void create(PixelFormat pixel_format, Drawable shared_drawable, ContextAttribs attribs)  {
//
//		}
//
//		/**
//		 * Create the OpenGL ES context with the given minimum parameters. If isFullscreen() is true or if windowed
//		 * context are not supported on the platform, the display mode will be switched to the mode returned by
//		 * getDisplayMode(), and a fullscreen context will be created. If isFullscreen() is false, a windowed context
//		 * will be created with the dimensions given in the mode returned by getDisplayMode(). If a context can't be
//		 * created with the given parameters, a LWJGLException will be thrown.
//		 * <p/>
//		 * <p>The window created will be set up in orthographic 2D projection, with 1:1 pixel ratio with GL coordinates.
//		 *
//		 * @param pixel_format Describes the minimum specifications the context must fulfill. Must be an instance of org.lwjgl.opengles.PixelFormat.
//		 *
//		 * @
//		 */
//
//		public static void create(PixelFormatLWJGL pixel_format)  {
//
//		}
//
//		/**
//		 * Create the OpenGL ES context with the given minimum parameters. If isFullscreen() is true or if windowed
//		 * context are not supported on the platform, the display mode will be switched to the mode returned by
//		 * getDisplayMode(), and a fullscreen context will be created. If isFullscreen() is false, a windowed context
//		 * will be created with the dimensions given in the mode returned by getDisplayMode(). If a context can't be
//		 * created with the given parameters, a LWJGLException will be thrown.
//		 * <p/>
//		 * <p>The window created will be set up in orthographic 2D projection, with 1:1 pixel ratio with GL coordinates.
//		 *
//		 * @param pixel_format    Describes the minimum specifications the context must fulfill. Must be an instance of org.lwjgl.opengles.PixelFormat.
//		 * @param shared_drawable The Drawable to share context with. (optional, may be null)
//		 *
//		 * @
//		 */
//		public static void create(PixelFormatLWJGL pixel_format, Drawable shared_drawable)  {
//
//		}
//
//		/**
//		 * Create the OpenGL ES context with the given minimum parameters. If isFullscreen() is true or if windowed
//		 * context are not supported on the platform, the display mode will be switched to the mode returned by
//		 * getDisplayMode(), and a fullscreen context will be created. If isFullscreen() is false, a windowed context
//		 * will be created with the dimensions given in the mode returned by getDisplayMode(). If a context can't be
//		 * created with the given parameters, a LWJGLException will be thrown.
//		 * <p/>
//		 * <p>The window created will be set up in orthographic 2D projection, with 1:1 pixel ratio with GL coordinates.
//		 *
//		 * @param pixel_format Describes the minimum specifications the context must fulfill. Must be an instance of org.lwjgl.opengles.PixelFormat.
//		 * @param attribs      The ContextAttribs to use when creating the context. (optional, may be null)
//		 *
//		 * @
//		 */
//		public static void create(PixelFormatLWJGL pixel_format, org.lwjgl.opengles.ContextAttribs attribs)  {
//			
//		}
//
//		/**
//		 * Create the OpenGL ES context with the given minimum parameters. If isFullscreen() is true or if windowed
//		 * context are not supported on the platform, the display mode will be switched to the mode returned by
//		 * getDisplayMode(), and a fullscreen context will be created. If isFullscreen() is false, a windowed context
//		 * will be created with the dimensions given in the mode returned by getDisplayMode(). If a context can't be
//		 * created with the given parameters, a LWJGLException will be thrown.
//		 * <p/>
//		 * <p>The window created will be set up in orthographic 2D projection, with 1:1 pixel ratio with GL coordinates.
//		 *
//		 * @param pixel_format    Describes the minimum specifications the context must fulfill. Must be an instance of org.lwjgl.opengles.PixelFormat.
//		 * @param shared_drawable The Drawable to share context with. (optional, may be null)
//		 * @param attribs         The ContextAttribs to use when creating the context. (optional, may be null)
//		 *
//		 * @
//		 */
//		public static void create(PixelFormatLWJGL pixel_format, Drawable shared_drawable, org.lwjgl.opengles.ContextAttribs attribs)  {
//			
//		}

		/**
		 * Set the initial color of the Display. This method is called before the Display is created and will set the
		 * background color to the one specified in this method.
		 *
		 * @param red   - color value between 0 - 1
		 * @param green - color value between 0 - 1
		 * @param blue  - color value between 0 - 1
		 */
		public static void setInitialBackground(float red, float green, float blue) {
			
		}

		private static void makeCurrentAndSetSwapInterval()  {
			
		}

		private static void initContext() {
			
		}

		static void getImplementation() {
			
		}

		/** Gets a boolean property as a privileged action. */
		static boolean getPrivilegedBoolean(final String property_name) {
			return false;
		}
		
		/** Gets a string property as a privileged action. */
		static String getPrivilegedString(final String property_name) {
			return "";
		}

		private static void initControls() {

		}

		/**
		 * Destroy the Display. After this call, there will be no current GL rendering context,
		 * regardless of whether the Display was the current rendering context.
		 */
		public static void destroy() {
			jsWin.close();
			Window.current().close();
			
		}

		/*
		 * Reset display mode if fullscreen. This method is also called from the shutdown hook added
		 * in the static constructor
		 */

		private static void reset() {

		}

		/** @return true if the window's native peer has been created */
		public static boolean isCreated() {
			return jsWin != null;
		}

		/**
		 * Set the buffer swap interval. This call is a best-attempt at changing
		 * the monitor swap interval, which is the minimum periodicity of color buffer swaps,
		 * measured in video frame periods, and is not guaranteed to be successful.
		 * <p/>
		 * A video frame period is the time required to display a full frame of video data.
		 *
		 * @param value The swap interval in frames, 0 to disable
		 */
		public static void setSwapInterval(int value) {
			
		}

		/**
		 * Enable or disable vertical monitor synchronization. This call is a best-attempt at changing
		 * the vertical refresh synchronization of the monitor, and is not guaranteed to be successful.
		 *
		 * @param sync true to synchronize; false to ignore synchronization
		 */
		public static void setVSyncEnabled(boolean sync) {
			
		}

		/**
		 * Set the window's location. This is a no-op on fullscreen windows or when getParent() != null.
		 * The window is clamped to remain entirely on the screen. If you attempt
		 * to position the window such that it would extend off the screen, the window
		 * is simply placed as close to the edge as possible.
		 * <br><b>note</b>If no location has been specified (or x == y == -1) the window will be centered
		 *
		 * @param new_x The new window location on the x axis
		 * @param new_y The new window location on the y axis
		 */
		public static void setLocation(int new_x, int new_y) {
			jsWin.moveTo(new_x, new_y);
		}

		private static void reshape() {
			
		}

		/**
		 * Get the driver adapter string. This is a unique string describing the actual card's hardware, eg. "Geforce2", "PS2",
		 * "Radeon9700". If the adapter cannot be determined, this function returns null.
		 *
		 * @return a String
		 */
		public static String getAdapter() {
			return "Web";
		}

		/**
		 * Get the driver version. This is a vendor/adapter specific version string. If the version cannot be determined,
		 * this function returns null.
		 *
		 * @return a String
		 */
		public static String getVersion() {
			return "";
		}

		/**
		 * Sets one or more icons for the Display.
		 * <ul>
		 * <li>On Windows you should supply at least one 16x16 icon and one 32x32.</li>
		 * <li>Linux (and similar platforms) expect one 32x32 icon.</li>
		 * <li>Mac OS X should be supplied one 128x128 icon</li>
		 * </ul>
		 * The implementation will use the supplied ByteBuffers with image data in RGBA (size must be a power of two) and perform any conversions nescesarry for the specific platform.
		 * <p/>
		 * <b>NOTE:</b> The display will make a deep copy of the supplied byte buffer array, for the purpose
		 * of recreating the icons when you go back and forth fullscreen mode. You therefore only need to
		 * set the icon once per instance.
		 *
		 * @param icons Array of icons in RGBA mode. Pass the icons in order of preference.
		 *
		 * @return number of icons used, or 0 if display hasn't been created
		 */
		public static int setIcon(ByteBuffer[] icons) {
			
			return 1;
		}

		/**
		 * Enable or disable the Display window to be resized.
		 *
		 * @param resizable set to true to make the Display window resizable;
		 * false to disable resizing on the Display window.
		 */
		public static void setResizable(boolean resizable) {
			
		}

		/**
		 * @return true if the Display window is resizable.
		 */
		public static boolean isResizable() {
			return true;
		}

		/**
		 * @return true if the Display window has been resized.
		 * This value will be updated after a call to Display.update().
		 *
		 * This will return false if running in fullscreen or with Display.setParent(Canvas parent)
		 */
		public static boolean wasResized() {
			return wasResized;
		}

		/**
		 * @return this method will return the x position (top-left) of the Display window.
		 *
		 * If running in fullscreen mode it will return 0.
		 * If Display.setParent(Canvas parent) is being used, the x position of
		 * the parent will be returned.
		 */
		public static int getX() {
			return jsWin.getScreenX();
		}

		/**
		 * @return this method will return the y position (top-left) of the Display window.
		 *
		 * If running in fullscreen mode it will return 0.
		 * If Display.setParent(Canvas parent) is being used, the y position of
		 * the parent will be returned.
		 */
		public static int getY() {
			return jsWin.getScreenY();
		}

		/**
		 * @return this method will return the width of the Display window.
		 *
		 * If running in fullscreen mode it will return the width of the current set DisplayMode.
		 * If Display.setParent(Canvas parent) is being used, the width of the parent
		 * will be returned.
		 *
		 * This value will be updated after a call to Display.update().
		 */
		public static int getWidth() {
			return jsWin.getInnerWidth();
		}

		/**
		 * @return this method will return the height of the Display window.
		 *
		 * If running in fullscreen mode it will return the height of the current set DisplayMode.
		 * If Display.setParent(Canvas parent) is being used, the height of the parent
		 * will be returned.
		 *
		 * This value will be updated after a call to Display.update().
		 */
		public static int getHeight() {
			return jsWin.getInnerHeight();
		}
		
		/**
		 * @return this method will return the pixel scale factor of the Display window.
		 *
		 * This method should be used when running in high DPI mode. In such modes Operating
		 * Systems will scale the Display window to avoid the window shrinking due to high
		 * resolutions. The OpenGL frame buffer will however use the higher resolution and
		 * not be scaled to match the Display window size.
		 * 
		 * OpenGL methods that require pixel dependent values e.g. glViewport, glTexImage2D,
		 * glReadPixels, glScissor, glLineWidth, glRenderbufferStorage, etc can convert the 
		 * scaled Display and Mouse coordinates to the correct high resolution value by 
		 * multiplying them by the pixel scale factor.
		 * 
		 * e.g. Display.getWidth() * Display.getPixelScaleFactor() will return the high DPI
		 * width of the OpenGL frame buffer. Whereas Display.getWidth() will be the same as
		 * the OpenGL frame buffer in non high DPI mode.
		 * 
		 * Where high DPI mode is not available this method will just return 1.0f therefore
		 * not have any effect on values that are multiplied by it.
		 */
		public static float getPixelScaleFactor() {
			return 1;
		}
	}
