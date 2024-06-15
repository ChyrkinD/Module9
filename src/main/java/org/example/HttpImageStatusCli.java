package org.example;

import java.util.Scanner;

public class HttpImageStatusCli {
    Scanner scanner = new Scanner(System.in);

    public void askStatus() {
        int code = 0;
        while (true){
            System.out.println("Enter HTTP status code: ");
            try{
                String input = scanner.nextLine();
                code = Integer.parseInt(input);
                HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();
                httpStatusImageDownloader.downloadStatusImage(code);
            }catch (NumberFormatException e){
                System.out.println("ENTER VALID NUMBER");
            }catch (RuntimeException e) {
                System.out.println("\nThere is not image for HTTP status "+ code);
            }
        }
    }

    public static void main(String[] args) {
        new HttpImageStatusCli().askStatus();
    }
}
