package com.example.restaurantforusers.dao;

import com.example.restaurantforusers.config.ConnectionFactory;
import com.example.restaurantforusers.model.Dish;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DishDAO implements IDishDAO{
    @Override
    public void setOrderToDish(Dish dish) {
        dish = findDishById(dish.getId());
        try (Connection connection =
                     ConnectionFactory.getConnection()){
            String query = "Update prato SET " +
                    "orderNumber = ? " +
                    "WHERE id = ?;";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, dish.getOrderNumber() + 1);
            statement.setInt(2, dish.getId());

            statement.executeUpdate();
        }catch (SQLException e){
            throw  new RuntimeException();
        }
    }

    private Dish findDishById(int id){
        String query = "SELECT * FROM prato WHERE id = ? ";
        Dish dish = new Dish();
        try (Connection connection = ConnectionFactory.getConnection() ) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.executeQuery();
            ResultSet rs = statement.executeQuery();
            if (rs.next()){
                dish.setId(rs.getInt("id"));
                dish.setName(rs.getString("name"));
                dish.setType(rs.getString("type"));
                dish.setOrderNumber(rs.getInt("orderNumber"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dish;
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
                dish.setType(rs.getString("type"));
                lista.add(dish);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
}
