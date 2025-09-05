package week_04._0905;

interface TV {
    public void powerOn();
    public void powerOff();
    public void volumeUp();
    public void volumeDown();
}

class STV  implements TV {
    private boolean power;
    private int volume = 50;

    @Override
    public void powerOn() {
        power = true;
        System.out.println("TV 켜짐");
    }

    @Override
    public void powerOff() {
        power = false;
        System.out.println("TV 꺼짐");
    }

    @Override
    public void volumeUp() {
        volume++;
        System.out.println("볼륨: " + volume);
    }

    @Override
    public void volumeDown() {
        volume--;
        System.out.println("볼륨: " + volume);
    }
}
class LTV  implements TV {
    private boolean power;
    private int volume = 50;

    @Override
    public void powerOn() {
        power = true;
        System.out.println("TV 켜짐");
    }

    @Override
    public void powerOff() {
        power = false;
        System.out.println("TV 꺼짐");
    }

    @Override
    public void volumeUp() {
        volume++;
        System.out.println("볼륨: " + volume);
    }

    @Override
    public void volumeDown() {
        volume--;
        System.out.println("볼륨: " + volume);
    }
}

// 팩토리 패턴으로 고도화
class TVFactory {
    public static TV obj(String brand) {
        if (brand.equals("samsung")) return new LTV();
        if (brand.equals("lg")) return new STV();
        throw new IllegalArgumentException("지원하지 않는 브랜드: " + brand);
    }
}

public class TVExam {
    public static void main(String[] args) {
        String brand = "samsung";
        TV tv = TVFactory.obj(brand);
        tv.powerOn();
        tv.volumeUp();
        tv.volumeDown();
        tv.powerOff();
    }
}
