package week_03._0826;
//import week_03._0826.shape.Shape;
import week_03._0826.shape.Circle;
import week_03._0826.shape.Rectangle;


public class ShapeExam {
    public static void main(String[] args) {
        Circle cir = new Circle("red", 6);
        Rectangle rect = new Rectangle("red", 6, 6);

        System.out.printf("cir: %.2f, %.2f%n", cir.getArea(), cir.getPerimeter());
        System.out.println("-".repeat(5));
        System.out.printf("rect: %d, %d%n", (int)rect.getArea(), (int)rect.getPerimeter());

    }

}
