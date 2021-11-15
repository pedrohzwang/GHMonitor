package control;

import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseListener;

public class InterceptMouseEvent implements NativeMouseListener {
    @Override
    public void nativeMouseClicked(NativeMouseEvent nativeMouseEvent) {
        MainControl.printEvent(nativeMouseEvent);
    }

    @Override
    public void nativeMousePressed(NativeMouseEvent nativeMouseEvent) {
        MainControl.printEvent(nativeMouseEvent);
    }

    @Override
    public void nativeMouseReleased(NativeMouseEvent nativeMouseEvent) {
        MainControl.printEvent(nativeMouseEvent);
    }
}