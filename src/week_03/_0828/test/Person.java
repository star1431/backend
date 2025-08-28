package week_03._0828.test;

import java.util.Objects;

public class Person {
    private String name;
    private String addr;
    private String id;
    private String tell;

    public Person(String name, String addr, String id, String tell) {
        this.name = name;
        this.addr = addr;
        this.id = id;
        this.tell = tell;
    }

    public String getName() {
        return name;
    }

    public String getAddr() {
        return addr;
    }

    public String getId() {
        return id;
    }

    public String getTell() {
        return tell;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", addr=" + addr +
                ", id='" + id + '\'' +
                ", tell=" + tell +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(addr, person.addr) && Objects.equals(id, person.id) && Objects.equals(tell, person.tell);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, addr, id, tell);
    }
}
