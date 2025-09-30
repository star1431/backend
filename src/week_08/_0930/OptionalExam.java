package week_08._0930;
import java.util.*;

class User {
    private String name;
    private Integer id; // null 가능

    public User(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public String getName() { return name; }
    public Integer getId() { return id; }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

public class OptionalExam {
    private static final Map<Integer, User> users = new HashMap<>();

    static {
        users.put(1001, new User("신짱구", 1001));
        users.put(1002, new User("김철수", 1002));
        users.put(1003, new User("이훈이", 1003));
    }

    // User 객체 반환
    static Optional<User> getUserById(Integer id) {
        if (id == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(users.get(id));
    }

    public static void main(String[] args) {
        Integer idVal = 1001;

        // 있는경우
        System.out.println("─── 있는 경우 ? ───");
        getUserById(idVal).ifPresentOrElse(
                user -> System.out.println("찾음: " + user),
                () -> System.out.println("못찾음")
        );

        // 없는경우
        System.out.println("─── 없는 경우 ? ───");
        idVal = 9999;
        getUserById(idVal).ifPresentOrElse(
                user -> System.out.println("찾음: " + user),
                () -> System.out.println("못찾음")
        );

        // null인 경우
        System.out.println("─── null인 경우 ? ───");
        idVal = null;
        getUserById(idVal).ifPresentOrElse(
                user -> System.out.println("찾음: " + user),
                () -> System.out.println("못찾음")
        );
    }
}