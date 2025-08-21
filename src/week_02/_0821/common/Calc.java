package week_02._0821.common;

public class Calc {
    public int optionKey(int a, int b, String key) {
        return (int)calcCore(a, b, key);
    }

    public double optionKey(double a, double b, String key) {
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
    
    public int addAll(int... numbers) {
        int total = 0;
        for(int num : numbers) {
            total += num;
        }
        return total;
    }
}