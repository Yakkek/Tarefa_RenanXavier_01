package com.example.restaurantformanagers.model;

public class Dish {
    private int id;
    private String name;

    private DishType type;
    private int orderNumber;

    public Dish(int id, String name, DishType type, int orderNumber) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.orderNumber = orderNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DishType getType() {
        return type;
    }

    public void setType(DishType type) {
        this.type = type;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Dish() {
    }
}
