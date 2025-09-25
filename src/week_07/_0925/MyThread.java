package week_07._0925;

public class MyThread extends Thread {
    private String name;

    MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        // 스레드가 실행할 작업
        for (int i = 1; i <= 5; i++) {
            System.out.println(this.name + " 실행 중: " + i);
            try {
                Thread.sleep(1000); // 1초 대기
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("메인 스레드 시작");

        MyThread thread1 = new MyThread("Thread-1");
        MyThread thread2 = new MyThread("Thread-2");


        thread1.start(); // 스레드 시작
        thread2.start();

        for (int i = 1; i <= 5; i++) {
            System.out.println("main" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("메인 스레드 종료");
    }
}