package week_08._1001;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MutilThreadEchoServer {
    private static final int PORT = 12345; // 서버 포트 번호
    private static final int THREAD_POOL_SIZE = 6; // 스레드 풀 크기

    // 클라이언트 연결을 처리
    static class ClientHandler implements Runnable {
        private final Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // 클라이언트와의 통신 로직 구현 (echo)
            String userName = null;
            try (
                    // socket.getInputStream() - 클라이언트로부터 데이터를 읽어올 수 있는 통로
                    // socket.getOutputStream() - 클라이언트로 데이터를 출력할 수 있는 통로
                    var in = new java.io.BufferedReader(new java.io.InputStreamReader(socket.getInputStream()));
                    var out = new java.io.PrintWriter(socket.getOutputStream(), true); // true - autoFlush
            ) {
                // getRemoteSocketAddress() - 클라이언트의 IP주소와 포트번호
                SocketAddress clientAddr = socket.getRemoteSocketAddress();
                userName = "사용자-" + socket.getPort();
                System.out.println("[" + clientAddr + "] 사용자 접속됨.. " + userName + " 로 지정");

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("[" + userName + "] 받은 메세지 :: " + inputLine);
                    out.println("Echo::" + inputLine);

                    // 클라이언트 bye 입력시
                    if ("bye".equalsIgnoreCase(inputLine)) break;
                }

                System.out.println("[" + clientAddr + "] 사용자 접속 종료");

            } catch (IOException e) {
                System.out.println(userName + " 통신오류:: " + e.getMessage());
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.out.println(userName + "소켓 닫기 오류:: " + e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        // 서버 소켓 생성 및 클라이언트 연결 대기
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("에코서버 시작 [포트: " + PORT + "]");

            while (true) {
                // 클라이언트 연결 수락
                Socket clientSocket = serverSocket.accept();
                // 클라이언트 연결 처리 작업을 스레드 풀에 전달
                executor.submit(new ClientHandler(clientSocket));
                
                // 스레드 풀 안쓸 때
                // Thread thread = new Thread(new ClientHandler(clientSocket));
                // thread.start();
            }
        } catch (IOException e) {
            System.err.println("서버 오류: " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }
}
