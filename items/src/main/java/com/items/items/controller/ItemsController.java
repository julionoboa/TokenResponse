package com.items.items.controller;

import com.items.items.model.*;
import com.items.items.service.ItemsService;
import com.items.items.service.LoginService;
import com.items.items.service.TokenService;
import com.items.items.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemsController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ItemsService itemsService;

    @GetMapping("/")
    public String greetings() {
        return "Bienvenidos a mi API";
    }

    @PostMapping("/api/user")
    public User user(@RequestBody User user) {
        userService.createUser(user);
        return user;
    }

    @GetMapping("/api/login")
    public ResponseEntity<TokenResponse> login(@RequestBody Login login) {
        if (loginService.validateLogin(login)) {
            Token token = tokenService.generateToken(login.getUsername());
            if (token != null) {
                return ResponseEntity.ok(new TokenResponse(token.getToken(), token.getUsername(), "Token generado exitosamente."));
            }
            if (token == null){
                token = tokenService.viewToken(login.getUsername());
                return ResponseEntity.ok(new TokenResponse(token.getToken(), token.getUsername(), "Este usuario tiene un token activo."));
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

    }

    @GetMapping("/api/product/item")
    public String addItem(@RequestParam String token, @RequestBody Items items) {
        if (itemsService.addItems(token, items)) {
            return "Objeto agregado. " + "Item: " + items.getItem() + ", Username: " + items.getUsername() + ", Brand: " + items.getBrand() + ", Price: " + items.getPrice();
        }
        return "Eres un mmg";
    }

    @GetMapping("/api/product/allItems")
    public List<Items> showItemsByToken(@RequestParam String token) {
        return itemsService.viewItemsByToken(token);
    }

    @GetMapping("/api/product/id")
    public Items showItemByID(@RequestParam String token, @RequestParam String id) {
        return null;
    }
}