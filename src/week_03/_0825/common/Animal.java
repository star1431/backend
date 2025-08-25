package week_03._0825.common;

public class Animal {
    protected String name;
    protected int age;

    // 자식 상속에선 super()로 접근
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void info() {
        System.out.println("동물이름: " + name);
        System.out.println("동물나이: " + age);
    }
}