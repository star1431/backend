package week_06._0915.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {
    public static void main(String[] args) throws Exception {
        String url = "jdbc:mysql://localhost:3306/liondb";
        String user = "root";
        String password = "root1234";

        String sql = "insert into dept(deptno, dname, loc) values (?,?,?)";
        try (
            Connection conn = DriverManager.getConnection(url,user,password);
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1,50);
            ps.setString(2,"lion");
            ps.setString(3,"seoul");

            int resultCnt = ps.executeUpdate();
            if(resultCnt == 1) System.out.println("성공");
            else System.out.println("실패");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}