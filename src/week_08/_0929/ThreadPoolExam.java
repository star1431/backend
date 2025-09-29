package week_08._0929;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// 스레드 풀 예시
public class ThreadPoolExam {
    public static void main(String[] args) throws InterruptedException {
        // 고정 크기 스레드 풀 생성 (3개의 스레드)
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // 10개의 작업 제출
        for (int i = 1; i <= 3; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("작업 " + taskId + " 시작");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("작업 " + taskId + " 중단");
                }
                System.out.println("작업 " + taskId + " 완료");
            });
        }

        // 스레드 풀 종료 (새 작업 제출 불가)
        executor.shutdown();
        try {
            // 모든 작업이 끝나길 3초 기다림 (작업 2초라면 넉넉)
            if (!executor.awaitTermination(3, TimeUnit.SECONDS)) {
                // 제한 시간 안에 안 끝나면 강제 종료
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
        System.out.println("모든 작업 완료");
    }
}