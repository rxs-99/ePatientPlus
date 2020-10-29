package com.revature.repository;

import java.util.List;

import com.revature.model.MonsterCard;

/*
 *
 */
public interface MonsterCardRepository {

	/*
	 * Let's define some methods that all implementations of this repository should
	 * implement.
	 * 
	 * These methods are typically your basic CRUD methods: 
	 */
	
	void insert(MonsterCard monsterCard); //CREATE
	List<MonsterCard> findAllMonsterCards(); //READ
	void update(MonsterCard monsterCard); //UPDATE
	void delete(MonsterCard monsterCard); //DELETE
	MonsterCard findMonsterCardByName(String name);
}
