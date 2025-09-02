package week_04._0902;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class ExamCalendar {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
//        exam01();
        exam02();
    }
    public static void exam01() {

        // Calendar = 추상클래스임 -----------------------------------------
        // 현재날짜 : 2025-09-02 화요일
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.get(Calendar.YEAR)); // 2025
        System.out.println(cal.get(1)); // 2025
        System.out.println(cal.get(Calendar.MONTH)); // 8
        System.out.println(cal.get(Calendar.DAY_OF_MONTH)); // 2
        System.out.println(cal.get(Calendar.DAY_OF_WEEK)); // 3
        // DAY_OF_WEEK ?
        //일1, 월2, 화3, 수4, 목5, 금6, 토7


        cal.set(2000, Calendar.JANUARY, 1); // 2000년 1월 1일
        Date calDate = cal.getTime();

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf2.format(calDate)); // 2000-01-01
    }

    public static void exam02() {
        Calendar cal = Calendar.getInstance();

        System.out.println("달력 만들기 (ex: 2025-09)");
        System.out.print("입력: ");

        String input = sc.nextLine();
        int year, month;
        String[] strArr;

        strArr = input.split("-");
        year = Integer.parseInt(strArr[0]);
        month = Integer.parseInt(strArr[1]);

        cal.set(year, month - 1, 1);

        int startDay = cal.get(Calendar.DAY_OF_WEEK); // 요일 위치 정수값
        int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 해당월 마지막 날

        System.out.println();
        System.out.printf(
                "─".repeat(6) + "[ %04d년 %02d월 ]" + "─".repeat(6) + "%n",
                year, month
        );
        System.out.println("일\t월\t화\t수\t목\t금\t토");

        for (int i = 1; i < startDay; i++) {
            System.out.print("\t"); // 시작위치 만큼 탭
        }

        for (int day = 1; day <= maxDay; day++) {
            System.out.printf("%2d\t", day);
            // (day + startDay - 1)
            // startDay가 1이면 월요일부터 시작
            // X 1 2 3 4 5 6 이런 느낌으로 들어가야 함
            if ((day + startDay - 1) % 7 == 0) {  //일주일마다 줄바꿈
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("─".repeat(26));
    }
}
