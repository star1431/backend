package week_08._1002;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPEchoClient {
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 9876;
    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) {
        try (
            // DatagramSocket - 클라이언트 UDP 소켓 생성 (포트 미지정)
            // 서버랑 달리 클라이언트는 포트번호 지정 안함 (운영체제가 빈 포트번호 자동 할당)
            DatagramSocket socket = new DatagramSocket();
            Scanner sc = new Scanner(System.in);
        ) {
            // 서버 주소 객체 생성
            InetAddress serverAddress = InetAddress.getByName(SERVER_HOST);
            byte[] buf = new byte[BUFFER_SIZE];
            System.out.println("UDP Echo 클라이언트가 시작되었습니다. (종료: quit)");

            while (true) {
                System.out.print("입력: ");
                String message = sc.nextLine();
                if ("quit".equalsIgnoreCase(message)) break;

                // 메시지 전송 패킷 생성 (클라이언트 -> 서버)
                byte[] sendData = message.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(
                        sendData,          // 전송 데이터
                        sendData.length,   // 전송 데이터 길이
                        serverAddress,     // 서버 주소
                        SERVER_PORT        // 서버 포트
                );
                // 데이터 송신
                socket.send(sendPacket); 

                // 서버로부터 응답 수신 (서버 -> 클라이언트)
                DatagramPacket receivePacket = new DatagramPacket(buf, buf.length);
                socket.receive(receivePacket); // 응답 올 때까지 대기
                String response = new String(
                        receivePacket.getData(),    // byte 배열
                        0, // 시작 인덱스
                        receivePacket.getLength()   // 실제 데이터 길이
                );
                System.out.println("[서버 응답] " + response);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
