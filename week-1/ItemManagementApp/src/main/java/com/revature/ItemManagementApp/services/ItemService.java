package com.revature.ItemManagementApp.services;

import com.revature.ItemManagementApp.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.ItemManagementApp.repos.ItemRepository;

import java.util.Optional;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    //Dependency injection
    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    //Methods that will be called on by controller layer which will talk to the dao layer

    //As a user, I can view a singular Item by its ID (HINT: Use Path Params to select a Item by its ID)
    public Item findItemById(int id) {
//        Optional<Item> itemOptional = itemDao.findById(id);
//        if (itemOptional.isPresent()){
//           return itemOptional.get();
//        }
//        return null;
        return itemRepository.findItemById(id);
    }

    public Integer updateItem(Integer itemId,String itemDescription) {
        Optional<Item> itemOptional = itemRepository.findById(itemId);
        if (itemOptional.isPresent()) {
            // Update the item's properties
            Item item = itemOptional.get();
            if(itemDescription != null){
                item.setDescription(itemDescription);
                itemRepository.save(item);
            }
            return 1;
        }
        return 0;
    }
}