package week_04._0903;

import java.util.Scanner;

public class ExamOrder {
    final static Scanner sc = new Scanner(System.in);

    public static void order01() {
        int price = 0;
        long maxMoney = 100_000;
        System.out.printf("보유현금액: %,d원%n", maxMoney);
        while (true) {
            System.out.print("금액입력: ");
            try {
                price = Integer.parseInt(sc.nextLine());
                if (price <= 0) {
                    System.out.println("0원이하 안됨");
                    continue; // 다시 입력
                }
                if (price > maxMoney) {
                    System.out.println("보유현금보다 높음");
                    continue; // 다시 입력
                }
                // 정상 입력이면 break
                System.out.println("통과! / 가격: " + price + "원");
                break;
            } catch (NumberFormatException e) { // 넘버포맷
                System.out.println("[NumberFormat!] 숫자로 입력해야 합니다.");
            }
        }
    }
    public static void main(String[] args) {
        order01();
    }
}
