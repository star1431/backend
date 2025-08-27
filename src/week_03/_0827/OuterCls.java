package week_03._0827;

public class OuterCls {
    private String message = "필드(1)";
    private static String message2 = "스태틱필드(2)";

    // 1. 일반 내부
    public class Inner {
        public void show() {
            System.out.println("이너 Class - 외부 필드: " + message);  // 논필드 접근가능
        }
    }

    // 2. 정적 - 스태틱
    public static class InnerStatic {
        public void show() {
            // System.out.println("스태틱클래스 - 외부 필드:" + message); // 논필드 접근불가
            System.out.println("스태틱 Class - 외부 스태틱필드: " + message2);
        }
    }

    // 3. 메서드 내부
    public void method1() {
        int a = 1;          // 묵시적 final
        final int b = 2;    // 명시적 final
        class Local { // public 안됨
            public void show() {
                System.out.println("메서드내부 class - 외부 필드: " + message);
                System.out.println("메서드내부 class - 외부 스태틱필드: " + message2);
                System.out.println("메서드내부 class - 메서드 지역변수(묵시적_final): " + a);
                System.out.println("메서드내부 class - 메서드 지역변수(명시적_final): " + b);
            }
        }

        Local local = new Local();
        local.show();
    }
    // 4. 익명 내부
    public void method2() {
        int a = 2;          // 묵시적 final
        final int b = 3;    // 명시적 final
        
        // 인터페이스를 구현하는 익명 클래스
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("익명 클래스 실행------");
                System.out.println("메서드내부 익명 - 외부 필드: " + message);
                System.out.println("메서드내부 익명 - 외부 스태틱필드: " + message2);
                System.out.println("메서드내부 익명 - 메서드 지역변수(묵시적_final): " + a);
                System.out.println("메서드내부 익명 - 메서드 지역변수(명시적_final): " + b);
            }
            /*
             * @FunctionalInterface
                public interface Runnable {
                    void run();   // 추상 메서드 딱 하나
                }
             */
        };
        runnable.run();

        // Java 8+ 람다 표현식으로 실행 방법
        Runnable lambdaRun = () ->  {
            System.out.println("람다 실행");
        };
        lambdaRun.run();
    }


    public static void main(String[] args) {
        OuterCls outer = new OuterCls();

        // 1. 인스턴스 내부 클래스 사용
        OuterCls.Inner cls1 = outer.new Inner();
        cls1.show();

        // 2. 정적 내부 클래스 사용
        OuterCls.InnerStatic cls2 = new OuterCls.InnerStatic();
        cls2.show();

        // 3. 메서드 내부 클래스 사용
        outer.method1();

        // 4. 익명 내부 클래스 사용
        outer.method2();
    }
}
