package week_03._0828.test;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
//import java.util.HashMap;
import java.util.LinkedHashMap;


public class TestExam {
    public static void main(String[] args) {
        // Person 여러명 저장
        Person p1 = new Person("김ㅇㅇ", "서울", "A1001", "010-0001-0001");
        Person p2 = new Person("이ㅇㅇ", "경기", "A1002", "010-0002-0002");
        Person p3 = new Person("정ㅇㅇ", "부산", "A1003", "010-0003-0003");
        Person p4 = new Person("황ㅇㅇ", "제주", "A1004", "010-0004-0004");
        Person p5 = new Person("배ㅇㅇ", "대전", "A1005", "010-0005-0005");

        // 1. List 담기
        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        System.out.println("List size: " + list.size());

        // 2. Set 담기
        // HashSet 에 Collection을 받는 생성자가 있기 때문에 list 넣을 수 있음.
        Set<Person> set = new HashSet<>(list);
        System.out.println("Set size: " + set.size());

        // 3. Map 담기 (LinkedHashMap : 순서보장)
        Map<String, Person> map = new LinkedHashMap<>();
        for (Person p : list) {
            map.put(p.getId(), p);
        }
        System.out.println("Map size: " + map.size());

        System.out.println("-".repeat(10));
        
        // 4. list 내 특정 id 가진 객체 뽑기
        for (Person p : list) {
            if (p.getId().equals("A1003")) {
                System.out.println(p);
                break;
            }
        }

        // 5. set 내 특정 id 가진 객체 뽑기
        for (Person p : set) {
            if (p.getId().equals("A1001")) {
                System.out.println(p);
                break;
            }
        }

        // 6. map 내 특정 id 가진 객체 뽑기
        Person p = map.get("A1005");
        System.out.println(p);
    }
}
