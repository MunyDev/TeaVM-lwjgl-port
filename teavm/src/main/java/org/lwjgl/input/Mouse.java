package org.lwjgl.input;

import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.PrivilegedAction;

import java.util.HashMap;
import java.util.Map;

import org.teavm.jso.dom.html.HTMLCanvasElement;
import org.teavm.jso.dom.html.HTMLDocument;
import org.teavm.jso.webgl.WebGLRenderingContext;
import org.munydev.teavm.lwjgl.CurrentContext;
import org.teavm.jso.dom.events.*;


/**
 * <br>
 * A raw Mouse interface. This can be used to poll the current state of the
 * mouse buttons, and determine the mouse movement delta since the last poll.
 *
 * n buttons supported, n being a native limit. A scrolly wheel is also
 * supported, if one such is available. Movement is reported as delta from
 * last position or as an absolute position. If the window has been created
 * the absolute position will be clamped to 0 - width | height.
 *
 * @author cix_foo <cix_foo@users.sourceforge.net>
 * @author elias_naur <elias_naur@users.sourceforge.net>
 * @author Brian Matzon <brian@matzon.dk>
 * @version $Revision$
 * $Id$
 */
@SuppressWarnings("unused")
public class Mouse {
	/** Internal use - event size in bytes */
	public static final int	EVENT_SIZE									= 1 + 1 + 4 + 4 + 4 + 8;

	/** Has the mouse been created? */
	private static boolean		created;

	/** Mouse absolute X position in pixels */
	private static int				x;

	/** Mouse absolute Y position in pixels */
	private static int				y;
	
	/** Delta X */
	private static int				dx;

	/** Delta Y */
	private static int				dy;

	/** Delta Z */
	private static int				dwheel;

	

	/** The current native cursor, if any */
//	private static Cursor		currentCursor;

	/** Button names. These are set upon create(), to names like BUTTON0, BUTTON1, etc. */
	private static String[]		buttonName;

	/** hashmap of button names, for fast lookup */
	private static final Map<String, Integer>	buttonMap									= new HashMap<String, Integer>(16);

	/** The mouse button events from the last read */
	private static ByteBuffer	readBuffer;

	/** The current mouse event button being examined */
	private static int				eventButton;

	/** The current state of the button being examined in the event queue */
	private static boolean		eventState;

	/** The current delta of the mouse in the event queue */
	private static int			event_dx;
	private static int			event_dy;
	private static int			event_dwheel;
	/** The current absolute position of the mouse in the event queue */
	private static int			event_x;
	private static int			event_y;
	private static boolean		isGrabbed;
	public static boolean isSupposedToBeGrabbed = true;

//	private static InputImplementation implementation;

	private static  boolean clipMouseCoordinatesToWindow = true;

	private static boolean[] buttonArray = new boolean[5];

	protected static boolean isInsideWindow = true;
	/**
	 * Mouse cannot be constructed.
	 */
	private Mouse() {
	}

	/**
	 * Gets the currently bound native cursor, if any.
	 *
	 * @return the currently bound native cursor, if any.
	 */
	

	/**
	 * Binds a native cursor. If the cursor argument is null, any
	 * currently bound native cursor is disabled, and the cursor reverts
	 * to the default operating system supplied cursor.
	 *
	 * NOTE: The native cursor is not constrained to the window, but
	 * relative events will not be generated if the cursor is outside.
	 *
	 * @param cursor the native cursor object to bind. May be null.
	 * @return The previous Cursor object set, or null.
	 * @throws LWJGLException if the cursor could not be set for any reason
	 */
	

	public static boolean isClipMouseCoordinatesToWindow() {
		return clipMouseCoordinatesToWindow;
	}

	public static void setClipMouseCoordinatesToWindow(boolean clip) {
		clipMouseCoordinatesToWindow = clip;
	}

	/**
	 * Set the position of the cursor. If the cursor is not grabbed,
	 * the native cursor is moved to the new position.
	 *
	 * @param new_x The x coordinate of the new cursor position in OpenGL coordinates relative
	 *			to the window origin.
	 * @param new_y The y coordinate of the new cursor position in OpenGL coordinates relative
	 *			to the window origin.
	 */
	public static void setCursorPosition(int new_x, int new_y) {
		System.err.println("You cannot set the cursor position in this context");
	}

	/**
	 * Static initialization
	 */
	private static void initialize() {
		
		// Assign names to all the buttons
		buttonName = new String[16];
		for (int i = 0; i < 16; i++) {
			buttonName[i] = "BUTTON" + i;
			buttonMap.put(buttonName[i], i);
		}
	}

	
	private static void resetMouse() {
		dx = dy = dwheel = 0;
		readBuffer.position(readBuffer.limit());
	}

	

	/**
	 * "Create" the mouse with the given custom implementation.	This is used
	 * reflectively by AWTInputAdapter.
	 *
	 * @throws LWJGLException if the mouse could not be created for any reason
	 */
	

	/**
	 * "Create" the mouse. The display must first have been created.
	 * Initially, the mouse is not grabbed and the delta values are reported
	 * with respect to the center of the display.
	 *
	 * @throws LWJGLException if the mouse could not be created for any reason
	 */
	public static void create() {
		if (created) return;
		WebGLRenderingContext wglr = (WebGLRenderingContext)CurrentContext.getContext();
		HTMLCanvasElement hce = wglr.getCanvas();
		created = true;
		hce.addEventListener("mousemove", new EventListener<MouseEvent>() {

			@Override
			public void handleEvent(MouseEvent evt) {
				// TODO Auto-generated method stub
				if (isSupposedToBeGrabbed) {
//					((WebGLRenderingContext)CurrentContext.getContext()).getCanvas().requestPointerLock()?;
				}
				dx = (int) evt.getMovementX();
				dy = (int) evt.getMovementY();
				x = (int) evt.getClientX();
				y = (int) evt.getClientY();
				event_dx = dx;
				event_dy = dy;
				event_x = x;
				event_y = y;
				evt.preventDefault();
				evt.stopPropagation();
			}
			
		});
		hce.addEventListener("pointerlockchange", new EventListener<Event>() {

			@Override
			public void handleEvent(Event evt) {
				// TODO Auto-generated method stub
				if (HTMLDocument.current().getPointerLockElement() != ((WebGLRenderingContext)CurrentContext.getContext()).getCanvas()) {
					isGrabbed = false;
				}else {
					isGrabbed = true;
				}
				
				evt.preventDefault();
				evt.stopPropagation();
			}
			
			
		});
		hce.addEventListener("mousedown", new EventListener<MouseEvent>() {

			@Override
			public void handleEvent(MouseEvent evt) {
				// TODO Auto-generated method stub
				
				buttonArray[evt.getButton()] = true;
				eventButton = evt.getButton();
				eventState = true;
				if (isSupposedToBeGrabbed) {
					((WebGLRenderingContext)CurrentContext.getContext()).getCanvas().requestPointerLock();
				}
				evt.preventDefault();
				evt.stopPropagation();
				
			}
			
		});
		hce.addEventListener("mouseup", new EventListener<MouseEvent>() {

			@Override
			public void handleEvent(MouseEvent evt) {
				// TODO Auto-generated method stub
				buttonArray[evt.getButton()] = false;
				eventButton = evt.getButton();
				eventState = false;
				evt.preventDefault();
				evt.stopPropagation();
				
			}
			
		});
		
		hce.addEventListener("mousewheel", new EventListener<WheelEvent>() {

			@Override
			public void handleEvent(WheelEvent evt) {
				// TODO Auto-generated method stub
				if (evt.getDeltaMode() == WheelEvent.DOM_DELTA_PIXEL) {
					dwheel = (int) evt.getDeltaY();
					event_dwheel = dwheel;
				}
				evt.preventDefault();
				evt.stopPropagation();
			}
			
		});
		hce.addEventListener("mouseleave", new EventListener<WheelEvent>() {

			@Override
			public void handleEvent(WheelEvent evt) {
				// TODO Auto-generated method stub
				isInsideWindow = false;
				dx = 0;
				dy = 0;
				x = 0;
				y = 0;
				evt.preventDefault();
				evt.stopPropagation();
			}
			
		});
		hce.addEventListener("contextmenu", new EventListener<MouseEvent>() {

			@Override
			public void handleEvent(MouseEvent evt) {
				// TODO Auto-generated method stub
				if (isSupposedToBeGrabbed) {
					((WebGLRenderingContext)CurrentContext.getContext()).getCanvas().requestPointerLock();
				}
				evt.preventDefault();
				evt.stopPropagation();
			}
			
		});
		hce.addEventListener("mouseenter", new EventListener<MouseEvent>() {

			@Override
			public void handleEvent(MouseEvent evt) {
				// TODO Auto-generated method stub
				isInsideWindow = true;
				dx = 0;
				dy = 0;
				x = evt.getClientX();
				y = evt.getClientY();
				evt.preventDefault();
				evt.stopPropagation();
			}
			
		});
	}

	/**
	 * @return true if the mouse has been created
	 */
	public static boolean isCreated() {
		return created;
	}

	/**
	 * "Destroy" the mouse.
	 */
	public static void destroy() {
		
	}

	/**
	 * Polls the mouse for its current state. Access the polled values using the
	 * get<value> methods.
	 * By using this method, it is possible to "miss" mouse click events if you don't
	 * poll fast enough.
	 *
	 * To use buffered values, you have to call <code>next</code> for each event you
	 * want to read. You can query which button caused the event by using
	 * <code>getEventButton</code>. To get the state of that button, for that event, use
	 * <code>getEventButtonState</code>.
	 *
	 * NOTE: This method does not query the operating system for new events. To do that,
	 * Display.processMessages() (or Display.update()) must be called first.
	 *
	 * @see org.lwjgl.input.Mouse#next()
	 * @see org.lwjgl.input.Mouse#getEventButton()
	 * @see org.lwjgl.input.Mouse#getEventButtonState()
	 * @see org.lwjgl.input.Mouse#isButtonDown(int button)
	 * @see org.lwjgl.input.Mouse#getX()
	 * @see org.lwjgl.input.Mouse#getY()
	 * @see org.lwjgl.input.Mouse#getDX()
	 * @see org.lwjgl.input.Mouse#getDY()
	 * @see org.lwjgl.input.Mouse#getDWheel()
	 */
	public static void poll() {
		Mouse.dx += Mouse.dx * -0.5f;
		Mouse.dy += Mouse.dy * -0.5f;
	}

//	private static void read() {
//		
//	}

	/**
	 * See if a particular mouse button is down.
	 *
	 * @param button The index of the button you wish to test (0..getButtonCount-1)
	 * @return true if the specified button is down
	 */
	public static boolean isButtonDown(int button) {
		return buttonArray[button];
	}

	/**
	 * Gets a button's name
	 * @param button The button
	 * @return a String with the button's human readable name in it or null if the button is unnamed
	 */
	public static String getButtonName(int button) {
		return "";
	}

	/**
	 * Get's a button's index. If the button is unrecognised then -1 is returned.
	 * @param buttonName The button name
	 */
	public static int getButtonIndex(String buttonName) {
		return 0;
	}

	/**
	 * Gets the next mouse event. You can query which button caused the event by using
	 * <code>getEventButton()</code> (if any). To get the state of that key, for that event, use
	 * <code>getEventButtonState</code>. To get the current mouse delta values use <code>getEventDX()</code>
	 * and <code>getEventDY()</code>.
	 * @see org.lwjgl.input.Mouse#getEventButton()
	 * @see org.lwjgl.input.Mouse#getEventButtonState()
	 * @return true if a mouse event was read, false otherwise
	 */
	public static boolean next() {
		return true;
	}

	/**
	 * @return Current events button. Returns -1 if no button state was changed
	 */
	public static int getEventButton() {
		return eventButton;
	}

	/**
	 * Get the current events button state.
	 * @return Current events button state.
	 */
	public static boolean getEventButtonState() {
		return eventState;
	}

	/**
	 * @return Current events delta x.
	 */
	public static int getEventDX() {
		return event_dx;
	}

	/**
	 * @return Current events delta y.
	 */
	public static int getEventDY() {
		return event_dy;
	}

	/**
	 * @return Current events absolute x.
	 */
	public static int getEventX() {
		return event_x;
	}

	/**
	 * @return Current events absolute y.
	 */
	public static int getEventY() {
		return event_y;
	}

	/**
	 * @return Current events delta z
	 */
	public static int getEventDWheel() {
		return event_dwheel;
	}

	/**
	 * Gets the time in nanoseconds of the current event.
	 * Only useful for relative comparisons with other
	 * Mouse events, as the absolute time has no defined
	 * origin.
	 *
	 * @return The time in nanoseconds of the current event
	 */
	public static long getEventNanoseconds() {
		return 0;
	}

	/**
	 * Retrieves the absolute position. It will be clamped to
	 * 0...width-1.
	 *
	 * @return Absolute x axis position of mouse
	 */
	public static int getX() {
		return x;
	}

	/**
	 * Retrieves the absolute position. It will be clamped to
	 * 0...height-1.
	 *
	 * @return Absolute y axis position of mouse
	 */
	public static int getY() {
		return y;
	}

	/**
	 * @return Movement on the x axis since last time getDX() was called.
	 */
	public static int getDX() {
		return dx;
	}

	/**
	 * @return Movement on the y axis since last time getDY() was called.
	 */
	public static int getDY() {
		return dy;
	}

	/**
	 * @return Movement of the wheel since last time getDWheel() was called
	 */
	public static int getDWheel() {
		return dwheel;
	}

	/**
	 * @return Number of buttons on this mouse
	 */
	public static int getButtonCount() {
		return 5;
	}

	/**
	 * @return Whether or not this mouse has wheel support
	 */
	public static boolean hasWheel() {
		return true;
	}

	/**
	 * @return whether or not the mouse has grabbed the cursor
	 */
	public static boolean isGrabbed() {
		return isGrabbed;
	}

	/**
	 * Sets whether or not the mouse has grabbed the cursor
	 * (and thus hidden). If grab is false, the getX() and getY()
	 * will return delta movement in pixels clamped to the display
	 * dimensions, from the center of the display.
	 * You may only use setGrabbed during an event due to the browser's limitations
	 * @param grab whether the mouse should be grabbed
	 */
	public static void setGrabbed(boolean grab) {
		
		if (grab) {
//			((WebGLRenderingContext)CurrentContext.getContext()).getCanvas().requestPointerLock();
			isGrabbed = true;
			isSupposedToBeGrabbed = true;
		}else {
			HTMLDocument.current().exitPointerLock();
			isGrabbed = false;
			isSupposedToBeGrabbed = false;
		}
	}

	/**
	 * Updates the cursor, so that animation can be changed if needed.
	 * This method is called automatically by the window on its update, and
	 * shouldn't be called otherwise
	 */
	public static void updateCursor() {
		return;
	}
	
        /** Gets a boolean property as a privileged action. */
	static boolean getPrivilegedBoolean(final String property_name) {
		Boolean value = AccessController.doPrivileged(new PrivilegedAction<Boolean>() {
			public Boolean run() {
				return Boolean.getBoolean(property_name);
			}
		});
		return value;
	}

        /**
         * Retrieves whether or not the mouse cursor is within the bounds of the window.
         * If the mouse cursor was moved outside the display during a drag, then the result of calling
         * this method will be true until the button is released.
         * @return true if mouse is inside display, false otherwise.
         */
    public static boolean isInsideWindow() {
    	
    	
    	return isInsideWindow;
    }
}