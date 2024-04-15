package com.revature.ItemManagementApp.services;

import com.revature.ItemManagementApp.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.revature.ItemManagementApp.repos.ItemDAO;

import java.util.Optional;

@Service
public class ItemService {

    private ItemDAO itemDao;

    //Dependency injection
    @Autowired
    public ItemService(ItemDAO itemDAO) {
        this.itemDao = itemDAO;
    }

    //Methods that will be called on by controller layer which will talk to the dao layer

    //As a user, I can view a singular Item by its ID (HINT: Use Path Params to select a Item by its ID)
    public Item findItemById(int id) {
//        Optional<Item> itemOptional = itemDao.findById(id);
//        if (itemOptional.isPresent()){
//           return itemOptional.get();
//        }
//        return null;
        return itemDao.findItemById(id);
    }

    public Integer updateItem(Integer itemId,String itemDescription) {
        Optional<Item> itemOptional = itemDao.findById(itemId);
        if (itemOptional.isPresent()) {
            // Update the item's properties
            Item item = itemOptional.get();
            if(itemDescription != null){
                item.setDescription(itemDescription);
                itemDao.save(item);
            }
            return 1;
        }
        return 0;
    }
}