package week_02._0822.common;

public class Calculator {
    public int calculate(int a, int b, String key) {
        return (int)calcCore(a, b, key);
    }

    public double calculate(double a, double b, String key) {
        return calcCore(a, b, key);
    }

    private double calcCore(double a, double b, String key) {
        switch (key) {
            case "+": return a + b;
            case "-": return a - b;
            case "%": return a % b;
            case "*": return a * b;
            case "/": return a / b;
            default:  return 0;
        }
    }
    
    public int sum(int... params) {
        int total = 0;
        for(int num : params) {
            total += num;
        }
        return total;
    }

    public double avg(int... params) {
        int total = sum(params);
        double avg = (double)total / params.length;
        return avg;
    }
}