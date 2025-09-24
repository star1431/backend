package week_07._0922;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        String a = sc.nextLine().trim();
        String[] strArr;

        strArr = a.split(" ");

        long sum = 0;
        for(String item: strArr){
            sum += Long.parseLong(item);
        }

        System.out.println(sum);
    }
}
