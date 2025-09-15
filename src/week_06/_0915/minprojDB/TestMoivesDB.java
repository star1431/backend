package week_06._0915.minprojDB;

import week_06._0915.minprojDB.movies.MoviesDTO;
import week_06._0915.minprojDB.movies.MoivesDAO;

public class TestMoivesDB {
    static MoivesDAO mDAO = new MoivesDAO();
    static MoviesDTO mDTO = new MoviesDTO("인터스텔라", "R15", "SF", 18000);

    public static void insertTest() {
        boolean insert = mDAO.insert(mDTO);
        if(insert) System.out.println("추가됨");
        else System.out.println("추가안됨 - " + mDTO);
    }

    public static void deleteTest() {
        mDTO.setId(5);
        boolean delete = mDAO.delete(mDTO);
        if(delete) System.out.println("삭제됨");
        else System.out.println("삭제안됨 - " + mDTO);
    }

    public static void updateTest() {
        mDTO.setId(5);
        mDTO.setPrice(15000);
        boolean update = mDAO.update(mDTO);
        if(update) System.out.println("변경됨");
        else System.out.println("변경안됨 - " + mDTO);
    }


    public static void main(String[] args) {

        // 테스트
        // insertTest();
        // deleteTest();
        // updateTest();

    }
}
