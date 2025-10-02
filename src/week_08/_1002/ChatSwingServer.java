package week_08._1002;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

// (10.01) TCP 멀티스레드 참고
public class ChatSwingServer {
    private static final int PORT = 12345;
    private static final Map<String, ClientHandler> clients = new HashMap<>();

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
                out.println("[server알림] 닉네임 입력 하세요.");
                while (true) {
                    nickname = in.readLine();
                    if(nickname == null) return;
                    // 닉네임 중복 체크
                    if(clients.containsKey(nickname)) {
                        out.println("[server알림] 이미 사용중인 닉네임입니다.");
                    } else {
                        break;
                    }
                }
                

                // 클라이언트 목록에 추가 (nickname : ClientHandler)
                clients.put(nickname, this);

                // 입장 시 접속자 수 업데이트
                broadcastUserCount();

                // 서버콘솔에 표시
                System.out.println(nickname +"님 입장");
                
                // 사용법 안내
                sendUsageInfo();

                // 클라이언트 자신만 노출
                this.sendMsg(nickname + "님 입장");
                // 채팅방에 있는 사용자에게 알림
                broadcast("[server알림] " + nickname + "님이 입장하셨습니다.", this);

                String msg;
                while ((msg = in.readLine()) != null) {
                    if("/exit".equalsIgnoreCase(msg)) {
                        this.sendMsg("[server알림] 채팅을 종료합니다.");
                        break;
                    } else if("/help".equalsIgnoreCase(msg)) {
                        sendUsageInfo();
                    } else if(msg.startsWith("/to ")) {
                        handleWhisper(msg);
                    } else {
                        // 내 메세지 - (나)
                        this.sendMsg("[나] " + nickname + ": " + msg);
                        // 내 메세지 - (상대)
                        broadcast(nickname + ": " + msg, this);
                    }
                }

            } catch (Exception e) {
                System.out.println("클라이언트처리오류: " + e.getMessage());
            } finally {
                // 퇴장 - 브로드캐스트 전에 clients에서 제거
                clients.remove(nickname);
                if(nickname != null) {
                    // 자기자신만 보임
                    System.out.println(nickname + "님 퇴장");
                    // 채팅방에 있는 사용자에게 알림
                    broadcast("[server알림] " + nickname + "님이 퇴장하셨습니다.", null);
                    // 퇴장 시 접속자 수 업데이트
                    broadcastUserCount();
                }
                try {
                    if (out != null) out.close();
                    if (socket != null) socket.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        
        // 사용법 안내 메시지
        private void sendUsageInfo() {
            sendMsg("────────────────── 채팅 사용법 ──────────────────");
            sendMsg("1. 일반 메시지: 내용을 입력 후 엔터");
            sendMsg("2. 귓속말: /to [대상닉네임] [내용] 형식으로 입력");
            sendMsg("   예) /to userA 안녕하세요.");
            sendMsg("3. 종료: /exit 를 입력 후 엔터");
            sendMsg("4. 도움말: /help 를 입력 후 엔터");
            sendMsg("───────────────────────────────────────────");
        }
        
        // 귓속말 처리
        private void handleWhisper(String msg) {
            String[] parts = msg.split(" ", 3);
            if(parts.length < 3) {
                sendMsg("[server알림] 귓속말 형식이 올바르지 않습니다. /to [닉네임] [메시지] 형식으로 입력하세요.");
                return;
            }
            
            String targetNickname = parts[1];
            String whisperMsg = parts[2];
            
            ClientHandler targetClient = clients.get(targetNickname);
            if(targetClient == null) {
                sendMsg("[server알림] '" + targetNickname + "' 사용자를 찾을 수 없습니다.");
                return;
            }
            
            // 받는 사람에게 귓속말 전송
            targetClient.sendMsg("[귓속말] " + nickname + " → " + targetNickname + ": " + whisperMsg);
            // 보내는 사람에게 확인 메시지
            this.sendMsg("[귓속말 전송] " + nickname + " → " + targetNickname + ": " + whisperMsg);
        }
    }
    
    // 자기 자신 제외하고 브로드캐스트
    private static void broadcast(String msg, ClientHandler clientMe) {
        for(ClientHandler client : clients.values()) {
            if(client != clientMe) {
                client.sendMsg(msg);
            }
        }
        broadcastUserCount();
    }

    // 접속자 수 브로드캐스트 메서드 추가
    private static void broadcastUserCount() {
        String userCountMsg = "[접속자수:" + clients.size() + "명]";
        for(ClientHandler client : clients.values()) {
            client.sendMsg(userCountMsg);
        }
    }

    public static void main(String[] args) {
        try(
            ServerSocket serverSocket = new ServerSocket(PORT)
        ) {
            System.out.println("채팅서버 시작! (포트: " + PORT + ")");
            while (true) {
                Socket socket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(socket);
                new Thread(clientHandler).start();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}