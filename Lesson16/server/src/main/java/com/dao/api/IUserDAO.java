package com.dao.api;

import com.entity.User;

public interface IUserDAO extends IBaseDAO<User> {
    Boolean checkUser(User user);
    User getUserByLoginPassword(String login,String password);
}