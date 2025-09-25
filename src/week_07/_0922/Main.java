package week_07._0922;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hh = sc.nextInt();
        int mm = sc.nextInt();

        final int MAX_HOUR = 24;
        final int MAX_MIN = 60;
        int pointMin = 45;

        boolean check = mm >= pointMin;
        int setHour, setMin;

        if(check) {
            setMin = mm - pointMin;
            setHour = hh;
        } else {
            setMin = MAX_MIN - pointMin + mm;
            setHour = (hh == 0) ? MAX_HOUR - 1 : hh - 1;
        }

        System.out.println(setHour + " " + setMin);
    }
}
