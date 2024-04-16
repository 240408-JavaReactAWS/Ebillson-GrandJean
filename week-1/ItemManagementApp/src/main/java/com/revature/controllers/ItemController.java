package com.revature.controllers;

import com.revature.models.Item;
import com.revature.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
    public ResponseEntity<Item> updateItemById(@PathVariable Integer id, @RequestBody Item updatedItem) {
        Item existingItem = itemService.findItemById(id);
        if (existingItem != null) {
            // Update all properties of the existing item with the updated values
            existingItem.setItemName(updatedItem.getItemName());
            existingItem.setDescription(updatedItem.getDescription());
            existingItem.setPrice(updatedItem.getPrice());
            existingItem.setQuantity(updatedItem.getQuantity());

            // Save the updated item
            Item savedItem = itemService.updateItem(existingItem);
            if (savedItem != null) {
                return ResponseEntity.ok(savedItem);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
