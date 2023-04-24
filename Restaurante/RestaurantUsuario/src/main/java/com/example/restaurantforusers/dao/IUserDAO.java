package com.example.restaurantforusers.dao;

import com.example.restaurantforusers.model.User;

public interface IUserDAO {
    public boolean login(String nick, String password);
    public int createUser(User user);
    public int resetPassword(String nick, String newPassword);
}
