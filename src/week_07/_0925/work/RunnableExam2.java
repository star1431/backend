package week_07._0925.work;


public class RunnableExam2 {
    public static void main(String[] args) {
        // 람다식 사용
        Runnable work = () -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("람다 작업중: " + i);
                try {
                    Thread.sleep(1000); // 1초 슬립
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        };

        // Runnable을 Thread에 전달
        Thread thread1 = new Thread(work);
        Thread thread2 = new Thread(work);

        // 스레드 시작
        thread1.start();
        thread2.start();
    }
}