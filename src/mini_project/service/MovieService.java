package mini_project.service;

import mini_project.dto.AgeGradeDTO;
import mini_project.dto.MovieDTO;
import mini_project.repository.MovieDAO;
import mini_project.repository.AgeGradeDAO;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 영화,관람등급 DTO,DAO 서비스
 * @author 정병천
 * @since 2025-09-17
 */
public class MovieService {
    private final MovieDAO mDAO = new MovieDAO();
    private final AgeGradeDAO aDAO = new AgeGradeDAO();

    public MovieService() {
        // 기본생성자
    }

    /** 등급 label 반환 */
    public String ageLabel(String code) {
        AgeGradeDTO dto = aDAO.selectByCode(code);
        return (dto != null) ? dto.getLabel() : null;
    }

    /** 등급 list */
    public Map<String, String> ageOptions() {
        List<AgeGradeDTO> list = aDAO.selectAll();
        Map<String, String> map = new LinkedHashMap<>();
        if (list != null) {
            for (AgeGradeDTO item : list) {
                map.put(item.getCode(), item.getLabel());
            }
        }
        return map;
    }


    /** 영화정보 - id,전체 */
    public Map<Integer, MovieDTO> movieAll() {
        return mDAO.selectAllMap();
    }

    /** 영화정보 - 단건 */
    public MovieDTO movieInfo(int id) {
        return mDAO.selectById(id);
    }

    /** 영화추가 */
    public int addMovie(String title, String type, String genre, int price) {
        int returnId = -1;
        returnId = mDAO.insert(new MovieDTO(title, type, genre, price));
        return returnId;
    }

    /** 영화삭제 */
    public boolean removeMovie(int id) {
        return mDAO.delete(id);
    }
}