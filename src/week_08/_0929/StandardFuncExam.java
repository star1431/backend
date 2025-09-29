package week_08._0929;
import java.util.function.*;

public class StandardFuncExam {
    public static void main(String[] args) {
        // 매개변수 없고, 반환 X
        Runnable r = () -> System.out.println("Runnable 실행");
        r.run();

        // 매개변수 하나, 반환 X
        Consumer<String> consumer = (s) -> System.out.println("Consumer: " + s);
        consumer.accept("Hello");

        // 매개변수 하나, 반환 O
        Function<Integer, String> function = (i) -> "Function: " + (i * 2);
        String result = function.apply(5);
        System.out.println(result);

        // 매개변수 두개, 반환 O
        BiFunction<Integer, Integer, Integer> biFunction = (a, b) -> a + b;
        int sum = biFunction.apply(3, 7);
        System.out.println("BiFunction: " + sum);

        // 매개변수 하나, boolean 반환
        Predicate<String> predicate = (s) -> s.length() > 5;
        boolean testResult = predicate.test("HelloWorld");
        System.out.println("Predicate: " + testResult);
    }
}