package week_03._0826._interface;

// 여러 인터페이스 구현
public class Photo implements InterA, InterB {
    private String fileName;
    private int width, height;

    public Photo(String fileName, int width, int height) {
        this.fileName = fileName;
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println(fileName + " 사진을 화면에 그립니다.");
    }

    @Override
    public void erase() {
        System.out.println(fileName + " 사진을 화면에서 지웁니다.");
    }

    @Override
    public void resize(double factor) {
        width = (int)(width * factor);
        height = (int)(height * factor);
        System.out.println("크기 조정: " + width + "x" + height);
    }
}