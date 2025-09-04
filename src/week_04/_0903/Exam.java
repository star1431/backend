package week_04._0903;

import java.util.Scanner;

public class Exam {
    final static Scanner sc = new Scanner(System.in);
    public static void prints(String str, String msg) {
        if (str.equals("title")) System.out.println("─".repeat(8) + msg + "─".repeat(8));
        if (str.equals("end")) System.out.println("─".repeat(20));
    }
    public static void main(String[] args) {
        exam01(); // try-catch
    }

    public static void exam01() {
        prints("title", "try-catch");
        System.out.print("입력: ");
        String test = sc.nextLine();
        try {
            int i = Integer.parseInt(test);
            System.out.println("try블럭: " + 10/i);
        } catch (ArithmeticException e) {
            System.out.println("산수오류 캐치");
            System.out.println(e);
        } catch (NumberFormatException e) {
            System.out.println("넘버포맷오류 캐치");
            System.out.println(e);
        } finally {
            System.out.println("파이널 무조건 실행됨");
        }

        prints("end", ".");
    }

}
