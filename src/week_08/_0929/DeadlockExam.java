package week_08._0929;

public class DeadlockExam {
    public static void main(String[] args) {
        final Object resource1 = "자원1";
        final Object resource2 = "자원2";

        // 스레드 A
        Thread threadA = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("스레드 A: 자원1 점유");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                synchronized (resource2) {
                    System.out.println("스레드 A: 자원2 점유");
                }
            }
        });

        // 스레드 B
        Thread threadB = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("스레드 B: 자원2 점유");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                synchronized (resource1) {
                    System.out.println("스레드 B: 자원1 점유");
                }
            }
        });

        // 100ms 동안 실행임
        threadA.start();
        threadB.start();

        // 1000ms 뒤에도 A,B가 아직도 실행중이면 ? 데드락임!
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            // isAlive : 스레드가 아직 실행중인지?
            if (threadA.isAlive() && threadB.isAlive()) {
                System.out.println("!!!! 데드락 발생 감지 !!!!");
            }
        }).start();
    }
}
