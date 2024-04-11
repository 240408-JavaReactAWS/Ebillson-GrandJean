package services;

import models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repos.ItemDAO;

import java.util.Optional;

@Service
public class ItemService {

    private ItemDAO itemDao;

    //Dependency injection
    @Autowired
    public ItemService(ItemDAO itemDAO){
        this.itemDao= itemDAO;
    }

    //Methods that will be called on by controller layer which will talk to the dao layer

    //As a user, I can view a singular Item by its ID (HINT: Use Path Params to select a Item by its ID)
    public Item findItemById(int id){
//        Optional<Item> itemOptional = itemDao.findById(id);
//        if (itemOptional.isPresent()){
//           return itemOptional.get();
//        }
//        return null;
        return itemDao.findItemById(id);
    }
}
