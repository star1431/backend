# java.leng

```bash
java.leng
    ├─ Sysytem
    ├─ Math
    ├─ String
    ├─ StringBuilder
    ├─ StringBuffer
    └─ ...
```

## 1. Sysytem 주요 메서드

| 메서드 / 필드                              | 설명                   | 예시                                    |
| ------------------------------------- | -------------------- | ------------------------------------- |
| out                                   | 표준 출력 스트림            | System.out.println("Hello");          |
| in                                    | 표준 입력 스트림            | int ch = System.in.read();            |
| err                                   | 표준 에러 출력 스트림         | System.err.println("Error!");         |
| currentTimeMillis()                   | 1970-01-01 이후 ms     | System.currentTimeMillis()            |
| nanoTime()                            | 고해상도 시간 (ns)         | System.nanoTime()                     |
| getenv(key)                           | 환경 변수 가져오기           | System.getenv("PATH")                 |
| getProperty(key)                      | JVM 속성 가져오기          | System.getProperty("user.dir")        |
| setProperty(k, v)                     | JVM 속성 설정            | System.setProperty("mode","dev")      |
| arraycopy(src, sPos, dest, dPos, len) | 배열 복사                | System.arraycopy(arr1, 0, arr2, 0, 3) |
| gc()                                  | Garbage Collector 요청 | System.gc()                           |
| exit(status)                          | JVM 종료               | System.exit(0)                        |


```java
public class SystemExample {
    public static void main(String[] args) throws Exception {
        // 심플 ----------------
        System.out.println("표준 출력");   // 표준 출력
        System.err.println("에러 출력");   // 에러 출력 (빨간 글씨)

        long ms = System.currentTimeMillis();
        System.out.println("현재 ms: " + ms);

        long ns = System.nanoTime();
        System.out.println("현재 ns: " + ns);

        // 응용 ----------------
        // 1. 배열 복사
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = new int[5];
        System.arraycopy(arr1, 0, arr2, 0, arr1.length);
        System.out.println("배열 복사 결과: " + java.util.Arrays.toString(arr2));
        // 배열 복사 결과: [1, 2, 3, 4, 5]

        // 2. 환경 변수 가져오기
        String path = System.getenv("PATH");
        System.out.println("환경 변수 PATH: " + path);

        // 3. 시스템 속성
        System.out.println("현재 사용자: " + System.getProperty("user.name"));
        System.out.println("현재 디렉토리: " + System.getProperty("user.dir"));

        // 4. 실행 시간 측정
        long start = System.nanoTime();
        for(int i=0;i<1000000;i++){} // dummy loop
        long end = System.nanoTime();
        System.out.println("실행 시간(ns): " + (end-start));

        // 5. 프로그램 종료
        // System.exit(0); // 실제 실행 시 JVM 종료됨
    }
}
```

---

## 2. Math 주요 메서드

| 메서드       | 설명            | 예시                           |
| --------- | ------------- | ---------------------------- |
| abs(x)    | 절댓값           | Math.abs(-5)<br>→ 5          |
| max(a, b) | 큰 값           | Math.max(10, 20)<br>→ 20     |
| min(a, b) | 작은 값          | Math.min(10, 20)<br>→ 10     |
| pow(a, b) | 거듭제곱          | Math.pow(2,3)<br>→ 8.0       |
| sqrt(x)   | 제곱근           | Math.sqrt(16)<br>→ 4.0       |
| round(x)  | 반올림           | Math.round(3.6)<br>→ 4       |
| ceil(x)   | 올림            | Math.ceil(3.1)<br>→ 4.0      |
| floor(x)  | 내림            | Math.floor(3.9)<br>→ 3.0     |
| random()  | 0.0 \~ 1.0 난수 | Math.random()<br>→ 0.1234... |


```java
public class MathExample {
    public static void main(String[] args) {
        // 심플  ----------------
        System.out.println(Math.abs(-10));   // 10
        System.out.println(Math.max(5, 8));  // 8
        System.out.println(Math.min(5, 8));  // 5
        System.out.println(Math.pow(2, 3));  // 8.0
        System.out.println(Math.sqrt(16));   // 4.0
        System.out.println(Math.round(3.6)); // 4
        System.out.println(Math.ceil(3.1));  // 4.0
        System.out.println(Math.floor(3.9)); // 3.0
        System.out.println(Math.random());   // 0.0 이상 1.0 미만

        // 응용 ----------------
        // 1. 좌표 거리 계산 (피타고라스)
        int x1 = 3, y1 = 4, x2 = 7, y2 = 1;
        double dist = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        System.out.println("좌표 거리: " + dist);
        // 좌표 거리: 5.0

        // 2. 페이지 계산 (총 데이터 103개 → 페이지 수)
        int total = 103, pageSize = 10;
        int totalPages = (int)Math.ceil(total / (double)pageSize);
        System.out.println("총 페이지 수: " + totalPages);
        // 총 페이지 수: 11

        // 3. 금액 절삭 (100원 단위 내림)
        int amount = 12347;
        int truncated = (int)Math.floor(amount / 100.0) * 100;
        System.out.println("100원 단위 절삭: " + truncated);
        // 100원 단위 절삭: 12300

        // 4. 로또 번호 (1~45 난수)
        int lotto = (int)(Math.random() * 45) + 1;
        System.out.println("랜덤 로또 번호: " + lotto);
        // 랜덤 로또 번호: 실행할 때마다 달라짐 (예: 27)

        // 5. 특정 범위 난수 (10~20)
        int min = 10, max = 20;
        int randRange = (int)(Math.random() * (max - min + 1)) + min;
        System.out.println("10~20 범위 난수: " + randRange);
        // 10~20 범위 난수: 실행할 때마다 달라짐 (예: 14)

        // 6. 배열 랜덤 선택
        String[] colors = {"red", "green", "blue"};
        String pick = colors[(int)(Math.random() * colors.length)];
        System.out.println("랜덤 색상 선택: " + pick);
        // 랜덤 색상 선택: 실행할 때마다 달라짐 (예: green)
    }
}
```

---

## 3. String 주요 메서드

| 메서드                   | 설명           | 예시                                        |
| --------------------- | ------------ | ----------------------------------------- |
| length()              | 문자열 길이 반환    | "hello".length()<br>→ 5                   |
| charAt(i)             | i번째 문자 반환    | "java".charAt(2)<br>→ 'v'                 |
| substring(s, e)       | 부분 문자열 추출    | "program".substring(0, 3)<br>→ "pro"      |
| indexOf(str)          | 문자열 검색 (앞)   | "banana".indexOf("na")<br>→ 2             |
| lastIndexOf(str)      | 문자열 검색 (뒤)   | "banana".lastIndexOf("na")<br>→ 4         |
| contains(str)         | 포함 여부 확인     | "hello".contains("he")<br>→ true          |
| equals(str)           | 문자열 비교       | "abc".equals("abc")<br>→ true             |
| equalsIgnoreCase(str) | 대소문자 무시 비교   | "Java".equalsIgnoreCase("java")<br>→ true |
| toUpperCase()         | 대문자로 변환      | "java".toUpperCase()<br>→ "JAVA"          |
| toLowerCase()         | 소문자로 변환      | "JAVA".toLowerCase()<br>→ "java"          |
| trim()                | 앞뒤 공백 제거     | " hi ".trim()<br>→ "hi"                   |
| replace(a, b)         | 치환           | "apple".replace("p","x")<br>→ "axxle"     |
| split(regex)          | 구분자로 분리 → 배열 | "a,b,c".split(",")<br>→ \["a","b","c"]    |
| join(delim, arr)      | 배열 요소 연결     | String.join("-", "a","b")<br>→ "a-b"      |
| valueOf(x)            | 기본형 → 문자열    | String.valueOf(100)<br>→ "100"            |
| isEmpty()             | 길이 0 확인      | "".isEmpty()<br>→ true                    |
| isBlank() (Java 11+)  | 공백 포함 여부     | " ".isBlank()<br>→ true                   |


```java
public class StringExample {
    public static void main(String[] args) {
        // 심플 ----------------
        String str = " Hello Java ";
        System.out.println(str.length());           // 12
        System.out.println(str.charAt(6));          // J
        System.out.println(str.substring(1, 6));    // Hello
        System.out.println(str.indexOf("Java"));    // 7
        System.out.println(str.lastIndexOf("a"));   // 10
        System.out.println(str.contains("Java"));   // true
        System.out.println("abc".equals("ABC"));    // false
        System.out.println("abc".equalsIgnoreCase("ABC")); // true
        System.out.println(str.toUpperCase());      //  HELLO JAVA 
        System.out.println(str.toLowerCase());      //  hello java 
        System.out.println(str.trim());             // Hello Java
        System.out.println("apple".replace("p","x"));// axxle
        String[] arr = "a,b,c".split(",");
        System.out.println(arr[0] + arr[1] + arr[2]); // abc
        System.out.println(String.join("-", "a","b","c")); // a-b
        System.out.println(String.valueOf(100));    // 100
        System.out.println("".isEmpty());           // true
        System.out.println(" ".isBlank());          // true (Java 11+)

        // 응용 ----------------
        // 1. 파일 경로에서 확장자 추출
        String file = "report.pdf";
        String ext = file.substring(file.lastIndexOf(".") + 1);
        System.out.println("파일 확장자: " + ext);
        // 파일 확장자: pdf

        // 2. 전화번호 포맷 변경
        String phone = "01012345678";
        String formatted = phone.substring(0,3) + "-" + phone.substring(3,7) + "-" + phone.substring(7);
        System.out.println("전화번호: " + formatted);
        // 전화번호: 010-1234-5678

        // 3. 회원 아이디 마스킹
        String userId = "superman";
        String masked = userId.substring(0,2) + "****";
        System.out.println("마스킹 아이디: " + masked);
        // 마스킹 아이디: su****
    }
}
```

---

## 4. StringBuilder / StringBuffer 주요 메서드

| 메서드          | 설명           | 예시                                            |
| ------------ | ------------ | --------------------------------------------- |
| append(x)    | 문자열 뒤에 추가    | sb.append("hi").append(1)<br>→ "hi1"          |
| insert(i, x) | 특정 위치에 삽입    | sb.insert(1,"-")<br>→ "h-i"                   |
| delete(s, e) | s\~e-1 범위 삭제 | sb.delete(0,2)<br>→ ...                       |
| reverse()    | 문자열 뒤집기      | new StringBuilder("abc").reverse()<br>→ "cba" |
| toString()   | 문자열 변환       | sb.toString()<br>→ "..."                      |


```java
public class StringBuilderExample {
    public static void main(String[] args) {
        // 심플 ----------------
        StringBuilder sb = new StringBuilder("Java");

        sb.append(" World");
        System.out.println(sb); // Java World

        sb.insert(4, "-");
        System.out.println(sb); // Java- World

        sb.delete(4, 6);
        System.out.println(sb); // JavaWorld

        sb.reverse();
        System.out.println(sb); // dlroWavaJ

        // 응용 ----------------
        // 1. 문자열 반복 합치기 (성능 좋음)
        StringBuilder numbers = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            numbers.append(i).append(",");
        }
        System.out.println("숫자 목록: " + numbers);
        // 숫자 목록: 1,2,3,4,5,

        // 2. 로그 메시지 생성
        String action = "LOGIN";
        String user = "kim";
        StringBuilder log = new StringBuilder();
        log.append("User[").append(user).append("] Action[").append(action).append("]");
        System.out.println(log.toString());
        // User[kim] Action[LOGIN]

        // 3. StringBuffer (멀티스레드 환경)
        StringBuffer sbf = new StringBuffer("Sync");
        sbf.append(" Test");
        System.out.println(sbf);
        // Sync Test
    }
}
```