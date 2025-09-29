package week_08._0929;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LambdaCollectionExam {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("신짱구", "김철수", "유리", "훈이", "맹구");

        // 1. forEach : 각 요소 출력
        System.out.println("─── forEach ───");
        names.forEach(item -> {
            System.out.print(item + " ");
        });
        System.out.println();

        // 1-1. forEach 내 idx 활용
        System.out.println("\n─── forEach + IntStream (index추가) ───");
        IntStream.range(0, names.size())
                .forEach(idx -> {
                    if(idx != names.size() - 1) System.out.printf("[%d] %s | ", idx, names.get(idx));
                    else System.out.printf("[%d] %s%n", idx, names.get(idx));
                });

        // 2. map : name + 님
        System.out.println("\n─── map (+ 님) ───");
        List<String> upperNames = names.stream()
                .map(item -> item + "님")
                .collect(Collectors.toList());

        upperNames.forEach(item -> System.out.print(item + " "));
        System.out.println();

        // 3. filter : 이름 길이가 3 이상인 요소만 필터링
        System.out.println("\n─── filter (길이 >= 3) ───");
        List<String> longNames = names.stream()
                .filter(name -> name.length() >= 3)
                .collect(Collectors.toList());

        longNames.forEach(name -> System.out.print(name + " "));
        System.out.println();

        // 4. reduce : 모든 이름을 하나의 문자열로 결합
        System.out.println("\n─── reduce (모든 이름 결합) ───");
        String allNames = names.stream()
                .reduce((item1, item2) -> item1 + ", " + item2)
                .orElse("없는데요?");
        System.out.println("모든 이름: " + allNames);

        // 5. sorted : 이름을 가나다순으로 정렬
        System.out.println("\n─── sorted (가나다순) ───");
        List<String> sortedNames = names.stream()
                .sorted()
                .collect(Collectors.toList());
        sortedNames.forEach(name -> System.out.print(name + " "));
        System.out.println();
        // sorted : 디폴트 오름차순
        // sorted(Comparator.reverseOrder()) : 내림차순
    }
}