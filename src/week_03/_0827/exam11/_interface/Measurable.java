package week_03._0827.exam11._interface;

// Measurable 측정
public interface Measurable {
    double getArea();           // 넓이
    double getPerimeter();      // 둘레
    void resize(double resize); // 크기 배율
}