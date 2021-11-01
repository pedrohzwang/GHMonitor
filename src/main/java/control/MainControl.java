package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Date;

public class MainControl {

    private static final String filePath = "D:/ProjetosJava/logs/logs1.txt";

    private static String getContent() {
        StringBuilder existentContent = new StringBuilder();
        String actualLine = "";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
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
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))){
            String oldContent = getContent();
            Date date = new Date();
            String textoComData = date.toString() + " log " + log;
            bw.write(textoComData + "\n");
            Thread.sleep(60000);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}