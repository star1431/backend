package week_08._0929;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 최적 스레드 풀 크기 예시
public class OptimalThreadPool {
    public static void main(String[] args) {
        // CPU 집약적 작업
        // Runtime 객체를 통해 CPU 코어 수 확인
        // getRuntime() : 현재 실행중인 자바 프로그램의 런타임 객체 반환
        // availableProcessors() : 사용 가능한 프로세서 수 반환
        int coreCount = Runtime.getRuntime().availableProcessors();


        // I/O 집약적 작업
        // 작업비율에 따라 스레드 수 조정 0% ~ 100%
        double blockingPercent = 0.4; // I/O 작업 비율 40%

        // 최적 스레드 수 계산
        // CPU 코어 수 / (1 - 블로킹 계수)
        int optimalThreadCount = (int) (coreCount / (1 - blockingPercent));

        // CPU 코어 수에 맞게 스레드 풀 생성
        ExecutorService executor = Executors.newFixedThreadPool(optimalThreadCount);
        System.out.println("CPU 코어 수: " + coreCount);
        System.out.println("I/O 작업 비율: " + (blockingPercent * 100) + "%");
        System.out.println("최적 스레드 수: " + optimalThreadCount);

        // 스레드 풀 종료
        executor.shutdown();
    }
}