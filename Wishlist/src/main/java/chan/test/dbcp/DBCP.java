package chan.test.dbcp;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class DBCP{
    public static void main(String[] args) {
        // 데이터베이스 연결 정보 설정
        String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
        String username = "scott";
        String password = "tiger";

        // DBCP BasicDataSource 객체 생성
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        Connection conn = null;
        try {
            // 데이터베이스 연결 테스트
            conn = dataSource.getConnection();
            if (conn != null) {
                System.out.println("데이터베이스 연결 성공!");
            } else {
                System.out.println("데이터베이스 연결 실패!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 연결 종료
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
