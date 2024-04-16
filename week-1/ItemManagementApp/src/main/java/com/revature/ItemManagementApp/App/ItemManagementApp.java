package com.revature.ItemManagementApp.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.revature.ItemManagementApp") //We want to scan the com.revature package for spring Beans
@EntityScan("com.revature.ItemManagementApp.models") //We want to scan the models package for Database entities
@EnableJpaRepositories("com.revature.ItemManagementApp.repos") //allows all dao to be a JpaRepository
public class ItemManagementApp {

	public static void main(String[] args) {
		SpringApplication.run(ItemManagementApp.class, args);
	}

}
