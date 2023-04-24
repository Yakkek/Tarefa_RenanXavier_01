package com.example.restaurantforusers.model;

public class Dish {
    private int id;
    private String name;
    private String type;

    private int orderNumber;

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getId() {
        return id;
    }

    public Dish(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Dish() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
