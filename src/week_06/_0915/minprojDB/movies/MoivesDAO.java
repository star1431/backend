package week_06._0915.minprojDB.movies;

import week_06._0915.minprojDB.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/** 영화정보 DML class */
public class MoivesDAO {
    static final String table = "movies";
    static final String fkTable = "reserved_seat";

    /** 삭제 */
    public boolean delete(MoviesDTO MoviesDTO) {
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
    public boolean update(MoviesDTO MoviesDTO) {
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
    public boolean insert(MoviesDTO MoviesDTO) {
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
            if (result > 0) {
                // getGeneratedKeys - DB가 생성한 키(AUTO_INCREMENT, IDENTITY, 시퀀스 같은 것)
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    // AUTO_INCREMENT로 생성된 id값 넣기
                    if (rs.next()) MoviesDTO.setId(rs.getInt("id"));
                }
            }
        } catch (Exception e) {
            System.out.println("삽입오류 : " + e.getMessage());
        }

        return result > 0;
    }

    /** 단건조회 (title) */
    public MoviesDTO getDept(String title) {
        String sql = "select * from " + table +  " where title = ?";
        MoviesDTO mdto = null;

        try(
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, title);
            try(ResultSet rs = ps.executeQuery()) {
                if(rs.next()) {
                    mdto = new MoviesDTO();
                    mdto.setId(rs.getInt("id"));
                    mdto.setTitle(rs.getString("title"));
                    mdto.setGrade(rs.getString("age_grade"));
                    mdto.setGrade(rs.getString("genre"));
                    mdto.setPrice(rs.getInt("price"));
                }
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return  mdto;
    }
    /** 단건조회 (id) */
    public MoviesDTO getDept(int id) {
        String sql = "select * from " + table +  " where id = ?";
        MoviesDTO mdto = null;

        try(
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()) {
                if(rs.next()) {
                    mdto = new MoviesDTO();
                    mdto.setId(rs.getInt("id"));
                    mdto.setTitle(rs.getString("title"));
                    mdto.setGrade(rs.getString("age_grade"));
                    mdto.setGrade(rs.getString("genre"));
                    mdto.setPrice(rs.getInt("price"));
                }
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return  mdto;
    }


}
