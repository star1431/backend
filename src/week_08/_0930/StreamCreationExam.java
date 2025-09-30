package week_08._0930;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamCreationExam {
    public static void main(String[] args) {
        // 1. 스트림 메서드 사용
        List<String> lists = Arrays.asList("Java", "Python", "C++", "JavaScript", "SQL");
        lists.stream()
                .filter(item -> item.toLowerCase().startsWith("j"))
                .forEach(System.out::println);
                //  Java \n JavaScript

        // 스트림은 원본배열 변경하지 않음
        System.out.println(lists); 

        // 2. 스트림 객체 사용
        Stream<String> stream = lists.stream();
        stream.forEach(item -> System.out.print(item + " "));
        System.out.println();

        // 재사용불가함
        try {
            stream.forEach(System.out::println);
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            // stream has already been operated upon or closed
        }
    }
}
