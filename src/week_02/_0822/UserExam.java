package week_02._0822;

class User {
    String name;
    int age;

    // 기본 생성자
    public User() {
        this("이름없음", -1); // this() -> 매개변수 없으면 디폴트값 설정, 사용.
    }
    public User(String name) {
        this.name = name;
    }
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class UserExam {
    public static void main(String[] args) {
        User u1 = new User();
        User u2 = new User("영희");
        User u3 = new User("민수", 30);

        // 생성자는 객체가 생성될 떄 단 한번만 호출됨 - 이후 호출 불가능.

        System.out.println("u1 : " + u1.name + "," + u1.age);
        System.out.println("u2 : " + u2.name + "," + u2.age);
        System.out.println("u3 : " + u3.name + "," + u3.age);
    }
}