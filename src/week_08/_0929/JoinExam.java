package week_08._0929;


// 조인 대기 확인
public class JoinExam {
    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            System.out.println("작업 시작");
            try {
                Thread.sleep(3000); // 3초 작업
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("작업 완료");
        });

        worker.start();

        System.out.println("작업자 스레드 종료 대기...");
        worker.join(); // worker 스레드가 끝날 때까지 대기
        System.out.println("모든 작업 완료!");
    }
}
