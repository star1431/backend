package week_08._1001;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatTCPClient_backup {
    // 호스트 & 포트
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 12345;



    public static void main(String[] args) {
        try (
            Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);
        ) {
            // 서버로부터 타 메시지를 수신하는 스레드
            Thread readThread = new Thread(() -> {
                try {
                    String serverMsg;
                    while ((serverMsg = in.readLine()) != null) {
                        System.out.println(serverMsg);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            });
            readThread.start();

            // 사용자 입력을 서버 전송
            String myMsg;
            while((myMsg = sc.nextLine()) != null && !"bye".equalsIgnoreCase(myMsg)) {
                out.println(myMsg);
            }
            out.println("bye"); // 서버에 종료 메시지 전송


        } catch (Exception e) {
            System.out.println("클라이언트 시작 실패:: " + e.getMessage());
        }
    }
}