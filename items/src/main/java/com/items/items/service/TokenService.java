package com.items.items.service;

import com.items.items.model.Token;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenService {
    Token generateToken(String username);
    boolean validateActiveTokenByUsername(String username);
    boolean validateActiveTokenByToken(String token);
    Token viewToken(String username);

}
