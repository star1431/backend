package week_06._0915.minprojDB.movies;

import week_06._0915.minprojDB.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;

/** 영화정보 DML class */
public class MoivesDAO {
    static final String table = "movies";
    static final String fkTable = "reserved_seat";

    /** 삭제 */
    public static boolean delete(MoviesDTO MoviesDTO) {
        String sql = "delete from " + table + " where id = ?";
        int result = 0;

        try (
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, MoviesDTO.getId());
            result = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("삭제오류 : " + e.getMessage());
        }

        return result > 0;
    }

    /** 변경 */
    public static boolean update(MoviesDTO MoviesDTO) {
        String sql = "update " + table + " set " +
                "title = ?, age_grade = ?, genre = ?, price = ?" +
                " where id = ?";

        int result = 0;

        try (
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, MoviesDTO.getTitle());
            ps.setString(2, MoviesDTO.getGrade());
            ps.setString(3, MoviesDTO.getGenre());
            ps.setInt(4, MoviesDTO.getPrice());
            ps.setInt(5, MoviesDTO.getId());

            result = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("업데이트오류 : " + e.getMessage());
        }

        return result > 0;
    }

    /** 추가 */
    public static boolean insert(MoviesDTO MoviesDTO) {
        // (null, '어벤져스-엔드게임', 'R15', '히어로', 12000),
        String sql = "insert into " + table +
                "(title, age_grade, genre, price) value " +
                "(?, ?, ?, ?)";

        int result = 0;

        try (
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, MoviesDTO.getTitle());
            ps.setString(2, MoviesDTO.getGrade());
            ps.setString(3, MoviesDTO.getGenre());
            ps.setInt(4, MoviesDTO.getPrice());

            result = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("삽입오류 : " + e.getMessage());
        }

        return result > 0;
    }
}
