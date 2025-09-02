package week_04._0902;
import java.time.DayOfWeek;
//import java.time.LocalDateTime;
import java.time.LocalDate;
//import java.time.Period;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;


public class Work {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Dday();
        businessDay();
        workDay();
        sc.close();
        
    }
    public static void Dday() {
        /*
        *   D-day 계산기
            오늘 날짜 기준으로 날짜를 입력하고 입력받은 날짜가 미래일 때 과거일 때 D+00, 미래일 때 D-00, 오늘이면 D-DAY 출력
            예) 2025-01-01 입력 -> D-244 출력
        * */
        System.out.println("─".repeat(8) + "[ D-day 계산 ]" +  "─".repeat(8));
        LocalDate toDay = LocalDate.now();

        System.out.println("현재 날짜: " + toDay);
        System.out.print("날짜 입력 (yyyy-mm-dd): ");
        String input = sc.nextLine();

        String[] inputArr = input.split("-");

        int year = Integer.parseInt(inputArr[0]);
        int month = Integer.parseInt(inputArr[1]);
        int day = Integer.parseInt(inputArr[2]);

        LocalDate inputDate = LocalDate.of(year, month, day);

        // Period period = Period.between(toDay, inputDate);
        /*
        * ChronoUnit.비교기준.between(a,b)
        * ChronoUnit ? 특정 기준 (시간,날짜,년도 등) 비교할때 사용
        */
        long diff = ChronoUnit.DAYS.between(toDay, inputDate);

        if(diff < 0) System.out.print("(D+) ");
        else System.out.print("(D-) ");

        System.out.println(Math.abs(diff) + "일");
    }

    public static void businessDay() {
        /*
        *   영업일 계산기
            오늘 날짜 기준으로 숫자를 입력하면 주말이 제외된 영업일 기준으로 몇월며칠인지 출력
            예) 5 입력 -> (주말 6일, 7일 제외) 9월 8일
        */
        System.out.println("─".repeat(8) + "[ 영업일 계산 ]" +  "─".repeat(8));
        LocalDate toDay = LocalDate.now();

        System.out.println("현재 날짜: " + toDay);
        System.out.print("숫자 입력: ");
        String input = sc.nextLine();

        int num = Integer.parseInt(input);

        LocalDate resultDay = toDay;

        int cnt = 0;
        while (cnt < num) {
            resultDay = resultDay.plusDays(1); // 날짜에서 하루씩 증가
            boolean checking = resultDay.getDayOfWeek() != DayOfWeek.SATURDAY && resultDay.getDayOfWeek() != DayOfWeek.SUNDAY;
            if (checking) cnt++;
        }

        System.out.println("입력값: " + num + "일\n주말이 제외된 영업일 기준 날짜는? : " + resultDay);
    }


    public static void workDay() {
        /*
        *   근무일 계산기
            입사일, 퇴사일을 입력하고 실제로 근무한 근무일수를 계산
            주말을 제외한 근무일수를 계산
        */
        System.out.println("─".repeat(8) + "[ 근무일 계산 ]" +  "─".repeat(8));
        System.out.println("( 각각 날짜 입력 ex: 2025-11-01 )");
        String[] strArr;
        int year, month, day;

        System.out.print("입사일 입력: ");
        String input1 = sc.nextLine();
        strArr = input1.split("-");
        year = Integer.parseInt(strArr[0]);
        month = Integer.parseInt(strArr[1]);
        day = Integer.parseInt(strArr[2]);
        LocalDate startDate = LocalDate.of(year, month, day);

        System.out.print("퇴사일 입력: ");
        String input2 = sc.nextLine();
        strArr = input2.split("-");
        year = Integer.parseInt(strArr[0]);
        month = Integer.parseInt(strArr[1]);
        day = Integer.parseInt(strArr[2]);
        LocalDate endDate = LocalDate.of(year, month, day);

        long diff = ChronoUnit.DAYS.between(startDate, endDate) + 1;

        LocalDate resultDate = startDate;

        int cnt = 0;
        // resultDate.isAfter(endDate) = resultDate > endDate
        // !resultDate.isAfter(endDate) = resultDate <= endDate
        while (!resultDate.isAfter(endDate)) {
            boolean checking = resultDate.getDayOfWeek() != DayOfWeek.SATURDAY && resultDate.getDayOfWeek() != DayOfWeek.SUNDAY;
            if (checking) cnt++;
            resultDate = resultDate.plusDays(1); // 검사 후 추가
        }

        // System.out.println(cnt);

        // 입사일에서 cnt 근무일수 만큼 날짜 다시 재대입해서 년/월/일 얻기
        resultDate = startDate;
        resultDate = resultDate.plusDays(cnt);
        Period period = Period.between(startDate, resultDate);
        // System.out.println(startDate);
        // System.out.println(resultDate);

        System.out.println("입사일: " + startDate + ", 퇴사일: " + endDate);
        System.out.print("근무일수: ");
        if(period.getYears() > 0) System.out.print(period.getYears() + "년 ");
        if(period.getMonths() > 0) System.out.print(period.getMonths() + "개월 ");
        if(period.getDays() > 0) System.out.print(period.getDays() + "일");
    }
}
