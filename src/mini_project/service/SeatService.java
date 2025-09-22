package mini_project.service;


import mini_project.dto.ReservedSeatDTO;
import mini_project.repository.ReservedSeatDAO;
import mini_project.dto.SeatDTO;
import mini_project.repository.SeatDAO;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 좌석,예매좌석 DTO,DAO 서비스
 * @author 정병천
 * @since 2025-09-17
 */
public class SeatService {
    private final ReservedSeatDAO rDAO = new ReservedSeatDAO();
    private final SeatDAO sDAO = new SeatDAO();

    public SeatService() {
        
    }

    /** 영화 - 좌석 생성 */
    public boolean addSeat(int id, int rows, int cols) {
        return sDAO.insert(new SeatDTO(id, rows, cols));
    }

    /** 영화 - 좌석정보 */
    public Map<String, String[]> seatGrid(int id) {
        SeatDTO sDTO = sDAO.selectById(id);
        List<ReservedSeatDTO> rervList = rDAO.selectByMovieId(id);

        Map<String, String[]> grid = new LinkedHashMap<>();
        int rows = sDTO.getRows();
        int cols = sDTO.getCols();

        // 좌석 생성 A=[A1,..], B=[B1...]
        int changeNum = (int)'A'; // 아스키 = 65
        for (int i = 0; i < rows; i++) {
            String label = String.valueOf((char)(changeNum + i));
            String[] arr = new String[cols];
            for (int j = 0; j < cols; j++) {
                arr[j] = label + (j + 1); // A1
            }
            grid.put(label, arr);
        }

        // 예약좌석 마스킹
        for (ReservedSeatDTO item : rervList) {
            String code = item.getSeatCode();
            if (code == null) continue; // null 건너뜀

            String key = code.substring(0, 1);
            int idx = Integer.parseInt(code.substring(1)) - 1;
            String[] row = grid.get(key);
            if (idx >= 0 && idx < row.length) row[idx] = "__";
        }
        
        return grid;
    }


    /** id - 좌석정보 */
    public int seatCounts(int id, String caseStr) {
        List<ReservedSeatDTO> rervList = rDAO.selectByMovieId(id);
        SeatDTO sDTO = sDAO.selectById(id);
        switch (caseStr) {
            case "total" :
                return sDTO.getTotal();
            case "reserve":
                return rervList.size();
            case "left" :
                return sDTO.getTotal() - rervList.size();

        }
        return -1;
    }


    /** 예약 정보 */
    public List<String> reservedCodes(int id) {
        List<String> codelist = new ArrayList<>();
        List<ReservedSeatDTO> rervList = rDAO.selectByMovieId(id);
        for(ReservedSeatDTO item : rervList) {
            codelist.add(item.getSeatCode());
        }
        return codelist;
    }

    /** 좌석 코드 유효성 */
    public boolean codeCheck(int id, String code) {
        SeatDTO s = sDAO.selectById(id);
        int rows = s.getRows();
        int cols = s.getCols();
        char fchar = code.charAt(0);
        int codeKey = (int) fchar;
        int codeVal = Integer.parseInt(code.substring(1));

        // DB저장된 row,col 값보다 크면 false
        if(codeKey < (int)'A'  && codeVal < 1) return false;
        else if(codeKey <= ((int)'A' + rows) && codeVal > cols) return false;
        else return true;
    }


    /** 예매 등록 */
    public boolean reserve(int id, String code) {
        if (!codeCheck(id, code)) return false;

        List <ReservedSeatDTO> rervList = rDAO.selectByMovieId(id);
        if(rervList.isEmpty()) {
            return rDAO.insert(new ReservedSeatDTO(id, code));
        }
        int cnt = 0;
        for(ReservedSeatDTO item : rervList) {
            if(code.equals(item.getSeatCode())) cnt ++;
        }
        if(cnt > 0) return false;
        else return rDAO.insert(new ReservedSeatDTO(id, code));
    }

    /** 예매 취소 */
    public boolean cancel(int id, String code) {
        if (!codeCheck(id, code)) return false;

        List <ReservedSeatDTO> rervList = rDAO.selectByMovieId(id);
        if(rervList.isEmpty()) return false;

        int cnt = 0;
        for(ReservedSeatDTO item : rervList) {
            if(code.equals(item.getSeatCode())) cnt ++;
        }
        if(cnt == 0) return false;
        else return rDAO.delete(id, code);
    }

}