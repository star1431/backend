## java.lang

### String 주요 메서드

| 메서드 | 설명 | 예시 |
| --- | --- | --- |
| length() | 문자열 길이 반환 | "hello".length() → 5 |
| charAt(i) | i번째 문자 반환 (0부터 시작) | "java".charAt(2) → 'v' |
| substring(s, e) | 문자열의 부분 추출 (s부터 e-1까지) | "program".substring(0, 3) → "pro" |
| indexOf(str) | 지정 문자열이 처음 등장하는 위치 반환 | "banana".indexOf("na") → 2 |
| lastIndexOf(str) | 지정 문자열이 마지막으로 등장하는 위치 반환 | "banana".lastIndexOf("na") → 4 |
| contains(str) | 지정 문자열 포함 여부 반환 (boolean) | "hello".contains("he") → true |
| equals(str) | 문자열 내용이 같은지 비교 | "abc".equals("abc") → true |
| equalsIgnoreCase(str) | 대소문자 무시하고 비교 | "Java".equalsIgnoreCase("java") → true |
| toUpperCase() | 문자열을 모두 대문자로 변환 | "java".toUpperCase() → "JAVA" |
| toLowerCase() | 문자열을 모두 소문자로 변환 | "JAVA".toLowerCase() → "java" |
| trim() | 앞뒤 공백 제거 | " hi ".trim() → "hi" |
| replace(a, b) | 문자열 a를 b로 모두 치환 | "apple".replace("p", "x") → "axxle" |
| split(regex) | 구분자를 기준으로 문자열 배열 반환 | "a,b,c".split(",") → \["a","b","c"\] |
| join(delim, arr) | 배열 요소를 구분자와 함께 문자열로 합침 | String.join("-", "a","b","c") → "a-b-c" |
| valueOf(x) | 기본형 값을 문자열로 변환 | String.valueOf(100) → "100" |
| isEmpty() | 문자열이 비어있는지 확인 (길이 0) | "".isEmpty() → true |
| isBlank() (Java 11+) | 공백만 포함해도 true 반환 | " ".isBlank() → true |

### Math 주요 메서드

| 메서드 | 설명 | 예시 |
| --- | --- | --- |
| abs(x) | 절댓값 반환 | Math.abs(-5) → 5 |
| max(a, b) | 두 값 중 큰 값 반환 | Math.max(10, 20) → 20 |
| min(a, b) | 두 값 중 작은 값 반환 | Math.min(10, 20) → 10 |
| pow(a, b) | a^b (거듭제곱) | Math.pow(2, 3) → 8.0 |
| sqrt(x) | 제곱근 반환 | Math.sqrt(16) → 4.0 |
| round(x) | 반올림 (소수점 첫째자리 기준) | Math.round(3.6) → 4 |
| ceil(x) | 올림 (소수점 올림) | Math.ceil(3.1) → 4.0 |
| floor(x) | 내림 (소수점 버림) | Math.floor(3.9) → 3.0 |
| random() | 0.0 이상 1.0 미만의 난수 반환 | Math.random() → 0.12345... |
| PI / E | 원주율, 자연상수 상수 제공 | Math.PI → 3.14159... |

### System 주요 메서드

| 메서드 | 설명 | 예시 |
| --- | --- | --- |
| currentTimeMillis() | 현재 시간을 밀리초 단위로 반환 (UTC 기준) | System.currentTimeMillis() |
| nanoTime() | 현재 시간을 나노초 단위로 반환 (성능 측정용) | System.nanoTime() |
| exit(status) | 프로그램 종료 (0 = 정상, 1 = 오류) | System.exit(0) |
| gc() | 가비지 컬렉터 실행 요청 | System.gc() |
| getenv(String name) | 환경 변수 값 가져오기 | System.getenv("PATH") |
| getProperty(String key) | 시스템 속성 가져오기 | System.getProperty("java.version") |
| arraycopy(src, srcPos, dest, destPos, length) | 배열 복사 | System.arraycopy(arr1, 0, arr2, 0, arr1.length) |
| setProperty(key, value) | 시스템 속성 설정 | System.setProperty("mode", "dev") |
| lineSeparator() | 운영체제 줄바꿈 문자 반환 | System.lineSeparator() |
| console() | 콘솔 객체 반환 (없으면 null) | System.console() |
| identityHashCode(Object obj) | 객체의 고유 해시코드 반환 | System.identityHashCode(obj) |
| getProperties() | 모든 시스템 속성(Properties) 반환 | System.getProperties().list(System.out) |
| setOut(PrintStream out) | 표준 출력 스트림 변경 | System.setOut(new PrintStream("log.txt")) |
| setErr(PrintStream err) | 표준 에러 출력 스트림 변경 | System.setErr(...) |
| setIn(InputStream in) | 표준 입력 변경 | System.setIn(...) |

---

## java.util

### Arrrays 주요 메서드

| 메서드 | 설명 | 예시 |
| --- | --- | --- |
| sort(array) | 배열 정렬 (오름차순) | Arrays.sort(arr) |
| sort(array, Comparator) | 사용자 정의 기준 정렬 | Arrays.sort(arr, Comparator.reverseOrder()) |
| binarySearch(array, key) | 정렬된 배열에서 이진 탐색 | Arrays.binarySearch(arr, "사과") |
| copyOf(array, newLen) | 배열 길이 변경 (복사) | Arrays.copyOf(arr, 5) |
| equals(arr1, arr2) | 두 배열 비교 | Arrays.equals(arr1, arr2) |
| fill(array, value) | 배열 전체 값 채우기 | Arrays.fill(arr, 0) |
| toString(array) | 배열 문자열 변환 | Arrays.toString(arr) |

### Collection 주요 메서드 (인터페이스 | .메서드형)

| 메서드 | 설명 | 예시 |
| --- | --- | --- |
| add(E e) | 요소 추가 | list.add("사과") |
| remove(Object o) | 요소 삭제 | list.remove("사과") |
| contains(Object o) | 요소 포함 여부 | list.contains("사과") |
| size() | 요소 개수 반환 | list.size() |
| clear() | 모든 요소 삭제 | list.clear() |
| isEmpty() | 비어있는지 확인 | list.isEmpty() |
| iterator() | 반복자 반환 | for(String s : list) { ... } |
| toArray() | 배열로 변환 (Object\[\]) | list.toArray() |
| toArray(T\[\] a) | 배열로 변환 (제네릭 타입 유지) | list.toArray(new String\[0\]) |

### Collections 주요 메서드 (클래스 static형)

| 메서드 | 설명 | 예시 |
| --- | --- | --- |
| sort(List) | 리스트 정렬 (오름차순) | Collections.sort(list) |
| sort(List, Comparator) | 사용자 정의 정렬 | Collections.sort(list, Comparator.reverseOrder()) |
| reverse(List) | 리스트 요소 뒤집기 | Collections.reverse(list) |
| shuffle(List) | 리스트 무작위 섞기 | Collections.shuffle(list) |
| max(Collection) | 최대값 | Collections.max(list) |
| min(Collection) | 최소값 | Collections.min(list) |
| frequency(Collection, obj) | 특정 요소 빈도 | Collections.frequency(list, "사과") |
| copy(dest, src) | src → dest 복사 | Collections.copy(dest, src) |
| unmodifiableList(list) | 읽기 전용 리스트 반환 | Collections.unmodifiableList(list) |
| synchronizedList(list) | 스레드 안전 리스트 반환 | Collections.synchronizedList(list) |

### Scanner 주요 메서드

```
Scanner sc = new Scanner();
```

| 메서드 | 설명 | 예시 |
| --- | --- | --- |
| next() | 공백 기준 문자열 입력 | sc.next() |
| nextLine() | 한 줄 입력 | sc.nextLine() |
| nextInt() | int 입력 | sc.nextInt() |
| nextDouble() | double 입력 | sc.nextDouble() |
| hasNext() | 입력이 남았는지 확인 | sc.hasNext() |

---

## java.time

### LocalDate (날짜전용)

| 메서드                                          | 설명                                 | 예시                                                     |
| -------------------------------------------- | ---------------------------------- | ------------------------------------------------------ |
| now()                                        | 현재 날짜 반환                           | LocalDate.now() <br>→ 2025-08-29                           |
| of(y,m,d)                                    | 특정 날짜 생성                           | LocalDate.of(2025, 1, 1)                               |
| parse(str)                                   | 문자열을 LocalDate로 변환 (기본 yyyy-MM-dd) | LocalDate.parse("2025-01-01")                          |
| format(fmt)                                  | LocalDate를 문자열로 변환                 | date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")) |
| getYear(), getMonth(), getDayOfMonth()       | 연/월/일 가져오기                         | date.getYear()                                         |
| plusDays(n), plusMonths(n), plusYears(n)     | 날짜 더하기                             | date.plusDays(7)                                       |
| minusDays(n), minusMonths(n)                 | 날짜 빼기                              | date.minusMonths(1)                                    |
| isBefore(date)                               | 날짜 비교 (this < date)                | date1.isBefore(date2)                                  |
| isAfter(date)                                | 날짜 비교 (this > date)                | date1.isAfter(date2)                                   |
| isEqual(date)                                | 날짜 비교 (this == date)               | date1.isEqual(date2)                                   |
| withYear(y), withMonth(m), withDayOfMonth(d) | 특정 필드 변경                           | date.withYear(2030)                                    |
| lengthOfMonth()                              | 해당 월의 일 수                          | date.lengthOfMonth() → 31                              |
| lengthOfYear()                               | 해당 년의 일 수(윤년 체크 가능)                | date.lengthOfYear() → 366                              |


### LocalTime (시간 전용)

| 메서드                                            | 설명                               | 예시                                                  |
| ---------------------------------------------- | -------------------------------- | --------------------------------------------------- |
| now()                                          | 현재 시간 반환                         | LocalTime.now() <br>→ 12:34:56.789                      |
| of(h,m,s)                                      | 특정 시간 생성                         | LocalTime.of(10, 30, 0)                             |
| parse(str)                                     | 문자열을 LocalTime으로 변환 (HH\:mm\:ss) | LocalTime.parse("10:15:30")                         |
| format(fmt)                                    | LocalTime을 문자열로 변환               | time.format(DateTimeFormatter.ofPattern("HH시 mm분")) |
| getHour(), getMinute(), getSecond(), getNano() | 시/분/초/나노 가져오기                    | time.getHour()                                      |
| plusHours(n), minusMinutes(n)                  | 시/분 단위 연산                        | time.plusHours(2)                                   |
| isBefore(time), isAfter(time)                  | 시간 비교                            | time1.isAfter(time2)                                |
| withHour(h), withMinute(m)                     | 특정 필드 변경                         | time.withHour(22)                                   |
| toSecondOfDay()                                | 자정(0시)부터의 초 단위 값                 | time.toSecondOfDay() → 37800                        |


### LocalDateTime (날짜+시간)
| 메서드                                                                         | 설명                                                 | 예시                                                             |
| --------------------------------------------------------------------------- | -------------------------------------------------- |----------------------------------------------------------------|
| now()                                                                       | 현재 날짜·시간 반환                                        | LocalDateTime.now() <br>→ 2025-08-29T12:34:56.789              |
| of(y,m,d,h,m,s)                                                             | 특정 날짜·시간 생성                                        | LocalDateTime.of(2025, 1, 1, 10, 30, 0)                        |
| parse(str)                                                                  | 문자열을 LocalDateTime으로 변환 (기본 yyyy-MM-ddTHH\:mm\:ss) | LocalDateTime.parse("2025-01-01T10:15:30")                     |
| format(fmt)                                                                 | LocalDateTime을 문자열로 변환                             | dt.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH\:mm\:ss")) |
| getYear(), getMonth(), getDayOfMonth(), getHour(), getMinute(), getSecond() | 날짜·시간 필드 가져오기                                      | dt.getYear(), dt.getHour()                                     |
| plusDays(n), plusHours(n)                                                   | 날짜·시간 더하기                                          | dt.plusDays(3), dt.plusHours(5)                                |
| minusMonths(n), minusMinutes(n)                                             | 날짜·시간 빼기                                           | dt.minusMonths(1), dt.minusMinutes(30)                         |
| isBefore(dt), isAfter(dt), isEqual(dt)                                      | 날짜·시간 비교                                           | dt1.isBefore(dt2)                                              |
| withYear(y), withMonth(m), withDayOfMonth(d), withHour(h)                   | 특정 필드 변경                                           | dt.withHour(22)                                                |
| toLocalDate(), toLocalTime()                                                | 날짜·시간 분리                                           | dt.toLocalDate(), dt.toLocalTime()                             |


### Period (날짜 간격 계산)

| 메서드                                      | 설명                    | 예시                     |
| ---------------------------------------- | --------------------- | ---------------------- |
| between(d1, d2)                          | 두 날짜 차이를 `Period`로 반환 | Period.between(d1, d2) |
| getYears(), getMonths(), getDays()       | 년/월/일 단위 반환           | p.getDays()            |
| plusDays(n), plusMonths(n), plusYears(n) | 기간 더하기                | p.plusMonths(2)        |
| minusDays(n), minusMonths(n)             | 기간 빼기                 | p.minusDays(5)         |
| isZero()                                 | 기간이 0인지 확인            | p.isZero()             |
| isNegative()                             | 음수 여부(과거) 확인          | p.isNegative()         |


### Duration (시간 간격 계산)

| 메서드                                  | 설명                            | 예시                       |
| ------------------------------------ | ----------------------------- | ------------------------ |
| between(t1, t2)                      | 두 시간/날짜시간 차이를 `Duration`으로 반환 | Duration.between(t1, t2) |
| ofDays(n), ofHours(n), ofMinutes(n)  | 직접 Duration 생성                | Duration.ofHours(3)      |
| getSeconds(), toMinutes(), toHours() | 단위 변환                         | d.toMinutes()            |
| plusHours(n), plusMinutes(n)         | 시간 더하기                        | d.plusHours(1)           |
| minusHours(n), minusMinutes(n)       | 시간 빼기                         | d.minusMinutes(30)       |
| isZero()                             | 0인지 확인                        | d.isZero()               |
| isNegative()                         | 음수 여부(과거) 확인                  | d.isNegative()           |

### ChronoUnit (간단한 차이 계산 유틸)

| 메서드                     | 설명            | 예시                                 |
| ----------------------- | ------------- | ---------------------------------- |
| DAYS.between(d1, d2)    | 두 날짜의 일수 차이   | ChronoUnit.DAYS.between(d1, d2)    |
| MONTHS.between(d1, d2)  | 두 날짜의 개월 수 차이 | ChronoUnit.MONTHS.between(d1, d2)  |
| YEARS.between(d1, d2)   | 두 날짜의 연도 차이   | ChronoUnit.YEARS.between(d1, d2)   |
| HOURS.between(t1, t2)   | 두 시간의 시 차이    | ChronoUnit.HOURS.between(t1, t2)   |
| MINUTES.between(t1, t2) | 두 시간의 분 차이    | ChronoUnit.MINUTES.between(t1, t2) |

### 관련 예시 (Period / Duration / ChronoUnit 비교)
```java
public class DateTimeExample {
    public static void main(String[] args) {
        // -------------------
        // 1. Period (날짜 간격)
        // -------------------
        LocalDate today = LocalDate.of(2025, 9, 2);
        LocalDate targetDate = LocalDate.of(2026, 1, 10);

        Period period = Period.between(today, targetDate);
        System.out.println("Period 결과: " + period); // P0Y4M8D
        System.out.println("년: " + period.getYears());
        System.out.println("월: " + period.getMonths());
        System.out.println("일: " + period.getDays());
        System.out.println("isNegative(): " + period.isNegative());
        System.out.println();

        // -------------------
        // 2. Duration (시간 간격)
        // -------------------
        LocalTime startTime = LocalTime.of(10, 0, 0);
        LocalTime endTime = LocalTime.of(13, 45, 30);

        Duration duration = Duration.between(startTime, endTime);
        System.out.println("Duration 결과: " + duration); // PT3H45M30S
        System.out.println("총 초(second): " + duration.getSeconds());
        System.out.println("총 분(minute): " + duration.toMinutes());
        System.out.println("isZero(): " + duration.isZero());
        System.out.println();

        // -------------------
        // 3. ChronoUnit (숫자 차이 계산)
        // -------------------
        LocalDateTime startDateTime = LocalDateTime.of(2025, 9, 2, 10, 0);
        LocalDateTime endDateTime = LocalDateTime.of(2025, 9, 3, 15, 30);

        long days = ChronoUnit.DAYS.between(startDateTime, endDateTime);
        long hours = ChronoUnit.HOURS.between(startDateTime, endDateTime);
        long minutes = ChronoUnit.MINUTES.between(startDateTime, endDateTime);

        System.out.println("ChronoUnit DAYS: " + days);      // 1
        System.out.println("ChronoUnit HOURS: " + hours);    // 29
        System.out.println("ChronoUnit MINUTES: " + minutes);// 1770
    }
}
```
```bash
Period 결과: P0Y4M8D
년: 0
월: 4
일: 8
isNegative(): false

Duration 결과: PT3H45M30S
총 초(second): 13530
총 분(minute): 225
isZero(): false

ChronoUnit DAYS: 1
ChronoUnit HOURS: 29
ChronoUnit MINUTES: 1770
```

---

## 컬렉션 프레임워크

### List 주요 메서드

| 메서드 | 설명 | 예시 |
| --- | --- | --- |
| add(E e) | 요소 추가 (마지막에 삽입) | list.add("사과") |
| add(int index, E e) | 특정 위치에 요소 삽입 | list.add(1, "바나나") |
| get(int index) | 해당 인덱스의 요소 반환 | list.get(0) |
| set(int index, E e) | 특정 위치 요소 변경 | list.set(0, "포도") |
| remove(int index) | 특정 인덱스의 요소 삭제 | list.remove(0) |
| remove(Object o) | 해당 객체 삭제 | list.remove("사과") |
| size() | 요소 개수 반환 | list.size() |
| contains(Object o) | 요소 존재 여부 확인 | list.contains("사과") |
| clear() | 모든 요소 삭제 | list.clear() |
| isEmpty() | 비어있는지 확인 | list.isEmpty() |
| indexOf(Object o) | 첫 번째 등장 인덱스 반환 | list.indexOf("사과") |
| lastIndexOf(Object o) | 마지막 등장 인덱스 반환 | list.lastIndexOf("사과") |
| subList(from, to) | 부분 리스트 반환 (from ≤ index < to) | list.subList(1, 3) |
| sort(Comparator) | 리스트 정렬 | list.sort(Comparator.naturalOrder()) |
| replaceAll(UnaryOperator) | 모든 요소 변환 | list.replaceAll(String::toUpperCase) |

### Set 주요 메서드

| 메서드 | 설명 | 예시 |
| --- | --- | --- |
| add(E e) | 요소 추가 (중복 불가) | set.add("사과") |
| remove(Object o) | 해당 요소 삭제 | set.remove("사과") |
| contains(Object o) | 요소 존재 여부 확인 | set.contains("사과") |
| size() | 요소 개수 반환 | set.size() |
| clear() | 모든 요소 삭제 | set.clear() |
| isEmpty() | 비어있는지 확인 | set.isEmpty() |
| iterator() | 순회할 수 있는 반복자 반환 | for(String s : set) { ... } |
| addAll(Collection c) | 다른 컬렉션 요소 모두 추가 | set.addAll(list) |
| retainAll(Collection c) | 교집합 유지 | set.retainAll(otherSet) |
| removeAll(Collection c) | 차집합 유지 | set.removeAll(otherSet) |

### Map 주요 메서드

| 메서드 | 설명 | 예시 |
| --- | --- | --- |
| put(K key, V value) | key-value 추가 (같은 key 있으면 value 교체) | map.put("001", "Kim") |
| get(Object key) | key로 value 조회 (없으면 null) | map.get("001") |
| remove(Object key) | key에 해당하는 엔트리 삭제 | map.remove("001") |
| containsKey(Object key) | 해당 key가 존재하는지 확인 | map.containsKey("001") |
| containsValue(Object v) | 해당 value가 존재하는지 확인 | map.containsValue("Kim") |
| entrySet() | key-value 쌍 집합 반환 → 전체 순회에 사용 | for(Map.Entry<String,String> e : map.entrySet()) { ... } |
| keySet() | key들만 모아서 Set 반환 | for(String k : map.keySet()) { ... } |
| values() | value들만 모아서 Collection 반환 | for(String v : map.values()) { ... } |
| size() | 엔트리 개수 반환 | map.size() |
| clear() | 모든 엔트리 삭제 | map.clear() |
| getOrDefault(key, def) | key 없으면 기본값 반환 | map.getOrDefault("999", "Unknown") |
| putIfAbsent(key, value) | key 없을 때만 삽입 | map.putIfAbsent("002", "Lee") |
| replace(key, value) | 기존 key 값 교체 | map.replace("001", "Choi") |
| replace(key, old, new) | old 값이 일치할 때만 교체 | map.replace("001", "Kim", "Choi") |
| forEach(BiConsumer) | 람다식 순회 | map.forEach((k,v) -> System.out.println(k+":"+v)) |
| merge(key, value, func) | 기존 값과 병합 | map.merge("001", 1, Integer::sum) |
| compute(key, func) | key 기반 값 계산 후 갱신 | map.compute("001", (k,v) -> v+"\_new") |

### Map.Entry 주요 메서드

| 메서드 | 설명 | 예시 |
| --- | --- | --- |
| getKey() | 엔트리의 key 반환 | entry.getKey() |
| getValue() | 엔트리의 value 반환 | entry.getValue() |
| setValue(V value) | 엔트리의 value 변경 (해당 Map에도 반영됨) | entry.setValue("새값") |
| equals(Object o) | 다른 엔트리와 key/value가 같은지 비교 | entry1.equals(entry2) |
| hashCode() | key와 value 기준 해시코드 반환 | entry.hashCode() |
| toString() | `"key=value"` 문자열 반환 | System.out.println(entry) |

Map과 Entry의 관계

-   Map<K, V> : key와 value를 한 쌍으로 저장하는 자료구조
    -   → 예: "학번" → "이름" , "아이디" → "비밀번호"
-   Map.Entry<K,V> : Map 안에 들어가는 **"key-value 쌍 하나"**를 표현하는 객체
    -   → 즉, Map을 이루는 최소 단위

```
Map<String, String> map = new HashMap<>();
map.put("A", "사과");
map.put("B", "바나나");
map.put("C", "체리");

// entrySet() → key-value 쌍 집합 반환
for (Map.Entry<String, String> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " = " + entry.getValue());
}
```

```
# 실행 결과 
A = 사과
B = 바나나
C = 체리
```