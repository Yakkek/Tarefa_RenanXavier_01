package com.example.restaurantforusers.dao;

import com.example.restaurantforusers.model.Dish;

import java.util.List;

public interface IDishDAO {

    public void setOrderToDish(Dish dish);
    public List<Dish> findAll();


}
