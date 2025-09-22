package mini_project.dto;

/**
 * 예매좌석 DTO
 * @author 정병천
 * @since 2025-09-17
 */
public class ReservedSeatDTO {
    private int movieId;
    private String seatCode;

    public ReservedSeatDTO() {}

    public ReservedSeatDTO(int movieId, String seatCode) {
        this.movieId = movieId;
        this.seatCode = seatCode;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getSeatCode() {
        return seatCode;
    }

    public void setSeatCode(String seatCode) {
        this.seatCode = seatCode;
    }

    @Override
    public String toString() {
        return "ReservedSeatDTO{" +
                "movieId=" + movieId +
                ", seatCode='" + seatCode + '\'' +
                '}';
    }
}