package week_08._0930.work0930;

import java.util.*;
import java.util.stream.Collectors;

public class Work02 {
    static void commmonPrint(String type, String title) {
        switch (type) {
            case "start" -> System.out.println("\n" + "─".repeat(5) + "[ " + title + " ]" + "─".repeat(5));
            case "end" -> System.out.println("─".repeat(4) + "─".repeat(title.length()*2));
        }
    }

    static void work01() {
        String title = "문제 1: 문자열 리스트 정렬하기";
        commmonPrint("start", title);
        // -------
        List<String> words = Arrays.asList("apple", "banana", "kiwi", "grape", "strawberry");

        List<String> list = new ArrayList<>(words);
        Collections.sort(list, (a, b) -> a.length() - b.length());
        System.out.println(list);
        // -------
        commmonPrint("end", title);
    }

    static void work02() {
        String title = "문제 2: 최대값 찾기";
        commmonPrint("start", title);
        // -------
        int[] numbers = {23, 45, 12, 67, 34, 89, 56};

        int max = Arrays.stream(numbers).max().getAsInt();
        System.out.println("최대값: " + max);
        // -------
        commmonPrint("end", title);
    }


    static void work03() {
        String title = "문제 3: 리스트의 각 요소에 연산 적용하기";
        commmonPrint("start", title);
        // -------
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> result =
                numbers.stream()
                        .map(item -> item + 10)
                        .collect(Collectors.toList());
        System.out.println("원본리스트: " + numbers);
        System.out.println("변환리스트: " + result);
        // -------
        commmonPrint("end", title);
    }


    static void work04() {
        String title = "문제 4: 조건에 맞는 요소 찾기";
        commmonPrint("start", title);
        // -------
        List<String> words = Arrays.asList("cat", "dog", "elephant", "bird", "giraffe");

        Optional<String> find =
                words.stream()
                        .filter(word -> word.length() >= 5)
                        .findFirst();

        String result = find.orElse(null);
        System.out.println("조건에 맞는 첫 번째 단어: " + result);
        // -------
        commmonPrint("end", title);
    }

    static void work05() {
        String title = "문제 5: 요소 변환하기";
        commmonPrint("start", title);
        // -------
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5);

        List<Integer> result =
                numbers.stream()
                        .map(item -> (int) Math.pow(item, 2))
                        .collect(Collectors.toList());

        System.out.println("원본리스트: " + numbers);
        System.out.println("변환리스트: " + result);
        // -------
        commmonPrint("end", title);
    }

    static void work06() {
        String title = "문제 6: 모든 요소에 대해 조건 확인하기";
        commmonPrint("start", title);
        // -------
        List<Integer> numbers1 = Arrays.asList(2, 4, 6, 8, 10);
        List<Integer> numbers2 = Arrays.asList(2, 4, 5, 8, 10);

        boolean oddCheck1 =
                numbers1.stream()
                        .allMatch(number -> number % 2 == 0);
        boolean oddCheck2 =
                numbers2.stream()
                        .allMatch(number -> number % 2 == 0);

        System.out.println("numbers1 모두 짝수인가?  " + oddCheck1);
        System.out.println("numbers2 모두 짝수인가?  " + oddCheck2);
        // -------
        commmonPrint("end", title);
    }

    static void workBonus() {
        String title = "보너스 문제: 종합 실습";
        commmonPrint("start", title);
        // -------
        List<String> fruits = Arrays.asList("apple", "kiwi", "banana", "fig", "grape", "mango");

        List<String> result =
                fruits.stream()
                        .filter(item -> item.length() >= 4)
                        .map(item -> item.toUpperCase())
                        .sorted()
                        .collect(Collectors.toList());

        System.out.println(result);

        // -------
        commmonPrint("end", title);
    }


    public static void main(String[] args) {
        work01();
        work02();
        work03();
        work04();
        work05();
        work06();
        workBonus();
    }
}
