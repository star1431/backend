package week_08._1002;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPBroadcastClient {
    private static final int SERVER_PORT = 9876; // 서버 포트 번호
    private static final String BROADCAST_IP = "255.255.255.255"; // 브로드캐스트 주소

    public static void main(String[] args) {
        // DatagramSocket - UDP 소켓 생성
        try (DatagramSocket socket = new DatagramSocket()) {
            socket.setBroadcast(true); // 브로드캐스트 허용
            String message = "Hello, UDP Broadcast!";
            byte[] buff = message.getBytes();

            // 브로드캐스트 주소로 패킷 생성
            InetAddress broadcastAddress = InetAddress.getByName(BROADCAST_IP);
            DatagramPacket packet = new DatagramPacket(
                    buff,              // 데이터
                    buff.length,       // 데이터 길이
                    broadcastAddress,  // 브로드캐스트 주소
                    SERVER_PORT        // 서버 포트 번호
            );

            // 브로드캐스트 전송
            socket.send(packet);
            System.out.println("브로드캐스트 메시지 전송: " + message);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}