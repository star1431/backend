package mini_project.control;

// import mini_project.model.Movie;
import mini_project.model.Seat;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * SeatController Class
 * info : 좌석 관리 클래스
 * @author 정병천
 * ---------
 * 상영관 어떻게 나눌까?
 */
public class SeatController {
    private static final String MASKING = "__";
    private final Seat seat;
    private final Map<String, Seat> seatHall = new LinkedHashMap<>();
    private int idCnt = 1;

    public SeatController(Seat seat) {
        this.seat = seat;
    }
    public SeatController() {
        this(new Seat(5, 6));
    }
    public SeatController(int rows, int cols) {
        this(new Seat(rows, cols));
    }

    public Map<String, String[]> getSeatMap() {
        return seat.getSeatMap();
    }

    public Set<String> getReservedSeat() {
        return seat.getReservedSet();
    }

    /**
     * 좌석 예매
     * @param code 예매할 좌석 코드
     * @return 예매 성공 여부 (true: 성공, false: 실패)
     */
    public boolean reserve(String code) {
        String key = code.substring(0, 1); // 행 키값
        int idx = Integer.parseInt(code.substring(1)) - 1; // 번호값 인덱스 변환
        String[] row = getSeatMap().get(key); // 행 배열 새로 담기

        // 해당코드 마스킹 처리되어 있는 경우 (예매된상태)
        if (MASKING.equals(row[idx])) {
            return false;
        } else {
            row[idx] = MASKING; // 예매표시로 변경
            getReservedSeat().add(code); // 예매좌석 배열 내 추가
            return true;
        }
    }

    /**
     * 예매 취소
     * @param code 예매 취소할 좌석 코드
     * @return 예매 취소 여부 (true: 성공, false: 실패)
     */
    public boolean cancel(String code) {
        String key = code.substring(0, 1);  // 행 키값
        int idx = Integer.parseInt(code.substring(1)) - 1; // 번호값 인덱스 변환
        String[] row = getSeatMap().get(key); // 행 배열 새로 담기

        // 해당코드 마스킹 처리 안되어 있는 경우 (예매안된 상태)
        if (!MASKING.equals(row[idx])) {
            return false;
        } else {
            row[idx] = code;    // 원래 좌석값으로 변경
            getReservedSeat().remove(code);  // 예매좌석배열 내 제거
            return true;
        }
    }

    /** 총 좌석 수 */
    public int getTotal() {
        int total = 0;
        for (String[] row : getSeatMap().values()) {
            total += row.length;   // 각 행 좌석 수를 누적
        }
        return total;
    }

    /** 예매 좌석 수 */
    public int getReservedCount() {
        return getReservedSeat().size();
    }

    /** 남은 좌석 수 */
    public int getLeftCount() {
        return getTotal() - getReservedCount();
    }


}