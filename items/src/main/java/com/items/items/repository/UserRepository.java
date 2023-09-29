package com.items.items.repository;

import com.items.items.model.User;
import com.items.items.service.UUIDGenerator;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class UserRepository {
    private Map<UUID, User> userMap = new HashMap<>();

    public void addUser(User user) {
        userMap.put(UUIDGenerator.uuidGenerator(), user);
    }
    public User getUserByUsername(String username){
        for (User user: userMap.values()){
            if (user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }
}
