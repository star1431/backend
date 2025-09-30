package week_08._0930;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExam01 {
    public static void main(String[] args) {
        int[] iarr = {1,2,3,4,5,6,7,8,0};

        // 배열에서 짝수
        for(int item : iarr) {
            if(item % 2 == 0) System.out.print(item + " ");
        }
        System.out.println("\n" + "-".repeat(10));

        // 스트림 이용
        Arrays.stream(iarr)
                .filter(item -> item % 2 == 0)
                .forEach(item -> System.out.print(item + " "));
        System.out.println("\n" + "-".repeat(10));

        // ---------
        List<String> words = new ArrayList<>(
                Arrays.asList("Apple", "Banana", "Cherry", "Apple", "Banana", "Cherry", "Date")
        );

        // 글자수 5개 이상 필터 & 중복 제외 & 새로운 배열로 담기
        // java 유틸로 
        List<String> result = 
        words.stream()
            .filter(item -> item.length() >= 5)
            .distinct()     // 중복제거
            .collect(Collectors.toCollection(ArrayList::new)); // 깊은 복사
        
        // 일반 스트링 배열로
        String[] result2 = 
        words.stream()
            .filter(item -> item.length() >= 5)
            .distinct()
            .toArray(String[]::new); // 깊은 복사

        words.add("Apple5");
        System.out.println(words);
        System.out.println(result);
        System.out.println(Arrays.toString(result2));

        List<String> original = Arrays.asList("Java", "Js", "Python", "C++");
        List<String> deep = original.stream()
                .filter(item -> item.toLowerCase().startsWith("j"))
                .toList();

        // 원본 객체 수정
        original.set(1, "Js ES6+");  // 새로운 String 객체 생성됨
        System.out.println(original); // [Java, Js ES6+, Python, C++]
        System.out.println(deep);     // [Java, Js] <- 깊은복사
    }
}
