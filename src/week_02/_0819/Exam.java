package week_02._0819;

/**
 * @author 정병천
 * @since  2025-08-19
 */
public class Exam {
    public static void main(String[] args) { 
        System.out.println("TITLE : 0819 자바 기초"); 
        Exam obj = new Exam();
        obj.exam01();
        obj.exam02();
        obj.exam03();
        obj.exam04();
        obj.exam05();
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
        System.out.println("exam04 : 문자열 합치기 확인");

        int num = 20;
        String strDt = "name";
        String innerText1 = strDt + ": 라이언" + num + 25;     // name: 라이언2025
        String innerText2 = strDt + ": 라이언" + (num + 25);   // name: 라이언45
        String innerText3 = strDt.concat(": 라이언");      // name: 라이언

        System.out.println(innerText1 + "\n" + innerText2 + "\n" + innerText3);
        System.out.println(strDt);
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
    }
}

