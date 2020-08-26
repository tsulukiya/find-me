package com.findme.dao;

import com.findme.models.User;

public interface UserRepository {

    User save(User user);

    User update(User user);

    User delete(Long id);

    User findById(Long id);

    User userLogin(String login, String password);
}
