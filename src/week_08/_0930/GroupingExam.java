package week_08._0930;

import java.util.*;
import java.util.stream.Collectors;

class Product {
    private String name;
    private String category;
    private long price;

    public Product(String name, String category, long price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public long getPrice() { return price; }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}

public class GroupingExam {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("TV", "전자제품", 500_000),
                new Product("스마트폰", "전자제품", 1_000_000),
                new Product("노트북", "전자제품", 1_500_000),
                new Product("의자", "가구", 150_000),
                new Product("책상", "가구", 300_000),
                new Product("볼펜", "문구", 800)
        );

        // groupingBy() - 카테고리별 그룹화
        Map<String, List<Product>> groupPing1 =
                products.stream()
                        .collect(Collectors.groupingBy(Product::getCategory));
        System.out.println("[groupingBy] 카테고리별 그룹화: " + groupPing1);

        // partitioningBy() - 가격 1백만원 이상/미만으로 분할
        Map<Boolean, List<Product>> groupPing2 =
                products.stream()
                        .collect(Collectors.partitioningBy(p -> p.getPrice() >= 1_000_000));
        System.out.println("[partitioningBy] 가격 1백만원 이상/미만 분할: " + groupPing2);


        // 카테고리별 평균 가격
        Map<String, Double> avgPriceByCategory =
                products.stream()
                        .collect(Collectors.groupingBy(
                                Product::getCategory,
                                Collectors.averagingLong(Product::getPrice)
                        ));
        System.out.println("[averagingBy] 카테고리별 평균 가격: " + avgPriceByCategory);

        // 전자제품 평균 가격
        double avgPrice =
                products.stream()
                        .filter(p -> p.getCategory().equals("전자제품"))
                        .mapToLong(Product::getPrice)
                        .average()
                        .orElse(0.0);
        System.out.printf("[average] 전자제품 평균 가격: %,.1f%n", avgPrice);



    }
}