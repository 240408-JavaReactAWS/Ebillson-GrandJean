package com.revature.ItemManagementApp.repos;

import com.revature.ItemManagementApp.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDAO extends JpaRepository<Item, Integer> {
    Item findItemById(int id);
}
