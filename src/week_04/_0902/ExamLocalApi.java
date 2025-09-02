package week_04._0902;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

public class ExamLocalApi {
    public static void main(String[] args) {
//        exam01(); // 로컬데이트,타임,데이트타임
//        exam02(); // 존드데이트타임
        exam03();
    }

    public static void exam01() {
        // 현재날짜 : 2025-09-02
        // 현재 날짜/시간
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();

        System.out.println("날짜: " + date);
        System.out.println("시간: " + time);
        System.out.println("날짜시간: " + dateTime);
        System.out.println("─".repeat(10));

        // 특정 날짜/시간 생성
        LocalDate date01 = LocalDate.of(2000, 1, 1); // yyy-mm-dd
        LocalTime noon = LocalTime.of(12, 0); // hh:mm
        LocalDateTime appointment = LocalDateTime.of(2024, 12, 25, 18, 30);
        // yyy-mm-ddThh:mm

        System.out.println(date01);
        System.out.println(noon);
        System.out.println(appointment);
        System.out.println("─".repeat(10));

        // 날짜 연산 (minus,plus)
        System.out.println("어제: " + date.minusDays(1));
        System.out.println("내일: " + date.plusDays(1));
        System.out.println("지난주: " + date.minusWeeks(1));
        System.out.println("다음주: " + date.plusWeeks(1));
        System.out.println("지난달: " + date.minusMonths(1));
        System.out.println("다음달: " + date.plusMonths(1));
        System.out.println("─".repeat(10));

        // 날짜 정보 추출
        System.out.printf("%d년 %s %d일 %s%n",
                date.getYear(),
                date.getMonth(),
                date.getDayOfMonth(),
                date.getDayOfWeek()
        ); // 2025년 SEPTEMBER 2일 TUESDAY
        // 숫자월 표기시 : date.getMonthValue()
        System.out.println("─".repeat(10));
    }

    public static void exam02() {
        // 시스템 기본 시간대
        ZoneId systemZone = ZoneId.systemDefault();
        System.out.println("내 지역(TimeZone): " + systemZone);

        // 현재 시간대의 날짜시간
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println("현재(서울): " + now);

        // 다른 시간대로 변환
        ZonedDateTime newYork = now.withZoneSameInstant(
                ZoneId.of("America/New_York"));
        System.out.println("뉴욕: " + newYork);

        // 특정 시간대로 생성
        ZonedDateTime paris = ZonedDateTime.of(
                LocalDateTime.now(),
                ZoneId.of("Europe/Paris"));
        System.out.println("파리: " + paris);

        // 사용 가능한 시간대 확인
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        zoneIds.stream()
                .filter(z -> z.contains("Seoul"))
                .forEach(System.out::println);
    }

    public static void exam03() {

        // Duration
        LocalDateTime time1 = LocalDateTime.of(2025, 9, 2, 10, 0);
        LocalDateTime time2 = LocalDateTime.of(2025, 9, 2, 15, 30);

        // 2025-09-02 10:00 | 2025-09-02 15:30
        Duration duration = Duration.between(time1, time2);

        System.out.println("총 시간 차이: " + duration.toHours() + "시간");
        System.out.println("총 분 차이: " + duration.toMinutes() + "분");
        System.out.println("총 초 차이: " + duration.toSeconds() + "초");


        // Period
        LocalDate date1 = LocalDate.of(2025, 1, 1);
        LocalDate date2 = LocalDate.of(2025, 9, 2);

        // 2025-01-01 | 2025-09-02
        Period period = Period.between(date1, date2);

        System.out.printf("두 날짜 차이: %d년 %d개월 %d일%n",
                period.getYears(),
                period.getMonths(),
                period.getDays()
        );
    }
}
