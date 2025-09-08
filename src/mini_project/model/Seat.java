package mini_project.model;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Seat Class
 * info : 좌석 생성 클래스
 * @author 정병천
 * ㅡㅡㅡㅡㅡㅡㅡㅡㅡ
 * 250908 : 좌석 생성 <-> 관리 책임 분리 (Seat Class)
 */
public class Seat {
    private final Map<String, String[]> seatMap = new LinkedHashMap<>();
    private final Set<String> reservedSet = new HashSet<>();
    private final int rows;
    private final int cols;

    public Seat(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        initSeatMap();
    }

    /** 좌석맵 설정 */
    private void initSeatMap() {
        int changeNum = (int)'A'; // 아스키 = 65
        for (int i = 0; i < rows; i++) {
            String label = String.valueOf((char)(changeNum + i));
            String[] arr = new String[cols];
            for (int j = 0; j < cols; j++) {
                arr[j] = label + (j + 1); // A1
            }
            seatMap.put(label, arr);
        }
    }

    public int getRows() {
        return rows;
    }
    public int getCols() {
        return cols;
    }

    public Map<String, String[]> getSeatMap() {
        return seatMap;
    }

    public Set<String> getReservedSet() {
        return reservedSet;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatMap=" + seatMap +
                ", reservedSet=" + reservedSet +
                ", rows=" + rows +
                ", cols=" + cols +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return rows == seat.rows && cols == seat.cols && Objects.equals(seatMap, seat.seatMap) && Objects.equals(reservedSet, seat.reservedSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seatMap, reservedSet, rows, cols);
    }
}
