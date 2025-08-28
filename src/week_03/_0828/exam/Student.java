package week_03._0828.exam;
import java.util.Objects;

public class Student {
    private String name;    // 이름
    private String id;      // 학번
    private int grade;      // 학년
    private String major;   // 전공

    public Student(String name, String id, int grade, String major) {
        this.name = name;
        this.id = id;
        this.grade = grade;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", grade=" + grade +
                ", major='" + major + '\'' +
                '}';
    }

    // 학번만 중복 비교
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
