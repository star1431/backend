package week_03._0827._enum;
// 값과 메서드 가진 열거형
public enum Order {
    대기("P", "대기중"),
    처리("R", "처리중"),
    배송("S", "배송중"),
    완료("D", "배송완료"),
    취소("C", "취소");

    private final String code;
    private final String info;

    // 생성자
    Order(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }

    // 정적 메소드
    public static Order fromCode(String code) {
        for (Order status : Order.values()) {
            if (status.code.equals(code)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }
}

