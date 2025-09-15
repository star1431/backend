package week_06._0915.lionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
    static final String url = "jdbc:mysql://localhost:3306/liondb";

    public static Connection getConnection() throws Exception {
        String user = "root";
        String password = "root1234";

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
