package main;

import control.InterceptKeyboardEvent;
import control.InterceptMouseEvent;
import org.jnativehook.GlobalScreen;

public class Main {
    public static void main(String[] args) {
        try {
            GlobalScreen.registerNativeHook();
        } catch (Exception e) {
            e.printStackTrace();
        }

        GlobalScreen.addNativeKeyListener(new InterceptKeyboardEvent());
        GlobalScreen.addNativeMouseListener(new InterceptMouseEvent());
    }
}