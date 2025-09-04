# java.util

```bash
java.util
    ├─ Arrays
    ├─ Collections
    ├─ List             # interface
    │    ├─ ArrayList
    │    └─ LinkedList 
    ├─ Set              # interface
    │    ├─ HashSet
    │    ├─ LinkedHashSet
    │    └─ TreeSet     
    ├─ Map              # interface
    │    ├─ HashMap
    │    ├─ LinkedHashMap
    │    ├─ TreeMap                
    │    └─ Map.Entry   # Map 내부 interface
    └─ ...
```

## 1. Arrays 주요 메서드

| 메서드                    | 설명           | 예시                                                   |
| ---------------------- | ------------ | ---------------------------------------------------- |
| sort(arr)              | 오름차순 정렬      | Arrays.sort(nums)<br>→ \[1, 2, 3]                    |
| sort(arr, comp)        | 사용자 정의 정렬    | Arrays.sort(arr, (a,b)->b-a)<br>→ \[3, 2, 1]         |
| binarySearch(arr, key) | 이진 탐색(정렬 필수) | Arrays.binarySearch(nums, 3)<br>→ 1                  |
| copyOf(arr, n)         | 배열 복사        | Arrays.copyOf(nums, 5)<br>→ \[1, 2, 3, 0, 0]         |
| fill(arr, val)         | 값 채우기        | Arrays.fill(nums, 9)<br>→ \[9, 9, 9]                 |
| equals(a, b)           | 배열 비교        | Arrays.equals(a, b)<br>→ true                        |
| toString(arr)          | 1차원 배열 문자열화  | Arrays.toString(nums)<br>→ "\[1, 2, 3]"              |
| deepToString(arr)      | 다차원 배열 문자열화  | Arrays.deepToString(twoD)<br>→ "\[\[1, 2], \[3, 4]]" |
| asList(e…)             | 배열을 리스트 뷰로   | Arrays.asList("a","b")<br>→ \[a, b]                  |


```java
import java.util.Arrays;
import java.util.Comparator;

public class ArraysExample {
    public static void main(String[] args) {
        // 심플 ----------------
        int[] nums = {3, 1, 2};

        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        // [1, 2, 3]

        int idx = Arrays.binarySearch(nums, 2);
        System.out.println("2의 인덱스: " + idx);
        // 2의 인덱스: 1

        int[] copy = Arrays.copyOf(nums, 5);
        System.out.println(Arrays.toString(copy));
        // [1, 2, 3, 0, 0]

        Arrays.fill(nums, 9);
        System.out.println(Arrays.toString(nums));
        // [9, 9, 9]

        // 응용 ----------------
        // 1. 내림차순 정렬
        Integer[] arr = {5, 2, 9, 1};
        Arrays.sort(arr, Comparator.reverseOrder());
        System.out.println("내림차순: " + Arrays.toString(arr));
        // 내림차순: [9, 5, 2, 1]

        // 2. 2차원 배열 출력
        int[][] grid = {
            {1,2},{3,4}
        };
        System.out.println(Arrays.deepToString(grid));
        // [[1, 2], [3, 4]]

        // 3. asList (고정 크기 리스트)
        var listView = Arrays.asList("a","b","c");
        System.out.println("asList 뷰: " + listView);
        // asList 뷰: [a, b, c]
    }
}
```

---

## 2. Collections 주요 메서드

| 메서드                    | 설명          | 예시                                        |
| ---------------------- | ----------- | ----------------------------------------- |
| sort(list)             | 정렬          | Collections.sort(list)<br>→ \[a, b, c]    |
| reverse(list)          | 역순          | Collections.reverse(list)<br>→ \[c, b, a] |
| shuffle(list)          | 무작위 섞기      | Collections.shuffle(list)<br>→ \[b, a, c] |
| max/min(list)          | 최대/최소       | Collections.max(list)<br>→ c              |
| frequency(list, x)     | 빈도수         | Collections.frequency(list,"a")<br>→ 2    |
| copy(dst, src)         | dst에 src 복사 | Collections.copy(dst, src)                |
| unmodifiableList(list) | 불변 리스트 뷰    | Collections.unmodifiableList(list)        |


```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsExample {
    public static void main(String[] args) {
        // 심플 ----------------
        List<String> list = new ArrayList<>(Arrays.asList("b","a","c"));

        Collections.sort(list);
        System.out.println("정렬: " + list);
        // 정렬: [a, b, c]

        Collections.reverse(list);
        System.out.println("역순: " + list);
        // 역순: [c, b, a]

        Collections.shuffle(list);
        System.out.println("셔플: " + list);
        // 셔플: 실행할 때마다 달라짐

        System.out.println("최대값: " + Collections.max(list));
        // 최대값: c
        System.out.println("빈도: " + Collections.frequency(list,"a"));
        // 빈도: 1

        // 응용 ----------------
        // 1. 불변 리스트
        List<String> unmod = Collections.unmodifiableList(list);
        System.out.println("불변 리스트: " + unmod);
        // 불변 리스트: [c, b, a]

        // 2. copy 사용
        List<String> src = Arrays.asList("x","y","z");
        List<String> dst = new ArrayList<>(Arrays.asList("","",""));
        Collections.copy(dst, src);
        System.out.println("copy 결과: " + dst);
        // copy 결과: [x, y, z]
    }
}
```

---

## 3. List (ArrayList) 주요 메서드

| 메서드         | 설명     | 예시                                |
| ----------- | ------ | --------------------------------- |
| add(x)      | 요소 추가  | list.add("a")<br>→ \[a]           |
| add(i, x)   | 인덱스 삽입 | list.add(1,"b")<br>→ \[a, b]      |
| get(i)      | 요소 조회  | list.get(0)<br>→ a                |
| set(i, x)   | 값 변경   | list.set(0,"z")<br>→ \[z, b]      |
| remove(i/x) | 삭제     | list.remove(0) / list.remove("a") |
| size()      | 크기     | list.size()<br>→ 2                |
| contains(x) | 포함 여부  | list.contains("a")<br>→ true      |
| indexOf(x)  | 처음 위치  | list.indexOf("a")<br>→ 0          |
| isEmpty()   | 비었는지   | list.isEmpty()<br>→ false         |


```java
import java.util.ArrayList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        // 심플 ----------------
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        System.out.println(list);
        // [a, b]

        list.add(1,"c");
        System.out.println(list);
        // [a, c, b]

        System.out.println(list.get(0));
        // a

        list.set(0,"z");
        System.out.println(list);
        // [z, c, b]

        list.remove(1);
        System.out.println(list);
        // [z, b]

        // 응용 ----------------
        // 1. 반복문 순회
        for(String s : list){
            System.out.println("요소: " + s);
        }
        // 요소: z
        // 요소: b

        // 2. 조건 검색
        if(list.contains("b")){
            System.out.println("b 포함됨");
            // b 포함됨
        }
    }
}

```

---

## 4. Set (HashSet) 주요 메서드

| 메서드         | 설명         | 예시                          |
| ----------- | ---------- | --------------------------- |
| add(x)      | 추가 (중복 무시) | set.add("a")<br>→ \[a]      |
| remove(x)   | 삭제         | set.remove("a")<br>→ \[]    |
| contains(x) | 포함 여부      | set.contains("a")<br>→ true |
| size()      | 크기         | set.size()<br>→ 1           |
| isEmpty()   | 비었는지       | set.isEmpty()<br>→ false    |
| clear()     | 전체 삭제      | set.clear()<br>→ \[]        |


```java
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        // 심플 ----------------
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("a"); // 중복 무시
        System.out.println(set);
        // [a, b]

        set.remove("a");
        System.out.println(set);
        // [b]

        System.out.println(set.contains("b"));
        // true

        // 응용 ----------------
        // 1. 중복 제거
        java.util.List<String> dup = Arrays.asList("a","b","a","c");
        Set<String> unique = new HashSet<>(dup);
        System.out.println("중복 제거: " + unique);
        // 중복 제거: [a, b, c]

        // 2. 교집합
        Set<String> s1 = new HashSet<>(Arrays.asList("a","b","c"));
        Set<String> s2 = new HashSet<>(Arrays.asList("b","c","d"));
        s1.retainAll(s2);
        System.out.println("교집합: " + s1);
        // 교집합: [b, c]
    }
}
```

---

## 5. Map (HashMap) 주요 메서드

| 메서드                  | 설명       | 예시                             |
| -------------------- | -------- | ------------------------------ |
| put(k,v)             | 키-값 추가   | map.put("a",1)<br>→ {a=1}      |
| get(k)               | 값 조회     | map.get("a")<br>→ 1            |
| remove(k)            | 삭제       | map.remove("a")<br>→ {}        |
| containsKey(k)       | 키 존재     | map.containsKey("a")<br>→ true |
| containsValue(v)     | 값 존재     | map.containsValue(1)<br>→ true |
| keySet()             | 키 집합     | map.keySet()<br>→ \[a]         |
| values()             | 값 모음     | map.values()<br>→ \[1]         |
| entrySet()           | 키-값 쌍    | map.entrySet()<br>→ \[a=1]     |
| size()               | 크기       | map.size()<br>→ 1              |
| clear()              | 전체 삭제    | map.clear()<br>→ {}            |
| getOrDefault(k, def) | 기본값 반환   | map.getOrDefault("x",0)<br>→ 0 |
| putIfAbsent(k,v)     | 없을 때만 추가 | map.putIfAbsent("a",1)         |

```java
import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        // 심플 ----------------
        Map<String,Integer> map = new HashMap<>();
        map.put("a",1);
        map.put("b",2);
        System.out.println(map);
        // {a=1, b=2}

        System.out.println(map.get("a"));
        // 1

        map.remove("a");
        System.out.println(map);
        // {b=2}

        System.out.println(map.containsKey("b"));
        // true
        System.out.println(map.containsValue(2));
        // true

        // 응용 ----------------
        map.clear();
        map.put("a",1);
        map.put("b",2);

        // 1. 반복문 순회
        for(Map.Entry<String,Integer> e : map.entrySet()){
            System.out.println(e.getKey() + "=" + e.getValue());
        }
        // a=1 
        // b=1

        // 2. 카운팅 예제
        String text = "hello world";
        Map<Character,Integer> counter = new HashMap<>();
        for(char c : text.toCharArray()){
            counter.put(c, counter.getOrDefault(c,0)+1);
        }
        System.out.println("문자 빈도: " + counter);
        // 문자 빈도: { =1, r=1, d=1, e=1, w=1, h=1, l=3, o=2}
        // =1 이부분은 공백

        // 3. putIfAbsent
        Map<String,String> config = new HashMap<>();
        config.putIfAbsent("mode","dev");
        config.putIfAbsent("mode","prod"); // 무시됨
        System.out.println("config: " + config);
        // config: {mode=dev}
    }
}

```

---

## 6. Map.Entry 주요 메서드

| 메서드         | 설명                | 예시                       |
| ----------- | ----------------- | ------------------------ |
| getKey()    | 엔트리의 키 반환         | entry.getKey()           |
| getValue()  | 엔트리의 값 반환         | entry.getValue()         |
| setValue(v) | 값 수정              | entry.setValue(100)      |
| equals(o)   | 키와 값이 모두 같으면 true | entry.equals(otherEntry) |
| hashCode()  | 키와 값의 해시코드        | entry.hashCode()         |

```java
import java.util.HashMap;
import java.util.Map;

public class MapEntryExample {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Kim", 90);
        scores.put("Lee", 85);
        scores.put("Park", 95);

        // entrySet()으로 순회
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        // Kim = 90
        // Lee = 85
        // Park = 95

        // setValue로 값 수정
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            if (entry.getKey().equals("Lee")) {
                entry.setValue(100);
            }
        }
        System.out.println("수정 후: " + scores);
        // 수정 후: {Kim=90, Lee=100, Park=95}
    }
}

```