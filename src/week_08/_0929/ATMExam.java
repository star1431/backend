package week_08._0929;


class ATMSystem {
    private int balance = 0; // 잔액
    private boolean hasTrans = false; // 거래 상태

    // 시스템 - 입금 받는 메서드
    public synchronized void deposit(int amount) throws InterruptedException {
        while (hasTrans) {
            System.out.println("[시스템] 이전거래 처리중 wait...");
            wait(); // 사용자가 거래를 완료할 때까지 대기
        }

        // 입금 처리
        this.balance += amount;
        this.hasTrans = true;
        System.out.println("[시스템] " + amount + "원 입금! (잔액: " + balance + "원)");
        notify(); // 사용자에게 거래 완료 알림
    }

    // 사용자 - 거래 내역 확인 메서드
    public synchronized int checkBalance() throws InterruptedException {
        while (!hasTrans) {
            System.out.println("[사용자] 거래중 없음 wait...");
            wait(); // 시스템이 거래를 처리할 때까지 대기
        }

        // 잔액 확인
        int currentBalance = this.balance;
        this.hasTrans = false;
        System.out.println("[사용자] 잔액확인! " + currentBalance + "원 입니다.");
        notify(); // 시스템에게 다음 거래 가능하다고 알림

        return currentBalance;
    }
}

public class ATMExam {
    public static void main(String[] args) {
        ATMSystem atm = new ATMSystem();

        // 시스템 스레드 (거래 처리)
        Thread system = new Thread(() -> {
            try {
                Thread.sleep(1000);
                atm.deposit(100); 

                Thread.sleep(1000);
                atm.deposit(500);

                Thread.sleep(1000);
                atm.deposit(300);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });

        // 사용자 스레드 (잔액 확인)
        Thread user = new Thread(() -> {
            try {
                for (int i = 0; i < 3; i++) {  // 3번 반복
                    int balance = atm.checkBalance();
                    Thread.sleep(2000); // 잔액확인 지연 (처리중 확인)
                    System.out.println("-- Exam 체크! --");
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });

        system.start();
        user.start();
    }
}