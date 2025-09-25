package week_07._0925;

class CounterA {
    private int count = 0;

    // 동기화가 없는 메서드
    public void increment() {
        count++; // 비원자적 연산 (읽기 + 쓰기)
    }

    public int getCount() {
        return count;
    }
}

public class NoSyncTest {

    public static void main(String[] args) {
        CounterA counter = new CounterA();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        try {
            thread1.join(); // thread1이 끝날 때까지 대기
            thread2.join(); // thread2가 끝날 때까지 대기
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("최종 카운트: " + counter.getCount());
    }
}