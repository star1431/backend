package week_03._0827;
import java.util.Arrays;
import java.util.Objects;

class Person implements Cloneable {
    private String name;
    private int age;
    private int[] scores;

    public Person(String name, int age, int[] scores) {
        this.name = name;
        this.age = age;
        this.scores = scores;
    }

    public int[] getScores() {
        return scores;
    }

    // 1. toString() : 객체를 문자열로 표현
    @Override
    public String toString() {
        // Objects.toStringHelper 같은 건 없음 → 직접 포맷 작성
        return "Person{name='" + name + "', age=" + age +
                ", scores=" + Arrays.toString(scores) + "}";
    }

    // 2. equals() : 내용 비교 (Objects.equals 사용으로 NPE 방지)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Arrays.equals(scores, person.scores);
    }

    // 3. hashCode() : Objects.hash 사용
    @Override
    public int hashCode() {
        // return Objects.hash(name, age); // 배열없을때
        int result = Objects.hash(name, age);
        result = 31 * result + Arrays.hashCode(scores);
        return result;
    }

    // 4. clone() : 얕은 복제
    // throws : 예외 발생 키워드
    // CloneNotSupportedException :  clone() 메서드를 사용할 때 발생할 수 있는 체크 예외
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    // 깊은 복사
    protected Person deepCopy() {
        // scores 배열도 새로 복사
        return new Person(this.name, this.age, this.scores.clone());
    }
}

public class ObjectMethodTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};
        String name = "홍길동";

        Person p1 = new Person(name, 10, arr1);
        Person p2 = new Person(name, 10, arr1);
        Person p3 = new Person("이순신", 50, arr2);

        // toString()
        System.out.println(p1.toString());  // Person{name='홍길동', age=10}
        System.out.println(p1);             // toString() 자동 호출

        // equals()
        System.out.println(p1.equals(p2));  // true (내용 같음)
        System.out.println(p1.equals(p3));  // false (내용 다름)

        // hashCode()
        System.out.println(p1.hashCode());  // p1과 p2는 같은 해시코드
        System.out.println(p2.hashCode());
        System.out.println(p3.hashCode());  // p3은 다른 해시코드

        // clone()
        Person p4 = (Person) p1.clone();    // p1 복제
        System.out.println(p4);             // Person{name='홍길동', age=10}
        System.out.println(p1 == p4);       // false (객체는 다름)
        System.out.println(p1.equals(p4));  // true (내용 같음)

        // 깊은복사
        Person p5 = p1.deepCopy();          // p1을 깊은 복사하여 독립된 객체 생성
        arr1[0] = 10;

        System.out.println("원본 변경 후 비교");
        System.out.println("p1 : " + p1);  // p1 : Person{name='홍길동', age=10, scores=[10, 2, 3]}
        System.out.println("p4 : " + p4);  // p4 : Person{name='홍길동', age=10, scores=[10, 2, 3]}
        System.out.println("p5 : " + p5);  // p5 : Person{name='홍길동', age=10, scores=[1, 2, 3]}
    }
}