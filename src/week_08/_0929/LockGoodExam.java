package week_08._0929;

public class LockGoodExam {
    private final Object lock = new Object();
    private int count = 0;

    // 안좋은 예
    public void badMethod() {
        synchronized(lock) {
            longRun(); // 긴작업..
            commonData(); // 실제 동기화가 필요한 부분
        }
    }

    // 좋은 예
    public void goodMethod() {
        longRun(); // 락 밖에서 수행
        synchronized(lock) {
            commonData(); // 필요한 부분만 동기화
        }
    }

    private void longRun() {
        try {
            Thread.sleep(2000); // 2초 대기
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    private void commonData() {
        count++;
        System.out.println("[" + Thread.currentThread().getName() + "] count: " + count);
    }

    public static void main(String[] args) {
        LockGoodExam exam = new LockGoodExam();

        Runnable badTask = () -> exam.badMethod();
        Runnable goodTask = () -> exam.goodMethod();

        // 스레드 풀 예시
        Thread t1 = new Thread(badTask, "스레드 A");
        Thread t2 = new Thread(badTask, "스레드 B");

        Thread t3 = new Thread(goodTask, "스레드 C");
        Thread t4 = new Thread(goodTask, "스레드 D");

        System.out.println("=== badMethod 실행 ===");
        t1.start();
        t2.start();

        try { Thread.sleep(4100); } catch (InterruptedException e) {}

        System.out.println("\n=== goodMethod 실행 ===");
        t3.start();
        t4.start();
    }
}