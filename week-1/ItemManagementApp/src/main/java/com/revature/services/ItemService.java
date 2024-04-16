package com.revature.services;

import com.revature.models.Item;
import com.revature.repos.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Item updateItem(Integer id, Item updatedItem) {
        Optional<Item> itemOptional = itemRepository.findById(id);
        if (itemOptional.isPresent()) {
            // Update the item's properties
            Item item = itemOptional.get();
            item.setItemName(updatedItem.getItemName());
            item.setDescription(updatedItem.getDescription());
            item.setPrice(updatedItem.getPrice());
            item.setQuantity(updatedItem.getQuantity());
            // Save the updated item
            return itemRepository.save(item);
        }
        return null;
    }

    public Item createItem(Item item){
        return  itemRepository.save(item);
    }
}