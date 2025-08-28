package week_03._0827.exam11._impl;
import week_03._0827.exam11._interface.Drawable;
import week_03._0827.exam11._interface.Measurable;

public class Square implements Measurable, Drawable {
    private final String type = "정사각형";
    private double width;
    private double height;
    private String color;

    public Square(double width, double height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
    @Override
    public void resize(double resize) {
        width *= resize;
        height *= resize;
    }
    @Override
    public void drawInfo() {
        System.out.println("-".repeat(10));
        System.out.println("타입: " + type);
        System.out.println("색상: " + color);
        System.out.println("가로: " + width + ", 세로: " + height);
        System.out.println("넓이: " + getArea());
        System.out.println("둘레: " + getPerimeter());
        System.out.println("-".repeat(10));
    }
}