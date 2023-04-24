package com.example.restaurantforusers.dao;

import com.example.restaurantforusers.config.Auth;
import com.example.restaurantforusers.config.ConnectionFactory;
import com.example.restaurantforusers.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO implements IUserDAO{
    @Override
    public boolean login(String nick, String password) {
        User user = getUserByNick(nick);
        return Auth.checkPassword(password, user.getPassword());
    }

    @Override
    public int createUser(User user) {
        try (Connection connection = ConnectionFactory.getConnection() ){
            String query = "INSERT INTO usuario" + "(nick, password)"+
                    "VALUES (?,?)";
            PreparedStatement statement = connection.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getNick());
            statement.setString(2, user.getPassword());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Falha na criação do usuário. Nenhum ID foi gerado.");
                }
            }
        } catch (SQLException e){
            throw  new RuntimeException(e);
        }
        return user.getId();
    }

    private User getUserByNick(String nick){
        String query = "SELECT * FROM usuario WHERE nick = ? ";
        User user;

        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nick);
            statement.executeQuery();
            ResultSet rs = statement.executeQuery();
            rs.next();
            user = new User(
                    rs.getInt("id"),
                    rs.getString("nick"),
                    rs.getString("password")
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
    @Override
    public int resetPassword(String nick, String newPassword) {
        User user = getUserByNick(nick);
        if(user == null){
            return 0;
        }
        try (Connection connection =
                     ConnectionFactory.getConnection()){
            String query = "Update usuario SET " +
                    "password = ? " +
                    "WHERE id = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, Auth.hashPassword(newPassword));
            statement.setInt(2, user.getId());
            statement.executeUpdate();
        }catch (SQLException e){
            throw  new RuntimeException();
        }

        return user.getId();
    }
}
