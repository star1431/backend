package week_08._1001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicBoolean;

public class ChatTCPClient_backup2 {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 12345;

    // ANSI 제어코드
    private static final String CR = "\r";           // 커서 맨 앞으로
    private static final String CLEAR_LINE = "\033[2K"; // 현재 줄 전체 지우기
    private static final String PROMPT = "입력> ";

    public static void main(String[] args) {
        try (
            Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true); // autoFlush=true
        ) {
            // 입력줄을 보존/복원하는 콘솔 UI
            ConsoleUI ui = new ConsoleUI();

            AtomicBoolean running = new AtomicBoolean(true);

            // 수신 스레드: 서버 메시지 출력
            Thread readThread = new Thread(() -> {
                try {
                    String serverMsg;
                    while ((serverMsg = in.readLine()) != null) {
                        // 현재 입력줄 지우고 → 메시지 출력 → 프롬프트/버퍼 복원
                        ui.printIncoming(serverMsg);
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                } finally {
                    running.set(false);
                }
            });
            readThread.start();

            // 입력 스레드: 키보드에서 문자 단위로 읽어 버퍼 유지
            // Scanner.nextLine()은 “입력 중인 버퍼”를 우리가 알 수 없어서 줄 복원이 불가
            // 문자 단위로 읽으면 백스페이스 등 편집까지 반영 가능
            ui.renderPrompt(); // 첫 프롬프트
            InputStream sysIn = System.in;
            while (running.get()) {
                int ch = sysIn.read();
                if (ch == -1) break;

                // CR은 무시(CRLF 환경 대비)
                if (ch == '\r') continue;

                // Enter: 버퍼 내용 서버로 전송
                else if (ch == '\n') {
                    String msg = ui.consumeBuffer(); // 현재 버퍼를 문자열로 반환 + 줄바꿈 출력
                    if (msg != null) {
                        out.println(msg); // autoFlush=true 이므로 즉시 송신
                        if ("bye".equalsIgnoreCase(msg.trim())) {
                            running.set(false);
                            break;
                        }
                    }
                    ui.renderPrompt();
                } else if (ch == 127 || ch == 8) {
                    // Backspace 처리(DEL 또는 BS)
                    ui.backspace();
                } else {
                    // 일반 문자: 버퍼에 추가하고 화면에도 출력
                    ui.append((char) ch);
                }
            }

            // 종료 프로토콜
            out.println("bye");

        } catch (Exception e) {
            System.out.println("클라이언트 시작 실패:: " + e.getMessage());
        }
    }

    //  콘솔 UI : 입력 버퍼 보존/복원
    static class ConsoleUI {
        private final StringBuilder buf = new StringBuilder();

        // 현재 프롬프트+버퍼를 한 줄로 만들기
        private String currentLine() {
            return PROMPT + buf;
        }

        // 프롬프트와 버퍼를 다시 그리기
        public synchronized void renderPrompt() {
            System.out.print(CR + CLEAR_LINE + currentLine());
            System.out.flush();
        }

        // 서버에서 수신된 메시지를 안전하게 출력 (입력줄 보존)
        public synchronized void printIncoming(String msg) {
            // 현재 입력줄 지우기
            System.out.print(CR + CLEAR_LINE);
            // 수신 메시지 출력
            System.out.println(msg);
            // 프롬프트 및 현재 입력 복원
            System.out.print(currentLine());
            System.out.flush();
        }

        // 입력 버퍼에 문자 추가 (화면에도 반영)
        public synchronized void append(char ch) {
            buf.append(ch);
            System.out.print(ch);
            System.out.flush();
        }

        // 백스페이스: 버퍼/화면에서 한 글자 제거
        public synchronized void backspace() {
            if (buf.length() == 0) return;
            buf.deleteCharAt(buf.length() - 1);
            // 커서를 왼쪽으로 이동 → 공백 덮어쓰기 → 다시 왼쪽 이동
            System.out.print("\033[D \033[D");
            System.out.flush();
        }

        // Enter 시 버퍼 비우고 문자열 반환 + 줄바꿈 출력
        public synchronized String consumeBuffer() {
            if (buf.length() == 0) {
                System.out.println();
                return null;
            }
            String s = buf.toString();
            buf.setLength(0);
            System.out.println(); // 현재 줄 확정
            return s;
        }
    }
}
