package com.revature.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.MonsterCard;
import com.revature.repository.MonsterCardRepository;
import com.revature.repository.MonsterCardRepositoryImpl;

/*
 * Service is also a Spring stereotype that we use to mark a class as a candidate for
 * auto detection so that Spring may add a bean of this type to our IOC container.
 */
@Service("monsterCardService2")
public class MonsterCardService {

	private MonsterCardRepository monsterCardRepository2;
	
//	public MonsterCardService(MonsterCardRepositoryImpl monsterCardRepository) {
//		this.monsterCardRepository = monsterCardRepository;
//	}
	
	//Spring assumes by default that you are using setter injection!
	@Autowired
	public void setMonsterCardRepository(MonsterCardRepositoryImpl monsterCardRepository2) {
		this.monsterCardRepository2 = monsterCardRepository2;
	}
	
	public List<MonsterCard> findAllMonsterCards(){
		//In this case, we aren't performing business logic, though we could, and this
		//would be the appropriate place to handle it.
		return this.monsterCardRepository2.findAllMonsterCards();
	}
	
	/*
	 * This method sorts the cards based on the comparator passed in. This logic
	 * is not directly related to data access; it is about transforming the data in
	 * some way for business purposes (e.g. maybe the user interface allows users to
	 * filter and sort the cards per the application requirements).
	 */
	public List<MonsterCard> findAllMonsterCardsSorted(Comparator<MonsterCard> c){
		List<MonsterCard> cards = this.monsterCardRepository2.findAllMonsterCards();
		Collections.sort(cards, c);
		return cards;
	}
	
	public void update(MonsterCard monsterCard) {
		this.monsterCardRepository2.update(monsterCard);
	}
	
	public void insert(MonsterCard monsterCard) {
		this.monsterCardRepository2.insert(monsterCard);
	}
	
	public MonsterCard findByName(String name) {
		return this.monsterCardRepository2.findMonsterCardByName(name);
	}
	
}
