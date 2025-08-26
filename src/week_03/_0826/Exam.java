package week_03._0826;

class Parent {
    int num = 5;

    public int getNum() {
        return num;
    }
}

class Child extends Parent {
    int num = 10;

    @Override
    public int getNum() {
        return num;
    }

    public void print() {
        System.out.println(num);
    }
}

public class Exam {

    public static void main(String[] args) {
        System.out.println("TITLE : 0826 자바 기초");
        Exam obj = new Exam();
        obj.exam00();
    }

    public static void test(Parent p) {
        System.out.println(p.num);
        System.out.println(p.getNum());

        // 명시적 형변환
        if (p instanceof Child) {
            ((Child)p).print();
        }
    }

    public void exam00() {
        System.out.println("exam00 : 상속 형변환 복습");

        Parent p = new Parent();
        System.out.println(p.num);          // 5
        System.out.println(p.getNum());     // 5
        
        Child c = new Child();
        System.out.println(c.num);          // 10
        System.out.println(c.getNum());     // 10
        c.print();                          // 10


        // 묵시적 형변환
        Parent pc = new Child();
        System.out.println(pc.num);         // 5
        System.out.println(pc.getNum());    // 10

        // 명시적 형변환
        ((Child)pc).print();                // 10


        System.out.println("-".repeat(5));
        test(p);                            // 5, 5
        System.out.println("-".repeat(5));
        test(c);                            // 5, 10, 10
        System.out.println("-".repeat(5));
        test(pc);                           // 5, 10, 10

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
    }
}
