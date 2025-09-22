package mini_project.repository;

import mini_project.common.DBUtil;
import mini_project.dto.AgeGradeDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 관람등급 DAO
 * @author 정병천
 * @since 2025-09-17
 */
public class AgeGradeDAO {

    /** 관람등급 단건 선택 */
    public AgeGradeDTO selectByCode(String code) {
        String sql = "SELECT code_name, label FROM age_grade WHERE code_name = ?";
        AgeGradeDTO aDTO = null;
        try (
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, code);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    aDTO = new AgeGradeDTO(
                        rs.getString("code_name"),
                        rs.getString("label")
                    );
                }
            }
        } catch (Exception e) {
            System.out.println("관람등급 선택 error :  " + e.getMessage());
        }
        return aDTO;
    }
    
    /** 관람등급 목록 */
    public List<AgeGradeDTO> selectAll() {
        String sql = "SELECT code_name, label FROM age_grade";
        List<AgeGradeDTO> list = new ArrayList<>();
        try (
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                list.add(
                    new AgeGradeDTO(
                        rs.getString("code_name"),
                        rs.getString("label")
                    )
                );
            }
        } catch (Exception e) {
            System.out.println("관람등급 전체선택 error : " + e.getMessage());
        }
        return list;
    }

    /** 추가(임시) */
    public boolean insert(AgeGradeDTO dto) {
        String sql = "INSERT INTO age_grade(code_name, label) VALUES (?,?)";
        int result = 0;
        try (
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, dto.getCode());
            ps.setString(2, dto.getLabel());
            result = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("관람등급 추가 error : " + e.getMessage());
        }
        return result > 0;
    }

    /** 변경(임시) */
    public boolean update(AgeGradeDTO dto) {
        String sql = "UPDATE age_grade SET label=? WHERE code_name=?";
        int result = 0;
        try (
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, dto.getLabel());
            ps.setString(2, dto.getCode());
            result = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("관람등급 변경 error : " + e.getMessage());
        }
        return result > 0;
    }

    /** 삭제(임시) */
    public boolean delete(String code) {
        String sql = "DELETE FROM age_grade WHERE code_name=?";
        int result = 0;
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, code);
            result = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("관람등급 삭제 error : " + e.getMessage());
        }
        return result > 0;
    }
}