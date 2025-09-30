package week_08._0930;
import java.util.*;

public class ParallelStreamExam {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 1_000_000; i++) {
            numbers.add(i);
        }

        // 순차 스트림 처리 시간 측정
        long startTime = System.currentTimeMillis();

        numbers.stream()
                .mapToInt(Integer::intValue).sum();

        long test0 =  System.currentTimeMillis() - startTime;

        // 병렬 스트림 처리 시간 측정
        startTime = System.currentTimeMillis();

        numbers.parallelStream()
                .mapToInt(Integer::intValue).sum();

        long test1 =  System.currentTimeMillis() - startTime;

        System.out.println("병렬 스트림 처리 시간: " + test0 + "ms");
        System.out.println("순차 스트림 처리 시간: " + test1 + "ms");
    }
}
