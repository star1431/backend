# java.time

```bash
java.time
    ├─ LocalDate
    ├─ LocalTime
    ├─ LocalDateTime
    ├─ ZonedDateTime
    ├─ Period
    ├─ Duration
    ├─ Instant
    ├─ ZoneId / ZoneOffset
    ├─ DayOfWeek / Month
    ├─ temporal / ChronoUnit
    └─ ...

```

## 1. LocalDate 주요 메서드

| 메서드             | 설명       | 예시                                |
| --------------- | -------- | --------------------------------- |
| now()           | 현재 날짜    | LocalDate.now()                   |
| of(y, m, d)     | 특정 날짜 생성 | LocalDate.of(2025, 9, 3)          |
| getYear()       | 연도 추출    | date.getYear()<br>→ 2025          |
| getMonth()      | 월 추출     | date.getMonth()<br>→ DECEMBER     |
| getDayOfMonth() | 일 추출     | date.getDayOfMonth()<br>→ 25      |
| getDayOfWeek()  | 요일 추출    | date.getDayOfWeek()<br>→ THURSDAY |
| plusDays(n)     | 일 더하기    | date.plusDays(5)                  |
| minusDays(n)    | 일 빼기     | date.minusDays(5)                 |
| plusMonths(n)   | 월 더하기    | date.plusMonths(1)                |
| plusYears(n)    | 연도 더하기   | date.plusYears(1)                 |
| isBefore(date)  | 과거 여부    | d1.isBefore(d2)                   |
| isAfter(date)   | 미래 여부    | d1.isAfter(d2)                    |
| isEqual(date)   | 동일 여부    | d1.isEqual(d2)                    |



```java
import java.time.LocalDate;

public class LocalDateExample {
    public static void main(String[] args) {
        // 심플 ----------------
        LocalDate today = LocalDate.now();
        System.out.println("오늘 날짜: " + today);
        // 오늘 날짜: 2025-09-03

        LocalDate date = LocalDate.of(2025, 12, 25);
        System.out.println("크리스마스: " + date);
        // 크리스마스: 2025-12-25

        System.out.println("연도: " + date.getYear());
        // 연도: 2025
        System.out.println("월: " + date.getMonth());
        // 월: DECEMBER
        System.out.println("일: " + date.getDayOfMonth());
        // 일: 25
        System.out.println("요일: " + date.getDayOfWeek());
        // 요일: THURSDAY

        // 응용 ----------------
        // 1. D-day 계산
        LocalDate today1 = LocalDate.now();
        LocalDate exam = LocalDate.of(2025, 11, 1);

        long diff = ChronoUnit.DAYS.between(today1, exam);

        if (diff > 0) {
            System.out.println("오늘: " + today1);
            System.out.println("시험일: " + exam);
            System.out.println("[D-" + diff + "] 남았습니다.");
            // [D-59] 남았습니다.
        } else if (diff < 0) {
            System.out.println("오늘: " + today1);
            System.out.println("시험일: " + exam);
            System.out.println("[D+" + Math.abs(diff) + "] 지났습니다.");
            // [D+10] 지났습니다.
        } else {
            System.out.println("오늘: " + today1);
            System.out.println("시험일: " + exam);
            System.out.println("오늘은 [D-DAY] 입니다");
            // 오늘은 [D-DAY] 입니다
        }
    }
}

```

---

## 2. LocalTime 주요 메서드

| 메서드             | 설명       | 예시                       |
| --------------- | -------- | ------------------------ |
| now()           | 현재 시간    | LocalTime.now()          |
| of(h, m, s)     | 특정 시간 생성 | LocalTime.of(14, 30, 0)  |
| getHour()       | 시 추출     | time.getHour()<br>→ 14   |
| getMinute()     | 분 추출     | time.getMinute()<br>→ 30 |
| getSecond()     | 초 추출     | time.getSecond()<br>→ 15 |
| plusHours(n)    | 시 더하기    | time.plusHours(2)        |
| minusMinutes(n) | 분 빼기     | time.minusMinutes(10)    |



```java
import java.time.LocalTime;

public class LocalTimeExample {
    public static void main(String[] args) {
        // 심플 ----------------
        LocalTime now = LocalTime.now();
        System.out.println("현재 시각: " + now);
        // 현재 시각: 19:32:15.123 (실행 시점마다 다름)

        LocalTime lunch = LocalTime.of(12, 30);
        System.out.println("점심 시간: " + lunch);
        // 점심 시간:  12:30

        System.out.println("시: " + lunch.getHour());
        // 시: 12
        System.out.println("분: " + lunch.getMinute());
        // 분: 30
        System.out.println("초: " + lunch.getSecond());
        // 초: 0

        // 응용 ----------------
        // 1. 회의 시간 계산
        LocalTime meeting = lunch.plusHours(2);
        System.out.println("회의 시간: " + meeting);
        // 회의 시간: 14:30
    }
}

```

---

## 3. LocalDateTime 주요 메서드

| 메서드               | 설명         | 예시                                   |
| ----------------- | ---------- | ------------------------------------ |
| now()             | 현재 날짜/시간   | LocalDateTime.now()                  |
| of(y, m, d, h, m) | 특정 날짜시간 생성 | LocalDateTime.of(2025, 9, 3, 14, 30) |
| plusDays(n)       | 일 더하기      | dt.plusDays(1)                       |
| plusHours(n)      | 시 더하기      | dt.plusHours(2)                      |
| minusDays(n)      | 일 빼기       | dt.minusDays(3)                      |
| toLocalDate()     | 날짜만 추출     | dt.toLocalDate()                     |
| toLocalTime()     | 시간만 추출     | dt.toLocalTime()                     |



```java
import java.time.LocalDateTime;

public class LocalDateTimeExample {
    public static void main(String[] args) {
        // 심플 ----------------
        LocalDateTime now = LocalDateTime.now();
        System.out.println("현재: " + now);
        // 2025-09-03T14:33:10.456

        LocalDateTime meeting = LocalDateTime.of(2025, 9, 3, 15, 0);
        System.out.println("회의: " + meeting);
        // 2025-09-03T15:00

        System.out.println("날짜만: " + meeting.toLocalDate());
        // 2025-09-03
        System.out.println("시간만: " + meeting.toLocalTime());
        // 15:00

        // 응용 ----------------
        // 1. 마감시간 계산 (오늘 기준 18시 마감까지 남은 시간)
        LocalDateTime deadline = LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(), 18, 0);
        System.out.println("마감 시간: " + deadline);
        // 2025-09-03T18:00
        System.out.println("현재 시각: " + now);
        // 2025-09-03T14:33:10.456
        System.out.println("남은 시간(시간 단위): " + java.time.Duration.between(now, deadline).toHours());
        // 3
    }
}

```

---

## 4. ZonedDateTime / ZoneId 주요 메서드

| 메서드                       | 설명              | 예시                                                      |
| ------------------------- | --------------- | ------------------------------------------------------- |
| now(zone)                 | 특정 타임존 현재       | ZonedDateTime.now(ZoneId.of("Asia/Seoul"))              |
| withZoneSameInstant(zone) | 같은 시각 다른 타임존 변환 | zdt.withZoneSameInstant(ZoneId.of("America/New\_York")) |
| getZone()                 | Zone 반환         | zdt.getZone()<br>→ Asia/Seoul                           |



```java
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.LocalDateTime;

public class ZonedDateTimeExample {
    public static void main(String[] args) {
        // 심플 ----------------
        ZonedDateTime seoulNow = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println("서울: " + seoulNow);
        // 2025-09-03T14:35+09:00[Asia/Seoul]

        ZonedDateTime newYorkNow = seoulNow.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("뉴욕: " + newYorkNow);
        // 2025-09-03T01:35-04:00[America/New_York]

        System.out.println("타임존: " + seoulNow.getZone());
        // Asia/Seoul

        // 응용 ----------------
        // 1) 서울 기준 회의 시간 → 뉴욕 시간 변환
        LocalDateTime meetingLocal = LocalDateTime.of(2025, 9, 3, 15, 0);
        ZonedDateTime meetingSeoul = meetingLocal.atZone(ZoneId.of("Asia/Seoul"));
        ZonedDateTime meetingNY = meetingSeoul.withZoneSameInstant(ZoneId.of("America/New_York"));

        System.out.println("서울 회의: " + meetingSeoul);
        // 2025-09-03T15:00+09:00[Asia/Seoul]
        System.out.println("뉴욕 시간: " + meetingNY);
        // 2025-09-03T02:00-04:00[America/New_York]
    }
}

```

---

## 5. Period 주요 메서드

| 메서드             | 설명       | 예시                     |
| --------------- | -------- | ---------------------- |
| between(d1, d2) | 날짜 차이 반환 | Period.between(d1, d2) |
| getYears()      | 년 차이     | p.getYears()           |
| getMonths()     | 월 차이     | p.getMonths()          |
| getDays()       | 일 차이     | p.getDays()            |
| plusDays(n)     | 일 더하기    | p.plusDays(5)          |
| plusMonths(n)   | 월 더하기    | p.plusMonths(2)        |
| plusYears(n)    | 년 더하기    | p.plusYears(1)         |
| minusDays(n)    | 일 빼기     | p.minusDays(3)         |
| isZero()        | 차이가 0인지  | p.isZero()             |
| isNegative()    | 음수 여부    | p.isNegative()         |

```java
import java.time.LocalDate;
import java.time.Period;

public class PeriodExample {
    public static void main(String[] args) {
        // 심플 ----------------
        LocalDate start = LocalDate.of(2025, 1, 1);
        LocalDate end = LocalDate.of(2025, 9, 3);
        Period p = Period.between(start, end);

        System.out.println("년: " + p.getYears());
        // 0
        System.out.println("월: " + p.getMonths());
        // 8
        System.out.println("일: " + p.getDays());
        // 2

        // 응용 ----------------
        // 1) 생일로 만 나이 계산
        LocalDate birth = LocalDate.of(1995, 4, 10);
        int age = Period.between(birth, LocalDate.now()).getYears();
        System.out.println("만 나이: " + age);
        // 30

        // 2) 구독 시작일로 다음 갱신일 계산 (Period 사용)
        LocalDate subscribed = LocalDate.of(2025, 9, 3);
        LocalDate nextBilling = subscribed.plus(Period.ofMonths(1));
        System.out.println("다음 결제일: " + nextBilling);
        // 2025-10-03
    }
}
```

---

## 6. Duration 주요 메서드

| 메서드             | 설명       | 예시                       |
| --------------- | -------- | ------------------------ |
| between(t1, t2) | 시간 차이 반환 | Duration.between(t1, t2) |
| toHours()       | 시간 단위    | d.toHours()              |
| toMinutes()     | 분 단위     | d.toMinutes()            |
| getSeconds()    | 초 단위     | d.getSeconds()           |
| plusHours(n)    | 시 더하기    | d.plusHours(2)           |
| minusMinutes(n) | 분 빼기     | d.minusMinutes(10)       |


```java
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DurationExample {
    public static void main(String[] args) {
        // 심플 ----------------
        LocalTime t1 = LocalTime.of(10, 0);
        LocalTime t2 = LocalTime.of(15, 30);
        Duration d = Duration.between(t1, t2);

        System.out.println("시간(시): " + d.toHours());
        // 5
        System.out.println("시간(분): " + d.toMinutes());
        // 330
        System.out.println("초 단위: " + d.getSeconds());
        // 19800

        // 응용 ----------------
        // 1) 업무 마감까지 남은 분 계산 (LocalDateTime)
        LocalDateTime now = LocalDateTime.of(2025, 9, 3, 14, 30);
        LocalDateTime deadline = LocalDateTime.of(2025, 9, 3, 18, 0);
        long leftMinutes = Duration.between(now, deadline).toMinutes();

        System.out.println("마감까지(분): " + leftMinutes);
        // 210

        // 2) API 호출 지연 측정 (Duration)
        LocalDateTime start = LocalDateTime.now();
        // ... API call ...
        LocalDateTime finish = start.plusSeconds(2); // 예시
        Duration latency = Duration.between(start, finish);

        System.out.println("지연(ms): " + latency.toMillis());
        // 2000
    }
}
```

---

## 7. ChronoUnit 주요 메서드 

| 메서드                     | 설명           | 예시                                            |
| ----------------------- | ------------ | --------------------------------------------- |
| DAYS.between(d1, d2)    | 두 날짜 간 일수 차이 | ChronoUnit.DAYS.between(d1, d2)<br>→ 59       |
| MONTHS.between(d1, d2)  | 두 날짜 간 월수 차이 | ChronoUnit.MONTHS.between(d1, d2)<br>→ 1      |
| YEARS.between(d1, d2)   | 두 날짜 간 년수 차이 | ChronoUnit.YEARS.between(d1, d2)<br>→ 2       |
| HOURS.between(t1, t2)   | 두 시간 간 시간 차이 | ChronoUnit.HOURS.between(t1, t2)<br>→ 5       |
| MINUTES.between(t1, t2) | 두 시간 간 분 차이  | ChronoUnit.MINUTES.between(t1, t2)<br>→ 330   |
| SECONDS.between(t1, t2) | 두 시간 간 초 차이  | ChronoUnit.SECONDS.between(t1, t2)<br>→ 19800 |

```java
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class ChronoUnitExample {
    public static void main(String[] args) {
        // 날짜 차이 ----------------
        LocalDate today = LocalDate.of(2025, 9, 3);
        LocalDate exam = LocalDate.of(2025, 11, 1);

        long days = ChronoUnit.DAYS.between(today, exam);
        System.out.println("일 차이: " + days);
        // 59

        long months = ChronoUnit.MONTHS.between(today, exam);
        System.out.println("월 차이: " + months);
        // 1

        // 시간 차이 ----------------
        LocalTime start = LocalTime.of(10, 0);
        LocalTime end = LocalTime.of(15, 30);

        long hours = ChronoUnit.HOURS.between(start, end);
        System.out.println("시간 차이: " + hours);
        // 5

        long minutes = ChronoUnit.MINUTES.between(start, end);
        System.out.println("분 차이: " + minutes);
        // 330

        long seconds = ChronoUnit.SECONDS.between(start, end);
        System.out.println("초 차이: " + seconds);
        // 19800

        // 응용 ----------------
        // 1) LocalDateTime 마감일까지 남은 일수 계산
        LocalDateTime deadline = LocalDateTime.of(2025, 12, 31, 23, 59);
        long leftDays = ChronoUnit.DAYS.between(today.atStartOfDay(), deadline);
        System.out.println("연말까지 남은 일수: " + leftDays);
        // 119

        // 2) 지난 로그인으로부터 경과 시간 체크
        LocalDateTime lastLogin = LocalDateTime.of(2025, 9, 2, 22, 0);
        long diffHours = ChronoUnit.HOURS.between(lastLogin, LocalDateTime.now());
        System.out.println("마지막 로그인 이후 시간: " + diffHours);
        // 실행 시점에 따라 다름
    }
}

```