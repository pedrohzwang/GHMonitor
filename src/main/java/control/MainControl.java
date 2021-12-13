package control;

import model.entities.Log;
import org.jnativehook.NativeInputEvent;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.mouse.NativeMouseEvent;
import service.LogService;
import util.LogUtils;

import java.io.*;
import java.time.LocalDateTime;

public class MainControl {

    private static final File path = new File(LogUtils.getFilePath());
    private static final File file = new File(LogUtils.getFilePath().concat("/log.txt"));

    public static void printEvent(NativeInputEvent ev) {
        LocalDateTime date = LocalDateTime.now();
        StringBuilder message = new StringBuilder();
        if (!path.exists()){
            path.mkdirs();
        }
        if (ev instanceof NativeKeyEvent) {
            message.append("KEY PRESSED");
        } else if (ev instanceof NativeMouseEvent) {
            message.append("MOUSE CLICKED".concat(" ").concat(String.valueOf(((NativeMouseEvent) ev).getButton())));
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){
            Log log = new Log(message.toString(), date.toString(), 3);
            String textWithDate = date.toString().concat(" ").concat(message.toString());
            bw.write(textWithDate + "\n");
            LogService.sendLog(log);
            Thread.sleep(6000);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}