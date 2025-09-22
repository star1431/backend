package mini_project.controller;

import mini_project.dto.MovieDTO;
import mini_project.service.MovieService;
import mini_project.service.SeatService;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 영화,좌석 서비스 제어
 * @author 정병천
 * @since 2025-09-17
 */
public class MoiveController {
    private final MovieService ms = new MovieService();
    private final SeatService ss = new SeatService();

    public MoiveController() {}

    /** 영화 + 좌석 보드 데이터 */
    public List<Map<String, Object>> movieBoardData() {
        Map<Integer, MovieDTO> map = ms.movieAll();
        List<Map<String, Object>> rows = new ArrayList<>();

        for (Map.Entry<Integer, MovieDTO> e : map.entrySet()) {
            int id = e.getKey();
            MovieDTO mDTO = e.getValue();
            Map<String, Object> row = new LinkedHashMap<>();
            row.put("id",    id);
            row.put("title", mDTO.getTitle());
            row.put("genre", mDTO.getGenre());
            row.put("type",  ms.ageLabel(mDTO.getType()));
            row.put("price", mDTO.getPrice());
            row.put("total", ss.seatCounts(id, "total"));
            row.put("left",  ss.seatCounts(id, "left"));
            rows.add(row);
        }
        return rows;
    }
    
    /** 예매된영화 + 좌석 보드 데이터 */
    public List<Map<String, Object>> reservedBoardData() {
        Map<Integer, MovieDTO> map = ms.movieAll();          
        List<Map<String, Object>> rows = new ArrayList<>();

        for (Map.Entry<Integer, MovieDTO> e : map.entrySet()) {
            int id = e.getKey();
            // 예약안된 영화 거름
            if (ss.seatCounts(id, "reserve") < 1) continue;
            MovieDTO mDTO = e.getValue();
            Map<String, Object> row = new LinkedHashMap<>();
            row.put("id",    id);
            row.put("title", mDTO.getTitle());
            row.put("genre", mDTO.getGenre());
            row.put("type",  mDTO.getType());
            row.put("price", mDTO.getPrice());
            row.put("total", ss.seatCounts(id, "total"));
            row.put("left",  ss.seatCounts(id, "left"));
            rows.add(row);
        }
        return rows;
    }

    /** 영화 + 좌석 단건 데이터 */
    public Map<String, Object> movieInfoData(int id) {
        MovieDTO mDTO = ms.movieInfo(id);
        Map<String, Object> info = new LinkedHashMap<>();
        info.put("id", id);
        info.put("title", mDTO.getTitle());
        info.put("genre", mDTO.getGenre());
        info.put("type",  mDTO.getType());
        info.put("price", mDTO.getPrice());
        info.put("total", ss.seatCounts(id, "total"));
        info.put("left",  ss.seatCounts(id, "left"));
        return info;
    }

    /** 해당영화 좌석 목록 */
    public Map<String, String[]> seatGrid(int id) {
        return ss.seatGrid(id);
    }

    /** 관람등급 옵션 목록 */
    public Map<String, String> ageOptions() {
        return ms.ageOptions();
    }

    /** 영화추가 */
    public boolean add(String title, String code, String genre, int price, int rows, int cols) {
        boolean check = false;
        int pk_id = ms.addMovie(title, code, genre, price);
        if(pk_id > 0) {
            check = ss.addSeat(pk_id, rows, cols);
        }
        return check;
    }

    /** 인덱스 선택 */
    public int selectMovie(String caseStr, String numStr) {
        int idx = Integer.parseInt(numStr) - 1;
        // var = map<k,y>
        var map = ms.movieAll();
        switch (caseStr) {
            case "read": {
                if (idx >= map.size()) return -1;
                int i = 0;
                for (Integer id : map.keySet()) {
                    if (i++ == idx) return id;
                }
                break;
            }
            case "cancel":
                // 예약된 영화만 id값 배열담음
                List<Integer> rervIdList = new ArrayList<>();
                for (Integer id : map.keySet()) {
                    if (ss.seatCounts(id, "reserve") > 0) rervIdList.add(id);
                }
                if (idx >= rervIdList.size()) return -1;
                return rervIdList.get(idx);
            default: return -1;
        }
        return -1;
    }

    /** 영화삭제 */
    public boolean remove(int id) {
        boolean check = false;
        check = ms.removeMovie(id);
        return check;
    }

    /** 좌석코드 확인 */
    public boolean codeCheck(int id, String code) {
        return ss.codeCheck(id, code);
    }

    /** 좌석 예매 */
    public boolean reserve(int id, String code) {
        return ss.reserve(id, code);
    }
    /** 예매 취소 */
    public boolean cancel(int id, String code)  {
        return ss.cancel(id, code);
    }
    
    /** 예매코드 리스트 */
    public List<String> reservedCodes (int id) {
        return ss.reservedCodes(id);
    }

    /** age label 반환 */
    public String ageLabel(String code) {
        return ms.ageLabel(code);
    }

}
