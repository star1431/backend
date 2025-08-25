package week_03._0825;

class Parent {
    int a = 10;
    int b = 0;
    int c = 5;
}
class Child extends Parent {
    // 부모에 상속되어 필드변수 같이 사용됨

    // 필드의 오버라이드
    int b = 1;
    
    public Child() {
        this.a = 20; // 생성자에서 부모 필드 받아 자기 자신 변경 가능
    }
}

public class Exam {

    public static void main(String[] args) {
        System.out.println("TITLE : 0825 자바 기초");
        Exam obj = new Exam();
        obj.exam00(); //
    }

    public void exam00() {
        System.out.println("exam00 : parent 확인");
        Parent p = new Parent();
        Child c = new Child();
        System.out.println(p.a);    // 10   (부모필드)
        System.out.println(c.a);    // 20   (자식 this)
        System.out.println(c.c);    // 5    (자식인데 부모필드 가져옴)

        // 1. 부모는 자식을 가리킬 수 있음.
        Parent p1 = new Child();
        // Child c1 = new Parent(); // 불가능!

        // 2. 필드는 선언한 타입에 따름.
        System.out.println(p1.b);   // 0  (부모필드)
        System.out.println(c.b);    // 1  (자식필드)
        System.out.println(p1.a);   // 20 (자식 this)

        // 묵시적 형변환 
        Parent p2 = new Child();
        Object obj2 = p2;
        System.out.println(((Parent)obj2).b);  // 0 (부모필드)
        System.out.println(((Child)obj2).b);   // 1 (자식필드)

        if(obj2 instanceof Child) {
            System.out.println("obj2는 Child 타입입니다.");
        }

        // 명시적 형변환
        Child c2 = (Child)obj2;

        System.out.println(c2.b);   // 1 (자식필드)

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
    }
}
