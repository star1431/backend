package week_04._0903;
class UnCheckExc extends RuntimeException {
    public UnCheckExc(String msg) {
        super(msg);
    }
}
class CheckExc extends Exception {
    public CheckExc(String msg) {
        super(msg);
    }
}

public class InnerExc {
    // Unchecked Exception
    public static void unCheckNum(int n) {
        if (n < 1 || n > 100) {
            throw new UnCheckExc("범위를 벗어난 값: " + n);
        }
        System.out.println("정상 입력: " + n);
    }
    // Checked Exception
    public static void checkNum(int n) throws MyException {
        if (n < 1 || n > 100) {
            throw new MyException("범위를 벗어난 값: " + n);
        }
        System.out.println("정상 입력: " + n);
    }

    public static void main(String[] args) {
        try {
            checkNum(-1); // 예외 발생
        } catch (MyException e) {
            System.out.println("[Checked Exception 예외 잡힘] " + e.getMessage());
        }
        unCheckNum(150); // try-catch 안 해도 컴파일됨.
        System.out.println("이 코드는 실행되지 않음");
    }
}
