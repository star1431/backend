package week_03._0826;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
        obj.exam01();
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
    

    public void exam01() {
        System.out.println("exam01 : Date 테스트");

        // 오래된 방식 ( 더이상 사용되지 않음 deprecated )
        // Date 생성자 : 연도는 1900부터, 월은 0부터 시작
        Date _date = new Date(123, 7, 26); // 2023년 8월 26일
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        String format1 = sdf.format(_date);
        System.out.println(format1); // 2023.08.26
        
        System.out.println("-".repeat(5));

        // 새로운 방식
        LocalDate _date2 = LocalDate.of(2023, 8, 26);
        String format2 = _date2.format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        System.out.println(format2); // 2023.08.26

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡ");
    }
}
