package week_03._0826._exam;
import java.util.Arrays;

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // equals() : 오브젝트 공통 메서드 - 문자열 비교
    @Override
    public boolean equals(Object obj) {

        // 자기 자신과 비교일 경우 바로 true
        if (this == obj) return true;

        // 비교 대상이 null 이거나, 클래스 타입이 다르면 false
        if (obj == null || getClass() != obj.getClass()) return false;

        // 타입이 같다면 명시적 형변환
        // 형변환 하는 이유는 Object 타입으로 매개변수를 받고 있기 때문
        Person person = (Person) obj;

        // 나이와 이름이 모두 같으면 true, 하나라도 다르면 false
        return (age == person.age) && name.equals(person.name);
    }

    // toString() : 오브젝트메서드 - 문자열로 표현
    @Override
    public String toString() {
        return "Person = {name='" + name + "', age=" + age + "}";
    }
}

class ObjExam2 {
    public static void main(String[] args) {
        Person p1 = new Person("홍길동", 10);
        Person p2 = new Person("홍길동", 10);
        Person p3 = new Person("홍길동", 20);

        String a = "123";
        String b = "123";
        Integer  x = 100;
        Integer  y = 100;
        System.out.println(x.equals(y));

        // epuals : 문자열 비교 boolean 반환
        System.out.println(a.equals(b));  // true

        // epuals 오버라이딩된 부분 사용 예시
        System.out.println(p1 == p2);       // false (주소 비교)
        System.out.println(p1.equals(p2));  // true  (값 비교)
        System.out.println(p1.equals(p3));  // false


        int[] arr = {1, 2, 3, 4, 5};
        // toString : 문자열로 표현
        System.out.println(Arrays.toString(arr));  // [1, 2, 3, 4, 5]
        
        // toString 오버라이딩된 부분 사용 예시
        System.out.println(p1.toString());  // Person = {name='홍길동', age=10}
        System.out.println(p3.toString());  // Person = {name='홍길동', age=20}

        System.out.println(p2);  // Person = {name='홍길동', age=10}
    }
}