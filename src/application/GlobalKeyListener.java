package application;

import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

public class GlobalKeyListener implements NativeKeyListener {

	public void nativeKeyPressed(NativeKeyEvent e) {

		if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
			System.out.println("escaped");
			System.exit(1);
		}
	}

	public void nativeKeyTyped(NativeKeyEvent e) {

	}

	public void change(NativeKeyEvent e) {
	}

}
