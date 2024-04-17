package com.revature.controllers;

import com.revature.models.Item;
import com.revature.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/items")
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    // 6- As a user, I can view a singular Item by its ID
    // (HINT: Use Path Params to select a Item by its ID)
    @GetMapping("{id}")
    public ResponseEntity<Item> findItemById(@PathVariable int id) {
        Item item = itemService.findItemById(id);
        if (item != null)return new ResponseEntity<>(item, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //  7- As a user, I can update a Item (Change the name or other properties)
    @PatchMapping("{id}")
    public ResponseEntity<Item> updateItemById(@PathVariable Integer id, @RequestBody Item updatedItem) {
        Item savedItem = itemService.updateItem(id, updatedItem);
        if (savedItem != null) {
            return ResponseEntity.ok(savedItem);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 4- As a user, I can view all Items
    @GetMapping
    public  ResponseEntity<List<Item>> getAllItems(){
        List<Item> items = itemService.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    //    8- As a user, I can delete a Item by its ID
    //    (HINT: Use Path Params to select a Item by its ID)
    @DeleteMapping("{id}")
    public ResponseEntity<Integer> deleteItemById(@PathVariable Integer id){
        Integer deletedItemCount = itemService.deleteItemById(id);
        if(deletedItemCount == 0) return new ResponseEntity<>(deletedItemCount, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(deletedItemCount, HttpStatus.OK);
    }

}
