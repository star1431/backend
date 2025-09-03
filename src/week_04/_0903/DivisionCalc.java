package week_04._0903;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DivisionCalc {
    static Scanner sc = new Scanner(System.in);

    // 나눗셈을 수행하는 메소드
    public static double divide(double a, double b) throws RuntimeException {
        if (b == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return a / b;
    }

    public static void main(String[] args) {
        System.out.println("─".repeat(8) + "[ 나눗셈 예외처리 ]" + "─".repeat(8));

        double num1 = 0, num2 = 0;

        // 첫 번째 입력
        while (true) {
            try {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                num1 = sc.nextDouble();
                break; // 성공하면 루프 탈출
            } catch (InputMismatchException e) {
                System.out.println("오류: 숫자를 입력해주세요.");
            }
        }

        // 두 번째 입력
        while (true) {
            try {
                System.out.print("두 번째 숫자를 입력하세요: ");
                num2 = sc.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("오류: 숫자를 입력해주세요.");
            } catch (ArithmeticException e) {
                System.out.println("오류: " + e.getMessage());
            }
        }

        double result = divide(num1, num2);
        System.out.println("결과: " + num1 + " ÷ " + num2 + " = " + result);

        sc.close();
    }
}
