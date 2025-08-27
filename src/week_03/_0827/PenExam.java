package week_03._0827;

import java.util.Objects;

class Pen {
    private String name;        // 제품명
    private String code;        // 제품코드
    private String type;        // 타입

    public Pen(String name, String code, String type) {
        this.name = name;
        this.code = code;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Pen{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        // 자기자신 비교 리턴 - true
        if (this == obj) return true;

        // 비교 대상이 null 이거나, 클래스 타입이 다르면 false
        if (obj == null || getClass() != obj.getClass()) return false;

        // 타입이 같다면 명시적 형변환
        // 형변환 하는 이유는 Object 타입으로 매개변수를 받고 있기 때문
        Pen pen = (Pen) obj;

        // 매개변수 객체와 자기자신과 비교
        return name.equals(pen.name) && code.equals(pen.code) && type.equals(pen.type);
    }

    @Override
    public int hashCode() {
        // 각 필드의 해시를 누적
        // 누적 방식: result = 31 * result + fieldHash
        // 초기값 (보통 17 사용)
//        int result = 17;
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        result = 31 * result + (code != null ? code.hashCode() : 0);
//        result = 31 * result + (type != null ? type.hashCode() : 0);
//        return result;


        // import java.util.Objects
         return Objects.hash(name, code, type);
    }
}

public class PenExam {
    public static void main(String[] args) {
        Pen p1 = new Pen("파이롯트", "A105", "샤프");
        Pen p2 = new Pen("파이롯트", "A105", "샤프");
        Pen p3 = new Pen("모나미", "B101", "볼펜");

        // toString() Override
        System.out.println(p1.toString());  // Pen{name='파이롯트', code='A105', type='샤프'}
        System.out.println(p1);             // toString() 자동 호출

        // equals() Override
        System.out.println(p1 == p2);       // false
        System.out.println(p1.equals(p2));  // true
        System.out.println(p1.equals(p3));  // false

        // hashCode() Override
        System.out.println(p1.hashCode());  // 2019936075
        System.out.println(p2.hashCode());  // 2019936075
        System.out.println(p3.hashCode());  // -1657557753

    }
}
