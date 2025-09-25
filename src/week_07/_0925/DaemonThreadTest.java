package week_07._0925;


public class DaemonThreadTest {

    public static void main(String[] args) {

        System.out.println("메인 스레드 시작");

        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("데몬 스레드 실행 중...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        });

        daemonThread.setDaemon(true); // 데몬 스레드로 설정
        daemonThread.start();

        try {
            Thread.sleep(3000); // 메인 스레드 3초 대기
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("메인 스레드 종료");
    }
}