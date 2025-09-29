package week_08._0929;

// 함수형 인터페이스 애노테이션
@FunctionalInterface
interface RunFunc {
    void run();
}

@FunctionalInterface
interface PlusFunc {
    int plus(int a, int b);
}

class FuncImpl implements RunFunc {
    @Override
    public void run() {
        System.out.println("임플리 run");
    }
}

public class FuncImplTest {
    public static void main(String[] args) {
        // 1. 익명 객체 사용
        RunFunc funcTest1 = new RunFunc() {
            @Override
            public void run() {
                System.out.println("재정의 run");
            }
        };

        // 2. 클래스 구현 사용
        RunFunc funcTest2 = new FuncImpl();

        // 3. 람다식 사용
        RunFunc funcTest3 = () -> System.out.println("람다 run");

        // 4. 매개변수, 반환값 있는 람다식
        PlusFunc funcTest4 = ( a, b) -> {
            // int a, int b 생략 가능 - 타입 추론
            int result = 0;
            for (int i = a; i <= b; i++) {
                result += i;
            }
            return result;
        };

        funcTest1.run();
        funcTest2.run();
        funcTest3.run();
        int result = funcTest4.plus(1, 10);

        System.out.println("람다 run 2 결과: " + result);
    }
}