package week_02._0820;
/**
 * @author 정병천
 * @since  2025-08-19
 */
public class Exam {
    public static void main(String[] args) {
        System.out.println("TITLE : 0820 자바 기초");
        Exam obj = new Exam();
        obj.exam00(); // 변환 연습
        obj.exam01(); // while문
        obj.exam02(); // while문 사용 / 1~100 합
        obj.exam03(); // for문 사용 / 1~100 짝수 합
        obj.exam04(); // 구구단 출력
    }

    public void exam00() {
        System.out.println("exam00 : 변환 연습");
        String stVal = "1234";

        // String -> int
        int num = Integer.parseInt(stVal);
        // String -> double
        double dd = Double.parseDouble(stVal);
        // int -> String
        String str = Integer.toString(num);

        System.out.printf("%d, %s, %.1f \n", num, str, dd);
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
    }

    public void exam01() {
        System.out.println("exam01 : while문");
        
        // 기본형
        int i = 0;
        while (i < 10) { // 0 ~ 9
            if(i % 2 == 0) {
                System.out.printf("i:%d ", i);
            }
            i++;
        }
        System.out.println();
        
        // 브레이크
        int j = 0;
        while(true) {
            if(j == 10) break; // 0 ~ 9
            System.out.printf("j:%d ", j);
            j++;
        }
        System.out.println();
        
        // 컨티뉴
        int k = 0;
        while(k++ < 10) { // 1 ~ 10
            if(k == 5) continue; // 5빼고 출력
            System.out.printf("k:%d ", k);
        }
        System.out.println();
        
        // do-while
        int l = 0;
        do {
            System.out.printf("l:%d ", l);
            l++;
        } while (l < 10); // 0 ~ 9
        System.out.println();

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
    }
    
    public void exam02() {
        System.out.println("exam02 : while문 사용 / 1~100 합");
        
        int sum = 0, min = 1, max = 100;
        int i = min;
        while (i <= max) {
            sum += i;
            i++;
        }
        System.out.printf("합산 : %d%n", sum);

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
    }

    public void exam03() {
        System.out.println("exam03 : for문 사용 / 1~100 짝수 합");

        int sum = 0, min = 1, max = 100;
        for(int i = min; i <= max; i++) {
            if(i % 2 == 0) sum += i;
        }
        System.out.printf("짝수 합산 : %d%n", sum);

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
    }

    public void exam04() {
        System.out.println("exam04 : 구구단");

        for(int i = 0; i < 10; i++) {  // 열
            for(int j = 2; j < 10; j++) { // 행
                if(i == 0) System.out.printf("%d단 \t", j);
                else System.out.printf("%dx%d=%d \t", j, i, (j*i));
            }
            System.out.println();
        }
    }
}
