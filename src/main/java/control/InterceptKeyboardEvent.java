package control;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class InterceptKeyboardEvent implements NativeKeyListener {
    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {
        MainControl.printEvent(nativeKeyEvent.paramString());
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        MainControl.printEvent(nativeKeyEvent.paramString());
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
        MainControl.printEvent(nativeKeyEvent.paramString());
    }
}