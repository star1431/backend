package week_08._1002;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class ChatClientSwing extends JFrame {
    // private JTextArea textArea;
    private JTextPane textPane; // 대화색상 관련
    private JTextField inputField;
    private JButton sendButton;
    private PrintWriter out;
    private JLabel userCountLabel;

    public ChatClientSwing(String host, int port) {
        setTitle("채팅 클라이언트");        // 창 제목
        setSize(800, 600);          // 창 크기
        setDefaultCloseOperation(EXIT_ON_CLOSE); // 닫기 버튼 클릭 시 종료
        setLocationRelativeTo(null);           // 화면 중앙에 창 띄우기

        // UI 구성
        textPane = new JTextPane();     // 채팅 메시지 표시 영역
        textPane.setEditable(false);  // 편집 불가
        JScrollPane scrollPane = new JScrollPane(textPane); // 스크롤 가능
        
        // textArea 인 경우
        // textArea = new JTextArea();
        // textArea.setEditable(false);
        // JScrollPane scrollPane = new JScrollPane(textArea);

        // 접속자 수 라벨
        userCountLabel = new JLabel("접속자 수: 0명");
        userCountLabel.setHorizontalAlignment(JLabel.CENTER);
        userCountLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // 필드 및 버튼
        inputField = new JTextField(); // 메시지 입력 필드
        sendButton = new JButton("전송"); // 전송 버튼

        // 레이아웃 설정
        JPanel bottomPanel = new JPanel(new BorderLayout()); // 하단 패널
        bottomPanel.add(inputField, BorderLayout.CENTER); // 입력 필드 중앙
        bottomPanel.add(sendButton, BorderLayout.EAST); // 버튼 오른쪽

        add(userCountLabel, BorderLayout.NORTH); // 상단에 접속자 수 라벨
        add(scrollPane, BorderLayout.CENTER); // 중앙에 스크롤 패널
        add(bottomPanel, BorderLayout.SOUTH); // 하단에 입력 패널

        // 버튼/엔터키 이벤트
        sendButton.addActionListener(e -> sendMessage());
        inputField.addActionListener(e -> sendMessage());

        //입력 필드에 초기 포커스 설정
        SwingUtilities.invokeLater(() -> inputField.requestFocusInWindow());

        // 서버 연결 스레드
        new Thread(() -> connect(host, port)).start();
    }

    // 서버 연결 및 메시지 수신
    private void connect(String host, int port) {
        try (
            Socket socket = new Socket(host, port);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            this.out = new PrintWriter(socket.getOutputStream(), true);
            appendMessage("서버에 연결됨: " + host + ":" + port);
            // 서버 메시지 읽는 스레드
            new Thread(() -> {
                try {
                    String line;
                    while ((line = in.readLine()) != null) {
                        // <!-- 수정 --> 접속자 수 메시지 처리
                        if (line.startsWith("[접속자수:")) {
                            updateUserCount(line);
                        } else {
                            appendMessage(line);
                        }
                    }
                } catch (IOException e) {
                    appendMessage("서버 연결이 종료되었습니다.");
                }
            }).start();

            // 메인 스레드는 계속 대기 (연결 유지)
            while (socket.isConnected()) {
                Thread.sleep(100);
            }
        } catch (IOException e) {
            appendMessage("서버 연결 실패: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            if (out != null) {
                out.close();
                out = null;
            }
        }
    }

    // 접속자 수 업데이트
    private void updateUserCount(String msg) {
        SwingUtilities.invokeLater(() -> {
            userCountLabel.setText("접속자 수: " + msg.substring(5, msg.length() - 1));
        });
    }

    // 메시지 전송
    private void sendMessage() {
        String msg = inputField.getText().trim();
        if (!msg.isEmpty() && out != null) {
            if("/exit".equalsIgnoreCase(msg)) {
                appendMessage("채팅을 종료합니다.");
                System.exit(0);
            }
            out.println(msg);
            inputField.setText(""); // 입력 필드 초기화
        }
    }

    // 메시지 영역에 메시지
    private void appendMessage(String msg) {
        SwingUtilities.invokeLater(() -> {
            try {
                // 스타일 문서 및 속성 집합 생성
                javax.swing.text.StyledDocument doc = textPane.getStyledDocument();
                javax.swing.text.SimpleAttributeSet attr = new javax.swing.text.SimpleAttributeSet();

                Color color; // 기본 색상 (검은색)
                String displayMsg = msg;

                // 메시지 타입별 색상 처리
                if (msg.startsWith("[나]") || msg.startsWith("[귓속말 전송]")) {
                    color = new Color(0, 128, 0);
                } else if (msg.startsWith("[귓속말]")) {
                    color = Color.BLUE;
                } else if(msg.startsWith("[server")) {
                    color = Color.RED;
                } else {
                    color = Color.BLACK;
                }

                // 메시지에 따라 색상 적용
                javax.swing.text.StyleConstants.setForeground(attr, color);
                // 문서에 메시지 추가
                doc.insertString(doc.getLength(), displayMsg + "\n", attr);
                textPane.setCaretPosition(doc.getLength()); // 스크롤 최하단
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });
        
        // textArea인 경우
        // SwingUtilities.invokeLater(() -> {
        //     textArea.append(msg + "\n"); // 메시지
        //     textArea.setCaretPosition(textArea.getDocument().getLength()); // 스크롤 최하단
        // });
    }

    public static void main(String[] args) {
        // SwingUtilities.invokeLater - GUI 관련 작업은 이벤트 디스패치 스레드에서 실행
        SwingUtilities.invokeLater(() -> {
            // ChatClientSwing 인스턴스 생성 및 표시
            ChatClientSwing client = new ChatClientSwing("localhost", 12345);
            client.setVisible(true); // 창 표시
        });
    }
}