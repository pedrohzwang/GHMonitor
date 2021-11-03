package control;

import service.LogService;
import util.LogUtils;

import java.io.*;
import java.util.Date;

public class MainControl {

    private static final File path = new File(LogUtils.getFilePath());
    private static final File file = new File(LogUtils.getFilePath().concat("/log.txt"));

    private static String getContent() {
        StringBuilder existentContent = new StringBuilder();
        String actualLine = "";

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((actualLine = br.readLine()) != null){
                existentContent.append(actualLine);
            }

            return existentContent.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void printEvent(String log) {
        if (!path.exists()){
            path.mkdirs();
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){
            Date date = new Date();
            String textWithDate = date.toString() + " log " + log;
            bw.write(textWithDate + "\n");
            LogService.sendLog();
            Thread.sleep(60000);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}