package week_06._0915.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/liondb";
        String user = "root";
        String password = "root1234";

        String sql = "select deptno, dname, loc from dept where deptno = ?";
        try (
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1, 10);
            try (ResultSet rs = ps.executeQuery()) {
                // 6) 결과 읽기: 행이 있으면 커서가 다음 행으로 이동하고 true
                if (rs.next()) {
                    // 컬럼 라벨(이름)으로 꺼내는 게 안전
                    int deptno      = rs.getInt("deptno");
                    String dname    = rs.getString("dname");
                    String loc      = rs.getString("loc");

                    System.out.printf("성공: deptno=%d, dname=%s, loc=%s%n", deptno, dname, loc);
                } else {
                    System.out.println("실패(해당 조건의 행이 없음)");
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}