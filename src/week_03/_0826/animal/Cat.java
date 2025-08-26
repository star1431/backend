package week_03._0826.animal;

public class Cat extends Animal {
    private String breed;

    public Cat(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void info() {
        System.out.println("품종이 '" + breed + "'인 고양이 '" + getName() + "'가 " + getAge() + "살 입니다.");
    }

    @Override
    public void sound() {
        System.out.println("울음소리: 야옹~");
    }
}
