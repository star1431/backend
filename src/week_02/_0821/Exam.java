package week_02._0821;

import java.util.Arrays;

public class Exam {

    public static void main(String[] args) {
        System.out.println("TITLE : 0821 자바 기초");
        Exam obj = new Exam();
        obj.exam00(); // 다차원 배열
        obj.exam01(); // 다차원 예제
    }

    public void exam00() {
        System.out.println("exam00 : 다차원 배열");

        int[][] arr0 = new int[][] {
                {1, 2, 3},  // arr0[0][] -> [0][0] = 1, [0][1] = 2, [0][2] = 3,
                {4, 5, 6},  // arr0[1][] -> [1][0] = 4, [1][1] = 5, [2][2] = 6,
                {7, 8}      // arr0[2][] -> [2][0] = 7, [2][1] = 8,
        };
        // Arrays.deepToString  = 다차원 배열 문자열로 출력
        // Arrays.toString      = 1차원 배열 문자열로 출력
        System.out.println("arr0 : " + Arrays.deepToString(arr0));
        // arr0 : [[1, 2, 3], [4, 5, 6], [7, 8]]

        // 2차원 가변 넣기
        int[][] arr1 = new int[2][];
        arr1[0] = new int[2];
        arr1[1] = new int[5];
        arr1[0][0] = 10;
        arr1[0][1] = 20;

        for (int i = 0; i < arr1.length; i++) {
            System.out.printf("arr1[%d] : [", i);
            for (int j = 0; j < arr1[i].length; j++) {
                if(j == (arr1[i].length - 1)) System.out.printf("%d]", arr1[i][j]);
                else System.out.printf("%d, ", arr1[i][j]);
            }
            System.out.print("\n");
        }
        /*
         * arr1[0] : [100, 200]
         * arr1[1] : [3, 6, 9, 12, 15]
         */

        System.out.println("arr1 : " + Arrays.deepToString(arr1));
        // arr1 : [[100, 200], [3, 6, 9, 12, 15]]
        
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
    }


    public void exam01() {
        System.out.println("exam01 : 다차원 예제");
        /*
         *  === 성적표 ===
            이름  국어  영어  수학  과학  총점  평균
            --------------------------------------------------
            김철수 90  85  88  92  355 88.8
            이영희 85  90  95  88  358 89.5
            박민수 78  82  85  90  335 83.8
         */

        String[] attrVal = { "국어", "영어", "수학", "과학" };
        String[] stuName = { "김철수", "이영희", "박민수" };
        int[][] scoreArr = {
                {90, 85, 88, 92},
                {85, 90, 95, 88},
                {78, 82, 85, 90}
        };

        // 헤드 및 속성 출력
        System.out.println("=== 성적표 ===");
        System.out.print("이름  \t");
        for (String val : attrVal) {
            System.out.print(val + "\t");
        }
        System.out.println("총점\t평균");
        System.out.println("-".repeat(50)); // (n)개만큼 복사

        // 데이터 행 출력
        for (int i = 0; i < stuName.length; i++) {
            System.out.print(stuName[i] + "\t");
            int sum = 0;
            double avg = 0;
            // 총합계산
            for (int j = 0; j < scoreArr[i].length; j++) {
                System.out.print(scoreArr[i][j] + "\t");
                sum += scoreArr[i][j];
            }
            // 평균계산
            avg = (double) sum / attrVal.length;
            // 마지막 출력
            System.out.printf("%d\t%.1f\n", sum, avg);
        }


        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
    }
}
