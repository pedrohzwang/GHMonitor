package service;

import com.google.gson.Gson;
import model.entities.Log;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class LogService {

    private static final Gson JSON_CONVERTER = new Gson();

    public static void sendLog(Log log) {
        String logString = JSON_CONVERTER.toJson(log);
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(logString))
                    .uri(URI.create("http://localhost:8080/api/log"))
                    .timeout(Duration.ofSeconds(5))
                    .build();

            HttpClient httpClient = HttpClient.newBuilder()
                    .connectTimeout(Duration.ofSeconds(5))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    public static void sendLog(Log log) {
//        HttpURLConnection connection;
//        String line;
//        StringBuffer responseContent = new StringBuffer();
//        try {
//            URL url = new URL("http://localhost:8080/api/log");
//            connection = (HttpURLConnection) url.openConnection();
//
//            connection.setRequestMethod("POST");
//            //connection.set
//            connection.setConnectTimeout(5000);
//            connection.setReadTimeout(5000);
//            int status = connection.getResponseCode();
//
//            BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            while ((line = bf.readLine()) != null) {
//                responseContent.append(line);
//            }
//            bf.close();
//            System.out.println(responseContent.toString());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
