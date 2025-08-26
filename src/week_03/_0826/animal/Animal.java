package week_03._0826.animal;

public abstract class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    // abstract: 자식클래스가 상속할 경우 해당 메서드 무조건 오버라이딩! (기능 일관성)
    public abstract void sound();
    public abstract void info();
}
