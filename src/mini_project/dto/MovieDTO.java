package mini_project.dto;
import java.util.Objects;

/**
 * 영화 DTO
 * @author 정병천
 * @since 2025-09-17
 */
public class MovieDTO {
    private int movieId;        // 영화 고유 ID
    private String title;       // 영화명
    private String type;        // 관람등급
    private String genre;       // 장르
    private int price;          // 가격

    public MovieDTO() {}
    public MovieDTO(String title, String type, String genre, int price) {
        this.title = title;
        this.type = type;
        this.genre = genre;
        this.price = price;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
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
                "id='" + movieId + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MovieDTO movieDTO = (MovieDTO) o;
        return Objects.equals(movieId, movieDTO.movieId);
        // return Objects.equals(id, movie.id) && 
        //         Objects.equals(title, movie.title) && 
        //         Objects.equals(type, movie.type) && 
        //         Objects.equals(genre, movie.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movieId);
        // return Objects.hash(id, title, type, genre);
    }
}