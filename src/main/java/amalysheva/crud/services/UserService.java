package amalysheva.crud.services;

import amalysheva.crud.entities.User;
import amalysheva.crud.exceptions.WrongPasswordException;
import amalysheva.crud.repositories.DBConnection;
import amalysheva.crud.repositories.MySqLQuery;
import amalysheva.crud.repositories.UserRepository;

import java.sql.Connection;
import java.sql.SQLException;

public class UserService implements Service<User> {
    private final Connection connection;
    private final UserRepository repository;
    private MySqLQuery<User> dbUserQuery; //??????

    public UserService(Connection connection, UserRepository repository) {
        this.connection = connection;
        this.repository = repository;
    }

    public UserService(){
        connection = DBConnection.getConnection();
        repository = new UserRepository(connection, dbUserQuery);
        repository.createTable();
    }


    @Override
    public int create(User user) throws SQLException {
        connection.setAutoCommit(false);
        repository.insert(user);
        connection.commit();
        return repository.getUserId();
    }

    @Override
    public User read(User user) {
        int id = repository.getEntityId(user);
        if(!user.getPassword().equals(repository.getPassword(id))){
            throw new WrongPasswordException("Wrong password");
        }
        return repository.read(id);
    }

    @Override
    public User update(User entity, String value) {
        return null;
    }

    @Override
    public void delete() {

    }
}
