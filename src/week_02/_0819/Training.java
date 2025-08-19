package week_02._0819;
import java.util.*;

public class Training {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("===== 계산기 (+-*/%) =======");
        System.out.println("입력방식 ex) 101 % 10");
        System.out.print("값입력 : ");
        String inputVal = input.nextLine();
        input.close();

        /*
         * 스트링토큰라이저 util
         * StringTokenizer(스트링값,"구분자식별", 구분자식별받기 여부)
         */
        StringTokenizer tokenStr = new StringTokenizer(inputVal, "+-*/%", true);

        String preVal   ="0";
        String optVal   = "";
        String nextVal  = "0";

        if (tokenStr.hasMoreTokens()) preVal  = tokenStr.nextToken().trim();
        if (tokenStr.hasMoreTokens()) optVal  = tokenStr.nextToken().trim();
        if (tokenStr.hasMoreTokens()) nextVal = tokenStr.nextToken().trim();

        int preNum, nextNum;

        long resultNum;

        
        preNum  = Integer.parseInt(preVal);
        nextNum = Integer.parseInt(nextVal);
        
        String opt = optVal;

        switch (opt) {
            case "+":
                resultNum = preNum + nextNum;
                break;
            case "-":
                resultNum = preNum - nextNum;
                break;
            case "*":
                resultNum = preNum * nextNum;
                break;
            case "/":
                resultNum = preNum / nextNum;
                break;
            case "%":
                resultNum = preNum % nextNum;
                break;
            default:
                resultNum = 0;
                break;
        }
        System.out.println();
        System.out.printf("입력값은 \'%s\' 이고,\n", inputVal);
        System.out.printf("결과값은 \'%d\' 입니다.\n", resultNum);
        System.out.println("=========== END ============");
    }
}
