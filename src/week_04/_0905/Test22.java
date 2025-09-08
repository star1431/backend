package week_04._0905;

class Parent {
    void display() { System.out.println("Parent"); }
}

class Child extends Parent {
    void display() { System.out.println("Child"); }
}

public class Test22 {
    public static void main(String[] args) {
        Parent p = new Child();
        p.display();
    }
}