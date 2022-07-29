package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.keys.TrainerItemsKey;
import com.revature.models.TrainerItem;

public interface TrainerItemRepository extends JpaRepository<TrainerItem, TrainerItemsKey>{

}
