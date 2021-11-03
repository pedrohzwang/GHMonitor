package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class LogService {

    //private static HttpURLConnection CONNECTION;


    public static void sendLog() {
        HttpURLConnection connection;
        String line;
        StringBuffer responseContent = new StringBuffer();
        try {
            URL url = new URL("http://localhost:8080/api/log");
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            int status = connection.getResponseCode();

            BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = bf.readLine()) != null) {
                responseContent.append(line);
            }
            bf.close();
            System.out.println(responseContent.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
