package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Move;

public interface MoveRepository extends JpaRepository<Move, Integer> {

}
