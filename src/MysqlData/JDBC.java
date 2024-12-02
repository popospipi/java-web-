package MysqlData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
    private Connection conn = null;
    private String url = "jdbc:mysql://localhost:3306/animation";//数据库名称
    private String user = "root";//用户名
    private String password = "823181698";//密码

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, password);
        return conn;
    }
}
