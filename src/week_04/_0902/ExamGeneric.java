package week_04._0902;

public class ExamGeneric {
    public static void main(String[] args) {
        GenericBox<Pen> penBox = new GenericBox<>();
        Pen pen1 = new Pen("볼펜",1300);
        penBox.setItem(pen1);

        System.out.println(penBox.getItem());
        // Pen{name='볼펜', price=1300}
        penBox.getItem().write();
        // 볼펜을 쓴다
    }
}
