package mini_project.model;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Movie Class
 * info : 영화 생성 클래스
 * @author 정병천
 */
public class Movie {
    private String id;          // 영화 고유 ID
    private String title;       // 영화명
    private String type;        // 관람등급
    private String genre;       // 장르
    private int price;          // 가격

    public Movie(String id, String title, String type, String genre, int price) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.genre = genre;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id);
        // return Objects.equals(id, movie.id) && 
        //         Objects.equals(title, movie.title) && 
        //         Objects.equals(type, movie.type) && 
        //         Objects.equals(genre, movie.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
        // return Objects.hash(id, title, type, genre);
    }
}