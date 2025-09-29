package week_08._0929;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

// 6-4. 데드락 타임아웃 설정
public class TimeoutSolution {
    private final ReentrantLock lock1 = new ReentrantLock();
    private final ReentrantLock lock2 = new ReentrantLock();

    public void performTask() throws InterruptedException {
        while (true) {
            if (lock1.tryLock(1, TimeUnit.SECONDS)) {
                try {
                    if (lock2.tryLock(1, TimeUnit.SECONDS)) {
                        try {
                            // 작업 수행
                            break;
                        } finally {
                            lock2.unlock();
                        }
                    }
                } finally {
                    lock1.unlock();
                }
            }
            Thread.sleep(100); // 재시도 전 대기
        }
    }
}