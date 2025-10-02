package week_08._1002;
import java.io.*;
import java.net.*;

public class SimpleURLReader {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.example.com");

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(url.openStream()))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

            }
        } catch (MalformedURLException e) {
            System.err.println("잘못된 URL: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("네트워크 오류: " + e.getMessage());
        }
    }
}