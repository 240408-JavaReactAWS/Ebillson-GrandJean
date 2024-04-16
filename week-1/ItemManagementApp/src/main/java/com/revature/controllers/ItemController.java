package com.revature.controllers;

import com.revature.models.Item;
import com.revature.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.revature.services.ItemService;


@RestController
@RequestMapping("/items")
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Item> findItemById(@PathVariable int id) {
        Item item = itemService.findItemById(id);
        if (item != null)return new ResponseEntity<>(item, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PatchMapping("{id}")
    public ResponseEntity<Object> updateItemById(@PathVariable Integer id, @RequestBody Item itemDescription){
        int rowsUpdated = itemService.updateItem(id, itemDescription.getDescription());
        if (rowsUpdated ==1){
            return ResponseEntity.ok(rowsUpdated);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
