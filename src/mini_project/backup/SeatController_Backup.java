package mini_project.backup;

// import mini_project.model.Movie;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * SeatController Class
 * info : 좌석 생성 및 관리 클래스
 * @author 정병천
 */
public class SeatController_Backup {
    private final Map<String, String[]> seatMap = new LinkedHashMap<>(); // 좌석맵
    private final Set<String> reserveSet = new HashSet<>(); // 예매된 좌석 집합
    private final String MASKING = "__"; // 예매표시
    private int rows;
    private int cols;

    // 디폴트
    public SeatController_Backup() {
        this(5, 6);
        initSeatMap();
    }
    // 확장
    public SeatController_Backup(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        initSeatMap();
    }

    // 좌석 설정
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

    /**
     * 좌석 예매
     * @param code 예매할 좌석 코드
     * @return 예매 성공 여부 (true: 성공, false: 실패)
     */
    public boolean reserve(String code) {
        String key = code.substring(0, 1); // 행 키값
        int idx = Integer.parseInt(code.substring(1)) - 1; // 번호값 인덱스 변환
        String[] row = seatMap.get(key); // 행 배열 새로 담기

        // 해당코드 마스킹 처리되어 있는 경우 (예매된상태)
        if (MASKING.equals(row[idx])) {
            return false;
        } else {
            row[idx] = MASKING; // 예매표시로 변경
            reserveSet.add(code); // 예매좌석 배열 내 추가
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
        String[] row = seatMap.get(key); // 행 배열 새로 담기

        // 해당코드 마스킹 처리 안되어 있는 경우 (예매안된 상태)
        if (!MASKING.equals(row[idx])) {
            return false;
        } else {
            row[idx] = code;    // 원래 좌석값으로 변경
            reserveSet.remove(code);  // 예매좌석배열 내 제거
            return true;
        }
    }

    // 예매된 코드값
    public Set<String> getReserveList() {
        System.out.println(reserveSet);
        return reserveSet;
    }

    // 총 좌석 수
    public int getTotal() {
        int total = 0;
        for (String[] row : seatMap.values()) {
            total += row.length;   // 각 행 좌석 수를 누적
        }
        return total;
    }



    // 예매 좌석 수
    public int getReservedCount() {
        return reserveSet.size();
    }

    // 남은 좌석 수
    public int getLeftCount() {
        return getTotal() - getReservedCount();
    }


    // 시트 해시맵 전달
    public Map<String, String[]> getSeatMap() {
        return seatMap;
    }
}