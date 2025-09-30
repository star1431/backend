package week_08._0930.work0930;

import java.util.*;
import java.util.stream.Collectors;

public class Work01 {
    static void commmonPrint(String type, String title) {
        switch (type) {
            case "start" -> System.out.println("\n" + "─".repeat(5) + "[ " + title + " ]" + "─".repeat(5));
            case "end" -> System.out.println("─".repeat(4) + "─".repeat(title.length()*2));
        }
    }

    static void work01() {
        String title = "실습문제 1: 숫자 배열 처리";
        commmonPrint("start", title);
        // -------
        int[] numbers = {3, 10, 4, 17, 6};

        int sum = Arrays.stream(numbers).filter(item -> item % 2 == 0).sum();
        System.out.println(sum);
        // -------
        commmonPrint("end", title);
    }

    static void work02() {
        String title = "실습 문제 2: 문자열 리스트 필터링";
        commmonPrint("start", title);
        // -------
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");

        List<String> result =
                words.stream()
                        .filter(item -> item.length() >= 5)
                        .map(item -> item.toLowerCase())
                        .collect(Collectors.toList());
        System.out.println(result);
        // -------
        commmonPrint("end", title);
    }

    static void work03() {
        String title = "실습 문제 3: 학생 성적 처리";
        commmonPrint("start", title);
        // -------
        List<Student> students = Arrays.asList(
                new Student("Alice", 82),
                new Student("Bob", 90),
                new Student("Charlie", 72),
                new Student("David", 76)
        );

        List<String> result = students.stream()
                .filter(student -> student.getScore() >= 80)
                .map(item -> item.getName())
                .sorted()
                .collect(Collectors.toList());
        System.out.println(result);
        // -------
        commmonPrint("end", title);
    }

    static void work04() {
        String title = "실습 문제 4: 직원 관리";
        commmonPrint("start", title);
        // -------
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 3000),
                new Employee("Bob", "HR", 2000),
                new Employee("Charlie", "Engineering", 5000),
                new Employee("David", "Engineering", 4000)
        );

        Map<String, Double> mapping =
                employees.stream()
                        // 부서 내림차순 정렬
                        .sorted(Comparator.comparing(item -> item.getDepartment(), Comparator.reverseOrder()))
                        .collect(Collectors.groupingBy(
                                item -> item.getDepartment(),
                                LinkedHashMap::new, // 링크드해시 객체로 설정. 삽입순서 유지
                                Collectors.averagingDouble(item -> item.getSalary())
                        ));

        for(Map.Entry<String, Double> entry : mapping.entrySet()) {
            String key =  entry.getKey();
            double value = entry.getValue();
            System.out.printf("%s: %.1f%n", key, value);
        }
        // -------
        commmonPrint("end", title);
    }

    static void work05() {
        String title = "실습 문제 5: 제품 카테고리별 평균 가격 계산";
        commmonPrint("start", title);
        // -------
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200.00),
                new Product("Smartphone", "Electronics", 700.00),
                new Product("Desk", "Furniture", 300.00),
                new Product("Chair", "Furniture", 150.00)
        );

        Map<String, Double> mapping =
                products.stream()
                        .collect(Collectors.groupingBy(
                                item -> item.getCategory(),
                                Collectors.averagingDouble(item -> item.getPrice())
                        ));

        for(Map.Entry<String, Double> entry : mapping.entrySet()) {
            String key =  entry.getKey();
            double value = entry.getValue();
            System.out.printf("%s: %.1f%n", key, value);
        }
        // -------
        commmonPrint("end", title);
    }

    static void work06() {
        String title = "실습 문제 6: 나이대별 평균 점수 계산";
        commmonPrint("start", title);
        // -------
        List<Student2> students = Arrays.asList(
                new Student2("Alice", 14, 88),
                new Student2("Bob", 23, 82),
                new Student2("Charlie", 17, 95),
                new Student2("David", 21, 73)
        );
        Map<String, Double> mapping =
                students.stream()
                        .collect(Collectors.groupingBy(
                                item -> (item.getAge()/10) * 10 + "s",
                                Collectors.averagingDouble(item -> item.getScore())
                        ));

        for(Map.Entry<String, Double> entry : mapping.entrySet()) {
            String key =  entry.getKey();
            double value = entry.getValue();
            System.out.printf("%s: %.1f%n", key, value);
        }
        // -------
        commmonPrint("end", title);
    }

    static void work07() {
        String title = "실습 문제 7: 도시별 최고 온도 기록";
        commmonPrint("start", title);
        // -------
        List<Temperature> temperatures = Arrays.asList(
                new Temperature("Seoul", 33),
                new Temperature("New York", 30),
                new Temperature("Seoul", 34),
                new Temperature("New York", 28)
        );
        Map<String, Integer> mapping =
            temperatures.stream()
                        .collect(Collectors.toMap(
                                Temperature::getCity,
                                Temperature::getMaxTemp,
                                Integer::max,  // 같은 키가 있으면 더 큰 값 선택
                                LinkedHashMap::new // 삽입 순서 유지
                        ));

        for(Map.Entry<String, Integer> entry : mapping.entrySet()) {
            String key =  entry.getKey();
            int value = entry.getValue();
            System.out.printf("%s: %d%n", key, value);
        }
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
        work07();
    }
}
