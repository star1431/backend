package week_06._0916.kr.likelion.demo.repository;

import week_06._0916.kr.likelion.demo.common.DBUtil;
import week_06._0916.kr.likelion.demo.dto.ProductDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    /** 삽입 및 아이디 get */
    @Override
    public int insertAndGetId(ProductDTO pDTO) {
        String sql = "INSERT INTO products(name, price, reg_date) VALUES (?, ?, now())";
        int result = 0;

        try (
                Connection conn = DBUtil.getConnection();
                // Statement.RETURN_GENERATED_KEYS
                // = INSERT 실행 후 DB에서 생성된 자동 증가 키(AUTO_INCREMENT 값)를 가져오도록 설정
                PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
            ps.setString(1, pDTO.getName());
            ps.setInt(2, pDTO.getPrice());
            result = ps.executeUpdate();
            if(result > 0) {
                // ps.getGeneratedKeys()
                // = INSERT 실행 시 생성된 자동 증가 키를 ResultSet 형태로 반환
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    // getGeneratedKeys 는 컬럼명 없음
                    if(rs.next()) pDTO.setId(rs.getInt(1));
                }
            }
        } catch (Exception e) {
            System.out.println("삽입(id) error : " + e.getMessage());
        }

        return pDTO.getId();
    }

    /** 삽입 */
    @Override
    public boolean insert(ProductDTO pDTO) {
        String sql = "INSERT INTO products(name, price, reg_date) VALUES (?, ?, now())";
        int result = 0;

        try (
            Connection conn = DBUtil.getConnection();
            // Statement.RETURN_GENERATED_KEYS
            // = INSERT 실행 후 DB에서 생성된 자동 증가 키(AUTO_INCREMENT 값)를 가져오도록 설정
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
            ps.setString(1, pDTO.getName());
            ps.setInt(2, pDTO.getPrice());
            result = ps.executeUpdate();
            if(result > 0) {
                // ps.getGeneratedKeys()
                // = INSERT 실행 시 생성된 자동 증가 키를 ResultSet 형태로 반환
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    // getGeneratedKeys 는 컬럼명 없음
                    if(rs.next()) pDTO.setId(rs.getInt(1));
                }
            }
        } catch (Exception e) {
            System.out.println("삽입 error : " + e.getMessage());
        }

        return result > 0;
    }

    /** 삭제 (id) */
    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM products WHERE id = ?";
        int result = 0;

        try (
                Connection conn = DBUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setInt(1, id);
            result = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("삭제 error : " + e.getMessage());
        }

        return result > 0;
    }

    /** 삭제 (dto) */
    @Override
    public boolean delete(ProductDTO pDTO) {
        String sql = "DELETE FROM products WHERE id = ?";
        int result = 0;

        try (
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setInt(1, pDTO.getId());
            result = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("삭제 error : " + e.getMessage());
        }

        return result > 0;
    }

    /** 변경 */
    @Override
    public boolean update(ProductDTO pDTO) {
        String sql = "UPDATE products SET " +
                "name = ?, price = ? " +
                "WHERE id = ?";
        int result = 0;

        try (
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, pDTO.getName());
            ps.setInt(2, pDTO.getPrice());
            ps.setInt(3, pDTO.getId());
            result = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("변경 error : " + e.getMessage());
        }

        return result > 0;
    }

    /** 단건조회(id) */
    @Override
    public ProductDTO select(int id) {
        String sql = "SELECT * FROM products WHERE id = ?";
        ProductDTO pDTO = null;
        try (
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if(rs.next()) pDTO = resultSet(rs);
            } catch (Exception e) {
                System.out.println("단건선택(id) DTO 삽입 error :" + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("단건선택(id) error : " + e.getMessage());
        }

        return pDTO;
    }
    /** 단건조회(name) */
    @Override
    public ProductDTO select(String name) {
        String sql = "SELECT * FROM products WHERE name = ?";
        ProductDTO pDTO = null;

        try (
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if(rs.next()) pDTO = resultSet(rs);
            } catch (Exception e) {
                System.out.println("단건선택(name) DTO 삽입 error :" + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("단건선택(name) error : " + e.getMessage());
        }

        return pDTO;
    }

    /** 전체조회 */
    @Override
    public List<ProductDTO> selectAll() {
        String sql = "SELECT * FROM products";
        List<ProductDTO> lists = new ArrayList<>();

        try (
            Connection conn = DBUtil.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                lists.add(resultSet(rs));
            }
        } catch (Exception e) {
            System.out.println("전체선택 error : " + e.getMessage());
        }

        return lists;
    }

    /** 리절트 공통 */
    private ProductDTO resultSet(ResultSet rs) throws SQLException {
        ProductDTO pDTO = new ProductDTO();
        pDTO.setId(rs.getInt("id"));
        pDTO.setName(rs.getString("name"));
        pDTO.setPrice(rs.getInt("price"));
        // pDTO.setRegdate(rs.getTimestamp("reg_date").toLocalDateTime());
        Timestamp regDate = rs.getTimestamp("reg_date");
        if(regDate != null) pDTO.setRegdate(regDate.toLocalDateTime());

        return pDTO;
    }
}
