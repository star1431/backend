package week_08._0929.work0929_01;

// 1. 클래스 구현 Inc
public class IncrementCounter implements Runnable {
    private int min;
    private int max;
    private int count;

    public IncrementCounter(int min , int max) {
        this.min = min;
        this.max = max;
        this.count = min;
    }
    // 2. 실행
    @Override
    public void run() {
        for(int i = min; i <= max; i++){
            // 3.1. - 출력 양식
            System.out.println("Increment: " + count++);
            try {
                // 3.2. - 0 ~ 10 밀리초 무작위
                int delay = (int) (Math.random() * 10) + 1;
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}