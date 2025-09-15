package week_05._0912.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionTest {
    public static void main(String[] args) throws Exception {
        // https://mvnrepository.com/repos
        // file - 프로젝트구조 - 라이브러리 - 메이븐
        // mysql:mysql-connector-java:8.0.33

        // 드라이버 클래스 로드 - DriverManager에 자동 등록 (옛날엔 필수 / 지금은 아님)
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // 1. db 접속시도. Connection -> 접속 추상화 객체
        Connection connection = null;
        String url = "jdbc:mysql://localhost:3306/liondb";
        String user = "star1431";
        String pw = "star1431";
        connection = DriverManager.getConnection(url, user, pw);

        if(connection != null) System.out.println("성공");
        else System.out.println("실패");

    }
}
