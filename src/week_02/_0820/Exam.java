package week_02._0820;
import java.util.Arrays;
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
        obj.exam05(); // 다이아몬드 만들기
        obj.exam06(); // 반복문 label
        obj.exam07(); // 배열 선언 방식
        obj.exam08(); // 예제 풀이
        obj.exam09(); // 배열 - 깊은 복사
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

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
    }

    public void exam05() {
        System.out.println("exam05 : 다이아몬드 만들기");

        int floor = 8;

        // 정피마리드
        for(int i = 1; i <= floor; i++) {
            // 앞공백
            for(int j = 1; j <= (floor - i); j++) {
                System.out.print(" ");
            }
            // 별표
            for(int j = 0; j < (i*2) - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 역피마리드
        for(int i = (floor - 1); i <= floor; i--) {
            if(i < 0) break;
            // 앞공백
            for(int j = 1; j <= (floor - i); j++) {
                System.out.print(" ");
            }
            // 별표
            for(int j = 0; j < (i*2) - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
    }
    
    public void exam06() {
        System.out.println("exam06 : 반복문 label");
        outter:
            for(int i = 0; i < 3; i++) {
                System.out.printf("i: %d = |", i);
                for(int j = 0; j < 10; j++) {
                    if(i == 2 && j == 5) break outter; // 바깥쪽 반복문까지 종료
                    System.out.printf(" j:%d |", j);
                }
                System.out.println();
            }
            System.out.println();

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
    }
    
    public void exam07() {
        System.out.println("exam07 : 배열선언");

        int[] intArr = new int[5]; // 선언시 intArr: [0, 0, 0, 0, 0]
        int[] intArr2 = {0, 0, 0};
        String[] strArr = new String[5];


        intArr[(intArr.length - 1)] = 10; // 인덱스 선택삽입 intArr: [0, 0, 0, 0, 10]

        for(int i = 0; i < intArr.length; i++) {
            intArr[i] = (i + 1) * 2; // intArr: [2, 4, 6, 8, 10]
        }

        strArr[2] = "안녕?";
        for(String str : strArr) { // 향상된 for문 - 인덱스사용불가/ 읽기전용 (수정불가)
            System.out.printf("%s ", str);
        }

        System.out.println(); // 중단점 디버깅

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
    }

    public void exam08() {
        System.out.println("exam08 : 배열 예제풀기");

        int[] scores = {95, 87, 66, 73, 82};

        // 1. 배열 요소 출력
        for(int val : scores) {
            System.out.printf("%d ", val);
        }
        System.out.print("\n");

        // 2. 총점, 평균 구하기 | 3. 최대값 구하기
        int sum = 0, maxNum = 0;
        double avg = 0;
        for(int i = 0; i < scores.length; i++) {
            sum += scores[i];
            if(scores[i] > maxNum) maxNum = scores[i];
        }
        avg = (double) sum / scores.length;
        System.out.printf("합계: %d%n평균: %.1f%n최대값: %d%n", sum, avg, maxNum);

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
    }

    public void exam09() {
        System.out.println("exam09 : 배열 - 깊은 복사");

        int[] orgArr = {100, 200, 300, 400, 500};

        // System.arraycopy() 사용
        int[] copyArr1 = new int[orgArr.length];
        // System.arraycopy(원본배열, 원본인덱스start, 복사배열, 복사인덱스start, 복사할갯수);
        System.arraycopy(orgArr, 0, copyArr1, 0, orgArr.length);

        // 3Arrays.copyOf() 사용
        int[] copyArr2 = Arrays.copyOf(orgArr, orgArr.length); // 복사대상, 배열생성갯수

        // Arrays.copyOfRange() 사용 (범위 복사)
        int[] copyArr3 = Arrays.copyOfRange(orgArr, 1, 4); // 인덱스 1 ~ 3

        copyArr1[0] = 1;
        copyArr2[0] = -1;
        copyArr3[0] = -2;

        System.out.println("orgArr: " + Arrays.toString(orgArr));
        System.out.println("copyArr1: " + Arrays.toString(copyArr1));
        System.out.println("copyArr2: " + Arrays.toString(copyArr2));
        System.out.println("copyArr3: " + Arrays.toString(copyArr3));

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
    }
}
