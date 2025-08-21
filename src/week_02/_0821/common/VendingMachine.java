package week_02._0821.common;


public class VendingMachine {
    // 필드
    String product;
    int price;

    // 생성자
    public VendingMachine() {}

    // 메소드
    public String pushProductButton(int menuId) {
        if(menuId == 0) return "봉봉";
        if(menuId == 1) return "콜라";
        else if(menuId == 2) return "사이다";
        else if(menuId == 3) return "환타";
        else if(menuId == 4) return "웰치스";
        else return "없는 상품";
    }

}
