package com.items.items.repository;

import com.items.items.model.Items;
import com.items.items.service.UUIDGenerator;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ItemsRepository {
    Map<UUID, Items> itemsMap = new HashMap<>();

    public void addItems(Items items){
        itemsMap.put(UUIDGenerator.uuidGenerator(), items);
    }
    public List<Items> viewItems(){
        return new ArrayList<>(itemsMap.values());
    }
}
