package com.items.items.service;

import com.items.items.model.Token;
import com.items.items.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TokenServiceImplementation implements TokenService {

    @Autowired
    private TokenRepository tokenRepository = new TokenRepository();

    @Override
    public Token generateToken(String username) {
        if (!validateActiveTokenByUsername(username)) {
            String tokenUUID = UUIDGenerator.uuidGenerator().toString();
            LocalDateTime creationTime = LocalDateTime.now();
            LocalDateTime expirationTime = creationTime.plusMinutes(5);
            Token token = new Token(tokenUUID, creationTime, expirationTime, username);
            tokenRepository.addToken(token);
            return token;
        }
        System.out.println("El token se encuentra activo.");
        return null;
    }

    @Override
    public boolean validateActiveTokenByToken(String tokenValue) {
        for (Token token: tokenRepository.viewTokens().values()){
            if (token.getToken().equals(tokenValue)&& token.getExpirationTime().isAfter(LocalDateTime.now())){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean validateActiveTokenByUsername(String username){
        for (Token token: tokenRepository.viewTokens().values()){
            if (token.getUsername().equals(username)&& token.getExpirationTime().isAfter(LocalDateTime.now())){
                return true;
            }
        }
        return false;
    }

    @Override
    public Token viewToken(String username) {
        for (Token token : tokenRepository.viewTokens().values()) {
            if (token.getUsername().equals(username) && token.getExpirationTime().isAfter(LocalDateTime.now())) {
                return token;
            }
        }
        return null;
    }

}
