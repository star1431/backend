package week_03._0828;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.Objects;
import java.util.Collection;
import java.util.Map.Entry;

class Pen {
    String color;

    Pen(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color + " Pen";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pen pen = (Pen) o;
        return Objects.equals(color, pen.color);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(color);
    }
}

public class collectionExam {
    public static void main(String[] args) {
        collectionExam obj = new collectionExam();
        // obj.exam00(); // 어레이리스트
        // obj.exam01(); // 리스트 메서드 활용
        // obj.exam02(); // set 사용
        obj.exam03(); // Map 사용
    }

    public void exam00() {
        System.out.println("exam00 : 어레이리스트");

        // 1. <> 제네릭 사용없이 하면 자료꺼낼때 형변환 강제로 해야되는 단점을 가짐.
        ArrayList list1 = new ArrayList();
        list1.add(1);
        list1.add(" 123 ");
        list1.add(new Exam());
        // list1.get(1).trim(); // 부모타입으로 자식 접근 안됨
        String _test = ((String)list1.get(1)).trim();
        System.out.println("제네릭없는 Array get(1)\n" + _test);

        System.out.println("-".repeat(8));

        // 2. <> 제네릭 사용
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("123");
        // list2.add(11); // 스트링 선언으로 정수타입 삽입 불가능
        list2.add("안녕");
        list2.add("하세요!");
        list2.add("삭제해보기");

        System.out.println("list2 배열:" + Arrays.toString(list2.toArray()));
        System.out.println("list2 랭스:" + list2.size());

        list2.remove("삭제해보기"); // 또는 list2.remove(3);
        System.out.println("list2 삭제후 배열:" + list2);

        System.out.println("-".repeat(8));

        // 3. 이터레이터 써보기
        ArrayList<String> list3 = new ArrayList<>();
        list3.add("abc");
        list3.add("def");
        Iterator<String> iter3 = list3.iterator();

        System.out.println("hasNext()로 출력");
        while (iter3.hasNext()) {
            System.out.println(iter3.next());
        }

        System.out.println("향상된for문으로 출력");
        for (String item : list3) {
            System.out.println(item);
        }


        System.out.println("-".repeat(8));


        System.out.println("ㅡ".repeat(8));
    }
    
    public void exam01() {
        System.out.println("exam01 : 리스트 메서드 활용");

        List<String> list1 = new ArrayList<>();

        // 요소 추가
        String[] arr1 = {"수박", "바나나", "포도", "귤"};
        list1.add("사과");
        list1.addAll(Arrays.asList(arr1));

        System.out.println("추가 - list1 배열: " + list1); // [사과, 수박, 바나나, 포도, 귤]

        // 요소 변경
        list1.set(1, "사과");
        System.out.println("변경 - list1 배열: " + list1); // [사과, 사과, 바나나, 포도, 귤]


        // 요소 삭제
        list1.remove(2);
        list1.remove("포도");
        System.out.println("삭제 - list1 배열: " + list1); // [사과, 사과, 귤]

        // 인덱스 확인
        System.out.println("귤 인덱스: " + list1.indexOf("귤")); // 2

        System.out.println("ㅡ".repeat(8));
    }

    public void exam02() {
        System.out.println("exam02 : set 사용");

        Set<String> set1 = new HashSet<>();
        set1.add("볼펜");
        set1.add("샤프");
        set1.add("연필");
        set1.add("볼펜");
        set1.add("샤프");
        set1.add("연필");
        
        // set은 중복 제거함
        System.out.println("set1 배열: " + set1);

        // set 객체 담기
        Set<Pen> set2 = new HashSet<>();
        set2.add(new Pen("red"));
        set2.add(new Pen("blue"));
        set2.add(new Pen("red"));
        set2.add(new Pen("RED"));

        System.out.println("set2 배열: " + set2); // [red Pen, RED Pen, blue Pen]
        
        // [TIP] equals, hashCode 오버라이딩 안하면 주소값 비교해서 중복제거 안됨!


        System.out.println("blue Pen ? : " + set2.contains(new Pen("blue"))); // true

        System.out.println("ㅡ".repeat(8));
    }
    
    public void exam03() {
        System.out.println("exam03 : Map 사용");

        Map<String, String> addrMap = new HashMap<>();

        addrMap.put("홍길동", "서울");
        addrMap.put("철수", "경기");
        addrMap.put("영희", "부산");

        // 특정 키값 검색
        System.out.println("홍길동 지역: " + addrMap.get("홍길동"));

        // 키값 뽑기
        Set<String> keys = addrMap.keySet();
        System.out.println("키값들: " + keys);

        // 벨류값 뽑기
        Collection<String> values = addrMap.values();
        System.out.println("벨류값들: " + values);

        // 전체 map 출력 toString
        System.out.println("전체 map 출력: " + addrMap);

        // 제거
        addrMap.remove("철수");
        System.out.println("철수 제거 후 전체 map 출력: " + addrMap);

        // Map<String, Integer> map = Map.of(
        //     "apple", 1000,
        //     "banana", 2000,
        //     "grape", 3000
        // );

        // System.out.println("map 배열: " + map);
        // System.out.println("apple 가격: " + map.get("apple"));

        System.out.println("ㅡ".repeat(8));
    }
}
