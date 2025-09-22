package mini_project.repository;

import mini_project.common.DBUtil;
import mini_project.dto.MovieDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 영화 DAO
 * @author 정병천
 * @since 2025-09-17
 */
public class MovieDAO {

    /** 삽입 */
    public int insert(MovieDTO movie) {
        String sql = "INSERT INTO movies(title, age_grade, genre, price) VALUES (?, ?, ?, ?)";
        int result = 0;
        try (
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)
        ) {
            ps.setString(1, movie.getTitle());
            ps.setString(2, movie.getType());
            ps.setString(3, movie.getGenre());
            ps.setInt(4, movie.getPrice());
            result = ps.executeUpdate();
            if(result > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if(rs.next()) movie.setMovieId(rs.getInt(1));
                }
            }
        } catch (Exception e) {
            System.out.println("영화 삽입 error : " + e.getMessage());
        }
        return movie.getMovieId();
    }

    /** 삭제 */
    public boolean delete(int id) {
        String sql = "DELETE FROM movies WHERE id = ?";
        int result = 0;
        try (
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            result = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("영화 삭제 error : " + e.getMessage());
        }
        return result > 0;
    }

    /** 변경 */
    public boolean update(MovieDTO movie) {
    String sql = "UPDATE movies SET title=?, age_grade=?, genre=?, price=? WHERE id=?";
        int result = 0;
        try (
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, movie.getTitle());
            ps.setString(2, movie.getType());
            ps.setString(3, movie.getGenre());
            ps.setInt(4, movie.getPrice());
            ps.setInt(5, movie.getMovieId());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("영화 변경 error : " + e.getMessage());
        }
        return result > 0;
    }

    /** 단건조회(id) */
    public MovieDTO selectById(int id) {
        String sql = "SELECT * FROM movies WHERE id = ?";
        MovieDTO mDTO = null;
        try (
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if(rs.next()) mDTO = resultSet(rs);
            }
        } catch (Exception e) {
            System.out.println("영화 단건조회(id) error : " + e.getMessage());
        }
        return mDTO;
    }

    /** 전체조회 list(DTO) */
    public List<MovieDTO> selectAll() {
        String sql = "SELECT * FROM movies";
        List<MovieDTO> list = new ArrayList<>();
        try (
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                list.add(resultSet(rs));
            }
        } catch (Exception e) {
            System.out.println("영화 전체조회 error : " + e.getMessage());
        }
        return list;
    }

    /** 전체조회 map(id,DTO) */
    public Map<Integer, MovieDTO> selectAllMap() {
        String sql = "SELECT * FROM movies";
        Map<Integer, MovieDTO> map = new HashMap<>();
        try (
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                map.put(rs.getInt("id"), resultSet(rs));
            }
        } catch (Exception e) {
            System.out.println("영화 전체조회 error : " + e.getMessage());
        }
        return map;
    }

    /** ResultSet -> DTO 변환 */
    private MovieDTO resultSet(ResultSet rs) throws SQLException {
        MovieDTO mDTO = new MovieDTO();
        mDTO.setMovieId(rs.getInt("id"));
        mDTO.setTitle(rs.getString("title"));
        mDTO.setType(rs.getString("age_grade"));
        mDTO.setGenre(rs.getString("genre"));
        mDTO.setPrice(rs.getInt("price"));

        return mDTO;
    }
}