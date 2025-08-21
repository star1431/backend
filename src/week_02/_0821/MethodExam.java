package week_02._0821;

public class MethodExam {
    /**
     * calc 사칙연산 기능 
     * @param a   int정수  
     * @param b   int정수
     * @param key "-", "+", "/", "*", "%"
     * @return (int) or (double)
     */
    public static int calc(int a, int b, String key) {
        return (int)calcCore(a, b, key);
    }
    public static double calc(double a, double b, String key) {
        return calcCore(a, b, key);
    }
    private static double calcCore(double a, double b, String key) {
        switch (key) {
            case "+": return a + b;
            case "-": return a - b;
            case "%": return a % b;
            case "*": return a * b;
            case "/": return a / b;
            default:  return 0;
        }
    }

    /**
     * add 가변 합산
     * @param numbers 숫자 가변 or 정수 배열
     * @return (int)total
     */
    public static int add(int... numbers) {
        int total = 0;
        for(int num : numbers) {
            total += num;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println("TITLE : 0821 계산 메서드 만들기");

        int _add = calc(10, 3, "+");
        int _minus = calc(10, 3, "-");
        int _mul = calc(10, 3, "*");
        double _div = calc((double)10, 3, "/");
        int _reNum = calc(10, 3, "%");

        System.out.printf(
            "덧셈: %d, 뺄셈: %d, 곱셈: %d, 나눗셈: %.2f, 나머지: %d%n", 
            _add, _minus, _mul, _div, _reNum 
        );

        int _sum0 = add(1,2,3,4,5,6,7,8,9,10);
        int[] arr0 = {5, 9, 7, 6, 4, 5, 5 }; 
        System.out.println("1~10합산: " + _sum0);
        System.out.println("배열 합산: " + add(arr0));
        
    }

}
