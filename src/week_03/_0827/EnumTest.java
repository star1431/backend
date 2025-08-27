package week_03._0827;
import week_03._0827._enum.Day;
import week_03._0827._enum.Order;

public class EnumTest {
    public static void main(String[] args) {
        // 기본열거형 사용
        Day today = Day.월요일;
        switch(today) {
            case 월요일:
            case 화요일:
            case 수요일:
            case 목요일:
            case 금요일:
                System.out.println("평일입니다.");
                break;
            case 토요일:
            case 일요일:
                System.out.println("주말입니다.");
                break;
        }
        System.out.println("-".repeat(5));

        // Order 사용
        Order status = Order.대기;
        System.out.println(status.getInfo());  // 대기중

        System.out.println("-".repeat(5));

        // Order 모든 값 순회
        for (Order s : Order.values()) {
            System.out.println(s.name() + ": " + s.getInfo());
        }

        System.out.println("-".repeat(5));

        // Order 코드로 찾기
        Order found = Order.fromCode("S");
        System.out.println(found);  // SHIPPED
    }
}
