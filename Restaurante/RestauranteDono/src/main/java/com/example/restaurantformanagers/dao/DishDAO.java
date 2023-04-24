package com.example.restaurantformanagers.dao;

import com.example.restaurantformanagers.config.ConnectionFactory;
import com.example.restaurantformanagers.model.Dish;
import com.example.restaurantformanagers.model.DishType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DishDAO implements IDishDAO{
    @Override
    public Dish create(Dish dish) {
        try (Connection connection = ConnectionFactory.getConnection() ){
            String query = "INSERT INTO prato" + "( name, type, orderNumber)"+
                    "VALUES (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, dish.getName());
            statement.setString(2, dish.getType().getDisplayName());
            statement.setInt(3, 0);
            statement.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        return dish;
    }

    @Override
    public Dish update(Dish dish) {
        try (Connection connection =
                     ConnectionFactory.getConnection()){
            String query = "Update prato SET " +
                    "name = ?, type = ?" +
                    "WHERE id = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, dish.getName());
            statement.setString(2, dish.getType().getDisplayName());
            statement.setInt(3, dish.getId());

            statement.executeUpdate();
        }catch (SQLException e){
            throw  new RuntimeException();
        }
        return dish;
    }

    @Override
    public void delete(int id) {
        try (Connection connection =
                     ConnectionFactory.getConnection()){
            String query = "Delete FROM prato Where id = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setLong(1,id);
            statement.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Dish> findAll() {
        String query = "SELECT * FROM prato";
        List<Dish> lista = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getConnection() ) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeQuery();
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Dish dish =new Dish();
                dish.setId(rs.getInt("id"));
                dish.setName(rs.getString("name"));
                dish.setType(DishType.fromString(rs.getString("type")));
                dish.setOrderNumber(rs.getInt("orderNumber"));
                lista.add(dish);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
}
