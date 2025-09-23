package week_07._0922;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = 543;
        while (true) {
            int input = sc.nextInt();
            if(input <= 1000 || input >= 3000) {
                System.out.println("1001 ~ 3000 까지 입력");
            } else {
                System.out.println((input - year));
                sc.close();
                break;
            }
        }
    }
}
