package repositories;

import models.User;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryImpl implements UsersRepository{

    private Connection connection;

    //language=sql
    private final String SQL_INSERT_USER = "INSERT INTO users(nickname, passwordHash) VALUES (?, ?)";
    private final String SQL_FIND_USER_BY_LOGIN = "SELECT * FROM users WHERE login=?;";

    public UsersRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public User save(User user) {
        ResultSet resultSet = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_USER, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getNickname());
            preparedStatement.setString(2, user.getPasswordHash());

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                user.setId(resultSet.getLong("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public User findByLogin(String nickname) {
        ResultSet resultSet = null;
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FIND_USER_BY_LOGIN);
            preparedStatement.setString(1, nickname);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setNickname(resultSet.getString("nickname"));
                user.setPasswordHash(resultSet.getString("passwordHash"));

            }
        } catch (SQLException throwable) {
            //
        }
        return user;
    }
}
