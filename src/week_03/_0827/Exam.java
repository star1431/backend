package week_03._0827;

import java.util.Arrays;

public class Exam {
    String name;
    public static void main(String[] args) {
        System.out.println("TITLE : 0827 자바 기초");
        Exam obj = new Exam();
        obj.exam00(); // 스트링 비교
        obj.exam01(); // 스트링 메서드
        obj.exam02(); // 메스 메서드
    }

    public void exam00() {
        System.out.println("exam00 : 스트링 비교 ");
        String str1 = "Hello";
        String str2 = "Hello";
        String str3 = new String("Hello");

        System.out.println(str1 == str2);      // true (String Pool)
        System.out.println(str1 == str3);      // false (다른 객체)
        System.out.println(str1.equals(str3)); // true (내용 비교)

        // 문자열 수정 시 새 객체 생성
        String str4 = str1.concat(" World");
        System.out.println(str1); // "Hello" (변경되지 않음)
        System.out.println(str1); // "HelloHello"
        System.out.println(str4); // "Hello World"
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
    }

    public void exam01() {
        System.out.println("exam01 : 스트링 메서드 ");
        
        String str = " Hello Java ";
        System.out.println(str.length());                 // 11
        System.out.println(str.charAt(2));                // e      -> 인덱스 0=' ', 1='H', 2='e'
        System.out.println(str.substring(1, 6));          // Hello  -> 인덱스 1~5 까지
        System.out.println(str.indexOf("Java"));          // 7
        System.out.println(str.contains("Java"));         // true
        System.out.println(str.startsWith(" He"));        // true
        System.out.println(str.endsWith("va "));          // true
        System.out.println(str.toLowerCase());            // " hello java "
        System.out.println(str.toUpperCase());            // " HELLO JAVA "
        System.out.println(str.replace("Java", "World")); // " Hello World "
        System.out.println(str.trim());                   // "Hello Java"

        String colors = "red,green,blue";
        String[] arr = colors.split(",");
        System.out.println(Arrays.toString(arr));         // [red, green, blue]
        System.out.println(String.join("-", arr));        // red-green-blue
        System.out.println(String.format("이름: %s, 나이: %d", "홍길동", 20)); 
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
    }

    public void exam02() {
        System.out.println("exam02 : 메스 메서드 ");

        // 기본 연산
        System.out.println("절대값: " + Math.abs(-10));        // 10
        System.out.println("최대값: " + Math.max(10, 20));     // 20
        System.out.println("최소값: " + Math.min(10, 20));     // 10

        // 제곱과 제곱근
        System.out.println("2의 3제곱: " + Math.pow(2, 3));    // 8.0
        System.out.println("16의 제곱근: " + Math.sqrt(16));   // 4.0
        System.out.println("27의 세제곱근: " + Math.cbrt(27)); // 3.0

        // 반올림, 올림, 내림
        double num = 3.7;
        System.out.println("반올림: " + Math.round(num));      // 4
        System.out.println("올림: " + Math.ceil(num));         // 4.0
        System.out.println("내림: " + Math.floor(num));        // 3.0

        // 삼각함수
        double angle = Math.PI / 4; // 45도
        System.out.printf("sin(45°): %.5f%n", Math.sin(angle)); // 0.70711
        System.out.printf("cos(45°): %.5f%n", Math.cos(angle)); // 0.70711
        System.out.printf("tan(45°): %.5f%n", Math.tan(angle)); // 1.00000

        // 로그
        System.out.println("자연로그: " + Math.log(Math.E));   // 1.0
        System.out.println("상용로그: " + Math.log10(100));    // 2.0

        // 난수 생성
        System.out.printf("0~1 난수: %.5f%n", Math.random()); // 0.0 ~ 0.99...

        // 1~100 사이의 정수 난수
        int randomInt = (int)(Math.random() * 100) + 1;
        System.out.println("1~100 난수: " + randomInt); // 1 ~ 100 사이

        // 상수
        System.out.printf("원주율: %.3f%n", Math.PI); // 3.141
        System.out.printf("자연상수: %.3f%n", Math.E); // 2.718
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
    }
    

}
