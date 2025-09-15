package week_06._0915.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/liondb";
        String user = "root";
        String password = "root1234";

        String sql = "update dept set dname=? where deptno=?";
        try (
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1,"변경");
            ps.setInt(2,50);

            int resultCnt = ps.executeUpdate();
            if(resultCnt == 1) System.out.println("성공");
            else System.out.println("실패");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}