package mini_project.service;

import mini_project.model.Movie;
import mini_project.enums.AgeRating;
import mini_project.control.MovieController;
import mini_project.control.SeatController;
import mini_project.io.DataFile;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * MovieService Class
 * info : 무비정보 + 좌석관리 통합
 * @author 정병천
 */
public class MovieService {
    private final MovieController movieCtrl = new MovieController();
//    private final SeatController seatCtrl = new SeatController();
    private final Map<String, SeatController> allMap = new LinkedHashMap<>(); // 영화id-좌석 맵
    private final Map<String, SeatController> reservedMap = new LinkedHashMap<>(); // 예약된 영화id-좌석 맵

    /**
     * 영화추가
     * @param title 영화제목
     * @param type 관람등급
     * @param genre 장르
     * @param price 가격
     */
    public String addMovie(String title, String type, String genre, int price) {
        String returnId = movieCtrl.addMovie(title, type, genre, price);
        allMap.put(returnId, new SeatController()); // key:영화id | val:좌석(생성)
        return returnId;

    }
    // enum으로 받는 경우 확장
    public String addMovie(String title, AgeRating type, String genre, int price) {
        String returnId = movieCtrl.addMovie(title, type.getLabel(), genre, price);
        allMap.put(returnId, new SeatController());
        return returnId;
    }

    public Map<String, SeatController> getAllMap() {
        return allMap;
    }

    public Map<String, SeatController> getReservedMap() {
        return reservedMap;
    }

    public MovieController getMovieCtrl() {
        return movieCtrl;
    }

    /**
     * 영화 삭제
     * @param id 영화 고유 아이디
     */
    public void removeMovie(String id) {
        movieCtrl.removeMovie(id); // 영화 맵
        allMap.remove(id);  // 영화-좌석 맵
        reservedMap.remove(id); // 예약된 영화-좌석 맵
    }

    // 해당 무비 시트 객체 반환
    public SeatController getSeat(String id) {
        return allMap.get(id);
    }

    // 등록된 영화 수
    public int movieTotal() {
        return movieCtrl.getTotal();
    }

    // 영화 모든 목록 출력
    public void MovieBoard() {
        System.out.println("영화 목록 |  (등록된 영화 수: " + movieTotal() +")");

        int cnt = 1;
        // 해당 좌석 키(id)-값(movie)
        for (Map.Entry<String, Movie> entry : movieCtrl.getMovieMap().entrySet()) {
            String id = entry.getKey();
            Movie movie = entry.getValue();

            System.out.printf("[%02d] : ", cnt++);
            System.out.printf(
                    "제목: %s | 장르: %s | 등급: %s | 가격: %,d원 | 전체좌석: %d | 남은좌석: %d%n",
                    movie.getTitle(),
                    movie.getGenre(),
                    movie.getType(),
                    movie.getPrice(),
                    getSeat(id).getTotal(),
                    getSeat(id).getLeftCount()
            );
        }
    }

     /**
     * 영화 예매 목록 출력
     * @return 목록 여부 (true: 있음, false: 없음)
     */
    public boolean reservedMovieBoard() {
        System.out.println("예매된 영화 목록");

        int cnt = 1;

        // 예매된 영화 키(id)-값(SeatController)
        for (Map.Entry<String, SeatController> entry : reservedMap.entrySet()) {
            String id = entry.getKey();
            SeatController seat = entry.getValue();
            Movie movie = movieCtrl.findMovie(id); // 무비정보 따로

            if(seat.getReservedCount() > 0) {
                System.out.printf("[%02d] : ", cnt++);
                System.out.printf(
                        "제목: %s | 장르: %s | 등급: %s | 가격: %,d원 | 전체좌석: %d | 남은좌석: %d%n",
                        movie.getTitle(),
                        movie.getGenre(),
                        movie.getType(),
                        movie.getPrice(),
                        seat.getTotal(),
                        seat.getLeftCount()
                );
            }
        }
        if (cnt == 1) {
            System.out.println("❌ 예매된 영화가 없습니다.");
            return false;
        }
        return true;
    }

    /**
     * 해당영화 좌석표 출력
     * @param id 영화 고유 아이디
     */
    public void movieSeatBoard(String id) {
        System.out.println("┌───────────────────────────────────────┐");
        System.out.println("│                Screen                 │");
        System.out.println("└───────────────────────────────────────┘");
        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

        // 해당 좌석 키(A~)-값(A1~)
        for (Map.Entry<String, String[]> entry : getSeat(id).getSeatMap().entrySet()) {
            String row = entry.getKey();
            String[] seats = entry.getValue();

            System.out.print(row + "열 |  ");
            for (String item : seats) {
                System.out.print("[" + item + "] ");
            }
            System.out.println();
        }
    }

    /**
     * 해당영화 예매번호 출력
     * @param id 영화 고유 아이디
     */
    public void reservedSeatBoard(String id) {
        SeatController seat = allMap.get(id);
        System.out.println(seat.getReservedSeat());
    }

    /**
     * 해당영화 정보 출력
     * @param id 영화 고유 아이디
     */
    public void movieInfo(String id) {
        Movie movie = movieCtrl.findMovie(id);

        System.out.printf(
                "제목: %s | 장르: %s | 등급: %s | 가격: %,d원 | 전체좌석: %d | 남은좌석: %d%n",
                movie.getTitle(),
                movie.getGenre(),
                movie.getType(),
                movie.getPrice(),
                getSeat(id).getTotal(),
                getSeat(id).getLeftCount()
        );
    }

    /**
     * 보드에서 해당영화 선택
     * @param caseStr 호출케이스
     * @param num 영화목록 번호
     * @return 영화ID값
     */
    public String selectMovie(String caseStr, String num) {
        int idx = Integer.parseInt(num) - 1;
        
        switch (caseStr) {
            case "읽기전용":
            case "예매등록":
                if (idx < 0 || idx >= movieCtrl.getTotal()) return null;
                int i = 0;
                for (Movie movie : movieCtrl.getMovieMap().values()) {
                    if (i == idx) return movie.getId();
                    i++;
                }
                break;
            case "예매취소":
                if (idx < 0 || idx >= reservedMap.size()) return null;
                int j = 0;
                for (Map.Entry<String, SeatController> entry : reservedMap.entrySet()) {
                    if (j == idx) return entry.getKey();
                    j++;
                }
                break;
            default:
                System.out.println("매개변수확인");
                break;
        }
        return null;
    }

    /**
     * 해당영화 좌석표 예매 등록
     * @param id 영화 고유 아이디
     * @param code 좌석번호
     * @return 예매 통과 여부 (true: 성공, false: 실패)
     */
    public boolean reserveSeat(String id, String code) {
        boolean reservedCheck = getSeat(id).reserve(code);
        if(!reservedMap.containsKey(id)) {
            reservedMap.put(id, getSeat(id));
        }
        return reservedCheck;
    }

    /**
     * 해당영화 좌석표 예매 취소
     * @param id 영화 고유 아이디
     * @param code 좌석번호
     * @return 예매 취소 여부 (true: 성공, false: 실패)
     */
    public boolean cancelSeat(String id, String code) {
        boolean cancelCheck = getSeat(id).cancel(code);
        if(getSeat(id).getReservedCount() == 0) {
            reservedMap.remove(id);
        }
        return cancelCheck;
    }

    public void dataLoad() {
        DataFile.load(this);
    }

    public void dataSave() {
        DataFile.save(this);
    }

}