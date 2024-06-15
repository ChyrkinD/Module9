package org.example;

import java.io.*;
import java.net.*;
import java.util.Arrays;


public class HttpStatusImageDownloader {
    void downloadStatusImage(int code) {
        HttpURLConnection connection;
        try {
            URL url = new URI(new HttpStatusChecker().getStatusImage(code)).toURL();
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            if(connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new IOException(connection.getResponseMessage());
            }

            File file = new File(code + ".jpg");
            OutputStream out = new FileOutputStream(file);
            out.write(connection.getInputStream().readAllBytes());
            out.close();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
