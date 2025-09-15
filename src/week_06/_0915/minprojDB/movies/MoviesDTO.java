package week_06._0915.minprojDB.movies;

/** 무비 정보 class */
public class MoviesDTO {
    private int id;
    private String title;
    private String grade;
    private String genre;
    private int price;

    public MoviesDTO() {
        super();
    }
    public MoviesDTO(String title, String grade, String genre, int price) {
        this.title = title;
        this.grade = grade;
        this.genre = genre;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
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
        return "MoviesDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", grade='" + grade + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                '}';
    }
}
