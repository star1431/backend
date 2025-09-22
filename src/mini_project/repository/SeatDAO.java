package mini_project.repository;

import mini_project.common.DBUtil;
import mini_project.dto.SeatDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 좌석 DAO
 * @author 정병천
 * @since 2025-09-17
 */
public class SeatDAO {

    /** 삽입 */
    public boolean insert(SeatDTO sDTO) {
        String sql = "INSERT INTO seats (movie_id, row_num, col_num) VALUES (?, ?, ?)";
        int result = 0;
        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, sDTO.getMovieId());
            ps.setInt(2, sDTO.getRows());
            ps.setInt(3, sDTO.getCols());
            result = ps.executeUpdate();
        } catch (Exception e) { 
            System.out.println("좌석 삽입 error : " + e.getMessage());
        }
        return result > 0;
    }

    /** 삭제 */
    public void delete(int movieId) {
        String sql = "DELETE FROM seats WHERE movie_id = ?";
        try (
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, movieId);
            ps.executeUpdate();
        } catch (Exception e) { 
            System.out.println("좌석 삭제 error : " + e.getMessage());
        }
    }

    /** 단건조회(id) */
    public SeatDTO selectById(int id) {
        String sql = "SELECT * FROM seats WHERE movie_id = ?";
        SeatDTO sDTO = null;
        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if(rs.next()) sDTO = resultSet(rs);
            }
        } catch (Exception e) {
            System.out.println("좌석 단건조회(id) error : " + e.getMessage());
        }
        return sDTO;
    }
    /** ResultSet -> DTO 변환 */
    private SeatDTO resultSet(ResultSet rs) throws SQLException {
        SeatDTO sDTO = new SeatDTO();
        sDTO.setMovieId(rs.getInt("movie_id"));
        sDTO.setRows(rs.getInt("row_num"));
        sDTO.setCols(rs.getInt("col_num"));

        return sDTO;
    }
}