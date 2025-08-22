package week_02._0822;
import week_02._0822.common.Calculator;

public class CalcExam {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        int[] intArr = {1, 2, 3, 5, 7, 9};

        int preNum  = intArr[4]; // 7
        int nextNum = intArr[2]; // 3


        int total   = calc.sum(intArr);
        double avg   = calc.avg(intArr);
        int add     = calc.calculate(preNum, nextNum, "+");
        int minus   = calc.calculate(preNum, nextNum, "-");
        int mul     = calc.calculate(preNum, nextNum, "*");
        double div  = calc.calculate((double)preNum, nextNum, "/");
        int reNum   = calc.calculate(preNum, nextNum, "%");

        System.out.println("배열총합 : " + total);
        System.out.println("배열평균 : " + avg);
        System.out.printf("%d + %d = %d %n", preNum, nextNum, add);
        System.out.printf("%d - %d = %d %n", preNum, nextNum, minus);
        System.out.printf("%d * %d = %d %n", preNum, nextNum, mul);
        System.out.printf("%d / %d = %.3f %n", preNum, nextNum, div);
        System.out.printf("%d %% %d = %d %n", preNum, nextNum, reNum);
    }
}