package week_08._1001;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// Echo 단일연결 서버
public class SimpleEchoServer {
    public static void main(String[] args) {

        // socket ? TCP/IP 기반 통신에서 데이터 송수신의 마지막 접점 (서버 - 서버소켓, 클라이언트 - 소켓)
        // 해당 서버소켓 포트번호에 클라이언트가 접속하면 클라이언트의 소켓을 리턴
        try(ServerSocket serverSocket = new ServerSocket(12345);) {
            System.out.println("에코 서버가 12345 번 포트에서 시작되었습니다.");

            while (true) {
                // 서버가 클라이언트를 기다리다가 accept() 클라이언트가 해당 서버에 접속하면
                // Client의 소켓이 리턴됨.
                try(
                    // 클라이언트와의 연결을 위한 소켓
                    Socket socket = serverSocket.accept();
                    // socket.getInputStream() - 클라이언트로부터 데이터를 읽어올 수 있는 통로
                    // socket.getOutputStream() - 클라이언트로 데이터를 출력할 수 있는 통로
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true); // true - autoFlush
                ) {
                    // getRemoteSocketAddress() - 클라이언트의 IP주소와 포트번호를 알 수 있음
                    System.out.println("클라이언트 연결 :: " + socket.getRemoteSocketAddress());

                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        System.out.println("클라이언트로부터 받은 메시지 :: " + inputLine);
                        out.println("Echo::" + inputLine);
                        
                        // 클라이언트 bye 입력시
                        if("bye".equalsIgnoreCase(inputLine)) break;
                    }
                } catch (Exception e) {
                    System.out.println("클라이언트 통신오류:: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("서버시작실패:: " + e.getMessage());
        }
    }
}