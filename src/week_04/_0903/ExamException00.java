package week_04._0903;

public class ExamException00 {
    public static void setAge(int age) {
        if (age < 0) {
            // 직접 익셉션 던짐
            throw new IllegalArgumentException("음수야: " + age);
        }
        System.out.println("나이: " + age);
    }

    public static void main(String[] args) {
        setAge(-5); // 잘못된 인자로 예외 발생
    }
}
