package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

	// Any custom declarations
}
