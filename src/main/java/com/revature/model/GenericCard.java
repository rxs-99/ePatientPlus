package com.revature.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/*
 * The @MappedSuperclass annotation denotes that classes which inherit from
 * this class will inherit its mappings. Note that a table for this class
 * will NOT be created.
 */
@MappedSuperclass
public abstract class GenericCard {

	@Column
	protected String name;
	/**
	 * This field tells us whether or not a card is face up or down.
	 */
	@Column
	protected boolean faceUp;
	//This refers to how hard the card is to use from a user's perspective.
	@Column
	protected int difficultyLevel;
	
	
	public abstract void printDifficultyManual();
	
}
