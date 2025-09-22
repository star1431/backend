package mini_project.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DB 커넥션 유틸
 * @author 정병천
 * @since 2025-09-17
 */
public class DBUtil {
    static final String url = "jdbc:mysql://localhost:3306/minimoviedb";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String user = "star1431";
        String password = "star1431";
        return DriverManager.getConnection(url, user, password);
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
