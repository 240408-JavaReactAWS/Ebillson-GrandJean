package com.revature.ItemManagementApp.repos;

import com.revature.ItemManagementApp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {

}
