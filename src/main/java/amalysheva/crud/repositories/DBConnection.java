package amalysheva.crud.repositories;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    Connection connection;
//    Executor executor;????

    public static Connection getConnection() {
        StringBuilder url = new StringBuilder();
        url.append(Settings.DB_PREFIX)
                .append(Settings.DB_HOST)
                .append(Settings.DB_PORT)
                .append(Settings.DB_NAME)
                .append(Settings.DB_USER)
                .append(Settings.DB_PASSWORD);
        try {
            Connection connection = DriverManager.getConnection(url.toString());
            if (connection.isValid(10)) {
                System.out.println("Connection OK");
            }
            return connection;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
