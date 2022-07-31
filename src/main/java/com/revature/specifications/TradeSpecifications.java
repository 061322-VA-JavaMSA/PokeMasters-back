package com.revature.specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.revature.models.Status;
import com.revature.models.Trade;
import com.revature.models.Trainer;

public class TradeSpecifications {

	public static Specification<Trade> ownedBy(Trainer t) {
		return new Specification<Trade>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Trade> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.get("owner"), t);
			}
		};
	}
	
	public static Specification<Trade> notOwnedBy(Trainer t) {
		return new Specification<Trade>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Trade> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.notEqual(root.get("owner"), t);
			}
		};
	}
	
	public static Specification<Trade> notCompleted() {
		return new Specification<Trade>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Trade> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.notEqual(root.get("status"), Status.COMPLETED);
			}
		};
	}
	
	public static Specification<Trade> isPending() {
		return new Specification<Trade>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Trade> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.get("status"), Status.PENDING);
			}
		};
	}
}
