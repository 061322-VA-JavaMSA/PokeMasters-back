package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Trade;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Integer>{

}
