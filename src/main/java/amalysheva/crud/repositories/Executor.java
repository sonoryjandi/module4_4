package amalysheva.crud.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Executor {
    private Connection connection;

    public Executor(Connection connection) {
        this.connection = connection;
    }

    public int execUpdate(String update) {
        try {
            Statement statement = connection.createStatement();
            statement.execute(update);
            int updatedLines = statement.getUpdateCount();
            statement.close();
            return updatedLines;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return 0;
    }

    public <T> T execQuery(String query, TResultHandler<T> handler) {
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
            ResultSet resultSet = statement.getResultSet();
            T value = handler.handle(resultSet);
            resultSet.close();
            statement.close();
            return value;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
