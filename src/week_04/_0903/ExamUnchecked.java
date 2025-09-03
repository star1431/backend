package week_04._0903;

class MyException extends RuntimeException {
    public MyException(String msg) {
        super(msg);
    }
    public MyException(Exception e) {
        super(e);
    }
}

public class ExamUnchecked {
    public static void checkNumber(int n) {
        if (n < 1 || n > 100) {
            throw new MyException("범위를 벗어난 값: " + n);
        }
        System.out.println("정상 입력: " + n);
    }

    public static void main(String[] args) {
        checkNumber(150); // try-catch 안 해도 컴파일 OK
        System.out.println("이 코드는 실행되지 않음");
    }
}