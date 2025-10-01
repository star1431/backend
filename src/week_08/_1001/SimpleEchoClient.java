package week_08._1001;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

// Echo 단일연결 클라이언트
public class SimpleEchoClient {
    public static void main(String[] args) {

        try(
            Socket socket = new Socket("localhost", 12345);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            // 표준입력
            Scanner sc = new Scanner(System.in);
        ) {
            System.out.println("서버에 접속되었습니다.");

            while (true) {
                System.out.print("입력(종료:bye) : ");

                // 사용자 입력 -> 서버로 전송
                String msg = sc.nextLine();
                out.println(msg);

                if ("bye".equalsIgnoreCase(msg)) break;
                
                // 서버로부터 응답받음
                String response = in.readLine();
                System.out.println("서버로부터 응답 : " + response);
            }
            System.out.println("클라이언트 종료");

        } catch(Exception e) {
            System.out.println("클라이언트 시작 실패:: " + e.getMessage());
        }
    }
}
