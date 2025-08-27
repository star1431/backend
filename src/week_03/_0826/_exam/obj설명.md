## Object 클래스의 역할

### Object 클래스란?

* 자바의 모든 클래스의 최상위 부모 클래스
    - object > parent 
    - object > child 


* 명시적으로 `extends Object`를 적지 않아도 자동으로 상속되어 있음.
    - 따라서 모든 클래스는 **오브젝트 클래스의 메서드**를 사용 가능함.


```java
package week_03._0826._exam;

class Parent { /* ... */}
class Child extends Parent { /* ... */ }

class Exam {
    public static void main(String[] args) {
        Child c = new Child();
        
        // Object 클래스의 메서드 사용 가능
        System.out.println(c.toString());
        // 출력: week_03._0826._exam.Child@{해시코드}
        
        System.out.println(c.getClass());
        // 출력: class week_03._0826._exam.Child
        
        System.out.println(c.getClass().getSuperclass());
        // 출력: class week_03._0826._exam.Parent
        
        // A instanceof B : A는 B 타입 이거나, B의 하위 타입인지 ?
        System.out.println(c instanceof Object); // true
        System.out.println(c instanceof Parent); // true
    }
}
```

### Object 클래스에서 가장 많이 사용하는 메서드 소개

* `equals()` : 논리적으로 같은지 비교 boolean 반환
* `toString()` : 문자열로 표현


```java
import java.util.Arrays;

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // equals() : 오브젝트 공통 메서드
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

    // toString() : 오브젝트 공통 메서드 
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

        // epuals : 논리적으로 같은지 비교 boolean 반환
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
```