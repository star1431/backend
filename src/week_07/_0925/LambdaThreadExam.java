package week_07._0925;

public class LambdaThreadExam {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.println("람다스레드확인: " + i);
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
        });

        thread1.start();
    }
}
