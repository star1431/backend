package week_06._0916.kr.likelion.demo.dto;

import java.time.LocalDateTime;

public class ProductDTO {
    private int id;
    private String name;
    private int price;
    private LocalDateTime reg_date;

    public ProductDTO() {

    }
    public ProductDTO(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDateTime getRegdate() {
        return reg_date;
    }

    public void setRegdate(LocalDateTime reg_date) {
        this.reg_date = reg_date;
    }

    @Override
    public String toString() {
        return "[" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", reg_date=" + reg_date +
                ']';
    }
}
