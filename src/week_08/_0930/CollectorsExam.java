package week_08._0930;
import java.util.*;
import java.util.stream.Collectors;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    @Override
    public String toString() {
        return "\n Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

public class CollectorsExam {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("신짱구", 30),
                new Person("김철수", 25),
                new Person("이유리", 30),
                new Person("이유리", 30)
                );

        // toList() - 리스트로 수집
        List<Person> list =
                people.stream()
                    .filter(p -> p.getAge() >= 30)
                    .collect(Collectors.toList());
        System.out.println("[List] 30세 이상: " + list);

        // toSet() - 집합으로 수집 (중복제거)
        Set<Person> set =
                people.stream()
                    .collect(Collectors.toSet());
        System.out.println("[Set] 전체(중복빠짐): " + set);

        // toMap() - 맵으로 수집 (키-값 쌍)
        Map<String, Person> map =
                people.stream()
                    .collect(Collectors.toMap(
                            Person::getName, // 키: 이름
                            p -> p,         // 값: Person 객체
                            (existing, replacement) -> existing // 중복키 처리
                    ));

        System.out.println("[Map] 이름-객체 쌍: " + map);
    }
}