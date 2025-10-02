package week_08._1002;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLConnectionPostExam {
    public static void main(String[] args) {
        // JSONPlaceholder - 무료 테스트 API 사용
        String urlString = "https://jsonplaceholder.typicode.com/posts";
        String jsonData = "{\"title\":\"테스트 제목\",\"body\":\"테스트 내용\",\"userId\":1}";

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // POST 요청 설정
            connection.setRequestMethod("POST"); // 명시적으로 POST 설정
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");

            // JSON 데이터 전송
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonData.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // 응답 읽기
            int responseCode = connection.getResponseCode();
            System.out.println("응답 코드: " + responseCode);

            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println("전송한 JSON: " + jsonData);
                System.out.println("응답 JSON: " + response.toString());
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}