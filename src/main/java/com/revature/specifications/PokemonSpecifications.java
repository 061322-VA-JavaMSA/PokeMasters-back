package com.revature.specifications;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.revature.models.Pokemon;

public class PokemonSpecifications {

	public static Specification<Pokemon> meetsLevelRequirements(int level, int range) {
		return new Specification<Pokemon>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Pokemon> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.between(root.get("level"), level - range, level + range);
			}
		};
	}
	
	public static Specification<Pokemon> matchesApiId(int apiId) {
		return new Specification<Pokemon>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Predicate toPredicate(Root<Pokemon> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				return cb.equal(root.get("apiId"), apiId);
			}
		};
	}
}
