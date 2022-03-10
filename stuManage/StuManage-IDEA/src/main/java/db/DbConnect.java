package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @ClassName: DbConnect
 * @Author: Leo
 * @Description:
 * @Date: 2019/3/27 21:36
 */
public class DbConnect {
    public static Connection connection;
    public static String url = "jdbc:mysql://localhost/stumanage?user=root&password=root"
            + "&useUnicode=true&characterEncoding=utf-8&useSSL=true";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
