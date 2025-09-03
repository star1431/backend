package week_04._0903;

public class ExamThrows {
    public static int divide(int a, int b) throws ArithmeticException {
        return a / b;
    }

    public static void main(String[] args) {
        try {
            System.out.println(divide(10, 2)); // 정상 출력: 5
            System.out.println(divide(10, 0)); // 예외 발생
            System.out.println("이거 안나옴");
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다. 예외 메시지: " + e.getMessage());
        }

        // 캐치 이후에도 실행됨
        System.out.println("이후 실행");
    }
}
