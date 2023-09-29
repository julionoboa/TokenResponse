package com.items.items.service;

import com.items.items.model.Items;

import java.util.List;

public interface ItemsService {
    boolean addItems(String token, Items items);
    List<Items> viewItemsByToken(String token);
    List<Items> viewItemsByTokenAndUsername(String token, String username);
}
