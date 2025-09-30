package week_08._0930;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;

public class StreamExam02 {
    public static void main(String[] args) {
        // exam01();
        // exam02();
        exam03();
    }

    static void exam01() {
        List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 2, 7);

        // 오름차순 정렬
        numbers.stream()
                .sorted()   // 기본 오름차순 정렬
                .forEach(item -> System.out.print(item + " "));
        System.out.println();
        // 1 2 3 5 7 8

        // 내림차순 정렬
        numbers.stream()
                .sorted(Comparator.reverseOrder())  // 내림차순 정렬
                .forEach(item -> System.out.print(item + " "));
        System.out.println();
        // 8 7 5 3 2 1


        // peek() 예시
        numbers.stream()
                .filter(item -> item % 2 == 0) // 짝수 필터링
                .peek(n -> System.out.print("짝수: " + n)) // 중간 확인
                .map(item -> item * item)        // 제곱으로 변환
                .peek(n -> System.out.print(", 제곱: " + n + " | "))   // 중간 확인
                .forEach(item -> System.out.print(item + " "));
        System.out.println();
    }

    static void exam02() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // allMatch - 모든 요소가 조건 만족
        boolean check1 = numbers.stream()
                .allMatch(n -> n > 0);
        System.out.println("모두 양수? " + check1); // true

        // anyMatch - 하나라도 조건 만족
        boolean check2 = numbers.stream()
                .anyMatch(n -> n % 2 == 0);
        System.out.println("짝수 존재? " + check2); // true

        // noneMatch - 모든 요소가 조건 불만족
        boolean check3 = numbers.stream()
                .noneMatch(n -> n < 0);
        System.out.println("음수 없음? " + check3); // true
    }

    static void exam03() {

        List<Integer> numbers = Arrays.asList(5, 3, 1, 1, 1, 7);

        // Optional - null 방지
        Optional<Integer> firstEven =
                numbers.stream()
                        .filter(n -> n % 2 == 0)
                        .findFirst();

        System.out.println(firstEven);

        Optional<Integer> test = Optional.of(100);
        System.out.println(test);

        test = Optional.empty();
        System.out.println(test);
        System.out.println(test.isPresent()); // false

        test = Optional.ofNullable(100);
        System.out.println(test);
        System.out.println(test.isPresent()); // true

        test.ifPresent(value ->
                System.out.println("값: " + value)
        );

        // test.orElse()

    }

    static void exam04() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        int count =
                (int) numbers.stream()
                        .filter(item -> item > 5)
                        .count();
        System.out.println("5초과 개수: " + count); // 개수: 5

        int sum =
                numbers.stream()
                        .mapToInt(Integer::intValue) // IntStream으로 변환
                        .sum();

        System.out.println("합계: " + sum); // 합계: 10

        double avg =
                numbers.stream()
                        .mapToInt(Integer::intValue)
                        .average()
                        .orElse(0.0); // 값이 없을 때 기본값 지정

        System.out.println("평균: " + avg); // 평균: 5.5

        IntSummaryStatistics stats =
                numbers.stream()
                        .mapToInt(Integer::intValue)
                        .summaryStatistics();

        System.out.println(stats);
        // IntSummaryStatistics{count=10, sum=55, min=1, average=5.500000, max=10}
        System.out.println("최소값: "   + stats.getMin()); // 최소값: 1
        System.out.println("최대값: "   + stats.getMax()); // 최대값: 10
        System.out.println("합계: "     + stats.getSum()); // 합계: 55
        System.out.println("평균: "     + stats.getAverage()); // 평균: 5.5
        System.out.println("개수: "     + stats.getCount()); // 개수: 10

    }
}
