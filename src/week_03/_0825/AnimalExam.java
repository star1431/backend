package week_03._0825;
import week_03._0825.common.Animal;

class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age); // 부모 생성자 호출
        this.breed = breed;
    }

    public void showBreed() {
        System.out.println("견종: " + breed);
    }

    
}
public class AnimalExam {

    public static void main(String[] args) {
        Dog dog = new Dog("초코", 15, "슈나우저");
        dog.info();        // 부모 메서드 사용
        dog.showBreed();   // 자식 메서드 사용
    }
}