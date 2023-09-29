package com.items.items.service;

import com.items.items.model.Login;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginService {
    boolean validateLogin(Login login);
}
