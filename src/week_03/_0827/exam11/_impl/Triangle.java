package week_03._0827.exam11._impl;
import week_03._0827.exam11._interface.Drawable;
import week_03._0827.exam11._interface.Measurable;


public class Triangle implements Measurable, Drawable {
    private final String type = "삼각형";
    private double side1; // a변
    private double side2; // b변
    private double side3; // c변
    private String color;

    public Triangle(double side1, double side2, double side3, String color) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.color = color;
    }

    @Override   
    public double getArea() { // 하론공식
        double semi = getPerimeter() / 2;
        // = 루트(반둘레 * (반둘레 - a변) * (반둘레 - b변) * (반둘레 - c변))
        return Math.sqrt(semi * (semi - side1) * (semi - side2) * (semi - side3));
    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }
    @Override
    public void resize(double resize) {
        side1 *= resize;
        side2 *= resize;
        side3 *= resize;
    }
    @Override
    public void drawInfo() {
        System.out.println("-".repeat(10));
        System.out.println("타입: " + type);
        System.out.println("색상: " + color);
        System.out.println("a변: " + side1 + ", b변: " + side2 + ", c변: " + side3);
        System.out.println("넓이: " + getArea());
        System.out.println("둘레: " + getPerimeter());
        System.out.println("-".repeat(10));
    }
}