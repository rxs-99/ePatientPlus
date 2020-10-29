package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.service.MonsterCardService;

public class Driver {
	
	public static void main(String... args) {
		
		/*
		 * We've defined beans in our IOC container. Now let's request one of those
		 * beans.
		 * 
		 * We'll use our ApplicationContext to do so. There are several different 
		 * implementations of our ApplicationContext:
		 * 
		 * ClassPathXmlApplicationContext
		 * AnnotationConfigApplicationContext
		 * FileSystemXmlAppklicationContext
		 * XmlWebApplicationContext
		 */
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		MonsterCardService msc = ctx.getBean("monsterCardService3", MonsterCardService.class);
		System.out.println(msc.findAllMonsterCards());
	}
}
