package luis122448.util;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    private static final String url = "jdbc:mysql://localhost:3306/project";
    private static final String user = "root";
    private static final String password = "1073741824";
    private static BasicDataSource poolConnection;
    public static BasicDataSource getInstance() throws SQLException {
        if(poolConnection == null){
            poolConnection = new BasicDataSource();
            poolConnection.setUrl(url);
            poolConnection.setUsername(user);
            poolConnection.setPassword(password);
            poolConnection.setInitialSize(5);
            poolConnection.setMaxTotal(10);
            poolConnection.setMaxIdle(5);
            poolConnection.setMinIdle(2);
        }
        return poolConnection;
    }

    public static Connection getConnection() throws SQLException {
        return getInstance().getConnection();
    }
}
