package week_06._0915.minprojDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
    static final String url = "jdbc:mysql://localhost:3306/minprojdb";

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        String user = "star1431";
        String password = "star1431";

        return DriverManager.getConnection(url, user, password);
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
