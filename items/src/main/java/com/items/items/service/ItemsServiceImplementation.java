package com.items.items.service;

import com.items.items.model.Items;
import com.items.items.model.Token;
import com.items.items.repository.ItemsRepository;
import com.items.items.repository.LoginRepository;
import com.items.items.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemsServiceImplementation implements ItemsService{
    @Autowired
    private UserRepository userRepository = new UserRepository();
    @Autowired
    private UserService userService = new UserServiceImplementation();
    @Autowired
    private LoginRepository loginRepository = new LoginRepository();
    @Autowired
    private TokenService tokenService;
    @Autowired
    private ItemsRepository itemsRepository = new ItemsRepository();
    @Override
    public boolean addItems(String token, Items items) {
        if (tokenService.validateActiveTokenByToken(token)){
            items.setToken(token);
            itemsRepository.addItems(items);
            return true;
        }
        return false;
    }

    @Override
    public List<Items> viewItemsByToken(String token){
        List<Items> itemsListNew = new ArrayList<>();

        for(Items items: itemsRepository.viewItems()){
            if (items.getToken().equals(token)){
                itemsListNew.add(items);
            }
        }
        return itemsListNew;
    }

    @Override
    public List<Items> viewItemsByTokenAndUsername(String token, String username){
        List<Items> itemsListNew = new ArrayList<>();

        for(Items items: itemsRepository.viewItems()){
            if (items.getToken().equals(token) && items.getUsername().equals(username)){
                itemsListNew.add(items);
            }
        }
        return itemsListNew;
    }
}
