package week_07._0925.work;

class CustomRunnable implements Runnable {
    private final String taskName;

    CustomRunnable(String name) {
        this.taskName = name;
    }

    @Override
    public void run() {
        // 스레드가 실행할 코드
        for (int i = 1; i <= 3; i++) {
            System.out.println(this.taskName + " 작업중: " + i);
            try {
                Thread.sleep(1000); // 1초 슬립
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

public class RunnableExam {
    public static void main(String[] args) {
        // Runnable 구현 객체
        CustomRunnable work1 = new CustomRunnable("work1");
        CustomRunnable work2 = new CustomRunnable("work2");

        // Runnable을 Thread에 전달
        Thread thread1 = new Thread(work1);
        Thread thread2 = new Thread(work2);

        // 스레드 시작
        thread1.start();
        thread2.start();
    }
}