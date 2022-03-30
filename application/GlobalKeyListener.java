<<<<<<< HEAD
package application;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class GlobalKeyListener implements NativeKeyListener {
	private static int escaped;

	public GlobalKeyListener() {
		escaped = 1;
	}

	public void nativeKeyPressed(NativeKeyEvent e) {

		if (e.getKeyCode() == NativeKeyEvent.VC_A) {
			System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
			GlobalKeyListener.escaped = 5;
			System.out.println(escaped);

		}
		if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
			System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
			GlobalKeyListener.escaped = 1;
			System.out.println(escaped);
			System.exit(1);
		}
	}

	public void nativeKeyTyped(NativeKeyEvent e) {
		GlobalKeyListener.escaped = 5;

	}

	public void change(NativeKeyEvent e) {
		if (e.getKeyCode() == NativeKeyEvent.VC_A) {
			GlobalKeyListener.escaped = 5;
		}
	}

	public int isEscaped() {
		return escaped;
	}
}
=======
package application;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class GlobalKeyListener implements NativeKeyListener {
	private static int escaped;

	public GlobalKeyListener() {
		escaped = 1;
	}

	public void nativeKeyPressed(NativeKeyEvent e) {

		if (e.getKeyCode() == NativeKeyEvent.VC_A) {
			System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
			GlobalKeyListener.escaped = 5;
			System.out.println(escaped);

		}
		if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
			System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
			GlobalKeyListener.escaped = 1;
			System.out.println(escaped);
			System.exit(1);
		}
	}

	public void nativeKeyTyped(NativeKeyEvent e) {
		GlobalKeyListener.escaped = 5;

	}

	public void change(NativeKeyEvent e) {
		if (e.getKeyCode() == NativeKeyEvent.VC_A) {
			GlobalKeyListener.escaped = 5;
		}
	}

	public int isEscaped() {
		return escaped;
	}
}
>>>>>>> 2d41b70085db30c249926faac5bf0fb34d147589
