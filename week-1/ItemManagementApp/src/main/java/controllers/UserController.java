package controllers;

import models.Item;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import services.ItemService;

@RestController
public class UserController {

    private ItemService itemService;

    public UserController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<Item> findItemById(@PathVariable int id) {
        Item item = itemService.findItemById(id);
        if (item != null)return new ResponseEntity<>(item, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
