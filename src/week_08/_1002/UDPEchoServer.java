package week_08._1002;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPEchoServer {
    private static final int PORT = 9876; // 서버 포트 번호
    private static final int BUFFER_SIZE = 1024; // 버퍼 크기

    public static void main(String[] args) {
        // DatagramSocket - UDP 소켓 생성 (포트 바인딩)
        try (DatagramSocket socket = new DatagramSocket(PORT)) {
            System.out.println("UDP Echo 서버가 포트 " + PORT + "에서 시작되었습니다.");
            byte[] buf = new byte[BUFFER_SIZE]; // 수신 버퍼

            while (true) {
                // DatagramPacket - 수신 패킷 생성 (클라이언트 -> 서버)
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                
                // 클라이언트가 데이터를 보낼 때까지 대기(블로킹 호출)
                // -데이터 수신 시, 패킷 객체에 데이터와 클라이언트 주소/포트 정보가 채워짐
                socket.receive(packet);

                // 수신된 데이터 처리
                String message = new String(
                    packet.getData(),  // byte 배열
                    0,          // 시작 인덱스
                    packet.getLength() // 실제 데이터 길이
                );
                System.out.println("수신된 메시지:: " + message);

                // 수신된 데이터를 응답 데이터로 변환
                String responseMessage = "Echo:: "+ message;
                byte[] responseBuffer = responseMessage.getBytes();

                // DatagramPacket - 송신 패킷 생성 (서버 -> 클라이언트)
                DatagramPacket sendPacket = new DatagramPacket(
                        responseBuffer,         // 응답 데이터
                        responseBuffer.length,  // 응답 데이터 길이
                        packet.getAddress(),    // 클라이언트 IP 주소
                        packet.getPort()        // 클라이언트 포트 번호
                );
                
                // 클라이언트 데이터 송신
                socket.send(sendPacket);
                System.out.println("[전송] " + responseMessage);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
