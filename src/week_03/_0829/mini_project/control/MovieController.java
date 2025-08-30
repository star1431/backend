package week_03._0829.mini_project.control;

import week_03._0829.mini_project.model.Movie;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * MovieController Class
 * info : 영화 관리 클래스
 * @author 정병천
 */
public class MovieController {
    private final Map<String, Movie> movieMap = new LinkedHashMap<>();
    private int idCnt = 1;

    public MovieController() {}

    /**
     * 영화 추가
     * @param title 영화제목
     * @param type 등급
     * @param genre 장르
     * @param price 가격
     * @return 생성된 id값 전달
     */
    public String addMovie(String title, String type, String genre, int price) {
        String id = String.format("M-%04d", idCnt++); // M-0001 시작
        movieMap.put(id, new Movie(id, title, type, genre, price)); // key:id | val:영화생성
        return id;
    }

    /**
     * 영화 제거
     * @param id 영화 고유아이디
     */
    public void removeMovie(String id) {
        movieMap.remove(id);
    }

    // 제목 아이디 값 get
    public String getId(String title) {
        for (Movie movie : movieMap.values()) {
            if (movie.getTitle().equals(title)) {
                return movie.getId();
            }
        }
        return null;
    }

    // 총 갯수 전달
    public int getTotal() {
        return movieMap.size();
    }

    // 해당 영화 정보 전달
    public Movie findMovie (String id) {
        return movieMap.get(id);
    }

    // 무비 해시맵 전달
    public Map<String, Movie> getMovieMap() {
        return movieMap;
    }
}
