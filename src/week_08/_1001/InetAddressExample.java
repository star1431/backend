package week_08._1001;

import java.net.InetAddress;
import java.io.IOException;
import java.net.UnknownHostException;

public class InetAddressExample {
    public static void main(String[] args) throws Exception {
        // 사이트 IP 및 이름(host)
        InetAddress address = InetAddress.getByName("bootcamp.likelion.net");
        System.out.println("ip:: "  + address.getHostAddress());
        System.out.println("host:: "  + address.getHostName());
        // 도달 가능 여부 (ping 같은 기능)
        boolean b1 = address.isReachable(3000); // 3s
        System.out.println("도달가능:: " + b1); 
        // cmd의 ping과 다르게 false 뜨는 경우 (방화벽, 권한, 서버측 설정 등..)
        System.out.println("─".repeat(10));


        // getAllByName : 해당 도메인 모든 IP 주소 가져옴
        InetAddress[] alladdress = InetAddress.getAllByName("www.google.com");
        for(InetAddress addr : alladdress) {
            System.out.println("ip:: "  + addr.getHostAddress());
        }
        System.out.println("─".repeat(10));

        // 로컬 호스트 IP 주소 및 이름(host)
        InetAddress local = InetAddress.getLocalHost();
        System.out.println("local-ip:: "  + local.getHostAddress());
        System.out.println("local-host:: "  + local.getHostName());

        boolean b2 = local.isReachable(3000); // 3s
        System.out.println("도달가능:: " + b2); // 로컬은 무조건 true
        System.out.println("─".repeat(10));

        // 바이트 배열로 IP 확인
        byte[] ip = local.getAddress();
        System.out.print("byte format:: ");
        for(int i = 0; i < ip.length; i++) {
            System.out.print(ip[i] & 0xFF);
            if(i < ip.length - 1) {
                System.out.print(".");
            }
        }
        System.out.println();

        // 루프백 주소 확인
        System.out.println("루프백 주소?:: " + local.isLoopbackAddress());

        // 사설 IP 확인
        System.out.println("사설 IP?:: " + local.isSiteLocalAddress());
    }
}
