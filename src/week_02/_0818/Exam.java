package week_02._0818;

public class Exam { // 클래스 선언 (파일명=클래스명)
    public static void main(String[] args) { // main 메소드 선언 (프로그램 시작점)
        System.out.println("\nTITLE : 0818 자바 기초"); // java api의 시스템 클래스, 콘솔출력
        /**
         * System.out : 콘솔
         * System.in : 키보드
         */

        // static 아닌 경우 객체 생성 후 호출임.
        Exam obj = new Exam();
        obj.exam01();
        exam02();
    }

    public void exam01() {
        int a = 10;
        int b = 2102;
        int sum = a + b;
        System.out.println("a + b = " + sum);
    }
    public static void exam02() {
        System.out.println("public static void exam02()");
    }
}

