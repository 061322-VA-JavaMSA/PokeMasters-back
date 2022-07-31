package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.revature.models.Trade;
import com.revature.models.Trainer;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Integer>, JpaSpecificationExecutor<Trade>{

	List<Trade> findByOwner(Trainer owner);
}
