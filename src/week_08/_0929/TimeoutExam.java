package week_08._0929;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TimeoutExam {
    // 공정성 옵션: true면 대기 시간 오래된 스레드에 우선권 (기아 방지 도움)
    private final ReentrantLock lock1 = new ReentrantLock(true);
    private final ReentrantLock lock2 = new ReentrantLock(true);

    public void timeoutRun() throws InterruptedException {
        final long TIMEOUT_MS = 1000; // tryLock 대기시간
        final int MAX_RETRY = 100;    // 안전한 상한 (필요시 조정)
        int attempts = 0;

        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                // 외부에서 인터럽트 요청 시 깔끔히 종료
                throw new InterruptedException("작업이 인터럽트되었습니다.");
            }

            boolean isRun1 = false;
            boolean isRun2 = false;

            try {
                // lock1 시도 (timeout)
                isRun1 = lock1.tryLock(TIMEOUT_MS, TimeUnit.MILLISECONDS);
                if (!isRun1) continue;
                System.out.println(Thread.currentThread().getName() + " : lock1 획득");

                // lock2 시도 (timeout)
                isRun2 = lock2.tryLock(TIMEOUT_MS, TimeUnit.MILLISECONDS);
                if (!isRun2) continue;
                System.out.println(Thread.currentThread().getName() + " : lock2 획득");

                // ====== 임계 구역 ======
                System.out.println(Thread.currentThread().getName() + " : 작업 수행 완료");
                return; // 성공적으로 종료

            } finally {
                if (isRun1) lock1.unlock();
                if (isRun2) lock2.unlock();
            }
        }
    }

    // 메인 메서드
    public static void main(String[] args) {
        TimeoutExam exam = new TimeoutExam();

        // 스레드 여러 개 실행 (의도적으로 경쟁 발생)
        Runnable task = () -> {
            try {
                exam.timeoutRun();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " : 인터럽트 발생");
            }
        };

        Thread t1 = new Thread(task, "스레드 A");
        Thread t2 = new Thread(task, "스레드 B");
        Thread t3 = new Thread(task, "스레드 C");

        t1.start();
        t2.start();
        t3.start();
    }
}