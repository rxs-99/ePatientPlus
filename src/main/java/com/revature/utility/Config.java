package com.revature.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.revature.repository.MonsterCardRepository;
import com.revature.repository.MonsterCardRepositoryImpl;
import com.revature.service.MonsterCardService;

/*
 * The Configuration annotation denotes that this class contains methods which are annotated
 * with @Bean and return beans that are then placed into our IOC container.
 */
@Configuration
public class Config {

	@Bean(value = "monsterCardService3")
	@Scope(scopeName = "")
	public MonsterCardService getMonsterCardService() {
		return new MonsterCardService();
	}
	
	@Bean(value = "monsterCardRepository3")
	public MonsterCardRepository getMonsterCardRepository() {
		return new MonsterCardRepositoryImpl();
	}
}
