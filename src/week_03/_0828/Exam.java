package week_03._0828;
import java.util.Arrays;
import java.util.Scanner;

public class Exam {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("TITLE : 0828 자바 기초");
        Exam obj = new Exam();
        // obj.exam00(); // 스캐너 테스트
        obj.exam01(); // 시스템 유틸
        obj.exam02(); // 래퍼 클래스
    }

    public void exam00() {
        System.out.println("exam00 : 스캐너 테스트");
        // 표준 출력
        System.out.println("일반 메시지");
        System.err.println("에러 메시지"); // 빨간색으로 출력

        System.out.print("이름을 입력하세요: ");
        String name = sc.nextLine();
        System.out.println("안녕하세요, " + name + "님!");
        sc.close();
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
    }

    public void exam01() {
        System.out.println("exam01 : 시스템 유틸");
        // 현재 시간 (밀리초)
        long currentMillis = System.currentTimeMillis();
        System.out.println("현재 시간(밀리초): " + currentMillis);

        // 나노초 (더 정밀한 시간 측정)
        long nanoTime = System.nanoTime();
        System.out.println("나노시간: " + nanoTime);

        // 시간 측정 예제
        long start = System.currentTimeMillis();
        // 시간이 걸리는 작업
        for(int i = 0; i < 1000000; i++) {
            Math.sqrt(i);
        }
        long end = System.currentTimeMillis();
        System.out.println("실행 시간: " + (start - end) + "ms");

        // 시스템 프로퍼티
        System.out.println("Java 버전: " + System.getProperty("java.version"));
        System.out.println("OS: " + System.getProperty("os.name"));
        System.out.println("사용자 홈: " + System.getProperty("user.home"));
        System.out.println("현재 디렉토리: " + System.getProperty("user.dir"));

        // 환경 변수
        String path = System.getenv("PATH");
        System.out.println("PATH: " + path);

        // 배열 복사 (native 메소드로 빠름)
        int[] src = {1, 2, 3, 4, 5};
        int[] dest = new int[5];
        /*
        *  System.arraycopy(원본 배열, 원본시작idx, 대상 배열, 대상배열시작idx, 총갯수);
        *  다른방식 : .clone() , Arrays.copyOf() 있음.
        */
        System.arraycopy(src, 0, dest, 0, src.length);
        System.out.println("복사된 배열: " + Arrays.toString(dest));

        // int[] _copy1 = src.clone();
        // int[] _copy2 = Arrays.copyOf(src, src.length);

        // 가비지 컬렉션 제안 (강제 실행 아님)
        System.gc();

        // 프로그램 종료
        // System.exit(0); // 정상 종료
        // System.exit(1); // 비정상 종료
    }

    public void exam02() {
        System.out.println("exam02 : 래퍼 클래스");
        // 1. byte → Byte
        byte _b = 10;
        Byte byteObj = _b;  // 오토 박싱

        // 2. short → Short
        short _s = 20;
        Short shortObj = _s;

        // 3. int → Integer
        int _i = 100;
        Integer intObj = _i;

        // 4. long → Long
        long _l = 100_000;
        Long longObj = _l;

        // 5. float → Float
        float _f = 3.14f;
        Float floatObj = _f;

        // 6. double → Double
        double _d = 3.141592;
        Double doubleObj = _d;

        // 7. char → Character
        char _c = 'A';
        Character charObj = _c;

        // 8. boolean → Boolean
        boolean _bool = true;
        Boolean boolObj = _bool;

        // 언박싱 예시
        int i2 = 10;
        Integer intObj2 = i2;
        int num = intObj2; //  Integer → int 언박싱

        // 문자열 변환 예시
        String str1 = "123";
        String str2 = "true";
        int parseInt = Integer.parseInt(str1);
        String parseStr = Integer.toString(parseInt);

        boolean parseBol =  Boolean.parseBoolean(str2);

        // 진법 변환
        System.out.println(Integer.toBinaryString(10));  // "1010"
        System.out.println(Integer.toOctalString(10));   // "12"
        System.out.println(Integer.toHexString(10));     // "a"

        // 다른 진법 파싱
        int binary = Integer.parseInt("1010", 2);  // 10
        int octal = Integer.parseInt("12", 8);     // 10
        int hex = Integer.parseInt("A", 16);       // 10

        // 유용한 상수
        System.out.println("int 최대값: " + Integer.MAX_VALUE); // int 최대값: 2147483647
        System.out.println("int 최소값: " + Integer.MIN_VALUE); // int 최소값: -2147483648
        System.out.println("int 크기: " + Integer.SIZE + "비트"); // int 크기: 32비트

        // 비교
        Integer a = 127;
        Integer b = 127;
        Integer c = 128;
        Integer d = 128;

        System.out.println(a == b);     // true (-128~127은 캐싱)
        System.out.println(c == d);     // false (캐싱 범위 초과)
        System.out.println(c.equals(d)); // true (값 비교)
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
    }


}
