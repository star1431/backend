package week_08._1002;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLDetailsExam {
    public static void main(String[] args) {
        String urlString = "http://www.example.com"; // 접근할 웹 리소스 URL

        try {
            // URL 객체 생성
            URL url = new URL(urlString);

            // URL 정보 출력
            System.out.println("프로토콜: " + url.getProtocol());
            System.out.println("호스트: " + url.getHost());
            System.out.println("포트: " + url.getPort());
            System.out.println("경로: " + url.getPath());
            System.out.println("─".repeat(20));

            // URLConnection 객체 생성 및 연결
            URLConnection connection = url.openConnection();

            connection.setConnectTimeout(5000); // 연결 타임아웃
            connection.setReadTimeout(5000); // 읽기 타임아웃
            // connection.connect(); // 연결 설정 - 생략가능

            // 헤더 정보 읽기
            System.out.println("헤더정보");
            System.out.println("Content-Type: " + connection.getContentType());
            System.out.println("Content-Length: " + connection.getContentLength());

            System.out.println("─".repeat(20));

            // 응답 데이터 읽기
            // connection.getInputStream() - 이 시점에서 자동으로 연결됨
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println(inputLine);
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}