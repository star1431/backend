package week_04._0905;

interface Payment {
    void pay(int amount);
}

class CardPayment implements Payment {
    public void pay(int amount) {
        System.out.printf("신용카드로 %,d원 결제", amount);
    }
}

class PayPalPayment implements Payment {
    public void pay(int amount) {
        System.out.printf("페이팔로 %,d원 결제", amount);
    }
}

class CashPayment implements Payment {
    private int amount;
    public void pay(int amount) {
        System.out.printf("현금으로 %,d원 결제", amount);
    }
}

class PayFactory {
    public static Payment obj(String type) {
        if (type.equals("카드")) return new CardPayment();
        else if (type.equals("현금")) return new CashPayment();
        else if (type.equals("페이팔")) return new PayPalPayment();
        else throw new IllegalArgumentException("지원하지 않는 결제수단: " + type);
    }
}


public class PaymentExam {
    public static void main(String[] args) {
        String type = "현금";
        int amount = 100000;

        Payment payment = PayFactory.obj(type);
        payment.pay(amount);
    }
}