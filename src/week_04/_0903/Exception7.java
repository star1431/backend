package week_04._0903;
class testExc extends RuntimeException {
    public testExc(String msg) {
        super(msg);
    }

    public testExc(Exception ex) {
        super(ex);
    }
}

public class Exception7 {
    public static void main(String[] args) {
        try {
            ExceptionObj7 exobj = new ExceptionObj7();
            int value = exobj.divide(10, 0);
            System.out.println(value);
        } catch(testExc ex) {
            System.out.println("사용자 정의 Exception이 발생했네요.");
            System.out.println("오류 메시지: " + ex.getMessage());
        }
    }
}

class ExceptionObj7 {
    public int divide(int i, int k) throws testExc {
        int value = 0;
        try {
            value = i / k;
        } catch(ArithmeticException ae) {
            throw new testExc("0으로 나눌 수 없습니다.");
        }
        return value;
    }
}