package week_02._0819;
// import java.util.*;

/**
 * @author 정병천
 * @since  2025-08-19
 */
public class Exam {
    public static void main(String[] args) { 
        System.out.println("TITLE : 0819 자바 기초"); 
        Exam obj = new Exam();
        obj.exam01(); // 진수 표기
        obj.exam02(); // 불리언 확인
        obj.exam03(); // 형변환 확인
        obj.exam04(); // 이스케이프 확인
        obj.exam05(); // 문자열 합치기 확인
        obj.exam06(); // 타입 변환 확인
        obj.exam07(); // 프린트f 서식지정
        obj.exam08(); // 조건문 if, 삼항연산
        obj.exam09(); // 조건문 swich
    }

    public void exam01() { 
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
        System.out.println("exam01 : 진수 표기");
        int format_2    = 0b101010;   // 2진수
        int format_8    = 052;        // 8진수
        int format_16   = 0x2A;       // 16진수

        System.out.println(format_2 + ", " + format_8 + ", " + format_16);
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
    }

    public void exam02() { 
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
        System.out.println("exam02 : 불리언 확인");
        boolean result0 = true;
        boolean result1 = (5 > 2);
        int num1 = 10;
        int num2 = 20;
        boolean result2 = num1 > num2;

        System.out.println(result0 + ", " + result1 + ", " + result2);
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
    }

    public void exam03() { 
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
        System.out.println("exam03 : 형변환 확인");
        int     a1 = 10;
        double  b1 = a1;        // 자동 형변환

        double  a2 = 3.14;
        int     b2 = (int)a2;   // 강제 형변환, 소수점 이하 버림

        char    a3 = 'A';
        int     b3 = (int)a3;   // = 65; 유니코드값으로 변환
        char    c3 = (char)65;  // = 'A'; 문자로 변환

        System.out.println(b1 + ", " + b2 + ", " + b3 + ", " + c3);
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
    }

    public void exam04() { 
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
        System.out.println("exam04 : 이스케이프 확인");

        // 줄바꿈
        System.out.println("첫 번째 줄\n두 번째 줄");
        System.out.println();

        // 탭
        System.out.println("이름\t나이\t성별");
        System.out.println("라이언\t99\t남");
        System.out.println();

        // 따옴표
        System.out.println("꿈꾸는라이언 : \"안녕하세요!\"");
        System.out.println("char a = \'A\';");
        System.out.println();

        // 백슬래시
        System.out.println("path : C:\\Users\\Documents");

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
    }

    public void exam05() {
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
        System.out.println("exam05 : 문자열 합치기 확인");

        int num = 20;
        String strDt = "name";
        String innerText1 = strDt + ": 라이언" + num + 25;     // name: 라이언2025
        String innerText2 = strDt + ": 라이언" + (num + 25);   // name: 라이언45
        String innerText3 = strDt.concat(": 라이언");      // name: 라이언

        System.out.println(innerText1 + "\n" + innerText2 + "\n" + innerText3);
        System.out.println(strDt);
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
    }

    public void exam06() {
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
        System.out.println("exam06 : 타입 변환 확인");
        byte _byte = 10;
        int _int;
        byte _byte2;

        _int = _byte; // 명시적 변환 (자동변환)  4byte << 1byte
        // _byte2 = _int (불가)  1byte << 4byte
        _byte2 = (byte)_int;
        System.out.println(_int + ", " + _byte2);

        int a = 131, b = 22;

        double calc = (double)a/b;
        double calc2 = (double)(a/b);

        System.out.println("double calc = (double)a/b\n" + calc + ", // 타입먼저 전환 후 계산됨 (5.95...)");
        System.out.println("double calc2 = (double)(a/b)\n" + calc2 + ", // 인트끼리 먼저 계산 후 타입변환됨 (5)");

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
    }

    public void exam07() {
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
        System.out.println("exam07 : 프린트f 서식지정");

        String name = "라이언";
        int age = 99;
        double myKey = 199.9d;

        System.out.printf("이름: %s, 나이: %d, 키 : %.2f \n", name, age, myKey);

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
    }
    
    public void exam08() {
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
        System.out.println("exam08 : 조건문 if, 삼항연산");

        int score = 95;

        System.out.printf("점수 : %d", score);
        // 기본 (if-else)
        if(score >= 60) {
            System.out.print(", 합격\n");
        } else {
            System.out.print(", 불합격\n");
        }

        // 삼항 연산
        // (a < b) ? true : false
        System.out.printf((score >= 60) ? "점수 : %d, 합격%n" : "점수 : %d, 불합격%n", score);

        // 추가조건 (else-if)
        char grade;
        if(score >= 90) grade = 'A';
        else if(score >= 80) grade = 'B';
        else if(score >= 70) grade = 'C';
        else if(score >= 60) grade = 'D';
        else if(score >= 50) grade = 'E';
        else grade = 'F';

        System.out.printf("등급 : %c%n", grade);

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
    }    
    
    public void exam09() {
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
        System.out.println("exam08 : 조건문 swich");

        int month = (int)(Math.random()*12) + 1;
        
        System.out.printf("랜덤선택 %d월, ", month);
        switch (month) {
            case 12:
            case 1:
            case 2:
                System.err.println("겨울");
                break;
            case 3:
            case 4:
            case 5:
                System.err.println("봄");
                break;
            case 6:
            case 7:
            case 8:
                System.err.println("여름");
                break;
            case 9:
            case 10:
            case 11:
                System.err.println("가을");
                break;
            default:
                break;
        }
        
        int score = 1;

        switch (score) {
            case 1:
                System.out.print("A");
                // break 없음!
            case 2:
                System.out.print("B");
                // break 없음!
            case 3:
                System.out.print("C");
                // break 없음!
            case 4:
                System.out.print("D");
                // break 없음!
            default:
                System.out.print("F");
        }
        

        System.out.println("\nㅡㅡㅡㅡㅡㅡㅡ");
    }
}

