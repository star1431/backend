package week_03._0826._exam;


class Parent { /* ... */}
class Child extends Parent { /* ... */ }

class ObjExam {
    public static void main(String[] args) {
        Child c = new Child();

        // Object 클래스의 메서드 사용 가능
        System.out.println(c.toString());
        // 출력: 클래스명@해시코드

        System.out.println(c.getClass());
        // class Child

        System.out.println(c.getClass().getSuperclass());
        // class Parent

        // A instanceof B : A는 B 타입 이거나, B의 하위 타입인지 ?
       System.out.println(c instanceof Object); // true
       System.out.println(c instanceof Parent); // true
    }
}