package week_08._1001;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class ChatTCPServer {
    private static final int PORT = 12345;
    private static final Set<ClientHandler> clients = new HashSet<ClientHandler>();

    static class ClientHandler implements Runnable {
        private final Socket socket;
        private PrintWriter out; // 바깥으로 설정해서 메서드도 공유
        private String nickname;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }
        
        // 외부 접근되게 별도 메서드 지정
        public void sendMsg(String msg) {
            if (out != null) out.println(msg);
        }

        @Override
        public void run() {
            try(BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                out = new PrintWriter(socket.getOutputStream(), true);

                // 닉네임 설정
                out.println("닉네임 입력 하세요.");
                nickname = in.readLine();
                if(nickname == null) return;
                // 자기자신만 보임
                System.out.println(nickname +"님 입장");
                
                // 채팅방에 있는 사용자에게 알림
                broadcast(nickname + "님 입장", this);

                String msg;
                while ((msg = in.readLine()) != null) {
                    if("bye".equalsIgnoreCase(msg)) {
                        this.sendMsg("종료했음");
                        break;
                    }
                    // 나도보임
                    this.sendMsg("나: " + msg);
                    // 상대도보임
                    broadcast(nickname + ": " + msg, this);
                }

            } catch (Exception e) {
                System.out.println("클라이언트처리오류: " + e.getMessage());
            } finally {
                // 퇴장 - 브로드캐스트 전에 clients에서 제거
                clients.remove(this);
                if(nickname != null) {
                    // 자기자신만 보임
                    System.out.println(nickname + "님 퇴장");
                    // 채팅방에 있는 사용자에게 알림
                    broadcast(nickname + "님 퇴장", this);
                }
                try {
                    if (out != null) out.close();
                    if (socket != null) socket.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    // 모두에게 (자기 포함)
    private static void broadcast(String msg) {
        for(ClientHandler client : clients) {
            client.sendMsg(msg);
        }
    }
    // 자기 자신 제외
    private static void broadcast(String msg, ClientHandler clientMe) {
        for(ClientHandler client : clients) {
            if(client != clientMe) {
                client.sendMsg(msg);
            }
        }
    }

    public static void main(String[] args) {
        try(
            ServerSocket serverSocket = new ServerSocket(PORT)
        ) {
            System.out.println("채팅서버 시작!");
            while (true) {
                Socket socket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(socket);
                clients.add(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

