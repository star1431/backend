package week_06._0916.kr.likelion.demo.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
    static final String url =
            "jdbc:mysql://localhost:3306/liondb" +
            "?useSSL=false" +
            "&serverTimezone=Asia/Seoul" +
            "&characterEncoding=UTF-8";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String user = "star1431";
        String password = "star1431";

        return DriverManager.getConnection(url, user, password);
    }

    public static void autoCommit(Connection conn, boolean check) {
        if(conn != null){
            try {
                conn.setAutoCommit(check);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void commit(Connection conn) {
        if(conn != null){
            try {
                conn.commit();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void rollback(Connection conn) {
        if(conn != null){
            try {
                conn.rollback();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void close(Connection conn) {
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void close(PreparedStatement ps) {
        if(ps != null){
            try {
                ps.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void close(ResultSet rs) {
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
