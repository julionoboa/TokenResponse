package com.items.items.service;

import com.items.items.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService {
    boolean createUser(User user);
    User getUserByUsername (String user);
}
