package week_08._0929;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.function.*;

public class MethodRefExam {

    private static String addNim(String name) {
        return name + "님";
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("신짱구", "김철수", "유리", "훈이", "맹구");

        // 1. 정적 메서드 참조 (static method reference)
        System.out.println("─── 정적 메서드 참조 ───");
        List<String> withHonor = names.stream()
                .map(MethodRefExam::addNim) // 람다식 (n -> addNim(n)) 과 동일
                .collect(Collectors.toList());
        withHonor.forEach(System.out::println);

        // 2. 인스턴스 메서드 참조 (instance method reference)
        System.out.println("\n─── 인스턴스 메서드 참조 ───");
        List<String> sortedByLength = names.stream()
                .sorted(Comparator.comparing(String::length)) // 스트링 길이순
                .collect(Collectors.toList());
        sortedByLength.forEach(System.out::println);

        // 3. 생성자 참조
        System.out.println("\n─── 생성자 참조 ───");
        String[] arr = names.stream().toArray(String[]::new); // 스트링배열로 새 생성자
        System.out.println(Arrays.toString(arr));

        // 4. 특정 객체의 메소드 참조
        System.out.println("\n─── 메서드 참조 ───");
        String prefix = "Name: ";
        Function<String, String> addPrefix = prefix::concat;
        // str -> prefix.concat(str) 와 동일

        names.stream()
                .map(addPrefix)
                .forEach(System.out::println);
    }
}