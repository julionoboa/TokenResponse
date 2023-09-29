package com.items.items.repository;

import com.items.items.model.Token;
import com.items.items.service.UUIDGenerator;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class TokenRepository {
    private Map<UUID, Token> tokenMap = new HashMap<>();

    public void addToken(Token token){
        tokenMap.put(UUIDGenerator.uuidGenerator(),token);
    }
    public Map<UUID, Token> viewTokens(){
        return tokenMap;
    }
}
