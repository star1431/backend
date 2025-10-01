package week_08._1001;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

// Echo 연결 클라이언트
public class SimpleEchoClient {
    public static void main(String[] args) {

        try(
            // socket ? TCP/IP 기반 통신에서 데이터 송수신의 마지막 접점 (서버 - 서버소켓, 클라이언트 - 소켓)
            // Socket 객체로 TCP 소켓 생성하여 서버에 접속함
            Socket socket = new Socket("localhost", 12345);
            // socket.getInputStream() - 서버 -> 클라이언트 수신 스트림
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // socket.getOutputStream() - 클라이언트 -> 서버 송신 스트림
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in) // 표준입력 사용
        ) {
            socket.setSoTimeout(1000);
            try {
                out.println("접속요청");
                String test = in.readLine();
                if (test == null) {
                    System.out.println("서버가 응답하지 않습니다. 종료합니다.");
                    return;
                }
            } catch (Exception e) {
                System.out.println("서버가 응답하지 않습니다. 종료합니다.");
                return;
            }

            System.out.println("서버에 접속되었습니다.");

            while (true) {
                System.out.print("입력(종료:bye) : ");

                // 사용자 입력 -> 서버로 전송
                String msg = sc.nextLine();
                out.println(msg); // autoflush

                if ("bye".equalsIgnoreCase(msg)) break;
                
                // 서버로부터 응답받음
                String response = in.readLine();
                System.out.println("서버로부터 응답: " + response);
            }
            System.out.println("클라이언트 종료");

        } catch(Exception e) {
            // 서버연결 실패
            System.out.println("서버 연결 실패: " + e.getMessage());
        }
    }
}
