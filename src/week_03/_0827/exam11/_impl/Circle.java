package week_03._0827.exam11._impl;
import week_03._0827.exam11._interface.Drawable;
import week_03._0827.exam11._interface.Measurable;


public class Circle implements Measurable, Drawable {
    private final String type = "원형";
    private double radius;
    private String color;

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
    @Override
    public void resize(double resize) {
        radius *= resize;
    }
    @Override
    public void drawInfo() {
        System.out.println("-".repeat(10));
        System.out.println("타입: " + type);
        System.out.println("색상: " + color);
        System.out.println("반지름: " + radius);
        System.out.printf("넓이: %.2f\n", getArea());
        System.out.printf("둘레: %.2f\n", getPerimeter());
        System.out.println("-".repeat(10));
    }
}