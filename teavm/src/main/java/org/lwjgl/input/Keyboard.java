package org.lwjgl.input;


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


	import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.function.BiConsumer;

import org.lwjgl.opengl.Display;
import org.munydev.teavm.lwjgl.CurrentContext;
import org.teavm.jso.dom.events.EventListener;
import org.teavm.jso.dom.events.KeyboardEvent;
import org.teavm.webgl2.WebGL2RenderingContext;

	/**
	 * <br>
	 * A raw Keyboard interface. This can be used to poll the current state of the
	 * keys, or read all the keyboard presses / releases since the last read.
	 *
	 * @author cix_foo <cix_foo@users.sourceforge.net>
	 * @author elias_naur <elias_naur@users.sourceforge.net>
	 * @author Brian Matzon <brian@matzon.dk>
	 * @version $Revision$
	 * $Id$
	 */
	public class Keyboard {
		/** Internal use - event size in bytes */
		public static final int EVENT_SIZE = 4 + 1 + 4 + 8 + 1;

		/**
		 * The special character meaning that no
		 * character was translated for the event.
		 */
		public static final int CHAR_NONE          = '\0';

		/**
		 * The special keycode meaning that only the
		 * translated character is valid.
		 */
		public static final int KEY_NONE            = 0x00;

		public static final int KEY_ESCAPE          = 0x01;
		public static final int KEY_1               = 0x02;
		public static final int KEY_2               = 0x03;
		public static final int KEY_3               = 0x04;
		public static final int KEY_4               = 0x05;
		public static final int KEY_5               = 0x06;
		public static final int KEY_6               = 0x07;
		public static final int KEY_7               = 0x08;
		public static final int KEY_8               = 0x09;
		public static final int KEY_9               = 0x0A;
		public static final int KEY_0               = 0x0B;
		public static final int KEY_MINUS           = 0x0C; /* - on main keyboard */
		public static final int KEY_EQUALS          = 0x0D;
		public static final int KEY_BACK            = 0x0E; /* backspace */
		public static final int KEY_TAB             = 0x0F;
		public static final int KEY_Q               = 0x10;
		public static final int KEY_W               = 0x11;
		public static final int KEY_E               = 0x12;
		public static final int KEY_R               = 0x13;
		public static final int KEY_T               = 0x14;
		public static final int KEY_Y               = 0x15;
		public static final int KEY_U               = 0x16;
		public static final int KEY_I               = 0x17;
		public static final int KEY_O               = 0x18;
		public static final int KEY_P               = 0x19;
		public static final int KEY_LBRACKET        = 0x1A;
		public static final int KEY_RBRACKET        = 0x1B;
		public static final int KEY_RETURN          = 0x1C; /* Enter on main keyboard */
		public static final int KEY_LCONTROL        = 0x1D;
		public static final int KEY_A               = 0x1E;
		public static final int KEY_S               = 0x1F;
		public static final int KEY_D               = 0x20;
		public static final int KEY_F               = 0x21;
		public static final int KEY_G               = 0x22;
		public static final int KEY_H               = 0x23;
		public static final int KEY_J               = 0x24;
		public static final int KEY_K               = 0x25;
		public static final int KEY_L               = 0x26;
		public static final int KEY_SEMICOLON       = 0x27;
		public static final int KEY_APOSTROPHE      = 0x28;
		public static final int KEY_GRAVE           = 0x29; /* accent grave */
		public static final int KEY_LSHIFT          = 0x2A;
		public static final int KEY_BACKSLASH       = 0x2B;
		public static final int KEY_Z               = 0x2C;
		public static final int KEY_X               = 0x2D;
		public static final int KEY_C               = 0x2E;
		public static final int KEY_V               = 0x2F;
		public static final int KEY_B               = 0x30;
		public static final int KEY_N               = 0x31;
		public static final int KEY_M               = 0x32;
		public static final int KEY_COMMA           = 0x33;
		public static final int KEY_PERIOD          = 0x34; /* . on main keyboard */
		public static final int KEY_SLASH           = 0x35; /* / on main keyboard */
		public static final int KEY_RSHIFT          = 0x36;
		public static final int KEY_MULTIPLY        = 0x37; /* * on numeric keypad */
		public static final int KEY_LMENU           = 0x38; /* left Alt */
		public static final int KEY_SPACE           = 0x39;
		public static final int KEY_CAPITAL         = 0x3A;
		public static final int KEY_F1              = 0x3B;
		public static final int KEY_F2              = 0x3C;
		public static final int KEY_F3              = 0x3D;
		public static final int KEY_F4              = 0x3E;
		public static final int KEY_F5              = 0x3F;
		public static final int KEY_F6              = 0x40;
		public static final int KEY_F7              = 0x41;
		public static final int KEY_F8              = 0x42;
		public static final int KEY_F9              = 0x43;
		public static final int KEY_F10             = 0x44;
		public static final int KEY_NUMLOCK         = 0x45;
		public static final int KEY_SCROLL          = 0x46; /* Scroll Lock */
		public static final int KEY_NUMPAD7         = 0x47;
		public static final int KEY_NUMPAD8         = 0x48;
		public static final int KEY_NUMPAD9         = 0x49;
		public static final int KEY_SUBTRACT        = 0x4A; /* - on numeric keypad */
		public static final int KEY_NUMPAD4         = 0x4B;
		public static final int KEY_NUMPAD5         = 0x4C;
		public static final int KEY_NUMPAD6         = 0x4D;
		public static final int KEY_ADD             = 0x4E; /* + on numeric keypad */
		public static final int KEY_NUMPAD1         = 0x4F;
		public static final int KEY_NUMPAD2         = 0x50;
		public static final int KEY_NUMPAD3         = 0x51;
		public static final int KEY_NUMPAD0         = 0x52;
		public static final int KEY_DECIMAL         = 0x53; /* . on numeric keypad */
		public static final int KEY_F11             = 0x57;
		public static final int KEY_F12             = 0x58;
		public static final int KEY_F13             = 0x64; /*                     (NEC PC98) */
		public static final int KEY_F14             = 0x65; /*                     (NEC PC98) */
		public static final int KEY_F15             = 0x66; /*                     (NEC PC98) */
		public static final int KEY_F16             = 0x67; /* Extended Function keys - (Mac) */
		public static final int KEY_F17             = 0x68;
		public static final int KEY_F18             = 0x69;
		public static final int KEY_KANA            = 0x70; /* (Japanese keyboard)            */
		public static final int KEY_F19             = 0x71; /* Extended Function keys - (Mac) */
		public static final int KEY_CONVERT         = 0x79; /* (Japanese keyboard)            */
		public static final int KEY_NOCONVERT       = 0x7B; /* (Japanese keyboard)            */
		public static final int KEY_YEN             = 0x7D; /* (Japanese keyboard)            */
		public static final int KEY_NUMPADEQUALS    = 0x8D; /* = on numeric keypad (NEC PC98) */
		public static final int KEY_CIRCUMFLEX      = 0x90; /* (Japanese keyboard)            */
		public static final int KEY_AT              = 0x91; /*                     (NEC PC98) */
		public static final int KEY_COLON           = 0x92; /*                     (NEC PC98) */
		public static final int KEY_UNDERLINE       = 0x93; /*                     (NEC PC98) */
		public static final int KEY_KANJI           = 0x94; /* (Japanese keyboard)            */
		public static final int KEY_STOP            = 0x95; /*                     (NEC PC98) */
		public static final int KEY_AX              = 0x96; /*                     (Japan AX) */
		public static final int KEY_UNLABELED       = 0x97; /*                        (J3100) */
		public static final int KEY_NUMPADENTER     = 0x9C; /* Enter on numeric keypad */
		public static final int KEY_RCONTROL        = 0x9D;
		public static final int KEY_SECTION         = 0xA7; /* Section symbol (Mac) */
		public static final int KEY_NUMPADCOMMA     = 0xB3; /* , on numeric keypad (NEC PC98) */
		public static final int KEY_DIVIDE          = 0xB5; /* / on numeric keypad */
		public static final int KEY_SYSRQ           = 0xB7;
		public static final int KEY_RMENU           = 0xB8; /* right Alt */
		public static final int KEY_FUNCTION        = 0xC4; /* Function (Mac) */
		public static final int KEY_PAUSE           = 0xC5; /* Pause */
		public static final int KEY_HOME            = 0xC7; /* Home on arrow keypad */
		public static final int KEY_UP              = 0xC8; /* UpArrow on arrow keypad */
		public static final int KEY_PRIOR           = 0xC9; /* PgUp on arrow keypad */
		public static final int KEY_LEFT            = 0xCB; /* LeftArrow on arrow keypad */
		public static final int KEY_RIGHT           = 0xCD; /* RightArrow on arrow keypad */
		public static final int KEY_END             = 0xCF; /* End on arrow keypad */
		public static final int KEY_DOWN            = 0xD0; /* DownArrow on arrow keypad */
		public static final int KEY_NEXT            = 0xD1; /* PgDn on arrow keypad */
		public static final int KEY_INSERT          = 0xD2; /* Insert on arrow keypad */
		public static final int KEY_DELETE          = 0xD3; /* Delete on arrow keypad */
		public static final int KEY_CLEAR           = 0xDA; /* Clear key (Mac) */
		public static final int KEY_LMETA           = 0xDB; /* Left Windows/Option key */
		/**
		 * The left windows key, mapped to KEY_LMETA
		 *
		 * @deprecated Use KEY_LMETA instead
		 */
		public static final int KEY_LWIN            = KEY_LMETA; /* Left Windows key */
		public static final int KEY_RMETA            = 0xDC; /* Right Windows/Option key */
		/**
		 * The right windows key, mapped to KEY_RMETA
		 *
		 * @deprecated Use KEY_RMETA instead
		 */
		public static final int KEY_RWIN            = KEY_RMETA; /* Right Windows key */
		public static final int KEY_APPS            = 0xDD; /* AppMenu key */
		public static final int KEY_POWER           = 0xDE;
		public static final int KEY_SLEEP           = 0xDF;

	/*	public static final int STATE_ON							= 0;
		public static final int STATE_OFF						 = 1;
		public static final int STATE_UNKNOWN				 = 2;
	*/
		public static final int KEYBOARD_SIZE = 256;

		/** Buffer size in events */
//		private static final int BUFFER_SIZE = 50;

		/** Key names */
//		private static final String[] keyName = new String[KEYBOARD_SIZE];
		private static final Map<String, Integer> keyMap = new HashMap<String, Integer>(256);
		protected static class Event {
			public boolean state;
			public int keyCode;
			public char keyCharCode;
			public boolean repeat;
			public boolean isRepeat() {
				return repeat;
			}
			public Event(boolean state, int keyCode, char keyCharCode, boolean repeat) {
//				super();
				this.state = state;
				this.keyCode = keyCode;
				this.keyCharCode = keyCharCode;
				this.repeat = repeat;
			}
			public boolean isState() {
				return state;
			}
			public int getKeyCode() {
				return keyCode;
			}
			public char getKeyCharCode() {
				return keyCharCode;
			}
			
		}
		private static Keyboard.Event curEvent;
//		private static PriorityQueue<Keyboard.Event> queue = new PriorityQueue<Keyboard.Event>(20);
		
		
//		private static int counter;

//		static {
//			// Use reflection to find out key names
//			Field[] fields = Keyboard.class.getFields();
//			try {
//				for ( Field field : fields ) {
//					if ( Modifier.isStatic(field.getModifiers())
//					     && Modifier.isPublic(field.getModifiers())
//					     && Modifier.isFinal(field.getModifiers())
//					     && field.getType().equals(int.class)
//					     && field.getName().startsWith("KEY_")
//					     && !field.getName().endsWith("WIN") ) { /* Don't use deprecated names */
//
//						int key = field.getInt(null);
//						String name = field.getName().substring(4);
//						keyName[key] = name;
//						keyMap.put(name, key);
//						counter++;
//					}
//
//				}
//			} catch (Exception e) {
//			}
//
//		}

		/** The number of keys supported */
//		private static final int keyCount = counter;
//
		/** Has the keyboard been created? */
		private static boolean created;
//		private static PriorityQueue<KeyboardEvent> pq = new PriorityQueue<KeyboardEvent>();
		/** Are repeat events enabled? */
//		private static boolean repeat_enabled;
		private static boolean[] keyArr;
		/** The keys status from the last poll */
//		private static final ByteBuffer keyDownBuffer = BufferUtils.createByteBuffer(KEYBOARD_SIZE);

	
		static {
//			keyMap.put(CHAR_NONE, '');
			
			
			keyMap.put("Escape", KEY_ESCAPE);
			keyMap.put("Digit1", KEY_1);
			keyMap.put("Digit2", KEY_2);
			keyMap.put("Digit3", KEY_3);
			keyMap.put("Digit4", KEY_4);
			keyMap.put("Digit5", KEY_5);
			keyMap.put("Digit6", KEY_6);
			keyMap.put("Digit7", KEY_7);
			keyMap.put("Digit8", KEY_8);
			keyMap.put("Digit9", KEY_9);
			keyMap.put("Digit0", KEY_0);
			keyMap.put("Minus", KEY_MINUS);
			keyMap.put("Equal", KEY_EQUALS);
			keyMap.put("Backspace", KEY_BACK);
			keyMap.put("Tab", KEY_TAB);
			keyMap.put("KeyQ", KEY_Q);
			keyMap.put("KeyW", KEY_W);
			keyMap.put("KeyE", KEY_E);
			keyMap.put("KeyR", KEY_R);
			keyMap.put("KeyT", KEY_T);
			keyMap.put("KeyY", KEY_Y);
			keyMap.put("KeyU", KEY_U);
			keyMap.put("KeyI", KEY_I);
			keyMap.put("KeyO", KEY_O);
			keyMap.put("KeyF", KEY_P);
			keyMap.put("BracketLeft", KEY_LBRACKET);
			keyMap.put("BracketRight", KEY_RBRACKET);
			keyMap.put("Enter", KEY_RETURN);
			keyMap.put("ControlLeft", KEY_LCONTROL);
			keyMap.put("KeyA", KEY_A);
			keyMap.put("KeyS", KEY_S);
			keyMap.put("KeyD", KEY_D);
			keyMap.put("KeyF", KEY_F);
			keyMap.put("KeyG", KEY_G);
			keyMap.put("KeyH", KEY_H);
			keyMap.put("KeyJ", KEY_J);
			keyMap.put("KeyK", KEY_K);
			keyMap.put("KeyL", KEY_L);
			keyMap.put("Semicolon", KEY_SEMICOLON);
			keyMap.put("Quote", KEY_APOSTROPHE);
			keyMap.put("Backquote", KEY_GRAVE);
			keyMap.put("ShiftLeft", KEY_LSHIFT);
			keyMap.put("Backslash", KEY_BACKSLASH);
			keyMap.put("KeyZ", KEY_Z);
			keyMap.put("KeyX", KEY_X);
			keyMap.put("KeyC", KEY_C);
			keyMap.put("KeyV", KEY_V);
			keyMap.put("KeyB", KEY_B);
			keyMap.put("KeyN", KEY_N);
			keyMap.put("KeyM", KEY_M);
			keyMap.put("Comma", KEY_COMMA);
			keyMap.put("Period", KEY_PERIOD);
			keyMap.put("Slash", KEY_SLASH);
			keyMap.put("ShiftRight", KEY_RSHIFT);
			keyMap.put("NumpadMultiply", KEY_MULTIPLY);
			keyMap.put("AltLeft", KEY_LMENU);
			keyMap.put("Space", KEY_SPACE);
			keyMap.put("CapsLock", KEY_CAPITAL);
			keyMap.put("F1", KEY_F1);
			keyMap.put("F2", KEY_F2);
			keyMap.put("F3", KEY_F3);
			keyMap.put("F4", KEY_F4);
			keyMap.put("F5", KEY_F5);
			keyMap.put("F6", KEY_F6);
			keyMap.put("F7", KEY_F7);
			keyMap.put("F8", KEY_F8);
			keyMap.put("F9", KEY_F9);
			keyMap.put("F10", KEY_F10);
			keyMap.put("NumLock", KEY_NUMLOCK);
			keyMap.put("ScrollLock", KEY_SCROLL);
			keyMap.put("Numpad7", KEY_NUMPAD7);
			keyMap.put("Numpad8", KEY_NUMPAD8);
			keyMap.put("Numpad9", KEY_NUMPAD9);
			keyMap.put("NumpadSubstract", KEY_SUBTRACT);
			keyMap.put("Numpad4", KEY_NUMPAD4);
			keyMap.put("Numpad5", KEY_NUMPAD5);
			keyMap.put("Numpad6", KEY_NUMPAD6);
			keyMap.put("NumpadAdd", KEY_ADD);
			keyMap.put("Numpad1", KEY_NUMPAD1);
			keyMap.put("Numpad2", KEY_NUMPAD2);
			keyMap.put("Numpad3", KEY_NUMPAD3);
			keyMap.put("Numpad0", KEY_NUMPAD0);
			keyMap.put("NumpadDecimal", KEY_DECIMAL);
			keyMap.put("F11", KEY_F11);
			keyMap.put("F12", KEY_F12);
			keyMap.put("F13", KEY_F13);
			keyMap.put("F14", KEY_F14);
		    keyMap.put("F15", KEY_F15);
		    keyMap.put("F16", KEY_F16);
		    keyMap.put("F17", KEY_F17);
		    keyMap.put("F18", KEY_F18);
		    keyMap.put("KanaMode", KEY_KANA);
		    keyMap.put("F19", KEY_F19);
		    
		    keyMap.put("NumpadEqual", KEY_NUMPADEQUALS);
		    
		    keyMap.put("NumpadEnter", KEY_NUMPADENTER);
		    keyMap.put("ControlRight", KEY_RCONTROL);
		    keyMap.put("IntlBackslash", KEY_SECTION);
		    keyMap.put("NumpadComma", KEY_NUMPADCOMMA);
		    keyMap.put("NumpadDivide", KEY_DIVIDE);
		    keyMap.put("PrintScreen", KEY_SYSRQ);
		    keyMap.put("AltRight", KEY_RMENU);
		    
		    keyMap.put("Pause", KEY_PAUSE);
		    keyMap.put("Home", KEY_HOME);
		    keyMap.put("ArrowUp", KEY_UP);
		    keyMap.put("PageUp", KEY_PRIOR);
		    keyMap.put("ArrowLeft", KEY_LEFT);
		    keyMap.put("ArrowRight", KEY_RIGHT);
		    keyMap.put("End", KEY_END);
		    keyMap.put("ArrowDown", KEY_DOWN);
		    keyMap.put("PageDown", KEY_NEXT);
		    keyMap.put("Insert", KEY_INSERT);
		    keyMap.put("Delete", KEY_DELETE);
//		    keyMap.put("NumLock", KEY_CLEAR);
		    keyMap.put("MetaLeft", KEY_LMETA);
		    
		    keyMap.put("MetaRight", KEY_RMETA);
		    
		    keyMap.put("ContextMenu", KEY_APPS);
		    keyMap.put("Power", KEY_POWER);
		    keyMap.put("Sleep", KEY_SLEEP);
		}
		/**
		 * Keyboard cannot be constructed.
		 */
		private Keyboard() {
		}

		/**
		 * Static initialization
		 */
//		private static void initialize() {
//			
//		}
		public static Set<String> map(int key) {
			Set<String> str = new HashSet<String>();
			keyMap.forEach(new BiConsumer<String, Integer>() {

				@Override
				public void accept(String t, Integer u) {
					// TODO Auto-generated method stub
					if (u == key) {
						str.add(t);
					}
				}
				
			});
			return str;
			
		}
		/**
		 * "Create" the keyboard with the given implementation. This is used
		 * reflectively from AWTInputAdapter.
		 *
		 * @throws LWJGLException if the keyboard could not be created for any reason
		 */
//		private static void create(Object unused) {
//			create();
//		}

		/**
		 * "Create" the keyboard. The display must first have been created. The
		 * reason for this is so the keyboard has a window to "focus" in.
		 *
		 * @throws LWJGLException if the keyboard could not be created for any reason
		 */
		public static void create() {
			if (created) return;
			keyArr = new boolean[512];
//			HTMLCanvasElement hce = ((WebGL2RenderingContext)CurrentContext.getContext()).getCanvas();
			Display.getWindow().addEventListener("keydown", new EventListener<KeyboardEvent>() {

				@Override
				public void handleEvent(KeyboardEvent evt) {
					// TODO Auto-generated method stub
					if (Mouse.isSupposedToBeGrabbed && evt.getCode() != "Escape") ((WebGL2RenderingContext) CurrentContext.getContext()).getCanvas().requestPointerLock();
					if (evt.isRepeat()) return;
					
					if (keyMap.containsKey(evt.getCode())) {
//						System.out.printf("%s, %d", evt.getCode(), keyMap.get(evt.getCode()));
//						System.out.println(keyMap.get(evt.getCode()));
						keyArr[keyMap.get(evt.getCode())] = true;
					}else {
						System.out.println(String.format("%s is not available", evt.getCode()));
					}
//					queue.add(new Keyboard.Event(true, keyMap.get(evt.getCode()), (char) evt.getCharCode(), evt.isRepeat()));
					evt.preventDefault();
					evt.stopPropagation();
					
				}
				
			});
			Display.getWindow().addEventListener("keyup", new EventListener<KeyboardEvent>() {

				@Override
				public void handleEvent(KeyboardEvent evt) {
					// TODO Auto-generated method stub
					if (keyMap.containsKey(evt.getCode())) {
//						System.out.printf("%s, %d", evt.getCode(), keyMap.get(evt.getCode()));
//						System.out.println(keyMap.get(evt.getCode()));
						keyArr[keyMap.get(evt.getCode())] = false;
//						queue.add(new Keyboard.Event(false, keyMap.get(evt.getCode()), (char) evt.getCharCode(), false));
					}else {
//						System.out.printf("%s is not available", evt.getCode());
					}
					evt.preventDefault();
					evt.stopPropagation();
				}
				
			});
		}

//		private static void reset() {
//			
//		}

		/**
		 * @return true if the keyboard has been created
		 */
		public static boolean isCreated() {
			return created;
		}

		/**
		 * "Destroy" the keyboard
		 */
		public static void destroy() {
			
		}

		/**
		 * Polls the keyboard for its current state. Access the polled values using the
		 * <code>isKeyDown</code> method.
		 * By using this method, it is possible to "miss" keyboard keys if you don't
		 * poll fast enough.
		 *
		 * To use buffered values, you have to call <code>next</code> for each event you
		 * want to read. You can query which key caused the event by using
		 * <code>getEventKey</code>. To get the state of that key, for that event, use
		 * <code>getEventKeyState</code> - finally use <code>getEventCharacter</code> to get the
		 * character for that event.
		 *
		 * NOTE: This method does not query the operating system for new events. To do that,
		 * Display.processMessages() (or Display.update()) must be called first.
		 *
		 * @see org.lwjgl.input.Keyboard#isKeyDown(int key)
		 * @see org.lwjgl.input.Keyboard#next()
		 * @see org.lwjgl.input.Keyboard#getEventKey()
		 * @see org.lwjgl.input.Keyboard#getEventKeyState()
		 * @see org.lwjgl.input.Keyboard#getEventCharacter()
		 */
		public static void poll() {
			
		}

//		private static void read() {
//			
//		}

		/**
		 * Checks to see if a key is down.
		 * @param key Keycode to check
		 * @return true if the key is down according to the last poll()
		 */
		public static boolean isKeyDown(int key) {
			return keyArr[key];
		}

		/**
		 * Checks whether one of the state keys are "active"
		 *
		 * @param key State key to test (KEY_CAPITAL | KEY_NUMLOCK | KEY_SYSRQ)
		 * @return STATE_ON if on, STATE_OFF if off and STATE_UNKNOWN if the state is unknown
		 */
	/*	public static int isStateKeySet(int key) {
			if (!created)
				throw new IllegalStateException("Keyboard must be created before you can query key state");
			return implementation.isStateKeySet(key);
		}
	*/
		/**
		 * Gets a key's name
		 * @param key The key
		 * @return a String with the key's human readable name in it or null if the key is unnamed
		 */
		public static synchronized String getKeyName(int key) {
			return "";
		}

		/**
		 * Get's a key's index. If the key is unrecognised then KEY_NONE is returned.
		 * @param keyName The key name
		 */
		public static synchronized int getKeyIndex(String keyName) {
			return 0;
		}

		/**
		 * Gets the number of keyboard events waiting after doing a buffer enabled poll().
		 * @return the number of keyboard events
		 */
		public static int getNumKeyboardEvents() {
			return 0;
		}

		/**
		 * Gets the next keyboard event. You can query which key caused the event by using
		 * <code>getEventKey</code>. To get the state of that key, for that event, use
		 * <code>getEventKeyState</code> - finally use <code>getEventCharacter</code> to get the
		 * character for that event.
		 *
		 * @see org.lwjgl.input.Keyboard#getEventKey()
		 * @see org.lwjgl.input.Keyboard#getEventKeyState()
		 * @see org.lwjgl.input.Keyboard#getEventCharacter()
		 * @return true if a keyboard event was read, false otherwise
		 */
		public static boolean next() {
//			if (queue.isEmpty()) {
//				return false;
//			}else {
//				curEvent = queue.poll();
//				return true;
//			}
			
			return true;
		}

		/**
	     * Controls whether repeat events are reported or not. If repeat events
		 * are enabled, key down events are reported when a key is pressed and held for
		 * a OS dependent amount of time. To distinguish a repeat event from a normal event,
		 * use isRepeatEvent().
		 *
		 * @see org.lwjgl.input.Keyboard#getEventKey()
		 */
		public static void enableRepeatEvents(boolean enable) {
			
		}

		/**
	     * Check whether repeat events are currently reported or not.
		 *
		 * @return true is repeat events are reported, false if not.
		 * @see org.lwjgl.input.Keyboard#getEventKey()
		 */
		public static boolean areRepeatEventsEnabled() {
			return false;
		}

//		private static boolean readNext(Object event) {
//			return false;
//		}

		/**
		 * @return Number of keys on this keyboard
		 */
		public static int getKeyCount() {
			return 256;
		}

		/**
		 * @return The character from the current event
		 */
		public static char getEventCharacter() {
			return (char) curEvent.getKeyCharCode();
		}

		/**
	   * Please note that the key code returned is NOT valid against the
	   * current keyboard layout. To get the actual character pressed call
	   * getEventCharacter
	   *
		 * @return The key from the current event
		 */
		public static int getEventKey() {
			return 0;
		}

		/**
		 * Gets the state of the key that generated the
		 * current event
		 *
		 * @return True if key was down, or false if released
		 */
		public static boolean getEventKeyState() {
			return true;
		}

		/**
		 * Gets the time in nanoseconds of the current event.
		 * Only useful for relative comparisons with other
		 * Keyboard events, as the absolute time has no defined
		 * origin.
		 * @return The time in nanoseconds of the current event
		 */
		public static long getEventNanoseconds() {
			return 0;
		}

		/**
		 * @see org.lwjgl.input.Keyboard#enableRepeatEvents(boolean)
		 * @return true if the current event is a repeat event, false if
		 * the current event is not a repeat even or if repeat events are disabled.
		 */
		public static boolean isRepeatEvent() {
			return false;
		}

		
	}
