package com.revature.repos;

import com.revature.models.Item;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    Item findItemById(int id);

    @Query(value = "SELECT * FROM items i WHERE i.user_id = ?1", nativeQuery = true)
    List<Item> findUserItems(Integer id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM items i WHERE i.id = ?1", nativeQuery = true)
    Integer deleteItemById(Integer id);

}
