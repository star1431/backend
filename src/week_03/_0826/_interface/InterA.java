package week_03._0826._interface;

// 인터페이스는 껍데기 형식 - 구현 형태가 없는 것이 기본
public interface InterA {
    void draw(); // 추상메서드 (자동)
    void erase();
    static void infoVersion() {
        System.out.println("버전 : v1.10");
    }
}