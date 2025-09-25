package week_07._0925;


class CounterB {
    private int count = 0;

    // 동기화된 메서드
    public synchronized void increment() {
        count++; // 이제 이 메서드는 한 번에 하나의 스레드만 접근 가능
    }

    public int getCount() {
        return count;
    }
}

public class SyncTest {
    public static void main(String[] args) {
        CounterB counter = new CounterB();

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