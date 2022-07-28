package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Box;

@Repository
public interface BoxRepository extends JpaRepository<Box, Integer>{

}
