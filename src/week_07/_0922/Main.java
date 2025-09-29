package week_07._0922;


import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.next(), b = sc.next(), c = sc.next();

        int line1 = Integer.parseInt(a) + Integer.parseInt(b) - Integer.parseInt(c);
        int line2 = Integer.parseInt(a + b) - Integer.parseInt(c);
        System.out.println(line1);
        System.out.println(line2);
    }
}
