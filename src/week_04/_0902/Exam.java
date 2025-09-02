package week_04._0902;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exam {
    public static void main(String[] args) {

        // 인티저 ------------------------------
        System.out.println("title: 정수형 확인");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            list.add(i);
        }

        Collections.shuffle(list); // 랜덤섞기
        System.out.println(list); // [8,1,3 ...]

        Collections.sort(list); // 오름차순
        System.out.println(list); // [0,1..,10]


        Collections.sort(list, Collections.reverseOrder()); // 내림차순
        System.out.println(list); // [10,9..,1]

        Collections.reverse(list); // 뒤집기
        System.out.println(list); // [0,1..,10]

        System.out.println("─".repeat(30));

        // 스트링 ------------------------------
        System.out.println("title: 스트링 확인");
        List<String> listStr = new ArrayList<>();
        listStr.add("가나");
        listStr.add("마바");
        listStr.add("다라");

        Collections.sort(listStr);
        System.out.println(listStr); // [가나, 다라, 마바]

        System.out.println("─".repeat(30));
    }
}
