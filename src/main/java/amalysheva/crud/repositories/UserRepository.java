package amalysheva.crud.repositories;

import amalysheva.crud.entities.User;

import java.sql.Connection;

public class UserRepository implements Repository<User> {
    private final Executor executor;
    private final MySqLQuery<User> dbQuery;

    public UserRepository(Connection connection, MySqLQuery<User> dbQuery) {
        executor = new Executor(connection);
        this.dbQuery = dbQuery;
    }

    @Override
    public void insert(User user) {
        executor.execUpdate(dbQuery.insert(user));
    }

    @Override
    public User read(int id) {
        String q = dbQuery.read(id);
        return executor.execQuery(q, resultSet -> {
            resultSet.next();
            return new User(resultSet.getInt("id"), resultSet.getString("login"), resultSet.getString("password"));
        });
    }

    public int getUserId(){
        return
    }

    @Override
    public User update() {
        return null;
    }

    @Override
    public void delete() {

    }

    public void createTable() {
        executor.execUpdate(dbQuery.creatTable());
    }
}
