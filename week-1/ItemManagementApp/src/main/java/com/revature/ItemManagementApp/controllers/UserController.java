package com.revature.ItemManagementApp.controllers;

import com.revature.ItemManagementApp.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.revature.ItemManagementApp.services.ItemService;


@RestController
@RequestMapping("/items")
public class UserController {

    private ItemService itemService;

    @Autowired
    public UserController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Item> findItemById(@PathVariable int id) {
        Item item = itemService.findItemById(id);
        if (item != null)return new ResponseEntity<>(item, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    @PatchMapping("{id}")
//    public ResponseEntity<Object> updateItemById(@PathVariable Integer itemId, @RequestBody){
//
//    }

}
