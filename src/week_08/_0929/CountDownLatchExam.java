package week_08._0929;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchExam {
    public static void main(String[] args) throws InterruptedException {
        final int NUM_TASKS = 3;
        CountDownLatch latch = new CountDownLatch(NUM_TASKS);
        // 고정 크기 스레드 풀 생성 (3개의 스레드)
        ExecutorService executor = Executors.newFixedThreadPool(NUM_TASKS);

        // 작업 정의
        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " 작업 시작");
                Thread.sleep((long) (Math.random() * 3000)); // 랜덤 대기
                System.out.println(Thread.currentThread().getName() + " 작업 완료");
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " 작업 중단");
            } finally {
                latch.countDown(); // 작업 완료 시 카운트 다운
            }
        };

        // 작업 제출
        for (int i = 0; i < NUM_TASKS; i++) {
            executor.submit(task);
        }

        // 모든 작업이 완료될 때까지 대기
        latch.await();
        System.out.println("모든 작업 완료!");

        // 스레드 풀 종료
        executor.shutdown();
    }
}