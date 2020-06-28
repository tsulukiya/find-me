package com.findme.service;

import com.findme.models.User;

public interface UserService {

    User save(User user);

    User update(User user);

    User delete(Long id);

    User findById(Long id);
}
