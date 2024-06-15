package org.example;

import java.io.IOException;
import java.net.*;

public class HttpStatusChecker {
    public String getStatusImage(int code){
        try {
            URI uri = new URI(String.format("https://http.cat/%s.jpg",code));
            URL url = uri.toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int status = connection.getResponseCode();
            if(status != HttpURLConnection.HTTP_OK){
                throw new IllegalArgumentException("Http status check failed");
            }
            return String.format("https://http.cat/%s.jpg",code);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
