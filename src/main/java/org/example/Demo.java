package org.example;

public class Demo {
    public static void main(String[] args) {
        HttpStatusChecker checker = new HttpStatusChecker();
        String statusImage = checker.getStatusImage(1000);
        System.out.println(statusImage);
//        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
//        downloader.downloadStatusImage(500);
    }
}