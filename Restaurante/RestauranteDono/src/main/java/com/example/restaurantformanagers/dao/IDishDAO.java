package com.example.restaurantformanagers.dao;

import com.example.restaurantformanagers.model.Dish;

import java.util.List;

public interface IDishDAO {

    Dish create (Dish dish);
    Dish update (Dish dish);

    void delete (int id);

    List<Dish> findAll();

}
