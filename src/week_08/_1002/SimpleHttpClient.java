package week_08._1002;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SimpleHttpClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("접속할 URL 입력 (예: www.example.com): ");
        String urlString = scanner.nextLine();
        int port = 80; // 기본 HTTP 포트

        try (
                Socket socket = new Socket(urlString, port);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {
            // HTTP GET 요청 전송
            out.println("GET / HTTP/1.1");
            out.println("Host: " + urlString);
            out.println("Connection: close");
            out.println(); // 빈 줄로 헤더 종료

            // 응답 읽기
            String responseLine;
            while ((responseLine = in.readLine()) != null) {
                System.out.println(responseLine);
            }
            scanner.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}