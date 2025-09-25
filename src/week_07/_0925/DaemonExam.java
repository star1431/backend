package week_07._0925;

class TaskThread extends Thread {
    public void run() {
        System.out.println("작업시작");
        try{
            sleep(2000); // 2초 작업
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("TaskThread 작업 완료"); // 추가하면 더 명확
    }
}

class DaemonThread extends Thread {
    public void run() {
        while(true){
            System.out.println("일하는중...");
            try{
                sleep(1000); // 1초마다 출력
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class DaemonExam {
    public static void main(String[] args) {
        TaskThread task1 = new TaskThread();
        task1.start();

        DaemonThread deTh = new DaemonThread();
        deTh.setDaemon(true); // 데몬스레드로 설정
        deTh.start();

        try{
            task1.join(); // TaskThread가 끝날 때까지 대기
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }

        System.out.println("작업완료");
        // 여기서 main 스레드 종료 → 데몬스레드도 자동 종료
    }
}