package week_04._0902;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// 테스트용 Comparable
class TestPerson implements Comparable<TestPerson> {
    private String name;
    private int age;

    public TestPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    @Override
    public int compareTo(TestPerson o) {
        // Comparable 인터페이스 오버라이딩
        return this.age - o.age; // 나이기준
        //return this.name.compareTo(o.name); // 이름기준
    }

    @Override
    public String toString() {
        return "\nTestPerson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                "}";
    }
}

public class ExamCollections {
    public static void main(String[] args) {
        List<TestPerson> list1 = new ArrayList<>();

        list1.add(new TestPerson("안녕", 1));
        list1.add(new TestPerson("가나", 30));
        list1.add(new TestPerson("다라", 10));
        list1.add(new TestPerson("마바", 20));

        // 내부 오버라이딩시 - 나이기준으로 기준 정의됨 ---------------------
        Collections.sort(list1);
        System.out.println("내부 compareTo: " + list1);
        System.out.println("─".repeat(30));

        List<TestPerson> list2 = new ArrayList<>();
        list2.add(new TestPerson("홍길동", 50));
        list2.add(new TestPerson("김철수", 30));

        // 내부 익명 예시 (Comparator) ---------------------
        Collections.sort(list2, new Comparator<TestPerson>() {
            @Override
            public int compare(TestPerson o1, TestPerson o2) {
                return o1.getName().compareTo(o2.getName()); // 이름순 기준
            }
        });
        System.out.println("list2 Comparator: " + list2);
        System.out.println("─".repeat(30));

        // 람다 - 나이 기준 정렬 (compare) ---------------------
        Collections.sort(list1, (a, b) -> Integer.compare(a.getAge(), b.getAge()));
        System.out.println("람다-나이: " + list1);
        System.out.println("─".repeat(30));


        // 람다 - 이름 기준 정렬 (compareTo) ---------------------
        Collections.sort(list1, (a, b) -> a.getName().compareTo(b.getName()));
        System.out.println("람다-이름: " + list1);
        System.out.println("─".repeat(30));

        // 컴페어투 확인
        System.out.println("'가,나' 비교: " + "가".compareTo("나")); // -1176
        System.out.println("'나,가' 비교: " + "나".compareTo("가")); // 1176
        System.out.println("'B,A' 비교: " + "B".compareTo("A")); // 1
    }
}
