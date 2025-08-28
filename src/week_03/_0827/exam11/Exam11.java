package week_03._0827.exam11;
import week_03._0827.exam11._impl.*;

public class Exam11 {
    public static void main(String[] args) {

        Circle circle = new Circle(10, "빨간색");
        circle.drawInfo();

        Square square = new Square(10, 10, "빨간색");
        square.drawInfo();
        
        Triangle triangle = new Triangle(3, 4, 5, "파란색");
        triangle.drawInfo();


        System.out.println("ㅡ".repeat(10));
        System.out.println("원형 배율 x1.3");
        circle.resize(1.3);
        circle.drawInfo();


        System.out.println("ㅡ".repeat(10));
        System.out.println("사각형 배율 x1.5");
        square.resize(1.5);
        square.drawInfo();

        System.out.println("ㅡ".repeat(10));
        System.out.println("삼각형 배율 x2.0");
        triangle.resize(2.0);
        triangle.drawInfo();

    }
    
}