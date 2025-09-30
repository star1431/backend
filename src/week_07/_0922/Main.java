package week_07._0922;


import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int[] nums = new int[10];
        String str = String.valueOf(a * b * c);

        for (int i = 1; i <= str.length(); i++) {
            String cur =  str.substring(i - 1, i);
            for (int j = 0; j < nums.length; j++) {
                if(j == Integer.parseInt(cur)) nums[j] += 1;
            }
        }

        for (int item : nums) {
            System.out.println(item);
        }
    }
}
