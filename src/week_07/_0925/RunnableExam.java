package week_07._0925;

public class RunnableExam {
    public static void main(String[] args) {

        // Runnable 객체 생성
        Runnable workA = new MyRunnable("작업A");
        Runnable workB = new MyRunnable("작업B");

        // Thread 객체에 전달
        Thread thread1 = new Thread(workA);
        Thread thread2 = new Thread(workB);

        thread1.start();
        thread2.start();
    }
}
