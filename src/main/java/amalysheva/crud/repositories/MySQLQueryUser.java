package amalysheva.crud.repositories;

import amalysheva.crud.entities.User;

public class MySQLQueryUser implements MySqLQuery<User> {

    @Override
    public String creatTable() {
        return "create table if not exists users (id int auto_increment primary key,login varchar(64) unique,password varchar(64))";
    }

    @Override
    public String insert(User entity) {
        return String.format("insert into users (login, password) values (\"%s\",\"%s\")", entity.getLogin(), entity.getPassword());
    }

    @Override
    public String read(int id) {
        return "select*from users where id=" + id;
    }

    @Override
    public String delete(int id) {
        return "delete from users where id=" + id;
    }

    @Override
    public String updateValue(String field, String newValue, int id) {
        return String.format("UPDATE users SET \"%s\" = '\"%s\"' WHERE id=" + id, field, newValue);
    }
}
