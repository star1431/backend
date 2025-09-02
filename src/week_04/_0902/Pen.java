package week_04._0902;

public class Pen {
    private String name;
    private int price;

    public Pen(String name,int price ){
        this.name=name;
        this.price=price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void write() {
        System.out.println(name + "을 쓴다");
    }

    @Override
    public String toString() {
        return "Pen{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
