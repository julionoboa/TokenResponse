package com.items.items.repository;

import com.items.items.model.Login;
import com.items.items.service.UUIDGenerator;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class LoginRepository {
    Map<UUID, Login> loginMap = new HashMap<>();

    public void addLogin(Login login){
        loginMap.put(UUIDGenerator.uuidGenerator(), login);
    }
}
