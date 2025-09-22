package mini_project.dto;

/**
 * 좌석 DTO
 * @author 정병천
 * @since 2025-09-17
 */
public class SeatDTO {
    private int movieId;
    private int rows;
    private int cols;

    public SeatDTO() {}

    public SeatDTO(int movieId, int rows, int cols) {
        this.movieId = movieId;
        this.rows = rows;
        this.cols = cols;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int getTotal() {
        return (rows * cols);
    }
}