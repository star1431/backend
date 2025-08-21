package week_02._0821.common;

public class Pen {
    // 필드
    int cnt;

    // 생성자  (= 없으면 컴파일에서 알아서 빈 생성자 제공)
    // public Pen() {
    //     System.out.println("Pen() 생성자 실행");
    // }

    // 메서드
    public void write(String msg) {
        System.out.println("펜쓰기 = " + msg);
    }
}
