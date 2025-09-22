package mini_project.repository;

import mini_project.common.DBUtil;
import mini_project.dto.ReservedSeatDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 예매좌석 DAO
 * @author 정병천
 * @since 2025-09-17
 */
public class ReservedSeatDAO {

    /** 무비id 기준으로 예약좌석 집합 */
    public List<ReservedSeatDTO> selectByMovieId(int movieId) {
        List<ReservedSeatDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM reserved_seat WHERE movie_id = ?";
        try (
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, movieId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ReservedSeatDTO seat = new ReservedSeatDTO(
                        rs.getInt("movie_id"),
                        rs.getString("seat_code")
                    );
                    list.add(seat);
                }
            }
        } catch (Exception e) {
            System.out.println("예매 조회 error : " + e.getMessage());
        }
        return list;
    }

    /** 삽입 */
    public boolean insert(ReservedSeatDTO reservedSeat) {
        String sql = "INSERT INTO reserved_seat (movie_id, seat_code) VALUES (?, ?)";
        int result = 0;
        try (
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, reservedSeat.getMovieId());
            ps.setString(2, reservedSeat.getSeatCode());
            result = ps.executeUpdate();
        } catch (Exception e) { 
            System.out.println("예매 삽입 error : " + e.getMessage());
        }
        return  result > 0;
    }

    /** 삭제 */
    public boolean delete(int movieId, String seatCode) {
        String sql = "DELETE FROM reserved_seat WHERE movie_id = ? AND seat_code = ?";
        int result = 0;
        try (
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, movieId);
            ps.setString(2, seatCode);
            result = ps.executeUpdate();
        } catch (Exception e) { 
            System.out.println("예매 삭제 error : " + e.getMessage());
        }
        return result > 0;
    }
}