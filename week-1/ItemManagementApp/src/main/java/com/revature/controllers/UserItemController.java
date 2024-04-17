package com.revature.controllers;

import com.revature.models.Item;
import com.revature.models.User;
import com.revature.repos.UserRepository;
import com.revature.services.ItemService;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserItemController {
    private UserService userService;
    private ItemService itemService;

    @Autowired
    public UserItemController(UserService userService, ItemService itemService){
        this.userService = userService;
        this.itemService = itemService;
    }

    // 3- As a user, I can create a new Item
    @PostMapping("{id}/items")
    public ResponseEntity<Item> createItem(@RequestBody Item item, @PathVariable Integer id){
        User findUser = userService.findUserById(id);

        if(findUser != null){
            item.setUserId(findUser.getId());
            boolean isItemNameBlank = item.getItemName().isBlank();
            int itemNameLength = item.getItemName().length();
            if(!isItemNameBlank && itemNameLength >= 4){
                Item itemToCreate = itemService.createItem(item);
                return new ResponseEntity<>(itemToCreate, HttpStatus.OK);
            }
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    //  5- As a user, I can view the Items associated with my account
    @GetMapping("{id}/items")
    public ResponseEntity<List<Item>> getAllUserItems(@PathVariable Integer id){
        User findUser = userService.findUserById(id);
        if(findUser != null){
            List<Item>  userItems = itemService.getAllUserItems(id);
            return new ResponseEntity<>(userItems, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
